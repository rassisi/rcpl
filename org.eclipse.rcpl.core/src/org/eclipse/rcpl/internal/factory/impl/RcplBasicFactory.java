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
package org.eclipse.rcpl.internal.factory.impl;

import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.EnServiceId;
import org.eclipse.rcpl.IButton;
import org.eclipse.rcpl.IColorProvider;
import org.eclipse.rcpl.ICommand;
import org.eclipse.rcpl.IDetailPage;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IFontProvider;
import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.ILogin;
import org.eclipse.rcpl.IModelManager;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplFactory;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.IService;
import org.eclipse.rcpl.ISideToolBar;
import org.eclipse.rcpl.IStyleTemplate;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.IToolFactory;
import org.eclipse.rcpl.ITopToolbar;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.app.toolcontrols.RcplSideToolBar;
import org.eclipse.rcpl.app.toolcontrols.RcplTopToolBar;
import org.eclipse.rcpl.detailpages.RcplModelManagerImpl;
import org.eclipse.rcpl.homepages.DefaultAboutHomePage;
import org.eclipse.rcpl.homepages.DefaultContactUsHomePage;
import org.eclipse.rcpl.homepages.DefaultDocumentHomePage;
import org.eclipse.rcpl.homepages.DefaultHTMLEditorHomePage;
import org.eclipse.rcpl.homepages.DefaultHomePage;
import org.eclipse.rcpl.homepages.DefaultNewHomePage;
import org.eclipse.rcpl.homepages.DefaultOverviewHomePage;
import org.eclipse.rcpl.homepages.DefaultOverviewWithNavigatorHomePage;
import org.eclipse.rcpl.homepages.DefaultPerspectiveHomePage;
import org.eclipse.rcpl.homepages.DefaultPreferencesHomePage;
import org.eclipse.rcpl.homepages.DefaultSamplesHomePage;
import org.eclipse.rcpl.homepages.DefaultTemplatesHomePage;
import org.eclipse.rcpl.homepages.DefaultToolsEditorHomePage;
import org.eclipse.rcpl.homepages.DefaultTutorialsHomePage;
import org.eclipse.rcpl.homepages.DefaultWhatsNewHomePage;
import org.eclipse.rcpl.internal.fx.figures.RcplButton;
import org.eclipse.rcpl.internal.resources.RcplColorProvider;
import org.eclipse.rcpl.internal.resources.RcplResources;
import org.eclipse.rcpl.internal.services.RcplService;
import org.eclipse.rcpl.internal.tools.RibbonGroup;
import org.eclipse.rcpl.libs.db.H2DB;
import org.eclipse.rcpl.login.RcplLogin;
import org.eclipse.rcpl.model.IResources;
import org.eclipse.rcpl.model.ISession;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.SideToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar;
import org.eclipse.rcpl.navigator.treeparts.DefaultNavigatorTreePart;
import org.eclipse.rcpl.ui.action.RcplCommand;
import org.eclipse.rcpl.ui.font.RcplFontProvider;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 * 
 */
public class RcplBasicFactory implements IRcplFactory {

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
	public ICommand createCommand(IService service, EnCommandId commandId, ILayoutObject layoutObject, Object[] oldData,
			Object... newData) {
		return new RcplCommand(service, commandId, layoutObject, null, oldData, newData);
	}

	@Override
	public ICommand createCommand(ITool tool, Object[] oldData, Object... newData) {
		ILayoutObject l = null;
		if (Rcpl.UIC().getEditor() != null) {
			l = Rcpl.UIC().getEditor().getSelectedLayoutObject();
		}
		return createCommand(tool, l, oldData, newData);
	}

	@Override
	public ICommand createCommand(ITool tool, ILayoutObject layoutObject, Object[] oldData, Object... newData) {

		try {

			if (tool.getModel() instanceof Tool) {
				switch (((Tool) tool.getModel()).getType()) {
				case TOGGLEBUTTON:
					RcplButton b = (RcplButton) tool.getModel().getData();
					newData = new Object[] { b.isSelected() };
					oldData = new Object[] { !b.isSelected() };
					break;
				case WEBVIEW:
					break;
				default:
					break;
				}
			}

			EnServiceId serviceId = EnServiceId.DEFAULT_SERVICE;
			String sId = tool.getModel().getService();

			if (sId != null) {
				serviceId = EnServiceId.valueOf(sId);
			}
			if (serviceId == null) {
				serviceId = EnServiceId.DEFAULT_SERVICE;
			}

			String id = tool.getModel().getId();
			EnCommandId commandId = EnCommandId.findCommandId(id);

			return new RcplCommand(null, commandId, layoutObject, tool, oldData, newData);
		} catch (Exception ex) {
			RcplModel.logError(ex);
			return null;
		}
	}

