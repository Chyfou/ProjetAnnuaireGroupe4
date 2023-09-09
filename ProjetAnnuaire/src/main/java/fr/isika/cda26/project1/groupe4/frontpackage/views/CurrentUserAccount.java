package fr.isika.cda26.project1.groupe4.frontpackage.views;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

/**
 * Display home page.
 * 
 * @author Sabrine SADEQ & Yoann FRANCOIS.
 *
 */

public class CurrentUserAccount extends BorderPane implements FrontConstants, BackConstants {

	// ********************ATTRIBUTES********************
	private Button loginButton;
	private Button help;
	private Button download;
	private Button searchButton;
	private Button tableRefreshButton;
	private List<Intern> internsList;
	private TextField searchName;
	private TextField searchForename;
	private TextField searchPromotion;
	private TextField searchLocation;
	private TextField searchPromotionYear;
	private InternDirectoryTableDisplay userTableView;

	// ********************CONSTRUCTOR********************
	/**
	 * Initialized constructor to display user view.
	 * 
	 * @param internsList (:List<Intern>)
	 */
	public CurrentUserAccount(List<Intern> internsList) {
		super();
		this.internsList = new ArrayList<Intern>(internsList);
		this.loginButton = new Button(LOGIN_BUTTON);
		this.help = new Button(HELP_BUTTON);
		this.download = new Button(DOWNLOAD_BUTTON);
		this.searchButton = new Button(SEARCH_BUTTON);
		this.tableRefreshButton = new Button(REFRESH_BUTTON);
		this.searchName = new TextField();
		this.searchForename = new TextField();
		this.searchPromotion = new TextField();
		this.searchLocation = new TextField();
		this.searchPromotionYear = new TextField();
		this.userTableView = new InternDirectoryTableDisplay();

		// Instantiate BorderPane.
		BorderPane root = new BorderPane();

		// Instantiate TopPannel.
		HBox topHbox = new HBox();
		Label userAccountlabel = new Label("ISIKA intern's directory");

		// Stylized topPannel and its HBox.
		topHbox.setStyle(TOP_HBOX_COLOR);
		topHbox.setPrefWidth(STAGE_WIDTH);
		topHbox.setPrefHeight(TOP_HBOX_HEIGHT);
		topHbox.setAlignment(Pos.CENTER);
		userAccountlabel.setStyle(BUTTON_FONT_1);

		// Add components to the TopPannel Children's Name list.
		topHbox.getChildren().addAll(userAccountlabel);

		// Instantiate leftPannel and its VBox.
		VBox vbox = new VBox(VBOX_SPACING);
		HBox hbox1 = new HBox(HBOX_SPACING);
		HBox hbox2 = new HBox(HBOX_SPACING);
		HBox hbox3 = new HBox(HBOX_SPACING);

		// Stylized buttons of my LeftPannel.
		help.setStyle(FONT_TITLE_1);
		download.setStyle(FONT_TITLE_1);
		loginButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		help.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		download.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		// ImageView setting.
		Image image1 = new Image(HELP_LOGO);
		ImageView imageView1 = new ImageView();
		imageView1.setImage(image1);
		hbox1.getChildren().addAll(imageView1, help);
		Image image2 = new Image(DOWNLOAD_LOGO);
		ImageView imageView2 = new ImageView();
		imageView2.setImage(image2);
		hbox2.getChildren().addAll(imageView2, download);
		Image image3 = new Image(LOGIN_LOGO);
		ImageView imageView3 = new ImageView();
		imageView3.setImage(image3);
		hbox3.getChildren().addAll(imageView3, loginButton);
		vbox.getChildren().addAll(hbox1, hbox2, hbox3);

		// Stylized my leftPannel and its VBox.
		vbox.setStyle(LEFT_PANNEL_COLOR);
		vbox.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);
		vbox.setAlignment(Pos.CENTER_RIGHT);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		loginButton.setStyle(FONT_TITLE_1);

		// Instantiate second BorderPane in center.
		BorderPane searchTableBorderPane = new BorderPane();
		HBox hboxSearch = new HBox(4);
		hboxSearch.getChildren().addAll(searchName, searchForename, searchPromotion, searchLocation,
				searchPromotionYear, searchButton, tableRefreshButton);
		searchTableBorderPane.setTop(hboxSearch);
		searchTableBorderPane.setCenter(userTableView.getInternsDirectoryTable());

		// Stylized HBox.
		hboxSearch.setPrefSize(HBOX_WIDTH, HBOX_HEIGHT);
		hboxSearch.setAlignment(Pos.CENTER);

		// Set components' position in BorderPane.
		this.setTop(topHbox);
		this.setLeft(vbox);
		this.setCenter(searchTableBorderPane);

		// Action events on buttons.
		loginButton.setOnAction(new EventHandler<ActionEvent>() {

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
				CurrentUserAccount.this.internsList = idt.getInTreeAllInternsWith(CurrentUserAccount.this.internsList,
						valuesArray);
				CurrentUserAccount.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(CurrentUserAccount.this.internsList));
			}
		});
		tableRefreshButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				InternsDirectoryTree idt = new InternsDirectoryTree();
				FXCollections.observableArrayList(CurrentUserAccount.this.internsList).clear();
				CurrentUserAccount.this.internsList = idt.getAllInternInDB(CurrentUserAccount.this.internsList,
						START_VALUE);
				CurrentUserAccount.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(CurrentUserAccount.this.internsList));
			}
		});
	}

}
