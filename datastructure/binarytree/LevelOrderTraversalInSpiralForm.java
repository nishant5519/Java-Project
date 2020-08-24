package com.datastructure.binarytree;

import java.util.Stack;


public class LevelOrderTraversalInSpiralForm {

	static Node root;

	public LevelOrderTraversalInSpiralForm() {
		root = null;
	}

	public static void main(String[] args) {
		LevelOrderTraversalInSpiralForm levelorder = new LevelOrderTraversalInSpiralForm();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		System.out.println("Spiral order traversal of Binary Tree is ");
		levelorder.spiralFormTraversal();
	}
	
	
	private void spiralFormTraversal(){
		
		Stack<Node> stack=new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()){
			Node temp = stack.pop();
			System.out.print(temp.data + " ");
			
			if(temp.left!=null)
				stack.push(temp.left);
			if(temp.right!=null)
				stack.push(temp.right);
			
			
		}
	}

}
