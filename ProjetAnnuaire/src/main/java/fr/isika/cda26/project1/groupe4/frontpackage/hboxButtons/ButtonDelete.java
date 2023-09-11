package fr.isika.cda26.project1.groupe4.frontpackage.hboxButtons;

import java.awt.Button;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import fr.isika.cda26.project1.groupe4.frontpackage.tablesView.InternDirectoryTableDisplay;
import fr.isika.cda26.project1.groupe4.frontpackage.views.Admin;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonDelete extends Button implements BackConstants {
	private InternDirectoryTableDisplay userTableView;
	private List<Intern> internsList;


	public ButtonDelete(String label, InternDirectoryTableDisplay userTableView, List<Intern> internsList) throws HeadlessException {
		super(label);
		this.userTableView = userTableView;
		this.internsList = internsList;
		
//		((Button)this).setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				InternsDirectoryTree idt = new InternsDirectoryTree();
//				Intern internToDelete = new Intern(ButtonDelete.this.userTableView.getSelectedIntern());
//				idt.deleteInternInDB(internToDelete);
//				ButtonDelete.this.internsList = new ArrayList<Intern>();
//				ButtonDelete.this.internsList = idt.getAllInternInDB(ButtonDelete.this.internsList, START_VALUE);
//				ButtonDelete.this.userTableView.getInternsDirectoryTable()
//						.setItems(FXCollections.observableArrayList(ButtonDelete.this.internsList));
//				ButtonDelete.this.userTableView.getInternsDirectoryTable().getSelectionModel().selectFirst();
//			}
//		});
	}

}
