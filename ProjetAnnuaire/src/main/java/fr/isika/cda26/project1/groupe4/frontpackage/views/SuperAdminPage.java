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
import javafx.scene.control.TableColumn;
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

public class SuperAdminPage extends BorderPane implements FrontConstants {

	private TableView<Intern> table = new TableView<Intern>();
	private Button manageStaff = new Button(" Manage staff ");
	private Button settings = new Button(" Settings ");
	private Button signout = new Button(" Sign out ");
	private Button help = new Button("help");
	private Button download = new Button("download");
	private List<Intern> internsList;

	public SuperAdminPage(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);

//******************I instanciate my BorderPane************************************
		BorderPane root = new BorderPane();

//****************** I instanciate my TopPannel***************************************
		HBox topHbox = new HBox();
		Label superAdmin = new Label(" Super Admin Account ");
//**************** I Stylist topPannel and its HBox ****l**********************
		topHbox.setStyle(TOP_HBOX_COLOR);
		topHbox.setPrefWidth(STAGE_WIDTH);
		topHbox.setPrefHeight(TOP_HBOX_HEIGHT);
		topHbox.setAlignment(Pos.CENTER);
		superAdmin.setStyle(BUTTON_FONT_1);

//**********I add our components to the TopPannel Children's Name list*************
		topHbox.getChildren().add(superAdmin);

// ****************** I instanciate leftPannel and its VBox*************************
		VBox vbox = new VBox(VBOX_SPACING);
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);
		HBox hbox4 = new HBox(HBOX_SPACING);
		HBox hbox5 = new HBox(HBOX_SPACING);

// ******************I stylist buttons of my LeftPannel******************************
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

//*******************************ImageView***************************************************

		Image image1 = new Image("Help_logo.png");
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, help);

		Image image2 = new Image("Download_logo.png");
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, download);

		Image image3 = new Image("Staff_logo.png");
		ImageView imageView3 = new ImageView();
		imageView3.setImage(image3);
		hbox3.getChildren().addAll(imageView3, manageStaff);

		Image image4 = new Image("Settings_logo.png");
		ImageView imageView4 = new ImageView();
		imageView4.setImage(image4);
		hbox4.getChildren().addAll(imageView4, settings);

		Image image5 = new Image("Sign_out_logo.png");
		ImageView imageView5 = new ImageView();
		imageView5.setImage(image5);
		hbox5.getChildren().addAll(imageView5, signout);

		vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5);
// **************I stylist my leftPannel and its VBox*****************************************
		vbox.setStyle(LEFT_PANNEL_COLOR);
		vbox.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.setAlignment(Pos.CENTER);
		hbox5.setAlignment(Pos.CENTER);
		
		

	
		
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//j'ai changé lA lignes 116 et 117: instanciation de vbox au lieu d' anchorepane 
		 VBox searchTableAdd = new VBox(VBOX_SPACING);
		 searchTableAdd.setStyle(BACKGROUND_COLOR);
	


		HBox hboxSearch = new HBox(15);
		hboxSearch.setPrefSize(HBOX_WIDTH, HBOX_HEIGHT);
		TextField searchName = new TextField(" Name");
		TextField searchForename = new TextField(" Forename");
		TextField searchPromotion = new TextField(" Promotion");
		TextField searchLocation = new TextField(" Location ");
		TextField searchPromotionYear = new TextField(" PromotionYear ");
		Button searchButton = new Button("Search");

		
		
		
	hboxSearch.getChildren().addAll(searchName, searchForename, searchPromotion, searchLocation,
				searchPromotionYear, searchButton);

		
		
		
//**********************tableView************************************************************************
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
		
		
//********Table with the Text Fields to Enter New Interns**********************
		final HBox addNewIntern = new HBox(15);
		
		final TextField addname = new TextField();
		addname.setPromptText("Name");
		addname.setMaxWidth(col1.getPrefWidth());
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


		
//********************* I stylist my hboxsearch************************************************
		searchName.setMaxWidth(col1.getPrefWidth());
		searchForename.setMaxWidth(col2.getPrefWidth());
		searchPromotion.setMaxWidth(col3.getPrefWidth());
		searchLocation.setMaxWidth(col4.getPrefWidth());
		searchPromotionYear.setMaxWidth(col5.getPrefWidth());
		
		addNewIntern.getChildren().addAll(addname, addforename, addpromotion, addlocation, addpromotionYear, addButton);


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		
// j'ai changé la ligne 193 : je donne mes composants aux VBox au lieu de anchorePane  
		searchTableAdd.getChildren().addAll(hboxSearch,table,addNewIntern);
		
		
	
// *****************I Stylist VBox of my center************************************************
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//j'ai changé la ligne 200 et 201: modifier alignment des deux hbox of my center
		hboxSearch.setAlignment(Pos.CENTER_LEFT);
		addNewIntern.setAlignment(Pos.TOP_LEFT);
		
		 
//*****************I position my components in the BorderPane**********************************
		this.setTop(topHbox);
		this.setLeft(vbox);
		this.setCenter(searchTableAdd);

//*****************************The Events*******************************************************

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

	}


}
