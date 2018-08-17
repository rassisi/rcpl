package org.eclipse.rcpl;

import java.io.File;
import java.util.HashMap;

public interface IDocumentProvider {

	IDocument createTemplateDocument(String fileName, HashMap<String, String> wordReplacements, boolean onePage,
			ITaskViewProvider taskViewProvider);

	void createTemplateDocument(String fileName, File file, ITaskViewProvider taskViewProvider);

	String createHtmlDocument(String fileName, HashMap<String, String> wordReplacements);

}
