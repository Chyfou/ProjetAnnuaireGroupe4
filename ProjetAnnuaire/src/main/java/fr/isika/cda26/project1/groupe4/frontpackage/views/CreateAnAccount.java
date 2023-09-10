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

/**
 * Display account creation view.
 * 
 * @author Sabrine SADEQ.
 *
 */

public class CreateAnAccount extends AnchorPane implements FrontConstants {

	// ********************ATTRIBUTES********************
	private Button createAcccountButton;
	private Button backButton;
	private List<Intern> internsList;

	// ********************CONSTRUCTOR********************
	/**
	 * Initialized constructor to create an account.
	 * 
	 * @param internsList (:List<Intern>)
	 */
	public CreateAnAccount(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);
		this.createAcccountButton = new Button(CREATE_ACCOUNT_BUTTON);
		this.backButton = new Button(BACK_BUTTON);

		//Instantiate BroderPane.
		AnchorPane root = new AnchorPane();

		//Stylized root.
		setStyle(BACKGROUND_COLOR);

		//Instantiate label.
		Label createStaffAccountLabel = new Label("Create staff account");

		//Stylized button and label.
		createAcccountButton.setStyle(BUTTON_FONT_1);
		createAcccountButton.setStyle(LIGHT_BUTTONS_COLOR);
		createStaffAccountLabel.setStyle(FONT_TITLE_3);
		HBox hbox = new HBox(20);

		//Stylized backButton.
		Image image = new Image(BACK_LOGO);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		hbox.getChildren().addAll(imageView, backButton);

		//InstanTiate GridPane, labels and text fields.
		GridPane grid = new GridPane();
		Label name = new Label(NAME_LABEL);
		TextField textname = new TextField();
		Label forename = new Label(FORENAME_LABEL);
		TextField textforename = new TextField();
		Label email = new Label(EMAIL_LABEL);
		TextField textemail = new TextField();
		Label status = new Label(STATUS_LABEL);
		TextField textstatus = new TextField();
		Label password = new Label(PASSWORD_LABEL);
		PasswordField textpassword = new PasswordField();
		Label id = new Label(ID_LABEL);
		TextField textid = new TextField();

		//Stylized labels and text fields of GridPane.
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

		//Add several child Nodes on the same row with the addRow() method.
		grid.addRow(1, name, textname);
		grid.addRow(2, forename, textforename);
		grid.addRow(3, email, textemail);
		grid.addRow(4, password, textpassword);
		grid.addRow(5, status, textstatus);
		grid.addRow(6, id, textid);

		//Add padding to my panel.
		grid.setPadding(new Insets(PADDING_VALUE, PADDING_VALUE, PADDING_VALUE, PADDING_VALUE));
		grid.setVgap(VGAP_VALUE);
		grid.setHgap(HGAP_VALUE);

		//Position components in AnchorPane.	
		AnchorPane.setTopAnchor(hbox, 30.0);
		AnchorPane.setRightAnchor(hbox, 500.0);
		AnchorPane.setLeftAnchor(hbox, 30.0);
		AnchorPane.setTopAnchor(createStaffAccountLabel, 100.0);
		AnchorPane.setRightAnchor(createStaffAccountLabel, 300.0);
		AnchorPane.setLeftAnchor(createStaffAccountLabel, 400.0);
		AnchorPane.setTopAnchor(grid, 200.0);
		AnchorPane.setRightAnchor(grid, 200.0);
		AnchorPane.setLeftAnchor(grid, 350.0);
		AnchorPane.setTopAnchor(createAcccountButton, 600.0);
		AnchorPane.setRightAnchor(createAcccountButton, 770.0);
		AnchorPane.setLeftAnchor(createAcccountButton, 450.0);
		getChildren().addAll(hbox, createStaffAccountLabel, grid, createAcccountButton);
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			// Action events on buttons.
			@Override
			public void handle(ActionEvent arg0) {
				PageManageStaff manageStaff = new PageManageStaff(CreateAnAccount.this.internsList);
				Scene scene = new Scene(manageStaff);
				Stage stage = (Stage) CreateAnAccount.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});

		createAcccountButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Admin admin = new Admin(CreateAnAccount.this.internsList);
				Scene scene = new Scene(admin);
				Stage stage = (Stage) CreateAnAccount.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});

		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				SuperAdminView superAdmin = new SuperAdminView(CreateAnAccount.this.internsList);
				Scene scene = new Scene(superAdmin);
				Stage stage = (Stage) CreateAnAccount.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});
	}

}
