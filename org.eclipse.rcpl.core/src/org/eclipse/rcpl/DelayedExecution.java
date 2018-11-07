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
package org.eclipse.rcpl;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * @author ramin
 *
 */
public abstract class DelayedExecution {

	private boolean done = false;

	private List<Timeline> timelines;

	public DelayedExecution(int... delays) {

		timelines = new ArrayList<Timeline>();
		for (int delay : delays) {
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(delay), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					if (!done) {
						try {
							execute();
						} catch (Exception ex) {
							Rcpl.get().printErrorln("", ex);
						}
					}
				}
			}));
			timeline.setCycleCount(1);
			timeline.play();
			timelines.add(timeline);
		}

	}

	public void cancel() {
		done = true;
		for (Timeline timeline : timelines) {
			timeline.stop();
		}
	}

	protected abstract void execute();

	protected void setDone(boolean done) {
		this.done = done;
	}

	public boolean isDone() {
		return this.done;
	}
}
