package com.datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DelimiterMatching {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		String s = null;

		BufferedReader bf = new BufferedReader(isr);
		try {
			s = bf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Match match = new Match(s);
		System.out.println(match.matcher());

	}
}

class Match {
	String name;

	public Match(String name) {
		super();
		this.name = name;
	}

	public boolean matcher() {
		StackXXX stack = new StackXXX(name.length());
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == '(' || name.charAt(i) == '{'
					|| name.charAt(i) == '[') {
				stack.push(name.charAt(i));
			}
			if ((name.charAt(i) == '}' || name.charAt(i) == ')'
					|| name.charAt(i) == ']') && !stack.isEmpty() ) {
				if ((stack.peek() == '{' && name.charAt(i) == '}')
						|| (stack.peek() == '(' && name.charAt(i) == ')')
						|| (stack.peek() == '[' && name.charAt(i) == ']'))
					stack.pop();
			}

		}
		
		if (stack.isEmpty())
			return true;
		else
			return false;

	}
}

class StackXXX {
	private int maxSize; // size of stack array
	private char[] stackArray;
	private int top; // top of stack

	// --------------------------------------------------------------

	public StackXXX(int s) // constructor
	{
		maxSize = s; // set array size
		stackArray = new char[maxSize]; // create array
		top = -1; // no items yet
	}

	// --------------------------------------------------------------
	public void push(char j) // put item on top of stack
	{
		stackArray[++top] = j; // increment top, insert item
	}

	// --------------------------------------------------------------
	public char pop() // take item from top of stack
	{
		return stackArray[top--]; // access item, decrement top
	}

	// --------------------------------------------------------------
	public char peek() // peek at top of stack
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
} // end class StackXXXXXXX

