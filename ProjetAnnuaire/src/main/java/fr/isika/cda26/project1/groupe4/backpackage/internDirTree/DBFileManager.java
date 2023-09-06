package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DBFileManager implements BackConstants {

//*************************  CONSTRUCTORS  **********************************************	
	public DBFileManager() {

	}
	
//*************************  PUBLIC METHODES  *************************************
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

	/**
	 * Create directories for the DB.
	 */
	public void createDirectories() {
		File directory = new File(DB_URL);
		directory.mkdir();
		System.out.println("Creation of directory : " + DB_URL + " done.");
	}

	/**
	 * Create one DB file in each DB directories.
	 */
	public void createFiles() {
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
	public File getDonFile(Stage stage) {
		FileChooser fileChooser = new FileChooser();
		File donDir = new File(DON_DIR_URL);
		fileChooser.setInitialDirectory(donDir);
		File donFile = null;
		donFile = fileChooser.showOpenDialog(stage.getOwner());
		return donFile;
	}

	/**
	 * Calculate the size in bytes of the intern directory DB file.
	 * @return (:int)
	 */
	public int lengthOfDBFile() {
		String fileName = DB_URL + DIRECTORY_DB_FILE;
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			int lengthToReturn = (int)raf.length();
			raf.close();
			return lengthToReturn;
			
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
