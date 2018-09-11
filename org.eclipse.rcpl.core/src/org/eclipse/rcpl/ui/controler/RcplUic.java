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
package org.eclipse.rcpl.ui.controler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.rcpl.DelayedExecution;
import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IButton;
import org.eclipse.rcpl.IDetailPage;
import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.ILogin;
import org.eclipse.rcpl.IParagraphFigure;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.ISideToolBar;
import org.eclipse.rcpl.ITopToolbar;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.detailpages.WebBrowserDetailsPage;
import org.eclipse.rcpl.internal.fx.figures.RcplButton;
import org.eclipse.rcpl.internal.tools.URLAddressTool;
import org.eclipse.rcpl.libs.db.H2DB;
import org.eclipse.rcpl.model.IImage;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.listener.RcplEditorListenerAdapter;
import org.eclipse.rcpl.ui.listener.RcplEvent;
import org.eclipse.rcpl.util.WaitThread;
import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLDocument;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author ramin
 *
 */
public class RcplUic implements IRcplUic {

	private IHomePage activeHomePage;

	private static Timeline caretTimeline;

	private static Rectangle caret;

	public static List<String> internalStylesRegistry = null;

	public static String internalStyleMsOffice;

	public static String internalStyleWindows7;

	public static String internalStyleDark;

	protected boolean viewer;

	protected URLAddressTool urlAddressTool;

	public String WELCOME_URL;

	protected IButton buttonHome;

	protected Label titleText;

	protected Node onlineOfflineView;

	private List<IHomePage> homepages = new ArrayList<IHomePage>();

	private ITreePart rcplTreePart;

	private ITreePart applicationTreePart;

	private HashMap<String, IDetailPage> detailPages = new HashMap<String, IDetailPage>();

	private H2DB h2DB;

	private IDetailPage webDetailPage;

	@FXML
	protected Slider zoomSlider;

	@FXML
	protected Button minusZoom;

	@FXML
	protected Button plusZoom;

	@FXML
	protected Label zoomLabel;

	@FXML
	protected Button startMenuButton;

	@FXML
	protected HBox topArea;

	@FXML
	protected HBox homeHeaderHBox;

	@FXML
	protected HBox mainLeftArea;

	@FXML
	protected VBox mainLeftBox;

	@FXML
	protected HBox mainTopArea;

	@FXML
	private StackPane mainTopStack;

	@FXML
	protected HBox mainBottomArea;

	@FXML
	protected HBox mainRightArea;

	@FXML
	protected TabPane tabPane;

	@FXML
	protected Text statusText;

	@FXML
	protected HBox titleArea;

	@FXML
	protected ToggleButton topBarCollapseButton;

	@FXML
	protected HBox collapseButtonHBox;

	@FXML
	private VBox tabPaneContainer;

	@FXML
	private HBox quickToolsArea;

	@FXML
	private VBox topVBox;

	@FXML
	private StackPane logoutButtonArea;

	@FXML
	private StackPane progressArea;

	@FXML
	private StackPane zoomArea;

	private Timeline blinkingTimeline;

	private Label debugLabel;

	private VBox messageBox;

	private Perspective perspective;

	private IRcplAddon activeAddon;

	private VBox logPage;

	private TextArea errorTextArea;

	private TextArea logTextArea;

	protected File lastDocumentFile = null;

	private IApplicationStarter applicationStarter;

	private boolean internalRemoteCDOServer = false;

	private HBox internalTopTrimBar;

	private VBox internalToolBarVBox;

	protected ISideToolBar sideToolbarControl;

	private StackPane leftTrimBar;

	private SplitPane sideToolBarSplitPane;

	private WebView homeWebView;

	protected boolean internalInhibitUI = false;

	public double mouseDragOffsetX = 0;

	public double mouseDragOffsetY = 0;

	private Rectangle2D backupWindowBounds;

	protected HTMLEditor htmlEditor;

	protected StackPane internalHomeStackPane;

	protected ImageView internalHomeImageView;

	protected boolean internalFirstTimeHomePage = true;

	protected Parent internalParentTopBar = null;

	protected BorderPane internalParentParentTopBar = null;

	protected ITopToolbar internalTopToolBar;

	protected WebView internalWebView;

	public boolean internalDragMode;

	protected StackPane editorArea;

	private Node focusOwner;

	boolean requestCancel;

	protected long lastUsedMemory;

	private BorderPane borderPane;

	private Button returnButton;

	/**
	 * TabInfo
	 * 
	 * @author ramin
	 *
	 */
	protected class TabInfo {
		public TabInfo() {
		}

		private Node node;
		private Perspective perspective;
		private IEditor editor;

		private IRcplAddon addon;

		public Node getNode() {
			return node;
		}

		public Perspective getPerspective() {
			return perspective;
		}

		public IEditor getEditor() {
			return editor;
		}

		public void setEditor(IEditor editor) {
			this.editor = editor;
			if (editor != null) {
				activeHomePage = null;
			}
		}

		public void setNode(Node node) {
			this.node = node;
		}

		public void setPerspective(Perspective perspective) {
			this.perspective = perspective;
		}

		public IRcplAddon getAddon() {
			return addon;
		}

		public void setAddon(IRcplAddon addon) {
			this.addon = addon;
		}

	}

	/**
	 * Constructor
	 * 
	 * @param rcplApplicationStarter
	 */
	public RcplUic(IApplicationStarter rcplApplicationStarter) {
		this(rcplApplicationStarter, "Rcpl");
	}

