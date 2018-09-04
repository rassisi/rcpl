package org.eclipse.rcpl.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.model.client.RcplSession;

/**
 * @author Ramin
 *
 */
public class RcplSessionFactory implements ISessionFacory {

	@Override
	public ISession createSession() {
		return new RcplSession<EObject>();
	}

}
