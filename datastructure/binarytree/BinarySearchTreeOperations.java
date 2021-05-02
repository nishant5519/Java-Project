package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

//Iterative Solution
public class BinarySearchTreeOperations {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		/*
		 * bst.iterativeInsert(50); bst.iterativeInsert(25);
		 * bst.iterativeInsert(75); bst.iterativeInsert(12);
		 * bst.iterativeInsert(37); bst.iterativeInsert(43);
		 * bst.iterativeInsert(30); bst.iterativeInsert(33);
		 * bst.iterativeInsert(87); bst.iterativeInsert(93);
		 * bst.iterativeInsert(97);
		 */
		bst.insertRecursively(50);
		bst.insertRecursively(25);
		bst.insertRecursively(75);
		bst.insertRecursively(12);
		bst.iterativeInsert(37);
		bst.insertRecursively(43);
		bst.insertRecursively(30);
		bst.insertRecursively(33);
		bst.insertRecursively(87);
		bst.insertRecursively(93);
		bst.insertRecursively(97);
		bst.convertInMirrorImage();

	}

}



class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void insertRecursively(int data) {
		root = recursiveInsert(root, data);
	}

	// Time complexity for Balanced BST is O(logn) and for skewed is O(n)
	public Node recursiveInsert(Node current, int id) {
		if (current == null)
			current = new Node(id); // if root is null, then no need of further
									// recursion.That is why if-else block is
									// used
		else {
			if (id < current.data)
				current.left = recursiveInsert(current.left, id);
			else
				current.right = recursiveInsert(current.right, id);
		}
		return current;
	}

	public void iterativeInsert(int id) {
		Node newNode = new Node(id);
		if (root == null)
			root = newNode;
		Node current = root;
		Node parent;
		while (true) {
			parent = current;
			if (id < current.data) {
				current = current.left;
				if (current == null) { // Parent
					parent.left = newNode;// parent now not pointing to
											// current. /
					return; /*
							 * / / current
							 */

				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}

	}

	public Node finditerative1(int key) {
		Node parent = root;
		if (root == null)
			return null;
		else {
			while (true) {
				Node current = parent;
				if (key == current.data && current != null)
					return current;
				else {
					if (key < current.data && current != null)
						parent = current.left;
					else if (key > current.data && current != null)
						parent = current.right;
					else
						return null;
				}
			}

		}

	}

	// find node with given key
	public Node finditerative2(int key) {
		Node current = root; // start at root
		if (current == null)
			return null;
		else {
			while (current.data != key) // while no match,
			{
				if (key < current.data) // go left?
					current = current.left;
				else
					current = current.right; // or go right?
				if (current == null) // if no child,
					return null; // didn�t find it
			}
			return current; // found it
		}
	}

	public Node minimum() {
		Node current = root;
		while (current.left != null)
			current = current.left;
		return current;
	}

	public Node maximum() {
		Node current = root;
		while (current.right != null)
			current = current.right;
		return current;
	}

	public boolean delete(int key) {
		Node current = root; // start at root
		Node last = null;
		boolean isLeftChild = true;
		if (current == null)
			return false;
		else {
			while (current.data != key) // while no match,
			{
				if (key < current.data)// go left?
				{
					isLeftChild = true;
					last = current;
					current = current.left;
				} else {
					isLeftChild = false;
					last = current;
					current = current.right; // or go right?
				}
				if (current == null) // if no child,
					return false; // didn�t find it
			}

			if (current.left == null && current.right == null) {
				if (isLeftChild)
					last.left = null;
				else
					last.right = null;

			}

		}

		return true;
	}

	void search(int id) {
		System.out.println("Found Data: " + searchRecursive(root, id).data);
	}

	// For Balanced BST, worst case complexity is O(logn) and for skewed tree it
	// is O(n).
	Node searchRecursive(Node root, int key) {
		if (root == null || root.data == key)
			return root;

		if (root.data > key)
			return searchRecursive(root.left, key);

		return searchRecursive(root.right, key);
	}

	// Size of tree is equal to total number of nodes in a tree
	// * Time complexity - O(n)
	// * Space complexity(because of recursion stack) - height of binary tree.
	// Worst case O(n)
	public int size(Node root) {
		if (root == null) {
			return 0;
		}
		/*
		 * int leftSize = size(root.left); int rightSize = size(root.right);
		 * return leftSize + rightSize + 1;
		 */
		return size(root.left) + size(root.right) + 1;
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	public int height() {
		Node current = root;
		return calcHeight(current);
	}

	public int calcHeight(Node parent) {
		if (parent == null)
			return 0;
		int leftHeight = calcHeight(parent.left);
		int rightHeight = calcHeight(parent.right);

		return Math.max(leftHeight, rightHeight) + 1;

		/*
		 * if (leftHeight > rightHeight) return(leftHeight+1); else
		 * return(rightHeight+1);
		 */
	}

	/*
	 * Given a binary tree and a sum, find if there is a path from root to leaf
	 * which sums to this sum. Solution: Keep going left and right and keep
	 * subtracting node value from sum. If leaf node is reached check if
	 * whatever sum is remaining same as leaf node data. Time complexity is O(n)
	 * since all nodes are visited.
	 */
	public boolean RootToLeafSumPath(Node root, int sum, List<Node> path) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			if (root.data == sum) {
				path.add(root);
				return true;
			} else {
				return false;
			}
		}
		if (RootToLeafSumPath(root.left, sum - root.data, path)
				|| RootToLeafSumPath(root.right, sum - root.data, path)) {
			path.add(root);
			return true;
		}
		/*
		 * longer version of above code written with || condition* if
		 * (RootToLeafSumPath(root.left, sum - root.data, path)) {
		 * path.add(root); return true; } if (RootToLeafSumPath(root.right, sum
		 * - root.data, path)) { path.add(root); return true; }
		 */
		return false;
	}

	// Time complexity is O(n) since we are looking at all nodes.
	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data <= min || root.data > max) {
			return false;
		}
		return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
	}

	
	


	

	public void levelOrderTraversal() {
		int h = height();
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
			System.out.println(" ");
		}
	}

	/* Print nodes at the given level */
	public void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}



		/*
	 * Utility function to store vertical order in map 'm' 'hd' is horizontal
	 * distance of current node from root. 'hd' is initially passed as 0
	 * Horizontal distance of node 'n' from root = horizontal distance of its
	 * parent from root + 1, if node 'n' is right child of its parent Horizontal
	 * distance of node 'n' from root = horizontal distance of its parent from
	 * root - 1, if node 'n' is left child of its parent
	 */
	void getVerticalOrder(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
		if (root == null)
			return;
		// get the Arraylist list at 'hd'
		ArrayList<Integer> list = m.get(hd);

		// Store current node in map 'm'
		if (list == null) {
			list = new ArrayList<>();
			list.add(root.data);
		} else
			list.add(root.data);

		m.put(hd, list);

		// Store nodes in left subtree
		getVerticalOrder(root.left, hd - 1, m);

		// Store nodes in right subtree
		getVerticalOrder(root.right, hd + 1, m);
	}

	/*
	 * The main function to print vertical oder of a binary tree with given root
	 */
	void verticalOrderTraversal() {
		// Create a map and store vertical oder in map using
		// function getVerticalOrder()
		Node parent = root;
		TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
		int hd = 0;
		getVerticalOrder(parent, hd, m);

		// Traverse the map and print nodes at every horizontal
		// distance (hd)
		for (Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
			System.out.println(entry.getValue());
		}
	}


	void convertInMirrorImage() {
		Node node = root;
		mirror(node);
		System.out.println();
	}

	Node mirror(Node node) {

		if (node == null)
			return node;
		Node lt = mirror(node.left);
		Node rt = mirror(node.right);
		node.left = rt;
		node.right = lt;
		return node;

	}

	// node1 and node2 belongs to same Tree
	boolean checkMirrorImage(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return node1 == node2;
		if (node1.data != node2.data)
			return false;
		return checkMirrorImage(node1.left, node2.right) && checkMirrorImage(node1.right, node2.left);
	}

	// node1 and node2 belongs to two diff Trees.
	boolean isSameTree(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		else if (node1 == null || node2 == null)
			return false;
		else if (node1.data != node2.data)
			return false;
		else
			return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);

	}

	boolean sameTree(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.data == root2.data && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
	}

	// This is for BST. For binary tree code is diff
	Node lowestCommonAncestor(Node node, Node n1, Node n2) {
		if (root == null)
			return root;
		if (root.data > n1.data && root.data > n2.data)
			return lowestCommonAncestor(root.left, n1, n2);
		if (root.data < n1.data && root.data < n2.data)
			return lowestCommonAncestor(root.right, n1, n2);
		return root;
	}

}
