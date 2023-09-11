package fr.isika.cda26.project1.groupe4.frontpackage.tablesView;

import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import fri.isika.cda26.project1.groupe4.frontpackage.constants.FrontConstants;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Generate and fill TableView of interns for all concerned views.
 * 
 * @author Thibault SALGUES & Yoann FRANCOIS.
 *
 */

public class InternDirectoryTableDisplay implements FrontConstants, BackConstants {

// ********************ATTRIBUTES********************
	private TableView<Intern> internsDirectoryTable;
	private List<Intern> internsList;
	private Intern selectedIntern;
	private TextField textFielddName;
	private TextField textFieldForename;
	private TextField textFieldPromotion;
	private TextField textFieldLocation;
	private TextField textFieldPromotionYear;

// ********************GETTERS & SETTERS********************
	public List<Intern> getInternsList() {
		return internsList;
	}

	public void setInternsList(List<Intern> internsList) {
		this.internsList = internsList;
	}

	public Intern getSelectedIntern() {
		return selectedIntern;
	}

	public void setSelectedIntern(Intern selectedIntern) {
		this.selectedIntern = selectedIntern;
	}

	public TextField getTextFieldName() {
		return textFielddName;
	}

	public void setTextFieldName(TextField textFieldName) {
		this.textFielddName = textFieldName;
	}

	public TextField getTextFieldForename() {
		return textFieldForename;
	}

	public void setTextFieldForename(TextField textFielforename) {
		this.textFieldForename = textFielforename;
	}

	public TextField getTextFieldPromotion() {
		return textFieldPromotion;
	}

	public void setTextFieldPromotion(TextField textFielpromotion) {
		this.textFieldPromotion = textFielpromotion;
	}

	public TextField getTextFieldLocation() {
		return textFieldLocation;
	}

	public void setTextFieldLocation(TextField textFiellocation) {
		this.textFieldLocation = textFiellocation;
	}

	public TextField getTextFieldPromotionYear() {
		return textFieldPromotionYear;
	}

	public void setTextFieldPromotionYear(TextField textFielpromotionYear) {
		this.textFieldPromotionYear = textFielpromotionYear;
	}

	// *******************CONSTRUCTOR**************************************
	/**
	 * Initialized constructor to generate and fill TableView.
	 */
	public InternDirectoryTableDisplay() {
		this.internsDirectoryTable = new TableView<Intern>();
		this.internsList = new ArrayList<Intern>();
		this.textFielddName = new TextField();
		this.textFieldForename = new TextField();
		this.textFieldPromotion = new TextField();
		this.textFieldLocation = new TextField();
		this.textFieldPromotionYear = new TextField();

		InternsDirectoryTree frontTree = new InternsDirectoryTree();
		internsList = frontTree.getAllInternInDB(internsList, 0);
		internsDirectoryTable.setEditable(true);
		TableColumn<Intern, String> colonneName = new TableColumn<Intern, String>(NAME_LABEL);
		colonneName.setMinWidth(COLUMN_INTERN_WIDTH);
		colonneName.setCellValueFactory(new PropertyValueFactory<Intern, String>("name"));
		internsDirectoryTable.getColumns().add(colonneName);	

		TableColumn<Intern, String> colonneForename = new TableColumn<Intern, String>(FORENAME_LABEL);
		colonneForename.setMinWidth(COLUMN_INTERN_WIDTH);
		colonneForename.setCellValueFactory(new PropertyValueFactory<Intern, String>("forename"));
		internsDirectoryTable.getColumns().add(colonneForename);
		TableColumn<Intern, String> colonneLocation = new TableColumn<Intern, String>(LOCATION_LABEL);
		colonneLocation.setMinWidth(COLUMN_INTERN_WIDTH);
		colonneLocation.setCellValueFactory(new PropertyValueFactory<Intern, String>("location"));
		internsDirectoryTable.getColumns().add(colonneLocation);
		TableColumn<Intern, String> colonnePromotion = new TableColumn<Intern, String>(PROMOTION_LABEL);
		colonnePromotion.setMinWidth(COLUMN_INTERN_WIDTH);
		colonnePromotion.setCellValueFactory(new PropertyValueFactory<Intern, String>("promotion"));
		internsDirectoryTable.getColumns().add(colonnePromotion);
		TableColumn<Intern, Integer> colonnePromotionYear = new TableColumn<Intern, Integer>(PROMOTION_YEAR_LABEL);
		colonnePromotionYear.setMinWidth(COLUMN_INTERN_WIDTH);
		colonnePromotionYear.setCellValueFactory(new PropertyValueFactory<Intern, Integer>("promotionYear"));
		internsDirectoryTable.getColumns().add(colonnePromotionYear);
		internsDirectoryTable.setItems(FXCollections.observableList(internsList));

		this.internsDirectoryTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Intern>() {
			@Override
			public void changed(ObservableValue<? extends Intern> observableValue, Intern oldValue, Intern newValue) {
				// On affiche les attributs du personnage sélectionné dans le label:
				if (newValue != null) {InternDirectoryTableDisplay.this.selectedIntern = new Intern(newValue);
				textFielddName.setText(selectedIntern.getName());
				textFieldForename.setText(selectedIntern.getForename());
				textFieldPromotion.setText(selectedIntern.getPromotion());
				textFieldLocation.setText(selectedIntern.getLocation());
				textFieldPromotionYear.setText(selectedIntern.getPromotionYear().toString());
				}
			}
		});

		internsDirectoryTable.getSelectionModel().selectFirst();

	}

	// *******************GETTERS & SETTERS*******************
	public TableView<Intern> getInternsDirectoryTable() {
		return internsDirectoryTable;
	}

	public void setInternsDirectoryTable(TableView<Intern> internsDirectoryTable) {
		this.internsDirectoryTable = internsDirectoryTable;
	}

}
