package com.datastructure.balancedTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class TreeTraversals {	
	
	
	public void levelOrderPrint1(Node root) {
		// Base Case
		if (root == null)
			return;

		// Create an empty queue for level order traversal
		Queue<Node> q = new LinkedList<Node>();
		// Enqueue Root and initialize height
		q.add(root);
		while (true) {
			// nodeCount (queue size) indicates number of nodes
			// at current level.
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;
			// Dequeue all nodes of current level and Enqueue all
			// nodes of next level
			while (nodeCount > 0) {
				Node node = q.peek();
				System.out.print(node.data + " ");
				q.remove();
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}

	public void levelOrderPrint2(Node root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}

	}

	/* Print nodes at a given level */
	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public void inorderItr(Node root) {
		Deque<Node> stack = new LinkedList<Node>();
		Node node = root;
		while (true) {
			if (node != null) {
				stack.addFirst(node);
				node = node.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pollFirst();
				System.out.println(node.data);
				node = node.right;
			}
		}
	}

	public void preOrderItr(Node root) {
		Deque<Node> stack = new LinkedList<Node>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			root = stack.pollFirst();
			System.out.print(root.data + " ");
			if (root.right != null) {
				stack.addFirst(root.right);
			}
			if (root.left != null) {
				stack.addFirst(root.left);
			}
		}
	}

	public void postOrderItr(Node root) {
		Deque<Node> stack1 = new LinkedList<Node>();
		Deque<Node> stack2 = new LinkedList<Node>();
		stack1.addFirst(root);
		while (!stack1.isEmpty()) {
			root = stack1.pollFirst();
			if (root.left != null) {
				stack1.addFirst(root.left);
			}
			if (root.right != null) {
				stack1.addFirst(root.right);
			}
			stack2.addFirst(root);
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pollFirst().data + " ");
		}
	}

		public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		Node head = null;
		head = bt.addNode(11, head);
		head = bt.addNode(12, head);
		head = bt.addNode(10, head);
		head = bt.addNode(13, head);
		head = bt.addNode(9, head);
		head = bt.addNode(17, head);
		head = bt.addNode(16, head);

		TreeTraversals tt = new TreeTraversals();
		tt.postOrder(head);
		System.out.println();
		tt.postOrderItr(head);
		System.out.println();
		System.out.println("Level order traversal...");
		System.out.println("Level order print...");		
		tt.levelOrderPrint2(head);
		System.out.println("Spiral order print...");
	}
}