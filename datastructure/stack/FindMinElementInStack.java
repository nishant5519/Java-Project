package com.datastructure.stack;

import java.util.Stack;

public class FindMinElementInStack extends Stack<Integer> {

	private static final long serialVersionUID = 1L;
	// All operations are of O(1) and space complexity is O(n) because of use of
	// auxiliary stack
	Stack<Integer> min = new Stack<Integer>();

	void push(int x) {
		if (min.isEmpty() || super.isEmpty()) {
			min.push(x);
			super.push(x);
		} else {
			super.push(x);
			if (x <= min.peek())
				min.push(x);
		}
	}

	public Integer pop() {
		if (super.peek().equals(min.peek()))
			min.pop();
		return super.pop();
	}

	int getMin() {
		if (min.isEmpty())
			return 0;
		return min.peek();

	}

	public static void main(String[] args) {
		FindMinElementInStack s = new FindMinElementInStack();
		s.push(26);
		s.push(18);
		s.push(19);
		s.push(29);
		s.push(15);
		s.push(16);
		System.out.println(s.getMin());
		s.pop();
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		s.pop();
		s.pop();
		System.out.println(s.getMin());
	}

}

// All operations are of O(1) and space complexity is O(1)
class MyStack {
	Stack<Integer> s;
	Integer minEle;

	MyStack() {
		s = new Stack<Integer>();
	}

	void getMin() {
		if (s.isEmpty())
			System.out.println("Stack is empty");

		else
			System.out.println("Minimum Element in the " + " stack is: " + minEle);
	}

	void peek() {
		if (s.isEmpty()) {
			System.out.println("Stack is empty ");
			return;
		}

		Integer t = s.peek(); // Top element.

		System.out.print("Top Most Element is: ");

		if (t < minEle)
			System.out.println(minEle);
		else
			System.out.println(t);
	}

	void pop() {
		if (s.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		Integer topElement = s.pop();

		// Minimum will change as the minimum element
		// of the stack is being removed.
		if (topElement < minEle) {
			System.out.println(minEle);
			minEle = 2 * minEle - topElement;
		}

		else
			System.out.println(topElement);
	}

	void push(Integer curr) {
		if (s.isEmpty()) {
			minEle = curr;
			s.push(curr);
		}

		// If new number is less than original minEle
		if (curr < minEle) {
			s.push(2 * curr - minEle);
			minEle = curr;
		}

		else
			s.push(curr);

	}
}