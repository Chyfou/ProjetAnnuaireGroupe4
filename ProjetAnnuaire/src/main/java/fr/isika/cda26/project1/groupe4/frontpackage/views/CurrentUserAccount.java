package fr.isika.cda26.project1.groupe4.frontpackage.views;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
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

public class CurrentUserAccount extends BorderPane implements FrontConstants {
	private Button loginbutton = new Button("Log in");
	private Button help = new Button("Help");
	private Button download = new Button("Download");
	private Button searchButton = new Button("Search");
	private List<Intern> internsList;
	private TextField searchName = new TextField();
	private TextField searchForename = new TextField();
	private TextField searchPromotion = new TextField();
	private TextField searchLocation = new TextField();
	private TextField searchPromotionYear = new TextField();
	private InternDirectoryTableDisplay userTableView;
	
	public CurrentUserAccount(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);
//******************TableView************************************
		userTableView = new InternDirectoryTableDisplay();

//******************I instanciate my BorderPane************************************
		BorderPane root = new BorderPane();

//****************** I instanciate my TopPannel***************************************
		HBox topHbox = new HBox();
		Label userAccountlabel = new Label(" Current User Account");
//**************** I Stylist topPannel and its HBox ****l**********************
		topHbox.setStyle(TOP_HBOX_COLOR);
		topHbox.setPrefWidth(STAGE_WIDTH);
		topHbox.setPrefHeight(TOP_HBOX_HEIGHT);
		topHbox.setAlignment(Pos.CENTER);
		userAccountlabel.setStyle(BUTTON_FONT_1);

//**********I add our components to the TopPannel Children's Name list*************
		topHbox.getChildren().addAll(userAccountlabel);

//****************** I instanciate leftPannel and its VBox*************************
		VBox vbox = new VBox(VBOX_SPACING);
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);

//******************I stylist buttons of my LeftPannel******************************				
		help.setStyle(FONT_TITLE_1);
		download.setStyle(FONT_TITLE_1);
		loginbutton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		help.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		download.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		
// *********************ImageView***************************************************

		Image image1 = new Image("Help_logo.png");
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, help);

		Image image2 = new Image("Download_logo.png");
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, download);

		Image image3 = new Image("Log_in_logo.png");
		ImageView imageView3 = new ImageView();
		imageView3.setImage(image3);
		hbox3.getChildren().addAll(imageView3, loginbutton);

		vbox.getChildren().addAll(hbox1, hbox2, hbox3);
//**************I stylist my leftPannel and its VBox*****************************************
		vbox.setStyle(LEFT_PANNEL_COLOR);
		vbox.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER_RIGHT);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		loginbutton.setStyle(FONT_TITLE_1);

//****************I instanciate my second BorderPane in my center**************************************
		BorderPane searchTableBorderPane = new BorderPane();
		HBox hboxSearch = new HBox(4);
		hboxSearch.getChildren().addAll(searchName, searchForename, searchPromotion, searchLocation,
				searchPromotionYear, searchButton);
		searchTableBorderPane.setTop(hboxSearch);
		searchTableBorderPane.setCenter(userTableView.getInternsDirectoryTable());

//*****************I Stylist****************************************************************
		hboxSearch.setPrefSize(HBOX_WIDTH, HBOX_HEIGHT);
		hboxSearch.setAlignment(Pos.CENTER);

//*****************I position my components in the BorderPane*****************************
		this.setTop(topHbox);
		this.setLeft(vbox);
		this.setCenter(searchTableBorderPane);

//***************************The Events***************************************************
		loginbutton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Login login = new Login(CurrentUserAccount.this.internsList);
				Scene scene = new Scene(login);
				Stage stage = (Stage) CurrentUserAccount.this.getScene().getWindow();

				stage.setScene(scene);

			}
		});

		download.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				PDFGenerator createPDF = new PDFGenerator(CurrentUserAccount.this.internsList);
				try {
					createPDF.generateDFWithTable();
				} catch (Exception e) {
					System.out.println("Error when generating pdf.");
					e.printStackTrace();
				}
				PopUpAlert myPopup = new PopUpAlert();
				myPopup.downLandingPDF();
			}
		});

		help.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ShowUseDoc openView = new ShowUseDoc();
				openView.openUseDoc();

			}
		});

		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String[] valuesArray = new String[5];
				InternsDirectoryTree idt = new InternsDirectoryTree();
				valuesArray[0] = CurrentUserAccount.this.searchName.getText();
				System.out.println(valuesArray[0]);
				valuesArray[1] = CurrentUserAccount.this.searchForename.getText();
				valuesArray[2] = CurrentUserAccount.this.searchLocation.getText();
				valuesArray[3] = CurrentUserAccount.this.searchPromotion.getText();
				valuesArray[4] = CurrentUserAccount.this.searchPromotionYear.getText();
				//Reprendre pour refresh : 
				//				CurrentUserAccount.this.internsList = idt.getAllInternInDB(resultatRecherche, SART_VALUE); 
				CurrentUserAccount.this.internsList = idt.getInTreeAllInternsWith(CurrentUserAccount.this.internsList,valuesArray);
				 CurrentUserAccount.this.userTableView.getInternsDirectoryTable().setItems(FXCollections.observableArrayList( CurrentUserAccount.this.internsList));
				
			}
		});
	}

}
