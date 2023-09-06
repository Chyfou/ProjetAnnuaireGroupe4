package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;
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

	/**
	 * Resize attribute for binary writing.
	 * 
	 * @param size
	 * @param attribute
	 * @return
	 */
	public String prepareAttributeToBeWrite(int size, String attribute) {
		String attributePrepared = "";
		attribute = attribute.trim();
		if (attribute.length() <= size) {
			attributePrepared = attribute;
			for (int i = attribute.length(); i < size; i++) {
				attributePrepared += FILLING_CHAR;
			}
		} else {
			attributePrepared = attribute.substring(0, size);
		}
		return attributePrepared;
	}

	/**
	 * Rewrite intern nodes index to EMPTY_VALUE in the intern directory DB file.
	 * @param internToWrite (:Intern)
	 * @return
	 */
	public boolean setInternDeletedInDB(Intern internToWrite) {
		int currentInternIndex = internToWrite.searchInternIndexInDB();
		internToWrite.modifyInternLinksInDB(currentInternIndex, INTERN_DB_MASK[6], EMPTY_VALUE);
		internToWrite.modifyInternLinksInDB(currentInternIndex, INTERN_DB_MASK[5], EMPTY_VALUE);
		return true;
	}

	/**
	 * Rewrite the attributes of an intern in place in the intern directory 
	 * @param newInternIndex (:int)
	 * @param internToWrite (:Intern)
	 * @return
	 */
	public boolean rewriteInternInPlaceInDB(int newInternIndex, Intern internToWrite) {
		internToWrite.setName(prepareAttributeToBeWrite(NAME_SIZE, internToWrite.getName()));
		internToWrite.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, internToWrite.getForename()));
		internToWrite.setPromotion(prepareAttributeToBeWrite(PROMOTION_SIZE, internToWrite.getPromotion()));
		try {
			RandomAccessFile raf = new RandomAccessFile(DB_URL + DIRECTORY_DB_FILE, "rw");
			raf.seek(newInternIndex*INTERN_SIZE);
			raf.writeChars(internToWrite.getName());
			raf.writeChars(internToWrite.getForename());
			raf.writeChars(internToWrite.getLocation());
			raf.writeChars(internToWrite.getPromotion());
			raf.writeInt(internToWrite.getPromotionYear());
			raf.writeInt(internToWrite.getRightNodeIndex());
			raf.writeInt(internToWrite.getLeftNodeIndex());
			System.out.println("New intern " + internToWrite.getName() + " rewrite in interns directory file at index " + newInternIndex);
			raf.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding intern " + internToWrite.getName() + " in interns directory file.");
			return false;
		}
	}

	/** Rewrite the attributes of an intern in place in the intern directory, except nodes index. 
	 * @param newInternIndex (:int)
	 * @param internToWrite (:Intern)
	 * @return
	 */
	public boolean rewriteInPlaceInDBPartOfIntern(int newInternIndex, Intern internToWrite) {
		internToWrite.setName(prepareAttributeToBeWrite(NAME_SIZE, internToWrite.getName()));
		internToWrite.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, internToWrite.getForename()));
		internToWrite.setPromotion(prepareAttributeToBeWrite(PROMOTION_SIZE, internToWrite.getPromotion()));
		try {
			RandomAccessFile raf = new RandomAccessFile(DB_URL + DIRECTORY_DB_FILE, "rw");
			raf.seek(newInternIndex*INTERN_SIZE);
			raf.writeChars(internToWrite.getName());
			raf.writeChars(internToWrite.getForename());
			raf.writeChars(internToWrite.getLocation());
			raf.writeChars(internToWrite.getPromotion());
			raf.writeInt(internToWrite.getPromotionYear());
			System.out.println("New intern " + internToWrite.getName() + " rewrite in interns directory file at index " + newInternIndex);
			raf.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding intern " + internToWrite.getName() + " in interns directory file.");
			return false;
		}
	}

}
