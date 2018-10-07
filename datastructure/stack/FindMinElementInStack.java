package com.datastructure.stack;

import java.util.Stack;

public class FindMinElementInStack extends Stack<Integer> {
	// All operations are of O(1) and space complexity is O(n) because of use of
	// auxiliary stack
	Stack<Integer> min = new Stack<Integer>();

	void push(int x) {
		if (min.isEmpty() || super.isEmpty()) {
			min.push(x);
			super.push(x);
		} else {
			super.push(x);
			if (x < min.peek())
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


//All operations are of O(1) and space complexity is O(1) 
class MyStack {
	Stack<Integer> s;
	Integer minEle;

	// Constructor
	MyStack() {
		s = new Stack<Integer>();
	}

	// Prints minimum element of MyStack
	void getMin() {
		// Get the minimum number in the entire stack
		if (s.isEmpty())
			System.out.println("Stack is empty");

		// variable minEle stores the minimum element
		// in the stack.
		else
			System.out.println("Minimum Element in the " + " stack is: " + minEle);
	}

	// prints top element of MyStack
	void peek() {
		if (s.isEmpty()) {
			System.out.println("Stack is empty ");
			return;
		}

		Integer t = s.peek(); // Top element.

		System.out.print("Top Most Element is: ");

		// If t < minEle means minEle stores
		// value of t.
		if (t < minEle)
			System.out.println(minEle);
		else
			System.out.println(t);
	}

	// Removes the top element from MyStack
	void pop() {
		if (s.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		System.out.print("Top Most Element Removed: ");
		Integer t = s.pop();

		// Minimum will change as the minimum element
		// of the stack is being removed.
		if (t < minEle) {
			System.out.println(minEle);
			minEle = 2 * minEle - t;
		}

		else
			System.out.println(t);
	}

	// Insert new number into MyStack
	void push(Integer x) {
		if (s.isEmpty()) {
			minEle = x;
			s.push(x);
			System.out.println("Number Inserted: " + x);
			return;
		}

		// If new number is less than original minEle
		if (x < minEle) {
			s.push(2 * x - minEle);
			minEle = x;
		}

		else
			s.push(x);

		System.out.println("Number Inserted: " + x);
	}
}