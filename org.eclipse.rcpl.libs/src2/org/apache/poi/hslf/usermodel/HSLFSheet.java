/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.hslf.usermodel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherDggRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hslf.record.CString;
import org.apache.poi.hslf.record.ColorSchemeAtom;
import org.apache.poi.hslf.record.OEPlaceholderAtom;
import org.apache.poi.hslf.record.PPDrawing;
import org.apache.poi.hslf.record.RecordContainer;
import org.apache.poi.hslf.record.RecordTypes;
import org.apache.poi.hslf.record.RoundTripHFPlaceholder12;
import org.apache.poi.hslf.record.SheetContainer;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.draw.Drawable;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.sl.usermodel.Sheet;

/**
 * This class defines the common format of "Sheets" in a powerpoint
 * document. Such sheets could be Slides, Notes, Master etc
 *
 * @author Nick Burch
 * @author Yegor Kozlov
 */

public abstract class HSLFSheet implements HSLFShapeContainer, Sheet<HSLFShape,HSLFTextParagraph> {
    /**
     * The <code>SlideShow</code> we belong to
     */
    private HSLFSlideShow _slideShow;

    /**
     * Sheet background
     */
    private HSLFBackground _background;

    /**
     * Record container that holds sheet data.
     * For slides it is org.apache.poi.hslf.record.Slide,
     * for notes it is org.apache.poi.hslf.record.Notes,
     * for slide masters it is org.apache.poi.hslf.record.SlideMaster, etc.
     */
    private SheetContainer _container;

    private int _sheetNo;

    public HSLFSheet(SheetContainer container, int sheetNo) {
        _container = container;
        _sheetNo = sheetNo;
    }

    /**
     * Returns an array of all the TextRuns in the sheet.
     */
    public abstract List<List<HSLFTextParagraph>> getTextParagraphs();

    /**
     * Returns the (internal, RefID based) sheet number, as used
     * to in PersistPtr stuff.
     */
    public int _getSheetRefId() {
        return _container.getSheetId();
    }

    /**
     * Returns the (internal, SlideIdentifier based) sheet number, as used
     * to reference this sheet from other records.
     */
    public int _getSheetNumber() {
        return _sheetNo;
    }

    /**
     * Fetch the PPDrawing from the underlying record
     */
    public PPDrawing getPPDrawing() {
        return _container.getPPDrawing();
    }

    /**
     * Fetch the SlideShow we're attached to
     */
    public HSLFSlideShow getSlideShow() {
        return _slideShow;
    }

    /**
     * Return record container for this sheet
     */
    public SheetContainer getSheetContainer() {
        return _container;
    }

    /**
     * Set the SlideShow we're attached to.
     * Also passes it on to our child RichTextRuns
     */
    public void setSlideShow(HSLFSlideShow ss) {
        _slideShow = ss;
        List<List<HSLFTextParagraph>> trs = getTextParagraphs();
        if (trs == null) return;
        for (List<HSLFTextParagraph> ltp : trs) {
            for (HSLFTextParagraph tp : ltp) {
                tp.supplySheet(this);
            }
        }
    }


    /**
     * Returns all shapes contained in this Sheet
     *
     * @return all shapes contained in this Sheet (Slide or Notes)
     */
    @Override
    public List<HSLFShape> getShapes() {
        PPDrawing ppdrawing = getPPDrawing();

        EscherContainerRecord dg = (EscherContainerRecord) ppdrawing.getEscherRecords()[0];
        EscherContainerRecord spgr = null;

        for (Iterator<EscherRecord> it = dg.getChildIterator(); it.hasNext();) {
            EscherRecord rec = it.next();
            if (rec.getRecordId() == EscherContainerRecord.SPGR_CONTAINER) {
                spgr = (EscherContainerRecord) rec;
                break;
            }
        }
        if (spgr == null) {
            throw new IllegalStateException("spgr not found");
        }

        List<HSLFShape> shapeList = new ArrayList<HSLFShape>();
        Iterator<EscherRecord> it = spgr.getChildIterator();
        if (it.hasNext()) {
            // skip first item
            it.next();
        }
        for (; it.hasNext();) {
            EscherContainerRecord sp = (EscherContainerRecord) it.next();
            HSLFShape sh = HSLFShapeFactory.createShape(sp, null);
            sh.setSheet(this);
            shapeList.add(sh);
        }

        return shapeList;
    }

