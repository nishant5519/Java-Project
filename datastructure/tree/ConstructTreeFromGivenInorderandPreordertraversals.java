package tree;

public class ConstructTreeFromGivenInorderandPreordertraversals {

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int preStart = 0;
		int preEnd = preorder.length - 1;
		int inStart = 0;
		int inEnd = inorder.length - 1;

		return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
	}

	public static TreeNode construct(int[] preorder, int preStart, int preEnd,
			int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		int val = preorder[preStart];
		TreeNode p = new TreeNode(val);

		// find parent element index from inorder
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (val == inorder[i]) {
				k = i;
				break;
			}
		}

		p.left = construct(preorder, preStart + 1, preStart + (k - inStart),
				inorder, inStart, k - 1);
		p.right = construct(preorder, preStart + (k - inStart) + 1, preEnd,
				inorder, k + 1, inEnd);

		return p;
	}

	/* This function is here just to test buildTree() */
	static void printInorder(TreeNode node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	// driver program to test above functions
	public static void main(String args[]) {
		int in[] = new int[] { 4, 2, 5, 1, 6, 3 };
		int pre[] = new int[] { 1, 2, 4, 5, 3, 6 };
		TreeNode root = ConstructTreeFromGivenInorderandPreordertraversals
				.buildTree(pre, in);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		ConstructTreeFromGivenInorderandPreordertraversals.printInorder(root);

	}
}
