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
 * Display super administrator view and manage intern directory and staff.
 * 
 * @author Sabrine SADEQ & Yoann FRANCOIS & Thibault SALGUES.
 *
 */

public class SuperAdminView extends BorderPane implements FrontConstants, BackConstants {

	// ********************ATTRIBUTES********************
	private Button settingsButton;
	private Button signOutButton;
	private Button helpButton;
	private Button downloadButton;
	private Button manageStaff;
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
	// ***************** ADD BUTTON CREATION
	private TextField addName;
	private TextField addforename;
	private TextField addpromotion;
	private TextField addlocation;
	private TextField addpromotionYear;
	private Button addInternButton;
	private HBox addNewIntern;
	// ***************** MODIFY BUTTON CREATION
	private TextField modifyName;
	private TextField modifyforename;
	private TextField modifypromotion;
	private TextField modifylocation;
	private TextField modifypromotionYear;
	private Button modifyInternButton;
	private HBox modifySelecetedIntern;

	// ********************CONSTRUCTOR********************
	/**
	 * Initialized constructor to display administrator view.
	 * 
	 * @param internsList (:List<Intern>)
	 * @throws FileNotFoundException
	 */
	public SuperAdminView(List<Intern> internsList) {
		super();
		this.userTableView = new InternDirectoryTableDisplay();
		this.internsList = new ArrayList<Intern>(internsList);
		this.manageStaff = new Button(MANAGE_STAFF_BUTTON);
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
		// ***************** ADD BUTTON INITIALIZATION
		this.addName = new TextField();
		this.addName.setPromptText(NAME_LABEL);
		this.addforename = new TextField();
		this.addforename.setPromptText(FORENAME_LABEL);
		this.addpromotion = new TextField();
		this.addpromotion.setPromptText(PROMOTION_LABEL);
		this.addlocation = new TextField();
		this.addlocation.setPromptText(LOCATION_LABEL);
		this.addpromotionYear = new TextField();
		this.addpromotionYear.setPromptText(PROMOTION_YEAR_LABEL);
		this.addInternButton = new Button(ADD_BUTTON);
		this.addNewIntern = new HBox(HBOX_SPACING_DOUBLE);
		this.addNewIntern.getChildren().addAll(addName, addforename, addpromotion, addlocation, addpromotionYear,
				addInternButton, deleteInternButton);
		this.addNewIntern.setAlignment(Pos.TOP_LEFT);
		// ***************** MODIFY BUTTON INITIALIZATION
		this.modifyName = this.userTableView.getTextFieldName();
		this.modifyforename = this.userTableView.getTextFieldForename();
		this.modifypromotion = this.userTableView.getTextFieldPromotion();
		this.modifylocation = this.userTableView.getTextFieldLocation();
		this.modifypromotionYear = this.userTableView.getTextFieldPromotionYear();
		this.modifyInternButton = new Button(MODIFY_BUTTON);
		this.modifySelecetedIntern = new HBox(HBOX_SPACING_DOUBLE);
		this.modifySelecetedIntern.getChildren().addAll(modifyName, modifyforename, modifypromotion, modifylocation,
				modifypromotionYear, modifyInternButton);
		this.modifySelecetedIntern.setAlignment(Pos.TOP_LEFT);

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
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);
		HBox hbox4 = new HBox(HBOX_SPACING);
		HBox hbox5 = new HBox(HBOX_SPACING);

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
		Image image3 = new Image(STAFF_LOGO);
		ImageView imageView3 = new ImageView();
		imageView3.setImage(image3);
		hbox3.getChildren().addAll(imageView3, manageStaff);
		Image image4 = new Image(SETTINGS_LOGO);
		ImageView imageView4 = new ImageView();
		imageView4.setImage(image4);
		hbox4.getChildren().addAll(imageView4, settingsButton);
		Image image5 = new Image(SIGN_OUT_LOGO);
		ImageView imageView5 = new ImageView();
		imageView5.setImage(image5);
		hbox5.getChildren().addAll(imageView5, signOutButton);
		vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5);

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
		HBox hboxSearch = new HBox(HBOX_SPACING_DOUBLE);
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

		

		searchTableAdd.getChildren().addAll(hboxSearch, userTableView.getInternsDirectoryTable(), modifySelecetedIntern,
				addNewIntern);

		// Stylish VBox at center.
		hboxSearch.setAlignment(Pos.CENTER_LEFT);

		// Place component in BorderPane.
		this.setTop(topHbox);
		this.setLeft(vbox);
		this.setCenter(searchTableAdd);

		// Action events on buttons.
		settingsButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Settings settings = new Settings(SuperAdminView.this.internsList);
				Scene scene = new Scene(settings);
				Stage stage = (Stage) SuperAdminView.this.getScene().getWindow();
				stage.setScene(scene);
			}
		});
		signOutButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CurrentUserAccount signout = new CurrentUserAccount(SuperAdminView.this.internsList);
				Scene scene = new Scene(signout);
				Stage stage = (Stage) SuperAdminView.this.getScene().getWindow();
				stage.setScene(scene);
			}
		});
		
		manageStaff.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				PageManageStaff pageManageStaff = new PageManageStaff(SuperAdminView.this.internsList);
				Scene scene = new Scene(pageManageStaff);
				Stage stage = (Stage) SuperAdminView.this.getScene().getWindow();
				stage.setScene(scene);
			}
		});
		
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String[] valuesArray = new String[5];
				InternsDirectoryTree idt = new InternsDirectoryTree();
				valuesArray[0] = SuperAdminView.this.searchName.getText();
				System.out.println(valuesArray[0]);
				valuesArray[1] = SuperAdminView.this.searchForename.getText();
				valuesArray[2] = SuperAdminView.this.searchLocation.getText();
				valuesArray[3] = SuperAdminView.this.searchPromotion.getText();
				valuesArray[4] = SuperAdminView.this.searchPromotionYear.getText();
				SuperAdminView.this.internsList = idt.getInTreeAllInternsWith(SuperAdminView.this.internsList, valuesArray);
				SuperAdminView.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(SuperAdminView.this.internsList));
				SuperAdminView.this.userTableView.getInternsDirectoryTable().getSelectionModel().selectFirst();
			}
		});

		tableRefreshButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				InternsDirectoryTree idt = new InternsDirectoryTree();
				SuperAdminView.this.internsList = new ArrayList<Intern>();
				SuperAdminView.this.internsList = idt.getAllInternInDB(SuperAdminView.this.internsList, START_VALUE);
				SuperAdminView.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(SuperAdminView.this.internsList));			
				SuperAdminView.this.userTableView.getInternsDirectoryTable().getSelectionModel().selectFirst();
			}
		});
		
		deleteInternButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				InternsDirectoryTree idt = new InternsDirectoryTree();
				Intern internToDelete = new Intern(SuperAdminView.this.userTableView.getSelectedIntern());
				idt.deleteInternInDB(internToDelete);
				SuperAdminView.this.internsList = new ArrayList<Intern>();
				SuperAdminView.this.internsList = idt.getAllInternInDB(SuperAdminView.this.internsList, START_VALUE);
				SuperAdminView.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(SuperAdminView.this.internsList));
				SuperAdminView.this.userTableView.getInternsDirectoryTable().getSelectionModel().selectFirst();
			}
		});

		addInternButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				InternsDirectoryTree idt = new InternsDirectoryTree();
				Intern internToAdd = new Intern();
				internToAdd.setName(SuperAdminView.this.addName.getText());
				internToAdd.setForename(SuperAdminView.this.addforename.getText());
				internToAdd.setPromotion(SuperAdminView.this.addpromotion.getText());
				internToAdd.setLocation(SuperAdminView.this.addlocation.getText());
				internToAdd.setPromotionYear(Integer.valueOf(SuperAdminView.this.addpromotionYear.getText()));
				internToAdd.addInternInDB();
				SuperAdminView.this.internsList = new ArrayList<Intern>();
				SuperAdminView.this.internsList = idt.getAllInternInDB(SuperAdminView.this.internsList, START_VALUE);
				SuperAdminView.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(SuperAdminView.this.internsList));
				SuperAdminView.this.userTableView.getInternsDirectoryTable().getSelectionModel().selectFirst();
			}
		});
		
		modifyInternButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String[] valuesArray = new String[5];
				InternsDirectoryTree idt = new InternsDirectoryTree();
				Intern internToModify = new Intern(SuperAdminView.this.userTableView.getSelectedIntern());
				valuesArray[0] = SuperAdminView.this.modifyName.getText();
				valuesArray[1] = SuperAdminView.this.modifyforename.getText();
				valuesArray[2] = SuperAdminView.this.modifylocation.getText();
				valuesArray[3] = SuperAdminView.this.modifypromotion.getText();
				valuesArray[4] = SuperAdminView.this.modifypromotionYear.getText();
				idt.modifyInternGlobal(internToModify, valuesArray);
				SuperAdminView.this.internsList = new ArrayList<Intern>();
				SuperAdminView.this.internsList = idt.getAllInternInDB(SuperAdminView.this.internsList, START_VALUE);
				SuperAdminView.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(SuperAdminView.this.internsList));
				SuperAdminView.this.userTableView.getInternsDirectoryTable().getSelectionModel().selectFirst();
				
			}
		});
			}
}