	/**
	 * @param rcplApplicationStarter
	 * @param id
	 */
	public RcplUic(IApplicationStarter rcplApplicationStarter, String id) {

		this.applicationStarter = rcplApplicationStarter;
		this.editorArea = new StackPane();

		this.logPage = new VBox();
		this.errorTextArea = new TextArea();
		this.errorTextArea.setPrefSize(600, 800);
		this.errorTextArea.setEditable(false);
		this.errorTextArea.setWrapText(true);
		this.errorTextArea.setStyle("-fx-text-fill: red;");

		this.logTextArea = new TextArea();
		this.logTextArea.setPrefSize(600, 800);
		this.logTextArea.setEditable(false);
		this.logTextArea.setWrapText(true);
		logPage.getChildren().addAll(new Label("Errors"), errorTextArea, new Label("Logs"), logTextArea);
		returnButton = new Button("return");
		returnButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showHomePage(HomePageType.OVERVIEW, null);
			}
		});
		returnButton.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if ("\r".equals(event.getText())) {
					showHomePage(HomePageType.OVERVIEW, null);
				}
			}
		});
		Button clearButton = new Button("clear");
		clearButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				errorTextArea.setText("");
				logTextArea.setText("");
				RcplModel.clearLog();
			}
		});
		logPage.getChildren().addAll(returnButton, clearButton);

		Rcpl.UIC = this;

		rcplApplicationStarter.getRcplApplicationProvider().getMainApplicationStack().getScene().focusOwnerProperty()
				.addListener(new ChangeListener<Node>() {
					@Override
					public void changed(ObservableValue<? extends Node> observable, Node oldValue, Node newValue) {
						focusOwner = newValue;
					}
				});

		this.urlAddressTool = new URLAddressTool(null);
		WELCOME_URL = RcplSession.getDefault().getImageCodeBases().get(0) + "joffice_welcome.html";

	}

	public void actionAddWebBrowserTab() {
		final Tab newTab = createNewTab("Google");
		newTab.setClosable(true);
		newTab.setId("webBrowserTab");
		final WebView newWebView = new WebView();
		newWebView.getEngine().setJavaScriptEnabled(true);
		newWebView.setEffect(new InnerShadow());
		TabInfo tabInfo = getTabInfo(newTab);
		tabInfo.setNode(newWebView);
		newWebView.getEngine().load("http://www.google.com");
		urlAddressTool.addWebListener(newTab, newWebView);
		setContent(newWebView);
		newWebView.setUserData(newTab);
		tabPane.getSelectionModel().select(newTab);
		newTab.setOnSelectionChanged(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				if (newTab.isSelected()) {
					setContent(newWebView);
					updatePerspective(newTab);
				}
			}
		});
		updatePerspective(newTab);
	}

	@Override
	public void actionLogout() {
		saveRcpl();
		getRcplApplicationStarter().getRcplApplicationProvider().reStart();
	}

	private void saveRcpl() {
		doSaveRcpl();
	}

	protected void doSaveRcpl() {

	}

	@Override
	public void openDocumentWithFileDialog() {
	}

	@Override
	public void openLastDocument() {
	}

	@Override
	public void addtoApplicationStack(StackPane contentGroup) {
		contentGroup.getChildren().clear();
		contentGroup.getChildren().add(borderPane);
	}

	/**
	 * @param tab
	 */
	public boolean closeTab(final Tab tab) {
		TabInfo tabInfo = getTabInfo(tab);
		if (tabInfo != null && tabInfo.getEditor() != null) {
			final IEditor editor = tabInfo.getEditor();
			if (editor.close()) {
				tab.setUserData(null);
				getEditorArea().getChildren().remove(editor.getMainPane());
				if (tabPane.getTabs().size() == 1) {
					showHomePage(HomePageType.OVERVIEW, null);
					setScale(0);
				}
				RcplSession.getDefault().commit();
				return true;
			}
		}
		return false;
	}

	@Override
	public void createContent() {

		Rcpl.progressMessage(this.getClass().getName() + ".createContent()");

		htmlEditor = new HTMLEditor();
		htmlEditor.setPrefSize(2000, 2000);

		internalWebView = new WebView();

		if (internalHomeStackPane == null) {
			internalHomeStackPane = new StackPane();
			internalHomeStackPane.setStyle("-fx-border-color:gold;-fx-border-width: 1;");

			// mediaView = new MediaView();
			// homeStackPane.getChildren().add(mediaView);
			// StackPane
			// homeImageView = new ImageView();
			// StackPane.setMargin(homeImageView, new Insets(10));

			// homeStackPane.getChildren().add(homeImageView);
			//
			// homeWebView = new WebView();
			// homeWebView.setEffect(new InnerShadow());

		}

		initStyles();

		doCreateContent();

		new DelayedExecution(100) {

			@Override
			protected void execute() {
				showHomePage(HomePageType.OVERVIEW, null);
			}
		};

		zoomSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (Rcpl.UIC.getEditor() != null) {
					Rcpl.UIC.getEditor().setScale(newValue.doubleValue() / 100);
					zoomLabel.setText((int) (newValue.doubleValue()) + " %");
				}
			}
		});

		plusZoom.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (Rcpl.UIC.getEditor() != null) {
					double newValue = Rcpl.UIC.getEditor().getScale() + 0.1;
					setScale(newValue);
					Rcpl.UIC.getEditor().setScale(newValue);
				}
			}
		});

		minusZoom.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (Rcpl.UIC.getEditor() != null) {
					double newValue = Math.max(0, Rcpl.UIC.getEditor().getScale() - 0.1);
					setScale(newValue);
					Rcpl.UIC.getEditor().setScale(newValue);
				}
			}
		});

		zoomSlider.setVisible(false);
		plusZoom.setVisible(false);
		minusZoom.setVisible(false);
	}

	private double scale = 0.6;

	/*
	 * 1 = 100 %
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcpl.IRcplUic#setScale(double)
	 */
	@Override
	public void setScale(double scale) {
		this.scale = scale;
		zoomSlider.setVisible(scale > 0);
		plusZoom.setVisible(scale > 0);
		minusZoom.setVisible(scale > 0);
		zoomLabel.setVisible(scale > 0);
		zoomSlider.setValue(scale * 100);
		zoomLabel.setText((int) (scale * 100) + " %");
	}

	@Override
	public double getScale() {
		return scale;
	}

	public void doInitStyles() {
		internalStyleMsOffice = RcplUic.class.getResource("/css/msoffice.css").toExternalForm();
		getInternalStylesRegistry().add(internalStyleMsOffice);
		internalStyleWindows7 = RcplUic.class.getResource("/css/windows_7.css").toExternalForm();
		getInternalStylesRegistry().add(internalStyleWindows7);
		internalStyleDark = RcplUic.class.getResource("/css/theme_dark.css").toExternalForm();
		getInternalStylesRegistry().add(internalStyleDark);
	}

	@Override
	public void expandAllToolBars() {
		if (!viewer) {
			getTopToolbarControl().expandAll();
			expandBottomAra(true);
		}
	}

	@Override
	public void expandBottomAra(final boolean expand) {
		if (!expand) {
			borderPane.setBottom(null);
		} else {
			borderPane.setBottom(mainBottomArea);
		}
		mainBottomArea.layout();

	}

	@Override
	public void expandLeftAra(final boolean expand) {

		if (!expand) {
			getSideToolBarControl().collapseToolPane();
			mainLeftArea.setPrefWidth(0);
			mainLeftArea.setMinWidth(0);
			mainLeftArea.setMaxWidth(0);
		} else {
			mainLeftArea.setPrefWidth(ISideToolBar.WIDTH_COLLAPSED);
			mainLeftArea.setMinWidth(ISideToolBar.WIDTH_COLLAPSED);
			mainLeftArea.setMaxWidth(ISideToolBar.WIDTH_COLLAPSED);
		}
		mainLeftArea.layout();
	}

	@Override
	public void expandTopAra(boolean expand) {
		getTopToolbarControl().collapse(!expand);
	}

	@Override
	public Perspective findPerspective(String id) {
		for (Perspective p : RcplSession.getDefault().getRcpl().getAllPerspectives().getChildren()) {
			if (id.equals(p.getId())) {
				return p;
			}
		}
		return null;
	}

	@Override
	public IRcplAddon findRcplAddons(String id) {

		String[] splits = id.split("/");
		String lastSegment = splits[splits.length - 1];
		for (IRcplAddon addon : applicationStarter.getRcplApplicationProvider().getRcplAddons()) {
			String id2 = addon.getId();
			if (lastSegment.equals(id2)) {
				return addon;
			}
			if (addon.getClass().getName().equals(id)) {
				return addon;
			}
		}

		return null;

	}

	@Override
	public IApplicationStarter getApplicationStarter() {
		return applicationStarter;
	}

	@Override
	public WebView getBrowser() {
		if (borderPane.getCenter() == homeWebView) {
			return homeWebView;
		}
		if (tabPane != null) {
			Tab tab = tabPane.getSelectionModel().getSelectedItem();
			if (tab != null) {
				Object o = tab.getUserData();
				if (o instanceof WebView) {
					return (WebView) o;
				}
			}
		}
		return null;
	}

	@Override
	public IEditor getEditor() {
		if (tabPane == null) {
			return null;
		}
		if (tabPane.getSelectionModel().getSelectedItem() == null) {
			return null;
		}
		Tab tab = tabPane.getSelectionModel().getSelectedItem();
		TabInfo tabInfo = getTabInfo(tab);
		if (tabInfo == null) {
			return null;
		}
		return tabInfo.getEditor();
	}

	@Override
	public Node getFocusOwner() {
		return focusOwner;
	}

	@Override
	public void collapseAll() {
		getTopToolbarControl().collapse(true);
		expandLeftAra(false);
		expandTopAra(false);
		expandBottomAra(false);
	}

	public WebView getInternalInternalHomeWebView() {
		return homeWebView;
	}

	@Override
	public HBox getMainBottomArea() {
		return mainBottomArea;
	}

	@Override
	public HBox getMainLeftArea() {
		return mainLeftArea;
	}

	@Override
	public VBox getMainLeftBox() {
		return mainLeftBox;
	}

	public HBox getMainRightArea() {
		return mainRightArea;
	}

	@Override
	public HBox getMainTopArea() {
		return mainTopArea;
	}

	@Override
	public StackPane getMainTopStack() {
		return mainTopStack;
	}

	@Override
	public Perspective getPerspective() {
		return perspective;
	}

	public IApplicationStarter getRcplApplicationStarter() {
		return applicationStarter;
	}

	@Override
	public ISideToolBar getSideToolBarControl() {

		if (sideToolbarControl == null) {
			sideToolbarControl = Rcpl.getFactory().createSideToolBar(Rcpl.UIC.getMainLeftArea());
		}

		return sideToolbarControl;
	}

	public SplitPane getSideToolBarSplitPane() {
		return sideToolBarSplitPane;
	}

	@Override
	public Stage getStage() {
		return applicationStarter.getRcplApplicationProvider().getPrimaryStage();
	}

	@Override
	public String getStyleMsOffice() {
		return internalStyleMsOffice;
	}

	@Override
	public List<String> getStylesRegistry() {
		return internalStylesRegistry;
	}

	public TabPane getTabPane() {
		return tabPane;
	}

	public VBox getToolBarVBox() {
		return internalToolBarVBox;
	}

	public ITopToolbar getTopToolbarControl() {
		if (internalTopToolBar == null) {
			internalTopToolBar = Rcpl.getFactory().createTopToolBar(getMainTopStack());
		}
		return internalTopToolBar;
	}

	@Override
	public ITopToolbar getTopToolBar() {
		return getTopToolbarControl();
	}

	public HBox getTopTrimBar() {
		return internalTopTrimBar;
	}

	@Override
	public IRcplAddon getActiveAddon() {
		return activeAddon;
	}

	public StackPane getLeftTrimBar() {
		return leftTrimBar;
	}

	@FXML
	public void handleClose(ActionEvent event) {
//		RcplSession.getDefault().getSystemPreferences().put(RcplKey.STAGE_X, "" + getStage().getX());
//		RcplSession.getDefault().getSystemPreferences().put(RcplKey.STAGE_Y, "" + getStage().getY());
		RcplSession.getDefault().commit();

		RcplSession.getDefault().close(true, true);
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Platform.exit();
			}
		});
	}

	public void handleCollapseAll(ActionEvent event) {
		collapseAll();
	}

	@FXML
	public void handleMax(ActionEvent event) {
		Stage stage = getStage();
		final double stageY = stage.getY();
		final Screen screen = Screen.getScreensForRectangle(stage.getX(), stageY, 1, 1).get(0);
		Rectangle2D bounds = screen.getVisualBounds();
		if (bounds.getMinX() == stage.getX() && bounds.getMinY() == stageY && bounds.getWidth() == stage.getWidth()
				&& bounds.getHeight() == stage.getHeight()) {
			if (backupWindowBounds != null) {
				stage.setX(backupWindowBounds.getMinX());
				stage.setY(backupWindowBounds.getMinY());
				stage.setWidth(backupWindowBounds.getWidth());
				stage.setHeight(backupWindowBounds.getHeight());
			}
		} else {
			backupWindowBounds = new Rectangle2D(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight());
			final double newStageY = screen.getVisualBounds().getMinY();
			stage.setX(screen.getVisualBounds().getMinX());
			stage.setY(newStageY);
			stage.setWidth(screen.getVisualBounds().getWidth());
			stage.setHeight(screen.getVisualBounds().getHeight());
		}
	}

	@FXML
	public void handleMin(ActionEvent event) {
		getStage().setIconified(true);
	}

	@FXML
	public void handleThemeDark(ActionEvent event) {
		final Scene scene = getStage().getScene();
		removeAllStyles();
		scene.getStylesheets().add(getClass().getResource("/css/theme_dark.css").toExternalForm());
	}

	@Override
	@FXML
	public void handleThemeDefault(ActionEvent event) {
		final Scene scene = getStage().getScene();
		removeAllStyles();
		scene.getStylesheets().add(internalStyleMsOffice);

	}

	@FXML
	public void handleThemeSilver(ActionEvent event) {

		removeAllStyles();

	}

	@FXML
	public void handleThemeWIndows7(ActionEvent event) {
		final Scene scene = getStage().getScene();
		removeAllStyles();
		scene.getStylesheets().add(internalStyleWindows7);

	}

	@FXML
	public void handleTopBarCollapseButton(ActionEvent event) {
		boolean selected = topBarCollapseButton.isSelected();
		getTopToolbarControl().collapse(selected);
	}

	public void hideTopBar() {
		if (internalParentTopBar == null) {
			internalParentTopBar = internalTopTrimBar.getParent();
			internalParentParentTopBar = (BorderPane) internalParentTopBar.getParent();
		}
		internalParentParentTopBar.setTop(null);
	}

	@Override
	public void init(BorderPane parent) {
		borderPane = parent;
		tabPane.setPrefSize(10, 10);
	}

	@Override
	public boolean initSession(ILogin login) {

		Rcpl.progressMessage("Session Start");
		try {
			if (!RcplSession.getDefault().start()) {
				Rcpl.progressMessage("Session Start failed");
				return false;
			}
		} catch (Throwable e) {
			Rcpl.progressMessage(e.getMessage());
		}

		double max = 0;
		if (RcplSession.getDefault() != null && RcplSession.getDefault().isOnline()) {
			// login.getController().collapseAll();
//			max = RcplSession.getDefault().getSystemPreferences().getDouble(RcplKey.MAX_PROGRESS);
//			if (max > 0) {
//				// Rcpl.UIC.setProgressMax(max);
//			}
		}

		Rcpl.progressMessage("Register Services");

		RcplSession.getDefault().setPassword(null);

		return true;
	}

	@Override
	public void initStyles() {
		if (internalStylesRegistry == null) {
			internalStylesRegistry = new ArrayList<String>();
			doInitStyles();

		}
	}

	@Override
	public boolean isHome() {
		if (activeHomePage == null) {
			return false;
		}
		return HomePageType.OVERVIEW.equals(activeHomePage.getModel().getType());
	}

	@Override
	public boolean isInhibitUI() {
		return internalInhibitUI;
	}

	public boolean isRemoteCDOServer() {
		return internalRemoteCDOServer;
	}

	@Override
	public boolean isViewer() {
		return viewer;
	}

	public void logout() {

	}

	@Override
	public void openDocument(File file) {
	}

	@Override
	public void openTemplateDocument(String name, String tabName) {
	}

	// protected IUndoRedoListener getInternalUndoRedoListener() {
	// if (internalUndoRedoListener == null) {
	// internalUndoRedoListener = Rcpl.getFactory().createUndoRedoTool();
	// return internalUndoRedoListener;
	// }

	public void preDestroy() {
		try {
			RcplSession.getDefault().close(true, true);
		} catch (Exception ex) {
		} catch (Throwable ex) {
		}
	}

	@Override
	public void recreateSideBar() {
		internalInhibitUI = true;
		getSideToolBarControl().init();
		internalInhibitUI = false;
		getSideToolBarControl().showPerspective(Rcpl.UIC.getPerspective());
		getSideToolBarControl().showSideTools();
	}

	@Override
	public void recreateTopBar() {
		internalInhibitUI = true;
		getTopToolbarControl().init();
		internalInhibitUI = false;
		getTopToolbarControl().showPerspective(Rcpl.UIC.getPerspective());
	}

	public void removeAllSideToolBars() {
		internalToolBarVBox.getChildren().remove(1);
		while (internalToolBarVBox.getChildren().size() > 1) {
			internalToolBarVBox.getChildren().remove(1);
		}
	}

	@Override
	public void restorePerspective() {
		updatePerspective(tabPane.getSelectionModel().getSelectedItem());
	}

	@Override
	public void setContent(Node node) {
		new WaitThread(Rcpl.UIC.getEditor()) {

			@Override
			public void doRun() {
				if (node != null) {
					if (!editorArea.getChildren().contains(node)) {
						editorArea.getChildren().add(node);
					}
					node.toFront();
				}
			}
		};
	}

	@Override
	public void setDebugText(String text) {
		if (debugLabel != null) {
			debugLabel.setText(text);
		}
	}

	@Override
	public void setInhibitUI(boolean inhibitUI) {
		this.internalInhibitUI = inhibitUI;
	}

	public void setInternalInhibitUI(boolean internalInhibitUI) {
		this.internalInhibitUI = internalInhibitUI;
	}

	@Override
	public void setLeftTrimBar(StackPane leftTrimBar) {
		this.leftTrimBar = leftTrimBar;
	}

	@Override
	public void setPerspective(Perspective perspective) {
		this.perspective = perspective;
	}

	// private void initEcoreFile_OSGi() {
	//
	// String installDir = "";
	//
	// try {
	// if (JOSession.ENV_DEV) {
	//
	// File f = new
	// File(ResourcesPlugi.getWorkspace().getRoot().getLocation().toOSString());
	//
	// f = new File(f.getParentFile(),
	// "joffice_migration_1/org.eclipse.rcpl.build/installer/components/conf");
	//
	// installDir = f.getAbsolutePath() + "/";
	//
	// } else {
	// try {
	// installDir =
	// org.eclipse.core.runtime.Platform.getInstallLocation().getDataArea("/").getPath();
	//
	// } catch (IOException e1) {
	//
	// }
	// }
	// } catch (Throwable ex) {
	//
	// }
	//
	// }

	@Override
	public void setPerspective(Perspective activePerspective, IRcplAddon addon) {
		this.perspective = activePerspective;
		this.activeAddon = addon;
	}

	@Override
	public void setStatusText(String text) {
		statusText.setText(text);
	}

	@Override
	public void setTopAreaHeight(double height) {
		topVBox.setMaxHeight(height);
		topVBox.setMinHeight(height);
		topVBox.setPrefHeight(height);
		topVBox.setMaxHeight(height);
		topVBox.setMinHeight(height);
		topVBox.setPrefHeight(height);
	}

	@Override
	public void setTopContent(Node content) {
		borderPane.setTop(content);
	}

	@Override
	public void setActiveAddon(IRcplAddon addon) {
		this.activeAddon = addon;
	}

	@Override
	public void setViewer(boolean viewer) {
		this.viewer = viewer;
	}

	@Override
	public void showHomePage(HomePageType type, String id) {

		showStartMenuButton(type == null || !HomePageType.OVERVIEW.equals(type));
		IHomePage homePage = findHomePage(type, id);
		activeHomePage = homePage;

		if (editorArea.getChildren().contains(homePage.getNode())) {
			homePage.getNode().toFront();
		} else {
			setContent(homePage.getNode());
		}
		homePage.refresh();

		HomePage model = homePage.getModel();
		showPerspective(model.getPerspective());

	}

	@Override
	public IHomePage findHomePage(HomePageType type, String id) {
		for (IHomePage homePage : homepages) {
			if (type.equals(homePage.getModel().getType())) {
				if (id != null) {
					String homePageId = homePage.getModel().getId();
					if (id.equals(homePageId)) {
						return homePage;
					}
				} else {
					return homePage;
				}
			}
		}
		return null;
	}

	@Override
	public boolean showBrowser() {
		Object o = tabPane.getSelectionModel().getSelectedItem().getUserData();
		if (o instanceof WebView) {
			WebView webView = (WebView) tabPane.getSelectionModel().getSelectedItem().getUserData();
			if (webView != null) {
				setContent(webView);
				return true;
			}
		} else if ("homeTab".equals(o)) {
			showHomePage(activeHomePage.getModel().getType(), activeHomePage.getModel().getId());
		}
		return false;
	}

	@Override
	public void showErrorPage() {
		errorTextArea.setText(RcplModel.errorBuf.toString());
		logTextArea.setText(RcplModel.logBuf.toString());
		setContent(logPage);
		returnButton.requestFocus();
	}

	public void showMessage(final String title, final String message) {

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				StackPane stackPane = getRcplApplicationStarter().getRcplApplicationProvider().getMainContent();
				if (messageBox != null) {
					stackPane.getChildren().remove(messageBox);
				}

				Bounds b = stackPane.getBoundsInLocal();

				messageBox = new VBox();

				messageBox.setSpacing(10);
				messageBox.setFillWidth(true);
				messageBox.setStyle("-fx-background-color: beige");
				messageBox.setMinSize(b.getWidth() / 2, b.getHeight() / 2);
				messageBox.setPrefSize(b.getWidth() / 2, b.getHeight() / 2);
				messageBox.setMaxSize(b.getWidth() / 2, b.getHeight() / 2);
				if (title != null) {
					Label lTitle = new Label(title);
					VBox.setMargin(lTitle, new Insets(10));
					messageBox.getChildren().add(lTitle);
				}
				TextArea messageText = new TextArea(message);
				messageText.setPrefHeight(1000);
				VBox.setMargin(messageText, new Insets(10));
				messageText.setWrapText(true);
				messageBox.getChildren().add(messageText);
				stackPane.getChildren().add(messageBox);
				HBox buttonBox = new HBox();
				VBox.setMargin(buttonBox, new Insets(10));
				Button button = new Button("OK");
				HBox.setHgrow(button, Priority.ALWAYS);
				buttonBox.setPrefHeight(30);
				buttonBox.setMaxHeight(30);
				buttonBox.getChildren().add(button);
				button.setAlignment(Pos.CENTER_RIGHT);
				button.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						new DelayedExecution(30) {
							@Override
							protected void execute() {
								StackPane stackPane = getRcplApplicationStarter().getRcplApplicationProvider()
										.getMainContent();
								stackPane.getChildren().remove(messageBox);
							}
						};
					}
				});
				VBox.setVgrow(buttonBox, Priority.NEVER);
				messageBox.getChildren().add(buttonBox);
			}
		});

	}

	/**
	 * @param id
	 */
	@Override
	public boolean showPerspective(Perspective perspective) {

		topBarCollapseButton.setVisible(perspective != null && perspective.getTopToolBar() != null
				&& (!perspective.getTopToolBar().getToolGroups().isEmpty()
						|| !perspective.getTopToolBar().getTools().isEmpty()));

		if (perspective != null && perspective == this.perspective) {
			return false;
		}
		Rcpl.UIC.setPerspective(perspective);
		getSideToolBarControl().showPerspective(perspective);
		getTopToolBar().showPerspective(perspective);
		updateQuickToolsArea();
		this.perspective = perspective;
		return false;
	}

	private void updateQuickToolsArea() {
		quickToolsArea.getChildren().clear();
		if (!Rcpl.isMobile()) {
			if (perspective != null && perspective.getQuickToolBar() != null) {
				for (Tool tool : perspective.getQuickToolBar().getTools()) {
					IButton q = Rcpl.getFactory().createButton(tool);
					q.getNode().setStyle("-fx-background-color: transparent;");
					quickToolsArea.getChildren().add(q.getNode());
				}
			}
		}
	}

	@Override
	public void showStartMenuButton(boolean show) {
//		startMenuButton.setDisable(!show);
	}

	/**
	 * 
	 */

	public boolean showAddon() {
//		if (internalActiveAddon != null && internalActiveAddon.getId().length() > 0) {
//			return showPluginPerspective(internalActiveAddon);
//		}
		return false;
	}

	@Override
	public void showWebView(String url) {
		setContent(internalWebView);
		internalWebView.getEngine().load(url);
	}

	public void updatePerspective(Tab tab) {
		try {
			if (tab == null) {
				return;
			}
			TabInfo tabInfo = getTabInfo(tab);
			if (tabInfo.getPerspective() == null) {
				return;
			}
			showPerspective(tabInfo.getPerspective());

//			if (getBrowser() != null) {
//				urlAddressTool.setText(getBrowser().getEngine().getLocation());
//			}
		} catch (Exception ex) {
			Rcpl.printErrorln("", ex);
		}
	}

	@Override
	public void updateStartMenuButton() {
		try {
			if (RcplSession.getDefault().isOnline()) {
				// getStartMenuButton().setToolTip("Online");
				onlineOfflineView = Rcpl.resources().getImage("start_button", 20, 20).getNode();
				StackPane.setMargin(onlineOfflineView, new Insets(6, 0, 0, 0));
				// onlineOfflineView.setFitHeight(20);
				// onlineOfflineView.setFitWidth(20);
				Tooltip t = new Tooltip("Online");
				t.setId("joffice_tooltip");
				Tooltip.install(onlineOfflineView, t);
				addBlinkingAnimation(onlineOfflineView);
				if (blinkingTimeline != null) {
					blinkingTimeline.stop();
				}

			} else {
				// getStartMenuButton().setToolTip("Offline");
				IImage img = Rcpl.resources().getImage("start_button", 20, 20);
				onlineOfflineView = img.getNode();
				// img.getImage().;
				Tooltip t = new Tooltip("Offline");
				t.setId("joffice_tooltip");
				Tooltip.install(onlineOfflineView, t);
			}

			startMenuButton.setGraphic(onlineOfflineView);

		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}
	}

	private static Pane pane;

	/**
	 * 
	 */
	public static Pane getCaret() {

		if (pane == null) {
			pane = new Pane();
			caret = new Rectangle(3, 0, 1.6, 18);
			pane.getChildren().add(caret);
//			StackPane.setAlignment(caret, Pos.TOP_LEFT);

			caret.setX(80);
			caret.setFill(Color.BLACK);
			caretTimeline = new Timeline();
			caretTimeline.setCycleCount(Timeline.INDEFINITE);
			caretTimeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Node n = Rcpl.UIC.getFocusOwner();
					if (n instanceof ComboBox<?>) {
						caret.setFill(Color.TRANSPARENT);
						return;
					}
					caret.setFill(Color.BLACK);
					Parent parent = caret.getParent();
					if (parent != null) {
						parent.requestFocus();
					}
					IEditor editor = Rcpl.UIC.getEditor();
					if (editor != null) {
						// editor.updateScrollTargetForCaret();
					}
				}
			}), new KeyFrame(Duration.seconds(.5), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					caret.setFill(Color.TRANSPARENT);
				}
			}), new KeyFrame(Duration.seconds(1)));
			caretTimeline.play();
		}
		return pane;
	}

	public static double getCaretHeight() {
		getCaret();
		return caret.getHeight();
	}

	public static double getCaretX() {
		getCaret();
		return caret.getX();
	}

	public static double getCaretY() {
		getCaret();
		return caret.getY();
	}

	public static void setCaretHeight(double height) {
		getCaret();
		caret.setHeight(height);
	}

	public static void setCaretLocation(double x, double y) {
		getCaret();
		caret.setX(x);
		caret.setY(y);
	}

	// ===================================================

	public static void setCaretWidth(double width) {
		getCaret();
		caret.setWidth(width);
	}

	public static void showCaret(IParagraphFigure figure) {
		if (!figure.getCaretPane().getChildren().contains(RcplUic.getCaret())) {
			figure.getCaretPane().getChildren().add(RcplUic.getCaret());
		}
		getCaretTimeline().playFromStart();
		getCaret().setVisible(true);
	}

	public static void hideCaret(IParagraphFigure figure) {
		figure.getCaretPane().getChildren().clear();
	}

	private void addBlinkingAnimation(Node imageView) {
		blinkingTimeline = new Timeline();
		blinkingTimeline.setCycleCount(Timeline.INDEFINITE);
		blinkingTimeline.setAutoReverse(true);
		final KeyValue kv = new KeyValue(imageView.opacityProperty(), 0.0);
		final KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
		blinkingTimeline.getKeyFrames().add(kf);
		blinkingTimeline.play();
	}

	@Override
	public void addHomePageButton(HomePage homePage, Pane pane, ToggleGroup toggleGroup) {
		IButton homeButton = Rcpl.getFactory().createHomePageButton(homePage);
//		((ToggleButton) homeButton.getNode()).setToggleGroup(toggleGroup);
		FlowPane.setMargin(homeButton.getNode(), new Insets(0, 0, 0, 5));
		pane.getChildren().add(homeButton.getNode());
	}

