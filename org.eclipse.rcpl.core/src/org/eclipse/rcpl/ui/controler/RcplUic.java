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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.rcpl.DelayedExecution;
import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IButton;
import org.eclipse.rcpl.IDetailPage;
import org.eclipse.rcpl.IDictionary;
import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IEditorListener;
import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.ILogin;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IParagraphFigure;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.ISideToolBar;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.ITopToolbar;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.control.RcplCompletionListener;
import org.eclipse.rcpl.detailpages.WebBrowserDetailsPage;
import org.eclipse.rcpl.internal.fx.figures.RcplButton;
import org.eclipse.rcpl.internal.tools.ComboBoxTool;
import org.eclipse.rcpl.internal.tools.TextFieldTool;
import org.eclipse.rcpl.internal.tools.URLAddressTool;
import org.eclipse.rcpl.internal.tools.WebBrowserTool;
import org.eclipse.rcpl.libs.db.H2DB;
import org.eclipse.rcpl.model.EnKeyValue;
import org.eclipse.rcpl.model.EnKeyValueFolder;
import org.eclipse.rcpl.model.IImage;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.ui.listener.RcplEditorListenerAdapter;
import org.eclipse.rcpl.ui.listener.RcplEvent;
import org.eclipse.rcpl.util.RcplUtil;
import org.eclipse.rcpl.util.RcplUtil.ColorName;
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
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
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

	/**
	 * TabInfo
	 * 
	 * @author ramin
	 *
	 */
	protected class TabInfo {
		private Node node;

		private Perspective perspective;
		private IEditor editor;
		private IRcplAddon addon;

		public TabInfo() {
		}

		public IRcplAddon getAddon() {
			return addon;
		}

		public IEditor getEditor() {
			return editor;
		}

		public Node getNode() {
			return node;
		}

		public Perspective getPerspective() {
			return perspective;
		}

		public void setAddon(IRcplAddon addon) {
			this.addon = addon;
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

	}

	private static Timeline caretTimeline;

	private static Rectangle caret;

	private static HashMap<String, String> cssStylesheets = new HashMap<String, String>();

	private static Pane caretPane;

	private static boolean paragraphEditing;

	/**
	 * 
	 */
	public static Pane getCaret() {

		if (caretPane == null) {
			caretPane = new Pane();
			caret = new Rectangle(3, 0, 1.6, 18);
			caretPane.getChildren().add(caret);

			caret.setX(80);
			caret.setFill(Color.BLACK);
			caretTimeline = new Timeline();
			caretTimeline.setCycleCount(Timeline.INDEFINITE);
			caretTimeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if (!isParagraphEditing()) {
						caret.setFill(Color.LIGHTGRAY);
						return;
					}
					caret.setFill(Color.BLACK);
					IEditor editor = Rcpl.UIC.getEditor();
					if (editor != null) {
						// editor.updateScrollTargetForCaret();
					}
				}
			}), new KeyFrame(Duration.seconds(.5), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if (paragraphEditing) {
						caret.setFill(Color.TRANSPARENT);
					} else {
						caret.setFill(Color.LIGHTGRAY);
					}
				}
			}), new KeyFrame(Duration.seconds(1)));
			caretTimeline.play();
		}
		return caretPane;
	}

	public static void activateCaret() {
		if (Rcpl.UIC.getEditor() != null) {
			ILayoutObject lo = Rcpl.UIC.getEditor().getSelectedLayoutObject();
			if (lo instanceof IParagraph) {
				caretPane.setUserData(lo.getLayoutFigure());
				caret.requestFocus();
				((IParagraphFigure) lo.getLayoutFigure()).updateCaret();
			}
		}
	}

	public static void deActivateCaret() {
		caretPane.setUserData(null);
	}

	private static boolean isParagraphEditing() {
		Object o = caretPane.getUserData();
		if (o != null
				&& "com.joffice.rcpl.addon.office.figures.word.JOParagraphFigure".equals(o.getClass().getName())) {
			paragraphEditing = true;
			return true;
		}
		paragraphEditing = false;
		return false;

	}

	public static double getCaretHeight() {
		getCaret();
		return caret.getHeight();
	}

	private static Timeline getCaretTimeline() {
		return caretTimeline;
	}

	public static double getCaretX() {
		getCaret();
		return caret.getX();
	}

	public static double getCaretY() {
		getCaret();
		return caret.getY();
	}

	public static void hideCaret(IParagraphFigure figure) {
		figure.getCaretPane().getChildren().clear();
		RcplUic.getCaret().setUserData(null);
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

	private IHomePage activeHomePage;

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

	private RcplCompletionListener completionListener;

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
	private HBox quickToolsArea;

	@FXML
	private VBox topVBox;

	@FXML
	private StackPane logoutButtonArea;

	@FXML
	private StackPane progressArea;

	@FXML
	private HBox editorWindowTools;

	@FXML
	private ToggleButton themeDefaultButton;

	@FXML
	private ToggleButton themeSilverButton;

	@FXML
	private ToggleButton themeDarkButton;

	@FXML
	private ToggleButton themeWindows7Button;

	@FXML
	private ToggleButton onePageButton;

	@FXML
	private ToggleButton twoPagesButton;

	@FXML
	private ToggleButton multiPagesButton;

	@FXML
	private ColorPicker themeColorPicker;

	// ----------------------------------------------------------

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

	private List<File> recentlyOpenedDocuments = new ArrayList<File>();

	private List<File> lastOpenedDocuments = new ArrayList<File>();

	private double scale = 0.6;

	private ContextMenu contextMenu;

	private ToggleGroup themeToggles = new ToggleGroup();

	private ToggleGroup pageLayoutToggles = new ToggleGroup();

	private boolean inPageLayout;

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

		updatePerspective(newTab);
	}

	@Override
	public void actionLogout() {
		saveRcpl();
		getRcplApplicationStarter().getRcplApplicationProvider().reStart();
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
		FlowPane.setMargin(homeButton.getNode(), new Insets(0, 0, 0, 5));
		pane.getChildren().add(homeButton.getNode());
	}

	@Override
	public void addRecentDocument(File file, boolean commit) {

		for (String key : RcplSession.getDefault().loadKeys(EnKeyValueFolder.HISTORY.name(),
				EnKeyValue.RECENT_DOCUMENT.name())) {
			if (file.getAbsolutePath()
					.equals(RcplSession.getDefault().getValue(EnKeyValueFolder.HISTORY.name(), key))) {
				return;
			}
		}
		Rcpl.set(EnKeyValue.RECENT_DOCUMENT, file.getAbsolutePath());
		RcplSession.getDefault().commit();
	}

	@Override
	public void addtoApplicationStack(StackPane contentGroup) {
		contentGroup.getChildren().clear();
		contentGroup.getChildren().add(borderPane);
	}

	@Override
	public void closeApplication() {

		Rcpl.set(EnKeyValue.LOGIN_WINDOW_X, getApplicationStarter().getRcplApplicationProvider().getLoginWindowX());
		Rcpl.set(EnKeyValue.LOGIN_WINDOW_Y, getApplicationStarter().getRcplApplicationProvider().getLoginWindowY());

		Rcpl.set(EnKeyValue.WINDOW_X, getStage().getX());
		Rcpl.set(EnKeyValue.WINDOW_Y, getStage().getY());
		Rcpl.set(EnKeyValue.WINDOW_WIDTH, getStage().getWidth());
		Rcpl.set(EnKeyValue.WINDOW_HEIGHT, getStage().getHeight());

		Rcpl.set(EnKeyValue.SIDEBAR_LEFT, sideBarLeft);

		Rcpl.deleteAllValues(EnKeyValueFolder.HISTORY.name(), EnKeyValue.LAST_OPENED_DOCUMENT);

		Rcpl.set(EnKeyValue.TOP_TOOLBAR_COLLAPSED, topBarCollapseButton.isSelected());

		for (Tab tab : tabPane.getTabs()) {
			TabInfo ti = getTabInfo(tab);
			if (ti != null) {
				IEditor editor = ti.getEditor();
				if (editor != null && editor.getDocument() != null && editor.getDocument().getFile() != null) {
					String fn = editor.getDocument().getFile().getAbsolutePath();
					Rcpl.set(editor, EnKeyValue.LAST_OPENED_DOCUMENT, fn);
				}
			}
		}

		RcplSession.getDefault().commit();
		RcplSession.getDefault().close(true, true);

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Platform.exit();
				System.exit(0);
			}
		});
	}

	/**
	 * @param tab
	 */
	private void closeTab(final Tab tab, Event event) {
		TabInfo tabInfo = getTabInfo(tab);
		if (tabInfo != null && tabInfo.getEditor() != null) {
			final IEditor editor = tabInfo.getEditor();
			if (editor.close()) {
				tab.setUserData(null);
				if (tabPane.getTabs().size() == 1) {
					showHomePage(HomePageType.OVERVIEW, null);
					editorWindowTools.setVisible(false);
				}
				RcplSession.getDefault().commit();
			} else {
//				event.consume();
			}
		}
	}

	@Override
	public void collapseAll() {
		getTopToolbarControl().collapse(true);
		expandLeftAra(false);
		expandTopAra(false);
		expandBottomAra(false);
	}

	@Override
	public void collapseMainTopArea(boolean collapse) {
		if (collapse && topVBox.getChildren().contains(mainTopStack)) {
			topVBox.getChildren().remove(mainTopStack);
		} else if (!collapse && !topVBox.getChildren().contains(mainTopStack)) {
			topVBox.getChildren().add(1, mainTopStack);
		}
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

	private void createBorderDragger() {
		createBorderDragger(mainTopArea);
		createBorderDragger(borderPane);
		createBorderDragger(topVBox);
		createBorderDragger(quickToolsArea);
		createBorderDragger(titleArea);
		createBorderDragger(mainTopStack);
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

	@Override
	public void createContent() {

		Rcpl.progressMessage(this.getClass().getName() + ".createContent()");

		// ---------- restore some GUI states

//		RcplSession.getDefault().setMaxKeyValues(KeyValueKey.RECENT_DOCUMENT, 10);
//		RcplSession.getDefault().setMaxKeyValues(KeyValueKey.LAST_OPENED_DOCUMENT, 10);

		List<String> recentDocumentKeys = RcplSession.getDefault()
				.loadKeys(EnKeyValue.RECENT_DOCUMENT.getFolder().name(), EnKeyValue.RECENT_DOCUMENT.name());
		List<String> lastDocumentKeys = RcplSession.getDefault()
				.loadKeys(EnKeyValue.LAST_OPENED_DOCUMENT.getFolder().name(), EnKeyValue.LAST_OPENED_DOCUMENT.name());

		for (int i = recentDocumentKeys.size() - 1; i >= 0; i--) {
			File file = new File(RcplSession.getDefault().getValue(EnKeyValue.RECENT_DOCUMENT.getFolder().name(),
					recentDocumentKeys.get(i)));
			recentlyOpenedDocuments.add(file);
		}

		for (int i = 0; i < lastDocumentKeys.size(); i++) {
			File file = new File(RcplSession.getDefault().getValue(EnKeyValue.RECENT_DOCUMENT.getFolder().name(),
					lastDocumentKeys.get(i)));
			lastOpenedDocuments.add(file);
		}

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

		doCreateContent();

		new DelayedExecution(100) {

			@Override
			protected void execute() {
				sideBarLeft = !Rcpl.get(EnKeyValue.SIDEBAR_LEFT, true);
				onChangeSideBar();
				showHomePage(HomePageType.OVERVIEW, null);
			}
		};

		zoomSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (Rcpl.UIC.getEditor() != null) {
					double scale = computeScale(newValue.doubleValue());
					Rcpl.UIC.getEditor().setScale(scale);
					if (oldValue.doubleValue() != 0.0) {
						Rcpl.set(getEditor(), EnKeyValue.EDITOR_SCALE, newValue.doubleValue());
					}
					zoomLabel.setText("   " + (int) (scale * 100) + " %");
				}
			}
		});

		plusZoom.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (Rcpl.UIC.getEditor() != null) {
					double newValue = zoomSlider.getValue() + 0.05;
					setScale(newValue);
				}
			}
		});

		minusZoom.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (Rcpl.UIC.getEditor() != null) {
					double newValue = zoomSlider.getValue() - 0.05;
					setScale(newValue);
				}
			}
		});

		if (!lastOpenedDocuments.isEmpty()) {
			new Thread() {
				@Override
				public void run() {

					topBarCollapseButton.setSelected(Rcpl.get(EnKeyValue.TOP_TOOLBAR_COLLAPSED, false));

					File file = lastOpenedDocuments.get(lastOpenedDocuments.size() - 1);
					final boolean[] done = new boolean[1];
					completionListener = new RcplCompletionListener() {
						@Override
						public void onCompleted() {
							done[0] = true;
						}
					};
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							openDocument(file);
						}
					});
					RcplUtil.waitForDone(done);
					completionListener = null;
				}
			}.start();
		}

		getStage().widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (!inPageLayout) {
					try {
						if (Rcpl.get(getEditor(), EnKeyValue.PAGE_COLUMNS, 0) == -1) {
							inPageLayout = true;
							onMultiPages();
							inPageLayout = false;
						}
					} catch (Exception ex) {
						// happens when logging out
					}
				}
			}
		});

		themeDefaultButton.setId("themeDefaultButton");
		themeDarkButton.setId("themeDarkButton");
		themeSilverButton.setId("themeSilverButton");
		themeWindows7Button.setId("themeWindows7Button");

		themeToggles.getToggles().addAll(themeDefaultButton, themeSilverButton, themeDarkButton, themeWindows7Button);

		pageLayoutToggles.getToggles().addAll(onePageButton, twoPagesButton, multiPagesButton);

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {
					String style = Rcpl.get(EnKeyValue.THEME, null);
					if (THEME_MSOFFICE.equals(style)) {
						themeDefaultButton.setSelected(true);
						themeDefaultButton.requestFocus();
						handleThemeDefault(null);
					} else if (THEME_DARK.equals(style)) {
						themeDarkButton.setSelected(true);
						themeDarkButton.requestFocus();
						handleThemeDark(null);
					} else if (THEME_SILVER.equals(style)) {
						themeSilverButton.setSelected(true);
						themeSilverButton.requestFocus();
						handleThemeSilver(null);
					} else if (THEME_WINDOWS7.equals(style)) {
						themeWindows7Button.setSelected(true);
						themeWindows7Button.requestFocus();
						handleThemeSilver(null);
					} else {

						File f = RcplUtil.createCacheFile(style + ".css");
						if (f.exists()) {
							removeAllStyles();
							try {
								addStyles(f.toURI().toURL().toExternalForm());
								return;
							} catch (MalformedURLException e) {
							}
						}

						// ---------- fall back ----------

						themeSilverButton.setSelected(true);
						themeSilverButton.requestFocus();

					}
				} catch (Exception ex) {
					Rcpl.printErrorln("", ex);
				}
			}
		});

	}

	private double computeScale(double scale) {
		double result;
		if (scale >= 0.5) {
			result = 1 + (scale - 0.5) * 3;
		} else {
			result = 1 - Math.abs(scale - 0.5) * 2;
		}

		return Math.max(result, 0.05);

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

	protected Tab createNewTab(String title) {

		final Tab tab = new Tab();

		tab.setContent(null);
		ContextMenu contextMenu = new ContextMenu();
		contextMenu.setMinHeight(300);
		contextMenu.setMinWidth(100);

		contextMenu.setAutoHide(true);
		contextMenu.setHideOnEscape(true);
		tab.setContextMenu(contextMenu);

		final MenuItem item1 = new MenuItem("close");
		item1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				closeTab(tab);
				tabPane.getTabs().remove(tab);
			}
		});
		contextMenu.getItems().add(item1);

		final MenuItem item2 = new MenuItem("close All");
		item2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				List<Tab> tabs = new ArrayList<Tab>();
				tabs.addAll(tabPane.getTabs());

				for (Tab t : tabs) {
					try {
						new WaitThread() {

							@Override
							public void doRun() {
								closeTab(t);
								tabPane.getTabs().remove(tab);
							}
						};

					} catch (Exception ex) {
						break;
					}
					RcplUtil.sleep(30);
				}
			}
		});
		contextMenu.getItems().add(item2);

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
					closeTab(tab, arg0);
				}
			});

			tabPane.getTabs().add(tab);
		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}
		return tab;
	}

	private void closeTab(Tab tab) {
		EventHandler<Event> handler = tab.getOnCloseRequest();
		if (null != handler) {
			handler.handle(null);
		} else {
			tab.getTabPane().getTabs().remove(tab);
		}
	}

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
				for (File file : recentlyOpenedDocuments) {
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

	private void createTitelArea() {
		titleText = new Label(getApplicationStarter().getVersionString() + " - " + RcplSession.getDefault().getUserId()
				+ " (" + (RcplSession.getDefault().isOnline() ? "Online" : "Offline") + ")");
		titleText.setId("title_version");
		titleArea.setAlignment(Pos.CENTER_LEFT);
		HBox.setHgrow(titleText, Priority.ALWAYS);
		StackPane.setAlignment(titleText, Pos.TOP_LEFT);
		StackPane.setMargin(titleText, new Insets(0, 0, 0, 55));

	}

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
			updateEditorListener();
			statusText.setText(getApplicationStarter().getVersionString());
		} catch (Exception ex) {
			RcplModel.logError(ex);
		}

		if (Rcpl.isMobile()) {
			borderPane.setTop(titleArea);
			borderPane.setBottom(null);
		}
