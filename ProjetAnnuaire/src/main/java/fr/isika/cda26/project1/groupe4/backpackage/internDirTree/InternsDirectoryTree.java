/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;

/**
 * Infix tree of Intern's directory.
 * 
 * @author Thibault SALGUES
 *
 */
public class InternsDirectoryTree extends BinaryFileHandler {
//*************************  ATTRIBUTES  *****************************************
	private Intern internsDirectoryRoot;

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Empty constructor.
	 * @param dBFileUrl (:String)
	 */
	public InternsDirectoryTree(String dBFileUrl) {
		super(dBFileUrl);
	}

	/**
	 * Full constructor.
	 * 
	 * @param internsDirectoryRoot (:Intern)
	 */
	public InternsDirectoryTree(String dBFileUrl, Intern internsDirectoryRoot) {
		super(dBFileUrl);
		this.internsDirectoryRoot = internsDirectoryRoot;
	}

//*************************  GETTERS/SETTERS  ************************************
	public Intern getInternsDirectoryRoot() {
		return this.internsDirectoryRoot;
	}

	public void setInternsDirectoryRoot(Intern internsDirectoryRoot) {
		this.internsDirectoryRoot = internsDirectoryRoot;
	}

}
