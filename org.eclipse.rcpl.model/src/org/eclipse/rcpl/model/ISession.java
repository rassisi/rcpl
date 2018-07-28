package org.eclipse.rcpl.model;

import java.util.List;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.SideToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar;

/**
 * @author ramin
 *
 */
public interface ISession {

	CDOSession getSession();

	List<String> getImageCodeBases();

	void addAdditionalImageCodebases(String url);

	void setStandalone(boolean standalone);

	boolean isStandalone();

	RCPL getRcpl();

	void commit();

	void close(boolean commit, boolean close);

	String getCDOServer();

	void setCDOServer(String host);

	org.eclipse.emf.ecore.resource.Resource getResource();

	String getUserId();

	boolean isDemo();

	boolean isOnline();

	boolean start() throws Throwable;

	boolean isValid();

	void setPassword(String pw);

	// ======= nach irgendeiner ModelUtil

	Perspective findPerspective(String id);

	ToolGroup findToolGroup(TopToolBar topToolBar, String id);

	ToolGroup findToolGroup(SideToolBar sideToolBar, String id);

	ToolGroup findToolGroup(RCPL rcpl, String id);

	EList<EObject> getContents();
}
