/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;

/**
 * Infix tree of Intern's directory.
 * 
 * @author Yoann François / Thibault SALGUES
 *
 */
public class InternsDirectoryTree extends DBFileManager implements BackConstants {
//*************************  ATTRIBUTES  *****************************************


//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Empty constructor.
	 * 
	 * @param dBFileUrl (:String)
	 */
	public InternsDirectoryTree() {
		super();
	}


//*************************  GETTERS/SETTERS  ************************************


//********************************** PUBLICS METHODS *****************************

//*********** GETTERS METHODS
	/**
	 * Return all interns in the interns directory DB file with a specific name.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param index (:int)
	 * @param value (:String)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getInTreeAllInternsWithName(List<Intern> internsList, int index, String value) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				if (internOfTheNode.getName().equals(value)) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getName().equals(value)) {
					internsList.add(internOfTheNode);
				}
				internsList = this.getInTreeAllInternsWithName(internsList, internOfTheNode.getRightNodeIndex(), value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreeAllInternsWithName(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getName().equals(value)) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreeAllInternsWithName(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getName().equals(value)) {
					internsList.add(internOfTheNode);
				}
				internsList = this.getInTreeAllInternsWithName(internsList, internOfTheNode.getRightNodeIndex(), value);
			}
		}
		return internsList;
	}

	/**
	 * Return all interns in the interns directory DB file with a specific forename.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param index (:int)
	 * @param value (:String)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithForename(List<Intern> internsList, int index, String value) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				if (internOfTheNode.getForename().equals(value)) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getForename().equals(value)) {
					internsList.add(internOfTheNode);
				}
				internsList = this.getInTreegetAllInternsWithForename(internsList, internOfTheNode.getRightNodeIndex(), value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreegetAllInternsWithForename(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getForename().equals(value)) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreegetAllInternsWithForename(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getForename().equals(value)) {
					internsList.add(internOfTheNode);
				}
				internsList = this.getInTreegetAllInternsWithForename(internsList, internOfTheNode.getRightNodeIndex(), value);
			}
		}
		return internsList;
	}

	/**
	 * Return all interns in the interns directory DB file with a specific promotion.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param index (:int)
	 * @param value (:String)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithPromotion(List<Intern> internsList, int index, String value) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				if (internOfTheNode.getPromotion().equals(value)) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getPromotion().equals(value)) {
					internsList.add(internOfTheNode);
				}
				internsList = getInTreegetAllInternsWithPromotion(internsList, internOfTheNode.getRightNodeIndex(), value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreegetAllInternsWithPromotion(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getPromotion().equals(value)) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreegetAllInternsWithPromotion(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getPromotion().equals(value)) {
					internsList.add(internOfTheNode);
				}
				internsList = this.getInTreegetAllInternsWithPromotion(internsList, internOfTheNode.getRightNodeIndex(), value);
			}
		}
		return internsList;
	}

	/**
	 * Return all interns in the interns directory DB file with a specific location.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param index (:int)
	 * @param value (:String)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithLocation(List<Intern> internsList, int index, String value) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				if (internOfTheNode.getLocation().equals(value)) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getLocation().equals(value)) {
					internsList.add(internOfTheNode);
				}
				internsList = this.getInTreegetAllInternsWithLocation(internsList, internOfTheNode.getRightNodeIndex(), value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreegetAllInternsWithLocation(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getLocation().equals(value)) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreegetAllInternsWithLocation(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getLocation().equals(value)) {
					internsList.add(internOfTheNode);
				}
				internsList = this.getInTreegetAllInternsWithLocation(internsList, internOfTheNode.getRightNodeIndex(), value);
			}
		}
		return internsList;
	}

	/**
	 * Return all interns in the tree with a specific PromotionYear.
	 * @param internsList (:List<Intern>)
	 * @param index (:int)
	 * @param value (:int)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithPromotionYear(List<Intern> internsList, int index, int value) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				if (internOfTheNode.getPromotionYear() == value) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getPromotionYear() == value) {
					internsList.add(internOfTheNode);
				}
				internsList = this.getInTreegetAllInternsWithPromotionYear(internsList, internOfTheNode.getRightNodeIndex(), value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreegetAllInternsWithPromotionYear(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getPromotionYear() == value) {
					internsList.add(internOfTheNode);
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreegetAllInternsWithPromotionYear(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getPromotionYear() == value) {
					internsList.add(internOfTheNode);
				}
				internsList = this.getInTreegetAllInternsWithPromotionYear(internsList, internOfTheNode.getRightNodeIndex(), value);
			}
		}
		return internsList;
	}

	/**
	 * Get by order all interns in the interns directory DB file.
	 *@param internsList (:List<Intern>)
	 * @param index (:int)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getAllInternInDB(List<Intern> internsList, int index) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList.add(internOfTheNode);
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				internsList.add(internOfTheNode);
				internsList = this.getAllInternInDB(internsList, internOfTheNode.getRightNodeIndex());
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getAllInternInDB(internsList, internOfTheNode.getLeftNodeIndex());
				internsList.add(internOfTheNode);
				// Case Intern has two children.
			} else {
				internsList = this.getAllInternInDB(internsList, internOfTheNode.getLeftNodeIndex());
				internsList.add(internOfTheNode);
				internsList = this.getAllInternInDB(internsList, internOfTheNode.getRightNodeIndex());
			}
		}
		return internsList;
	}

	/**
	 * Extract one intern from the interns directory file at the required position.
	 * @param internIndex (:int)
	 * @return (:Intern)
	 */
	public Intern getInternInDBAtIndex(int internIndex) {
		Intern internToReturn = new Intern();
		String fileName = DB_URL + DIRECTORY_DB_FILE;
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "r");
			rf.seek(internIndex * INTERN_SIZE);
			String internName = "";
			for (int j = 0; j < NAME_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					internName += charRead;
				}
			}
			internToReturn.setName(internName);

			String internForename = "";
			for (int j = 0; j < FORENAME_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					internForename += charRead;
				}
			}
			internToReturn.setForename(internForename);

			String internLocation = "";
			for (int j = 0; j < LOCATION_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					internLocation += charRead;
				}
			}
			internToReturn.setLocation(internLocation);

			String internPromotion = "";
			for (int j = 0; j < PROMOTION_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					internPromotion += charRead;
				}
			}
			internToReturn.setPromotion(internPromotion);

			int internPromotionYear = rf.readInt();
			internToReturn.setPromotionYear(internPromotionYear);

			int internRightNodeIndex = rf.readInt();
			internToReturn.setRightNodeIndex(internRightNodeIndex);

			int internLeftNodeIndex = rf.readInt();
			internToReturn.setLeftNodeIndex(internLeftNodeIndex);
			rf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return internToReturn;
	}

