package org.eclipse.rcpl;

import java.io.File;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlObject;
import org.eclipse.rcpl.internal.tools.IStyle;

/**
 * @author Ramin
 *
 */
public interface IStyleTemplate {

	IStyle findStyleByName(String id);

	XmlObject getTemplateXml(String id);

	String getName();

	void setName(String name);

	void loadTemplateDocument(XWPFDocument xml);

	void loadTemplateDocument(File file);

	List<IStyle> getStyles();

	IStyle getParagraphStyleById(String additionalData);

	IStyle findStyle(String name);

	IStyle createClonedStyle(IStyle paragraphStyle);

}
