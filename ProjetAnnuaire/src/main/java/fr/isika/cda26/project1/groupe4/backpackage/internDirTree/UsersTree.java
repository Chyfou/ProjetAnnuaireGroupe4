/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.person.User;

/**
 * Binary infix tree of users.
 * 
 * @author Thibault SALGUES
 *
 */
public class UsersTree extends BinaryFileHandler {
//*************************  ATTRIBUTES  *****************************************
	private User usersTreeRoot;

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Full constructor.
	 * 
	 * @param dBFileUrl (:String)
	 */
	public UsersTree(String dBFileUrl) {
		super(dBFileUrl);
	}

	/**
	 * Full constructor.
	 * 
	 * @param usersTree (:User)
	 */
	public UsersTree(String dBFileUrl, User usersTreeRoot) {
		super(dBFileUrl);
		this.usersTreeRoot = usersTreeRoot;
	}

}
