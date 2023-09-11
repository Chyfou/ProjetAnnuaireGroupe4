package fr.isika.cda26.project1.groupe4.backpackage.person;

import java.io.IOException;
import java.io.RandomAccessFile;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.DBFileManager;

/**
 * Connected user off the App.
 * 
 * @author Thibault SALGUES.
 *
 */
public class User extends DBFileManager implements BackConstants, Comparable<User> {
//*************************  ATTRIBUTES  *****************************************
	protected String name;
	protected String forename;
	protected String email;
	protected String password;
	final String STATUS;
	final int ID;

//*************************  CONSTRUCTORS  **************************************
	/**
	 * Full constructor.
	 * 
	 * @param email    (:String)
	 * @param password (:String)
	 * @param sTATUS   (:String)
	 * @param iD       (:int)
	 */
	public User(String name, String forename, String email, String password, String status, int iD) {
		this.name = name;
		this.forename = forename;
		this.email = email;
		this.password = password;
		STATUS = status;
		ID = iD;
	}

	/**
	 * Constructor for login form.
	 * 
	 * @param name     (:String)
	 * @param forename (:String)
	 * @param password (:String)
	 */
	public User(String name, String forename, String password) {
		this.name = name;
		this.forename = forename;
		this.email = null;
		this.password = password;
		STATUS = null;
		ID = EMPTY_VALUE;
	}

	/**
	 * Empty constructor.
	 */
	public User() {
		this.name = null;
		this.forename = null;
		this.email = null;
		this.password = null;
		STATUS = null;
		ID = EMPTY_VALUE;
	}

	/**
	 * Empty constructor with at least Status value.
	 */
	public User(String status) {
		this.name = null;
		this.forename = null;
		this.email = null;
		this.password = null;
		STATUS = status;
		ID = EMPTY_VALUE;
	}

	/**
	 * Copy constructor.
	 */
	public User(User userToCopie) {
		super();
		this.name = userToCopie.getName();
		this.forename = userToCopie.getForename();
		this.email = userToCopie.getEmail();
		this.password = userToCopie.getPassword();
		this.STATUS = userToCopie.getSTATUS();
		this.ID = userToCopie.getID();
	}

//*************************  GETTERS/SETTERS  **********************************
	public String getEmail() {
		return email;
	}

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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public int getID() {
		return ID;
	}

// ************************* OVERRIDEN METHODES **********************************
	/**
	 * Overridden method Compare two users using all their attributes except their
	 * nodes's index.
	 */
	@Override
	public int compareTo(User userToCompare) {
		int i = this.name.compareTo(userToCompare.getName());
		if (i == 0) {
			i = this.forename.compareTo(userToCompare.getForename());
			if (i == 0) {
				i = this.email.compareTo(userToCompare.getEmail());
				if (i == 0) {
					i = this.password.compareTo(userToCompare.getPassword());
					if (i == 0) {
						i = this.STATUS.compareTo(userToCompare.getSTATUS());
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
		return "User [name=" + name + ", forename=" + forename + ", email=" + email + ", password=" + password
				+ ", STATUS=" + STATUS + ", ID =" + ID + "]";
	}

	/**
	 * Compare two users login forms.
	 * 
	 * @param userToCompare (:Intern)
	 * @return (:int)
	 */
	public int compareFormTo(User userToCompare) {
		int i = this.name.toLowerCase().compareTo(userToCompare.getName().toLowerCase());
		if (i == 0) {
			i = this.forename.toLowerCase().compareTo(userToCompare.getForename().toLowerCase());
			if (i == 0) {
				i = this.password.compareTo(userToCompare.getPassword());
			}
		}
		return i;

	}

	/**
	 * Write Intern in the InternDirectory binary DB file.
	 * 
	 * @return (: boolean)
	 */
	public boolean writeUserInDB() {
		this.setName(prepareAttributeToBeWrite(NAME_SIZE, this.getName()));
		this.setForename(prepareAttributeToBeWrite(FORENAME_SIZE, this.getForename()));
		this.setEmail(prepareAttributeToBeWrite(EMAIL_SIZE, this.getEmail()));
		this.setPassword(prepareAttributeToBeWrite(PASSWORD_SIZE, this.getPassword()));
		System.out.println(this.getName());
		try {
			RandomAccessFile raf = new RandomAccessFile(DB_URL + USER_DB_FILE, "rw");
			raf.seek(raf.length());
			raf.writeChars(this.getName());
			raf.writeChars(this.getForename());
			raf.writeChars(this.getEmail());
			raf.writeChars(this.getPassword());
			raf.writeChars(this.getSTATUS());
			raf.writeInt((int) lengthOfUserDBFile() / USER_SIZE);
			System.out.println("New user " + this.getName() + " added in user DB file.");
			raf.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding user " + this.getName() + " in user DB file.");
			return false;
		}

	}

}
