package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 * Display administrator view and manage intern directory.
 * 
 * @author Sabrine SADEQ & Yoann FRANCOIS.
 *
 */

public class Admin extends BorderPane implements FrontConstants, BackConstants {

	// ********************ATTRIBUTES********************
	private Button settingsButton;
	private Button signOutButton;
	private Button helpButton;
	private Button downloadButton;
	private List<Intern> internsList;
	private TextField searchName;
	private TextField searchForename;
	private TextField searchPromotion;
	private TextField searchLocation;
	private TextField searchPromotionYear;
	private InternDirectoryTableDisplay userTableView;
	private Button searchButton;
	private Button tableRefreshButton;
	private Button deleteInternButton;

	// ********************CONSTRUCTOR********************
	/**
	 * Initialized constructor to display administrator view.
	 * 
	 * @param internsList (:List<Intern>)
	 * @throws FileNotFoundException
	 */
	public Admin(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);
		this.settingsButton = new Button(SETTINGS_BUTTON);
		this.signOutButton = new Button(SIGN_OUT_BUTTON);
		this.helpButton = new Button(HELP_BUTTON);
		this.downloadButton = new Button(DOWNLOAD_BUTTON);
		this.searchName = new TextField();
		this.searchForename = new TextField();
		this.searchPromotion = new TextField();
		this.searchLocation = new TextField();
		this.searchPromotionYear = new TextField();
		this.searchButton = new Button(SEARCH_BUTTON);
		this.tableRefreshButton = new Button(REFRESH_BUTTON);
		this.deleteInternButton = new Button(DELETE_INTERN_BUTTON);

		// Instantiate BorderPane.s
		BorderPane root = new BorderPane();

		// Instantiate TopPanel.
		HBox topHbox = new HBox();
		Label superAdmin = new Label("Admin Account");

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
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);
		HBox hbox4 = new HBox(HBOX_SPACING);

		// Stylized buttons of LeftPannel.
		helpButton.setStyle(FONT_TITLE_1);
		downloadButton.setStyle(FONT_TITLE_1);
		settingsButton.setStyle(FONT_TITLE_1);
		signOutButton.setStyle(FONT_TITLE_1);
		helpButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		downloadButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		settingsButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		signOutButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		// Image view.
		Image image1 = new Image(HELP_LOGO);
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, helpButton);
		Image image2 = new Image(DOWNLOAD_LOGO);
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, downloadButton);
		Image image3 = new Image(SETTINGS_LOGO);
		ImageView imageView3 = new ImageView();
		imageView3.setImage(image3);
		hbox3.getChildren().addAll(imageView3, settingsButton);
		Image image4 = new Image(SIGN_OUT_LOGO);
		ImageView imageView4 = new ImageView();
		imageView4.setImage(image4);
		hbox4.getChildren().addAll(imageView4, signOutButton);
		vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);

		// Stylized leftPannel and its VBox.
		vbox.setStyle(LEFT_PANNEL_COLOR);
		vbox.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.setAlignment(Pos.CENTER);

		// Instantiate and stylized VBox.
		VBox searchTableAdd = new VBox(VBOX_SPACING);
		searchTableAdd.setStyle(BACKGROUND_COLOR);

		// Instantiate and stylized HBox.
		HBox hboxSearch = new HBox(15);
		hboxSearch.setPrefSize(HBOX_WIDTH, HBOX_HEIGHT);

		// Stylized TextField.
		searchName.setPromptText(NAME_LABEL);
		searchForename.setPromptText(FORENAME_LABEL);
		searchLocation.setPromptText(LOCATION_LABEL);
		searchPromotion.setPromptText(PROMOTION_LABEL);
		searchPromotionYear.setPromptText(PROMOTION_YEAR_LABEL);

		// Fill hboxSearch.
		hboxSearch.getChildren().addAll(searchName, searchForename, searchPromotion, searchLocation,
				searchPromotionYear, searchButton, tableRefreshButton);

		// TableView
		userTableView = new InternDirectoryTableDisplay();

		// Fields and button to add new Interns.
		final HBox addNewIntern = new HBox(15);
		final TextField addName = new TextField();
		addName.setPromptText(NAME_LABEL);
		final TextField addforename = new TextField();
		addforename.setPromptText(FORENAME_LABEL);
		final TextField addpromotion = new TextField();
		addpromotion.setPromptText(PROMOTION_LABEL);
		final TextField addlocation = new TextField();
		addlocation.setPromptText(LOCATION_LABEL);
		final TextField addpromotionYear = new TextField();
		addpromotionYear.setPromptText(PROMOTION_YEAR_LABEL);
		final Button addInternButton = new Button(ADD_BUTTON);

		// Fill addNewIntern & searchTableAdd.
		addNewIntern.getChildren().addAll(addName, addforename, addpromotion, addlocation, addpromotionYear,
				addInternButton, deleteInternButton);
		searchTableAdd.getChildren().addAll(hboxSearch, userTableView.getInternsDirectoryTable(), addNewIntern);

		// Stylish VBox at center.
		hboxSearch.setAlignment(Pos.CENTER_LEFT);
		addNewIntern.setAlignment(Pos.TOP_LEFT);

		// Place component in BorderPane.
		this.setTop(topHbox);
		this.setLeft(vbox);
		this.setCenter(searchTableAdd);

		// Action events on buttons.
		settingsButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Settings settings = new Settings(Admin.this.internsList);
				Scene scene = new Scene(settings);
				Stage stage = (Stage) Admin.this.getScene().getWindow();
				stage.setScene(scene);
			}
		});
		signOutButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CurrentUserAccount signout = new CurrentUserAccount(Admin.this.internsList);
				Scene scene = new Scene(signout);
				Stage stage = (Stage) Admin.this.getScene().getWindow();
				stage.setScene(scene);
			}
		});
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String[] valuesArray = new String[5];
				InternsDirectoryTree idt = new InternsDirectoryTree();
				valuesArray[0] = Admin.this.searchName.getText();
				System.out.println(valuesArray[0]);
				valuesArray[1] = Admin.this.searchForename.getText();
				valuesArray[2] = Admin.this.searchLocation.getText();
				valuesArray[3] = Admin.this.searchPromotion.getText();
				valuesArray[4] = Admin.this.searchPromotionYear.getText();
				Admin.this.internsList = idt.getInTreeAllInternsWith(Admin.this.internsList, valuesArray);
				Admin.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(Admin.this.internsList));
			}
		});
		tableRefreshButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				InternsDirectoryTree idt = new InternsDirectoryTree();
				Admin.this.internsList = idt.getAllInternInDB(Admin.this.internsList, START_VALUE);
				Admin.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(Admin.this.internsList));

			}
		});
		InternDirectoryTableDisplay removeIntern = new InternDirectoryTableDisplay();
		deleteInternButton.setOnAction(e -> removeIntern.deleteSelectedRow());

	}

}
