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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.cdo.client.RcplKey;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLDocument;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author ramin
 *
 */
public abstract class RcplAbstractUic implements IRcplUic {

	private Perspective perspective;

	private IRcplAddon activeUseCase;

	@Override
	public Perspective getPerspective() {
		if (perspective == null) {
			perspective = RcplSession.PERSPECTIVE_OVERVIEW;
		}
		return perspective;
	}

	@Override
	public void setPerspective(Perspective perspective) {
		if (perspective == null) {
			System.out.println();
		}
		this.perspective = perspective;
	}

	@Override
	public void setPerspective(Perspective activePerspective, IRcplAddon useCase) {
		this.perspective = activePerspective;
		this.activeUseCase = useCase;
		// if (useCase != null) {
		// this.activeUseCaseId = useCase.getEmfModel().getId();
		// }
	}

	@Override
	public IRcplAddon getUseCase() {
		return activeUseCase;
	}

	@Override
	public void setUseCase(IRcplAddon useCase) {
		this.activeUseCase = useCase;
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

	public static List<String> internalStylesRegistry = null;

	public static String internalStyleMsOffice;

	public static String internalStyleWindows7;

	public static String internalStyleDark;

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

	protected static void setInternalStyleDark(String internalStyleDark) {
		RcplAbstractUic.internalStyleDark = internalStyleDark;
	}

	protected static void setInternalStyleMsOffice(String internalStyleMsOffice) {
		RcplAbstractUic.internalStyleMsOffice = internalStyleMsOffice;
	}

	protected static void setInternalStylesRegistry(List<String> internalStylesRegistry) {
		RcplAbstractUic.internalStylesRegistry = internalStylesRegistry;
	}

	protected static void setInternalStyleWindows7(String internalStyleWindows7) {
		RcplAbstractUic.internalStyleWindows7 = internalStyleWindows7;
	}

	@Override
	public void addtoApplicationStack(StackPane contentGroup) {
		contentGroup.getChildren().clear();
		contentGroup.getChildren().add(internalBorderPane);
	}

	private VBox logPage;
	private TextArea errorTextArea;

	private TextArea logTextArea;

	protected HBox internalMainBottomArea;

	protected File lastDocumentFile = null;

	private IApplicationStarter rcplApplicationStarter;

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

	/**
	 * @param rcplApplicationStarter
	 */
	public RcplAbstractUic(IApplicationStarter rcplApplicationStarter, final String name) {
		this.rcplApplicationStarter = rcplApplicationStarter;
		this.name = name;
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
	}

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

	boolean requestCancel;

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

	protected long lastUsedMemory;

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

	@Override
	public void collapseAll() {
		getTopToolbarControl().collapse(true);
		expandLeftAra(false);
		expandTopAra(false);
		expandBottomAra(false);
	}

	protected abstract void copyFXToInternal();

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

	protected abstract Tab createNewTab(String title);

	protected abstract void doCreateContent();

	protected abstract void doInitStyles();

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
	public void expandTopAra(boolean expand) {
		getTopToolbarControl().collapse(!expand);
	}

	@Override
	public IRcplAddon findRcplAddons(String id) {
		try {
			String[] splits = id.split("/");
			String lastSegment = splits[splits.length - 1];
			for (IRcplAddon uc : rcplApplicationStarter.getRcplApplicationProvider().getRcplAddons()) {

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

	// protected IUndoRedoListener getInternalUndoRedoListener() {
	// if (internalUndoRedoListener == null) {
	// internalUndoRedoListener = Rcpl.getFactory().createUndoRedoTool();
	// HBox.setMargin((Node) internalUndoRedoListener, new Insets(0, 10, 0,
	// 10));
	// }
	// return internalUndoRedoListener;
	// }

	protected String getInternalUserId() {
		return internalUserId;
	}

	protected WebView getInternalWebView() {
		return internalWebView;
	}

	public StackPane getLeftTrimBar() {
		return internalLeftTrimBar;
	}

	public IApplicationStarter getRcplApplicationStarter() {
		return rcplApplicationStarter;
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
		return rcplApplicationStarter.getRcplApplicationProvider().getPrimaryStage();
	}

	@Override
	public String getStyleMsOffice() {
		return internalStyleMsOffice;
	}

	@Override
	public List<String> getStylesRegistry() {
		return internalStylesRegistry;
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

	public HBox getTopTrimBar() {
		return internalTopTrimBar;
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
		this.internalBorderPane = parent;
		copyFXToInternal();
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
		return internalBorderPane.getCenter() == internalHomeStackPane;
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

	protected abstract void registerServices();

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
	public void restoreTab() {
		Tab tab = internalTabPane.getSelectionModel().getSelectedItem();
		if (tab == null) {
			// showHomePage();
		} else {
			showTab(tab);
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
	};

	@Override
	public void setLeftTrimBar(StackPane leftTrimBar) {
		this.internalLeftTrimBar = leftTrimBar;
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
	public void showErrorPage() {
		errorTextArea.setText(RCPLModel.errorBuf.toString());
		logTextArea.setText(RCPLModel.logBuf.toString());
		setContent(logPage);
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

	protected abstract void updateButtons(boolean update);

	protected void updatePerspective(Tab tab) {
		if (tab == null) {
			return;
		}
		Object o = tab.getUserData();
		if (o instanceof IRcplAddon) {
			getSideToolBarControl().showPerspective(((IRcplAddon) o).getEmfModel().getDefaultPerspective(), true);
			getTopToolbarControl().show((IRcplAddon) o);
			getTopToolbarControl().updateUseCaseHeight();
		}

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

	@Override
	public void setContent(IEditor editor) {
		setEditor(editor);
	}

	@Override
	public void setContent(final Node node) {

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
	public Node getFocusOwner() {
		return focusOwner;
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
}
