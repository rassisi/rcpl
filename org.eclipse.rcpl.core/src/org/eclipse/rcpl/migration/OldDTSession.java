package org.eclipse.rcpl.migration;

import org.eclipse.rcpl.model.client.RcplDataProvider;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;

/**
 * @author Ramin
 * 
 */
public class OldDTSession extends RcplSession implements RcplDataProvider {

	RCPL joffice;

	public OldDTSession() {
		super();
	}

}
