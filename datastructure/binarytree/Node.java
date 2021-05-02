package binarytree;

class Node {
	public int data;
	public Node left, right;

	public Node(int d) {
		this.data = d;
	}

	public int getHeight(Node node) {

		if (node == null)
			return 0;
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

}