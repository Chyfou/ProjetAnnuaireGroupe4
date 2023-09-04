/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;

/**
 * Intern's node of the intern's tree.
 * 
 * @author Thibault Salgues & Yoann Francois
 *
 */
public class InternNode implements BackConstants {

//*************************  ATTRIBUTES  *****************************************
	private Intern intern;
	private InternNode leftNode;
	private InternNode rightNode;

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Full constructor.
	 * 
	 * @param intern    (:Intern)
	 * @param leftNode  (:InternNode)
	 * @param rightNode (:InternNode)
	 */
	public InternNode(Intern intern, InternNode leftNode, InternNode rightNode) {
		super();
		this.intern = intern;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	/**
	 * Constructor with only intern value. Left and right nodes are set to null.
	 */
	public InternNode(Intern intern) {
		super();
		this.intern = intern;
		this.leftNode = null;
		this.rightNode = null;
	}

//*************************  GETTERS/SETTERS  ************************************
	public InternNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(InternNode leftNode) {
		this.leftNode = leftNode;
	}

	public InternNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(InternNode rightNode) {
		this.rightNode = rightNode;
	}

	public Intern getIntern() {
		return intern;
	}

	public void setIntern(Intern intern) {
		this.intern = intern;
	}

// ************************* PUBLIC METHODES *********************************************

//*********** METRICS OF TREE	
	/**
	 * Calculate the length of the heightest branch of the interns directory tree.
	 * 
	 * @return (:int)
	 */

	public int heightOfSubTree() {
		if (this.leftNode == null && this.rightNode == null) {
			return 0;
		} else if (this.leftNode == null && this.rightNode != null) {
			return 1 + this.rightNode.heightOfSubTree();
		} else if (this.leftNode != null && this.rightNode == null) {
			return 1 + this.leftNode.heightOfSubTree();
		} else {
			return 1 + Math.max(this.leftNode.heightOfSubTree(), this.rightNode.heightOfSubTree());
		}
	}

	/**
	 * Calculate the number of intern's nodes in the interns directory tree.
	 * 
	 * @return (:int)
	 */
	public int sizeSubTree() {
		if (this.leftNode != null && this.rightNode != null) {
			return 1 + this.leftNode.sizeSubTree() + this.rightNode.sizeSubTree();
		} else if (this.leftNode != null && this.rightNode == null) {
			return 1 + this.leftNode.sizeSubTree();
		} else if (this.leftNode == null && this.rightNode != null) {
			return 1 + this.rightNode.sizeSubTree();
		} else {
			return 1;
		}
	}

	/**
	 * Seek number of descendants in order to delete an internNode of the interns
	 * directory tree.
	 * 
	 * 
	 * @return (:int)
	 */
	public int numberOfChildren() {
		if ((this.leftNode == null) && (this.rightNode == null)) {
			return 0;
		} else if ((this.leftNode == null) && (this.rightNode != null)) {
			return 1;
		} else if ((this.leftNode != null) && (this.rightNode == null)) {
			return 1;
		} else {
			return 1;
		}
	}

//*********** GETTERS OF TREE		
	/**
	 * Return a List of interns who's names match the required value.
	 * 
	 * @param value       (:String)
	 * @param internsList (:List<Intern>)
	 * @return
	 */
	public List<Intern> getAllInternsWithName(String value, List<Intern> internsList) {
		// Intern with right value. Add it to the internList.
		if (this.intern.getName().equals(value)) {
			internsList.add(this.intern);
			System.out.println("One intern found with the right name.");
		}

		// Search in the subtrees, other intern to add in the internsList.
		if (this.leftNode == null && this.rightNode == null) {
			return internsList;
		} else if (this.leftNode != null && this.rightNode == null) {
			internsList.addAll(this.leftNode.getAllInternsWithName(value, internsList));
			return internsList;
		} else if (this.leftNode == null && this.rightNode != null) {
			internsList.addAll(this.rightNode.getAllInternsWithName(value, internsList));
			return internsList;
		} else {
			internsList.addAll(this.leftNode.getAllInternsWithName(value, internsList));
			internsList.addAll(this.rightNode.getAllInternsWithName(value, internsList));
			return internsList;
		}

	}

	/**
	 * Return a List of interns who's forename match the required value.
	 * 
	 * @param value       (:String)
	 * @param internsList (:List<Intern>)
	 * @return
	 */
	public List<Intern> getAllInternsWithForename(String value, List<Intern> internsList) {
		// Intern with right value. Add it to the internList.
		if (this.intern.getForename().equals(value)) {
			internsList.add(this.intern);
			System.out.println("One intern found with the right forename.");
		}

		// Search in the subtrees, other intern to add in the internsList.
		if (this.leftNode == null && this.rightNode == null) {
			return internsList;
		} else if (this.leftNode != null && this.rightNode == null) {
			internsList.addAll(this.leftNode.getAllInternsWithForename(value, internsList));
			return internsList;
		} else if (this.leftNode == null && this.rightNode != null) {
			internsList.addAll(this.rightNode.getAllInternsWithForename(value, internsList));
			return internsList;
		} else {
			internsList.addAll(this.leftNode.getAllInternsWithForename(value, internsList));
			internsList.addAll(this.rightNode.getAllInternsWithForename(value, internsList));
			return internsList;
		}

	}

	/**
	 * Return a List of interns who's promotion match the required value.
	 * 
	 * @param value       (:String)
	 * @param internsList (:List<Intern>)
	 * @return
	 */
	public List<Intern> getAllInternsWithPromotion(String value, List<Intern> internsList) {
		// Intern with right value. Add it to the internList.
		if (this.intern.getPromotion().equals(value)) {
			internsList.add(this.intern);
			System.out.println("One intern found with the right promotion.");
		}

		// Search in the subtrees, other intern to add in the internsList.
		if (this.leftNode == null && this.rightNode == null) {
			return internsList;
		} else if (this.leftNode != null && this.rightNode == null) {
			internsList.addAll(this.leftNode.getAllInternsWithPromotion(value, internsList));
			return internsList;
		} else if (this.leftNode == null && this.rightNode != null) {
			internsList.addAll(this.rightNode.getAllInternsWithPromotion(value, internsList));
			return internsList;
		} else {
			internsList.addAll(this.leftNode.getAllInternsWithPromotion(value, internsList));
			internsList.addAll(this.rightNode.getAllInternsWithPromotion(value, internsList));
			return internsList;
		}

	}

	/**
	 * Return a List of interns who's location match the required value.
	 * 
	 * @param value       (:String)
	 * @param internsList (:List<Intern>)
	 * @return
	 */
	public List<Intern> getAllInternsWithLocation(String value, List<Intern> internsList) {
		// Intern with right value. Add it to the internList.
		if (this.intern.getLocation().equals(value)) {
			internsList.add(this.intern);
			System.out.println("One intern found with the right Location.");
		}

		// Search in the subtrees, other intern to add in the internsList.
		if (this.leftNode == null && this.rightNode == null) {
			return internsList;
		} else if (this.leftNode != null && this.rightNode == null) {
			internsList.addAll(this.leftNode.getAllInternsWithLocation(value, internsList));
			return internsList;
		} else if (this.leftNode == null && this.rightNode != null) {
			internsList.addAll(this.rightNode.getAllInternsWithLocation(value, internsList));
			return internsList;
		} else {
			internsList.addAll(this.leftNode.getAllInternsWithLocation(value, internsList));
			internsList.addAll(this.rightNode.getAllInternsWithLocation(value, internsList));
			return internsList;
		}

	}

	/**
	 * Return a List of interns who's promotion year match the required value.
	 * 
	 * @param value       (:String)
	 * @param internsList (:List<Intern>)
	 * @return
	 */
	public List<Intern> getAllInternsWithPromotionYear(int value, List<Intern> internsList) {
		// Intern with right value. Add it to the internList.
		if (this.intern.getPromotionYear() == value) {
			internsList.add(this.intern);
			System.out.println("One intern found with the right Location.");
		}

		// Search in the subtrees, other intern to add in the internsList.
		if (this.leftNode == null && this.rightNode == null) {
			return internsList;
		} else if (this.leftNode != null && this.rightNode == null) {
			internsList.addAll(this.leftNode.getAllInternsWithPromotionYear(value, internsList));
			return internsList;
		} else if (this.leftNode == null && this.rightNode != null) {
			internsList.addAll(this.rightNode.getAllInternsWithPromotionYear(value, internsList));
			return internsList;
		} else {
			internsList.addAll(this.leftNode.getAllInternsWithPromotionYear(value, internsList));
			internsList.addAll(this.rightNode.getAllInternsWithPromotionYear(value, internsList));
			return internsList;
		}

	}

	/**
	 * Research a InternNode with the requested Intern in the interns directory
	 * tree.
	 * 
	 * @param internToSearch (:Intern)
	 * @return (:Node)
	 */
	public Intern searchInternInNode(Intern internToSearch) {
		// Intern found at this node.
		if (this.intern.equals(internToSearch)) {
			System.out.println("Intern " + internToSearch.getName() + " found in DirectoryTree.");
			return this.intern;

			// Intern not found at this node and may be in the left subtree.
		} else if (this.intern.compareTo(internToSearch) > 0) {
			if (this.leftNode == null) {
				return null;
			} else {
				return this.leftNode.searchInternInNode(internToSearch);
			}
			// Intern not found at this node and may be in the right subtree.
		} else {
			if (this.rightNode == null) {
				return null;
			} else {
				return (this.rightNode.searchInternInNode(internToSearch));
			}
		}
	}

	/**
	 * Seek successor in order to delete an internNode of the interns directory
	 * tree.
	 * 
	 * 
	 * @return (:InternNode)
	 */
	public InternNode seekSuccessor() {
		InternNode currentNode = this.rightNode;
		if (currentNode != null) {
			while (currentNode.rightNode != null) {
				currentNode = currentNode.leftNode;
			}
		}
		return currentNode;
	}

//*********** C.U.D THE TREE	

	/**
	 * Add a new InternNode in the interns directory tree with an infix order.
	 * 
	 * @param key (:String)
	 */
	public void addInternToSubTree(Intern internToAdd) {
		// Case intern to add in the left subtree.
		if (internToAdd.compareTo(this.intern) < 0) {
			// Case with no left subtree. Add intern in a new node.
			if (this.leftNode == null) {
				this.leftNode = new InternNode(internToAdd);
				System.out.println("Intern " + internToAdd.getName() + " has been added to the InternDirectory.");
				// Case with one left subtree. Go on searching right place to add the intern.
			} else {
				this.leftNode.addInternToSubTree(internToAdd);
			}
			// Case intern to add in the right subtree.
		} else {
			// Case with no right subtree. Add intern in a new node.
			if (this.rightNode == null) {
				this.rightNode = new InternNode(internToAdd);
				System.out.println("Intern " + internToAdd.getName() + " has been added to the InternDirectory.");
				// Case with one right subtree. Go on searching right place to add the intern.
			} else {
				this.rightNode.addInternToSubTree(internToAdd);
			}
		}
	}

	/**
	 * Delete an InternNode of the interns directory tree.
	 * 
	 * @param internToDelete (:Intern)
	 * @return (:Boolean)
	 */
	public boolean searchInternToDelete(Intern internToDelete) {
		// Case intern to delete may be in the left subtree.
		if (internToDelete.compareTo(this.intern) < 0) {
			return this.deleteInternInSubTree(this.leftNode, internToDelete);
			// Case intern to delete may be in the right subtree.
		} else {
			return this.deleteInternInSubTree(this.rightNode, internToDelete);
		}
	}

	/**
	 * Delete root with two nodes in the interns directory tree.
	 * 
	 * 
	 */
	public void deleteRootWithTwoNodes() {
		this.intern = this.seekSuccessor().getIntern();
		this.searchInternToDelete(intern);
	}

	/**
	 * Fulfill empty branches in all the subtrees.
	 * 
	 * @return (:int)
	 */
	public int compactSubTree() {

		// Terminate case. No subtree at this node.
		if (this.getLeftNode() == null && this.getRightNode() == null) {
			return 0;
			// Node has one right subtree.
		} else if (this.getLeftNode() == null) {
			return this.compactRightSubTree();

			// Node has one left subtree.
		} else if (this.getRightNode() == null) {
			return this.compactLeftSubTree();

			// Node has two subtrees.
		} else {
			return this.compactRightSubTree() + this.compactLeftSubTree();

		}

	}

	/**
	 * Balance the interns directory subtree for having less than two lengths of
	 * difference between the two children subtrees.
	 */
	public int equilibrateSubTree() {

		if (this.rightNode != null && this.leftNode != null) {
			this.leftNode.equilibrateSubTree();
			this.rightNode.equilibrateSubTree();

			int equilibriumLeft = this.leftNode.heightBalanceOfSubtrees();
			while (equilibriumLeft > 1) {
				InternNode nodeToMove = new InternNode(this.leftNode.getIntern());

				if (equilibriumLeft < 0) {
					nodeToMove.setRightNode(this.getLeftNode().getRightNode());
					nodeToMove.setLeftNode(this.getLeftNode().getLeftNode().getRightNode());
					this.getLeftNode().getLeftNode().setRightNode(nodeToMove);
					this.setLeftNode(this.getLeftNode().getLeftNode());
					equilibriumLeft = this.getLeftNode().heightBalanceOfSubtrees();

				} else {
					nodeToMove.setLeftNode(this.getLeftNode().getLeftNode());
					nodeToMove.setRightNode(this.getLeftNode().getRightNode().getLeftNode());
					this.getLeftNode().getRightNode().setLeftNode(nodeToMove);
					this.setLeftNode(this.getLeftNode().getRightNode());
					equilibriumLeft = this.getLeftNode().heightBalanceOfSubtrees();

				}
			}

			int equilibriumRight = this.rightNode.heightBalanceOfSubtrees();
			while (equilibriumRight > 1) {
				InternNode nodeToMove = new InternNode(this.rightNode.getIntern());

				if (equilibriumRight < 0) {
					nodeToMove.setRightNode(this.getLeftNode().getRightNode());
					nodeToMove.setLeftNode(this.getLeftNode().getLeftNode().getRightNode());
					this.getLeftNode().getLeftNode().setRightNode(nodeToMove);
					this.setLeftNode(this.getLeftNode().getLeftNode());
					equilibriumLeft = this.getLeftNode().heightBalanceOfSubtrees();

				} else {
					nodeToMove.setLeftNode(this.getLeftNode().getLeftNode());
					nodeToMove.setRightNode(this.getLeftNode().getRightNode().getLeftNode());
					this.getLeftNode().getRightNode().setLeftNode(nodeToMove);
					this.setLeftNode(this.getLeftNode().getRightNode());
					equilibriumRight = this.getLeftNode().heightBalanceOfSubtrees();

				}
			}
			return Math.max(this.rightNode.heightOfSubTree(), this.leftNode.heightOfSubTree());

		} else {
			return 0;
		}

	}

// ************************* PRIVATES METHODES *********************************************	

//*********** METRICS OF TREE	
	/**
	 * Calculate the difference of heigth between the two subtrees of a node.
	 * 
	 * @return (:int)
	 */
	private int heightBalanceOfSubtrees() {
		if (this.getRightNode() != null && this.getLeftNode() == null) {
			return this.getRightNode().heightOfSubTree();
		} else if (this.getRightNode() == null && this.getLeftNode() != null) {
			return -this.getLeftNode().heightOfSubTree();
		} else if (this.getRightNode() != null && this.getLeftNode() != null) {
			return (this.getRightNode().heightOfSubTree() - this.getLeftNode().heightOfSubTree());
		} else {
			return 0;
		}

	}

//*********** GETTERS OF TREE		
	/**
	 * Search in a child subtree the InternToDelete. Delete it and return true if
	 * it's found.
	 * 
	 * @param internode      (:InterNode)
	 * @param internToDelete (:Intern)
	 * @return
	 */
	private boolean deleteInternInSubTree(InternNode internode, Intern internToDelete) {
		if (internode == null) {
			System.out.println("Intern " + internToDelete.getName() + " has not been found in the InternDirectory");
			return false;
		} else {
			// This child is to delete.
			if (internode.getIntern() == internToDelete) {
				// This child has no child.
				if (internode.numberOfChildren() == 0) {
					internode = null;
					// This child has two children.
				} else if (internode.numberOfChildren() == 2) {
					internode.deleteRootWithTwoNodes();
					// This child has only one right child.
				} else if (internode.getRightNode() != null) {
					internode = internode.getRightNode();
					// This child has only one left child.
				} else {
					internode = internode.getLeftNode();
				}
				System.out.println("Intern " + internToDelete.getName() + " has been deleted from the InternDirectory");
				return true;
				// This child is not to delete. Search in this child subtree.
			} else {
				return internode.searchInternToDelete(internToDelete);
			}
		}
	}

//*********** C.U.D THE TREE	
	/**
	 * Fulfill empty branches in the right subtree.
	 * 
	 * @return (:int)
	 */
	private int compactRightSubTree() {
		if (this.getRightNode().getLeftNode() == null && this.getRightNode().getRightNode() != null) {
			if (this.getRightNode().getRightNode().getLeftNode() == null) {
				InternNode cloneNode = this.getRightNode().getRightNode();
				this.getRightNode().setRightNode(null);
				cloneNode.setLeftNode(this.getRightNode());
				this.setRightNode(cloneNode);
			} else if (this.getRightNode().getRightNode().getLeftNode() != null) {
				InternNode cloneNode = this.getRightNode().getRightNode();
				this.getRightNode().setRightNode(cloneNode.getLeftNode());
				cloneNode.setLeftNode(this.getRightNode());
				this.setRightNode(cloneNode);
			}
			return 1 + this.getRightNode().compactSubTree();

		} else if (this.getRightNode().getLeftNode() != null && this.getRightNode().getRightNode() == null) {
			if (this.getRightNode().getLeftNode().getLeftNode() == null) {
				InternNode cloneNode = this.getRightNode().getLeftNode();
				this.getRightNode().setLeftNode(null);
				cloneNode.setRightNode(this.getRightNode());
				this.setRightNode(cloneNode);
			} else if (this.getRightNode().getLeftNode().getLeftNode() != null) {
				InternNode cloneNode = this.getRightNode().getLeftNode();
				this.getRightNode().setLeftNode(cloneNode.getRightNode());
				cloneNode.setRightNode(this.getRightNode());
				this.setRightNode(cloneNode);
			}
			return 1 + this.getRightNode().compactSubTree();

		} else {
			return this.getRightNode().compactSubTree();
		}

	}

	/**
	 * Fulfill empty branches in the left subtree.
	 * 
	 * @return (:int)
	 */
	private int compactLeftSubTree() {
		if (this.getLeftNode().getLeftNode() == null && this.getLeftNode().getRightNode() != null) {
			if (this.getLeftNode().getRightNode().getLeftNode() == null) {
				InternNode cloneNode = this.getRightNode().getRightNode();
				this.getLeftNode().setRightNode(null);
				cloneNode.setLeftNode(this.getRightNode());
				this.setLeftNode(cloneNode);
			} else if (this.getLeftNode().getRightNode().getLeftNode() != null) {
				InternNode cloneNode = this.getLeftNode().getRightNode();
				this.getLeftNode().setRightNode(cloneNode.getLeftNode());
				cloneNode.setLeftNode(this.getLeftNode());
				this.setLeftNode(cloneNode);
			}
			return 1 + this.getLeftNode().compactSubTree();

		} else if (this.getLeftNode().getLeftNode() != null && this.getLeftNode().getRightNode() == null) {
			if (this.getLeftNode().getLeftNode().getLeftNode() == null) {
				InternNode cloneNode = this.getLeftNode().getLeftNode();
				this.getLeftNode().setLeftNode(null);
				cloneNode.setRightNode(this.getLeftNode());
				this.setLeftNode(cloneNode);
			} else if (this.getLeftNode().getLeftNode().getLeftNode() != null) {
				InternNode cloneNode = this.getLeftNode().getLeftNode();
				this.getLeftNode().setLeftNode(cloneNode.getRightNode());
				cloneNode.setRightNode(this.getLeftNode());
				this.setLeftNode(cloneNode);
			}
			return 1 + this.getLeftNode().compactSubTree();

		} else {
			return this.getLeftNode().compactSubTree();
		}
	}
}