    /**
     * Add a new Shape to this Slide
     *
     * @param shape - the Shape to add
     */
    public void addShape(HSLFShape shape) {
        PPDrawing ppdrawing = getPPDrawing();

        EscherContainerRecord dgContainer = (EscherContainerRecord) ppdrawing.getEscherRecords()[0];
        EscherContainerRecord spgr = (EscherContainerRecord) HSLFShape.getEscherChild(dgContainer, EscherContainerRecord.SPGR_CONTAINER);
        spgr.addChildRecord(shape.getSpContainer());

        shape.setSheet(this);
        shape.setShapeId(allocateShapeId());
        shape.afterInsert(this);
    }

    /**
     * Allocates new shape id for the new drawing group id.
     *
     * @return a new shape id.
     */
    public int allocateShapeId()
    {
        EscherDggRecord dgg = _slideShow.getDocumentRecord().getPPDrawingGroup().getEscherDggRecord();
        EscherDgRecord dg = _container.getPPDrawing().getEscherDgRecord();

        dgg.setNumShapesSaved( dgg.getNumShapesSaved() + 1 );

        // Add to existing cluster if space available
        for (int i = 0; i < dgg.getFileIdClusters().length; i++)
        {
            EscherDggRecord.FileIdCluster c = dgg.getFileIdClusters()[i];
            if (c.getDrawingGroupId() == dg.getDrawingGroupId() && c.getNumShapeIdsUsed() != 1024)
            {
                int result = c.getNumShapeIdsUsed() + (1024 * (i+1));
                c.incrementShapeId();
                dg.setNumShapes( dg.getNumShapes() + 1 );
                dg.setLastMSOSPID( result );
                if (result >= dgg.getShapeIdMax())
                    dgg.setShapeIdMax( result + 1 );
                return result;
            }
        }

        // Create new cluster
        dgg.addCluster( dg.getDrawingGroupId(), 0, false );
        dgg.getFileIdClusters()[dgg.getFileIdClusters().length-1].incrementShapeId();
        dg.setNumShapes( dg.getNumShapes() + 1 );
        int result = (1024 * dgg.getFileIdClusters().length);
        dg.setLastMSOSPID( result );
        if (result >= dgg.getShapeIdMax())
            dgg.setShapeIdMax( result + 1 );
        return result;
    }

    /**
     * Removes the specified shape from this sheet.
     *
     * @param shape shape to be removed from this sheet, if present.
     * @return <tt>true</tt> if the shape was deleted.
     */
    public boolean removeShape(HSLFShape shape) {
        PPDrawing ppdrawing = getPPDrawing();

        EscherContainerRecord dg = (EscherContainerRecord) ppdrawing.getEscherRecords()[0];
        EscherContainerRecord spgr = null;

        for (Iterator<EscherRecord> it = dg.getChildIterator(); it.hasNext();) {
            EscherRecord rec = it.next();
            if (rec.getRecordId() == EscherContainerRecord.SPGR_CONTAINER) {
                spgr = (EscherContainerRecord) rec;
                break;
            }
        }
        if(spgr == null) {
            return false;
        }

        List<EscherRecord> lst = spgr.getChildRecords();
        boolean result = lst.remove(shape.getSpContainer());
        spgr.setChildRecords(lst);
        return result;
    }

    /**
     * Called by SlideShow ater a new sheet is created
     */
    public void onCreate(){

    }

    /**
     * Return the master sheet .
     */
    public abstract HSLFMasterSheet getMasterSheet();

    /**
     * Color scheme for this sheet.
     */
    public ColorSchemeAtom getColorScheme() {
        return _container.getColorScheme();
    }

    /**
     * Returns the background shape for this sheet.
     *
     * @return the background shape for this sheet.
     */
    public HSLFBackground getBackground() {
        if (_background == null) {
            PPDrawing ppdrawing = getPPDrawing();

            EscherContainerRecord dg = (EscherContainerRecord) ppdrawing.getEscherRecords()[0];
            EscherContainerRecord spContainer = dg.getChildById(EscherContainerRecord.SP_CONTAINER);
            _background = new HSLFBackground(spContainer, null);
            _background.setSheet(this);
        }
        return _background;
    }

    @Override
    public void draw(Graphics2D graphics) {
        DrawFactory drawFact = DrawFactory.getInstance(graphics);
        Drawable draw = drawFact.getDrawable(this);
        draw.draw(graphics);
    }

    /**
     * Subclasses should call this method and update the array of text runs
     * when a text shape is added
     *
     * @param shape
     */
    protected void onAddTextShape(HSLFTextShape shape) {
    }

