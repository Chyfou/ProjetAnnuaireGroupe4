package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author Sabrine SADEQ
 *
 */

public class Admin extends BorderPane implements FrontConstants {

	//********************ATTRIBUTES********************
	private TableView<Intern> table = new TableView<Intern>();
	private Button settingsButton = new Button("Settings");
	private Button signOutButton = new Button("Sign out");
	private Button helpButton = new Button("help");
	private Button downloadButton = new Button("Export");
	private List<Intern> internsList;

	//********************CONSTRUCTOR********************
	/**
	 * Constructor with a list of interns.
	 * 
	 * @param internsList (:List<Intern>)
	 * @throws FileNotFoundException 
	 */
	public Admin(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);

		// Instantiate BorderPane.s
		BorderPane root = new BorderPane();

		// Instantiate TopPanel.
		HBox topHbox = new HBox();
		Label superAdmin = new Label("Admin Account");
		
		//I stylish topPannel and its HBox.
		topHbox.setStyle(TOP_HBOX_COLOR);
		topHbox.setPrefWidth(STAGE_WIDTH);
		topHbox.setPrefHeight(TOP_HBOX_HEIGHT);
		topHbox.setAlignment(Pos.CENTER);
		superAdmin.setStyle(BUTTON_FONT_1);

		//Add components to the TopPannel Children's Name list.
		topHbox.getChildren().add(superAdmin);

		//Instantiate leftPannel and its VBox.
		VBox vbox = new VBox(VBOX_SPACING);
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);
		HBox hbox4 = new HBox(HBOX_SPACING);

		//Stylish buttons of LeftPannel.
		helpButton.setStyle(FONT_TITLE_1);
		downloadButton.setStyle(FONT_TITLE_1);
		settingsButton.setStyle(FONT_TITLE_1);
		signOutButton.setStyle(FONT_TITLE_1);
		helpButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		downloadButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		settingsButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		signOutButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		//Image view.
		Image image1 = new Image("Help_logo.png");	
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, helpButton);		
		Image image2 = new Image("Download_logo.png");
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, downloadButton);		
		Image image3 = new Image("Settings_logo.png");
		ImageView imageView3 = new ImageView();
		imageView3.setImage(image3);
		hbox3.getChildren().addAll(imageView3, settingsButton);
		Image image4 = new Image("Sign_out_logo.png");
		ImageView imageView4 = new ImageView();
		imageView4.setImage(image4);
		hbox4.getChildren().addAll(imageView4, signOutButton);
		vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);
		
		//Stylish leftPannel and its VBox.
		vbox.setStyle(LEFT_PANNEL_COLOR);
		vbox.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.setAlignment(Pos.CENTER);

		// Instantiate and stylish VBox.
		VBox searchTableAdd = new VBox(VBOX_SPACING);
		searchTableAdd.setStyle(BACKGROUND_COLOR);

		// Instantiate and stylish HBox.
		HBox hboxSearch = new HBox(15);
		hboxSearch.setPrefSize(HBOX_WIDTH, HBOX_HEIGHT);
		
		// Instantiate and stylish TextField.
		TextField searchName = new TextField(" Name");
		TextField searchForename = new TextField(" Forename");
		TextField searchPromotion = new TextField(" Promotion");
		TextField searchLocation = new TextField(" Location ");
		TextField searchPromotionYear = new TextField(" PromotionYear ");
		
		//Instantiate searchButton.
		Button searchButton = new Button("Search");
		
		//Fill hboxSearch.
		hboxSearch.getChildren().addAll(searchName, searchForename, searchPromotion, searchLocation,
				searchPromotionYear, searchButton);

		//TableView, WILL BE DELETE !!!! 
		table.setEditable(true);
		TableColumn col1 = new TableColumn("Name");
		col1.setMinWidth(COLUMN_WIDTH);
		TableColumn col2 = new TableColumn("Forename");
		col2.setMinWidth(COLUMN_WIDTH);
		TableColumn col3 = new TableColumn("Promotion");
		col3.setMinWidth(COLUMN_WIDTH);
		TableColumn col4 = new TableColumn("Location");
		col4.setMinWidth(COLUMN_WIDTH);
		TableColumn col5 = new TableColumn("Promotion year");
		col5.setMinWidth(COLUMN_WIDTH);
		table.getColumns().addAll(col1, col2, col3, col4, col5);

		//Fields and button to add new Interns.
		final HBox addNewIntern = new HBox(15);
		final TextField addName = new TextField();
		addName.setPromptText("Name");
		addName.setMaxWidth(col1.getPrefWidth());
		final TextField addforename = new TextField();
		addforename.setMaxWidth(col2.getPrefWidth());
		addforename.setPromptText("Forename");
		final TextField addpromotion = new TextField();
		addpromotion.setMaxWidth(col3.getPrefWidth());
		addpromotion.setPromptText("Promotion");
		final TextField addlocation = new TextField();
		addlocation.setMaxWidth(col4.getPrefWidth());
		addlocation.setPromptText("Location");
		final TextField addpromotionYear = new TextField();
		addpromotionYear.setMaxWidth(col5.getPrefWidth());
		addpromotionYear.setPromptText("Promotion year");
		final Button addButton = new Button("Add");

		// Stylish HBox.
		searchName.setMaxWidth(col1.getPrefWidth());
		searchForename.setMaxWidth(col2.getPrefWidth());
		searchPromotion.setMaxWidth(col3.getPrefWidth());
		searchLocation.setMaxWidth(col4.getPrefWidth());
		searchPromotionYear.setMaxWidth(col5.getPrefWidth());
		
		//Fill addNewIntern & searchTableAdd.
		addNewIntern.getChildren().addAll(addName, addforename, addpromotion, addlocation, addpromotionYear, addButton);
		searchTableAdd.getChildren().addAll(hboxSearch, table, addNewIntern);

		//Stylish VBox at center.
		hboxSearch.setAlignment(Pos.CENTER_LEFT);
		addNewIntern.setAlignment(Pos.TOP_LEFT);

		//Place component in BorderPane.
		this.setTop(topHbox);
		this.setLeft(vbox);
		this.setCenter(searchTableAdd);

		//Action events on byttons.
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
	}

}
