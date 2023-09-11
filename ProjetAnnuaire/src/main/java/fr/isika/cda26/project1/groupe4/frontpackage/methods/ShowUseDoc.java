package fr.isika.cda26.project1.groupe4.frontpackage.methods;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import fri.isika.cda26.project1.groupe4.frontpackage.constants.FrontConstants;

/**
 * Open on user's computer screen application's use documentation.
 * 
 * @author Yoann FRANCOIS.
 *
 */

public class ShowUseDoc implements FrontConstants{
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
				File myFile = new File(DISPLAY_USE_DOC_LABEL);
				Desktop.getDesktop().open(myFile);
			} catch (IOException ex) {
				System.out.println("Error when reading use documentation pdf.");
			}
		}
	}
}