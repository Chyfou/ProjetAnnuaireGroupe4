package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InternDirectoryTableDisplay implements FrontConstants {

	//*******************ATTRIBUTES	*******************
	private TableView<Intern> internsDirectoryTable;

	//*******************CONSTRUCTOR*******************	
	public InternDirectoryTableDisplay() {
	this.internsDirectoryTable	= new TableView<Intern>();
	List<Intern> allInterns = new ArrayList<Intern>();
	InternsDirectoryTree frontTree = new InternsDirectoryTree();
	allInterns = frontTree.getAllInternInDB(allInterns, 0);

	internsDirectoryTable.setEditable(true);

	// **********Création de la colonne name**********
	// Etape 1 : je créé la colonne.
	TableColumn<Intern, String> colonneName = new TableColumn<Intern, String>("Name");
	// Etape 2 : je donne une largeur à ma colonne.
	colonneName.setMinWidth(100);
	// Etape 3 : je précise comment remplir la colonne.
	colonneName.setCellValueFactory(new PropertyValueFactory<Intern, String>("name"));
	// Etape 4 : j'ajoute la colonne au TableView.
	internsDirectoryTable.getColumns().add(colonneName);

	// **********Création de la colonne forename**********
	TableColumn<Intern, String> colonneForename = new TableColumn<Intern, String>("Forename");
	colonneForename.setMinWidth(100);
	colonneForename.setCellValueFactory(new PropertyValueFactory<Intern, String>("forename"));
	internsDirectoryTable.getColumns().add(colonneForename);

	// **********Création de la colonne location**********
	TableColumn<Intern, String> colonneLocation = new TableColumn<Intern, String>("Location");
	colonneLocation.setMinWidth(100);
	colonneLocation.setCellValueFactory(new PropertyValueFactory<Intern, String>("location"));
	internsDirectoryTable.getColumns().add(colonneLocation);
	
	// **********Création de la colonne promotion**********
	TableColumn<Intern, String> colonnePromotion = new TableColumn<Intern, String>("Promotion");
	colonnePromotion.setMinWidth(100);
	colonnePromotion.setCellValueFactory(new PropertyValueFactory<Intern, String>("promotion"));
	internsDirectoryTable.getColumns().add(colonnePromotion);
	
	// **********Création de la colonne promotion year.**********
	TableColumn<Intern, Integer> colonnePromotionYear = new TableColumn<Intern, Integer>("Promotion Year");
	colonnePromotionYear.setMinWidth(100);
	colonnePromotionYear.setCellValueFactory(new PropertyValueFactory<Intern, Integer>("promotionYear"));
	internsDirectoryTable.getColumns().add(colonnePromotionYear);

	internsDirectoryTable.setItems(FXCollections.observableList(allInterns));
	
	}

	//*******************GETTERS & SETTERS*******************	
	public TableView<Intern> getInternsDirectoryTable() {
		return internsDirectoryTable;
	}

	public void setInternsDirectoryTable(TableView<Intern> internsDirectoryTable) {
		this.internsDirectoryTable = internsDirectoryTable;
	}
	
	
}
