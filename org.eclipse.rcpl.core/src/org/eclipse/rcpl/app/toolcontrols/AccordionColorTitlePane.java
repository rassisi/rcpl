package org.eclipse.rcpl.app.toolcontrols;

import java.util.HashMap;

import org.eclipse.rcpl.ISideToolBar;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.internal.dictionary.impl.RcplDictionary;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

class AccordionColorTitlePane extends TitledPane {
	private Pane pane;
	private Rectangle rect;
	private ToolGroup toolGroup;

	private Accordion accordion;

	private Text headerText;

	AccordionColorTitlePane(ISideToolBar sideToolBar, ToolGroup toolGroup, Node node, int hierarchy,
			HashMap<String, AccordionColorTitlePane> titlePaneRegistry) {
		super(toolGroup.getName(), node);
		this.toolGroup = toolGroup;
		titlePaneRegistry.put(toolGroup.getId(), this);
		setTextAlignment(TextAlignment.CENTER);
		setGraphicTextGap(10);
		setAnimated(false);
		if (hierarchy == 0) {
			setText("");
			setUnderline(true);
		} else if (hierarchy > 1) {
			setPadding(new Insets(0, 0, 0, 20));
		}

		if (hierarchy == 0) {

			setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					double y = event.getY();

					if (y < 40) {
						sideToolBar.collapseToolPane();
					}
				}
			});
		}

		try {

			String iconName = toolGroup.getImage();
			if (iconName == null) {
				iconName = toolGroup.getId();
			}
			String imageName = iconName;

			double width;
			double height;

			switch (hierarchy) {
			case 0:
				width = 32;
				height = 32;
				break;
			case 1:
				width = 24;
				height = 24;
				break;
			default:
				width = 16;
				height = 16;
				break;
			}

			HBox hBox = new HBox();
			hBox.setAlignment(Pos.CENTER);

			Node image = Rcpl.get().resources().getImage(imageName, width, height).getNode();

			if (image != null) {
				hBox.getChildren().add(image);
			} else {

			}

			if (hierarchy == 0) {
				hBox.setMinHeight(50);
				headerText = new Text(RcplDictionary.INSTANCE.get(toolGroup.getName()));
				InnerShadow is = new InnerShadow();
				is.setOffsetX(2.0f);
				is.setOffsetY(2.0f);
				headerText.setEffect(is);
				headerText.setFont(Font.font(null, FontWeight.BOLD, 22));
				HBox.setMargin(headerText, new Insets(0, 0, 0, 20));
				hBox.getChildren().add(headerText);
				headerText.setOpacity(0.8);

				String format = toolGroup.getFormat();
				if (!toolGroup.getTools().isEmpty() && format != null && format.indexOf("{HEADER}") != -1) {
					if (!ToolType.NAVIGATOR.equals(toolGroup.getTools().get(0).getType())) {
						ITool n = Rcpl.get().getToolFactory().createTool(toolGroup.getTools().get(0));
						if (n instanceof ComboBox<?>) {
							((ComboBox<?>) n).setEditable(true);
						}
						HBox.setMargin(n.getNode(), new Insets(0, 0, 0, 10));
						hBox.getChildren().add(n.getNode());
					}
				}

				headerText.setFill(Color.WHITE);

			}

			setGraphic(hBox);

		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}

	}

	public ToolGroup getToolGroup() {
		return toolGroup;
	}

	void setColor(Tool colorTool, Color color, boolean update) {
		if (rect == null) {
			pane = new HBox();
			rect = new Rectangle();
			pane.getChildren().add(rect);
			HBox.setMargin(rect, new Insets(8));
			rect.setWidth(40);
			rect.setHeight(16);
			Effect e = new DropShadow();
			rect.setEffect(e);
			setGraphic(pane);
			if (update) {

				// String format = colorTool.getFormat();
				// colorTool.getColorToolColor().setRed(color.getRed());
				// colorTool.getColorToolColor().setGreen(color.getGreen());
				// colorTool.getColorToolColor().setBlue(color.getBlue());
			}
		}
		rect.setFill(color);
	}

	public Accordion getAccordion() {
		return accordion;
	}

	public void setAccordion(Accordion accordion) {
		this.accordion = accordion;
	}

	public void updateLocale() {

		String name = toolGroup.getName();
		String id = toolGroup.getId();

		if ("Foreground Color".equals(name)) {
			System.out.println();
		}

		if (name != null) {
			if (headerText != null) {
				headerText.setText(RcplDictionary.INSTANCE.get(name));
			} else {
				setText(RcplDictionary.INSTANCE.get(name));
			}
		}
	}

}
