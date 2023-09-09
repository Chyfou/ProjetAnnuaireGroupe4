package fr.isika.cda26.project1.groupe4.frontpackage.views;

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
 * Display super administrator view and manage administrator and intern
 * directory.
 * 
 * @author Sabrine SADEQ & Yoann FRANCOIS.
 *
 */

public class SuperAdminPage extends BorderPane implements FrontConstants, BackConstants {

	// ********************ATTRIBUTES********************
	private Button manageStaff;
	private Button settings;
	private Button signout;
	private Button help;
	private Button download;
	private List<Intern> internsList;
	private TextField searchName;
	private TextField searchForename;
	private TextField searchPromotion;
	private TextField searchLocation;
	private TextField searchPromotionYear;
	private InternDirectoryTableDisplay userTableView;
	private Button tableRefreshButton;
	private Button searchButton;
	private Button deleteInternButton;

	// ********************CONSTRUCTOR********************
	/**
	 * Initialized constructor to display and manage super administrator view.
	 * 
	 * @param internsList (:List<Intern>)
	 */
	public SuperAdminPage(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);
		this.manageStaff = new Button(MANAGE_STAFF_BUTTON);
		this.settings = new Button(SETTINGS_BUTTON);
		this.signout = new Button(SIGN_OUT_BUTTON);
		this.help = new Button(HELP_BUTTON);
		this.download = new Button(DOWNLOAD_BUTTON);
		this.searchName = new TextField();
		this.searchForename = new TextField();
		this.searchPromotion = new TextField();
		this.searchLocation = new TextField();
		this.searchPromotionYear = new TextField();
		this.tableRefreshButton = new Button(REFRESH_BUTTON);
		this.searchButton = new Button(SEARCH_BUTTON);
		this.deleteInternButton = new Button(DELETE_INTERN_BUTTON);

		// Instantiate my BorderPane.
		BorderPane root = new BorderPane();

		// Instantiate TopPannel.
		HBox topHbox = new HBox();
		Label superAdmin = new Label("Administrator");

		// Stylized topPannel and its HBox.
		topHbox.setStyle(TOP_HBOX_COLOR);
		topHbox.setPrefWidth(STAGE_WIDTH);
		topHbox.setPrefHeight(TOP_HBOX_HEIGHT);
		topHbox.setAlignment(Pos.CENTER);
		superAdmin.setStyle(BUTTON_FONT_1);

		// Add components to the topPannel children's Name list.
		topHbox.getChildren().add(superAdmin);

