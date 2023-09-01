/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.person;

/**
 * Member of the pedagogic staff.
 * @author Thibault SALGUES
 *
 */
public class Staff extends User {
//*************************  CONSTRUCTORS  ************************************
	/**
	 * Full constructor.
	 * @param email (:String)
	 * @param password (:String)
	 * @param sTATUS (:String)
	 * @param iD (:int)
	 */
	public Staff(String name, String forename, String email, String password, String sTATUS, int iD) {
		super(name, forename, email, password, sTATUS, iD);
	}
	
//*************************  OVERRIDDEN METHODS  *******************************
//*************************  PUBLICS METHODS  **********************************

}
