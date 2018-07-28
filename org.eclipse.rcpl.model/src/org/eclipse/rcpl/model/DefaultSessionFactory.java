package org.eclipse.rcpl.model;

import org.eclipse.rcpl.model.client.RcplSession;

public class DefaultSessionFactory implements ISessionFacory {

	@Override
	public ISession createSession() {
		return new RcplSession();
	}

}
