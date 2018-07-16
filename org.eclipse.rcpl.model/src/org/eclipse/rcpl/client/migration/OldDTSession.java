package org.eclipse.rcpl.client.migration;

import org.eclipse.rcpl.model.cdo.client.RcplDataProvider;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
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
