package org.eclipse.rcpl;

import org.eclipse.rcpl.libs.db.H2DB;
import org.eclipse.rcpl.model.IResources;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;

import javafx.scene.Node;
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

	IButton createButton(AbstractTool t);

	Node createRibbonGroup(ToolGroup group, IRcplAddon useCase, boolean first, boolean dialogButton);

	IEditor createEditor();

	ISideToolBar createSideToolBar(HBox hbox);

	ITopToolbar createTopToolBar(StackPane stackPane);

	IHomePage createHomePage(IRcplUic uic, HomePage modelHomePage);

	Perspective createPerspective(String id, String name, String image);

	IResources createResources();

	IColorProvider createColorProvider();

	IFontProvider createFontProvider();

	IService createService();

	ICommand createCommand(ITool tool, Object[] oldData, Object... newData);

	ICommand createCommand(EnCommandId commandId, Object[] oldData, Object... data);

	ICommand createCommand(IService service, EnCommandId commandId, ILayoutObject layoutObject, Object[] oldData,
			Object... newData);

	ICommand createCommand(ITool tool, ILayoutObject layoutObject, Object[] oldData, Object... newData);

	IToolFactory createToolFactory();

	IDetailPage createDetailPage(String className);

	IButton createButton(EnCommandId id);

	IButton createButton(EnCommandId id, String cssId);
}
