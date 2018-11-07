package org.eclipse.rcpl.ui.controler;

import java.io.File;
import java.net.URL;

import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IButton;
import org.eclipse.rcpl.IDetailPage;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.ILogin;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.ISideToolBar;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.ITopToolbar;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.internal.tools.ComboBoxTool;
import org.eclipse.rcpl.internal.tools.SplitMenuTool;
import org.eclipse.rcpl.internal.tools.TextFieldTool;
import org.eclipse.rcpl.internal.tools.WebBrowserTool;
import org.eclipse.rcpl.libs.db.H2DB;
import org.eclipse.rcpl.model.EnKeyValue;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;

import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class RcplUicAdapter implements IRcplUic {

	@Override
	public boolean updateToggleButton(IEditor editor, EnCommandId commandId, EnKeyValue keyValue, boolean update) {
		return false;
	}

	@Override
	public void sideBarLoaded(Perspective perspective) {
	}

	@Override
	public void save() {
	}

	@Override
	public void saveAs() {
	}

	@Override
	public ITool findTool(ToolType type) {
		return null;
	}

	@Override
	public ITool findTool(ToolType type, String id) {
		return null;
	}

	@Override
	public WebBrowserTool findWebBrowserTool(String id) {
		return null;
	}

	@Override
	public SplitMenuTool findSplitMenuTool(String id) {
		return null;
	}

	@Override
	public ComboBoxTool findComboBoxTool(String id) {
		return null;
	}

	@Override
	public IButton findButtonTool(String id) {
		return null;
	}

	@Override
	public TextFieldTool findTextFieldTool(String id) {
		return null;
	}

	@Override
	public boolean isTopToolbarCollapsed() {
		return false;
	}

	@Override
	public void openDocument(URL url) {
	}

	@Override
	public void closeApplication() {
	}

	@Override
	public void addRecentDocument(File file) {
	}

	@Override
	public double getScale() {
		return 0;
	}

	@Override
	public void setScale(double scale) {
	}

	@Override
	public StackPane getProgressArea() {
		return null;
	}

	@Override
	public H2DB getH2DB() {
		return null;
	}

	@Override
	public IDetailPage getWebBrowserDetailPage() {
		return null;
	}

	@Override
	public IDetailPage getDetailPage(String className) {
		return null;
	}

	@Override
	public void putDetailPage(String className, IDetailPage detailPage) {
	}

	@Override
	public ITreePart getRcplTreepart() {
		return null;
	}

	@Override
	public ITreePart getApplicationTreepart() {
		return null;
	}

	@Override
	public void createAllHomeButtons(Pane pane) {
	}

	@Override
	public void addHomePageButton(HomePage homePage, Pane pane, ToggleGroup toggleGroup) {
	}

	@Override
	public void collapseMainTopArea(boolean collapse) {
	}

	@Override
	public void createContent() {
	}

	@Override
	public void createHomePages() {
	}

	@Override
	public IHomePage findHomePage(HomePageType type, String id) {
		return null;
	}

	@Override
	public void actionLogout() {
	}

	@Override
	public void openDocumentWithFileDialog() {
	}

	@Override
	public void openLastDocument() {
	}

	@Override
	public void addtoApplicationStack(StackPane contentGroup) {
	}

	@Override
	public void collapseAll() {
	}

	@Override
	public void expandAllToolBars() {
	}

	@Override
	public void expandBottomAra(boolean expand) {
	}

	@Override
	public void expandLeftAra(boolean expand) {
	}

	@Override
	public void expandTopAra(boolean epand) {
	}

	@Override
	public Perspective findPerspective(String id) {
		return null;
	}

	@Override
	public IRcplAddon findRcplAddons(String id) {
		return null;
	}

	@Override
	public WebView getBrowser() {
		return null;
	}

	@Override
	public IEditor getEditor() {
		return null;
	}

	@Override
	public Node getFocusOwner() {
		return null;
	}

	@Override
	public HBox getMainBottomArea() {
		return null;
	}

	@Override
	public HBox getMainLeftArea() {
		return null;
	}

	@Override
	public VBox getMainLeftBox() {
		return null;
	}

	@Override
	public HBox getMainTopArea() {
		return null;
	}

	@Override
	public StackPane getMainTopStack() {
		return null;
	}

	@Override
	public Perspective getPerspective() {
		return null;
	}

	@Override
	public ISideToolBar getSideToolBarControl() {
		return null;
	}

	@Override
	public Stage getStage() {
		return null;
	}

	@Override
	public ITopToolbar getTopToolBar() {
		return null;
	}

	@Override
	public IRcplAddon getActiveAddon() {
		return null;
	}

	@Override
	public void init(BorderPane parent) {
	}

	@Override
	public boolean initSession(ILogin login) {
		return false;
	}

	@Override
	public boolean isHome() {
		return false;
	}

	@Override
	public boolean isInhibitUI() {
		return false;
	}

	@Override
	public boolean isViewer() {
		return false;
	}

	@Override
	public void openDocument(File file) {
	}

	@Override
	public void openTemplateDocument(String name, String tabName) {
	}

	@Override
	public void recreateSideBar() {
	}

	@Override
	public void recreateTopBar() {
	}

	@Override
	public void restorePerspective() {
	}

	@Override
	public void setPerspective(Perspective perspective, IRcplAddon useCase) {
	}

	@Override
	public void setActiveAddon(IRcplAddon useCase) {
	}

	@Override
	public void setContent(Node node) {
	}

	@Override
	public void setDebugText(String text) {
	}

	@Override
	public void setInhibitUI(boolean inhibitUI) {
	}

	@Override
	public void setLeftTrimBar(StackPane perspectiveToolSideBarStackPane) {
	}

	@Override
	public void setPerspective(Perspective perspective) {
	}

	@Override
	public void setStatusText(String text) {
	}

	@Override
	public void setTopAreaHeight(double height) {
	}

	@Override
	public void setTopContent(Node content) {
	}

	@Override
	public void setViewer(boolean viewer) {
	}

	@Override
	public boolean showBrowser() {
		return false;
	}

	@Override
	public void showErrorPage() {
	}

	@Override
	public boolean showPerspective(Perspective perspective) {
		return false;
	}

	@Override
	public void showStartMenuButton(boolean show) {
	}

	@Override
	public void showWebView(String url) {
	}

	@Override
	public void updateStartMenuButton() {
	}

	@Override
	public IApplicationStarter getApplicationStarter() {
		return null;
	}

	@Override
	public void showHomePage(HomePageType type, String id) {
	}

	@Override
	public IHomePage getActiveHomePage() {
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
