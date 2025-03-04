/*
 * Name: Kevin Zheng
 * Date: 03/03/2025
 * Class Period: 3
 * Description: This file first creates an instance testTree to be able to use the BST's methods. Then, the isEmpty method is tested to see if it can check if a tree is empty. 
 * After that, each character of ORCHARDQUINCE is added to the tree and then they are printed out in order, pre order, and post order. After that, the BST's size method is tested
 * and isEmpty is tested to see if it can output true. Next, the delete method is tested by seeing if it can remove nodes with 0 child, nodes with 1 child, and nodes with 2 children. 
 * After each removal, the tree is printed in all 3 orders to check if the node was removed and at the end the tree's size is checked. 
 * The remove method is also tested on a nonexistent node to test its response. 
 * Then, the find method is tested by checking if it can find a node within the tree and whether it will return false when searching for a nonexistent node. 
 * Finally, the replace method is tested by replacing nodes with 0 child, nodes with 1 child, and nodes with 2 childs. 
 * After each replacement, the tree is printed in all 3 orders to check if the replace method worked. 
 * The replace method is also tested on a nonexistent node to test its response. 
 */

import java.lang.Comparable;

public class BSTTester {
  public static void main(String[] args) {
    BST testTree = new BST();
    System.out.println("Is tree empty? " + testTree.isEmpty());

    testTree.add("O");
    testTree.add("R");
    testTree.add("C");
    testTree.add("H");
    testTree.add("A");
    testTree.add("R");
    testTree.add("D");
    testTree.add("Q");
    testTree.add("U");
    testTree.add("I");
    testTree.add("N");
    testTree.add("C");
    testTree.add("E");

    System.out.print("In Order: ");
    testTree.printInOrder();
    System.out.print("Pre Order: ");
    testTree.printPreOrder();
    System.out.print("Post Order: ");
    testTree.printPostOrder();
    System.out.println("Tree Size (# of Nodes): " + testTree.size());
    System.out.println("Is tree empty? " + testTree.isEmpty());
    System.out.println();


    System.out.println("Was the 0 child node E removed? " + testTree.delete("E"));
    System.out.print("In Order: ");
    testTree.printInOrder();
    System.out.print("Pre Order: ");
    testTree.printPreOrder();
    System.out.print("Post Order: ");
    testTree.printPostOrder();
    System.out.println();

    System.out.println("Was the 1 child node A removed? " + testTree.delete("A"));
    System.out.print("In Order: ");
    testTree.printInOrder();
    System.out.print("Pre Order: ");
    testTree.printPreOrder();
    System.out.print("Post Order: ");
    testTree.printPostOrder();
    System.out.println();

    System.out.println("Was the 2 child node R removed? " + testTree.delete("R"));
    System.out.print("In Order: ");
    testTree.printInOrder();
    System.out.print("Pre Order: ");
    testTree.printPreOrder();
    System.out.print("Post Order: ");
    testTree.printPostOrder();
    System.out.println();

    System.out.println("Was the nonexistent node A removed? " + testTree.delete("A"));
    System.out.print("In Order: ");
    testTree.printInOrder();
    System.out.print("Pre Order: ");
    testTree.printPreOrder();
    System.out.print("Post Order: ");
    testTree.printPostOrder();
    System.out.println("Tree Size (# of Nodes): " + testTree.size());
    System.out.println();

    
    System.out.println("Is A in the tree? " + testTree.find("A"));
    System.out.println("Is R in the tree? " + testTree.find("R"));
    System.out.println();
    
    System.out.println("Was the 0 child node N replaced by M? " + testTree.replace("N", "M"));
    System.out.print("In Order: ");
    testTree.printInOrder();
    System.out.print("Pre Order: ");
    testTree.printPreOrder();
    System.out.print("Post Order: ");
    testTree.printPostOrder();
    System.out.println();

    System.out.println("Was the 1 child node I replaced by Z? " + testTree.replace("I", "Z"));
    System.out.print("In Order: ");
    testTree.printInOrder();
    System.out.print("Pre Order: ");
    testTree.printPreOrder();
    System.out.print("Post Order: ");
    testTree.printPostOrder();
    System.out.println();

    System.out.println("Was the 2 child node H replaced by K? " + testTree.replace("H", "K"));
    System.out.print("In Order: ");
    testTree.printInOrder();
    System.out.print("Pre Order: ");
    testTree.printPreOrder();
    System.out.print("Post Order: ");
    testTree.printPostOrder();
    System.out.println();

    System.out.println("Was the nonexistent node P replaced by S? " + testTree.replace("P", "S"));
    System.out.print("In Order: ");
    testTree.printInOrder();
    System.out.print("Pre Order: ");
    testTree.printPreOrder();
    System.out.print("Post Order: ");
    testTree.printPostOrder();

  } // end main 
} // end class 