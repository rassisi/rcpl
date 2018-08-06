package org.eclipse.rcpl;

import java.io.File;
import java.util.HashMap;

import org.eclipse.rcpl.libs.db.H2DB;
import org.eclipse.rcpl.model.IResources;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 * 
 */
public interface IRcplFactory {

	H2DB createH2DB();

	ILogin createLoginDialog(IRcplApplicationProvider applicationProvider);

	IButton createHomePageButton(HomePage homePage);

	IModelManager createRcplTreeManager();

	IModelManager createApplicationTreeManager();

	ITreePart createRcplTreePart();

	ITreePart createApplicationTreePart();

	IStyleTemplate createStyleTemplate();

//	IButton createButton(String id, String name, String toolTip, String imageName, boolean toggle,
//			IButtonListener buttonListener, boolean systemButton);
//
//	IButton createButton(ToolGroup g, boolean toggle, boolean systemButton, IButtonListener buttonListener);

	IButton createButton(AbstractTool t);

	Node createRibbonGroup(ToolGroup group, IRcplAddon useCase, boolean first, boolean dialogButton);

	ICommand createCommand(ITool tool);

	IUndoRedoListener createUndoRedoTool();

	IEditor createEditor(File file, Tab tab, HashMap<String, String> wordReplacements, boolean onePage);

	IEditor createEditor(Tab tab, boolean isBrowser);

	ISideToolBar createSideToolBar(HBox hbox);

	ITopToolbar createTopToolBar(StackPane stackPane);

	IHomePage createHomePage(IRcplUic uic, HomePage modelHomePage);

	Perspective createPerspective(String id, String name, String image);

	IResources createResources();

	IColorProvider createColorProvider();

	IFontProvider createFontProvider();

	IService createService();

	ICommand createCommand(EnCommandId commandId, ILayoutObject layoutObject, Object[] oldData, Object... newData);

	ICommand createCommand(ITool tool, ILayoutObject layoutObject, Object[] oldData, Object... newData);

	IToolFactory createOfficeToolFactory();

	IDetailPage createDetailPage(String className);
}
