package fr.isika.cda26.project1.groupe4.frontpackage.views.classes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateAnAccount extends AnchorPane implements FrontConstants {

	private Button btn = new Button("Create a new account");

	public CreateAnAccount() {
		super();

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
		AnchorPane.setTopAnchor(create, 100.0);
		AnchorPane.setRightAnchor(create, 300.0);
		AnchorPane.setLeftAnchor(create, 400.0);
		AnchorPane.setTopAnchor(grid, 150.0);
		AnchorPane.setRightAnchor(grid, 200.0);
		AnchorPane.setLeftAnchor(grid, 350.0);
		AnchorPane.setTopAnchor(btn, 600.0);
		AnchorPane.setRightAnchor(btn, 770.0);
		AnchorPane.setLeftAnchor(btn, 450.0);
		getChildren().addAll(create, grid, btn);

	}

	public Button getBtn() {
		return btn;
	}

	public void setBtn(Button btn) {
		this.btn = btn;
	}
}