//*********** C.U.D METHODS
	/**
	 * Delete an InternNode of the interns directory tree.
	 * 
	 * @param internToDelete (:Intern)
	 * @return (:Boolean)
	 */
	public boolean deleteInternInDB(Intern internToDelete) {
		Intern rootIntern = this.getInternInDBAtIndex(START_VALUE);
		int fileLenght = lengthOfDBFile();
		System.out.println(fileLenght);
		// No root case. Nothing to delete.
		if (fileLenght < INTERN_SIZE) {
			return false;
		// Root to delete.
		} else if (rootIntern.compareTo(internToDelete) == 0) {
			// Root has no children.
			if (rootIntern.getLeftNodeIndex() == EMPTY_VALUE && rootIntern.getRightNodeIndex() == EMPTY_VALUE) {
				eraseFilesContents();
				// Root has only one right child.
			} else if (rootIntern.getRightNodeIndex() != EMPTY_VALUE && rootIntern.getLeftNodeIndex() == EMPTY_VALUE) {
				Intern rightChildIntern = this.getInternInDBAtIndex(rootIntern.getRightNodeIndex());
				setInternDeletedInDB(rightChildIntern);
				modifyInPlaceAllIntern(START_VALUE, rightChildIntern);
				// Root has only one left child.
			} else if (rootIntern.getRightNodeIndex() == EMPTY_VALUE && rootIntern.getLeftNodeIndex() != EMPTY_VALUE) {
				Intern leftChildIntern = this.getInternInDBAtIndex(rootIntern.getLeftNodeIndex());
				setInternDeletedInDB(leftChildIntern);
				modifyInPlaceAllIntern(START_VALUE, leftChildIntern);
				
			// Root has two children.
			} else {
				// Set as root a copy of the InternNode in the tree with the nearest higher
				// Intern value.
				Intern nearestChildIntern = rootIntern.getNearestInternChild();
				rootIntern.searchInternToDelete(nearestChildIntern);
				modifyInPlacePartOfIntern(START_VALUE,  nearestChildIntern);
				
			}
			return true;
		// Case with one root that may contains the node to delete.
		} else {
			
			return rootIntern.searchInternToDelete(internToDelete);
		}
	}

	/**
	 * Modify an intern object and replace it in the intern directory DB file .
	 * @param previousIntern (:Intern)
	 * @param modifiedIntern (:Intern)
	 */
	public void modifyHardInternInDBFile(Intern previousIntern, Intern modifiedIntern) {
		deleteInternInDB(previousIntern);
		modifiedIntern.setRightNodeIndex(EMPTY_VALUE);
		modifiedIntern.setLeftNodeIndex(EMPTY_VALUE);
		modifiedIntern.setEqualNodeIndex(EMPTY_VALUE);
		modifiedIntern.addInternInDB();
	}

}
