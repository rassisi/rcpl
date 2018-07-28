package org.eclipse.rcpl.model;

import java.util.List;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;

/**
 * @author ramin
 *
 */
public interface ISession {

	CDOSession getSession();

	List<String> getImageCodeBases();

	void addAdditionalImageCodebases(String... url);

	void setStandalone(boolean standalone);

	boolean isStandalone();

	RCPL getRcpl();

	EList<EObject> getContents();

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

	RcplModelUtil getModelUtil();

}
