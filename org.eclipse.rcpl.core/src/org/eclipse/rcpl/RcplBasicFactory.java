/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/
package org.eclipse.rcpl;

import java.io.File;
import java.util.HashMap;

import org.eclipse.rcpl.app.toolcontrols.RcplSideToolBar;
import org.eclipse.rcpl.app.toolcontrols.RcplTopToolBar;
import org.eclipse.rcpl.homepages.DefaultAboutHomePage;
import org.eclipse.rcpl.homepages.DefaultContactUsHomePage;
import org.eclipse.rcpl.homepages.DefaultDocumentHomePage;
import org.eclipse.rcpl.homepages.DefaultHTMLEditorHomePage;
import org.eclipse.rcpl.homepages.DefaultHomePage;
import org.eclipse.rcpl.homepages.DefaultNewHomePage;
import org.eclipse.rcpl.homepages.DefaultOverviewHomePage;
import org.eclipse.rcpl.homepages.DefaultPerspectiveHomePage;
import org.eclipse.rcpl.homepages.DefaultPreferencesHomePage;
import org.eclipse.rcpl.homepages.DefaultSamplesHomePage;
import org.eclipse.rcpl.homepages.DefaultTemplatesHomePage;
import org.eclipse.rcpl.homepages.DefaultTutorialsHomePage;
import org.eclipse.rcpl.homepages.DefaultWhatsNewHomePage;
import org.eclipse.rcpl.internal.fx.figures.JOButton;
import org.eclipse.rcpl.internal.impl.RcplToolFactory;
import org.eclipse.rcpl.internal.resources.JOColorProvider;
import org.eclipse.rcpl.internal.resources.JOResources;
import org.eclipse.rcpl.internal.services.RcplService;
import org.eclipse.rcpl.internal.tools.JORibbonGroup;
import org.eclipse.rcpl.internal.tools.UndoRedoTool;
import org.eclipse.rcpl.model.IResources;
import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.SideToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar;
import org.eclipse.rcpl.ui.action.RcplCommand;
import org.eclipse.rcpl.ui.font.RcplFontProvider;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 * 
 */
public class RcplBasicFactory implements IRcplFactory {

	@Override
	public IButton createButton(String id, String name, String toolTip, String imageName, boolean toggle,
			IButtonListener buttonListener, boolean systemButton) {
		IButton b = new JOButton(id, name, toolTip, imageName, toggle);
		b.setButtonListener(buttonListener);
		if (systemButton) {
			b.setSystemButton();
		}
		return b;
	}

	public final static int NO_TOOLBAR = 1;

	public final static int NO_STATUSBAR = 1 << 1;

	public final static int NO_TABS = 1 << 2;

	public final static int ECLIPSE = 1 << 3;

	public final static int ONLY_BROWSER = 1 << 4;

	public final static int ONLY_OFFICE = 1 << 5;

	public final static int NO_STARTBUTTON = 1 << 6;

	public final static int NO_QUICKTOOLS = 1 << 7;

	public final static int NO_DOWNLOADS = 1 << 8;

	public final static int NO_UPDATES = 1 << 9;

	public final static int NO_MAINPAGE = 1 << 10;

	@Override
	public IUndoRedoListener createUndoRedoTool() {
		return new UndoRedoTool();
	}

	@Override
	public ICommand createCommand(IEditor editor, EnCommandId commandId, ILayoutObject layoutObject, Object[] oldData,
			Object... newData) {
		return new RcplCommand(editor, commandId, layoutObject, null, oldData, newData);
	}

	@Override
	public ICommand createCommand(IEditor editor, ITool tool) {
		ILayoutObject l = null;
		if (editor != null) {
			l = editor.getSelectedLayoutObject();
		}
		return createCommand(editor, tool, l, new Object[0], new Object[0]);
	}

