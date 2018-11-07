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
package org.eclipse.rcpl.homepages;

import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.images.RcplImage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public class DefaultHomePage extends AbstractHomePage {

	public DefaultHomePage(IRcplUic uic, HomePage modelHomePage) {
		super(uic, modelHomePage);
		modelHomePage.setType(HomePageType.OVERVIEW);
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {

		RcplImage img = new RcplImage(Rcpl.UIC().getApplicationStarter().getRcplApplicationProvider().getImage(), 200,
				200, Rcpl.UIC().getApplicationStarter().getRcplApplicationProvider().getApplicationResourceBaseClass());

		ImageView iv = img.getNode();
		iv.setOpacity(0.5);

		contentPane.setAlignment(Pos.CENTER);
		contentPane.getChildren().add(iv);
	}

}
