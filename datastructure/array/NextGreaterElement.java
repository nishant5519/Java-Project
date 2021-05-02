package array;

import java.util.Stack;

//Time Complexity: O(n).
public class NextGreaterElement {

	public static void main(String[] args) {
		// int arr[] = { 11, 8, 9, 1, 2, 5, 4, 13};
		int arr[] = { 5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4 };
		int n = arr.length;
		printNextGreaterElement(arr);
	}

	public static void printNextGreaterElement(int[] input) {
		Stack<Integer> stack = new Stack<Integer>();
		int inputSize = input.length;
		stack.push(input[0]);
		for (int i = 1; i < inputSize; i++) {
			while (!stack.isEmpty() && stack.peek() < input[i]) {
				System.out.println("Next greater element for " + stack.pop()
						+ "\t = " + input[i]);
			}
			stack.push(input[i]);
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			System.out.println("Next greater element for " + top + "\t = "
					+ "-1");
		}
	}

}