		// Instantiate leftPannel and its VBox.
		VBox vbox = new VBox(VBOX_SPACING);
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);
		HBox hbox4 = new HBox(HBOX_SPACING);
		HBox hbox5 = new HBox(HBOX_SPACING);

		// Stylized buttons of LeftPannel.
		help.setStyle(FONT_TITLE_1);
		download.setStyle(FONT_TITLE_1);
		manageStaff.setStyle(FONT_TITLE_1);
		settings.setStyle(FONT_TITLE_1);
		signout.setStyle(FONT_TITLE_1);
		help.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		download.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		manageStaff.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		settings.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		signout.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		// Manage Images.
		Image image1 = new Image(HELP_LOGO);
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, help);
		Image image2 = new Image(DOWNLOAD_LOGO);
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, download);
		Image image3 = new Image(STAFF_LOGO);
		ImageView imageView3 = new ImageView();
		imageView3.setImage(image3);
		hbox3.getChildren().addAll(imageView3, manageStaff);
		Image image4 = new Image(SETTINGS_LOGO);
		ImageView imageView4 = new ImageView();
		imageView4.setImage(image4);
		hbox4.getChildren().addAll(imageView4, settings);
		Image image5 = new Image(SIGN_OUT_LOGO);
		ImageView imageView5 = new ImageView();
		imageView5.setImage(image5);
		hbox5.getChildren().addAll(imageView5, signout);
		vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5);

		// Stylized leftPannel and its VBox.
		vbox.setStyle(LEFT_PANNEL_COLOR);
		vbox.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.setAlignment(Pos.CENTER);
		hbox5.setAlignment(Pos.CENTER);

		// Initialized VBox and manage component.
		VBox searchTableAdd = new VBox(VBOX_SPACING);
		searchTableAdd.setStyle(BACKGROUND_COLOR);

		// Initialized HBox and manage components.
		HBox hboxSearch = new HBox(15);
		hboxSearch.setPrefSize(HBOX_WIDTH, HBOX_HEIGHT);
		searchName.setPromptText(NAME_LABEL);
		searchForename.setPromptText(FORENAME_LABEL);
		searchPromotion.setPromptText(PROMOTION_LABEL);
		searchLocation.setPromptText(LOCATION_LABEL);
		searchPromotionYear.setPromptText(PROMOTION_YEAR_LABEL);
		hboxSearch.getChildren().addAll(searchName, searchForename, searchPromotion, searchLocation,
				searchPromotionYear, searchButton, tableRefreshButton);

		// Manage components of adding intern field.
		final HBox addNewIntern = new HBox(15);
		final TextField addname = new TextField();
		addname.setPromptText(NAME_LABEL);
		final TextField addforename = new TextField();
		addforename.setPromptText(FORENAME_LABEL);
		final TextField addpromotion = new TextField();
		addpromotion.setPromptText(PROMOTION_LABEL);
		final TextField addlocation = new TextField();
		addlocation.setPromptText(LOCATION_LABEL);
		final TextField addpromotionYear = new TextField();
		addpromotionYear.setPromptText(PROMOTION_YEAR_LABEL);
		final Button addButton = new Button(ADD_BUTTON);
		addNewIntern.getChildren().addAll(addname, addforename, addpromotion, addlocation, addpromotionYear, addButton,
				deleteInternButton);
		searchTableAdd.getChildren().addAll(hboxSearch, userTableView.getInternsDirectoryTable(), addNewIntern);

		// Stylized VBox at center.
		hboxSearch.setAlignment(Pos.CENTER_LEFT);
		addNewIntern.setAlignment(Pos.TOP_LEFT);

		// Set components' position in the BorderPane.
		this.setTop(topHbox);
		this.setLeft(vbox);
		this.setCenter(searchTableAdd);

		// Action events on buttons.
		settings.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Settings settings = new Settings(SuperAdminPage.this.internsList);
				Scene scene = new Scene(settings);
				Stage stage = (Stage) SuperAdminPage.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});

		manageStaff.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				PageManageStaff manageStaff = new PageManageStaff(SuperAdminPage.this.internsList);
				Scene scene = new Scene(manageStaff);
				Stage stage = (Stage) SuperAdminPage.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});
		signout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				CurrentUserAccount signout = new CurrentUserAccount(SuperAdminPage.this.internsList);
				Scene scene = new Scene(signout);
				Stage stage = (Stage) SuperAdminPage.this.getScene().getWindow();
				stage.setScene(scene);
			}
		});
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String[] valuesArray = new String[5];
				InternsDirectoryTree idt = new InternsDirectoryTree();
				valuesArray[0] = SuperAdminPage.this.searchName.getText();
				System.out.println(valuesArray[0]);
				valuesArray[1] = SuperAdminPage.this.searchForename.getText();
				valuesArray[2] = SuperAdminPage.this.searchLocation.getText();
				valuesArray[3] = SuperAdminPage.this.searchPromotion.getText();
				valuesArray[4] = SuperAdminPage.this.searchPromotionYear.getText();
				SuperAdminPage.this.internsList = idt.getInTreeAllInternsWith(SuperAdminPage.this.internsList,
						valuesArray);
				SuperAdminPage.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(SuperAdminPage.this.internsList));
			}
		});
		tableRefreshButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				InternsDirectoryTree idt = new InternsDirectoryTree();
				SuperAdminPage.this.internsList = idt.getAllInternInDB(SuperAdminPage.this.internsList, START_VALUE);
				SuperAdminPage.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(SuperAdminPage.this.internsList));
			}
		});
		InternDirectoryTableDisplay removeIntern = new InternDirectoryTableDisplay();
		deleteInternButton.setOnAction(e -> removeIntern.deleteSelectedRow());
	}

}
