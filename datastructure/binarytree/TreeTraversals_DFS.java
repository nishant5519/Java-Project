package binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TreeTraversals_DFS {

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

	// non-recursive java program for inorder traversal using STACK
	void inorderItr(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while (true) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				if (stack.isEmpty())
					break;
				node = stack.pop();
				System.out.print(node.data + " ");
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

	public void preOrderItrUsingOneStack(Node root) {
		if (root == null)
			return;
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while (!s.isEmpty()) {
			root = s.pop();
			System.out.println(root.data);
			if (root.right != null)
				s.push(root.right);
			if (root.left != null)
				s.push(root.left);
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

	// Time complexity: O(n) Space complexity: O(n)
	public void postOrderItrUsingTwoStack(Node root) {
		if (root == null)
			return;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while (!s1.isEmpty()) {
			Node temp = s1.pop();
			s2.push(temp);
			if (temp.left != null)
				s1.push(temp.left);
			if (temp.right != null)
				s1.push(temp.right);
		}

		while (!s2.isEmpty()) {
			Node temp = s2.pop();
			System.out.print(temp.data + " ");
		}

	}

	public void postOrderItrOneStack(Node root) {
		Node current = root;
		Deque<Node> stack = new LinkedList<>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.addFirst(current);
				current = current.left;
			} else {
				Node temp = stack.peek().right;
				if (temp == null) {
					temp = stack.poll();
					System.out.print(temp.data + " ");
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.poll();
						System.out.print(temp.data + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

}