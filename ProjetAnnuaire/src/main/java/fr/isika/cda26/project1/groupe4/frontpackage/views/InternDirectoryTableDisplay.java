package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Generate and fill TableView of interns for all concerned views.
 * 
 * @author Yoann FRANCOIS.
 *
 */

public class InternDirectoryTableDisplay implements FrontConstants, BackConstants {

	// *******************ATTRIBUTES *******************
	private TableView<Intern> internsDirectoryTable;
	private List<Intern> internsList;

	// *******************CONSTRUCTOR*******************
	/**
	 * Initialized constructor to generate and fill TableView.
	 */
	public InternDirectoryTableDisplay() {
		this.internsDirectoryTable = new TableView<Intern>();
		this.internsList = new ArrayList<Intern>();
		InternsDirectoryTree frontTree = new InternsDirectoryTree();
		internsList = frontTree.getAllInternInDB(internsList, 0);
		internsDirectoryTable.setEditable(true);
		TableColumn<Intern, String> colonneName = new TableColumn<Intern, String>(NAME_LABEL);
		colonneName.setMinWidth(100);
		colonneName.setCellValueFactory(new PropertyValueFactory<Intern, String>("name"));
		internsDirectoryTable.getColumns().add(colonneName);

//	colonneName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Intern, String>>() {
//		@Override
//		public void handle(CellEditEvent<Intern, String> event) {
//		//Je récupère l'objet qui correspond à la ligne modifiée
//			((Intern)internsDirectoryTable.getItems().get((event.getTablePosition().getRow())))
//				.setName(event.getNewValue());//On récupère la nouvelle valeur dans l'event
//		}
//	});
//	colonneName.setCellFactory(TextFieldTableCell.forTableColumn()); //On autorise à transformer la case en textfield.
//	colonneName.setEditable(true);//On autorise la modification des colonnes.
//	

		TableColumn<Intern, String> colonneForename = new TableColumn<Intern, String>(FORENAME_LABEL);
		colonneForename.setMinWidth(100);
		colonneForename.setCellValueFactory(new PropertyValueFactory<Intern, String>("forename"));
		internsDirectoryTable.getColumns().add(colonneForename);
		TableColumn<Intern, String> colonneLocation = new TableColumn<Intern, String>(LOCATION_LABEL);
		colonneLocation.setMinWidth(100);
		colonneLocation.setCellValueFactory(new PropertyValueFactory<Intern, String>("location"));
		internsDirectoryTable.getColumns().add(colonneLocation);
		TableColumn<Intern, String> colonnePromotion = new TableColumn<Intern, String>(PROMOTION_LABEL);
		colonnePromotion.setMinWidth(100);
		colonnePromotion.setCellValueFactory(new PropertyValueFactory<Intern, String>("promotion"));
		internsDirectoryTable.getColumns().add(colonnePromotion);
		TableColumn<Intern, Integer> colonnePromotionYear = new TableColumn<Intern, Integer>(PROMOTION_YEAR_LABEL);
		colonnePromotionYear.setMinWidth(100);
		colonnePromotionYear.setCellValueFactory(new PropertyValueFactory<Intern, Integer>("promotionYear"));
		internsDirectoryTable.getColumns().add(colonnePromotionYear);
		internsDirectoryTable.setItems(FXCollections.observableList(internsList));

	}

	// *******************PUBLIC METHOD*******************
	public void deleteSelectedRow() {
		ObservableList<Intern> selectedPersons = internsDirectoryTable.getSelectionModel().getSelectedItems();
		(FXCollections.observableList(internsList)).removeAll(selectedPersons);
		InternsDirectoryTree idt = new InternsDirectoryTree();
		this.internsList = idt.getAllInternInDB(this.internsList, START_VALUE);
		this.getInternsDirectoryTable()
				.setItems(FXCollections.observableArrayList(InternDirectoryTableDisplay.this.internsList));
	}

	// *******************GETTERS & SETTERS*******************
	public TableView<Intern> getInternsDirectoryTable() {
		return internsDirectoryTable;
	}

	public void setInternsDirectoryTable(TableView<Intern> internsDirectoryTable) {
		this.internsDirectoryTable = internsDirectoryTable;
	}

}
