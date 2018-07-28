package org.eclipse.rcpl.model;

import java.util.List;

import org.eclipse.emf.cdo.security.Group;
import org.eclipse.emf.cdo.security.User;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcpl.model.client.IModelFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Folder;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.Resource;
import org.eclipse.rcpl.model_2_0_0.rcpl.SideToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar;

public class RcplModelUtil {
	ISession session;

	public RcplModelUtil(ISession session) {
		this.session = session;
	}

	public void addDocument(RCPL joffice, Resource eNewDocument) {
		findMyDocumentsFolder(joffice).getResources().add(eNewDocument);
		getOpenedResources(joffice).add(eNewDocument);
	}

	public void addUserToGroup(Group group, User... users) {
		for (User user : users) {
			if (!group.getUsers().contains(user)) {
				group.getUsers().add(user);
				user.getGroups().add(group);
			}
		}
	}

	public Folder findMyDocumentsFolder() {
		return findMyDocumentsFolder(session.getRcpl());
	}

	public Folder findMyDocumentsFolder(RCPL joffice) {
		for (Folder e : joffice.getAllResources().getChildren()) {
			if (IModelFactory.MY_DOCUMENTS_FOLDER.equals(e.getId())) {
				return e;
			}
		}
		return null;
	}

	public Resource findOfficeDocumentTemplate(RCPL joffice, String id) {
		for (Resource doc : findTemplatesFolder(joffice).getResources()) {
			if (doc instanceof Resource && id.equals(doc.getId())) {
				return doc;
			}
		}
		return null;
	}

	public RCPL findRcplTemplate(String id) {
		for (EObject o : session.getContents()) {
			if (o instanceof RCPL) {
				RCPL jo = (RCPL) o;
				if (id.equals(jo.getId())) {
					return jo;
				}
			}
		}
		return null;
	}

	public Resource findOpenedDocument(RCPL joffice, String name) {
		for (Resource doc : getOpenedResources(joffice)) {
			if (doc instanceof Resource && doc.getId().equals(name)) {
				return doc;
			}
		}
		return null;
	}

	public Resource findOpenedDocument(String name) {
		return findOpenedDocument(session.getRcpl(), name);
	}

	public Resource findOpenedDocumentByUri(RCPL joffice, String uri) {
		for (Resource doc : getOpenedResources(joffice)) {
			if (doc instanceof Resource && doc.getUri().equals(uri)) {
				return doc;
			}
		}
		return null;
	}

	public Resource findOpenedDocumentByUri(String uri) {
		return findOpenedDocumentByUri(session.getRcpl(), uri);
	}

	public Perspective findPerspective(String id) {
		for (Perspective p : session.getRcpl().getAllPerspectives().getChildren()) {
			if (id.equalsIgnoreCase(p.getId())) {
				return p;
			}
		}
		return null;
	}

	public Folder findTemplatesFolder(RCPL joffice) {
		for (Folder e : joffice.getAllResources().getChildren()) {
			if (IModelFactory.TEMPLATE_FOLDER.equals(e.getId())) {
				return e;
			}
		}
		return null;
	}

	public Tool findTool(RCPL joffice, String id) {
		AbstractTool t = findAbstractTool(joffice, id);
		if (t instanceof Tool) {
			return (Tool) t;
		}
		return null;
	}

	public ToolGroup findToolGroup(RCPL joffice, String id) {
		AbstractTool t = findAbstractTool(joffice, id);
		if (t instanceof ToolGroup) {
			return (ToolGroup) t;
		}
		return null;
	}

