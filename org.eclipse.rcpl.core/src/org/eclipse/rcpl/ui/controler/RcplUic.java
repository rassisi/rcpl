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
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.rcpl.DelayedExecution;
import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IButton;
import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IEditorListener;
import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.INavigatorAddon;
import org.eclipse.rcpl.IParagraphFigure;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.ISideToolBar;
import org.eclipse.rcpl.ITopToolbar;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.WaitThread;
import org.eclipse.rcpl.homepages.DefaultAboutHomePage;
import org.eclipse.rcpl.homepages.DefaultNewHomePage;
import org.eclipse.rcpl.homepages.DefaultPerspectiveHomePage;
import org.eclipse.rcpl.homepages.DefaultSamplesHomePage;
import org.eclipse.rcpl.internal.fx.figures.JOButton;
import org.eclipse.rcpl.internal.tools.URLAddressTool;
import org.eclipse.rcpl.login.RcplLogin;
import org.eclipse.rcpl.migration.RcplMigration;
import org.eclipse.rcpl.model.IImage;
import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.cdo.client.RcplKey;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.ui.listener.RcplEditorListenerAdapter;
import org.eclipse.rcpl.ui.listener.RcplEvent;
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
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
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

	private static Timeline caretTimeline;

	private static Rectangle caret;

	public static List<String> internalStylesRegistry = null;

	public static String internalStyleMsOffice;

	public static String internalStyleWindows7;

	public static String internalStyleDark;

	/**
	 * 
	 */
	public static Rectangle getCaret() {

		if (caret == null) {
			caret = new Rectangle(3, 0, 1.6, 18);
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
		return caret;
	}

	public static double getCaretHeight() {
		return getCaret().getHeight();
	}

	private static Timeline getCaretTimeline() {
		return caretTimeline;
	}

	public static double getCaretX() {
		return getCaret().getX();
	}

	public static double getCaretY() {
		return getCaret().getY();
	}

	protected static String getInternalStyleDark() {
		return internalStyleDark;
	}

	protected static String getInternalStyleMsOffice() {
		return internalStyleMsOffice;
	}

	// private IButton saveButton;
	//
	// private IButton saveAsButton;

	protected static List<String> getInternalStylesRegistry() {
		return internalStylesRegistry;
	}

	protected static String getInternalStyleWindows7() {
		return internalStyleWindows7;
	}

	public static void setCaretHeight(double height) {
		getCaret().setHeight(height);
	}

	public static void setCaretLocation(double x, double y) {
		getCaret().setX(x);
		getCaret().setY(y);
	}

	// ===================================================

	public static void setCaretWidth(double width) {
		getCaret().setWidth(width);
	}

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

	public static void showCaret(IParagraphFigure figure) {

		if (!figure.getPane().getChildren().contains(RcplUic.getCaret())) {
			figure.getPane().getChildren().add(RcplUic.getCaret());
		}

		getCaretTimeline().playFromStart();
		getCaret().setVisible(true);

	}

	protected boolean viewer;

	protected URLAddressTool urlAddressTool;

	protected IHomePage samplesPage;

	protected IHomePage perspectivePage;

	protected IHomePage newPage;

	protected IHomePage aboutPage;

	protected IHomePage overviewPage;

	protected IHomePage preferencesPage;

	protected IHomePage tutorialsPage;

	protected IHomePage donationPage;

	protected IHomePage whatsNewPage;

	protected IHomePage contactUsPage;

	public String WELCOME_URL;

	protected IButton buttonHome;

	protected Text titleText;

	protected Node onlineOfflineView;

	protected List<IHomePage> homepages = new ArrayList<IHomePage>();

	@FXML
	protected Button startMenuButton;

	@FXML
	protected VBox topArea;

	@FXML
	protected HBox homeHeaderHBox;

	@FXML
	protected HBox homeButtonsArea;

	@FXML
	protected HBox mainLeftArea;

	@FXML
	protected VBox mainLeftBox;

	@FXML
	protected HBox mainTopArea;

	@FXML
	protected StackPane mainTopStack;

	// private void createQuickToolButtons() {
	//
	// if (!Rcpl.isBigDisplay()) {
	// buttonHome = Rcpl.factory.createButton("", "", "Home", "home", false, new
	// IButtonListener() {
	//
	// @Override
	// public void doAction() {
	// showOverviewPage();
	// }
	// }, true);
	// }
	//
	// saveButton = Rcpl.factory.createButton("", "", "Save", "save", false, new
	// IButtonListener() {
	//
	// @Override
	// public void doAction() {
	// actionSaveDocument();
	// }
	// }, true);
	//
	// saveAsButton = Rcpl.factory.createButton("", "", "Save As...", "save_as",
	// false, new IButtonListener() {
	//
	// @Override
	// public void doAction() {
	// actionSaveDocumentAs();
	// }
	// }, true);
	//
	// // buttonLogout = Rcpl.factory.createButton("logout", "Log Out", "Log
	// // Out", "logout", false,
	// // new IButtonListener() {
	// //
	// // @Override
	// // public void doAction() {
	// // actionLogout();
	// //
	// // }
	// // }, true);
	// }

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

	private Timeline blinkingTimeline;

	private Label debugLabel;

	private VBox messageBox;

	private Perspective perspective;

	private IRcplAddon activeUseCase;

	private VBox logPage;

	private TextArea errorTextArea;

	private TextArea logTextArea;

	protected HBox internalMainBottomArea;

	protected File lastDocumentFile = null;

	private IApplicationStarter applicationStarter;

	private boolean internalRemoteCDOServer = false;

	private HBox internalTopTrimBar;

	private VBox internalToolBarVBox;

	private String internalUserId;

	protected ISideToolBar internalSideToolbarControl;

	private StackPane internalLeftTrimBar;

	protected BorderPane internalBorderPane;

	private SplitPane internalSideToolBarSplitPane;

	private WebView internalHomeWebView;

	protected boolean internalInhibitUI = false;

	// @Override
	// public void recreateSideBar() {
	// IRcplPlugin useCase = getInternalActiveUsePlugin();
	// setInternalInhibitUI(true);
	// // String groupId = getSideToolBarControl().getActiveGroupId();
	// getSideToolBarControl().init();
	// setInternalInhibitUI(false);
	// getSideToolBarControl().show();
	// // getSideToolBarControl().setActiveGroupId(groupId);
	// getSideToolBarControl().showSideTools();
	// showPluginPerspective(useCase);
	// }

	// @Override
	// public void recreateTopBar() {
	// IRcplPlugin useCase = getInternalActiveUsePlugin();
	// setInternalInhibitUI(true);
	// getTopToolbarControl().init();
	// setInternalInhibitUI(false);
	// Perspective p = getActivePerspective();
	// if (p != null) {
	// // !!! 1
	// // getTopToolbarControl().show(p.getPerspectiveType());
	// }
	// showPluginPerspective(useCase);
	// }

	public double internalMouseDragOffsetX = 0;

	public double internalMouseDragOffsetY = 0;

	private Rectangle2D internalBackupWindowBounds;

	protected HTMLEditor internalHtmlEditor;

	protected IRcplAddon internalActivePlugin;

	protected TextFlow internalTitle;

	protected TabPane internalTabPane;

	protected StackPane internalHomeStackPane;

	protected ImageView internalHomeImageView;

	protected boolean internalFirstTimeHomePage = true;

	protected Parent internalParentTopBar = null;

	protected BorderPane internalParentParentTopBar = null;

	protected ITopToolbar internalTopToolBar;

	protected WebView internalWebView;

	public boolean internalDragMode;

	private String name;

	protected StackPane editorArea;

	private Node focusOwner;

	boolean requestCancel;

	protected long lastUsedMemory;

	public RcplUic(IApplicationStarter rcplApplicationStarter) {
		this(rcplApplicationStarter, "Rcpl");
	}

	public RcplUic(IApplicationStarter rcplApplicationStarter, String id) {

		this.applicationStarter = rcplApplicationStarter;
		this.name = id;
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
		Button returnButton = new Button("return");
		returnButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showOverviewPage();
			}
		});
		Button clearButton = new Button("clear");
		clearButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				errorTextArea.setText("");
				logTextArea.setText("");
				RCPLModel.clearLog();
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
		WELCOME_URL = RcplSession.getCodeBases().get(0) + "joffice_welcome.html";

	}

	@Override
	public void actionAddPresentationTab() {
	}

	// private IEditor getEditor(){
	// Tab tab = tabPane.getSelectionModel().getSelectedItem();
	// Object o = tab.getUserData();
	// if(o instanceof IEditor){
	// return (IEditor)o;
	// }
	// return null;
	// }

	// private static ChangeListener<Bounds> caretYListener;

	public void actionAddWebBrowserTab() {
		final Tab newTab = createNewTab("Google");
		newTab.setClosable(true);
		newTab.setId("webBrowserTab");
		final WebView newWebView = new WebView();
		newWebView.getEngine().setJavaScriptEnabled(true);
		newWebView.setEffect(new InnerShadow());
		newWebView.setUserData(newTab);
		newTab.setUserData(newWebView);
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
		updateButtons(false);
	}

	@Override
	public void actionLogout() {
		getRcplApplicationStarter().getRcplApplicationProvider().reStart();
	}

	@Override
	public void actionOpen() {
	}

	@Override
	public void actionOpenLast() {
	}

	/**
	 * @param rcplApplicationStarter
	 */

	public void actionPerspectivePresentation() {
		Perspective p = findPerspective("PRESENTATION");
		if (!"PRESENTATION".equals(getPerspective().getId())) {
			showPerspective(p.getId(), true);
		}
	}

	public void actionPerspectiveSettings() {
		if (!"SETTINGS".equals(getPerspective().getId())) {
			Perspective p = findPerspective("SETTINGS");
			if (p != null) {
				getSideToolBarControl().showPerspective(p, true);
				getTopToolbarControl().show("SETTINGS");
				showPerspective(RCPLModel.USE_CASE_CONTACTS_ID, true);
			}
		}
	}

	public void actionPerspectiveSpreadsheet() {
		Perspective p = findPerspective("SPREADSHEET");
		if (!"SPREADSHEET".equals(getPerspective().getId())) {
			showPerspective(p.getId(), true);
		}
	}

	public void actionPerspectiveWebbrowser() {
		Perspective p = findPerspective("WEB");
		if (!"WEB".equals(getPerspective().getId())) {
			showPerspective(p.getId(), true);
		}
	}

	public void actionPerspectiveWord() {
		try {
			Perspective p = findPerspective("WORD");
			if (!"WORD".equals(getPerspective().getId())) {
				showPerspective(p.getId(), true);
			}
		} catch (Throwable ex) {
			RCPLModel.logError(ex);
		}
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

	protected void addHomeButton(String id, String name, String toolTip, String image, boolean toggle) {
		IButton homeButton = new JOButton(id, name, toolTip, image, false);
		homeButton.setWidth(20);
		homeButton.setHeight(20);
		if (homeButtonsArea.getChildren().isEmpty()) {
			HBox.setMargin(homeButtonsArea, new Insets(-4, 0, 0, 48));
			homeButtonsArea.setSpacing(2);
		}
		homeButtonsArea.getChildren().add(homeButton.getNode());
	}

	@Override
	public void addtoApplicationStack(StackPane contentGroup) {
		contentGroup.getChildren().clear();
		contentGroup.getChildren().add(internalBorderPane);
	}

	protected void closeEditor(IEditor editor) {
		editorArea.getChildren().remove(editor.getMainPane());
		editor.dispose();
		getSideToolBarControl().setEditor(null);
		getTopToolbarControl().setEditor(null);
		for (IEditorListener l : Rcpl.getEditorListeners()) {
			l.setEditor(null);
		}
		System.gc();
	}

	public void closeTab(final Tab tab) {

		Object o = tab.getUserData();
		tab.setUserData(null);
		if (o instanceof IEditor) {

			final IEditor editor = (IEditor) o;
			final IDocument doc = editor.getDocument();

			if (internalTabPane.getTabs().isEmpty()) {
				showOverviewPage();
			}

			new DelayedExecution(200) {
				@Override
				protected void execute() {
					new Thread() {
						@Override
						public void run() {
							setName("CLOSE TAB");
							if (internalTabPane.getTabs().isEmpty()) {

								new WaitThread(editor) {

									@Override
									public void doRun() {
										showOverviewPage();
									}
								};

								RcplSession.getDefault().commit();
							}

							new DelayedExecution(200) {

								@Override
								protected void execute() {
									if (editor != null && editor.getDocument() != null) {
										editor.showPageGroup(false);
										closeEditor(editor);
										Rcpl.showProgress(false);

										new Thread("SAVE & CLOSE DOCUMENT") {
											@Override
											public void run() {
												doc.save();
												doc.dispose();

												printMemory("nach doc.dispose()    ");

											};
										}.start();
									}
								}
							};

						};
					}.start();
				}
			};

		}

	}

	@Override
	public void collapseAll() {
		getTopToolbarControl().collapse(true);
		expandLeftAra(false);
		expandTopAra(false);
		expandBottomAra(false);
	}

	protected void copyFXToInternal() {
		internalTabPane = tabPane;
		internalMainBottomArea = mainBottomArea;
	}

	protected IHomePage createAboutHomePage() {
		return new DefaultAboutHomePage(RcplUic.this, "joffice");
	}

	private void createBorderDragger() {
		if (!Rcpl.isMobile()) {
			internalBorderPane.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

					internalMouseDragOffsetX = event.getSceneX();
					internalMouseDragOffsetY = event.getSceneY();
				}
			});

			internalBorderPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Stage w = getStage();
					w.setX(event.getScreenX() - internalMouseDragOffsetX);
					w.setY(event.getScreenY() - internalMouseDragOffsetY);
				}
			});
		}
	}

	@Override
	public void createContent() {

		Rcpl.progressMessage(this.getClass().getName() + ".createContent()");

		internalHtmlEditor = new HTMLEditor();
		internalHtmlEditor.setPrefSize(2000, 2000);

		internalTitle = new TextFlow();

		Text txt_1 = new Text(name.substring(0, 1) + " ");
		txt_1.setFont(Font.font(null, FontWeight.BOLD, FontPosture.ITALIC, 18));
		Text txt_2 = new Text(name.substring(1));
		txt_1.setStyle("-fx-fill:linear-gradient(darkgray, gray)");
		txt_2.setFont(Font.font(null, FontWeight.BOLD, 16));
		// txt_2.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100%
		// 200%,
		// repeat, green 0%, seagreen 50%);"
		// + " -fx-stroke: darkgreen; -fx-stroke-width: 1;");

		txt_2.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, darkgray 0%, gray 50%);"
				+ " -fx-stroke: black; -fx-stroke-width: 0.2;");

		internalTitle.getChildren().addAll(txt_1, txt_2);
		HBox.setMargin(internalTitle, new Insets(4, 10, 0, -28));
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

	}

	protected IHomePage createNewHomePage() {
		return new DefaultNewHomePage(RcplUic.this, "office_new");
	}

	protected Tab createNewTab(String title) {
		return createNewTab(new Tab(), title);
	}

	protected Tab createNewTab(Tab tab, String title) {
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
			tab.setOnClosed(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					closeTab(tab);
				}
			});

			tabPane.getTabs().add(tab);

			double h = tabPane.getTabMinHeight();
			tabPane.setTabMinHeight(h + 1);
			tabPane.setTabMinHeight(h);

		} catch (Throwable ex) {
			RCPLModel.logError(ex);
		}
		return tab;
	}

	public void createPages() {

		if (overviewPage == null) {
			internalTitle.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					showAboutPage();
				}
			});

			overviewPage = Rcpl.getFactory().createOverviewHomePage(RcplUic.this, "My JOffice Cloud", "internet_cloud");

			perspectivePage = createPerspectivePage();

			samplesPage = createSamplesHomePage();
			newPage = createNewHomePage();

			whatsNewPage = Rcpl.getFactory().createWebHomePage(RcplUic.this, "What's New",
					RcplSession.getCodeBases().get(0) + "joffice_new_and_noteworthy.html", "office_whatsnew");

			String url = "http://85.25.100.163:8081/help/index.jsp";

			// if (JOSession.codeBase.endsWith("/")) {
			// helpUrl = JOSession.codeBase.substring(0,
			// JOSession.codeBase.length() - 1)
			// + ":8081/help/index.jsp";
			// }

			tutorialsPage = Rcpl.getFactory().createWebHomePage(RcplUic.this, "JOffice Help", url, "help");

			url = "http://joffice.eu/joffice_donation_text.html";
			donationPage = Rcpl.getFactory().createWebHomePage(RcplUic.this, "Donation", url, "donation");

			contactUsPage = Rcpl.getFactory().createContactUsHomePage(RcplUic.this, "Contact Us", "contact_us");

			preferencesPage = Rcpl.getFactory().createPreferencesHomePage(RcplUic.this, "Preferences",
					"preferences_clipart");

			aboutPage = createAboutHomePage();
		}

	}

	protected IHomePage createPerspectivePage() {
		return new DefaultPerspectiveHomePage(RcplUic.this);
	}

	private void createRecentDocumentList() {

		try {
			if (RcplSession.getDefault().getSystemPreferences() != null)

			{
				String lastDoc = RcplSession.getDefault().getSystemPreferences().getLastDocument();
				if (lastDoc != null && lastDoc.trim().length() > 0) {
					lastDocumentFile = new File(lastDoc);
				}
			}
		} catch (Exception ex) {

		}

	}

	protected IHomePage createSamplesHomePage() {
		return new DefaultSamplesHomePage(RcplUic.this, "office_samples");
	}

	private void createTitelArea() {
		titleText = new Text(getApplicationStarter().getVersionString() + " - " + RcplSession.getDefault().userId + " ("
				+ (RcplSession.getDefault().isOnline() ? "Online" : "Offline") + ")");
		titleText.setId("joffice_title_version");
		titleText.setOpacity(0.8);
		if (Rcpl.isMobile()) {
			titleArea.setAlignment(Pos.CENTER_LEFT);
		} else {
			titleArea.setAlignment(Pos.CENTER_RIGHT);
		}

		StackPane.setAlignment(titleText, Pos.TOP_LEFT);
		StackPane.setMargin(titleText, new Insets(7, 0, 0, 55));

	}

	protected void debugCollapsingAndHiding() {

		final ToggleButton top = new ToggleButton("T");
		top.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				getTopToolBarControl().collapse(!top.isSelected());
			}

		});
		mainTopArea.getChildren().add(1, top);

		final ToggleButton side = new ToggleButton("S");
		side.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!side.isSelected()) {
					getSideToolBarControl().collapseToolPane();

				} else {
					getSideToolBarControl().showSideTools();
				}
			}
		});
		mainTopArea.getChildren().add(2, side);

		final ToggleButton bottom = new ToggleButton("B");
		bottom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

			}
		});
		mainTopArea.getChildren().add(3, bottom);
	}

	protected void doCreateContent() {

		Rcpl.progressMessage("Rcpl.doCreateContent()");

		URL location = getClass().getResource("/org/eclipse/rcpl/ui/controler/rcpl_uic.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		fxmlLoader.setController(Rcpl.UIC);

		try {
			internalBorderPane = fxmlLoader.load();
			internalBorderPane.setCenter(editorArea);
			init(internalBorderPane);

		} catch (IOException e) {
			e.printStackTrace();
			// System.exit(1);
		}

		internalBorderPane.setRight(null);

		if (viewer) {
			internalBorderPane.setTop(null);
			internalBorderPane.setBottom(null);
			internalBorderPane.setLeft(null);
			return;
		}

		try {
			createTitelArea();
			createBorderDragger();
			updateWebViewDragger();
			createRecentDocumentList();

			updateTabPane();
			updateEditorListener();

			statusText.setText(getApplicationStarter().getVersionString());
		} catch (Exception ex) {
			RCPLModel.logError(ex);
		}

		if (Rcpl.isMobile()) {

			topArea.getChildren().remove(titleArea);
			topArea.getChildren().remove(titleText);

			internalBorderPane.setTop(titleArea);
			internalBorderPane.setBottom(null);

		}

		startMenuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showHomePage();
			}
		});

		Rcpl.showProgress(false);

	}

	protected void doCreateHomeButtons() {

		RCPL rcpl = RcplSession.getDefault().getRcpl();

		for (HomePage homePage : rcpl.getHomepages().getChildren()) {

			addHomeButton(homePage.getId(), homePage.getName(), homePage.getToolTip(), homePage.getImage(), false);

		}

//		addHomeButton(EnCommandId.homeShowOverview.name(), "My Cloud", "Show Documents in the Cloud", "internet_cloud",
//				false);
//		addHomeButton("homeShowNew", "New", "New Document", "office_new", false);
//
//		addHomeButton(EnCommandId.homeShowSamples.name(), "Samples", "Show Samples Page", "office_samples", false);
//
//		if (Rcpl.isBigDisplay()) {
//			if (!Rcpl.isMobile()) {
//				addHomeButton(EnCommandId.homeShowWhatsNew.name(), "What's New", "What's New", "office_whatsnew",
//						false);
//			}
//			addHomeButton(EnCommandId.homeShowPreferences.name(), "Preferences", "Preferences", "office_preferences",
//					false);
//
//			addHomeButton(EnCommandId.CONTACT_US.name(), "Contact Us", "Contact Us", "contact_us", false);
//
//			if (!Rcpl.isMobile()) {
//				addHomeButton(EnCommandId.homeShowDonation.name(), "Donation", "Show Donation Page", "donation", false);
//			}
//			addHomeButton(EnCommandId.homeShowTutorials.name(), "Help", "Show Help Page", "office_help", false);
//
//			addHomeButton(EnCommandId.homeShowAbout.name(), "About", "About", "joffice", false);
//		}

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

	// @Override
	// public String getUseCaseId() {
	// if (activeUseCase == null) {
	// return activeUseCaseId;
	// }
	// return activeUseCase.getEmfModel().getId();
	// }
	//
	// @Override
	// public void setActiveUseCaseId(String useCaseId) {
	// this.activeUseCaseId = useCaseId;
	//
	// }

	@Override
	public void expandBottomAra(final boolean expand) {

		if (!expand) {
			internalBorderPane.setBottom(null);
		} else {
			internalBorderPane.setBottom(internalMainBottomArea);
		}
		internalMainBottomArea.layout();

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
		try {
			String[] splits = id.split("/");
			String lastSegment = splits[splits.length - 1];
			for (IRcplAddon uc : applicationStarter.getRcplApplicationProvider().getRcplAddons()) {

				String id2 = uc.getId();

				if (lastSegment.equals(id2)) {
					return uc;
				}

				if (uc.getClass().getName().equals(id)) {
					return uc;
				}

			}
		} catch (Exception ex) {
			// TODO:
		}
		return null;

	}

	public IApplicationStarter getApplicationStarter() {
		return applicationStarter;
	}

	@Override
	public WebView getBrowser() {
		if (internalBorderPane.getCenter() == getInternalWebView()) {
			return getInternalWebView();
		}
		if (internalTabPane != null) {
			Tab tab = internalTabPane.getSelectionModel().getSelectedItem();
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
		if (internalTabPane == null) {
			return null;
		}
		if (internalTabPane.getSelectionModel().getSelectedItem() == null) {
			return null;
		}
		Object o = internalTabPane.getSelectionModel().getSelectedItem().getUserData();
		if (o instanceof IEditor) {
			return (IEditor) o;
		}
		return null;
	}

	@Override
	public Node getFocusOwner() {
		return focusOwner;
	}

	@Override
	public List<IHomePage> getHomepages() {
		return homepages;
	}

	protected IRcplAddon getInternalActiveUsePlugin() {
		return internalActivePlugin;
	}

	protected Rectangle2D getInternalBackupWindowBounds() {
		return internalBackupWindowBounds;
	}

	protected ImageView getInternalHomeImageView() {
		return internalHomeImageView;
	}

	protected StackPane getInternalHomeStackPane() {
		return internalHomeStackPane;
	}

	protected HTMLEditor getInternalHtmlEditor() {
		return internalHtmlEditor;
	}

	public WebView getInternalInternalHomeWebView() {
		return internalHomeWebView;
	}

	protected String getInternalUserId() {
		return internalUserId;
	}

	protected WebView getInternalWebView() {
		return internalWebView;
	}

	public StackPane getLeftTrimBar() {
		return internalLeftTrimBar;
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
	public INavigatorAddon getNavigator() {
		IRcplAddon rcplPlugin = Rcpl.rcplApplicationProvider.findRcplAddon(INavigatorAddon.class);
		if (rcplPlugin instanceof INavigatorAddon) {
			Parent parent = rcplPlugin.getNode().getParent();
			if (parent instanceof Pane) {
				((Pane) parent).getChildren().remove(rcplPlugin.getNode());
			}
			return (INavigatorAddon) rcplPlugin;
		}
		return null;
	}

	public IHomePage getOverviewPage() {
		return overviewPage;
	}

	@Override
	public Perspective getPerspective() {
		if (perspective == null) {
			perspective = RcplSession.PERSPECTIVE_OVERVIEW;
		}
		return perspective;
	}

	public IApplicationStarter getRcplApplicationStarter() {
		return applicationStarter;
	}

	@Override
	public ISideToolBar getSideToolBarControl() {

		if (internalSideToolbarControl == null) {
			internalSideToolbarControl = Rcpl.getFactory().createSideToolBar(Rcpl.UIC.getMainLeftArea());
		}

		return internalSideToolbarControl;
	}

	public SplitPane getSideToolBarSplitPane() {
		return internalSideToolBarSplitPane;
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
		return internalTabPane;
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
	public ITopToolbar getTopToolBarControl() {
		return getTopToolbarControl();
	}

	public HBox getTopTrimBar() {
		return internalTopTrimBar;
	}

	@Override
	public IRcplAddon getUseCase() {
		return activeUseCase;
	}

	@FXML
	public void handleClose(ActionEvent event) {
		RcplSession.getDefault().getSystemPreferences().put(RcplKey.STAGE_X, "" + getStage().getX());
		RcplSession.getDefault().getSystemPreferences().put(RcplKey.STAGE_Y, "" + getStage().getY());
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
			if (internalBackupWindowBounds != null) {
				stage.setX(internalBackupWindowBounds.getMinX());
				stage.setY(internalBackupWindowBounds.getMinY());
				stage.setWidth(internalBackupWindowBounds.getWidth());
				stage.setHeight(internalBackupWindowBounds.getHeight());
			}
		} else {
			internalBackupWindowBounds = new Rectangle2D(stage.getX(), stage.getY(), stage.getWidth(),
					stage.getHeight());
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

	public void hideTopBar() {
		if (internalParentTopBar == null) {
			internalParentTopBar = internalTopTrimBar.getParent();
			internalParentParentTopBar = (BorderPane) internalParentTopBar.getParent();
		}
		internalParentParentTopBar.setTop(null);
	}

	@Override
	public void init(BorderPane parent) {
		copyFXToInternal();
		internalBorderPane = parent;
		internalTabPane = tabPane;
		internalMainBottomArea = mainBottomArea;
		// internalTabPane.setStyle("-fx-open-tab-animation: NONE;
		// -fx-close-tab-animation: NONE;");
		tabPane.setPrefSize(10, 10);
	}

	@Override
	public boolean initSession(RcplLogin login) {

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
			max = RcplSession.getDefault().getSystemPreferences().getDouble(RcplKey.MAX_PROGRESS);
			if (max > 0) {
				// Rcpl.UIC.setProgressMax(max);
			}
		}

		Rcpl.progressMessage("Migrate Model");
		new RcplMigration().migrate();

		Rcpl.progressMessage("Register Services");
		registerServices();

		RcplSession.getDefault().setPassword(null);

		// new JOPointToPixelCalculator().init();

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
		if (overviewPage == null) {
			return true;
		}
		return internalBorderPane.getCenter() == overviewPage.getNode();
	}

	@Override
	public boolean isInhibitUI() {
		return internalInhibitUI;
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
	public void openTemplate(String name, String tabName) {
	}

	// protected IUndoRedoListener getInternalUndoRedoListener() {
	// if (internalUndoRedoListener == null) {
	// internalUndoRedoListener = Rcpl.getFactory().createUndoRedoTool();
	// HBox.setMargin((Node) internalUndoRedoListener, new Insets(0, 10, 0,
	// 10));
	// }
	// return internalUndoRedoListener;
	// }

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
	public void recreateSideBar() {
		internalInhibitUI = true;
		getSideToolBarControl().init();
		internalInhibitUI = false;
		getSideToolBarControl().showPerspective(Rcpl.UIC.getPerspective(), false);
		getSideToolBarControl().showSideTools();
		showPluginPerspective(internalActivePlugin);
	}

	@Override
	public void recreateTopBar() {
		internalInhibitUI = true;
		getTopToolbarControl().init();
		internalInhibitUI = false;
		String p = Rcpl.UIC.getPerspective().getId();
		getTopToolbarControl().show(p);
		showPluginPerspective(internalActivePlugin);
	}

	protected void registerServices() {
	}

	public void removeAllSideToolBars() {
		internalToolBarVBox.getChildren().remove(1);
		while (internalToolBarVBox.getChildren().size() > 1) {
			internalToolBarVBox.getChildren().remove(1);
		}
	}

	protected void removeAllStyles() {
		for (String style : internalStylesRegistry) {
			getStage().getScene().getStylesheets().remove(style);
		}
	}

	@Override
	public void restorePerspective() {
		updatePerspective(tabPane.getSelectionModel().getSelectedItem());
	}

	@Override
	public void restoreTab() {
		Tab tab = internalTabPane.getSelectionModel().getSelectedItem();
		if (tab == null) {
			// showHomePage();
		} else {
			showTab(tab);
		}
	}

	@Override
	public void setContent(IEditor editor) {
		setEditor(editor);
	}

	@Override
	public void setContent(Node node) {
		for (IHomePage h : getHomepages()) {
			if (node == h.getNode()) {
				showHomeButtons(true);
				doSetContent(node);
				return;
			}
		}
		showHomeButtons(false);
		doSetContent(node);
		;
	}

	public void doSetContent(final Node node) {

		new WaitThread(null) {

			@Override
			public void doRun() {
				if (node == null) {
					editorArea.getChildren().clear();
					return;
				}
				if (!editorArea.getChildren().contains(node)) {
					editorArea.getChildren().add(node);
				}
				node.toFront();
			}
		};
	}

	@Override
	public void setDebugText(String text) {
		if (debugLabel != null) {
			debugLabel.setText(text);
		}
	}

	protected void setEditor(IEditor editor) {
		getTopToolbarControl().setEditor(editor);
		getTopToolbarControl().setEditor(editor);
		for (IEditorListener l : Rcpl.getEditorListeners()) {
			l.setEditor(editor);
		}
		if (editor == null) {
			setContent((Node) null);
			return;
		}
		setContent(editor.getMainPane());
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
		this.internalLeftTrimBar = leftTrimBar;
	}

	@Override
	public void setPerspective(Perspective perspective) {
		if (perspective == null) {
			System.out.println();
		}
		this.perspective = perspective;
	}

//	private void initEcoreFile_OSGi() {
//
//		String installDir = "";
//
//		 try {
//		 if (JOSession.ENV_DEV) {
//		
//		 File f = new
//		 File(ResourcesPlugi.getWorkspace().getRoot().getLocation().toOSString());
//		
//		 f = new File(f.getParentFile(),
//		 "joffice_migration_1/org.eclipse.rcpl.build/installer/components/conf");
//		
//		 installDir = f.getAbsolutePath() + "/";
//		
//		 } else {
//		 try {
//		 installDir =
//		 org.eclipse.core.runtime.Platform.getInstallLocation().getDataArea("/").getPath();
//		
//		 } catch (IOException e1) {
//		
//		 }
//		 }
//		 } catch (Throwable ex) {
//		
//		 }
//
//	}

	@Override
	public void setPerspective(Perspective activePerspective, IRcplAddon useCase) {
		this.perspective = activePerspective;
		this.activeUseCase = useCase;
		// if (useCase != null) {
		// this.activeUseCaseId = useCase.getEmfModel().getId();
		// }
	}

	@Override
	public void setStatusText(String text) {
		statusText.setText(text);
	}

	@Override
	public void setTopAreaHeight(double height) {
		mainTopArea.setMaxHeight(height);
		mainTopArea.setMinHeight(height);
		mainTopArea.setPrefHeight(height);
		if (height <= 30) {
			height = 0;
		}
		mainTopStack.setMaxHeight(height);
		mainTopStack.setMinHeight(height);
		mainTopStack.setPrefHeight(height);
	}

	@Override
	public void setTopContent(Node content) {
		internalBorderPane.setTop(content);
	}

	@Override
	public void setUseCase(IRcplAddon useCase) {
		this.activeUseCase = useCase;
	}

	@Override
	public void setViewer(boolean viewer) {
		this.viewer = viewer;
	}

	@Override
	public void showAboutPage() {
		createPages();
		setContent(aboutPage.getNode());
		updateButtons(true);
	}

	@Override
	public boolean showBrowser() {
		Object o = internalTabPane.getSelectionModel().getSelectedItem().getUserData();
		if (o instanceof WebView) {
			WebView webView = (WebView) internalTabPane.getSelectionModel().getSelectedItem().getUserData();
			if (webView != null) {
				setEditor(null);
				setContent(webView);
				return true;
			}
		} else if ("homeTab".equals(o)) {
			showHomePage();
		}
		return false;
	}

	@Override
	public void showContactUsPage() {
		createPages();
		setContent(contactUsPage.getNode());
		updateButtons(true);
	}

	@Override
	public void showDonationPage() {
		createPages();
		setContent(donationPage.getNode());
		updateButtons(true);
		// donationPage.refresh();

		// Application app = (Application)
		// getRcplApplicationStarter().getRcplApplicationProvider();
		// HostServicesDelegate hostServices =
		// HostServicesFactory.getInstance(app);
		// hostServices.showDocument("http://joffice.eu/joffice_donation.html");
	}

	@Override
	public void showErrorPage() {
		errorTextArea.setText(RCPLModel.errorBuf.toString());
		logTextArea.setText(RCPLModel.logBuf.toString());
		setContent(logPage);
	}

	private void showHomeButtons(boolean show) {

		if (show) {
			if (homeButtonsArea.getChildren().isEmpty()) {
				doCreateHomeButtons();
			}
		} else {
			homeButtonsArea.getChildren().clear();
		}

	}

	@Override
	public void showHomePage() {
		createPages();
		showHomePage(-1);
		updateButtons(true);
	}

	public void showHomePage(final int imageIndex) {

		showOverviewPage();

	}

	@Override
	public boolean showHtmlEditor() {
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
				setContent(internalHtmlEditor);
				internalHtmlEditor.setHtmlText(html);
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

	@Override
	public void showNewPage() {
		createPages();
		setContent(newPage.getNode());
		updateButtons(true);
	}

	@Override
	public void showOverviewPage() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				createPages();
				if (overviewPage != null) {
					setContent(overviewPage.getNode());
				}

				getSideToolBarControl().showHomeTools();

				setPerspective(RcplSession.PERSPECTIVE_OVERVIEW);

			}
		});

	}

	/**
	 * @param id
	 */
	@Override
	public boolean showPerspective(String id, boolean asEditor) {
		IRcplAddon uc = findRcplAddons(id);
		if (uc != null) {
			if (uc.getEmfModel() != null) {
				uc.setAsEditor(asEditor);
				if (asEditor) {
					showPluginInEditor(uc);
				} else {
					setContent(uc.getNode());
				}
				updateButtons(false);
				uc.getNode().setVisible(true);
				if (internalActivePlugin != null && id.equals(internalActivePlugin.getId())) {
					return false;
				}
				internalActivePlugin = uc;

				getTopToolbarControl().show(internalActivePlugin);

				return true;
			} else {
				uc.getNode().setVisible(false);
			}
			return true;
		}

		Perspective perspective = findPerspective(id);
		if (perspective != null) {
			Rcpl.UIC.setPerspective(perspective);
			getSideToolBarControl().showPerspective(perspective, false);
			showPerspectivePage();
		}
		return false;
	};

	@Override
	public void showPerspectivePage() {
		createPages();
		setContent(perspectivePage.getNode());
		updateButtons(true);
	}

	private void showPluginInEditor(IRcplAddon rcplPlugin) {
		final Tab newTab = createNewTab(rcplPlugin.getEmfModel().getName());
		newTab.setGraphic(Rcpl.resources().getImage("contact", 16, 16).getNode());
		newTab.setClosable(true);
		internalTabPane.getSelectionModel().select(newTab);
		setContent(rcplPlugin.getNode());
		newTab.setUserData(rcplPlugin);
		updateButtons(false);
		updatePerspective(newTab);
	}

	public boolean showPluginPerspective(IRcplAddon rcplPlugin) {
		return showPerspective(rcplPlugin.getId(), rcplPlugin.isAsEditor());
	}

	/**
	 * 
	 */
	@Override
	public void showPreferencesPage() {
		createPages();
		if (preferencesPage != null) {
			setContent(preferencesPage.getNode());
		}

		// quickToolsArea.getChildren().removeAll((Node) saveAsButton.getNode(),
		// (Node) saveButton.getNode(),
		// (Node) getInternalUndoRedoListener());
		// getTopToolbarControl().show((PerspectiveType) null);
		// getSideToolBarControl().show((PerspectiveType) null, true);
		// getSideToolBarControl().collapseToolBar();
		updateButtons(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcpl.IUIC#showSamplesPage()
	 */
	@Override
	public void showSamplesPage() {
		createPages();
		setContent(samplesPage.getNode());
		updateButtons(true);
	}

	@Override
	public void showStartMenuButton(boolean show) {
		startMenuButton.setDisable(!show);
	}

	protected void showTab(final Tab tab) {
		try {

			Object o = tab.getUserData();
			IEditor edit = null;
			if (o instanceof IEditor) {
				edit = (IEditor) o;
			}
			final IEditor editor = edit;

			new Thread() {

				@Override
				public void run() {
					new WaitThread(editor) {

						@Override
						public void doRun() {
							updatePerspective(tab);
						}
					};
					try {
						sleep(10);
					} catch (InterruptedException e) {
					}

					new WaitThread(editor) {

						@Override
						public void doRun() {
							Object o = tab.getUserData();
							if (o instanceof IEditor) {
								final IEditor editor = (IEditor) o;
								setContent(editor);
							} else if (o instanceof Node) {
								setContent((Node) o);
								setEditor(null);
							} else if (o instanceof IRcplAddon) {
								setContent(((IRcplAddon) o).getNode());
								setEditor(null);
							}
						}
					};

				};
			}.start();

		} catch (Throwable ex) {
			RCPLModel.logError(ex);
		}
	}

	/**
	  *
	  */
	@Override
	public void showTabPane() {
		try {
			updateButtons(false);
			if (internalActivePlugin != null && !internalActivePlugin.isAsEditor()) {
				internalActivePlugin.getNode().setVisible(false);
				internalActivePlugin = null;
			}
			restoreTab();
		} catch (Throwable ex) {
			RCPLModel.logError(ex);
		}
	}

	@Override
	public void showTutorialsPage() {
		createPages();
		setContent(tutorialsPage.getNode());
		updateButtons(true);
		tutorialsPage.refresh();
	}

	/**
	 * 
	 */

	public boolean showUseCase() {
		if (internalActivePlugin != null && internalActivePlugin.getId().length() > 0) {
			return showPluginPerspective(internalActivePlugin);
		}
		return false;
	}

	@Override
	public void showWebView(String url) {
		updateButtons(false);

		setContent(internalWebView);
		internalWebView.getEngine().load(url);
	}

	@Override
	public void showWhatsNewPage() {
		createPages();
		setContent(whatsNewPage.getNode());
		updateButtons(true);
	}

//	protected abstract void updateButtons(boolean update);

	public void updateButtons(boolean home) {
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

	public void updatePerspective(Tab tab) {
		try {
			if (tab == null) {
				return;
			}
			Object o = tab.getUserData();
			if (o instanceof IRcplAddon) {
				getSideToolBarControl().showPerspective(((IRcplAddon) o).getEmfModel().getDefaultPerspective(), true);
				getTopToolbarControl().show((IRcplAddon) o);
				getTopToolbarControl().updateUseCaseHeight();
			}
			// if (tab.getContent() instanceof WebView) {
			// JO.officePane.setBrowser((WebView) tab.getContent());
			// actionPerspectiveWebbrowser();
			// JO.officePane.setEditor(null);
			// } else
			{
				if (o instanceof WebView) {
					actionPerspectiveWebbrowser();
				} else {
					if (o instanceof IEditor) {

						IEditor e = (IEditor) o;

						if (e.getDocument() != null && e.getDocument().getDefaultPerspective() != null) {
							if ("PRESENTATION".equals(e.getDocument().getDefaultPerspective())) {
								actionPerspectivePresentation();
							} else if ("SETTINGS".equals(e.getDocument().getDefaultPerspective())) {
								actionPerspectiveSettings();
							} else if ("SPREADSHEET".equals(e.getDocument().getDefaultPerspective())) {
								actionPerspectiveSpreadsheet();
							} else if ("WEB".equals(e.getDocument().getDefaultPerspective())) {
								actionPerspectiveWebbrowser();
							} else if ("WORD".equals(e.getDocument().getDefaultPerspective())) {
								actionPerspectiveWord();
							} else if ("USECASE".equals(e.getDocument().getDefaultPerspective())) {
							}
						}

					}
				}

				getTopToolbarControl().updateHeight();
			}

			if (getBrowser() != null) {
				urlAddressTool.setText(getBrowser().getEngine().getLocation());
			}
		} catch (Exception ex) {

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
			RCPLModel.logError(ex);
		}
	}

	private void updateTabPane() {

		tabPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (!internalDragMode) { // && isHome()) {
					showTabPane();
				}
				internalDragMode = false;
			}
		});

		if (Rcpl.isBigDisplay()) {

			tabPane.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					internalMouseDragOffsetX = event.getSceneX();
					internalMouseDragOffsetY = event.getSceneY();

				}
			});

			tabPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					internalMouseDragOffsetX = event.getSceneX();
					internalMouseDragOffsetY = event.getSceneY();
				}
			});

			tabPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Stage w = getStage();
					w.setX(event.getScreenX() - internalMouseDragOffsetX);
					w.setY(event.getScreenY() - internalMouseDragOffsetY);
					internalDragMode = true;
				}
			});
		}
	}

	private void updateWebViewDragger() {
		if (!Rcpl.isMobile()) {
			getInternalWebView().setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					internalMouseDragOffsetX = event.getSceneX();
					internalMouseDragOffsetY = event.getSceneY();
				}
			});

			getInternalWebView().setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					if (event.isControlDown()) {
						Stage w = getStage();
						w.setX(event.getScreenX() - internalMouseDragOffsetX);
						w.setY(event.getScreenY() - internalMouseDragOffsetY);
					}
				}
			});
		}
	}

}