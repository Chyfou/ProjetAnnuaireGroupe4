/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Manager of all Intern directory DB file's methods for the frontend .
 * 
 * @author Yoann François / Thibault SALGUES
 *
 */
public class InternsDirectoryTree extends DBFileManager {
//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Empty constructor.
	 * 
	 * @param dBFileUrl (:String)
	 */
	public InternsDirectoryTree() {
		super();
	}

//********************************** PUBLICS METHODS *****************************
//*********** GETTERS METHODS
	/**
	 * Select in the current list all interns containing the required values for
	 * their attributes.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param valuesArray (:String[])
	 * @return
	 */
	public List<Intern> getInTreeAllInternsWith(List<Intern> internsList, String[] valuesArray) {
		List<Intern> internsCollectorList = new ArrayList<Intern>();
		if (valuesArray[0] != null) {
			for (Intern intern : internsList) {
				if (intern.getName().toLowerCase().contains(valuesArray[0].toLowerCase())) {
					internsCollectorList.add(intern);
				}
			}
			internsList = new ArrayList<Intern>(internsCollectorList);
			internsCollectorList.clear();
		}
		if (valuesArray[1] != null) {
			for (Intern intern : internsList) {
				if (intern.getForename().toLowerCase().contains(valuesArray[1].toLowerCase())) {
					internsCollectorList.add(intern);
				}
			}
			internsList = new ArrayList<Intern>(internsCollectorList);
			internsCollectorList.clear();
		}
		if (valuesArray[2] != null) {
			for (Intern intern : internsList) {
				if (intern.getLocation().contains(valuesArray[2])) {
					internsCollectorList.add(intern);
				}
			}
			internsList = new ArrayList<Intern>(internsCollectorList);
			internsCollectorList.clear();
		}
		if (valuesArray[3] != null) {
			for (Intern intern : internsList) {
				if (intern.getPromotion().toLowerCase().contains(valuesArray[3].toLowerCase())) {
					internsCollectorList.add(intern);
				}
			}
			internsList = new ArrayList<Intern>(internsCollectorList);
			internsCollectorList.clear();
		}
		if (valuesArray[4] != null) {
			for (Intern intern : internsList) {
				if (intern.getPromotionYear().toString().contains(valuesArray[4])) {
					internsCollectorList.add(intern);
				}
			}
			internsList = new ArrayList<Intern>(internsCollectorList);
			internsCollectorList.clear();
		}
		return internsList;
	}

