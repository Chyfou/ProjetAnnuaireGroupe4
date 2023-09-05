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
			int rightNodeIndex, int leftNodeIndex) {
		super(name, forename);
		this.promotion = promotion;
		this.location = location;
		this.promotionYear = promotionYear;
		this.rightNodeIndex = rightNodeIndex;
		this.leftNodeIndex = leftNodeIndex;
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
		this.promotion = null;
		this.location = null;
		this.promotionYear = null;
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

// ************************* OVERRIDEN METHODES **********************************
	/**
	 * Compare two interns using all their attributes except their nodes's index.
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

	@Override
	public String toString() {
		return "Intern [promotion=" + promotion + ", location=" + location + ", promotionYear=" + promotionYear
				+ ", rightNodeIndex=" + rightNodeIndex + ", leftNodeIndex=" + leftNodeIndex + ", name=" + name
				+ ", forename=" + forename + "]";
	}

//*************************  PUBLIC METHODES  *************************************

//*********** C.U.D METHODS	
	/**
	 * Write a new intern in interns directory binary file and link it to its parent
	 * node.
	 */
	public void addInternInDB() {
		String fileName = DB_URL + DIRECTORY_DB_FILE;
		int fileLenght = 0;
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "r");
			fileLenght = (int) rf.length();
			rf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
				System.out.println("******HELLO******");
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
				System.out.println("******HELLO2******");
				// Case with no right subtree. Add intern in a new node.
				if (internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
					internOfTheNode.setRightNodeIndex(indexOfNewIntern);
					rf.close();
					internOfTheNode.modifyInternLinksInDB(index, INTERN_DB_MASK[5], indexOfNewIntern);
					System.out.println("Intern " + this.getName() + " at index " + index + " has been right linked in the InternDirectory.");
					// Case with one right subtree. Go on searching right place to add the intern.
				} else {
					this.linkInternInDB(internOfTheNode.getRightNodeIndex());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
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
		String fileName = DB_URL + DIRECTORY_DB_FILE;
		Intern internAtThisNode = new Intern();
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
			int index = START_VALUE;
			if (rf.length() != 0) {
				while (this.compareTo(internAtThisNode) != 0 && index < rf.length() / INTERN_SIZE) {
					internAtThisNode = this.getInternInDBAtIndex(index);
					index += 1;
				}
				rf.close();
				return defineInternIndex(index, (int) (rf.length() / INTERN_SIZE));
			} else {
				rf.close();
				return EMPTY_VALUE;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return EMPTY_VALUE;
		}

	}

//*************************  PRIVATE METHODES  ************************************	
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
	 * Resize attribute for binary writing.
	 * 
	 * @param size
	 * @param attribute
	 * @return
	 */
	private String prepareAttributeToBeWrite(int size, String attribute) {
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
	 * Modify right and left index of intern in DB file.
	 * 
	 * @param indexOfAttribute (:int)
	 * @param indexOfChild (:int)
	 * @param myIndex (:int)
	 */
	private void modifyInternLinksInDB(int myIndex, int indexOfAttribute, int indexOfChild) {
		try {
			RandomAccessFile raf = new RandomAccessFile(DB_URL + DIRECTORY_DB_FILE, "rw");
			raf.seek(indexOfAttribute + myIndex * INTERN_SIZE);
			System.out.println(indexOfAttribute + myIndex * INTERN_SIZE);
			if (indexOfAttribute == INTERN_DB_MASK[6]) {
				raf.writeInt((int) this.getLeftNodeIndex());
				System.out.println("Left Node index modify for intern " + this.getName() +".");
			} else {
				raf.writeInt((int) this.getRightNodeIndex());
				System.out.println("Right Node index modify for intern " + this.getName() +".");
			}
			System.out.println("New intern " + this.getName() + " added in interns directory file.");
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while modifyaing intern " + this.getName() + " in interns directory file.");
		}
	}

}
