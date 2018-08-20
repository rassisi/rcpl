/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/
package org.eclipse.rcpl.application;

import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.ILogin;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.IWindowAdvisor;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.internal.config.RcplConfig;
import org.eclipse.rcpl.internal.services.RcplService;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.Service;
import org.eclipse.rcpl.ui.controler.RcplUic;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author ramin
 * 
 *         Lifecycle: This class contains the functionality after the login.
 *
 */
public abstract class AbstractApplicationStarter implements IApplicationStarter {

	private final IRcplApplicationProvider applicationProvider;

	private IRcplUic uic = null;

	private IWindowAdvisor windowAdvisor;

	public AbstractApplicationStarter(IRcplApplicationProvider applicationProvider) {
		this.applicationProvider = applicationProvider;
	}

	/**
	 * @param login
	 * @param task
	 * @param primaryStage
	 * @return
	 */
	@Override
	public boolean start(final ILogin login, final Stage primaryStage) {

		RcplModel.mobileProvider.appendLog("register services)");

		RcplModel.mobileProvider.appendLog("before Session)");

		if (!beforeSession(login)) {
			return false;
		}

		// ========== model can be accessed from this point ================

		initApplicationWithModel();

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				uic.createContent();
				if (Rcpl.isMobile()) {
					uic.addtoApplicationStack(applicationProvider.getMainContent());
				} else {
					windowAdvisor = createWindowAdvisor();
					windowAdvisor.start();
					windowAdvisor.openMainWindow();
				}
				uic.createHomePages();
				uic.showHomePage(HomePageType.OVERVIEW, null);
				uic.updateStartMenuButton();
				RcplModel.log(this, "User dir: " + RcplModel.mobileProvider.getApplicationDir().toString());

			}
		});

		StackPane.setMargin(applicationProvider.getMainContent(), new Insets(0, 0, 0, 0));
		applicationProvider.setNormalWindow();

		return true;
	}

	protected void registerServices() {
		for (Service srv : RcplSession.getDefault().getRcpl().getServices().getChildren()) {

			try {
				@SuppressWarnings("unchecked")
				Class<? extends RcplService> srvClass = (Class<? extends RcplService>) Class
						.forName(srv.getClassName());
				getRcplApplicationProvider().registerService(srvClass);
			} catch (ClassNotFoundException e) {
				Rcpl.printErrorln("", e);
			}

		}
	}

	private void initApplicationWithModel() {
		doInitApplicationWithModel();
		for (String url : RcplSession.getDefault().getRcpl().getImageUrls()) {
			RcplSession.getDefault().addAdditionalImageCodebases(url);

		}
		Rcpl.progressMessage("Bind Plugins to Model");
		applicationProvider.bindAddonsToModel();

	}

	protected abstract void doInitApplicationWithModel();

	private boolean beforeSession(final ILogin login) {
		RcplSession.getDefault().setStandalone(true);

		Rcpl.progressMessage("Collapse All");
		RcplModel.configuration = new RcplConfig();

		Rcpl.progressMessage("Create UIC");
		uic = createUIC(login);

		Rcpl.progressMessage("Init Session");

		if (!uic.initSession(login)) {
			Rcpl.progressMessage("Init Session failed");
			return false;
		}

		return true;
	}

	protected abstract IWindowAdvisor createWindowAdvisor();

	protected IRcplUic createUIC(ILogin login) {
		return new RcplUic(this);
	}

	@Override
	public IRcplApplicationProvider getRcplApplicationProvider() {
		return applicationProvider;
	}

	@Override
	public String getVersionString() {
		RCPL rcpl = RcplSession.getDefault().getRcpl();
		return rcpl.getName() + " Version " + rcpl.getVersionMajor() + "." + rcpl.getVersionMinor() + "."
				+ rcpl.getVersionMaintenance() + " (" + rcpl.getVersionDescription() + ")";
	}

}
