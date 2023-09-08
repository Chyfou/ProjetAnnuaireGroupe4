package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends BorderPane implements FrontConstants, BackConstants {

	private Button logInButton = new Button("Log in");
	private Button backButton = new Button("Back home");
	private TextField textName;
	private TextField textForename;
	private PasswordField textPasseword;
	private List<Intern> internsList;

	public Login(List<Intern> internsList) {
		super();
		this.internsList =  new ArrayList<Intern>(internsList);

//******************I instanciate my BorderPane******************************************************
		BorderPane root = new BorderPane();

//*******************I instanciate VBox of my leftPannel**********************************************
		VBox vbox = new VBox(VBOX_SPACING);
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox(HBOX_SPACING);
		vbox.getChildren().addAll(hbox1, hbox2);
		Label wlc = new Label(" Welcome ");
		hbox1.getChildren().add(wlc);
//******************I stylist my leftpannel***********************************************************
		vbox.setStyle(LEFT_PANNEL_COLOR);
		vbox.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);

//**********************Stylish logInButton******************************************************************
		logInButton.setStyle(FONT_TITLE_1);
		logInButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

//**********************Stylish backButton******************************************************************
		backButton.setStyle(FONT_TITLE_1);
		backButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		
//**********************Add image to backButton******************************************************************
		Image image = new Image("Back_logo.png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		hbox2.getChildren().addAll(imageView, backButton);

//*******************I stylist labels of my leftPannel**************************************
		wlc.setStyle(BUTTON_FONT_1);

//***************** I instanciate labels and text fields of my VBox*****************
		AnchorPane anchor = new AnchorPane();
		GridPane grid = new GridPane();
//login:
		Label loglabel = new Label(" Please enter your credentials. ");

//name:
		Label name = new Label(" Name ");
		this.textName = new TextField();
		textName.setPrefSize(TEXT_FIELDS_WIDTH, TEXT_FIELDS_HEIGHT);
//forename:
		Label forename = new Label(" Forename ");
		this.textForename = new TextField();
		textForename.setPrefSize(TEXT_FIELDS_WIDTH, TEXT_FIELDS_HEIGHT);
//password
		Label password = new Label(" Password ");
		this.textPasseword = new PasswordField();
		textPasseword.setPrefSize(TEXT_FIELDS_WIDTH, TEXT_FIELDS_HEIGHT);

//*******************I instanciate AnchorPane in my center***********************************************

		anchor.setStyle(BACKGROUND_COLOR);
		anchor.getChildren().addAll(loglabel, grid, logInButton);
		anchor.setTopAnchor(loglabel, 100.0);
		anchor.setLeftAnchor(loglabel, 300.0);
		anchor.setRightAnchor(loglabel, 300.0);
		anchor.setTopAnchor(grid, 200.0);
		anchor.setRightAnchor(grid, 300.0);
		anchor.setLeftAnchor(grid, 300.0);
		anchor.setTopAnchor(logInButton, 500.0);
		anchor.setRightAnchor(logInButton, 600.0);
		anchor.setLeftAnchor(logInButton, 360.0);

//******************I stylist labels of my VBox**************************************
		loglabel.setStyle(BUTTON_FONT_1);
		name.setStyle(FONT_TITLE_1);
		forename.setStyle(FONT_TITLE_1);
		password.setStyle(FONT_TITLE_1);
		logInButton.setStyle(LIGHT_BUTTONS_COLOR);

//****we add several child Nodes on the same row with the addRow() method************
		grid.addRow(2, name, textName);
		grid.addRow(4, forename, textForename);
		grid.addRow(6, password, textPasseword);

//********************add padding to my pannel***************************************
		grid.setPadding(new Insets(PADDING_VALUE, PADDING_VALUE, PADDING_VALUE, PADDING_VALUE));
		grid.setStyle(BACKGROUND_COLOR);
		grid.setVgap(VGAP_VALUE);
		grid.setHgap(HGAP_VALUE);

//********************I position my components in root********************************
		setLeft(vbox);
		setCenter(anchor);

//****************************The Events****************************************
		logInButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				AdminAccountLogin newLogIn = new AdminAccountLogin();
				PopUpAlert myPopUp = new PopUpAlert();
				if ((newLogIn.checkId(Login.this.textName.getText(), Login.this.textForename.getText(),
						Login.this.textPasseword.getText())).equals(STAFF_STATUS)) {
					Admin admin = new Admin(Login.this.internsList);
					Scene scene = new Scene(admin);
					Stage stage = (Stage) Login.this.getScene().getWindow();
					stage.setScene(scene);
				} else if ((newLogIn.checkId(Login.this.textName.getText(), Login.this.textForename.getText(),
						Login.this.textPasseword.getText())).equals(ADMIN_STATUS)) {
					SuperAdminPage admin = new SuperAdminPage(Login.this.internsList);
					Scene scene = new Scene(admin);
					Stage stage = (Stage) Login.this.getScene().getWindow();
					stage.setScene(scene);
				} else {
					myPopUp.falseIdPopUp();
				}
			}
		});

		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				CurrentUserAccount currentUser = new CurrentUserAccount(Login.this.internsList);
				Scene scene = new Scene(currentUser);
				Stage stage = (Stage) Login.this.getScene().getWindow();

				stage.setScene(scene);

			}
		});

	}

}
