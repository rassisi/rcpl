package org.eclipse.rcpl.ui.controls;

import org.controlsfx.control.WorldMapView;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.eclipse.rcpl.ip2location.IPEntry;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.shape.Circle;

/**
 * @author ramin
 *
 */
public class RcplWorldMapView extends WorldMapView {

	private BooleanProperty showColorsProperty = new SimpleBooleanProperty(this, "showColors", false);

	private FontAwesome fontAwesome = new FontAwesome();

	public static class IPLocation extends WorldMapView.Location {

		private IPEntry ipEntry;

		public IPLocation(String name, IPEntry ipEntry) {
			this(name, ipEntry.getLatitude(), ipEntry.getLongitude());
			this.ipEntry = ipEntry;
		}

		public IPLocation(String name, double latitude, double longitude) {
			super(name, latitude, longitude);
		}

		public IPEntry getIpEntry() {
			return ipEntry;
		}

	}

	public RcplWorldMapView() {
		super();
	}

	public void configureCountryAndLocationViewFactories() {
		final Tooltip tooltip = new Tooltip();

		setCountryViewFactory(country -> {
			WorldMapView.CountryView view = new WorldMapView.CountryView(country);
			if (showColorsProperty.get()) {
				/*
				 * We have 8 different colors defined in sample stylesheet "world.css".
				 */
				view.getStyleClass().add("country" + ((country.ordinal() % 8) + 1));
			}
			return view;
		});

		setLocationViewFactory(location -> {
			/*
			 * The translates are needed because the location nodes will be anchored with
			 * their upper left corner at the location's coordinates. So usually these views
			 * needed to be shifted to the upper left to have them centered on the location.
			 */
			if (location.getName().equals("WRS Node")) {
				final Glyph glyph = fontAwesome.create(FontAwesome.Glyph.STAR);
				glyph.setUserData(location);
				glyph.setFontSize(32);
				glyph.setStyle("-fx-text-fill: yellow; -fx-stroke: orange;");
				glyph.setEffect(new DropShadow());
				glyph.setTranslateX(-8);
				glyph.setTranslateY(-8);
				glyph.setOnMouseClicked(evt -> {
					Object o = glyph.getUserData();
					if (o instanceof IPLocation) {
						IPLocation loc = (IPLocation) o;
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("World Reserve System - Node");
						alert.setContentText(
								loc.getIpEntry().getCity_name() + "(" + loc.getIpEntry().getCountry_name() + ")");
						alert.show();
					}
				});
				glyph.setOnMouseEntered(evt -> tooltip.setText(location.getName()));
				Tooltip.install(glyph, tooltip);
				return glyph;
			} else {
				Circle circle = new Circle();
				circle.getStyleClass().add("location");
				circle.setRadius(4);
				circle.setTranslateX(-4);
				circle.setTranslateY(-4);
				circle.setOnMouseEntered(evt -> tooltip.setText(location.getName()));
				Tooltip.install(circle, tooltip);
				return circle;
			}
		});
	}

}