	@Override
	public Node createRibbonGroup(ToolGroup group, IRcplAddon useCase, boolean first, boolean dialogButton) {
		return new RibbonGroup(group, first, dialogButton).get();
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
	public IButton createButton(AbstractTool tool) {
		IButton b = new RcplButton(tool);
		return b;
	}

	@Override
	public IResources createResources() {
		return new RcplResources();
	}

	@Override
	public IColorProvider createColorProvider() {
		return new RcplColorProvider();
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
	public IToolFactory createToolFactory() {
		return new RcplToolFactory();
	}

	@Override
	public IEditor createEditor() {
		return null;
	}

	@Override
	public IStyleTemplate createStyleTemplate() {
		return null;
	}

	@Override
	public IHomePage createHomePage(IRcplUic uic, HomePage model) {

		HomePageType type = model.getType();
		switch (type) {
		case ABOUT:
			return new DefaultAboutHomePage(uic, model);
		case CONTACT_US:
			return new DefaultContactUsHomePage(uic, model);
		case DOCUMENT:
			return new DefaultDocumentHomePage(uic, model);
//		case DONAT:
//			return new DefaultDonationsHomePage(uic, modelHomePage);
		case HTML_EDITOR:
			return new DefaultHTMLEditorHomePage(uic, model);
		case NEWS:
			return new DefaultNewHomePage(uic, model);
		case OVERVIEW:
			if (model.isNavigator()) {
				return new DefaultOverviewWithNavigatorHomePage(uic, model);
			}
			return new DefaultOverviewHomePage(uic, model);
		case PERSPECTIVES:
			return new DefaultPerspectiveHomePage(uic, model);
		case PREFERENCES:
			return new DefaultPreferencesHomePage(uic, model);
		case SAMPLES:
			return new DefaultSamplesHomePage(uic, model);
		case TEMPLATES:
			return new DefaultTemplatesHomePage(uic, model);
		case TUTORIALS:
			return new DefaultTutorialsHomePage(uic, model);
		case WHATS_NEW:
			return new DefaultWhatsNewHomePage(uic, model); // TODO
		case TOOLS_EDITOR:
			return new DefaultToolsEditorHomePage(uic, model);
		default:
			return new DefaultHomePage(uic, model);

		}
	}

	private ITreePart rcplTreePart;

	@Override
	public ITreePart createRcplTreePart() {
		rcplTreePart = new DefaultNavigatorTreePart();
		return rcplTreePart;
	}

	@Override
	public ITreePart createApplicationTreePart() {
		return rcplTreePart;
	}

	IModelManager rcplTreeManager;

	@Override
	public IModelManager createRcplTreeManager() {
		rcplTreeManager = new RcplModelManagerImpl();
		return rcplTreeManager;
	}

	ISession createSession() {
		return new RcplSession();
	}

	@Override
	public IModelManager createApplicationTreeManager() {
		return rcplTreeManager;
	}

	@Override
	public IDetailPage createDetailPage(String className) {
		try {
			Class<?> cl = Class.forName(className);
			Object o = cl.newInstance();
			if (o instanceof IDetailPage) {
				return (IDetailPage) o;
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			Rcpl.get().printErrorln("", e);
		}

		return null;
	}

	@Override
	public IButton createHomePageButton(HomePage homePage) {
		Tool tool = RcplFactory.eINSTANCE.createTool();
		tool.setId(homePage.getName());
		tool.setName(homePage.getName());
		tool.setToolTip(homePage.getToolTip());
		tool.setImage(homePage.getImage());
		tool.setType(ToolType.BUTTON);
		tool.setWidth(24);
		tool.setHeight(24);

		IButton homeButton = new RcplButton(tool);
		homeButton.getNode().setId("homePageButton");

		homeButton.getNode().setPrefWidth(110);
		homeButton.getNode().setMinWidth(110);
		homeButton.getNode().setMaxWidth(110);

		homeButton.getNode().setPrefHeight(32);
		homeButton.getNode().setMinHeight(32);
		homeButton.getNode().setMaxHeight(32);

		homeButton.getNode().setText(homePage.getName());

		homeButton.setData(homePage);
		return homeButton;
	}

	@Override
	public H2DB createH2DB() {
		return new H2DB("rcpl");
	}

	@Override
	public ILogin createLoginDialog(IRcplApplicationProvider applicationProvider) {
		return new RcplLogin(applicationProvider);
	}

	@Override
	public IButton createButton(EnCommandId id) {
		return createButton(id, null);
	}

	@Override
	public IButton createButton(EnCommandId id, String cssId) {
		Tool model = RcplFactory.eINSTANCE.createTool();
		model.setId(id.getId());
		model.setName(id.getDisplayName());
		model.setImage(id.getImage());
		model.setType(ToolType.BUTTON);
		model.setToolTip(id.getToolTip());

		final String css;

		if (cssId == null) {
			css = IButton.DEFAUL_TOOLBUTTON_CSS_ID;
		} else {
			css = cssId;
		}
		final RcplButton button = new RcplButton(model) {
			@Override
			protected String getNodeId() {
				return css;
			}
		};
		button.getNode().setPickOnBounds(false);
		if (id.getServiceId() != null) {
			model.setService(id.getServiceId().name());
		} else {
			button.disableService();
		}
		return button;
	}

	@Override
	public ICommand createCommand(EnCommandId commandId, Object[] oldData, Object... newData) {
		return createCommand((IService) null, commandId, (ILayoutObject) null, oldData, newData);
	}

}
