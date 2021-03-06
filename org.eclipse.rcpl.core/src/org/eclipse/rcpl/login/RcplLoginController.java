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
package org.eclipse.rcpl.login;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.eclipse.rcpl.ILoginController;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.images.RcplImage;
import org.eclipse.rcpl.model.client.RcplSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;

/**
 * @author ramin
 *
 */
public class RcplLoginController implements ILoginController {

	@FXML
	private Button buttonSignIn;

	@FXML
	private Button buttonLogin;

	@FXML
	private Button buttonDemo;

	@FXML
	private Button buttonCancel;

	@FXML
	private ToggleButton buttonShowHide;

	@FXML
	private Text loginHeaderText;

	@FXML
	private Text versionText;

	@FXML
	private HBox loginHeader;

	@FXML
	private BorderPane loginBorderPane;

	@FXML
	private GridPane loginGridPane;

	@FXML
	private TextField userId;

	@FXML
	private PasswordField password;

	@FXML
	private StackPane logoArea;

	@FXML
	private ImageView barCodeImageView;

	@FXML
	private WebView termsAndConditions;

	@FXML
	private PasswordField repeatPassword;

	@FXML
	private GridPane signInArea;

	@FXML
	private FlowPane signInButtonPane;

	private RcplLogin login;

	private static String TERMS_AND_CONDITIONS_URL = "https://raw.githubusercontent.com/rassisi/worldreservesystem/master/org.wrs.resources/html/terms_and_conditions.html";

	enum LoginState {
		START, IN_REGISTRATION, AFTER_REGISTRATION
	}

	private LoginState loginState = LoginState.START;

	private RcplAuth authentication;

	private static final double COLLAPSED_HEIGHT = 260;

	private static final double COLLAPSED_WIDTH = 360;

	private static final double EXPANDED_HEIGHT = 600;

	private static final double EXPANDED_WIDTH = 600;

	public RcplLoginController(RcplLogin login) {
		this.login = login;
	}

