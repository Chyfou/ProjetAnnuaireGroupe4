/**
 * 
 */
package fr.isika.cda26.project1.groupe4.backpackage.internDirTree;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;

/**
 * Intern's node of the intern's tree.
 * 
 * @author Thibault Salgues
 *
 */
public class InternNode implements BackConstants{
//*************************  ATTRIBUTES  *****************************************
	private InternNode leftNode;
	private InternNode rightNode;

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Full constructor.
	 * 
	 * @param leftNode  (:InternNode)
	 * @param rightNode (:InternNode)
	 */
	public InternNode(InternNode leftNode, InternNode rightNode) {
		super();
		this.leftNode = leftNode;
		this.rightNode = rightNode;
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

}
