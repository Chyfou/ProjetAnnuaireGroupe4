package fr.isika.cda26.project1.groupe4.frontpackage.views.classes;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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

public class CurrentUserAccount extends BorderPane implements FrontConstants {

	private TableView<Intern> table = new TableView<Intern>();
	private Button loginbutton = new Button("Log in");
	private Button help = new Button("Help");
	private Button print = new Button("Print");
	private Button download = new Button("Download");
	private Button retour = new Button("retour");

	public Button getRetour() {
		return retour;
	}

	public void setRetour(Button retour) {
		this.retour = retour;
	}

	public CurrentUserAccount() {
		super();

//******************I instanciate my BorderPane************************************
		BorderPane root = new BorderPane();

//****************** I instanciate my TopPannel***************************************
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
		VBox vbox = new VBox(200);
		HBox hbox1= new HBox();
		HBox hbox2= new HBox(HBOX_ICON_SPACING);
		Label userAccountlabel = new Label(" Current user account");
		hbox1.getChildren().add(userAccountlabel);
		

//**********I add our components to the LeftPannel Children's Name list************

		leftPannel.getChildren().add(vbox);

// *********************ImageView***************************************************
		Image image = new Image("logo-Login.jpg");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		hbox2.getChildren().addAll(imageView,loginbutton);
		vbox.getChildren().addAll(hbox1,hbox2);
//**************I stylist my leftPannel and its VBox*******************************
		leftPannel.setStyle(LEFT_PANNEL_COLOR);
		leftPannel.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER_RIGHT);
		hbox2.setAlignment(Pos.CENTER_RIGHT);
		userAccountlabel.setStyle(FONT_TITLE_1);
		loginbutton.setStyle(FONT_TITLE_1);

//****************I instanciate AnchorPane in my center****************************
		AnchorPane anchor = new AnchorPane();
		TextField search = new TextField(" search");
//****************I stylist AchorPane**********************************************
		anchor.setStyle(BACKGROUND_COLOR);
//**************I position  components in AnchorPane*******************************		
		AnchorPane.setTopAnchor(search, (double) PADDING_VALUE);
		AnchorPane.setRightAnchor(search, (double) PADDING_VALUE);
		AnchorPane.setLeftAnchor(search, (double) PADDING_VALUE);
		AnchorPane.setTopAnchor(table, 50.0);
		AnchorPane.setRightAnchor(table, (double) PADDING_VALUE);
		AnchorPane.setLeftAnchor(table, (double) PADDING_VALUE);

//**********************tableView********************************************************
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

		anchor.getChildren().addAll(search, table);

//*****************I position my components in the BorderPane*****************************
		this.setTop(topHbox);
		this.setLeft(leftPannel);
		this.setCenter(anchor);

//***************************The Events***************************************************
		loginbutton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Login login = new Login();
				Scene scene = new Scene(login);
				Stage stage = (Stage) CurrentUserAccount.this.getScene().getWindow();

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

	public Button getLoginbutton() {
		return loginbutton;
	}

	public void setLoginbutton(Button loginbutton) {
		this.loginbutton = loginbutton;
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
