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
		return true;
	} // end find 

	public boolean replace(Comparable old, Comparable toAdd) {
		return true;
	} // end replace 

	public boolean delete(Comparable old) {
		return false;
	} // end delete 

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
