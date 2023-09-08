package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 * Intern of the intern's directory.
 * 
 * @author Thibault SALGUES
 *
 */
public class Intern extends InternsDirectoryTree implements Comparable<Intern> {
//*************************  ATTRIBUTES  *****************************************
	private String name;
	private String forename;
	private String promotion;
	private String location;
	private Integer promotionYear;
	private Integer rightNodeIndex;
	private Integer leftNodeIndex;
	private Integer equalNodeIndex;

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Full constructor.
	 * 
	 * @param name           (:String)
	 * @param forename       (:String)
	 * @param promotion      (:String)
	 * @param location       (:String)
	 * @param promotionYear  (:Integer)
	 * @param rightNodeIndex (:Integer)
	 * @param leftNodeIndex  (:Integer)
	 */
	public Intern(String name, String forename, String promotion, String location, Integer promotionYear,
			int rightNodeIndex, int leftNodeIndex, int equalNodeIndex) {
		super();
		this.forename = forename;
		this.promotion = promotion;
		this.promotion = promotion;
		this.location = location;
		this.promotionYear = promotionYear;
		this.rightNodeIndex = rightNodeIndex;
		this.leftNodeIndex = leftNodeIndex;
		this.equalNodeIndex = equalNodeIndex;
	}

	/**
	 * Constructor with all attributes except nodes' index that are set to null.
	 * 
	 * @param name          (:String)
	 * @param forename      (:String)
	 * @param promotion     (:String)
	 * @param location      (:String)
	 * @param promotionYear (:Integer)
	 * 
	 */
	public Intern(String name, String forename, String promotion, String location, Integer promotionYear) {
		super();
		this.name = name;
		this.forename = forename;
		this.promotion = promotion;
		this.location = location;
		this.promotionYear = promotionYear;
		this.rightNodeIndex = EMPTY_VALUE;
		this.leftNodeIndex = EMPTY_VALUE;
		this.equalNodeIndex = EMPTY_VALUE;
	}

	/**
	 * Empty constructor.
	 */
	public Intern() {
		super();
		this.name = "";
		this.forename = "";
		this.promotion = "";
		this.location = "";
		this.promotionYear = EMPTY_VALUE;
		this.rightNodeIndex = EMPTY_VALUE;
		this.leftNodeIndex = EMPTY_VALUE;
		this.equalNodeIndex = EMPTY_VALUE;
	}

	/**
	 * Copy constructor.
	 */
	public Intern(Intern internToCopie) {
		super();
		this.name = internToCopie.getName();
		this.forename = internToCopie.getForename();
		this.promotion = internToCopie.getPromotion();
		this.location = internToCopie.getLocation();
		this.promotionYear = internToCopie.getPromotionYear();
		this.rightNodeIndex = internToCopie.getRightNodeIndex();
		this.leftNodeIndex = internToCopie.getLeftNodeIndex();
		this.equalNodeIndex = internToCopie.getEqualNodeIndex();
	}

//*************************  GETTERS/SETTERS  ************************************
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPromotionYear() {
		return promotionYear;
	}

	public void setPromotionYear(Integer promotionYear) {
		this.promotionYear = promotionYear;
	}

	public Integer getRightNodeIndex() {
		return rightNodeIndex;
	}

	public void setRightNodeIndex(Integer rightNodeIndex) {
		this.rightNodeIndex = rightNodeIndex;
	}

	public Integer getLeftNodeIndex() {
		return leftNodeIndex;
	}

	public void setLeftNodeIndex(Integer leftNodeIndex) {
		this.leftNodeIndex = leftNodeIndex;
	}

	public Integer getEqualNodeIndex() {
		return equalNodeIndex;
	}

	public void setEqualNodeIndex(Integer equalNodeIndex) {
		this.equalNodeIndex = equalNodeIndex;
	}

// ************************* OVERRIDEN METHODES ************************************
	/**
	 * Overridden method Compare two interns using all their attributes except their
	 * nodes's index.
	 */
	@Override
	public int compareTo(Intern internToCompare) {
		int i = this.name.compareTo(internToCompare.getName());
		if (i == 0) {
			i = this.forename.compareTo(internToCompare.getForename());
			if (i == 0) {
				i = this.promotion.compareTo(internToCompare.getPromotion());
				if (i == 0) {
					i = this.location.compareTo(internToCompare.getLocation());
					if (i == 0) {
						i = this.promotionYear.compareTo(internToCompare.getPromotionYear());
					}
				}
			}
		}
		return i;
	}

