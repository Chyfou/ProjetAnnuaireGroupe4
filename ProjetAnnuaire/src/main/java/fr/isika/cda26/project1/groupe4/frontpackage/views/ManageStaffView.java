package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.person.User;
import fr.isika.cda26.project1.groupe4.frontpackage.tablesView.UserTableDisplay;
import fri.isika.cda26.project1.groupe4.frontpackage.constants.FrontConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Display staff managing view.
 * 
 * @author Yoann FRANCOIS & Thibault SALGUES.
 *
 */

public class ManageStaffView extends BorderPane implements FrontConstants, BackConstants {

	// ********************ATTRIBUTES********************
	private List<User> usersList;
	private List<Intern> internsList;
	private Button backInternDirectoryButton;
	private Button signOutButton;
	private Button helpButton;
	private TextField searchName;
	private TextField searchForename;
	private TextField searchMail;
	private TextField searchSTATUS;
	private UserTableDisplay userTable;
	private Button searchButton;
	private Button tableRefreshButton;
	private Button deleteAdminButton;
	// ***************** ADD BUTTON CREATION
	private TextField addName;
	private TextField addforename;
	private TextField addMail;
	private TextField addSTATUS;
	private Button addAdminButton;
	private HBox addNewAdmin;
	// ***************** MODIFY BUTTON CREATION
	private TextField modifyName;
	private TextField modifyforename;
	private TextField modifyMail;
	private TextField modifySTATUS;
	private Button modifyAdminButton;
	private HBox modifySelecetedAdmin;

	// ********************CONSTRUCTOR********************
	/**
	 * Initialized constructor to display administrator view.
	 * 
	 * @param internsList (:List<Intern>)
	 * @throws FileNotFoundException
	 */
	public ManageStaffView(List<Intern> internsList) {
		super();
		this.userTable = new UserTableDisplay();
		this.usersList = new ArrayList<User>();
		this.internsList = new ArrayList<Intern>(internsList);
		this.backInternDirectoryButton = new Button(INTERN_DIRECTORY_BUTTON);
		this.backInternDirectoryButton.setStyle(FONT_TITLE_1 + TOP_HBOX_COLOR);
		this.backInternDirectoryButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.signOutButton = new Button(SIGN_OUT_BUTTON);
		this.signOutButton.setStyle(FONT_TITLE_1 + TOP_HBOX_COLOR);
		this.signOutButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.helpButton = new Button(HELP_BUTTON);
		this.helpButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.helpButton.setStyle(FONT_TITLE_1 + TOP_HBOX_COLOR);
		this.searchButton = new Button(SEARCH_BUTTON);
		this.searchButton.setStyle(LEFT_PANNEL_COLOR);
		this.tableRefreshButton = new Button(REFRESH_BUTTON);
		this.tableRefreshButton.setStyle(LEFT_PANNEL_COLOR);
		this.deleteAdminButton = new Button(DELETE_INTERN_BUTTON);
		this.deleteAdminButton.setStyle(LEFT_PANNEL_COLOR);

		// ***************** ADD BUTTON INITIALIZATION
		this.addName = new TextField();
		this.addName.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.addName.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.addName.setPromptText(NAME_LABEL);
		this.addforename = new TextField();
		this.addforename.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.addforename.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.addforename.setPromptText(FORENAME_LABEL);
		this.addSTATUS = new TextField();
		this.addSTATUS.setMinSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addSTATUS.setMaxSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addSTATUS.setPromptText(LOCATION_LABEL);
		this.addMail = new TextField();
		this.addMail.setMinSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addMail.setMaxSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addMail.setPromptText(PROMOTION_LABEL);
		this.addAdminButton = new Button(ADD_BUTTON);
		this.addAdminButton.setStyle(LEFT_PANNEL_COLOR);
		this.addNewAdmin = new HBox(HBOX_SPACING);
		this.addNewAdmin.getChildren().addAll(addName, addforename, addSTATUS, addMail, addAdminButton);
		this.addNewAdmin.setAlignment(Pos.TOP_LEFT);

		// ***************** SEARCH BUTTON INITIALIZATION
		this.searchName = new TextField();
		this.searchName.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.searchName.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.searchName.setPromptText(NAME_LABEL);
		this.searchForename = new TextField();
		this.searchForename.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.searchForename.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.searchForename.setPromptText(FORENAME_LABEL);
		this.searchSTATUS = new TextField();
		this.searchSTATUS.setMinSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.searchSTATUS.setMaxSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.searchSTATUS.setPromptText(LOCATION_LABEL);
		this.searchMail = new TextField();
		this.searchMail.setMinSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.searchMail.setMaxSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.searchMail.setPromptText(PROMOTION_LABEL);

		// ***************** MODIFY BUTTON INITIALIZATION
		this.modifyName = this.userTable.getTextFieldName();
		this.modifyName.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.modifyName.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.modifyforename = this.userTable.getTextFieldForename();
		this.modifyforename.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.modifyforename.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.modifySTATUS = this.userTable.getTextFieldEmail();
		this.modifySTATUS.setMinSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.modifySTATUS.setMaxSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.modifyMail = this.userTable.getTextFieldSTATUS();
		this.modifyMail.setMinSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.modifyMail.setMaxSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.modifyAdminButton = new Button(MODIFY_BUTTON);
		this.modifyAdminButton.setStyle(LEFT_PANNEL_COLOR);
		this.modifySelecetedAdmin = new HBox(HBOX_SPACING);
		this.modifySelecetedAdmin.getChildren().addAll(modifyName, modifyforename, modifySTATUS, modifyMail,
				modifyAdminButton, deleteAdminButton);
		this.modifySelecetedAdmin.setAlignment(Pos.TOP_LEFT);

		// Instantiate BorderPane.s
		BorderPane root = new BorderPane();

		// Instantiate TopPanel.
		HBox topHbox = new HBox();
		Label superAdmin = new Label("Super Admin Account");

		// Stylized topPannel and its HBox.
		topHbox.setStyle(TOP_HBOX_COLOR);
		topHbox.setPrefWidth(STAGE_WIDTH);
		topHbox.setPrefHeight(TOP_HBOX_HEIGHT);
		topHbox.setAlignment(Pos.CENTER);
		superAdmin.setStyle(BUTTON_FONT_1);

		// Add components to the TopPannel Children's Name list.
		topHbox.getChildren().add(superAdmin);

		// Instantiate leftPannel and its VBox.
		VBox vbox = new VBox(VBOX_SPACING);
		HBox hbox0 = new HBox(HBOX_SPACING);
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);

