package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time where n is 
  the number of nodes in the skewed tree. So time complexity of printLevelOrder() is O(n) + O(n-1) + 
 O(n-2) + .. + O(1) which is O(n^2).

Space Complexity: O(n) in worst case. For a skewed tree, printGivenLevel() uses O(n) space for call 
stack. For a Balanced tree, call stack uses O(log n) space, (i.e., height of the balanced tree). */

public class LevelOrderTreeTraversal {
	static Node root;

	public LevelOrderTreeTraversal() {
		root = null;
	}

	public static void main(String[] args) {

		LevelOrderTreeTraversal tree = new LevelOrderTreeTraversal();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(8);
		root.right.left = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("Height is : " + root.getHeight(root));
		
		tree.printLevelUsingQueue();

	}

	// Method 1
	private void printLevelOrder() {
		int height = root.getHeight(root);

		for (int i = 1; i <= height; i++) {
			printEachLevel(root, i);
		}
	}

	private void printEachLevel(Node node, int level) {
		if (node == null)
			return;
		if (level == 1)
			System.out.print(node.data + " ");
		printEachLevel(node.left, level - 1);
		printEachLevel(node.right, level - 1);
	}

	

	/* Method 2 
	 * Time complexity : O(n)
	 * space complexity : O(n) because all elements are being stored in queue
	 * */
	void printLevelUsingQueue() {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");

			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}

	}

}
