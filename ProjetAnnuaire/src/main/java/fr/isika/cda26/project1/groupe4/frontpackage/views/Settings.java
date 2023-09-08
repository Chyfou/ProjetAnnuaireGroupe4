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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Settings extends BorderPane implements FrontConstants {

	private Button signout = new Button(" Sign out ");
	private Button changeName = new Button(" change your name ");
	private Button changeForename = new Button(" change your forename ");
	private Button changeEmail = new Button(" change your email ");
	private Button changePassword = new Button(" change your password ");
	private Button staffDirectory = new Button(" Staff directory ");
	private Button internDirectory = new Button(" Intern directory ");
	private List<Intern> internsList;

	public Settings(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);

		TableView<Intern> table = new TableView<Intern>();

//***************I instanciate my BorderPane*****************************************
		BorderPane root = new BorderPane();

//****************I instanciate vbox of  leftPannel**********************************
		VBox vboxLeftPannel = new VBox(VBOX_SPACING);
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);

//**********I add our components to the LeftPannel Children's Name list**************
		vboxLeftPannel.getChildren().addAll(hbox1, hbox2, hbox3);

// **************I stylist my leftPannel and its VBox********************************

		vboxLeftPannel.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		vboxLeftPannel.setStyle(LEFT_PANNEL_COLOR);
		vboxLeftPannel.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);

//*************************I stylist buttons of my LeftPannel ************************

		internDirectory.setStyle(FONT_TITLE_1);
		staffDirectory.setStyle(FONT_TITLE_1);
		signout.setStyle(FONT_TITLE_1);
		internDirectory.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		staffDirectory.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		signout.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
//**************************I instanciate my images*********************************

		Image image1 = new Image("Intern_logo.png");
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, internDirectory);

		Image image2 = new Image("Staff_logo.png");
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, staffDirectory);

		Image image3 = new Image("Sign_out_logo.png");
		ImageView imageView3 = new ImageView();
		imageView3.setImage(image3);
		hbox3.getChildren().addAll(imageView3, signout);

//**************************I instanciate VBox of my center**********************************************
		AnchorPane anchor = new AnchorPane();
		VBox vbox2 = new VBox(70);
		Label labelsettings = new Label("Settings");

//***********************I add our components to the VBox Children's Name list************************************
		anchor.getChildren().add(vbox2);
		vbox2.getChildren().addAll(labelsettings, changeName, changeForename, changeEmail, changePassword);
		anchor.setTopAnchor(vbox2, 100.0);
		anchor.setLeftAnchor(vbox2, 400.0);
		anchor.setRightAnchor(vbox2, 80.0);

//********************I stylist Buttons and labels******************************************************************
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
//**************************I position my components in the BorderPane*****************************************
		setLeft(vboxLeftPannel);
		setCenter(anchor);
		setStyle(BACKGROUND_COLOR);

//**********************************The Events ****************************************************************

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

	public Button getSignout() {
		return signout;
	}

	public void setSignout(Button signout) {
		this.signout = signout;
	}

	public Button getChangeName() {
		return changeName;
	}

	public void setChangeName(Button changeName) {
		this.changeName = changeName;
	}

	public Button getChangeForename() {
		return changeForename;
	}

	public void setChangeForename(Button changeForename) {
		this.changeForename = changeForename;
	}

	public Button getChangeEmail() {
		return changeEmail;
	}

	public void setChangeEmail(Button changeEmail) {
		this.changeEmail = changeEmail;
	}

	public Button getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(Button changePassword) {
		this.changePassword = changePassword;
	}

	public Button getStaffDirectory() {
		return staffDirectory;
	}

	public void setStaffDirectory(Button staffDirectory) {
		this.staffDirectory = staffDirectory;
	}

}
