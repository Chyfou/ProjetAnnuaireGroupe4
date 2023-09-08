package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ShowUseDoc {

	// ********************ATTRIBUTE********************

	// ********************CONSTRUCTOR********************
	/**
	 * Empty constructor.
	 */
	public ShowUseDoc() {
		super();
	}
	
	// ********************PUBLIC METHOD********************
	public void openUseDoc() {
		if (Desktop.isDesktopSupported()) {
		    try {
		        File myFile = new File("src/main/java/files/Directory_app_use_doc.pdf");
		        Desktop.getDesktop().open(myFile);
		    } catch (IOException ex) {
		        System.out.println("Error when reading use documentation pdf.");
		    }
		}
	}
}