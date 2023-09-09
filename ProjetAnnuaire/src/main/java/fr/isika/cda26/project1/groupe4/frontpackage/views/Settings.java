package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Display settings view to manage staff.
 * 
 * @author Sabrine SADEQ
 *
 */

public class Settings extends BorderPane implements FrontConstants {

	// ********************ATTRIBUTES********************
	private Button signout;
	private Button changeName;
	private Button changeForename;
	private Button changeEmail;
	private Button changePassword;
	private Button staffDirectory;
	private Button internDirectory;
	private List<Intern> internsList;

	// ********************CONSTRUCTOR********************
	/**
	 * Initialized constructor to display settings view and manage staff.
	 * 
	 * @param internsList(:List<Intern>);
	 */
	public Settings(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);
		this.signout = new Button(SIGN_OUT_BUTTON);
		this.changeName = new Button(CHANGE_NAME_BUTTON);
		this.changeForename = new Button(CHANGE_FORENAME_BUTTON);
		this.changeEmail = new Button(CHANGE_EMAIL_BUTTON);
		this.changePassword = new Button(CHANGE_PASSWORD_BUTTON);
		this.staffDirectory = new Button(STAFF_LIST_BUTTON);
		this.internDirectory = new Button(INTERN_DIRECTORY_BUTTON);
		TableView<Intern> table = new TableView<Intern>();

		// Instantiate BorderPane.
		BorderPane root = new BorderPane();

		// Instantiate VBox of leftPannel.
		VBox vboxLeftPannel = new VBox(VBOX_SPACING);
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);

		// Add components to the LeftPannel children's Name list.
		vboxLeftPannel.getChildren().addAll(hbox1, hbox2, hbox3);

		// Stylized leftPannel and its VBox.
		vboxLeftPannel.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		vboxLeftPannel.setStyle(LEFT_PANNEL_COLOR);
		vboxLeftPannel.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);

		// Stylized buttons of leftPannel.
		internDirectory.setStyle(FONT_TITLE_1);
		staffDirectory.setStyle(FONT_TITLE_1);
		signout.setStyle(FONT_TITLE_1);
		internDirectory.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		staffDirectory.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		signout.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		// Instantiate images.
		Image image1 = new Image(INTERN_LOGO);
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, internDirectory);
		Image image2 = new Image(STAFF_LOGO);
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, staffDirectory);
		Image image3 = new Image(SIGN_OUT_LOGO);
		ImageView imageView3 = new ImageView();
		imageView3.setImage(image3);
		hbox3.getChildren().addAll(imageView3, signout);

		// Instantiate VBox in center.
		AnchorPane anchor = new AnchorPane();
		VBox vbox2 = new VBox(70);
		Label labelsettings = new Label(SETTINGS_LABEL);

		// Add our components to the VBox Children's Name list.
		anchor.getChildren().add(vbox2);
		vbox2.getChildren().addAll(labelsettings, changeName, changeForename, changeEmail, changePassword);
		anchor.setTopAnchor(vbox2, 100.0);
		anchor.setLeftAnchor(vbox2, 400.0);
		anchor.setRightAnchor(vbox2, 80.0);

		// Stylized buttons and label.
		changeName.setStyle(BUTTON_FONT_1);
		changeForename.setStyle(BUTTON_FONT_1);
		changeEmail.setStyle(BUTTON_FONT_1);
		changePassword.setStyle(BUTTON_FONT_1);
		changeName.setStyle(LIGHT_BUTTONS_COLOR);
		changeForename.setStyle(LIGHT_BUTTONS_COLOR);
		changeEmail.setStyle(LIGHT_BUTTONS_COLOR);
		changePassword.setStyle(LIGHT_BUTTONS_COLOR);
		labelsettings.setStyle(FONT_TITLE_3);
		changeName.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		changeForename.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		changeEmail.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		changePassword.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		// Set components' position in the BorderPane.
		setLeft(vboxLeftPannel);
		setCenter(anchor);
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
				SuperAdminPage adminPage = new SuperAdminPage(Settings.this.internsList);
				Scene scene = new Scene(adminPage);
				Stage stage = (Stage) Settings.this.getScene().getWindow();

				stage.setScene(scene);

			}
		});

		staffDirectory.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				PageManageStaff pageManageStaff = new PageManageStaff(Settings.this.internsList);
				Scene scene = new Scene(pageManageStaff);
				Stage stage = (Stage) Settings.this.getScene().getWindow();

				stage.setScene(scene);

			}
		});
	}

}
