package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CreateAnAccount extends AnchorPane implements FrontConstants {

	private Button btn = new Button("Create a new account");
	private Button retour = new Button("Back");
	private List<Intern> internsList;

	public CreateAnAccount(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);

//******************I instanciate my BorderPane************************************

		AnchorPane root = new AnchorPane();

//******************I stylist my root**********************************************
		setStyle(BACKGROUND_COLOR);

//*****************I instanciate label *********************************************
		Label create = new Label(" Create an account for staff");

//*****************I stylist  button and label**************************************
		btn.setStyle(BUTTON_FONT_1);
		btn.setStyle(LIGHT_BUTTONS_COLOR);
		create.setStyle(FONT_TITLE_3);
		HBox hbox = new HBox(20);
// **********************return button******************************************************************
		Image image = new Image("Back_logo.png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		hbox.getChildren().addAll(imageView, retour);
//**********************I instanciate GridPane and its labels and text fields***************************************
		GridPane grid = new GridPane();
		Label name = new Label(" Name ");
		TextField textname = new TextField();
		Label forename = new Label(" Forename");
		TextField textforename = new TextField();
		Label email = new Label(" Email ");
		TextField textemail = new TextField();
		Label status = new Label(" Status ");
		TextField textstatus = new TextField();
		Label password = new Label(" Password ");
		PasswordField textpassword = new PasswordField();
		Label id = new Label(" iD ");
		TextField textid = new TextField();

//******************* I stylist labels and text fields of my GridPane******************

		grid.setStyle(BACKGROUND_COLOR);
		name.setStyle(FONT_TITLE_1);
		textname.setStyle(FONT_TITLE_3);
		forename.setStyle(FONT_TITLE_1);
		textforename.setStyle(FONT_TITLE_3);
		email.setStyle(FONT_TITLE_1);
		textemail.setStyle(FONT_TITLE_3);
		status.setStyle(FONT_TITLE_1);
		textstatus.setStyle(FONT_TITLE_3);
		password.setStyle(FONT_TITLE_1);
		textpassword.setStyle(FONT_TITLE_3);
		id.setStyle(FONT_TITLE_1);
		textid.setStyle(FONT_TITLE_3);

//************I add several child Nodes on the same row with the addRow() method*****************

		grid.addRow(1, name, textname);
		grid.addRow(2, forename, textforename);
		grid.addRow(3, email, textemail);
		grid.addRow(4, password, textpassword);
		grid.addRow(5, status, textstatus);
		grid.addRow(6, id, textid);

//**************************add padding to my pannel*********************************************

		grid.setPadding(new Insets(PADDING_VALUE, PADDING_VALUE, PADDING_VALUE, PADDING_VALUE));
		grid.setVgap(VGAP_VALUE);
		grid.setHgap(HGAP_VALUE);

//**************I position  components in AnchorPane*******************************		
		AnchorPane.setTopAnchor(hbox, 30.0);
		AnchorPane.setRightAnchor(hbox, 500.0);
		AnchorPane.setLeftAnchor(hbox, 30.0);
		AnchorPane.setTopAnchor(create, 100.0);
		AnchorPane.setRightAnchor(create, 300.0);
		AnchorPane.setLeftAnchor(create, 400.0);
		AnchorPane.setTopAnchor(grid, 200.0);
		AnchorPane.setRightAnchor(grid, 200.0);
		AnchorPane.setLeftAnchor(grid, 350.0);
		AnchorPane.setTopAnchor(btn, 600.0);
		AnchorPane.setRightAnchor(btn, 770.0);
		AnchorPane.setLeftAnchor(btn, 450.0);
		getChildren().addAll(hbox, create, grid, btn);

		retour.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				PageManageStaff manageStaff = new PageManageStaff(CreateAnAccount.this.internsList);
				Scene scene = new Scene(manageStaff);
				Stage stage = (Stage) CreateAnAccount.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Admin admin = new Admin(CreateAnAccount.this.internsList);
				Scene scene = new Scene(admin);
				Stage stage = (Stage) CreateAnAccount.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});

		retour.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				SuperAdminPage superAdmin = new SuperAdminPage(CreateAnAccount.this.internsList);
				Scene scene = new Scene(superAdmin);
				Stage stage = (Stage) CreateAnAccount.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});
	}

}
