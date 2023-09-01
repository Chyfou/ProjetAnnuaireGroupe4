package fr.isika.cda26.project1.groupe4.backpackage.person;

/**
 * Connected user off the App.
 * @author Thibault SALGUES
 *
 */
public  abstract class User extends Person {
//*************************  ATTRIBUTES  *****************************************
	protected String email;
	protected String password;
	final String STATUS;
	final int ID;

//*************************  CONSTRUCTORS  ************************************
	/**
	 * Full constructor.
	 * @param email (:String)
	 * @param password (:String)
	 * @param sTATUS (:String)
	 * @param iD (:int)
	 */
	public User(String name, String forename, String email, String password, String sTATUS, int iD) {
		super(name, forename);
		this.email = email;
		this.password = password;
		STATUS = sTATUS;
		ID = iD;
	}
	
//*************************  GETTERS/SETTERS  ************************************
	public String getEmail() {
		return email;
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


	

}
