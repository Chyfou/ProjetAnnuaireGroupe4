/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Infix tree of Intern's directory.
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
				if (intern.getName().contains(valuesArray[0])) {
					internsCollectorList.add(intern);
				}
			}
			internsList = new ArrayList<Intern>(internsCollectorList);
			internsCollectorList.clear();
		}
		if (valuesArray[1] != null) {
			for (Intern intern : internsList) {
				if (intern.getForename().contains(valuesArray[1])) {
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
				if (intern.getPromotion().contains(valuesArray[3])) {
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
	 * Return all interns in the interns directory DB file with a specific name.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param index       (:int)
	 * @param value       (:String)
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
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getName().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				internsList = this.getInTreeAllInternsWithName(internsList, internOfTheNode.getRightNodeIndex(), value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreeAllInternsWithName(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getName().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreeAllInternsWithName(internsList, internOfTheNode.getLeftNodeIndex(), value);
				if (internOfTheNode.getName().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
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
	 * @param index       (:int)
	 * @param value       (:String)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getInTreeAllInternsWithForename(List<Intern> internsList, int index, String value) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				if (internOfTheNode.getForename().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getForename().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				internsList = this.getInTreeAllInternsWithForename(internsList, internOfTheNode.getRightNodeIndex(),
						value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreeAllInternsWithForename(internsList, internOfTheNode.getLeftNodeIndex(),
						value);
				if (internOfTheNode.getForename().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreeAllInternsWithForename(internsList, internOfTheNode.getLeftNodeIndex(),
						value);
				if (internOfTheNode.getForename().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				internsList = this.getInTreeAllInternsWithForename(internsList, internOfTheNode.getRightNodeIndex(),
						value);
			}
		}
		return internsList;
	}

	/**
	 * Return all interns in the interns directory DB file with a specific
	 * promotion.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param index       (:int)
	 * @param value       (:String)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getInTreeAllInternsWithPromotion(List<Intern> internsList, int index, String value) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				if (internOfTheNode.getPromotion().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getPromotion().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				internsList = getInTreeAllInternsWithPromotion(internsList, internOfTheNode.getRightNodeIndex(), value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreeAllInternsWithPromotion(internsList, internOfTheNode.getLeftNodeIndex(),
						value);
				if (internOfTheNode.getPromotion().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreeAllInternsWithPromotion(internsList, internOfTheNode.getLeftNodeIndex(),
						value);
				if (internOfTheNode.getPromotion().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				internsList = this.getInTreeAllInternsWithPromotion(internsList, internOfTheNode.getRightNodeIndex(),
						value);
			}
		}
		return internsList;
	}

	/**
	 * Return all interns in the interns directory DB file with a specific location.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param index       (:int)
	 * @param value       (:String)
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
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getLocation().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				internsList = this.getInTreegetAllInternsWithLocation(internsList, internOfTheNode.getRightNodeIndex(),
						value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreegetAllInternsWithLocation(internsList, internOfTheNode.getLeftNodeIndex(),
						value);
				if (internOfTheNode.getLocation().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreegetAllInternsWithLocation(internsList, internOfTheNode.getLeftNodeIndex(),
						value);
				if (internOfTheNode.getLocation().equals(value)) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				internsList = this.getInTreegetAllInternsWithLocation(internsList, internOfTheNode.getRightNodeIndex(),
						value);
			}
		}
		return internsList;
	}

	/**
	 * Return all interns in the tree with a specific PromotionYear.
	 * 
	 * @param internsList (:List<Intern>)
	 * @param index       (:int)
	 * @param value       (:int)
	 * @return (::List<Intern>)
	 */
	public List<Intern> getInTreeAllInternsWithPromotionYear(List<Intern> internsList, int index, int value) {
		int fileLenght = lengthOfDBFile();
		if (fileLenght != 0) {
			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Case Intern has no child.
			if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				if (internOfTheNode.getPromotionYear() == value) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has only one right child.
			} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() != EMPTY_VALUE) {
				if (internOfTheNode.getPromotionYear() == value) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				internsList = this.getInTreeAllInternsWithPromotionYear(internsList,
						internOfTheNode.getRightNodeIndex(), value);
				// Case Intern has only one left child.
			} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE
					&& internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
				internsList = this.getInTreeAllInternsWithPromotionYear(internsList, internOfTheNode.getLeftNodeIndex(),
						value);
				if (internOfTheNode.getPromotionYear() == value) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				// Case Intern has two children.
			} else {
				internsList = this.getInTreeAllInternsWithPromotionYear(internsList, internOfTheNode.getLeftNodeIndex(),
						value);
				if (internOfTheNode.getPromotionYear() == value) {
					internsList.addAll(getInternAndEquals(internOfTheNode));
				}
				internsList = this.getInTreeAllInternsWithPromotionYear(internsList,
						internOfTheNode.getRightNodeIndex(), value);
			}
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

			int internEqualNodeIndex = rf.readInt();
			internToReturn.setEqualNodeIndex(internEqualNodeIndex);
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
	 * Get all attributes to modify in an intern and modifiy it in the interns
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
		}
		if (valuesArray[2] != null) {
			modifiedIntern.setLocation(valuesArray[2]);
		}
		if (valuesArray[3] != null) {
			modifiedIntern.setPromotion(valuesArray[3]);
		}
		if (valuesArray[4] != null) {
			modifiedIntern.setPromotionYear(Integer.valueOf(valuesArray[4]));
		}
		if (valuesArray[0] != null) {
			modifiedIntern.setName(valuesArray[0]);
			modifyHardInternInDBFile(previousIntern, modifiedIntern);
		} else {
			modifiedIntern.setName(previousIntern.getName());
			modifyInPlacePartOfIntern(previousIntern.searchInternIndexInDB(), modifiedIntern);

		}
		System.out.println("Intern " + previousIntern + " has been midified into " + modifiedIntern);
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
			Intern equalChildIntern = getInternInDBAtIndex(rootIntern.getEqualNodeIndex());
			setInternDeletedInDB(equalChildIntern);
			modifyInPlaceAllEqualIntern(START_VALUE, equalChildIntern);
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
			rootIntern.searchInternToDeleteInSubTrees(nearestChildIntern);
			modifyInPlacePartOfIntern(START_VALUE, nearestChildIntern);
		}
		System.out.println("Intern " + internToDelete.getName() + " has been deleted from DB.");
		return true;
	}

}