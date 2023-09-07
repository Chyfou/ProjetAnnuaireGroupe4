package fr.isika.cda26.project1.groupe4.frontpackage.views.classes;


import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;
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

public class AdminPage extends BorderPane implements FrontConstants {

	private TableView<Intern> table = new TableView<Intern>();
	private Button manageStaff = new Button(" Manage staff ");
	private Button settings = new Button(" Settings ");
	private Button signout = new Button(" Sign out ");
	private Button help = new Button("help");
	private Button print = new Button("Print");
	private Button download = new Button("download");

	public AdminPage() {

		super();

//******************I instanciate my BorderPane************************************

		BorderPane root = new BorderPane();
//****************** I instanciate HBox***************************************
		HBox topHbox = new HBox(10);

//**************** I Stylist topPannel and its HBox ****l**********************
		topHbox.setStyle(TOP_HBOX_COLOR);
		topHbox.setPrefWidth(STAGE_WIDTH);
		topHbox.setPrefHeight(TOP_HBOX_HEIGHT);
		topHbox.setAlignment(Pos.CENTER);

//******************I stylist buttons of my TopPannel******************************				
		help.setStyle(FONT_TITLE_1);
		print.setStyle(FONT_TITLE_1);
		download.setStyle(FONT_TITLE_1);
//**********I add our components to the TopPannel Children's Name list*************
		topHbox.getChildren().addAll(help, print, download);

//****************** I instanciate leftPannel and its VBox*************************
		Pane leftPannel = new Pane();
		VBox vbox = new VBox(150);
		HBox hbox1= new HBox(HBOX_ICON_SPACING);
		HBox hbox2= new HBox(HBOX_ICON_SPACING);
		HBox hbox3= new HBox(HBOX_ICON_SPACING);
		HBox hbox4= new HBox(HBOX_ICON_SPACING);
		Label adminlabel = new Label(" Super Admin Account ");
	    hbox1.getChildren().add(adminlabel);
	    Image imageStaff = new Image("staff.png");
		ImageView imageView1 = new ImageView();
		imageView1.setImage(imageStaff);
		hbox2.getChildren().addAll(imageView1,manageStaff);
		Image imageSettings = new Image("settings.png");
		ImageView imageView2 = new ImageView();
		imageView2.setImage(imageSettings);
		hbox3.getChildren().addAll(imageView2,settings);
		Image imageSignout = new Image("signout.jpg");
		ImageView imageView3 = new ImageView();
		imageView3.setImage(imageSignout);
		hbox4.getChildren().addAll(imageView3,signout);
		hbox2.setAlignment(Pos.CENTER_RIGHT);
		hbox3.setAlignment(Pos.CENTER_RIGHT);
		hbox4.setAlignment(Pos.CENTER_RIGHT);
//**********I add our components to the LeftPannel Children's Name list************
		leftPannel.getChildren().add(vbox);
		vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4);

//**************I stylist my leftPannel and its VBox*******************************
		leftPannel.setStyle(LEFT_PANNEL_COLOR);
		leftPannel.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER_RIGHT);
//******************I stylist labels of my VBox************************************
		adminlabel.setStyle(FONT_TITLE_1);
		manageStaff.setStyle(FONT_TITLE_1);
		settings.setStyle(FONT_TITLE_1);
		signout.setStyle(FONT_TITLE_1);

//****************I instanciate AnchorPane in my center****************************
		AnchorPane anchor = new AnchorPane();
		TextField search = new TextField(" search");

//**********************tableView**************************************************
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
		final HBox addNewIntern = new HBox();
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
		addpromotionYear.setMaxWidth(col4.getPrefWidth());
		addpromotionYear.setPromptText("Promotion year");
		final Button addButton = new Button("Add");

//******************I position  components in AnchorPane************************************		
		addNewIntern.getChildren().addAll(addname, addforename, addpromotion, addlocation, addpromotionYear, addButton);
		addNewIntern.setSpacing(3);
		anchor.getChildren().addAll(search, table, addNewIntern);
		AnchorPane.setTopAnchor(search, 10.0);
		AnchorPane.setRightAnchor(search, 10.0);
		AnchorPane.setLeftAnchor(search, 10.0);
		AnchorPane.setTopAnchor(table, 50.0);
		AnchorPane.setRightAnchor(table, 10.0);
		AnchorPane.setLeftAnchor(table, 10.0);
		AnchorPane.setTopAnchor(addNewIntern, 470.0);
		AnchorPane.setRightAnchor(addNewIntern, 5.0);
		AnchorPane.setLeftAnchor(addNewIntern, 5.0);
//********************I position my components in the BorderPane****************************
		setTop(topHbox);
		setLeft(leftPannel);
		setCenter(anchor);

//*****************************The Events***************************************************

		settings.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Settings settings = new Settings();
				Scene scene = new Scene(settings);
				Stage stage = (Stage) AdminPage.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});

		manageStaff.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				PageManageStaff manageStaff = new PageManageStaff();
				Scene scene = new Scene(manageStaff);
				Stage stage = (Stage) AdminPage.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});
		signout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				CurrentUserAccount signout = new CurrentUserAccount();
				Scene scene = new Scene(signout);
				Stage stage = (Stage) AdminPage.this.getScene().getWindow();
				stage.setScene(scene);

			}
		});

	}

	public TableView<Intern> getTable() {
		return table;
	}

	public void setTable(TableView<Intern> table) {
		this.table = table;
	}

	public Button getManageStaff() {
		return manageStaff;
	}

	public void setManageStaff(Button manageStaff) {
		this.manageStaff = manageStaff;
	}

	public Button getSettings() {
		return settings;
	}

	public void setSettings(Button settings) {
		this.settings = settings;
	}

	public Button getSignout() {
		return signout;
	}

	public void setSignout(Button signout) {
		this.signout = signout;
	}

	public Button getHelp() {
		return help;
	}

	public void setHelp(Button help) {
		this.help = help;
	}

	public Button getPrint() {
		return print;
	}

	public void setPrint(Button print) {
		this.print = print;
	}

	public Button getDownload() {
		return download;
	}

	public void setDownload(Button download) {
		this.download = download;
	}

}