	/**
	 * Get by order all interns in the interns directory DB file.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param index       (:int)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getAllInternInDB(List<Intern> internsList, int index) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList.addAll(getInternAndEquals(internOfTheNode));
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				internsList.addAll(getInternAndEquals(internOfTheNode));
				internsList = this.getAllInternInDB(internsList, internOfTheNode.getRightNodeIndex());
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getAllInternInDB(internsList, internOfTheNode.getLeftNodeIndex());
				internsList.addAll(getInternAndEquals(internOfTheNode));
				// Case Intern has two children.
			} else {
				internsList = this.getAllInternInDB(internsList, internOfTheNode.getLeftNodeIndex());
				internsList.addAll(getInternAndEquals(internOfTheNode));
				internsList = this.getAllInternInDB(internsList, internOfTheNode.getRightNodeIndex());
			}
		}
		return internsList;
	}

	/**
	 * Extract one intern from the interns directory file at the required position.
	 * 
	 * @param internIndex (:int)
	 * @return (:Intern)
	 */
	public Intern getInternInDBAtIndex(int internIndex) {
		Intern internToReturn = new Intern();
		String fileName = DB_URL + DIRECTORY_DB_FILE;
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "r");
			raf.seek(internIndex * INTERN_SIZE);
			String internName = "";
			for (int j = 0; j < NAME_SIZE; j++) {
				String charRead = "";
				charRead += raf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					internName += charRead;
				}
			}
			internToReturn.setName(internName);

			String internForename = "";
			for (int j = 0; j < FORENAME_SIZE; j++) {
				String charRead = "";
				charRead += raf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					internForename += charRead;
				}
			}
			internToReturn.setForename(internForename);

			String internLocation = "";
			for (int j = 0; j < LOCATION_SIZE; j++) {
				String charRead = "";
				charRead += raf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					internLocation += charRead;
				}
			}
			internToReturn.setLocation(internLocation);

			String internPromotion = "";
			for (int j = 0; j < PROMOTION_SIZE; j++) {
				String charRead = "";
				charRead += raf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					internPromotion += charRead;
				}
			}
			internToReturn.setPromotion(internPromotion);

			int internPromotionYear = raf.readInt();
			internToReturn.setPromotionYear(internPromotionYear);

			int internRightNodeIndex = raf.readInt();
			internToReturn.setRightNodeIndex(internRightNodeIndex);

			int internLeftNodeIndex = raf.readInt();
			internToReturn.setLeftNodeIndex(internLeftNodeIndex);

			int internEqualNodeIndex = raf.readInt();
			internToReturn.setEqualNodeIndex(internEqualNodeIndex);
			raf.close();

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
		// No root case. Nothing to delete.
		if (fileLenght < INTERN_SIZE) {
			System.out.println("Intern to delete " + internToDelete.getName() + " not found");
			return false;
		// Root matches the intern to delete.
		} else if (rootIntern.compareNameTo(internToDelete) == 0) {
			// Root intern is the intern to delete.
			if (rootIntern.compareTo(internToDelete) == 0) {		
				return deleteRootIntern(internToDelete, rootIntern);
			// One of the equal child of the root may be the intern to delete.
			} else {
				return searchEqualInternToDelete(internToDelete, rootIntern);
			}
		// One of the right or left subtree of the root  may contain the intern to delete.
		} else {
			return rootIntern.searchInternToDeleteInSubTrees(internToDelete);
		}
	}

	/**
	 * Modify an intern object and replace it in the intern directory DB file .
	 * 
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

	/**
	 * Get all attributes to modify in an intern and modify it in the interns
	 * directory DB files.
	 * 
	 * @param previousIntern (:Intern)
	 * @param valuesArray    (: String[])
	 * @return (:boolean)
	 */
	public boolean modifyInternGlobal(Intern previousIntern, String[] valuesArray) {
		Intern modifiedIntern = new Intern();
		if (valuesArray[1] != null) {
			modifiedIntern.setForename(valuesArray[1]);
		} else {
			modifiedIntern.setForename(previousIntern.getForename());
		}
		if (valuesArray[2] != null) {
			modifiedIntern.setLocation(valuesArray[2]);
		} else {
			modifiedIntern.setLocation(previousIntern.getLocation());
		}
		if (valuesArray[3] != null) {
			modifiedIntern.setPromotion(valuesArray[3]);
		} else {
			modifiedIntern.setPromotion(previousIntern.getPromotion());
		}
		if (valuesArray[4] != null && valuesArray[4].length() == 4) {
			modifiedIntern.setPromotionYear(Integer.valueOf(valuesArray[4]));
		} else {
			modifiedIntern.setPromotionYear(previousIntern.getPromotionYear());
		}
		
		if (valuesArray[0] != null) {
			if (!valuesArray[0].toLowerCase().equals(previousIntern.getName().toLowerCase())) {
				modifiedIntern.setName(valuesArray[0]);
				modifyHardInternInDBFile(previousIntern, modifiedIntern);
			} else {
				modifiedIntern.setName(previousIntern.getName());
				modifyInPlacePartOfIntern(previousIntern.searchInternIndexInDB(), modifiedIntern);
			}
		} else {
			modifiedIntern.setName(previousIntern.getName());
			modifyInPlacePartOfIntern(previousIntern.searchInternIndexInDB(), modifiedIntern);

		}
		System.out.println("Intern " + previousIntern + " has been modified into " + modifiedIntern);
		return true;
	}

	/**
	 * Search intern to delete in the equal children of the root.
	 * 
	 * @param internToDelete (:Intern)
	 * @param parentIntern   (:Intern)
	 * @return (: boolean)
	 */
	public boolean searchEqualInternToDelete(Intern internToDelete, Intern parentIntern) {
		// Parent intern has no equal intern.
		if (parentIntern.getEqualNodeIndex() == EMPTY_VALUE) {
			System.out.println("Intern to delete " + internToDelete.getName() + " not found");
			return false;
			// Parent intern has has one equal child.
		} else {
			Intern equalChild = getInternInDBAtIndex(parentIntern.getEqualNodeIndex());
			// Equal child match the intern to delete and...
			if (equalChild.compareTo(internToDelete) == 0) {
				// ... has no equal child.
				if (equalChild.getEqualNodeIndex() == EMPTY_VALUE) {
					parentIntern.modifyInternLinksInDB(parentIntern.searchInternIndexInDB(), INTERN_DB_MASK[7],
							EMPTY_VALUE);
					// ... has one equal child.
				} else {
					parentIntern.modifyInternLinksInDB(parentIntern.searchInternIndexInDB(), INTERN_DB_MASK[7],
							equalChild.getEqualNodeIndex());
				}
				System.out.println("Intern " + internToDelete.getName() + " has been deleted from DB.");
				return true;
				// Equal child doesn't match the intern to delete and...
			} else {
				// ... has no equal child.
				if (equalChild.getEqualNodeIndex() == EMPTY_VALUE) {
					System.out.println("Intern to delete " + internToDelete.getName() + " not found");
					return false;
					// ... has one equal child.
				} else {
					return searchEqualInternToDelete(internToDelete, equalChild);
				}
			}

		}
	}

