/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.person;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;

/**
 * Person of the School.
 * 
 * @author Thibault SALGUES
 *
 */
public abstract class Person implements BackConstants{
//*************************  ATTRIBUTES  *****************************************
	protected String name;
	protected String forename;

//*************************  CONSTRUCTORS  ***************************************
	/**
	 * Full constructor.
	 * 
	 * @param name     (:String)
	 * @param forename (:String)
	 */
	public Person(String name, String forename) {
		super();
		this.name = name;
		this.forename = forename;
	}
	
	public Person() {
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

}
