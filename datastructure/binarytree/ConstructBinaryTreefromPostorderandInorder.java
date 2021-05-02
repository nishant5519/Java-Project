package binarytree;

public class ConstructBinaryTreefromPostorderandInorder {

	public static void main(String[] args) {
		int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
		Node root = ConstructBinaryTreefromPostorderandInorder.buildTree(in, post);
		System.out.println("Preorder of the constructed tree : ");
		ConstructBinaryTreefromPostorderandInorder.inOrder(root);
	}

	public static Node buildTree(int[] inorder, int[] postorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;

		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}

	public static Node buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;

		int rootValue = postorder[postEnd];
		Node root = new Node(rootValue);

		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}

		// k-inStart is number of elements in leftsubtree
		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
		// Because k is not the length, it it need to -(inStart+1) to get the
		// length
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd - 1);
		// postStart+k-inStart = postStart+k-(inStart+1) +1

		return root;
	}

	static void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

}