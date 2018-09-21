package org.eclipse.rcpl;

import java.io.File;
import java.net.URL;

import org.eclipse.rcpl.libs.db.H2DB;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;

import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author ramin
 *
 */
public interface IRcplUic {

	boolean isTopToolbarCollapsed();

	void openDocument(URL url);

	void closeApplication();

	void addRecentDocument(File file, boolean commit);

	double getScale();

	void setScale(double scale);

	StackPane getProgressArea();

	HBox getEditorWindowTools();

	H2DB getH2DB();

	StackPane getEditorArea();

	IDetailPage getWebBrowserDetailPage();

	IDetailPage getDetailPage(String className);

	void putDetailPage(String className, IDetailPage detailPage);

	ITreePart getRcplTreepart();

	ITreePart getApplicationTreepart();

	public void createAllHomeButtons(Pane pane);

	void addHomePageButton(HomePage homePage, Pane pane, ToggleGroup toggleGroup);

	void collapseMainTopArea(boolean collapse);

	void createContent();

	void createHomePages();

	IHomePage findHomePage(HomePageType type, String id);

	void actionLogout();

	void openDocumentWithFileDialog();

	void openLastDocument();

	void addtoApplicationStack(StackPane contentGroup);

	void collapseAll();

	void expandAllToolBars();

	void expandBottomAra(boolean expand);

	void expandLeftAra(boolean expand);

	void expandTopAra(boolean epand);

	Perspective findPerspective(String id);

	IRcplAddon findRcplAddons(String id);

	WebView getBrowser();

	IEditor getEditor();

	Node getFocusOwner();

	HBox getMainBottomArea();

	HBox getMainLeftArea();

	VBox getMainLeftBox();

	HBox getMainTopArea();

	StackPane getMainTopStack();

	Perspective getPerspective();

	ISideToolBar getSideToolBarControl();

	Stage getStage();

	ITopToolbar getTopToolBar();

	IRcplAddon getActiveAddon();

	void init(BorderPane parent);

	public boolean initSession(ILogin login);

	boolean isHome();

	boolean isInhibitUI();

	boolean isViewer();

	void openDocument(File file);

	void openTemplateDocument(String name, String tabName);

	void recreateSideBar();

	void recreateTopBar();

	void restorePerspective();

	void setPerspective(Perspective perspective, IRcplAddon useCase);

	void setActiveAddon(IRcplAddon useCase);

	void setContent(Node node);

	void setDebugText(String text);

	void setInhibitUI(boolean inhibitUI);

	void setLeftTrimBar(StackPane perspectiveToolSideBarStackPane);

	void setPerspective(Perspective perspective);

	void setStatusText(String text);

	void setTopAreaHeight(double height);

	void setTopContent(Node content);

	void setViewer(boolean viewer);

	boolean showBrowser();

	void showErrorPage();

	boolean showPerspective(Perspective perspective);

	void showStartMenuButton(boolean show);

	void showWebView(String url);

	void updateStartMenuButton();

	IApplicationStarter getApplicationStarter();

	void showHomePage(HomePageType type, String id);

	IHomePage getActiveHomePage();
}