	/**
	 * Overridden method Print all attributes of the intern object.
	 */
	@Override
	public String toString() {
		return "Intern [name=" + name + ", forename=" + forename + ", promotion=" + promotion + ", location=" + location
				+ ", promotionYear=" + promotionYear + ", equalNodeIndex=" + equalNodeIndex + ", rightNodeIndex="
				+ rightNodeIndex + ", leftNodeIndex=" + leftNodeIndex + "]";
	}

	/**
	 * Compare two interns using only their names.
	 * 
	 * @param internToCompare (:Intern)
	 * @return (:int)
	 */
	public int compareNameTo(Intern internToCompare) {
		int i = (this.getName()).compareTo(internToCompare.getName());
		return i;

	}
//*************************  PUBLIC METHODES  ***************************************

//*********** C.U.D METHODS	
	/**
	 * Add a new InternNode in the interns directory tree with an infix order.
	 *
	 * @param key (:String)
	 */
	public void linkInternInDB(int index) {
		String fileName = DB_URL + DIRECTORY_DB_FILE;
		try {

			Intern internOfTheNode = getInternInDBAtIndex(index);
			internOfTheNode.setName(prepareAttributeToBeWrite(NAME_SIZE, internOfTheNode.getName()));
			internOfTheNode.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, internOfTheNode.getForename()));
			internOfTheNode.setPromotion(prepareAttributeToBeWrite(PROMOTION_SIZE, internOfTheNode.getPromotion()));

			// Open DB file.
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			int indexOfNewIntern = ((int) (raf.length() / INTERN_SIZE) - 1);
			// Case intern to add in the left subtree.
			if (this.compareNameTo(internOfTheNode) < 0) {
				// Case with no left subtree. Add intern in a new node.
				if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE) {
					internOfTheNode.setLeftNodeIndex(indexOfNewIntern);
					raf.close();
					internOfTheNode.modifyInternLinksInDB(index, INTERN_DB_MASK[6], indexOfNewIntern);
					// Case with one left subtree. Go on searching in left place to add the intern.
				} else {
					raf.close();
					this.linkInternInDB(internOfTheNode.getLeftNodeIndex());
				}
				// Case intern to add in the right subtree.
			} else if (this.compareNameTo(internOfTheNode) > 0) {
				// Case with no right subtree. Add intern in a new node.
				if (internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
					raf.close();
					internOfTheNode.setRightNodeIndex(indexOfNewIntern);
					internOfTheNode.modifyInternLinksInDB(index, INTERN_DB_MASK[5], indexOfNewIntern);
					// Case with one right subtree. Go on searching in right place to add the
					// intern.
				} else {
					raf.close();
					this.linkInternInDB(internOfTheNode.getRightNodeIndex());
				}
				// Case intern to add in the equal subtree.
			} else {
				raf.close();
				this.linkEqualInternsInDB(internOfTheNode, this, index);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modify right and left index of intern in DB file.
	 * 
	 * @param indexOfAttribute (:int)
	 * @param indexOfChild     (:int)
	 * @param myIndex          (:int)
	 */
	public void modifyInternLinksInDB(int myIndex, int indexOfAttribute, int indexValue) {
		try {
			RandomAccessFile raf = new RandomAccessFile(DB_URL + DIRECTORY_DB_FILE, "rw");
			raf.seek(indexOfAttribute + (myIndex * INTERN_SIZE));
			// Modify the left node index.
			if (indexOfAttribute == INTERN_DB_MASK[6]) {
				raf.writeInt(indexValue);
				System.out.println("Left Node index modify for intern " + this.getName() + ".");
				// modify the right node index.
			} else if (indexOfAttribute == INTERN_DB_MASK[5]) {
				raf.writeInt(indexValue);
				System.out.println("Right Node index modify for intern " + this.getName() + ".");
			} else {
				raf.writeInt(indexValue);
				System.out.println("Equal Node index modify for intern " + this.getName() + ".");
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while modifyaing intern " + this.getName() + " in interns directory file.");
		}
	}

	/**
	 * Search an intern to delete in the interns directory DB file and delete it, if
	 * it's found.
	 * 
	 * @param internToDelete (:Intern)
	 * @return (:boolean)
	 */
	public boolean searchInternToDeleteInSubTrees(Intern internToDelete) {
		System.out.println("******************* " + this.getName() + "  " + this.getForename());
		// Case with intern not found in the tree
		if (this.getRightNodeIndex() == EMPTY_VALUE && this.getLeftNodeIndex() == EMPTY_VALUE) {
			System.out.println("Intern to delete " + internToDelete.getName() + " not found");
			return false;
			// Case with intern may be found in the right subtree
		} else if (this.compareNameTo(internToDelete) < 0) {
			System.out.println("************Go right********************");
			return this.searchInternToDeleteInAllChildren(internToDelete, this.getRightNodeIndex(), INTERN_DB_MASK[5]);
			// Case with intern may be found in the left subtree
		} else if (this.compareNameTo(internToDelete) > 0) {
			System.out.println("************Go left********************");
			return this.searchInternToDeleteInAllChildren(internToDelete, this.getLeftNodeIndex(), INTERN_DB_MASK[6]);
			// Error case.
		} else {
			System.out.println("Error in trying to delete " + internToDelete.getName() + ".");
			return false;
		}
	}

	/**
	 * Write a new intern in interns directory binary file and link it to its parent
	 * node.
	 */
	public void addInternInDB() {
		int fileLenght = lengthOfDBFile();
		if (fileLenght < INTERN_SIZE) {
			this.writeInternInDB();
		} else {
			this.writeInternInDB();
			this.linkInternInDB(START_VALUE);
		}
	}

	/**
	 * Write Intern in the InternDirectory binary DB file.
	 */
	public void writeInternInDB() {
		this.setName(prepareAttributeToBeWrite(NAME_SIZE, this.getName()));
		this.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, this.getForename()));
		this.setPromotion(prepareAttributeToBeWrite(PROMOTION_SIZE, this.getPromotion()));
		try {
			RandomAccessFile raf = new RandomAccessFile(DB_URL + DIRECTORY_DB_FILE, "rw");
			raf.seek(raf.length());
			raf.writeChars(this.getName());
			raf.writeChars(this.getForename());
			raf.writeChars(this.getLocation());
			raf.writeChars(this.getPromotion());
			raf.writeInt((int) this.getPromotionYear());
			raf.writeInt((int) this.getRightNodeIndex());
			raf.writeInt((int) this.getLeftNodeIndex());
			raf.writeInt((int) this.getEqualNodeIndex());
			System.out.println("New intern " + this.getName() + " added in interns directory file.");
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding intern " + this.getName() + " in interns directory file.");
		}
	}

