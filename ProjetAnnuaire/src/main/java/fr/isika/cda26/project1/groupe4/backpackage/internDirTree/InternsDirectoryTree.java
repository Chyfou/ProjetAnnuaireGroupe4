/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;

/**
 * Infix tree of Intern's directory.
 * 
 * @author Yoann François / Thibault SALGUES
 *
 */
public class InternsDirectoryTree extends BinaryFileHandler {
//*************************  ATTRIBUTES  *****************************************
	private InternNode root;

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Empty constructor.
	 * 
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
		this.root = new InternNode(internsDirectoryRoot);
	}

//*************************  GETTERS/SETTERS  ************************************
	public InternNode getRoot() {
		return this.root;
	}

	public void setRoot(InternNode internNode) {
		this.root = internNode;
	}

//********************************** PUBLICS METHODS ********************	

//*********** METRICS OF TREE
	/**
	 * Calculate the length of the heightest branch of the interns directory tree.
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
	 * @param value (String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithName(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root. getAllInternsWithName(value, internsList);
		}
	}
	
	/**
	 * Return all interns in the tree with a specific name.
	 * @param value (:String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreeAllInternsWithName(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root. getAllInternsWithName(value, internsList);
		}
	}
	
	/**
	 * Return all interns in the tree with a specific forename.
	 * @param value (:String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithForename(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root. getAllInternsWithForename(value, internsList);
		}
	}
	
	/**
	 * Return all interns in the tree with a specific promotion.
	 * @param value (:String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithPromotion(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root. getAllInternsWithPromotion(value, internsList);
		}
	}
	
	/**
	 * Return all interns in the tree with a specific location.
	 * @param value (:String)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithLocation(String value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root. getAllInternsWithLocation(value, internsList);
		}
	}
	
	/**
	 * Return all interns in the tree with a specific PromotionYear.
	 * @param value (:int)
	 * @return (:List<Intern>)
	 */
	public List<Intern> getInTreegetAllInternsWithPromotionYear(int value) {
		List<Intern> internsList = new ArrayList<Intern>();
		if (root == null) {
			return null;
		} else {
			return root. getAllInternsWithPromotionYear(value, internsList);
		}
	}

	/**
	 * Research a the first corresponding Intern in the interns directory and return it if it's found.
	 * tree.
	 * 
	 * @param internToSearch (:Intern)
	 * @return (:Node)
	 */
	public Intern searchInternInTree(Intern internToSearch) {
		if (root == null) {
			return null;
		} else {
			return root.searchInternInNode(internToSearch);
		}
	}

//*********** C.U.D OF THE TREE	
	/**
	 * Add a new InternNode in the interns directory tree with an infix order.
	 * 
	 * @param key (:String)
	 */
	public void addInternToInternTree(Intern internToAdd) {
		if (root == null) {
			this.root = new InternNode(internToAdd);
		} else {
			root.addInternToSubTree(internToAdd);
		}
	}

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

	/**
	 * Balance the interns directory tree for having less than two lengths of
	 * difference between the two root subtrees.
	 */
	public void equilibrateTree() {

		System.out.println("Root with heigth of " + this.root.heightOfSubTree());
		this.compactTree();
		System.out.println("Root heigth compact to " + this.root.heightOfSubTree());
		if (this.root != null) {
			System.out
					.println("The difference between the two heigths of subtress is now at " + this.equilibrateRoot());
			System.out.println("Balanced root heigth reduce to " + this.root.heightOfSubTree());
			System.out.println("Balance of subtrees in progress. ");
			System.out.println("Balanced root heigth reduce to " + this.root.equilibrateSubTree());

		}

	}

	// ********************************** PRIVATES METHODS **********************

	/**
	 * Reorganize branches of the interns directory tree for having no InternNode
	 * without less than two branches.
	 * 
	 */
	private int compactTree() {
		if (this.root != null) {
			return this.root.compactSubTree();
		} else {
			return 0;
		}
	}

	/**
	 * Drag the root on the left or right subtree to balance the interns directory
	 * tree .
	 * 
	 * @return (:int)
	 */
	private int equilibrateRoot() {
		// define the unbalanced level of the tree.
		int equilibrium = this.heightBalanceOfSubtrees();
		// balance the root tree.
		while (Math.abs(equilibrium) > 1) {
			InternNode nodeToMove = new InternNode(this.root.getIntern());

			if (equilibrium < 0) {
				nodeToMove.setRightNode(this.root.getRightNode());
				nodeToMove.setLeftNode(this.root.getLeftNode().getRightNode());
				this.root.getLeftNode().setRightNode(nodeToMove);
				this.setRoot(this.root.getLeftNode());
				equilibrium = this.heightBalanceOfSubtrees();
			} else {
				nodeToMove.setLeftNode(this.root.getLeftNode());
				nodeToMove.setRightNode(this.root.getRightNode().getLeftNode());
				this.root.getRightNode().setLeftNode(nodeToMove);
				this.setRoot(this.root.getRightNode());
				equilibrium = this.heightBalanceOfSubtrees();
			}
		}
		return equilibrium;
	}

	/**
	 * Calculate the difference of heigth between the two subtrees of a InternNode.
	 * 
	 * @return (:int)
	 */
	private int heightBalanceOfSubtrees() {
		if (this.root.getRightNode() != null && this.root.getLeftNode() == null) {
			return this.root.getRightNode().heightOfSubTree();
		} else if (this.root.getRightNode() == null && this.root.getLeftNode() != null) {
			return -this.root.getLeftNode().heightOfSubTree();
		} else {
			return (this.root.getRightNode().heightOfSubTree() - this.root.getLeftNode().heightOfSubTree());
		}
	}

}