	@Override
	public ICommand createCommand(IEditor editor, ITool tool, ILayoutObject layoutObject, Object[] oldData,
			Object... newData) {

		try {
			String sId = tool.getTool().getService();
			EnServiceId serviceId = EnServiceId.DEFAULT_SERVICE;

			if (sId != null) {
				serviceId = EnServiceId.valueOf(sId);
			}
			if (serviceId == null) {
				serviceId = EnServiceId.DEFAULT_SERVICE;
			}
			EnCommandId commandId = null;

			switch (tool.getTool().getType()) {
			case TOGGLEBUTTON:
				JOButton b = (JOButton) tool.getTool().getData();
				newData = new Object[] { b.isSelected() };
				oldData = new Object[] { !b.isSelected() };
				break;
			case WEBVIEW:
				break;
			default:
				break;
			}

			String id = tool.getTool().getId();

			commandId = EnCommandId.findCommandId(id);

			return new RcplCommand(editor, commandId, layoutObject, tool, oldData, newData);
		} catch (Exception ex) {
			RCPLModel.logError(ex);
			return null;
		}
	}

	@Override
	public Node createRibbonGroup(ToolGroup group, IRcplAddon useCase, boolean first, boolean dialogButton) {
		return new JORibbonGroup(group, first, dialogButton).get();
	}

	@Override
	public ISideToolBar createSideToolBar(HBox parent) {
		return new RcplSideToolBar(parent);
	}

	@Override
	public ITopToolbar createTopToolBar(StackPane stackPane) {
		return new RcplTopToolBar(stackPane);
	}

	@Override
	public Perspective createPerspective(String id, String name, String image) {
		Perspective perspective = RcplFactory.eINSTANCE.createPerspective();
		perspective.setId(id);
		perspective.setName(name);
		perspective.setImage(image);
		SideToolBar st = RcplFactory.eINSTANCE.createSideToolBar();
		TopToolBar tt = RcplFactory.eINSTANCE.createTopToolBar();
		perspective.setSideToolBar(st);
		perspective.setTopToolBar(tt);
		getJOffice().getAllPerspectives().getChildren().add(perspective);
		return perspective;
	}

	private RCPL getJOffice() {
		return RcplSession.getDefault().getRcpl();
	}

	@Override
	public IButton createButton(ToolGroup g, boolean toggle, boolean systemButton, IButtonListener buttonListener) {
		return createButton(g.getId(), g.getName(), g.getToolTip(), g.getImage(), toggle, buttonListener, systemButton);
	}

	@Override
	public IResources createResources() {
		return new JOResources();
	}

	@Override
	public IColorProvider createColorProvider() {
		return new JOColorProvider();
	}

	@Override
	public IFontProvider createFontProvider() {
		return new RcplFontProvider();
	}

	@Override
	public IService createService() {
		return new RcplService();
	}

	@Override
	public IToolFactory createOfficeToolFactory() {
		return new RcplToolFactory();
	}

	@Override
	public IEditor createEditor(File file, Tab tab, HashMap<String, String> wordReplacements, boolean onePage) {
		return null;
	}

	@Override
	public IEditor createEditor(Tab tab, boolean isBrowser) {
		return null;
	}

	@Override
	public IStyleTemplate createStyleTemplate() {
		return null;
	}

	@Override
	public IHomePage createHomePage(IRcplUic uic, HomePage modelHomePage) {

		switch (modelHomePage.getType()) {
		case ABOUT:
			return new DefaultAboutHomePage(uic, modelHomePage, null);
		case CONTACT_US:
			return new DefaultContactUsHomePage(uic, modelHomePage, null);
		case DOCUMENT:
			return new DefaultDocumentHomePage(uic, modelHomePage, null);
//		case DONAT:
//			return new DefaultDonationsHomePage(uic, modelHomePage, null);
		case HTML_EDITOR:
			return new DefaultHTMLEditorHomePage(uic, modelHomePage, null);
		case NEWS:
			return new DefaultNewHomePage(uic, modelHomePage, null);
		case OVERVIEW:
			return new DefaultOverviewHomePage(uic, modelHomePage, null);
		case PERSPECTIVES:
			return new DefaultPerspectiveHomePage(uic, modelHomePage, null);
		case PREFERENCES:
			return new DefaultPreferencesHomePage(uic, modelHomePage, null);
		case SAMPLES:
			return new DefaultSamplesHomePage(uic, modelHomePage, null);
		case TEMPLATES:
			return new DefaultTemplatesHomePage(uic, modelHomePage, null);
		case TUTORIALS:
			return new DefaultTutorialsHomePage(uic, modelHomePage, null);
		case WHATS_NEW:
			return new DefaultWhatsNewHomePage(uic, modelHomePage, null); // TODO
		default:
			return new DefaultHomePage(uic, modelHomePage, null);

		}
	}

}
