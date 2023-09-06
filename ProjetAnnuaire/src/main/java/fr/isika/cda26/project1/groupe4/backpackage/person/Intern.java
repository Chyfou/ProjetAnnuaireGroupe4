package fr.isika.cda26.project1.groupe4.backpackage.person;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Intern of the intern's directory.
 * 
 * @author Thibault SALGUES
 *
 */
public class Intern extends Person implements Comparable<Intern> {
//*************************  ATTRIBUTES  *****************************************
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
		super(name, forename);
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
		super(name, forename);
		this.promotion = promotion;
		this.location = location;
		this.promotionYear = promotionYear;
		this.rightNodeIndex = EMPTY_VALUE;
		this.leftNodeIndex = EMPTY_VALUE;
	}

	/**
	 * Empty constructor.
	 */
	public Intern() {
		super();
		this.promotion = "";
		this.location = "";
		this.promotionYear = EMPTY_VALUE;
		this.rightNodeIndex = EMPTY_VALUE;
		this.leftNodeIndex = EMPTY_VALUE;
	}

//*************************  GETTERS/SETTERS  ************************************
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
		return "Intern [promotion=" + promotion + ", location=" + location + ", promotionYear=" + promotionYear
				+ ", rightNodeIndex=" + rightNodeIndex + ", leftNodeIndex=" + leftNodeIndex + ", name=" + name
				+ ", forename=" + forename + "]";
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

			Intern internOfTheNode = this.getInternInDBAtIndex(index);
			// Open DB file.
			RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
			int indexOfNewIntern = (int) ((rf.length() / INTERN_SIZE) - 1);
			// Case intern to add in the left subtree.
			if (this.compareTo(internOfTheNode) < 0) {
				// Case with no left subtree. Add intern in a new node.
				if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE) {
					internOfTheNode.setLeftNodeIndex(indexOfNewIntern);
					rf.close();
					internOfTheNode.modifyInternLinksInDB(index, INTERN_DB_MASK[6], indexOfNewIntern);
					System.out.println("Intern " + this.getName() + " has been left linked in the InternDirectory.");
					// Case with one left subtree. Go on searching right place to add the intern.
				} else {
					rf.close();
					this.linkInternInDB(internOfTheNode.getLeftNodeIndex());
				}
				// Case intern to add in the right subtree.
			} else {
				// Case with no right subtree. Add intern in a new node.
				if (internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
					internOfTheNode.setRightNodeIndex(indexOfNewIntern);
					rf.close();
					internOfTheNode.modifyInternLinksInDB(index, INTERN_DB_MASK[5], indexOfNewIntern);
					System.out.println("Intern " + this.getName() + " at index " + index
							+ " has been right linked in the InternDirectory.");
					// Case with one right subtree. Go on searching right place to add the intern.
				} else {
					this.linkInternInDB(internOfTheNode.getRightNodeIndex());
				}
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
			raf.seek(indexOfAttribute + myIndex * INTERN_SIZE);
			// Modify the left node index.
			if (indexOfAttribute == INTERN_DB_MASK[6]) {
				raf.writeInt(indexValue);
				System.out.println("Left Node index modify for intern " + this.getName() + ".");
				// modify the right node index.
			} else {
				raf.writeInt(indexValue);
				System.out.println("Right Node index modify for intern " + this.getName() + ".");
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
	public boolean searchInternToDelete(Intern internToDelete) {
		// Case with intern not found in the tree
		if (this.getRightNodeIndex() == EMPTY_VALUE && this.getLeftNodeIndex() == EMPTY_VALUE) {
			return false;
			// Case with intern may be found in the right subtree
		} else if (this.compareTo(internToDelete) < 0) {
			// Case with empty right subtree.
			if (this.getRightNodeIndex() == EMPTY_VALUE) {
				return false;
				// Case with intern in a not empty right subtree .
			} else {
				Intern internChild = getInternInDBAtIndex(this.getRightNodeIndex());
				return this.searchInternToDeleteInChild(internChild, INTERN_DB_MASK[5], internToDelete);
			}
		// Case with intern may be found in the left subtree
		} else if (this.compareTo(internToDelete) > 0) {
			// Case with empty left subtree.
			if (this.getLeftNodeIndex() == EMPTY_VALUE) {
				return false;
			// Case with a not empty left subtree .
			} else {
				Intern internChild = this.getInternInDBAtIndex(this.getLeftNodeIndex());
				return this.searchInternToDeleteInChild(internChild, INTERN_DB_MASK[6], internToDelete);
			}
		} else {
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
			Intern.this.writeInternInDB();
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
			System.out.println("New intern " + this.getName() + " added in interns directory file.");
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding intern " + this.getName() + " in interns directory file.");
		}
	}

//*********** GETTERS IN DB METHODS	
	/**
	 * Extract one intern from the interns directory file at the required position.
	 * 
	 * @param internPosition (:int)
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
			while ((this.compareTo(internAtThisNode) != 0) && (index < (int)(fileLenght / INTERN_SIZE))) {	
				internAtThisNode = this.getInternInDBAtIndex(index);
				index += 1;
			}
			int internIndex = defineInternIndex(index-1, (int) (fileLenght / INTERN_SIZE));
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
		// Get the current intern frm intern directory DB file.
		Intern currentNode = this.getInternInDBAtIndex(this.getRightNodeIndex());
		// go the the first right child if exist.
		if (currentNode.getRightNodeIndex() != EMPTY_VALUE) {
			// go to the leftest child of the first right child.
			while (currentNode.getRightNodeIndex() != EMPTY_VALUE) {
				currentNode = this.getInternInDBAtIndex(currentNode.getLeftNodeIndex());
			}
		}
		return currentNode;
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
	private boolean searchInternToDeleteInChild(Intern internChild, int placeOfChild, Intern internToDelete) {
		// Intern's child matches to internToDelete.
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
				this.deleteChildInternWithTwoChildren(internChild, placeOfChild);

			}
			return true;
		// Intern's child doesn't match to internToDelete.
		} else {
			return internChild.searchInternToDelete(internToDelete);
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
		this.searchInternToDelete(nearestChildIntern);
		System.out.println("*************** : " + this.getLeftNodeIndex());
		int indexToWrite;
		if (placeOfChild == INTERN_DB_MASK[5]) {
			indexToWrite = this.getRightNodeIndex();
		} else {
			indexToWrite = this.getLeftNodeIndex();
		}
		rewriteInPlaceInDBPartOfIntern(indexToWrite , nearestChildIntern);
		return true;
	}
}