//*********** GETTERS IN DB METHODS	
	/**
	 * Get from the interns directory file, the index of the wanted intern.
	 * 
	 * @return (:int)
	 */
	public int searchInternIndexInDB() {
		// Define the size of the intern directory DB file.
		int fileLenght = lengthOfDBFile();
		Intern internAtThisNode = new Intern();
		int index = START_VALUE;
		// Case intern directory DB file not empty
		if (fileLenght > INTERN_SIZE) {
			while ((this.compareTo(internAtThisNode) != 0) && (index < (int) (fileLenght / INTERN_SIZE))) {
				internAtThisNode = this.getInternInDBAtIndex(index);
				index += 1;
			}
			int internIndex = defineInternIndex(index - 1, (int) (fileLenght / INTERN_SIZE));
			return internIndex;
		} else {

			return EMPTY_VALUE;
		}

	}

	/**
	 * Search the leftest intern child of an intern in its right subtree.
	 * 
	 * @return (:Intern)
	 */
	public Intern getNearestInternChild() {
		// Get the current intern from intern directory DB file.
		Intern currentNode = getInternInDBAtIndex(this.getRightNodeIndex());
		
		// go the the first right child if exist.
		if (currentNode.getRightNodeIndex() != EMPTY_VALUE) {
			// go to the leftest child of the first right child.
			while (currentNode.getLeftNodeIndex() != EMPTY_VALUE) {
				currentNode = this.getInternInDBAtIndex(currentNode.getLeftNodeIndex());
			}
		}
		return currentNode;
	}

	/**
	 * Get all equal children of the equal subtree of an intern.
	 * 
	 * @param internListToReturn (:List<Intern>)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInternAndEqualsInSubTree(List<Intern> internListToReturn) {
		if (this.getEqualNodeIndex() == EMPTY_VALUE) {
			internListToReturn.add(this);
		} else {
			Intern internEqualChild = getInternInDBAtIndex(this.getEqualNodeIndex());
			internListToReturn = internEqualChild.getInternAndEqualsInSubTree(internListToReturn);
			internListToReturn.add(this);
		}
		return internListToReturn;
	}

//*************************  PRIVATE METHODES  **************************************
	/**
	 * Define the index of the intern in the interns directory file.
	 * 
	 * @param index           (:int)
	 * @param numberOfInterns (:int)
	 * @return (:int)
	 */
	private int defineInternIndex(int index, int numberOfInterns) {
		if (index == numberOfInterns) {
			return EMPTY_VALUE;
		} else {
			System.out.println("Intern found at index " + index + ".");
			return index;
		}
	}

	/**
	 * Search an intern to delete in children of an intern and delete it in interns
	 * directory DB file, if it's found.
	 * 
	 * @param internChild
	 * @param placeOfChild
	 * @param internToDelete
	 * @return
	 */
	private boolean searchInternToDeleteInDownChild(Intern internChild, int placeOfChild, Intern internToDelete) {
		// Intern's child is the intern to Delete.
		if (internChild.compareTo(internToDelete) == 0) {
			// Intern's child has no child
			if (internChild.getRightNodeIndex() == EMPTY_VALUE && internChild.getLeftNodeIndex() == EMPTY_VALUE) {
				this.modifyInternLinksInDB(this.searchInternIndexInDB(), placeOfChild, EMPTY_VALUE);
				setInternDeletedInDB(internChild);
				// Intern's child has only one left child.
			} else if (internChild.getRightNodeIndex() == EMPTY_VALUE
					&& internChild.getLeftNodeIndex() != EMPTY_VALUE) {
				int childIndexOfLeftChild = internChild.getLeftNodeIndex();
				setInternDeletedInDB(internChild);
				this.modifyInternLinksInDB(this.searchInternIndexInDB(), placeOfChild, childIndexOfLeftChild);
				// Intern's child has only one right child.
			} else if (internChild.getRightNodeIndex() != EMPTY_VALUE
					&& internChild.getLeftNodeIndex() == EMPTY_VALUE) {
				int childIndexOfRightChild = internChild.getLeftNodeIndex();
				setInternDeletedInDB(internChild);
				this.modifyInternLinksInDB(this.searchInternIndexInDB(), placeOfChild, childIndexOfRightChild);
				// Intern's child has two children.
			} else {
				deleteChildInternWithTwoChildren(internChild, placeOfChild);

			}
			System.out.println("Intern " + internToDelete.getName() + " has been deleted from DB.");
			return true;
			// Intern's child doesn't match to internToDelete.
		} else {
			return internChild.searchInternToDeleteInSubTrees(internToDelete);
		}

	}

	/**
	 * Delete the child of intern and rebase it's nearest child as new child.
	 * 
	 * @param internToDelete (:Intern)
	 * @return (: boolean)
	 */
	private boolean deleteChildInternWithTwoChildren(Intern internToDelete, int placeOfChild) {
		Intern nearestChildIntern = internToDelete.getNearestInternChild();
		this.searchInternToDeleteInSubTrees(nearestChildIntern);
		int indexToWrite;
		// Rewrite the correct right or left child of parent intern.
		if (placeOfChild == INTERN_DB_MASK[5]) {
			indexToWrite = this.getRightNodeIndex();
		} else {
			indexToWrite = this.getLeftNodeIndex();
		}
		modifyInPlacePartOfIntern(indexToWrite, nearestChildIntern);
		return true;
	}

	/**
	 * Search intern to delete in right left and equal children of the parent
	 * intern.
	 * 
	 * @param internToDelete   (:Intern)
	 * @param internChildIndex (:int)
	 * @param placeOfChild     (:int)
	 * @return
	 */
	private boolean searchInternToDeleteInAllChildren(Intern internToDelete, int internChildIndex, int placeOfChild) {
		// Intern child subtree doesn't exist .
		if (internChildIndex == EMPTY_VALUE) {
			System.out.println("Intern to delete " + internToDelete.getName() + " not found");
			return false;
			// Intern child subtree exist .
		} else {
			Intern internChild = getInternInDBAtIndex(internChildIndex);
			// Intern child matches the intern to delete for the name.
			if (internChild.compareNameTo(internToDelete) == 0) {
				// Intern child is the intern to delete and ...
				if (internChild.compareTo(internToDelete) == 0) {
					// ...has no equal child.
					if (internChild.getEqualNodeIndex() == EMPTY_VALUE) {
						return this.searchInternToDeleteInDownChild(internChild, placeOfChild, internToDelete);
						
						// ...has one equal child.
					} else {
						Intern equalChildIntern = getInternInDBAtIndex(internChild.getEqualNodeIndex());
						setInternDeletedInDB(equalChildIntern);
						modifyInPlaceAllEqualIntern(this.searchInternIndexInDB(), equalChildIntern);
						System.out.println("Intern " + internToDelete.getName() + " has been deleted from DB.");
						return true;
					}
					// Intern child isn't the intern to delete and ...
				} else {
					// ...has no equal child.
					if (internChild.getEqualNodeIndex() == EMPTY_VALUE) {
						System.out.println("Intern to delete " + internToDelete.getName() + " not found");
						return false;
						// ...has one equal child.
					} else {
						return searchEqualInternToDelete(internToDelete, internChild);
					}
				}
				// Intern child doesn't match the intern to delete for the name. Go on
				// searching.
			} else {
				return internChild.searchInternToDeleteInSubTrees(internToDelete);
			}

		}

	}
}
