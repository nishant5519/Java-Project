package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal_BFS {

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

	// Prints in one line
	// LevelOrder Traversal:Time Complexity: O(n) where n is number of nodes in
	// the binary tree
	void levelOrderTraversalUsingQueue(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
	
	
	
	// Time complexity of this algorithm is O(n) and extra space used is also
		// O(n)
		public void spiralOrderTraversal(Node root) {
			if (root == null)
				return;
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);

			boolean directionflag = true;// for printing left to right to left
			while (!stack.isEmpty()) {
				Stack<Node> tempStack = new Stack<Node>();
				while (!stack.isEmpty()) {
					Node tempNode = stack.pop();
					System.out.printf("%d ", tempNode.data);
					if (!directionflag) {
						if (tempNode.left != null)
							tempStack.push(tempNode.left);
						if (tempNode.right != null)
							tempStack.push(tempNode.right);
					} else {
						if (tempNode.right != null)
							tempStack.push(tempNode.right);
						if (tempNode.left != null)
							tempStack.push(tempNode.left);
					}
				}
				// for changing direction
				directionflag = !directionflag;
				stack = tempStack;
			}
		}


		void levelOrderTraversalInReverseOrder(Node root) {
			if (root == null)
				return;
			Stack<Node> stk = new Stack<Node>();
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				root = q.poll();
				if (root.right != null)
					q.add(root.right);
				if (root.left != null)
					q.add(root.left);
				stk.push(root);
			}
			while (!stk.isEmpty())
				System.out.println("Reverse order level traversal:" + stk.pop().data);

		}


}
