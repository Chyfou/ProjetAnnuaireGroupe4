/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.person;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
	/**
	 * Add Intern in the binary DB file.
	 */
	public void addInternToDB() {
			this.setName(prepareAttributeToBeWrite(NAME_SIZE, this.getName()));
			this.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, this.getForename()));
			this.setPromotion(prepareAttributeToBeWrite(PROMOTION_SIZE, this.getPromotion()));
			String fileToWrite = DB_URL + DIRECTORY_DB_FILE;
			try {
				Path path = Paths.get(fileToWrite);
		        byte[] name = this.getName().getBytes(StandardCharsets.UTF_8);
		        Files.write(path, name, StandardOpenOption.APPEND);
		        byte[] forename = this.getForename().getBytes(StandardCharsets.UTF_8);
		        Files.write(path, forename, StandardOpenOption.APPEND);
		        byte[] location = this.getLocation().getBytes(StandardCharsets.UTF_8);
		        Files.write(path, location, StandardOpenOption.APPEND);
		        byte[] promotion = this.getPromotion().getBytes(StandardCharsets.UTF_8);
		        Files.write(path, promotion, StandardOpenOption.APPEND);
		        byte[] promotionYear = ByteBuffer.allocate(4).putInt(this.getPromotionYear()).array();
		        Files.write(path, promotionYear, StandardOpenOption.APPEND);
				
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
	private String prepareAttributeToBeWrite(int size, String attribute) {
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

	public int compareTo(Intern intern) {
		// TODO Auto-generated method stub
		return 0;
	}
}
