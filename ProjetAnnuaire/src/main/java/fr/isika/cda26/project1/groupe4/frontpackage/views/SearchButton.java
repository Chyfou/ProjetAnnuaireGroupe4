package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SearchButton extends Button {

	// ******************ATTRIBUTES******************
	private Button button;
	private InternsDirectoryTree idt;
	private CurrentUserAccount cua;

	// ******************CONSTRUCTOR******************
	/**
	 * Empty constructor.
	 */
	public SearchButton (CurrentUserAccount cua) {
		super();
		Button searchButton = new Button("Search");
		idt = new InternsDirectoryTree();
		this.cua = cua;
//	
//	this.setOnAction(new EventHandler<ActionEvent>() {
//
//		@Override
//		public void handle(ActionEvent arg0){	
//			String[] valuesArray = new String[5];
//			SearchButton.this.cua.getItems.getTextField(searchName.getValue());
//			SearchButton.this.idt.getInTreeAllInternsWith(SearchButton.this.internsList, valuesArray);
//			
//			
//		}
//	});
	}
		
}