	@Override
	public void init() {

		buttonCancel.setDisable(false);

		if (login.getApplicationProvider() != null) {
			String imageName = login.getApplicationProvider().getImage();
			RcplImage img = new RcplImage(imageName, 32, 32,
					login.getApplicationProvider().getApplicationResourceBaseClass());
			logoArea.getChildren().clear();
			logoArea.getChildren().add(img.getNode());
		}

		// agreeCheckBox.setVisible(false);
		// termsAndConditions.setText(
		//
		// "" + "JOffice is not ready for producive use!\n"
		// + " It is here provided for testing purposes, especially for early
		// evaluation" + " by developers.\n"
		//
		// + "\n"
		//
		// + "THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS
		// LICENSE "
		// + "(\"AGREEMENT\"). ANY USE OF THE PROGRAM CONSTITUTES RECIPIENT'S "
		// + "ACCEPTANCE OF THIS AGREEMENT.\n"
		//
		// + "\n"
		//
		// + " 1. DISCLAIMER OF LIABILITY EXCEPT AS EXPRESSLY SET FORTH IN THIS
		// AGREEMENT, "
		// + "NEITHER RECIPIENT NOR ANY CONTRIBUTORS SHALL HAVE ANY LIABILITY
		// FOR ANY DIRECT, "
		// + "INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
		// (INCLUDING "
		// + "WITHOUT LIMITATION LOST PROFITS), HOWEVER CAUSED AND ON ANY THEORY
		// OF LIABILITY, "
		// + "WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
		// NEGLIGENCE OR OTHERWISE) "
		// + "ARISING IN ANY WAY OUT OF THE USE OR DISTRIBUTION OF THE PROGRAM
		// OR THE EXERCISE OF "
		// + "ANY RIGHTS GRANTED HEREUNDER, EVEN IF ADVISED OF THE POSSIBILITY
		// OF SUCH DAMAGES. \n"
		//
		// + "For all used Open Source Components the Licences of the Components
		// Provider apply.\n"
		//
		// + " for all Eclipse Platform Componentes:
		// http://opensource.org/licenses/EPL-1.0\n"
		// + " for all Apache Group Components:
		// http://www.apache.org/licenses/LICENSE-2.0\n"
		//
		// );
		//
		// termsAndConditions.setEditable(false);
		// termsAndConditions.setWrapText(true);

		// userId.setOnMouseClicked(new EventHandler<MouseEvent>() {
		//
		// @Override
		// public void handle(MouseEvent event) {
		//
		// // System. out.(userId.getSelectedText());
		//
		// if (userIdAllSelected) {
		// userId.deselect();
		// userIdAllSelected = false;
		// } else {
		// userId.selectAll();
		// userIdAllSelected = true;
		// }
		// }
		// });

		// buttonLogin.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent arg0) {
		// if (!agreeCheckBox.isSelected()) {
		// return;
		// }
		// if (!isValidEmailAddress(userId.getText())) {
		// return;
		// }
		// login.handleLogin();
		// }
		// });

		// buttonCancel.setVisible(false);
		// buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent arg0) {
		// collapse2(true);
		// }
		// });

		// buttonSignIn2.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent arg0) {
		//
		// switch (loginState) {
		// case AFTER_REGISTRATION:
		// break;
		// case IN_REGISTRATION:
		// expand();
		//
		// if (!agreeCheckBox.isSelected()) {
		// return;
		// }
		// if (!isValidEmailAddress(userId.getText())) {
		// return;
		// }
		// if (verifyPassword()) {
		// login.handleRegister();
		// loginState = LoginState.AFTER_REGISTRATION;
		// }
		// break;
		// case START:
		// // if (!isValidEmailAddress(userId.getText())) {
		// // return;
		// // }
		// expand();
		// loginState = LoginState.IN_REGISTRATION;
		// break;
		// default:
		// break;
		//
		// }
		// }
		//
		// });

		// buttonDemo.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent arg0) {
		// if (!agreeCheckBox.isSelected()) {
		// return;
		// }
		// userId.setText("demo");
		// password.setText("demo");
		// login.handleLogin();
		// }
		// });

		userId.requestFocus();
		userId.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if (!Rcpl.get().isMobile()) {
					if ("x".equals(event.getText())) {
						if (event.isAltDown()) {
							password.setText("joffice");
							userId.setText("templates");
							login.getApplicationProvider().login();
							return;
						}
					}
				}
				password.setText("");
				userId.setStyle("-fx-border-color: #000;");

				if (event.getCode() == KeyCode.ENTER) {
					login.getApplicationProvider().login();
				}
			}
		});
		password.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				userId.deselect();
				if (event.getCode() == KeyCode.ENTER) {
					login.getApplicationProvider().login();
				}

			}
		});

		Document doc;
		try {
			doc = Jsoup.connect(TERMS_AND_CONDITIONS_URL).get();
			String text = doc.toString();
			termsAndConditions.getEngine().loadContent(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		collapse();

	}

	private void createPasswordToolTip() {
		Tooltip t = new Tooltip(

				"1. have at least eight characters.\n" + "2. consists of only letters and digits.\n"
						+ "3. must contain at least two digits.\n");
		Tooltip.install(password, t);
		t.getStyleClass().add("ttip");
	}

	private void resetPasswordToolTip() {
		Tooltip t = new Tooltip("");
		Tooltip.install(password, t);
		t.getStyleClass().add("ttip");
	}

	private boolean verifyPassword() {
		String pass = password.getText();
		// if (!pass.equals(repeatPassword.getText())) {
		// return false;
		// }
		// return true if and only if password:
		// 1. have at least eight characters.
		// 2. consists of only letters and digits.
		// 3. must contain at least two digits.
		if (pass.length() < 8) {
			return false;
		} else {
			char c;
			int count = 1;
			for (int i = 0; i < pass.length() - 1; i++) {
				c = pass.charAt(i);
				if (!Character.isLetterOrDigit(c)) {
					return false;
				} else if (Character.isDigit(c)) {
					count++;
					if (count < 2) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public void displayMessage(String message, String... params) {
		// termsAndConditions.setText(message);
		// int index = 1;
		// for (String param : params) {
		// message = message.replaceAll("{" + index + "}", param);
		// index++;
		// }

		// termsAndConditionsLabel.setText("Message");
		// agreeCheckBox.setVisible(false);
	}

	@Override
	public void enableButtons() {
		buttonLogin.setDisable(false);
	}

	public String getUserID() {
		return userId.getText();
	}

	public String getPassword() {
		return password.getText();
	}

	@Override
	public void reset() {
		userId.setText("");
		password.setText("");
	}

	public void collapse() {

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				loginGridPane.getChildren().removeAll(signInArea);
				loginBorderPane.layout();
				buttonLogin.setVisible(true);
				buttonDemo.setVisible(true);
				buttonSignIn.setVisible(true);
				buttonCancel.setVisible(true);
				resetPasswordToolTip();

				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						if (login.getApplicationProvider() != null) {
//							login.getNode().setPrefSize(650, 350);
							login.getApplicationProvider().setSize(COLLAPSED_WIDTH, COLLAPSED_HEIGHT);
							login.getApplicationProvider().centerWindow();
						} else {
							login.getStage().setWidth(COLLAPSED_WIDTH);
							login.getStage().setHeight(COLLAPSED_HEIGHT);
							login.getStage().centerOnScreen();
						}
					}
				});
			}
		});

	}

	private void expand() {

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				if (!loginGridPane.getChildren().contains(signInArea)) {

					buttonLogin.setVisible(false);
					buttonDemo.setVisible(false);
//					agreeCheckBox.setVisible(true);
					buttonCancel.setVisible(true);
					userId.setText("");
					password.setText("");
//					createPasswordToolTip();
					loginGridPane.getChildren().addAll(signInArea);
					loginGridPane.layout();
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							if (login.getApplicationProvider() != null) {
								login.getApplicationProvider().setSize(EXPANDED_WIDTH, EXPANDED_HEIGHT);
								login.getApplicationProvider().centerWindow();
							} else {
								login.getStage().setWidth(EXPANDED_WIDTH);
								login.getStage().setHeight(EXPANDED_HEIGHT);
								login.getStage().centerOnScreen();
							}
						}
					});
				}
			}
		});

	}

	private boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	@Override
	public void setHeaderText(final String text) {
//		Platform.runLater(new Runnable() {
//
//			@Override
//			public void run() {
//				loginHeaderText.setText(text);
//			}
//		});
	}

	@Override
	public void setErrorInUserId() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				userId.setText("Login failed!");
				userId.setStyle("-fx-border-color: #f00;");
				password.setText("");
				// login.getProgressBar().setVisible(false);
			}
		});
	}

	public void clearErrorInUserId() {
		userId.setText("");
		userId.setStyle("-fx-border-color: #000;");
	}

	@Override
	@FXML
	public void handleGuest() {
		if (login.getApplicationProvider() != null) {
			login.getApplicationProvider().login();
		}
	}

	public Text getLoginHeaderText() {
		return loginHeaderText;
	}

	public HBox getLoginHeader() {
		return loginHeader;
	}

	public TextField getUserId() {
		return userId;
	}

	public StackPane getLogoArea() {
		return logoArea;
	}

	public LoginState getLoginState() {
		return loginState;
	}

	public void handleSignIn() {

	}

	public void handleCancel() {
		Platform.exit();
	}

	public void handleLogin() {

	}

	public void onActionShowHide() {

		if (buttonShowHide.isSelected()) {
			expand();
		} else {
			collapse();
		}

		authentication = new RcplAuth();
		authentication.registerNewUser("ramin.assisi@gmail.com", RcplSession.HOME_URL);
		Image img;
		try {
			img = new Image(authentication.getBarCodeFile().toURI().toURL().toExternalForm());
			barCodeImageView.setImage(img);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onDragEnteredGoogleAuthentication() {

	}
}
