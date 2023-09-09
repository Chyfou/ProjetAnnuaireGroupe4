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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Display staff managing view.
 * 
 * @author Sabrine SADEQ.
 *
 */

public class PageManageStaff extends BorderPane implements FrontConstants {

	// ********************ATTRIBUTES********************
	private Button internDirectoryButton;
	private Button settings;
	private Button signout;
	private TextField search;
	private Button createAccountButton;
	private Button removeAccountButton;
	private Button updateAccountButton;
	private Button newInternsFileButton;
	private List<Intern> internsList;

	// ********************CONSTRUCTOR********************
	/**
	 * Initialized constructor to display view of staff managing.
	 * 
	 * @param internsList (:List<Intern>)
	 */
	public PageManageStaff(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);
		this.internDirectoryButton = new Button(INTERN_DIRECTORY_BUTTON);
		this.settings = new Button(SETTINGS_BUTTON);
		this.signout = new Button(SIGN_OUT_BUTTON);
		this.search = new TextField(SEARCH_BUTTON);
		this.createAccountButton = new Button(CREATE_ACCOUNT_BUTTON);
		this.removeAccountButton = new Button(REMOVE_ACCOUNT_BUTTON);
		this.updateAccountButton = new Button(UPDATE_ACCOUNT_BUTTON);
		this.newInternsFileButton = new Button("Add new interns file");

		// Instanciate leftPannel.
		Pane leftPannel = new Pane();

		// Instantiate VBox of leftPannel.
		VBox vboxLeftPannel = new VBox(100);
		Label adminlabel = new Label(" Menu");
		adminlabel.setStyle(BUTTON_FONT_2);
		vboxLeftPannel.getChildren().addAll(adminlabel, internDirectoryButton, settings, signout);
		leftPannel.getChildren().add(vboxLeftPannel);

		// Add icons.
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);
		HBox hbox4 = new HBox(HBOX_SPACING);
		hbox1.getChildren().add(adminlabel);
		Image imageStaff = new Image(INTERN_LOGO);
		ImageView imageView1 = new ImageView();
		imageView1.setImage(imageStaff);
		hbox2.getChildren().addAll(imageView1, internDirectoryButton);
		Image imageSettings = new Image(SETTINGS_LOGO);
		ImageView imageView2 = new ImageView();
		imageView2.setImage(imageSettings);
		hbox3.getChildren().addAll(imageView2, settings);
		Image imageSignout = new Image(SIGN_OUT_LOGO);
		ImageView imageView3 = new ImageView();
		imageView3.setImage(imageSignout);
		hbox4.getChildren().addAll(imageView3, signout);
		hbox2.setAlignment(Pos.CENTER_RIGHT);
		hbox3.setAlignment(Pos.CENTER_RIGHT);
		hbox4.setAlignment(Pos.CENTER_RIGHT);
		vboxLeftPannel.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);

		// Stylized buttons of leftPannel.
		internDirectoryButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		settings.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		signout.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		// Instantiate AnchorPane in center.
		AnchorPane anchorLeft = new AnchorPane();

		// Stylized AchorPane.
		anchorLeft.setStyle(LEFT_PANNEL_COLOR);

		// Set components' position in AnchorPane.
		anchorLeft.getChildren().add(vboxLeftPannel);
		leftPannel.getChildren().add(anchorLeft);
		AnchorPane.setTopAnchor(vboxLeftPannel, 200.0);
		AnchorPane.setRightAnchor(vboxLeftPannel, 5.0);
		AnchorPane.setLeftAnchor(vboxLeftPannel, 5.0);

		// Stylized my leftPannel and its components.
		leftPannel.setStyle(LEFT_PANNEL_COLOR);
		leftPannel.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vboxLeftPannel.setAlignment(Pos.CENTER_RIGHT);
		adminlabel.setStyle("-fx-font-weight: bold");
		adminlabel.setStyle(FONT_TITLE_1);

		// Instantiate my rightPannel.
		Pane rightPannel = new Pane();
		VBox vboxRightPannel = new VBox(50);
		Label labelStaffDirectory = new Label("Staff list");
		TableView<Intern> table = new TableView<Intern>();
		vboxRightPannel.getChildren().addAll(labelStaffDirectory, table);
		labelStaffDirectory.setStyle(FONT_TITLE_3);

		// Instantiate AnchorPane OF MY RightPannel.
		AnchorPane anchorRight = new AnchorPane();
		anchorRight.setStyle(BACKGROUND_COLOR);
		anchorRight.getChildren().add(vboxRightPannel);
		rightPannel.getChildren().add(anchorRight);
		AnchorPane.setTopAnchor(vboxRightPannel, 200.0);
		AnchorPane.setRightAnchor(vboxRightPannel, 10.0);
		AnchorPane.setLeftAnchor(vboxRightPannel, 10.0);
		rightPannel.setPrefSize(RIGHT_PANNEL_WIDTH, STAGE_HEIGHT);

		// Instantiate labels and buttons in center.
		VBox vboxCenter = new VBox(50);
		Label manageStaff = new Label("Manage staff");
		manageStaff.setStyle(FONT_TITLE_3);
		vboxCenter.getChildren().addAll(manageStaff, search, createAccountButton, removeAccountButton,
				updateAccountButton, newInternsFileButton);
		vboxCenter.setAlignment(Pos.CENTER);
		vboxCenter.setPrefSize(200, 200);

		// Set components' position in BorderPane.
		setLeft(leftPannel);
		setRight(rightPannel);
		setCenter(vboxCenter);
		setStyle(BACKGROUND_COLOR);

		// Action events on buttons.
		createAccountButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				CreateAnAccount createAnAccount = new CreateAnAccount(PageManageStaff.this.internsList);
				Scene scene = new Scene(createAnAccount);
				Stage stage = (Stage) PageManageStaff.this.getScene().getWindow();

				stage.setScene(scene);
			}
		});

		settings.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				Settings settings = new Settings(PageManageStaff.this.internsList);
				Scene scene = new Scene(settings);
				Stage stage = (Stage) PageManageStaff.this.getScene().getWindow();

				stage.setScene(scene);
			}
		});
		signout.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				CurrentUserAccount pageCurrentUser = new CurrentUserAccount(PageManageStaff.this.internsList);
				Scene scene = new Scene(pageCurrentUser);
				Stage stage = (Stage) PageManageStaff.this.getScene().getWindow();

				stage.setScene(scene);
			}
		});

		internDirectoryButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				SuperAdminPage adminPage = new SuperAdminPage(PageManageStaff.this.internsList);
				Scene scene = new Scene(adminPage);
				Stage stage = (Stage) PageManageStaff.this.getScene().getWindow();

				stage.setScene(scene);
			}
		});

	}

}
