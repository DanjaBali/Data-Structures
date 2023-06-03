
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class BST {

	// class Node declaration
	static class Node {

		int key; // key variable to enter values.
		int CountDuplicates; // variable that will used to count the duplicates values.
		Node leftChild; // left node.
		Node rightChild; // right node
	};

	static Node NewNode(int item) { // Method to create a new Binary Search Tree Node

		Node t = new Node();
		t.key = item;
		t.leftChild = t.rightChild = null;
		t.CountDuplicates = 1;// nr. of duplicates
		return t;
	}

	static Node insert(Node node, int key) {// Method to insert nodes
		if (node == null)
			return NewNode(key);

		if (key == node.key) {
			(node.CountDuplicates)++;
			return node;
		}

		if (key < node.key)// In a BST, all keys in left subtree must be smaller than the root
			node.leftChild = insert(node.leftChild, key);
		else
			node.rightChild = insert(node.rightChild, key);// And all keys in right subtree must be greater than the
															// root

		return node;
	}

	static Node ReturnNumberOfDublicate(Node root, int key) { // Method to return number of duplicates of an element:

		if (root != null) { // Search for node
			ReturnNumberOfDublicate(root.leftChild, key);
			if (key == root.key) { // if condition to check if key is equal to root.key

				System.out.print("(" + root.CountDuplicates + ") "); // and print nr. of duplicates for the respective
																		// keys
				root.leftChild = ReturnNumberOfDublicate(root.leftChild, key);
				root.rightChild = ReturnNumberOfDublicate(root.rightChild, key);
				ReturnNumberOfDublicate(root.rightChild, key);
			}
		}
		return root;
	}

	public void findAndReplaceAllDuplicates(Node root, int A, int B) {// Method to find and replace all duplicates of an
																		// element A with B
		if (root == null)
			return;

		if (root.key == A)
			System.out.print(B + "(" + root.CountDuplicates + ") ");
		else
			System.out.print(root.key + "(" + root.CountDuplicates + ") ");
		findAndReplaceAllDuplicates(root.leftChild, A, B);
		findAndReplaceAllDuplicates(root.rightChild, A, B);

	}

	static void inorder(Node root) { // Method to do in-order traversal of Binary Search Tree

		if (root != null) {
			inorder(root.leftChild); // left nodes
			System.out.print(root.key + "(" + root.CountDuplicates + ") "); // node
			inorder(root.rightChild); // right nodes
		}

	}

	static void preorder(Node root) {// Method to do pre-order traversal of Binary Search Tree

		if (root == null) {
			return;
		}
		System.out.print(root.key + "(" + root.CountDuplicates + ") "); // node
		preorder(root.leftChild); // left nodes
		preorder(root.rightChild); // right nodes
	}

	static void postorder(Node root) { // Method to do post-order traversal of Binary Search Tree
		if (root == null) {
			return;
		}
		postorder(root.leftChild); // left node
		postorder(root.rightChild); // right node
		System.out.print(root.key + "(" + root.CountDuplicates + ") ");
	}

	static void levelorder(Node root) { // Method to do Level order traversal of BST using Queue

		if (root == null) { // check for the root
			return;
		}

		Queue<Node> q = new LinkedList<Node>();

		q.add(root); // This add the root

		while (!q.isEmpty()) { // while loop to remove values from the queue
			Node top = q.remove();
			System.out.print(top.key + "(" + top.CountDuplicates + ") ");

			if (top.leftChild != null) {
				q.add(top.leftChild); // add left node
			}
			if (top.rightChild != null) {
				q.add(top.rightChild); // add right nodes
			}
		}
	}

	static Node minValueNode(Node node) {// Method to return the Node with minimum key value found in that tree.
		Node current = node;

		while (current.leftChild != null) { // This loop finds the leaf on the leftmost

			current = current.leftChild;
		}

		return current;
	}

	// Method with two parameters which remove all existing duplicates leaving only
	// one copy of an element.
	static Node RemoveAllExistingDuplicatesLeaveOneCopy(Node root, int key) {

		if (root != null) { // search for node
			RemoveAllExistingDuplicatesLeaveOneCopy(root.leftChild, key);
			if (key < root.key || key > root.key) { // check the left subtree values of duplicates if it is greater or
													// smaller.
				System.out.print(root.key + "(" + root.CountDuplicates + ") "); // the program will print only one
																				// duplicates

				root.rightChild = RemoveAllExistingDuplicatesLeaveOneCopy(root.rightChild, key);
			} else if (root.CountDuplicates != 1) {
				System.out.print(root.key + "(" + (root.CountDuplicates / root.CountDuplicates) + ") ");

				RemoveAllExistingDuplicatesLeaveOneCopy(root.rightChild, key); // check the right subtree
			}
		}
		return root;
	}

	static Node deleteNode(Node root, int key) {// This method deletes a given key and returns root of modified tree

		if (root == null) { // search for node
			return root; // base case
		}
		if (key < root.key) { // This condition show that if the key to be deleted is smaller
								// than the root key, then it lies in left subtree based on BST properties
			root.leftChild = deleteNode(root.leftChild, key);
		} else if (key > root.key) { // This condition show that the key to be deleted is greater
										// than the root's key, then it lies in right subtree
			root.rightChild = deleteNode(root.rightChild, key);
		} else { // This condition show that if key is same as root key

			if (root.CountDuplicates > 1) { // So, If key is present more than once time, it decrement data and return

				(root.CountDuplicates)--;
				return root;
			}

			if (root.leftChild == null) { // These conditions, deletes the Nodes, Nodes with only one child or no
											// child(leaf)

				Node t = root.rightChild;
				root = null;
				return t;
			} else if (root.rightChild == null) {
				Node t = root.leftChild;
				root = null;
				return t;
			}

			Node t = minValueNode(root.rightChild); // Node with two children will get the in-order successor
			// which is smallest in the right subtree

			root.key = t.key; // this condition will Copy the in-order successor in content to this Node

			root.rightChild = deleteNode(root.rightChild, t.key); // this condition will delete the in-order successor
		}
		return root;
	}

	public void RemoveAllExistingDuplicates(Node root) { // Method to Remove all existing duplicates
		if (root != null) {
			RemoveAllExistingDuplicates(root.leftChild); // check the left subtree
			if (root.CountDuplicates == 1) { // if count of duplicates is greater than 1.
				System.out.print(root.key + "(" + root.CountDuplicates + ") "); // the program will print only the
																				// duplicates
			} else if (root.CountDuplicates > 1) {
				System.out.print(root.key + "(" + (root.CountDuplicates / root.CountDuplicates) + ") ");

				RemoveAllExistingDuplicates(root.rightChild); // check the right subtree
			}
		}
	}

	int count[] = { 0 }; // Method to print the number of all the duplicates in the tree

	public Integer countDuplicate(Node root) {

		if (root == null)
			return null;

		if (root.CountDuplicates > 1) {
			count[0] = count[0] + root.CountDuplicates;
		}
		countDuplicate(root.leftChild);
		countDuplicate(root.rightChild);

		return count[0];
	}

	public void PrintDublicate(Node root) { // Method to print nodes together with the number of duplicates

		if (root != null) { // search for node
			PrintDublicate(root.leftChild);
			if (root.CountDuplicates > 1) { // if number of duplicates is greater than 1, we have duplicates
				System.out.print(root.key + "(" + root.CountDuplicates + ") ");// will print nodes with duplicates
			} else {
				PrintDublicate(root.rightChild); // check the right node

			}
		}
	}

	public void PrintNoDuplicates(Node root) { // Method to print only the nodes that do not have duplicates:
		if (root != null) { // search for node
			PrintNoDuplicates(root.leftChild); // check the left subtree
			if (root.CountDuplicates == 1) { // if number of duplicates is equal with 1, no duplicates
				System.out.print(root.key + "(" + root.CountDuplicates + ") "); // will print nodes that do not have
																				// duplicates

			} else {
				PrintNoDuplicates(root.rightChild); // check the right node
			}
		}
	}
}
