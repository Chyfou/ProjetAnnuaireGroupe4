/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;

/**
 * Infix tree of Intern's directory.
 * 
 * @author Yoann François / Thibault SALGUES
 *
 */
public class InternsDirectoryTree implements BackConstants {
//*************************  ATTRIBUTES  *****************************************
	private InternNode root;

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Empty constructor.
	 * 
	 * @param dBFileUrl (:String)
	 */
	public InternsDirectoryTree(String dBFileUrl) {
		super();
	}

	/**
	 * Full constructor.
	 * 
	 * @param internsDirectoryRoot (:Intern)
	 */
	public InternsDirectoryTree(Intern internsDirectoryRoot) {
		super();
		this.root = new InternNode(internsDirectoryRoot);
	}

//*************************  GETTERS/SETTERS  ************************************
	public InternNode getRoot() {
		return this.root;
	}

	public void setRoot(InternNode internNode) {
		this.root = internNode;
	}

//********************************** PUBLICS METHODS *****************************

//*********** METRICS OF TREE
	/**
	 * Calculate the length of the highest branch of the interns directory tree.
	 * 
	 * @return (:int)
	 */
	public int heightOfTree() {
		if (root == null) {
			return 0;
		} else {
			return root.heightOfSubTree();
		}
	}

	/**
	 * Calculate the number of intern's nodes in the interns directory tree.
	 * 
	 * @return (:int)
	 */
	public int sizeOfTree() {
		if (root == null) {
			return 0;
		} else {
			return root.sizeSubTree();
		}

	}

//*********** GETTERS OF TREE
	/**
	 * Return all interns in the tree with a specific name.
	 * 
	 * @param value (String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithName(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root.getAllInternsWithName(value, internsList);
		}
	}

	/**
	 * Return all interns in the tree with a specific name.
	 * 
	 * @param value (:String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreeAllInternsWithName(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root.getAllInternsWithName(value, internsList);
		}
	}

	/**
	 * Return all interns in the tree with a specific forename.
	 * 
	 * @param value (:String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithForename(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root.getAllInternsWithForename(value, internsList);
		}
	}

	/**
	 * Return all interns in the tree with a specific promotion.
	 * 
	 * @param value (:String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithPromotion(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root.getAllInternsWithPromotion(value, internsList);
		}
	}

	/**
	 * Return all interns in the tree with a specific location.
	 * 
	 * @param value (:String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithLocation(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root.getAllInternsWithLocation(value, internsList);
		}
	}

	/**
	 * Return all interns in the tree with a specific PromotionYear.
	 * 
	 * @param value (:int)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithPromotionYear(int value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root.getAllInternsWithPromotionYear(value, internsList);
		}
	}

	public List<Intern> getAllInternInDB(List<Intern> internsList, int index) {
		String fileName = DB_URL + DIRECTORY_DB_FILE;
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
			if (rf.length() != 0) {
				Intern internOfTheNode = this.getInternInDBAtIndex(index);
				// Case Intern has no child.
				if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE && internOfTheNode.getRightNodeIndex() == EMPTY_VALUE) {
					internsList.add(internOfTheNode);
				// Case Intern has only one right child.
				} else if (internOfTheNode.getLeftNodeIndex() == EMPTY_VALUE && internOfTheNode.getRightNodeIndex() != EMPTY_VALUE){
					internsList.add(internOfTheNode);
					internsList.addAll(this.getAllInternInDB(internsList, internOfTheNode.getRightNodeIndex()));
				// Case Intern has only one left child.
				} else if (internOfTheNode.getLeftNodeIndex() != EMPTY_VALUE && internOfTheNode.getRightNodeIndex() == EMPTY_VALUE){
					internsList.addAll(this.getAllInternInDB(internsList, internOfTheNode.getLeftNodeIndex()));
					internsList.add(internOfTheNode);
				// Case Intern has two children.	
				} else {
					internsList.addAll(this.getAllInternInDB(internsList, internOfTheNode.getLeftNodeIndex()));
					internsList.add(internOfTheNode);
					internsList.addAll(this.getAllInternInDB(internsList, internOfTheNode.getRightNodeIndex()));
				}
				}

			rf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return internsList;
	}
	
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
			for (int j = 0; j < FORENAME_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					internLocation += charRead;
				}
			}
			internToReturn.setLocation(internLocation);

			String internPromotion = "";
			for (int j = 0; j < FORENAME_SIZE; j++) {
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

//*********** C.U.D OF THE TREE	
	/**
	 * Delete an InternNode of the interns directory tree.
	 * 
	 * @param internToDelete (:Intern)
	 * @return (:Boolean)
	 */
	public boolean deleteInTree(Intern internToDelete) {
		// No root case. Nothing to delete.
		if (root == null) {
			return false;
			// Root to delete.
		} else if (root.getIntern().equals(internToDelete)) {
			// Root has no children.
			if (root.getLeftNode() == null && root.getRightNode() == null) {
				this.root = null;
				// Root has only one right child.
			} else if (root.getRightNode() != null && root.getLeftNode() == null) {
				this.root = this.root.getRightNode();
				// Root has only one left child.
			} else if (root.getRightNode() == null && root.getLeftNode() != null) {
				this.root = this.root.getLeftNode();
				// Root has two children.
			} else {
				// Set as root a copy of the InternNode in the tree with the nearest higher
				// Intern value.
				this.root.setIntern(this.root.seekSuccessor().getIntern());
				// Delete in the subTree the original InternNode which has been copy.
				this.root.getRightNode().searchInternToDelete(this.root.getIntern());
			}

			return true;
			// Case with one root that may contains the node to delete.
		} else {
			return root.searchInternToDelete(internToDelete);
		}
	}

}
