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

package org.eclipse.rcpl.internal.tools;

import java.util.Locale;

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.internal.dictionary.impl.Dict;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.ui.listener.RcplEvent;
import org.eclipse.rcpl.util.RcplConversion;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextField;

/**
 * @author ramin
 *
 */
public class TextFieldTool extends AbstractRcplTool<String> {

	public TextFieldTool(Tool tool) {
		super(tool);
	}

	@Override
	public TextField createNode() {
		return new TextField();
	}

	@Override
	public TextField getNode() {
		return (TextField) super.getNode();
	}

	@Override
	protected ChangeListener<String> createChangeListener() {
		return null;
	}

	@Override
	protected void doRemoveListener(ChangeListener<String> changeListener) {
	}

	@Override
	protected void doAddListener(ChangeListener<String> changeListener) {
	}

	@Override
	protected void doUpdate(RcplEvent event) {

		Locale locale = Dict.INSTANCE.getLocale();
		String country = locale.getISO3Country();
		String language = locale.getISO3Language();

		if (getModel() != null) {

			String id = getModel().getId();
			if (id == null || "".equals(id)) {
				return;
			}
			if (!ToolType.TEXTFIELD.equals(getModel().getType())) {
				return;
			}

			EnCommandId cmd;
			try {
				cmd = EnCommandId.valueOf(id);
			} catch (IllegalArgumentException ex) {
				// There is no value for this id
				return;
			}
			String text = "";
			boolean found = false;
			switch (cmd) {
			case PAGE_WIDTH:
				found = true;
				if (event.getLayoutObject().getPage() != null) {
					double w = event.getLayoutObject().getPage().getSection().getPageWidth();
					text = createMeasureText(country, language, w);
				}
				break;
			case PAGE_HEIGHT:
				found = true;
				if (event.getLayoutObject().getPage() != null) {
					double h = event.getLayoutObject().getPage().getSection().getPageHeight();
					text = createMeasureText(country, language, h);
				}
				break;

			default:
				break;

			}
			if (found) {
				getNode().setText(text);
			}
		}
	}

	private String createMeasureText(String country, String language, double size) {
		String text = "";
		if ("USA".equals(country)) {
			text = ((int) (RcplConversion.pixelToInch(size) * 100) / 100.0) + " Inch";
		} else if ("GER".equals(country) || "deu".equals(language)) {
			text = ((int) (RcplConversion.pixelToCm(size) * 100) / 100.0) + " Cm";
		}
		return text;
	}
}
