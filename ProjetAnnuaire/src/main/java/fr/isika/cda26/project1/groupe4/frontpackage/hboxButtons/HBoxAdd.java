package fr.isika.cda26.project1.groupe4.frontpackage.hboxButtons;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import fr.isika.cda26.project1.groupe4.frontpackage.tablesView.InternDirectoryTableDisplay;
import fri.isika.cda26.project1.groupe4.frontpackage.constants.FrontConstants;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class HBoxAdd extends HBox implements FrontConstants, BackConstants {
	
	private TextField addName;
	private TextField addforename;
	private TextField addpromotion;
	private TextField addlocation;
	private TextField addpromotionYear;
	private Button addInternButton;
	private InternDirectoryTableDisplay userTableView;
	
	public HBoxAdd(InternDirectoryTableDisplay userTableView ) {
		super();
		this.userTableView = userTableView;
		this.addName = new TextField();
		this.addName.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.addName.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.addName.setPromptText(NAME_LABEL);
		this.addforename = new TextField();
		this.addforename.setMinSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.addforename.setMaxSize(TEXT_FIELDS_WIDTH_LARGE, TEXT_FIELDS_HEIGHT);
		this.addforename.setPromptText(FORENAME_LABEL);
		this.addlocation = new TextField();
		this.addlocation.setMinSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addlocation.setMaxSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addlocation.setPromptText(LOCATION_LABEL);
		this.addpromotion = new TextField();
		this.addpromotion.setMinSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addpromotion.setMaxSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addpromotion.setPromptText(PROMOTION_LABEL);
		this.addpromotionYear = new TextField();
		this.addpromotionYear.setMinSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addpromotionYear.setMaxSize(TEXT_FIELDS_WIDTH_MINI, TEXT_FIELDS_HEIGHT);
		this.addpromotionYear.setPromptText(PROMOTION_YEAR_LABEL);
		this.addInternButton = new Button(ADD_BUTTON);
		this.addInternButton.setStyle(LEFT_PANNEL_COLOR);
		this.setSpacing(HBOX_SPACING);
		this.getChildren().addAll(addName, addforename, addlocation, addpromotion, addpromotionYear,
				addInternButton);
		this.setAlignment(Pos.TOP_LEFT);
		
		this.addInternButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				InternsDirectoryTree idt = new InternsDirectoryTree();
				Intern internToAdd = new Intern();
				internToAdd.setName(HBoxAdd.this.addName.getText());
				internToAdd.setForename(HBoxAdd.this.addforename.getText());
				internToAdd.setPromotion(HBoxAdd.this.addpromotion.getText());
				internToAdd.setLocation(HBoxAdd.this.addlocation.getText());
				internToAdd.setPromotionYear(Integer.valueOf(HBoxAdd.this.addpromotionYear.getText()));
				internToAdd.addInternInDB();
				List<Intern> internsList = new ArrayList<Intern>();
				internsList = idt.getAllInternInDB(internsList, START_VALUE);
				HBoxAdd.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(internsList));
				HBoxAdd.this.userTableView.getInternsDirectoryTable().getSelectionModel().selectFirst();
			}
		});
	}

}
