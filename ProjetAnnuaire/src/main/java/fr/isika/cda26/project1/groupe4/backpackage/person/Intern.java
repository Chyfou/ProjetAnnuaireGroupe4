/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.person;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Intern of the intern's directory.
 * 
 * @author Thibault SALGUES
 *
 */
public class Intern extends Person {
//*************************  ATTRIBUTES  *****************************************
	private String promotion;
	private String location;
	private Integer promotionYear;

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Full constructor.
	 * @param name (:String)
	 * @param forename (:String)
	 * @param promotion (:String)
	 * @param location (:String)
	 * @param promotionYear (:Integer)
	 */
	public Intern(String name, String forename, String promotion, String location, Integer promotionYear) {
		super(name, forename);
		this.promotion = promotion;
		this.location = location;
		this.promotionYear = promotionYear;
	}
	
	public Intern() {
		super();
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
	
	//*************************  PUBLIC METHODES  ************************************
	public void addInternToDB() {
			this.setName(prepareAttributeToBeWrite(NAME_SIZE, this.getName()));
			this.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, this.getForename()));
			this.setPromotion(prepareAttributeToBeWrite(PROMOTION_SIZE, this.getPromotion()));
			String fileToWrite = DB_URL + DIRECTORY_DB_FILE;
			try {
				RandomAccessFile raf = new RandomAccessFile(fileToWrite, "rw");
				raf.seek(raf.length());
				raf.writeChars(this.getName());
				raf.writeChars(this.getForename());
				raf.writeChars(this.getLocation());
				raf.writeChars(this.getPromotion());
				raf.writeInt(this.getPromotionYear());
				raf.close();
				System.out.println("New intern " + this.getName() + " added in the DB.");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error while adding intern " + this.getName() + " in the DB.");
			}
		}

	
	//*************************  PRIVATE METHODES  ************************************	
	/**
	 * Resize attribute for binary writing.
	 * @param size
	 * @param attribute
	 * @return
	 */
	public String prepareAttributeToBeWrite(int size, String attribute) {
		String attributePrepared = "";
		attribute = attribute.trim();
		if(attribute.length() <= size) {
			attributePrepared = attribute;
			for(int i = attribute.length() ; i < size; i++) {
				attributePrepared += FILLING_CHAR;
			}
		} else {
			attributePrepared = attribute.substring(0, size);
		}
		return attributePrepared;
	}
}
