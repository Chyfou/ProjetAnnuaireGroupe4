package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.stage.Stage;

/**
 * Initializer of the Interns directory DB files of the application.
 * 
 * @author Thibault SALGUES & Yoann FRANCOIS.
 *
 */
public class DBInit extends DBFileManager {
	
//*************************  CONSTRUCTORS  **********************************************	
	/**
	 * Empty constructor. Initialize the Db directories and files.
	 */
	public DBInit(Stage stage) {
		super();
		int lengthDBfile = lengthOfDBFile();
		if (lengthDBfile == 0) {
			System.out.println("Initializing DB.");
			System.out.println("Initializing DB files.");
			createInternsDBFiles();
			System.out.println("Files created.");
			System.out.println("Ask Admin for DON files.");
			File donFile = getDonFile(stage);
			System.out.println("DON files caught.");
			System.out.println("Reading DON File in progress");
			writeInternsInDBFrom(donFile);
			System.out.println("Reading Don file done.");
		}
	}

//********************************** PRIVATES METHODS ************************************
	/**
	 * Get all values in DON file to create Interns Object in Binary DB file.
	 * 
	 * @param donFile (:File)
	 */
	private void writeInternsInDBFrom(File donFile) {
		FileReader fr;
		try {
			fr = new FileReader(donFile);
			BufferedReader br = new BufferedReader(fr);
			String content = "";
			while (br.ready()) {
				int iterator = START_VALUE;

				while (iterator != STOP_VALUE) {
					Intern internToAdd = new Intern();
					content = br.readLine();
					internToAdd.setName(content);
					content = br.readLine();
					internToAdd.setForename(content);
					content = br.readLine();
					internToAdd.setLocation(content);
					content = br.readLine();
					internToAdd.setPromotion(content);
					content = br.readLine();
					internToAdd.setPromotionYear(Integer.valueOf(content));
					content = br.readLine();
					iterator = STOP_VALUE;
					internToAdd.addInternInDB();
					// internToAdd.writeInternInDB();
				}
			}
			File db = new File(DB_URL + DIRECTORY_DB_FILE);
			System.out.println(db.length());
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