		// Image view.
		Image image0 = new Image(INTERN_LOGO);
		ImageView imageView0 = new ImageView();
		imageView0.setImage(image0);
		hbox0.getChildren().addAll(imageView0, backInternDirectoryButton);
		Image image1 = new Image(HELP_LOGO);
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, helpButton);
		Image image2 = new Image(SIGN_OUT_LOGO);
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, signOutButton);
		vbox.getChildren().addAll(hbox0, hbox1, hbox2);

		// Stylized leftPannel and its VBox.
		vbox.setStyle(LEFT_PANNEL_COLOR);
		vbox.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER_LEFT);
		hbox0.setAlignment(Pos.CENTER_LEFT);
		hbox1.setAlignment(Pos.CENTER_LEFT);
		hbox2.setAlignment(Pos.CENTER_LEFT);

		// Instantiate and stylized VBox.
		VBox searchTableAdd = new VBox(VBOX_SPACING);
		searchTableAdd.setPadding(new Insets(PADDING_VALUE, PADDING_VALUE, PADDING_VALUE, PADDING_VALUE));
		searchTableAdd.setStyle(BACKGROUND_COLOR);

		// Instantiate and stylized HBox.
		HBox hboxSearch = new HBox(HBOX_SPACING);
		hboxSearch.setPrefSize(HBOX_WIDTH, HBOX_HEIGHT);

		// Stylized TextField.
		searchName.setPromptText(NAME_LABEL);
		searchForename.setPromptText(FORENAME_LABEL);
		searchSTATUS.setPromptText(STATUS_LABEL);
		searchMail.setPromptText(EMAIL_LABEL);

		// Fill hboxSearch.
		hboxSearch.getChildren().addAll(searchName, searchForename, searchMail, searchSTATUS, searchButton,
				tableRefreshButton);

		searchTableAdd.getChildren().addAll(hboxSearch, userTable.getUsersTable(), modifySelecetedAdmin,
				addNewAdmin);

		// Stylish VBox at center.
		hboxSearch.setAlignment(Pos.CENTER_LEFT);

		// Place component in BorderPane.
		this.setTop(topHbox);
		this.setLeft(vbox);
		this.setCenter(searchTableAdd);

		// Action events on buttons.
		signOutButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CurrentUserAccount signout = new CurrentUserAccount(ManageStaffView.this.internsList);
				Scene scene = new Scene(signout);
				Stage stage = (Stage) ManageStaffView.this.getScene().getWindow();
				stage.setScene(scene);
			}
		});
		
		backInternDirectoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				SuperAdminView currentUser = new SuperAdminView(ManageStaffView.this.internsList);
				Scene scene = new Scene(currentUser);
				Stage stage = (Stage) ManageStaffView.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});

	}
}
