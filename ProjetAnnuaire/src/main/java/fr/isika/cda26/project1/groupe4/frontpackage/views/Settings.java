package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fri.isika.cda26.project1.groupe4.frontpackage.constants.FrontConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Display settings view to manage staff.
 * 
 * @author Sabrine SADEQ & Thibault SALGUES & Yoann FRANCOIS.
 *
 */

public class Settings extends BorderPane implements FrontConstants {

	// ********************ATTRIBUTES********************
	private Button internDirectory;
	private Button signout;
	private TextField changeName;
	private TextField changeForename;
	private TextField changeEmail;
	private PasswordField changePassword;
	private Button updateAccountButton;
	private List<Intern> internsList;

	// ********************CONSTRUCTOR********************
	/**
	 * Initialized constructor to display settings view and manage staff.
	 * 
	 * @param internsList(:List<Intern>);
	 */
	public Settings(List<Intern> internsList) {
		super();

		// Stylized buttons of leftPannel.
		this.internsList = new ArrayList<Intern>();
		this.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.internDirectory = new Button(INTERN_DIRECTORY_BUTTON);
		this.internDirectory.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.internDirectory.setStyle(FONT_TITLE_1 + TOP_HBOX_COLOR);
		this.signout = new Button(SIGN_OUT_BUTTON);
		this.signout.setStyle(FONT_TITLE_1 + TOP_HBOX_COLOR);
		this.signout.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.changeName = new TextField();
		this.changeName.setPromptText(CHANGE_NAME_LABEL);
		this.changeName.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.changeName.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.changeForename = new TextField();
		this.changeForename.setPromptText(CHANGE_FORENAME_LABEL);
		this.changeForename.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.changeForename.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.changeEmail = new TextField();
		this.changeEmail.setPromptText(CHANGE_EMAIL_LABEL);
		this.changeEmail.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.changeEmail.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.changePassword = new PasswordField();
		this.changePassword.setPromptText(CHANGE_PASSWORD_LABEL);
		this.changePassword.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.changePassword.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.updateAccountButton = new Button(UPDATE_ACCOUNT_BUTTON);
		this.updateAccountButton.setStyle(FONT_TITLE_1 + LEFT_PANNEL_COLOR);

		// Instantiate BorderPane.
		BorderPane root = new BorderPane();

		// Instantiate VBox of leftPannel.
		VBox vboxLeftPannel = new VBox(VBOX_SPACING);
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);

		// Add components to the LeftPannel children's Name list.
		vboxLeftPannel.getChildren().addAll(hbox1, hbox2);

		// Stylized leftPannel and its VBox.
		vboxLeftPannel.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		vboxLeftPannel.setStyle(LEFT_PANNEL_COLOR);
		vboxLeftPannel.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);

		// Instantiate images.
		Image image1 = new Image(INTERN_LOGO);
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, internDirectory);
		Image image2 = new Image(SIGN_OUT_LOGO);
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, signout);

		// Instantiate VBox in center.
		VBox vBoxCenter = new VBox(50);
		Label labelsettings = new Label(SETTINGS_LABEL);

		// Add our components to the VBox Children's Name list.
		vBoxCenter.getChildren().addAll(labelsettings, changeName, changeForename, changeEmail, changePassword,
				updateAccountButton);

		// Stylized main label.
		labelsettings.setStyle(FONT_TITLE_3);		
		labelsettings.setAlignment(Pos.CENTER);

		// Set components' position in the BorderPane.
		setLeft(vboxLeftPannel);
		vBoxCenter.setAlignment(Pos.CENTER);
		setCenter(vBoxCenter);
		setStyle(BACKGROUND_COLOR);

		// Action events on buttons.
		signout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				CurrentUserAccount currentuseraccount = new CurrentUserAccount(Settings.this.internsList);
				Scene scene = new Scene(currentuseraccount);
				Stage stage = (Stage) Settings.this.getScene().getWindow();

				stage.setScene(scene);

			}
		});

		internDirectory.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Admin adminPage = new Admin(Settings.this.internsList);
				Scene scene = new Scene(adminPage);
				Stage stage = (Stage) Settings.this.getScene().getWindow();

				stage.setScene(scene);

			}
		});
	}

}