//	protected void closeEditor(IEditor editor) {
//		editorArea.getChildren().remove(editor.getMainPane());
//		editor.dispose();
//	}

	private void createBorderDragger() {
		createBorderDragger(mainTopArea);
		createBorderDragger(borderPane);
		createBorderDragger(topVBox);
		createBorderDragger(quickToolsArea);
		createBorderDragger(titleArea);
		createBorderDragger(topArea);
		createBorderDragger(titleText);
		createBorderDragger(tabPane);
	}

	private void createBorderDragger(Node node) {
		if (!Rcpl.isMobile()) {
			node.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

					mouseDragOffsetX = event.getSceneX();
					mouseDragOffsetY = event.getSceneY();
				}
			});

			node.setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Stage w = getStage();
					w.setX(event.getScreenX() - mouseDragOffsetX);
					w.setY(event.getScreenY() - mouseDragOffsetY);
				}
			});

		}
	}

	protected TabInfo getTabInfo(Tab tab) {
		return (TabInfo) tab.getUserData();
	}

	protected Tab createNewTab(String title) {

		final Tab tab = new Tab();
		TabInfo tabInfo = new TabInfo();
		tab.setUserData(tabInfo);

		if (title == null) {
			title = "-";
		}

		IImage img = null;

		if (title.endsWith("docx")) {
			img = Rcpl.resources().getImage("word", 16, 16);
		} else if (title.endsWith("xlsx")) {
			img = Rcpl.resources().getImage("spreadsheet", 16, 16);
		} else if (title.endsWith("pptx")) {
			img = Rcpl.resources().getImage("presentation", 16, 16);
		}

		title = title.replaceAll("\\.docx", "");
		title = title.replaceAll("\\.xlsx", "");
		title = title.replaceAll("\\.pptx", "").trim();

		tab.setText(title);

		if (img != null) {
			tab.setGraphic(img.getNode());
		}
		try {

			tab.selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> paramObservableValue, Boolean paramT1,
						Boolean isSelected) {
					if (isSelected) {
						showTab(tab);
					}
				}
			});
			tab.setOnCloseRequest(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					if (!closeTab(tab)) {
						arg0.consume();
					}

					System.out.println();

				}
			});

			tabPane.getTabs().add(tab);

			double h = tabPane.getTabMinHeight();
			tabPane.setTabMinHeight(h + 1);
			tabPane.setTabMinHeight(h);

		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}
		return tab;
	}

	@Override
	public void createHomePages() {
		if (homepages.isEmpty()) {
			for (HomePage modelHomePage : RcplSession.getDefault().getRcpl().getHomepages().getChildren()) {
				IHomePage homePage = Rcpl.getFactory().createHomePage(this, modelHomePage);
				homepages.add(homePage);
			}
		}
	}

	private void createRecentDocumentList() {

//		try {
//			if (RcplSession.getDefault().getSystemPreferences() != null)
//
//			{
//				String lastDoc = RcplSession.getDefault().getSystemPreferences().getLastDocument();
//				if (lastDoc != null && lastDoc.trim().length() > 0) {
//					lastDocumentFile = new File(lastDoc);
//				}
//			}
//		} catch (Exception ex) {
//
//		}

	}

	private void createTitelArea() {
		titleText = new Label(getApplicationStarter().getVersionString() + " - " + RcplSession.getDefault().getUserId()
				+ " (" + (RcplSession.getDefault().isOnline() ? "Online" : "Offline") + ")");
		titleText.setId("title_version");
		titleArea.setAlignment(Pos.CENTER_LEFT);
		HBox.setHgrow(titleText, Priority.ALWAYS);
		StackPane.setAlignment(titleText, Pos.TOP_LEFT);
		StackPane.setMargin(titleText, new Insets(0, 0, 0, 55));

	}

