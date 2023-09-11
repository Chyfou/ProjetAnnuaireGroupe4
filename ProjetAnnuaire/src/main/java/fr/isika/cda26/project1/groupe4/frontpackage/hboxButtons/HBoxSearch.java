package fr.isika.cda26.project1.groupe4.frontpackage.hboxButtons;

import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import fr.isika.cda26.project1.groupe4.frontpackage.tablesView.InternDirectoryTableDisplay;
import fri.isika.cda26.project1.groupe4.frontpackage.constants.FrontConstants;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class HBoxSearch extends HBox implements BackConstants, FrontConstants {
	private TextField searchName;
	private TextField searchForename;
	private TextField searchPromotion;
	private TextField searchLocation;
	private TextField searchPromotionYear;
	private Button searchButton;
	private Button tableRefreshButton;
	private InternDirectoryTableDisplay userTableView;
	private List<Intern> internsList;

	public HBoxSearch(InternDirectoryTableDisplay userTableView, Button tableRefreshButton, List<Intern> internsList) {
		this.internsList = internsList;
		this.userTableView = userTableView;
		this.searchName = new TextField();
		this.searchForename = new TextField();
		this.searchPromotion = new TextField();
		this.searchLocation = new TextField();
		this.searchPromotionYear = new TextField();
		this.searchName.setPromptText(NAME_LABEL);
		this.searchForename.setPromptText(FORENAME_LABEL);
		this.searchLocation.setPromptText(LOCATION_LABEL);
		this.searchPromotion.setPromptText(PROMOTION_LABEL);
		this.searchPromotionYear.setPromptText(PROMOTION_YEAR_LABEL);

		this.searchButton = new Button(SEARCH_BUTTON);
		this.tableRefreshButton = tableRefreshButton;
		this.setSpacing(HBOX_SPACING);
		this.setPrefSize(HBOX_WIDTH, HBOX_HEIGHT);
		this.getChildren().addAll(searchName, searchForename, searchPromotion, searchLocation, searchPromotionYear,
				searchButton, this.tableRefreshButton);

		this.searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String[] valuesArray = new String[5];
				InternsDirectoryTree idt = new InternsDirectoryTree();
				valuesArray[0] = HBoxSearch.this.searchName.getText();
				valuesArray[1] = HBoxSearch.this.searchForename.getText();
				valuesArray[2] = HBoxSearch.this.searchLocation.getText();
				valuesArray[3] = HBoxSearch.this.searchPromotion.getText();
				valuesArray[4] = HBoxSearch.this.searchPromotionYear.getText();
				HBoxSearch.this.internsList = idt.getInTreeAllInternsWith(HBoxSearch.this.internsList,
						valuesArray);
				HBoxSearch.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(HBoxSearch.this.internsList));
				HBoxSearch.this.userTableView.getInternsDirectoryTable().getSelectionModel().selectFirst();
			}
		});

	}

}
