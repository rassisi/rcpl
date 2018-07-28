package org.eclipse.rcpl.model.client;


public class RcplCoreDataInitializer {

	@SuppressWarnings("unused")
	private RcplSession cdoSession;

	public RcplCoreDataInitializer(RcplSession cdoSession) {
		this.cdoSession = cdoSession;

	}

	public void process(){
		createOffice();
	}





	/**
	 * @param code
	 * @param name
	 */
	private void createOffice() {
//		JOfficeFactory.eINSTANCE.createEJOffice();
//		cdoSession.
//		cdoSession.coreDataTable.put("cURRENCY_" + code, currency);
	}

}
