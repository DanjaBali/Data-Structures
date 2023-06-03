/* Data Structures Project by Danja Bali: Implement a binary search tree to allow duplicates. */
package binarySearchTree;

import binarySearchTree.BST.Node;

public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		/*
		 * Let us create following BST 12(3) / \ 10(2) 20(1) / \ 9(1) 11(1)
		 */

		BST t = new BST();
		Node root = null;
		root = t.insert(root, 12);
		root = t.insert(root, 10);
		root = t.insert(root, 20);
		root = t.insert(root, 9);
		root = t.insert(root, 11);
		root = t.insert(root, 10);
		root = t.insert(root, 12);
		root = t.insert(root, 12);

		System.out.print("\n1) Return number of duplicates of an element: \n ");
		System.out.print("\n   For e.g element 12 has:");
		t.ReturnNumberOfDublicate(root, 12);
		System.out.print("duplicates\n");
		System.out.print("\n");

		System.out.print("2) Find and replace all duplicates of an element A with element B: (10) with (12) \n ");
		System.out.print("\n");
		System.out.print("   Before replacing, tree in Preorder is :");
		System.out.print(" { ");
		t.preorder(root);
		System.out.print("}\n");
		System.out.print("\n");
		System.out.print("   After the replacing, tree in Preorder is: { ");
		t.findAndReplaceAllDuplicates(root, 12, 10);
		System.out.print("}\n");
		System.out.print("\n");

		System.out.print(
				"3) Show all the tree together with the duplicates  in-order, pre-order,post-order, level-order:\n");

		System.out.print("\n  *In-order Traversal:");
		System.out.print(" { ");
		t.inorder(root);
		System.out.print("}\n");
		System.out.print("\n");

		System.out.print("\n  *Pre-order Traversal:");
		System.out.print(" { ");
		t.preorder(root);
		System.out.print("}\n");
		System.out.print("\n");

		System.out.print("\n  *Post-order Traversal:");
		System.out.print(" { ");
		t.postorder(root);
		System.out.print("}\n");
		System.out.print("\n");

		System.out.print("\n  *Level-order Traversal:");
		System.out.print(" { ");
		t.levelorder(root);
		System.out.print("}\n");
		System.out.print("\n");

		System.out.print("\n 4) Remove all existing duplicates (leaving only one copy) of an element:\n");
		System.out.print("\n    From element 12(3)leave only one copy => (12(1)\n");
		System.out.print("    { ");
		t.RemoveAllExistingDuplicatesLeaveOneCopy(root, 12);
		System.out.print("}\n");
		System.out.print("\n");

		System.out.print("\n 5) Remove only one copy of the existing duplicates of an element:\n");
		System.out.print("\n    From element 12(3) remove 1 copy =>12(2)\n");
		System.out.print("    { ");
		t.deleteNode(root, 12);
		t.inorder(root);
		System.out.print("}\n");
		System.out.print("\n");

		System.out.print(
				"\n 6) Remove all existing duplicates (leaving only one copy) for all the duplicated elements in tree:\n");
		System.out.print("    { ");
		t.RemoveAllExistingDuplicates(root);
		System.out.print("}\n");
		System.out.print("\n");

		// System.out.print(" { ");
		System.out.print("\n 7) Print all elements that have duplicates together with the number of duplicates:\n");
		System.out.print("    { ");
		t.PrintDublicate(root);
		System.out.print("}\n");
		System.out.print("\n");

		System.out.print("\n 8) Print the number of all the duplicates in the tree:\n");
		System.out.print("    The number of duplicates is:  { ");
		// t.countDuplicate(root);
		System.out.print(t.countDuplicate(root));
		System.out.print("}\n");
		System.out.print("\n");

		System.out.print("\n 9) Show only the nodes that have/do not have duplicates:\n");
		System.out.print("\n");
		System.out.print("    Nodes that do not have dublicates: ");
		System.out.print("{ ");
		t.PrintNoDuplicates(root);
		System.out.print("}\n");
		System.out.print("\n    Nodes that have dublicates: ");
		System.out.print("{ ");
		t.PrintDublicate(root);
		System.out.print("}\n");
		System.out.print("\n");

	}
}
