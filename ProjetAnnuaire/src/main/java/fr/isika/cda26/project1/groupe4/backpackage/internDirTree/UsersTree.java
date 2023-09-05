/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import fr.isika.cda26.project1.groupe4.backpackage.person.User;

/**
 * Binary infix tree of users.
 * 
 * @author Thibault SALGUES
 *
 */
public class UsersTree {
//*************************  ATTRIBUTES  *****************************************
	private User usersTreeRoot;

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Full constructor.
	 * 
	 * @param dBFileUrl (:String)
	 */
	public UsersTree() {
		super();
		usersTreeRoot = null;
	}
	
//*************************  CONSTRUCTORS  ***************************************
	/**
	 * Full constructor.
	 * 
	 * @param usersTree (:User)
	 */
	public UsersTree(User usersTreeRoot) {
		super();
		this.usersTreeRoot = usersTreeRoot;
	}
	
//*************************  GETTERS/SETTERS  ************************************
	public User getUsersTreeRoot() {
		return usersTreeRoot;
	}

	public void setUsersTreeRoot(User usersTreeRoot) {
		this.usersTreeRoot = usersTreeRoot;
	}

}