    /**
     * Return placeholder by text type
     *
     * @param type  type of text, See {@link org.apache.poi.hslf.record.TextHeaderAtom}
     * @return  <code>TextShape</code> or <code>null</code>
     */
    public HSLFTextShape getPlaceholderByTextType(int type){
        for (HSLFShape shape : getShapes()) {
            if(shape instanceof HSLFTextShape){
                HSLFTextShape tx = (HSLFTextShape)shape;
                if (tx != null && tx.getRunType() == type) {
                    return tx;
                }
            }
        }
        return null;
    }

    /**
     * Search text placeholer by its type
     *
     * @param type  type of placeholder to search. See {@link org.apache.poi.hslf.record.OEPlaceholderAtom}
     * @return  <code>TextShape</code> or <code>null</code>
     */
    public HSLFTextShape getPlaceholder(int type){
        for (HSLFShape shape : getShapes()) {
            if(shape instanceof HSLFTextShape){
                HSLFTextShape tx = (HSLFTextShape)shape;
                int placeholderId = 0;
                OEPlaceholderAtom oep = tx.getPlaceholderAtom();
                if(oep != null) {
                    placeholderId = oep.getPlaceholderId();
                } else {
                    //special case for files saved in Office 2007
                    RoundTripHFPlaceholder12 hldr = tx.getClientDataRecord(RecordTypes.RoundTripHFPlaceholder12.typeID);
                    if(hldr != null) placeholderId = hldr.getPlaceholderId();
                }
                if(placeholderId == type){
                    return tx;
                }
            }
        }
        return null;
    }

    /**
     * Return programmable tag associated with this sheet, e.g. <code>___PPT12</code>.
     *
     * @return programmable tag associated with this sheet.
     */
    public String getProgrammableTag(){
        String tag = null;
        RecordContainer progTags = (RecordContainer)
                getSheetContainer().findFirstOfType(
                            RecordTypes.ProgTags.typeID
        );
        if(progTags != null) {
            RecordContainer progBinaryTag = (RecordContainer)
                progTags.findFirstOfType(
                        RecordTypes.ProgBinaryTag.typeID
            );
            if(progBinaryTag != null) {
                CString binaryTag = (CString)
                    progBinaryTag.findFirstOfType(
                            RecordTypes.CString.typeID
                );
                if(binaryTag != null) tag = binaryTag.getText();
            }
        }

        return tag;

    }

    public Iterator<HSLFShape> iterator() {
        return getShapes().iterator();
    }


    /**
     * @return whether shapes on the master sheet should be shown. By default master graphics is turned off.
     * Sheets that support the notion of master (slide, slideLayout) should override it and
     * check this setting
     */
    public boolean getFollowMasterGraphics() {
        return false;
    }


    @Override
    public HSLFTextBox createTextBox() {
        HSLFTextBox s = new HSLFTextBox();
        s.setHorizontalCentered(true);
        s.setAnchor(new Rectangle(0, 0, 100, 100));
        addShape(s);
        return s;
    }

    @Override
    public HSLFAutoShape createAutoShape() {
        HSLFAutoShape s = new HSLFAutoShape(ShapeType.RECT);
        s.setHorizontalCentered(true);
        s.setAnchor(new Rectangle(0, 0, 100, 100));
        addShape(s);
        return s;
    }

    @Override
    public HSLFFreeformShape createFreeform() {
        HSLFFreeformShape s = new HSLFFreeformShape();
        s.setHorizontalCentered(true);
        s.setAnchor(new Rectangle(0, 0, 100, 100));
        addShape(s);
        return s;
    }

    @Override
    public HSLFConnectorShape createConnector() {
        HSLFConnectorShape s = new HSLFConnectorShape();
        s.setAnchor(new Rectangle(0, 0, 100, 100));
        addShape(s);
        return s;
    }

    @Override
    public HSLFGroupShape createGroup() {
        HSLFGroupShape s = new HSLFGroupShape();
        s.setAnchor(new Rectangle(0, 0, 100, 100));
        addShape(s);
        return s;
    }

    @Override
    public HSLFPictureShape createPicture(PictureData pictureData) {
        if (!(pictureData instanceof HSLFPictureData)) {
            throw new IllegalArgumentException("pictureData needs to be of type HSLFPictureData");
        }
        HSLFPictureShape s = new HSLFPictureShape((HSLFPictureData)pictureData);
        s.setAnchor(new Rectangle(0, 0, 100, 100));
        addShape(s);
        return s;
    }

    @Override
    public HSLFTable createTable(int numRows, int numCols) {
        if (numRows < 1 || numCols < 1) {
            throw new IllegalArgumentException("numRows and numCols must be greater than 0");
        }
        HSLFTable s = new HSLFTable(numRows,numCols);
        s.setAnchor(new Rectangle(0, 0, 100, 100));
        addShape(s);
        return s;
    }
}
