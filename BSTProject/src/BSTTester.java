/*
 * Name: Kevin Zheng
 * Date: 02/20/2025
 * Class Period: 3
 * Program Description: 
 */

import java.lang.Comparable;

public class BSTTester {
  public static void main(String[] args) {
    BST testTree = new BST();
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

  } // end main 
} // end class 