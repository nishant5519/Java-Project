package com.datastructure.binarytree;

public class LevelOrderTraversalWithDirectionChangeAfterEveryTwoLevels {

	static class Node {
		int data;
		Node left;
		Node right;
	};

	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}

	public static void main(String[] args) {
		Node root = newNode(1);
		root.left = newNode(2);
		root.right = newNode(3);
		root.left.left = newNode(4);
		root.left.right = newNode(5);
		root.right.left = newNode(6);
		root.right.right = newNode(7);
		root.left.left.left = newNode(8);
		root.left.left.right = newNode(9);
		root.left.right.left = newNode(3);
		root.left.right.right = newNode(1);
		root.right.left.left = newNode(4);
		root.right.left.right = newNode(2);
		root.right.right.left = newNode(7);
		root.right.right.right = newNode(2);
		root.left.right.left.left = newNode(16);
		root.left.right.left.right = newNode(17);
		root.right.left.right.left = newNode(18);
		root.right.right.left.right = newNode(19);
		customTraversal(root);
	}

	private static void customTraversal(Node node) {

	}

}