//		else {
//			tabPaneContainer.setAlignment(Pos.BOTTOM_LEFT);
//		}

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

		tabPane.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				showTab(tabPane.getSelectionModel().getSelectedItem());
			}
		});

	}

	protected void doOpenDocument(URL file) {
	}

	protected void doOpenDocument(File file) {
	}

	protected void doOpenDocumentWithFileDialog() {
	}

	protected void doOpenLastDocument() {
	}

	protected void doOpenTemplateDocument(final String docName, String tabName) {
	}

	protected void doSaveRcpl() {

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
	public IRcplAddon getActiveAddon() {
		return activeAddon;
	}

	@Override
	public IHomePage getActiveHomePage() {
		return activeHomePage;
	}

	@Override
	public IApplicationStarter getApplicationStarter() {
		return applicationStarter;
	}

	@Override
	public ITreePart getApplicationTreepart() {
		if (applicationTreePart == null) {
			applicationTreePart = Rcpl.getFactory().createApplicationTreePart();
		}
		return applicationTreePart;
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

	public RcplCompletionListener getCompletionListener() {
		return completionListener;
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

//	@Override
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
	public H2DB getH2DB() {
		if (h2DB == null) {
			h2DB = Rcpl.getFactory().createH2DB();
		}
		return h2DB;
	}

	// protected IUndoRedoListener getInternalUndoRedoListener() {
	// if (internalUndoRedoListener == null) {
	// internalUndoRedoListener = Rcpl.getFactory().createUndoRedoTool();
	// return internalUndoRedoListener;
	// }

	public WebView getInternalInternalHomeWebView() {
		return homeWebView;
	}

	public StackPane getLeftTrimBar() {
		return leftTrimBar;
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

	@Override
	public StackPane getProgressArea() {
		return progressArea;
	}

	public IApplicationStarter getRcplApplicationStarter() {
		return applicationStarter;
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
	public ITreePart getRcplTreepart() {
		if (rcplTreePart == null) {
			rcplTreePart = Rcpl.getFactory().createRcplTreePart();
		}
		return rcplTreePart;
	}

	@Override
	public double getScale() {
		return scale;
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

	protected TabInfo getTabInfo(Tab tab) {
		return (TabInfo) tab.getUserData();
	}

	public TabPane getTabPane() {
		return tabPane;
	}

	public VBox getToolBarVBox() {
		return internalToolBarVBox;
	}

	@Override
	public ITopToolbar getTopToolBar() {
		return getTopToolbarControl();
	}

	public ITopToolbar getTopToolbarControl() {
		if (internalTopToolBar == null) {
			internalTopToolBar = Rcpl.getFactory().createTopToolBar(getMainTopStack());
		}
		return internalTopToolBar;
	}

	public HBox getTopTrimBar() {
		return internalTopTrimBar;
	}

	@Override
	public IDetailPage getWebBrowserDetailPage() {
		if (webDetailPage == null) {
			webDetailPage = new WebBrowserDetailsPage();
		}
		return webDetailPage;
	}

	@FXML
	public void handleClose(ActionEvent event) {
		closeApplication();
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

	private static final String THEME_MSOFFICE = "THEME_MSOFFICE";

	private static final String THEME_DARK = "THEME_DARK";

	private static final String THEME_DEFAULT = "THEME_DEFAULT";

	private static final String THEME_SILVER = "THEME_SILVER";

	private static final String THEME_WINDOWS7 = "THEME_WINDOWS7";

	@FXML
	public void handleThemeColorPicker(ActionEvent event) {
		Color color = themeColorPicker.getValue();
		if (color != null) {
			ColorName c2 = RcplUtil.findColor(color);
			removeAllStyles();
			String newStyleKey = "THEME_" + c2.name;
			String newStyleSheet = cssStylesheets.get(newStyleKey);
			if (newStyleSheet == null) {
				createStyleSheetTheme(c2);
			}

		}
	}

	private void createStyleSheetTheme(ColorName c2) {

		String newStyleKey = "THEME_" + c2.name;

		String s = RcplUtil.loadCssAsString("default_template.css");
		File f = RcplUtil.saveStringToFileInCache(newStyleKey + ".css",
				".root { -fx-base: rgb(" + (int) (c2.col.getRed() * 255.0) + "," + (int) (c2.col.getGreen() * 255.0)
						+ "," + (int) (c2.col.getBlue() * 255.0) + "); }\n" + s);
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {
					String newStyleSheet = f.toURI().toURL().toExternalForm();
					cssStylesheets.put(newStyleKey, newStyleSheet);
					removeAllStyles();
					addStyles(cssStylesheets.get(newStyleKey));
					Rcpl.set(EnKeyValue.THEME, newStyleKey);
				} catch (MalformedURLException e) {

				}
			}
		});

	}

	@FXML
	public void handleThemeDark(ActionEvent event) {
		createStyleSheetTheme(new ColorName(Color.rgb(100, 100, 100), THEME_DARK));
		Rcpl.set(EnKeyValue.THEME, THEME_DARK);
	}

	@FXML
	public void handleThemeDefault(ActionEvent event) {
		createStyleSheetTheme(new ColorName(Color.rgb(172, 208, 238), THEME_MSOFFICE));
		Rcpl.set(EnKeyValue.THEME, THEME_MSOFFICE);
	}

	@FXML
	public void handleThemeSilver(ActionEvent event) {
		createStyleSheetTheme(new ColorName(Color.WHITESMOKE, THEME_SILVER));
		Rcpl.set(EnKeyValue.THEME, THEME_SILVER);
	}

	@FXML
	public void handleThemeWindows7(ActionEvent event) {
		createStyleSheetTheme(new ColorName(Color.AZURE, THEME_WINDOWS7));
		Rcpl.set(EnKeyValue.THEME, THEME_WINDOWS7);
	}

	private void addStyles(String... styles) {
		final Scene scene = getStage().getScene();
		for (String style : styles) {
			scene.getStylesheets().add(style);
			getApplicationStarter().getRcplApplicationProvider().getApplicationWindow().getStyleSheets().add(style);
		}
	}

	private void removeAllStyles() {
		List<String> sts = getStage().getScene().getStylesheets();
		sts.clear();
		getApplicationStarter().getRcplApplicationProvider().getApplicationWindow().resetStyles();

	}

	@Override
	public boolean isTopToolbarCollapsed() {
		return topBarCollapseButton.isSelected();
	}

	@FXML
	public void handleTopBarCollapseButton(ActionEvent event) {
		getTopToolbarControl().collapse(isTopToolbarCollapsed());
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
	}

	// ===================================================

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

//		double max = 0;
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

	protected boolean isInternalDragMode() {
		return internalDragMode;
	}

//	protected void closeEditor(IEditor editor) {
//		editorArea.getChildren().remove(editor.getMainPane());
//		editor.dispose();
//	}

	protected boolean isInternalFirstTimeHomePage() {
		return internalFirstTimeHomePage;
	}

	protected boolean isInternalInhibitUI() {
		return internalInhibitUI;
	}

	protected boolean isInternalRemoteCDOServer() {
		return internalRemoteCDOServer;
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

	private boolean sideBarLeft = true;

	@FXML
	public void onChangeSideBar() {
		sideBarLeft = !sideBarLeft;
		borderPane.getChildren().remove(mainLeftBox);
		if (sideBarLeft) {
			borderPane.setLeft(mainLeftBox);
			mainLeftArea.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		} else {
			borderPane.setRight(mainLeftBox);
			mainLeftArea.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		}
	}

	@FXML
	public void onTest() {
//		getSideToolBarControl().expand("sidebar_paragraph_font/paragraphProperties");
		IDictionary.INSTANCE.setLocale(Locale.GERMAN);
	}

	@FXML
	public void onMultiPages() {
		if (getEditor() != null) {
			Rcpl.set(getEditor(), EnKeyValue.PAGE_COLUMNS, -1);
			getEditor().setPageColumns(-1);
		}
	}

	@FXML
	public void onOnePage() {
		if (getEditor() != null) {
			Rcpl.set(getEditor(), EnKeyValue.PAGE_COLUMNS, 1);
			getEditor().setPageColumns(1);
		}
	}

	@FXML
	public void onTwoPages() {
		if (getEditor() != null) {
			Rcpl.set(getEditor(), EnKeyValue.PAGE_COLUMNS, 2);
			getEditor().setPageColumns(2);
		}
	}

	@Override
	public void openDocument(URL url) {
		editorWindowTools.setVisible(true);
		doOpenDocument(url);
	}

	@Override
	public void openDocument(File file) {
		editorWindowTools.setVisible(true);
		doOpenDocument(file);
	}

	@Override
	public void openDocumentWithFileDialog() {
		editorWindowTools.setVisible(true);
		doOpenDocumentWithFileDialog();
	}

	@Override
	public void openLastDocument() {
		editorWindowTools.setVisible(true);
		doOpenLastDocument();
	}

	@Override
	public void openTemplateDocument(String name, String tabName) {
		editorWindowTools.setVisible(true);
		doOpenTemplateDocument(name, tabName);
	}

	public void preDestroy() {
		try {
			RcplSession.getDefault().close(true, true);
		} catch (Exception ex) {
		} catch (Throwable ex) {
		}
	}

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

	@Override
	public void putDetailPage(String className, IDetailPage detailPage) {
		if (detailPages == null) {
			detailPages = new HashMap<String, IDetailPage>();
		}
		detailPages.put(className, detailPage);
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

	// protected IUndoRedoListener getInternalUndoRedoListener() {
	// if (internalUndoRedoListener == null) {
	// internalUndoRedoListener = Rcpl.getFactory().createUndoRedoTool();
	// HBox.setMargin((Node) internalUndoRedoListener, new Insets(0, 10, 0,
	// 10));
	// }
	// return internalUndoRedoListener;
	// }

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

	private void saveRcpl() {
		doSaveRcpl();
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

	protected Tab searchTab(String name) {
		String[] splits1 = name.split("\\.");

		try {
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
		} catch (Exception ex) {
			// ignore
		}
		return null;
	}

	@Override
	public void setActiveAddon(IRcplAddon addon) {
		this.activeAddon = addon;
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

	// ===================================================

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

	@Override
	public void setPerspective(Perspective activePerspective, IRcplAddon addon) {
		this.perspective = activePerspective;
		this.activeAddon = addon;
	}

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
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// to force a change event
				zoomSlider.setValue(scale + 0.001);
				zoomSlider.setValue(scale);
			}
		});
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
	}

	@Override
	public void setTopContent(Node content) {
		borderPane.setTop(content);
	}

	@Override
	public void setViewer(boolean viewer) {
		this.viewer = viewer;
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

		try {
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

			new DelayedExecution(100) {

				@Override
				protected void execute() {
					handleTopBarCollapseButton(null);
				}
			};
		} catch (Exception ex) {
			Rcpl.printErrorln("", ex);
		}
		return false;
	}

	@Override
	public void showStartMenuButton(boolean show) {
//		startMenuButton.setDisable(!show);
	}

	protected void showTab(final Tab tab) {

		if (tab != null) {
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
	}

	@Override
	public void showWebView(String url) {
		setContent(internalWebView);
		internalWebView.getEngine().load(url);
	}

	protected void testMemoryConsumption() {

	}

	private void updateEditorListener() {
		Rcpl.getEditorListeners().add(new RcplEditorListenerAdapter() {
			@Override
			public boolean update(final RcplEvent event) {
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
				return true;

			}
		});
	}

	public ITool findTool(EnCommandId id) {
		for (IEditorListener l : Rcpl.getEditorListeners()) {
			if (l instanceof ITool) {
				ITool t = (ITool) l;
				if (id.getId() != null && t.getModel() != null && id.getId().equals(t.getModel().getId())) {
					return t;
				}
			}
		}
		return null;
	}

	public ITool findTool(ToolType type) {
		for (IEditorListener l : Rcpl.getEditorListeners()) {

			if (l instanceof ITool) {
				ITool t = (ITool) l;
				if (t.getModel() != null && type.equals(t.getModel().getType())) {
					return t;
				}
			}
		}
		return null;
	}

	public ITool findTool(ToolType type, String id) {
		for (IEditorListener l : Rcpl.getEditorListeners()) {
			if (l instanceof ITool) {
				ITool t = (ITool) l;
				if (t.getModel() != null && type.equals(t.getModel().getType()) && id.equals(t.getModel().getId())) {
					return t;
				}
			}
		}
		return null;
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

	@FXML
	private void onZoom100() {
		if (Rcpl.UIC.getEditor() != null) {
			double newValue = 0.5;
			setScale(newValue);
		}
	}

	@Override
	public WebBrowserTool findWebBrowserTool(String id) {
		return (WebBrowserTool) Rcpl.UIC.findTool(ToolType.WEBVIEW, id);
	}

	@Override
	public ComboBoxTool findComboBoxTool(String id) {
		return (ComboBoxTool) Rcpl.UIC.findTool(ToolType.COMBO, id);
	}

	@Override
	public TextFieldTool findTextFieldTool(String id) {
		return (TextFieldTool) Rcpl.UIC.findTool(ToolType.TEXTFIELD, id);
	}

	protected void saveWorkingDir(String dir) {
		Rcpl.set(EnKeyValue.WORKING_DIR, dir);
	}

	protected String getWorkingDir() {
		return Rcpl.get(EnKeyValue.WORKING_DIR);
	}

	@Override
	public void save() {
	}

	@Override
	public void saveAs() {
	}

}
