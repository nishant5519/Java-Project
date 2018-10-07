package com.datastructure.stack;

public class StackApp {

	// Array Implementation of Stack
	public static void main(String[] args) {
		StackX theStack = new StackX(10); // make new stack
		theStack.push(20); // push items onto stack
		theStack.push(40);
		theStack.push(60);
		theStack.push(80);
		/*
		 * while (!theStack.isEmpty()) // until it’s empty, { // delete item
		 * from stack int value = theStack.peek(); System.out.print(value); //
		 * display it System.out.print(" "); } // end while
		 */
		theStack.revertStack(theStack);
		while (!theStack.isEmpty()) // until it’s empty,
		{ // delete item from stack
			int value = theStack.pop();
			System.out.print(value); // display it
			System.out.print(" ");
		} // end while
	}

}

class StackX {
	private int maxSize; // size of stack array
	private int[] stackArray;
	private int top; // top of stack

	// --------------------------------------------------------------

	public StackX(int s) // constructor
	{
		maxSize = s; // set array size
		stackArray = new int[maxSize]; // create array
		top = -1; // no items yet
	}

	// --------------------------------------------------------------
	public void push(int j) // put item on top of stack
	{
		if (top >= maxSize)
			System.out.println("Stack Overflow");
		stackArray[++top] = j; // increment top, insert item
	}

	// --------------------------------------------------------------
	public int pop() // take item from top of stack
	{
		if (top < 0)
			System.out.println("Stack Underflow");
		return stackArray[top--]; // access item, decrement top
	}

	// --------------------------------------------------------------
	public int peek() // peek at top of stack
	{
		return stackArray[top];
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if stack is empty
	{
		return (top == -1);
	}

	// --------------------------------------------------------------
	public boolean isFull() // true if stack is full
	{
		return (top == maxSize - 1);
	}

	// --------------------------------------------------------------
//using double recursion
	public void revertStack(StackX s) {
		if (s.isEmpty()) {
			return;
		} else {
			Integer a = s.pop();
			revertStack(s);
			appendStack(s, a);
		}
	}

	public void appendStack(StackX s, Integer a) {
		if (s.isEmpty()) {
			s.push(a);
			return;
		} else {
			Integer o = s.pop();
			appendStack(s, a);
			s.push(o);
		}
	}
	
	// Method to sort stack using double recursion
	void sortStack(StackX s) {
		if (!s.isEmpty()) { // If stack is not empty
			int x = s.pop();// Remove the top item
			sortStack(s);// Sort remaining stack
			sortedInsert(s, x);// Push the top item back in sorted stack
		}
	}

	void sortedInsert(StackX s, int x) {
		// Base case: Either stack is empty or newly inserted
		// item is greater than top (more than all existing)
		if (s.isEmpty() || x > s.peek()) {
			s.push(x);
			return;
		}
		int temp = s.pop();// If top is greater, remove the top item and recur
		sortedInsert(s, x);
		s.push(temp);// Put back the top item removed earlier
	}
	
} // end class StackX