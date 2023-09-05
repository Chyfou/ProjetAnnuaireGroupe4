package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Initializer of the DB files of the application.
 * 
 * @author  Yoann François / Thibault SALGUES
 *
 */
public class DBInit implements BackConstants {

	/**
	 * Empty constructor. Initialize the Db directories and files.
	 */
	public DBInit(Stage stage) {
		System.out.println("Initializing DB.");
		createDirectories();
		System.out.println("Directories created.");
		System.out.println("Initializing DB files.");
		createFiles();
		eraseFilesContents();
		System.out.println("Files created.");
		System.out.println("Ask Admin for DON files.");
		File donFile = getDonFile(stage);
		System.out.println("DON files caught.");
		System.out.println("Reading DON File in progress");
		writeInternsInDBFrom(donFile);
		System.out.println("Reading Don file done.");
	}

//********************************** PRIVATES METHODS ************************************

	/**
	 * Create directories for the DB.
	 */
	private void createDirectories() {
		File directory = new File(DB_URL);
		directory.mkdir();
		System.out.println("Creation of directory : " + DB_URL + " done.");
	}

	/**
	 * Create one DB file in each DB directories.
	 */
	private void createFiles() {
		for (String file : FILES_LIST) {
			File myNewFile = new File(DB_URL + file);
			try {
				myNewFile.createNewFile();
				System.out.println("Creation of DB file for directory : " + DB_URL + " .");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error with creation of DB file for directory : " + DB_URL + " .");
				myNewFile = null;
			}
		}
	}

	/**
	 * Ask the user to get the DON file from it's desktop and return it.
	 * 
	 * @param stage (:stage)
	 * @return (:file)
	 */
	private File getDonFile(Stage stage) {
		FileChooser fileChooser = new FileChooser();
		File donDir = new File(DON_DIR_URL);
		fileChooser.setInitialDirectory(donDir);
		File donFile = null;
		donFile = fileChooser.showOpenDialog(stage.getOwner());
		return donFile;
	}

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
					//internToAdd.writeInternInDB();
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

	/**
	 * Erase content of all DB Files.
	 */
	public void eraseFilesContents() {
		for (String file : FILES_LIST) {
			String pathToFile = DB_URL.concat(file);
			try {
				PrintWriter pw = new PrintWriter(pathToFile);
				pw.close();
				System.out.println("File " + pathToFile + " has been erased.");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error. File " + pathToFile + " hasn't been erased.");
			}
		}
	}

}
