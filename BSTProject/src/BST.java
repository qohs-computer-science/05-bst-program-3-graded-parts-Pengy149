/*
 * Name: Kevin Zheng
 * Date: 03/03/2025
 * Class Period: 3
 * Description: The BST class creates the ability to allow the programmer to create and use trees. The size method checks the number of nodes in the tree. 
 * The isEmpty checks if there are nodes in the tree. The add method adds the node to the correct place in the tree depending on lexicographical order 
 * and the addHelper method assists with that via recursion. The delete method deletes the first node that matches what it's supposed to delete and 
 * deletes the node in various ways depending on if the node has 0, 1, or 2 childs and the delHelper method assists via recursion.
 * The find method determines if a value is in the tree and outputs true if the value is there and false if the value isn't in the tree. 
 * The findHelper method helps the find function by traversing through the tree via recursion. 
 * The replace method deletes a given value if the value is in the tree and then regardless of if the value is deleted, another given value is added to the tree. 
 * The printInOrder method prints out the tree in left, root, right order. The printPreOrder method prints the tree in root, left, right order. 
 * The printPostOrder prints the tree in left, right, root order. Each of the print methods has a helper method to assist them mainly via recursion.  
 */
import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode tree;
	private int nodes;

	public BST() {
		tree = null; 
		nodes = 0;
	} // end constructor 

	public int size() {
		return nodes;
	} // end size 

	public boolean isEmpty() {
		if (nodes == 0) 
			return true;
		else 
			return false;
	} // end isEmpty 

	public void add(Comparable newVal) {
		if (!(tree != null)) {
			tree = new TreeNode(newVal);
			nodes++;
		} // end if statement 
		else if (newVal.compareTo(tree.getValue()) <= 0) {
			if (!(tree.getLeft() != null)) {
				tree.setLeft(new TreeNode(newVal));
				nodes++;
			} // end if statement 
			else
				addHelper(newVal, tree.getLeft());
		} // end else if statement 
		else { // root’s value > toAdd
			if (!(tree.getRight() != null)) {
				tree.setRight(new TreeNode(newVal));
				nodes++;
			} // end if statement 
			else
				addHelper(newVal, tree.getRight());
		} // end else statement
	} // end add 

	private void addHelper(Comparable value, TreeNode parent) {
		// doesn’t hurt to check parent != null
		if (value.compareTo(parent.getValue()) <= 0 && !(parent.getLeft() != null)) {
			parent.setLeft(new TreeNode(value));
			nodes++;
		} // end if statement 
		else if (value.compareTo(parent.getValue()) <= 0)
			addHelper(value, parent.getLeft());
		else if (value.compareTo(parent.getValue()) > 0 && !(parent.getRight() != null)) {
			parent.setRight(new TreeNode(value));
			nodes++;
		} // end else if statement   
		else // if parent’s value <= value
			addHelper(value, parent.getRight());
	} // end addHelper 

	public boolean find(Comparable toFind) {
		if(!(tree != null))
			return false;
		if(tree.getValue().equals(toFind))
			return true; 
	
		Boolean isLeft = findHelper(toFind, tree.getLeft());
		Boolean isRight = findHelper(toFind, tree.getRight());
		if(isLeft == true || isRight == true) 
			return true;
		else 
			return false; 
	} // end find 

	private boolean findHelper (Comparable value, TreeNode parent) {
		if(parent.getValue().equals(value)) 
			return true;
		if(parent.getLeft() != null) {
			Boolean leftStatus = findHelper(value, parent.getLeft());
			if(leftStatus) 
				return true;
			else 
				return false;
		} // end if statement 
		if(parent.getRight() != null) {
			Boolean rightStatus = findHelper(value, parent.getRight());
			if(rightStatus) 
				return true;
			else 
				return false;
		} // end if statement 
		return false; 
	} // end findHelper 
	

	public boolean replace(Comparable old, Comparable toAdd) {
		if(delete(old)) {
			add(toAdd);
			return true;
		} // end if statement 
		else {
			add(toAdd);
			return false; 
		} // end else statement 
	} // end replace 

	public boolean delete(Comparable old) {
		if(!(tree != null))
			return false;
		else if(tree.getValue().equals(old)) {
			TreeNode treeLC;
			TreeNode treeRC;
			TreeNode tempNodes;
			if (!(tree.getLeft().getValue() != null) && !(tree.getRight().getValue() != null)) 
				tree = null;
			else if (tree.getLeft().getValue() != null && tree.getRight().getValue() != null) {
				treeLC = tree.getLeft();
				treeRC = tree.getRight();
				tree.setLeft(null);
				tree.setRight(null);
				tree = treeLC; 
				tempNodes = tree; 
				while (tempNodes.getRight() != null) 
					tempNodes = tempNodes.getRight();
				tempNodes.setRight(treeRC); 
			} // end else if statement   
			else {
				if(tree.getLeft() != null) 
					tree = tree.getLeft(); 
				else
					tree = tree.getRight(); 
			} // end else statement 
			nodes--;
			return true; 
		} // end delete 
		
		Boolean isDel = delHelper(old, tree);
		if (isDel) {
			nodes--;
			return true;
		} // end if statement 
		else 
			return false; 
	} // end delete 

	private boolean delHelper (Comparable value, TreeNode parent) {
		if(parent.getLeft() != null && parent.getLeft().getValue().equals(value)) {
			TreeNode toDelete = parent.getLeft();
			TreeNode delLC;
			TreeNode delRC;
			TreeNode tempNodes;
			if (!(toDelete.getLeft() != null) && !(toDelete.getRight() != null)) 
				parent.setLeft(null);
			else if (toDelete.getLeft() != null && toDelete.getRight() != null) {
				delLC = toDelete.getLeft();
				delRC = toDelete.getRight();
				toDelete.setLeft(null);
				toDelete.setRight(null);
				parent.setLeft(delLC);
				// loop through to add toDelete’s RC to farthest point
				// on the right in toDelete’s LC
				tempNodes = parent.getLeft();
				while (tempNodes.getRight() != null) 
					tempNodes = tempNodes.getRight();
				tempNodes.setRight(delRC); 
			} // end else if statement 
			else { // toDelete only has 1 kid
				if(toDelete.getLeft() != null) 
					parent.setLeft(toDelete.getLeft());
				else
					parent.setLeft(toDelete.getRight());
			} // end else statement 
			return true;
		} // end if statement 
		if(parent.getRight() != null && parent.getRight().getValue().equals(value)) {
			TreeNode toDelete = parent.getRight();
			TreeNode delLC;
			TreeNode delRC;
			TreeNode tempNodes;
			if (!(toDelete.getLeft() != null) && !(toDelete.getRight() != null)) {
				parent.setRight(null);
			} // end if statement 
			else if (toDelete.getLeft() != null && toDelete.getRight() != null) {
				delLC = toDelete.getLeft();
				delRC = toDelete.getRight();
				toDelete.setLeft(null);
				toDelete.setRight(null);
				parent.setRight(delLC);
				// loop through to add toDelete’s RC to farthest point
				// on the right in toDelete’s LC
				tempNodes = parent.getRight();
				while (tempNodes.getRight() != null) {
					tempNodes = tempNodes.getRight();
				} // end while loop 
				tempNodes.setRight(delRC); 
			} // end else if statement 
			else { // toDelete only has 1 kid
				if(toDelete.getLeft() != null) 
					parent.setRight(toDelete.getLeft());
				else
					parent.setRight(toDelete.getRight());
			} // end else statement 
			return true; 
		} // end if statement 

		if(parent.getLeft() != null) 
			if(delHelper(value, parent.getLeft()))
				return true;
		if(parent.getRight() != null) 
			if(delHelper(value, parent.getRight()))
				return true;
		return false;
	} // end delHelper 
	
	public void printInOrder() {
		if(tree != null)
			helpInOrder(tree);
		System.out.println("");
	} // end printInOrder

	private void helpInOrder (TreeNode parent) {
		if(parent.getLeft() != null) 
			helpInOrder(parent.getLeft());
		System.out.print(parent.getValue() + ", ");
		if(parent.getRight() != null) 
			helpInOrder(parent.getRight());
	} // end helpInOrder

	public void printPreOrder() {
		if(tree != null)
			helpPreOrder(tree);
		System.out.println("");
	} // end printPreOrder

	private void helpPreOrder (TreeNode parent) {
		System.out.print(parent.getValue() + ", ");
		if(parent.getLeft() != null) 
			helpPreOrder(parent.getLeft());
		if(parent.getRight() != null) 
			helpPreOrder(parent.getRight());
	} // end helpPreOrder

	public void printPostOrder() {
		if(tree != null)
			helpPostOrder(tree);
		System.out.println("");
	} // end printPostOrder 

	private void helpPostOrder (TreeNode parent) {
		if(parent.getLeft() != null) 
			helpPostOrder(parent.getLeft());
		if(parent.getRight() != null) 
			helpPostOrder(parent.getRight());
		System.out.print(parent.getValue() + ", ");
	} // end helpPostOrder 
} // end class 