//	protected void debugCollapsingAndHiding() {
//
//		final ToggleButton top = new ToggleButton("T");
//		top.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				getTopToolBar().collapse(!top.isSelected());
//			}
//
//		});
//		mainTopArea.getChildren().add(1, top);
//
//		final ToggleButton side = new ToggleButton("S");
//		side.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				if (!side.isSelected()) {
//					getSideToolBarControl().collapseToolPane();
//
//				} else {
//					getSideToolBarControl().showSideTools();
//				}
//			}
//		});
//		mainTopArea.getChildren().add(2, side);
//
//		final ToggleButton bottom = new ToggleButton("B");
//		bottom.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//		mainTopArea.getChildren().add(3, bottom);
//	}

	protected void doCreateContent() {

		Rcpl.progressMessage("Rcpl.doCreateContent()");

		URL location = getClass().getResource("/org/eclipse/rcpl/ui/controler/rcpl_uic.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		fxmlLoader.setController(Rcpl.UIC);

		try {
			borderPane = fxmlLoader.load();
			borderPane.setCenter(editorArea);
			init(borderPane);
		} catch (IOException e) {
			e.printStackTrace();
			// System.exit(1);
		}

		borderPane.setRight(null);

		if (viewer) {
			borderPane.setTop(null);
			borderPane.setBottom(null);
			borderPane.setLeft(null);
			return;
		}

		try {
			createTitelArea();
			createBorderDragger();
			createRecentDocumentList();
			updateEditorListener();
			statusText.setText(getApplicationStarter().getVersionString());
		} catch (Exception ex) {
			RcplModel.logError(ex);
		}

		if (Rcpl.isMobile()) {
			borderPane.setTop(titleArea);
			borderPane.setBottom(null);
		} else {
			tabPaneContainer.setAlignment(Pos.BOTTOM_LEFT);
		}

		startMenuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showHomePage(HomePageType.OVERVIEW, null);
			}
		});

		createStartMenu(startMenuButton);

		titleArea.getChildren().add(titleText);

		IButton logoutButton = new RcplButton("logout") {
			@Override
			public void doAction() {
				actionLogout();
			};
		};
		logoutButton.disableService();
		logoutButtonArea.getChildren().add(logoutButton.getNode());
		Rcpl.showProgress(false);

	}

	private ContextMenu contextMenu;

	private void createStartMenu(Node anchor) {
		contextMenu = new ContextMenu();
		contextMenu.setMinHeight(300);
		contextMenu.setMinWidth(100);

		contextMenu.setAutoHide(true);
		contextMenu.setHideOnEscape(true);
		anchor.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			@Override
			public void handle(ContextMenuEvent event) {
				contextMenu.getItems().clear();

				int counter = 0;
				for (String filePath : RcplSession.getDefault()
						.loadKeys(KeyValueKey.KEY_VALUE_KEY_RECENT_DOCUMENT.name())) {
					File file = new File(RcplSession.getDefault().getValue(filePath));
					final MenuItem item1 = new MenuItem(file.getName());
					item1.setUserData(file);
					item1.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							openDocument((File) item1.getUserData());
						}
					});
					contextMenu.getItems().add(item1);
					counter++;
					if (counter > 10) {
						break;
					}
				}
				contextMenu.show(anchor, event.getScreenX(), event.getScreenY());
			}
		});
	}

	@Override
	public void createAllHomeButtons(Pane pane) {
		RCPL rcpl = RcplSession.getDefault().getRcpl();
		ToggleGroup toggleGroup = new ToggleGroup();

		for (HomePage homePage : rcpl.getHomepages().getChildren()) {
			if (!HomePageType.OVERVIEW.equals(homePage.getType())) {
				addHomePageButton(homePage, pane, toggleGroup);
			}

		}
	}

	protected boolean isInternalDragMode() {
		return internalDragMode;
	}

	protected boolean isInternalFirstTimeHomePage() {
		return internalFirstTimeHomePage;
	}

	protected boolean isInternalInhibitUI() {
		return internalInhibitUI;
	}

	protected boolean isInternalRemoteCDOServer() {
		return internalRemoteCDOServer;
	}

	// protected IUndoRedoListener getInternalUndoRedoListener() {
	// if (internalUndoRedoListener == null) {
	// internalUndoRedoListener = Rcpl.getFactory().createUndoRedoTool();
	// HBox.setMargin((Node) internalUndoRedoListener, new Insets(0, 10, 0,
	// 10));
	// }
	// return internalUndoRedoListener;
	// }

	protected void printMemory(String message) {
		int mb = 1024 * 1024;
		Runtime runtime = Runtime.getRuntime();

		long usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / mb;
		long dif = usedMemory - lastUsedMemory;
		System.out.println(message + "   Used:" + usedMemory + " / " + dif + "     Free:" + runtime.freeMemory() / mb);

		// System.out.println("Total Memory:" + runtime.totalMemory() / mb);
		//
		// System.out.println("Max Memory:" + runtime.maxMemory() / mb);
		//
		lastUsedMemory = usedMemory;
	}

	protected void removeAllStyles() {
		for (String style : internalStylesRegistry) {
			getStage().getScene().getStylesheets().remove(style);
		}
	}

	protected boolean showHtmlEditor() {
		WebView webView = getBrowser();
		if (webView != null) {

			String htmlText = null;

			Document doc = webView.getEngine().getDocument();
			try {

				if (doc instanceof HTMLDocument) {

					// HTMLDocument htmlDoc = (HTMLDocument) doc;

					// HTMLElement el = htmlDoc.getBody();
					//
					// String str = doc.getTextContent();

					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
					transformer.setOutputProperty(OutputKeys.METHOD, "html");
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
					transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

					ByteArrayOutputStream bos = new ByteArrayOutputStream();

					transformer.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(bos, "UTF-8")));

					// transformer.transform(new DOMSource(el), new
					// StreamResult(
					// new OutputStreamWriter(bos, "UTF-8")));
					htmlText = bos.toString("UTF-8");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (htmlText != null) {
				final String html = htmlText;
				setContent(htmlEditor);
				htmlEditor.setHtmlText(html);
				return true;
			}
		}
		return false;
	}

	protected void showTab(final Tab tab) {

		final TabInfo tabInfo = getTabInfo(tab);
		if (tabInfo != null) {
			final IEditor editor = tabInfo.getEditor();
			final Node node = tabInfo.getNode();
			final IRcplAddon addon = tabInfo.getAddon();

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					updatePerspective(tab);
					if (editor != null) {
						setContent(editor.getMainPane());
					} else if (node != null) {
						setContent(node);
					} else if (addon != null) {
						setContent(addon.getNode());
					}
					tabPane.getSelectionModel().select(tab);
				}
			});
		}
	}

	private void updateEditorListener() {
		Rcpl.getEditorListeners().add(new RcplEditorListenerAdapter() {
			@Override
			public void update(final RcplEvent event) {
				if (event.getEditMode() != null) {
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							statusText.setText(event.getEditMode().name());
						}
					});

				} else if (event.getMessage() != null) {
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							statusText.setText(event.getMessage());
						}
					});

				}

			}
		});
	}

	private static Timeline getCaretTimeline() {
		return caretTimeline;
	}

	protected static String getInternalStyleDark() {
		return internalStyleDark;
	}

	protected static String getInternalStyleMsOffice() {
		return internalStyleMsOffice;
	}

	protected static List<String> getInternalStylesRegistry() {
		return internalStylesRegistry;
	}

	protected static String getInternalStyleWindows7() {
		return internalStyleWindows7;
	}

	// ===================================================

	protected static void setInternalStyleDark(String internalStyleDark) {
		RcplUic.internalStyleDark = internalStyleDark;
	}

	protected static void setInternalStyleMsOffice(String internalStyleMsOffice) {
		RcplUic.internalStyleMsOffice = internalStyleMsOffice;
	}

	protected static void setInternalStylesRegistry(List<String> internalStylesRegistry) {
		RcplUic.internalStylesRegistry = internalStylesRegistry;
	}

	protected static void setInternalStyleWindows7(String internalStyleWindows7) {
		RcplUic.internalStyleWindows7 = internalStyleWindows7;
	}

	@Override
	public void collapseMainTopArea(boolean collapse) {
		if (collapse && topArea.getChildren().contains(mainTopStack)) {
			topArea.getChildren().remove(mainTopStack);
		} else if (!collapse && !topArea.getChildren().contains(mainTopStack)) {
			topArea.getChildren().add(1, mainTopStack);
		}
	}

	@Override
	public ITreePart getRcplTreepart() {
		if (rcplTreePart == null) {
			rcplTreePart = Rcpl.getFactory().createRcplTreePart();
		}
		return rcplTreePart;
	}

	@Override
	public ITreePart getApplicationTreepart() {
		if (applicationTreePart == null) {
			applicationTreePart = Rcpl.getFactory().createApplicationTreePart();
		}
		return applicationTreePart;
	}

	@Override
	public IDetailPage getDetailPage(String className) {
		if (detailPages == null) {
			detailPages = new HashMap<String, IDetailPage>();

		}

		IDetailPage detailPage = detailPages.get(className);
		if (detailPage == null) {
			detailPage = Rcpl.getFactory().createDetailPage(className);
		}
		return detailPage;
	}

	@Override
	public void putDetailPage(String className, IDetailPage detailPage) {
		if (detailPages == null) {
			detailPages = new HashMap<String, IDetailPage>();
		}
		detailPages.put(className, detailPage);
	}

	@Override
	public IHomePage getActiveHomePage() {
		return activeHomePage;
	}

	@Override
	public StackPane getEditorArea() {
		return editorArea;
	}

	@Override
	public H2DB getH2DB() {
		if (h2DB == null) {
			h2DB = Rcpl.getFactory().createH2DB();
		}
		return h2DB;
	}

	@Override
	public IDetailPage getWebBrowserDetailPage() {
		if (webDetailPage == null) {
			webDetailPage = new WebBrowserDetailsPage();
		}
		return webDetailPage;
	}

	protected Tab searchTab(String name) {
		String[] splits1 = name.split("\\.");

		for (Tab t : tabPane.getTabs()) {
			TabInfo info = getTabInfo(t);
			String[] splits = t.getText().split("\\.");
			if (splits1[0].trim().equals(splits[0].trim())) {
				return t;
			}
			IDocument doc = info.getEditor().getDocument();
			String docName = doc.getFile().getName();
			if (docName.equals(name)) {
				return t;
			}
		}
		return null;
	}

	protected Tab searchTab(File file, Tab excludeTab) {
		for (Tab tab : tabPane.getTabs()) {
			TabInfo tabInfo = getTabInfo(tab);
			IDocument doc = tabInfo.getEditor().getDocument();
			File f = doc.getFile();
			if (f.equals(file)) {
				return tab;
			}
		}
		return null;
	}

	protected void testMemoryConsumption() {

	}

	@Override
	public StackPane getProgressArea() {
		return progressArea;
	}

	@Override
	public StackPane getZoomArea() {
		return zoomArea;
	}

	@Override
	public void addRecentDocument(File file, boolean commit) {
		for (String key : RcplSession.getDefault().loadKeys(KeyValueKey.KEY_VALUE_KEY_RECENT_DOCUMENT.name())) {
			if (file.getAbsolutePath().equals(RcplSession.getDefault().getValue(key))) {
				return;
			}
		}

		RcplSession.getDefault().putValue(
				KeyValueKey.KEY_VALUE_KEY_RECENT_DOCUMENT.name() + "_" + System.currentTimeMillis(),
				file.getAbsolutePath());
	}

	@Override
	public void layoutDocument(IEditor editor, IDocument document) {
	}
}
