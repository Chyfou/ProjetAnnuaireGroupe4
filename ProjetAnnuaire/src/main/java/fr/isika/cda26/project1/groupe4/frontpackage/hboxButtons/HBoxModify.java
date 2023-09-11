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

public class HBoxModify extends HBox implements BackConstants, FrontConstants {
	private TextField modifyName;
	private TextField modifyforename;
	private TextField modifypromotion;
	private TextField modifylocation;
	private TextField modifypromotionYear;
	private Button modifyInternButton;
	private ButtonDelete deleteInternButton;
	private InternDirectoryTableDisplay userTableView;

	public HBoxModify(InternDirectoryTableDisplay userTableView, ButtonDelete deleteInternButton) {
		super();
		this.userTableView = userTableView;
		this.deleteInternButton = deleteInternButton;
		this.modifyName = this.userTableView.getTextFieldName();
		this.modifyforename = this.userTableView.getTextFieldForename();
		this.modifypromotion = this.userTableView.getTextFieldPromotion();
		this.modifylocation = this.userTableView.getTextFieldLocation();
		this.modifypromotionYear = this.userTableView.getTextFieldPromotionYear();
		this.modifyInternButton = new Button(MODIFY_BUTTON);
		this.setSpacing(HBOX_SPACING);
		this.getChildren().addAll(modifyName, modifyforename, modifypromotion, modifylocation, modifypromotionYear,
				modifyInternButton);
		this.setAlignment(Pos.TOP_LEFT);

		this.modifyInternButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String[] valuesArray = new String[5];
				InternsDirectoryTree idt = new InternsDirectoryTree();
				Intern internToModify = new Intern(HBoxModify.this.userTableView.getSelectedIntern());
				valuesArray[0] = HBoxModify.this.modifyName.getText();
				valuesArray[1] = HBoxModify.this.modifyforename.getText();
				valuesArray[2] = HBoxModify.this.modifylocation.getText();
				valuesArray[3] = HBoxModify.this.modifypromotion.getText();
				valuesArray[4] = HBoxModify.this.modifypromotionYear.getText();
				idt.modifyInternGlobal(internToModify, valuesArray);
				List<Intern> internsList = new ArrayList<Intern>();
				internsList = idt.getAllInternInDB(internsList, START_VALUE);
				HBoxModify.this.userTableView.getInternsDirectoryTable()
						.setItems(FXCollections.observableArrayList(internsList));
				HBoxModify.this.userTableView.getInternsDirectoryTable().getSelectionModel().selectFirst();

			}
		});

	}
}