	public AbstractTool findAbstractTool(RCPL joffice, String id) {
		try {
			for (ToolGroup g : joffice.getAllTools().getToolgroupChildren()) {
				AbstractTool t = findAbstractTool2(g, id);
				if (t != null) {
					return t;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * @param sideToolBar
	 * @param id
	 * @return
	 */
	public ToolGroup findToolGroup(SideToolBar sideToolBar, String id) {
		for (ToolGroup g : sideToolBar.getToolGroups()) {
			String gid = g.getId();
			if (id.equals(gid)) {
				return g;
			}
		}
		return null;
	}

	/**
	 * @param topToolBar
	 * @param id
	 * @return
	 */
	public ToolGroup findToolGroup(TopToolBar topToolBar, String id) {
		if (topToolBar != null) {
			for (ToolGroup g : topToolBar.getToolGroups()) {
				if (id.equals(g.getId())) {
					return g;
				}
			}
		}
		return null;
	}

	public AbstractTool findAbstractTool2(AbstractTool tool, String id) {
		if (tool == null) {
			return null;
		}
		if (tool.getId() == null) {
//			println("Tool without ID!:" + tool.getName());
			return null;
		}
		try {
			if (tool.getId().equals(id)) {
				return tool;
			}
			if (tool instanceof ToolGroup) {

				ToolGroup tg = (ToolGroup) tool;
				for (ToolGroup g : tg.getToolGroups()) {
					if (g.getId() != null && g.getId().equals(id)) {
						return g;
					}
					AbstractTool at = findAbstractTool2(g, id);
					if (at != null) {
						return at;
					}
				}
				for (Tool t : tg.getTools()) {
					if (t.getId() != null && t.getId().equals(id)) {
						return t;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Resource findDocument(RCPL joffice, String name) {
		for (Folder folder : joffice.getAllResources().getChildren()) {
			for (Resource doc : folder.getResources()) {
				if (doc instanceof Resource && doc.getId().equals(name)) {
					return doc;
				}
			}
			for (Resource doc : folder.getLinkedResources()) {
				if (doc instanceof Resource && doc.getId().equals(name)) {
					return doc;
				}
			}
		}
		return null;
	}

	public List<Resource> getOpenedResources() {
		return getOpenedResources(session.getRcpl());
	}

	public List<Resource> getOpenedResources(RCPL joffice) {
		for (Folder f : joffice.getAllResources().getChildren()) {
			for (Resource e : f.getResources()) {
				if (IModelFactory.RECENTLY_OPENED_DOCUMENTS_FOLDER.equals(e.getId())) {
					return e.getLinkedResources();
				}
			}
			for (Resource e : f.getLinkedResources()) {
				if (IModelFactory.RECENTLY_OPENED_DOCUMENTS_FOLDER.equals(e.getId())) {
					return e.getLinkedResources();
				}
			}
		}
		return null;
	}

	public Perspective getSettingsPerspective() {
		if (settingsPerspective == null) {
			settingsPerspective = findPerspective("SETTINGS");
		}
		return settingsPerspective;
	}

	public Perspective getSpreadsheetPerspective() {
		if (spreadsheetPerspective == null) {
			spreadsheetPerspective = findPerspective("SPREADSHEET");
		}
		return spreadsheetPerspective;
	}

	private Perspective webPerspective;
	private Perspective spreadsheetPerspective;
	private Perspective wordPerspective;
	private Perspective presentationPerspective;
	private Perspective settingsPerspective;

	public Perspective getWebPerspective() {
		if (webPerspective == null) {
			webPerspective = findPerspective("WEB");
		}
		return webPerspective;
	}

	public Perspective getWordPerspective() {
		if (wordPerspective == null) {
			wordPerspective = findPerspective("WORD");
		}
		return wordPerspective;
	}

	public Perspective getPresentationPerspective() {
		if (presentationPerspective == null) {
			presentationPerspective = findPerspective("PRESENTATION");
		}
		return presentationPerspective;
	}

	public Resource createNewDocument(RCPL rcpl, String templateName) {
		Resource template = findDocument(rcpl, templateName);
		if (template != null) {
			if (findOpenedDocument(rcpl, templateName) == null) {
				getOpenedResources(rcpl).add(template);
			}
			return template;
		}
		for (Resource doc : findTemplatesFolder(rcpl).getResources()) {
			if (doc instanceof Resource && templateName.equals(doc.getId())) {
				Resource eNewDocument = EcoreUtil.copy(doc);
//				eNewDocument.setMainPerspective(findPerspective(perspektiveType));
				// eNewDocument.layout();
				addDocument(rcpl, eNewDocument);

				return eNewDocument;
			}
		}
		return null;
	}
}
