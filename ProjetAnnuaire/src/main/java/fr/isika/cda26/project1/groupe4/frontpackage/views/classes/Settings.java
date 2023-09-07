package fr.isika.cda26.project1.groupe4.frontpackage.views.classes;

import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
	public Settings() {
		super();

		TableView<Intern> table = new TableView<Intern>();
		

//***************I instanciate my BorderPane*****************************************
		BorderPane root = new BorderPane();
//***************I instanciate my leftPannel*****************************************
		Pane leftPannel = new Pane();
//****************I instanciate vbox of  leftPannel**********************************
		VBox vboxLeftPannel = new VBox(100);
		Label menu = new Label(" Menu ");
		
//**********I add our components to the LeftPannel Children's Name list**************
		vboxLeftPannel.getChildren().addAll(menu, internDirectory, staffDirectory, signout);
		leftPannel.getChildren().add(vboxLeftPannel);

// **************I stylist my leftPannel and its VBox********************************
		
		leftPannel.setStyle(LEFT_PANNEL_COLOR);
		leftPannel.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vboxLeftPannel.setAlignment(Pos.CENTER_RIGHT);
		
//*************************I stylist labels of my LeftPannel ************************
		menu.setStyle(FONT_TITLE_2);
		internDirectory.setStyle(FONT_TITLE_1);
		staffDirectory.setStyle(FONT_TITLE_1);
		signout.setStyle(FONT_TITLE_1);

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
//**************************I position my components in the BorderPane*****************************************
		setLeft(leftPannel);
		setCenter(anchor);
		setStyle(BACKGROUND_COLOR);

//**********************************The Events ****************************************************************

		signout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				CurrentUserAccount currentuseraccount = new CurrentUserAccount();

				Scene scene = new Scene(currentuseraccount);
				Stage stage = (Stage) Settings.this.getScene().getWindow();

				stage.setScene(scene);

			}
		});
		
		internDirectory.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				AdminPage adminPage = new AdminPage();
				Scene scene = new Scene(adminPage);
				Stage stage = (Stage) Settings.this.getScene().getWindow();

				stage.setScene(scene);

			}
		});
		
		staffDirectory.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				PageManageStaff pageManageStaff = new PageManageStaff();
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