//********************************** PRIVATES METHODS *****************************
	/**
	 * Get an intern of a node and all it's equal children.
	 * 
	 * @param internToGet
	 * @return
	 */
	private List<Intern> getInternAndEquals(Intern internToGet) {
		List<Intern> internListToReturn = new ArrayList<Intern>();
		if (internToGet.getEqualNodeIndex() == EMPTY_VALUE) {
			internListToReturn.add(internToGet);
		} else {
			internListToReturn = internToGet.getInternAndEqualsInSubTree(internListToReturn);
		}
		return internListToReturn;
	}

	/**
	 * Delete the root intern from the intern directory DB file.
	 * 
	 * @param internToDelete (:Intern)
	 * @param rootIntern     (:Intern)
	 * @return (:boolean)
	 */
	private boolean deleteRootIntern(Intern internToDelete, Intern rootIntern) {
		// Root has at lest one equal child, which will take it's place.
		if (rootIntern.getEqualNodeIndex() != EMPTY_VALUE) {
			System.out.println("//////////////////5///////////////"+ rootIntern);
			Intern equalChildIntern = getInternInDBAtIndex(rootIntern.getEqualNodeIndex());
			setInternDeletedInDB(equalChildIntern);
			modifyInPlaceAllEqualIntern(START_VALUE, equalChildIntern);
			System.out.println("//////////////////5///////////////"+ this.getInternInDBAtIndex(START_VALUE));
			// Root has no equal child to take it's place.
			System.out.println("Intern " + internToDelete.getName() + " has been deleted from DB.");
			return true;
		} else {
			return deleteRootFromSubtree(internToDelete, rootIntern);
		}

	}

	/**
	 * Delete the root intern and rebase one of its left or right child in it's
	 * place.
	 * 
	 * @param internToDelete (:Intern)
	 * @param rootIntern     (:Intern)
	 * @return (:boolean)
	 */
	private boolean deleteRootFromSubtree(Intern internToDelete, Intern rootIntern) {
		// Root has no right or left child.
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
			System.out.println("************FIND*****"+nearestChildIntern);
			rootIntern.searchInternToDeleteInSubTrees(nearestChildIntern);
			modifyInPlacePartOfIntern(START_VALUE, nearestChildIntern);
		}
		System.out.println("Intern " + internToDelete.getName() + " has been deleted from DB.");
		return true;
	}

}