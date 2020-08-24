package com.datastructure.recursion;

import java.util.Stack;

//Time complexity is O(n2)
public class ReverseStackElementsUsingDoubleRecursion {

	static Stack<String> stack = new Stack<>();

	public static void main(String[] args) {

		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");

		stack.stream().forEach(i -> System.out.println(i));
		reverse(stack);
		System.out.println("After Reversing....");
		stack.stream().forEach(i -> System.out.println(i));
	}

	static void reverse(Stack<String> stack) {

		if (stack.isEmpty())
			return;

		String temp = stack.pop();
		reverse(stack);
		reverseStack(temp);
	}

	static void reverseStack(String str) {

		if (stack.isEmpty()) {
			stack.push(str);
			return;
		}

		String temp = stack.pop();
		reverseStack(str);
		stack.push(temp);
	}

}
