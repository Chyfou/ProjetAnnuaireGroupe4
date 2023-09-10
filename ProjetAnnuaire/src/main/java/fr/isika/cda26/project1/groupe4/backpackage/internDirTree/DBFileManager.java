package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Manage basics methods for all DB files.
 * 
 * @author Thibault SALGUES et Yoann FRANCOIS
 *
 */
public class DBFileManager implements BackConstants {

	private Stage stage;

	// ************************* CONSTRUCTORS
	// **********************************************
	public DBFileManager() {

	}

//*************************  PUBLIC METHODES  *************************************
//*********** BASIC FILE METHODS
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
	 * Create the interns' directory DB file if it not exist.
	 */
	public void createInternsDBFiles() {
		File myNewFile = new File(DB_URL + DIRECTORY_DB_FILE);
		try {
			myNewFile.createNewFile();
			System.out.println("Creation of Interns DB file in directory : " + DB_URL + " .");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error with creation of Interns DB file in directory : " + DB_URL + " .");
			myNewFile = null;
		}
	}

	/**
	 * Create the user's DB file if it not exist.
	 */
	public void createUsersDBFiles() {
		File myNewFile = new File(DB_URL + USER_DB_FILE);
		try {
			myNewFile.createNewFile();
			System.out.println("Creation of Users DB file in directory : " + DB_URL + USER_DB_FILE + " .");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error with creation of Users DB file in directory : " + DB_URL + " .");
			myNewFile = null;
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
	 * 
	 * @return (:int)
	 */
	public int lengthOfDBFile() {
		String fileName = DB_URL + DIRECTORY_DB_FILE;
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			int lengthToReturn = (int) raf.length();
			raf.close();
			return lengthToReturn;

		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Calculate the size in bytes of the users DB file.
	 * 
	 * @return (:int)
	 */
	public int lengthOfUserDBFile() {
		String fileName = DB_URL + USER_DB_FILE;
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			int lengthToReturn = (int) raf.length();
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

//*********** BASIC C.U.D METHODS
	/**
	 * Rewrite intern nodes index to EMPTY_VALUE in the intern directory DB file.
	 * 
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
	 * 
	 * @param newInternIndex (:int)
	 * @param internToWrite  (:Intern)
	 * @return
	 */
	public boolean modifyInPlaceAllIntern(int newInternIndex, Intern internToWrite) {
		internToWrite.setName(prepareAttributeToBeWrite(NAME_SIZE, internToWrite.getName()));
		internToWrite.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, internToWrite.getForename()));
		internToWrite.setPromotion(prepareAttributeToBeWrite(PROMOTION_SIZE, internToWrite.getPromotion()));
		try {
			RandomAccessFile raf = new RandomAccessFile(DB_URL + DIRECTORY_DB_FILE, "rw");
			raf.seek(newInternIndex * INTERN_SIZE);
			raf.writeChars(internToWrite.getName());
			raf.writeChars(internToWrite.getForename());
			raf.writeChars(internToWrite.getLocation());
			raf.writeChars(internToWrite.getPromotion());
			raf.writeInt(internToWrite.getPromotionYear());
			raf.writeInt(internToWrite.getRightNodeIndex());
			raf.writeInt(internToWrite.getLeftNodeIndex());
			raf.writeInt(internToWrite.getEqualNodeIndex());
			System.out.println("New intern " + internToWrite.getName() + " rewrite in interns directory file at index "
					+ newInternIndex);
			raf.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding intern " + internToWrite.getName() + " in interns directory file.");
			return false;
		}
	}

	/**
	 * Rewrite the attributes of an intern in place in the intern directory except
	 * right and left nodes index.
	 * 
	 * @param newInternIndex (:int)
	 * @param internToWrite  (:Intern)
	 * @return
	 */
	public boolean modifyInPlaceAllEqualIntern(int newInternIndex, Intern internToWrite) {
		internToWrite.setName(prepareAttributeToBeWrite(NAME_SIZE, internToWrite.getName()));
		internToWrite.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, internToWrite.getForename()));
		internToWrite.setPromotion(prepareAttributeToBeWrite(PROMOTION_SIZE, internToWrite.getPromotion()));
		try {
			RandomAccessFile raf = new RandomAccessFile(DB_URL + DIRECTORY_DB_FILE, "rw");
			raf.seek(newInternIndex * INTERN_SIZE);
			raf.writeChars(internToWrite.getName());
			raf.writeChars(internToWrite.getForename());
			raf.writeChars(internToWrite.getLocation());
			raf.writeChars(internToWrite.getPromotion());
			raf.writeInt(internToWrite.getPromotionYear());
			raf.readInt();
			raf.readInt();
			raf.writeInt(internToWrite.getEqualNodeIndex());
			System.out.println("New intern " + internToWrite.getName() + " rewrite in interns directory file at index "
					+ newInternIndex);
			raf.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding intern " + internToWrite.getName() + " in interns directory file.");
			return false;
		}
	}

	/**
	 * Rewrite the attributes of an intern in place in the intern directory, except
	 * nodes index.
	 * 
	 * @param newInternIndex (:int)
	 * @param internToWrite  (:Intern)
	 * @return
	 */
	public boolean modifyInPlacePartOfIntern(int newInternIndex, Intern internToWrite) {
		internToWrite.setName(prepareAttributeToBeWrite(NAME_SIZE, internToWrite.getName()));
		internToWrite.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, internToWrite.getForename()));
		internToWrite.setPromotion(prepareAttributeToBeWrite(PROMOTION_SIZE, internToWrite.getPromotion()));
		try {
			RandomAccessFile raf = new RandomAccessFile(DB_URL + DIRECTORY_DB_FILE, "rw");
			raf.seek(newInternIndex * INTERN_SIZE);
			raf.writeChars(internToWrite.getName());
			raf.writeChars(internToWrite.getForename());
			raf.writeChars(internToWrite.getLocation());
			raf.writeChars(internToWrite.getPromotion());
			raf.writeInt(internToWrite.getPromotionYear());
			System.out.println("New intern " + internToWrite.getName() + " " + internToWrite.getForename()
					+ " rewrite in interns directory file at index " + newInternIndex);
			raf.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding intern " + internToWrite.getName() + " in interns directory file.");
			return false;
		}
	}

	/**
	 * Link in intern directory DB file a new intern equal to an other in it's equal
	 * subtree.
	 * 
	 * @param internToLink        (:Intern)
	 * @param parentIntern        (:Intern)
	 * @param indexOfInternToLink (:int)
	 * @return
	 */
	public boolean linkEqualInternsInDB(Intern parentIntern, Intern internToLink, int parentIndex) {
		// Equal subtree is empty.
		if (parentIntern.getEqualNodeIndex() == EMPTY_VALUE) {
			parentIntern.modifyInternLinksInDB(parentIndex, INTERN_DB_MASK[7], internToLink.searchInternIndexInDB());
			parentIntern = parentIntern.getInternInDBAtIndex(parentIndex);
			// There is already an intern in the equal subtree.
		} else {
			Intern newParentIntern = parentIntern.getInternInDBAtIndex(parentIntern.getEqualNodeIndex());
			linkEqualInternsInDB(newParentIntern, internToLink, newParentIntern.searchInternIndexInDB());
		}
		return true;
	}
}
