package com.datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {
	public static void main(String[] args) throws IOException {
		String input, output;

		System.out.print("Enter a string: ");
		System.out.flush();
		input = getString(); // read a string from keyboard
		if (input.equals(""))
			System.out.println("String is empty");
		else {
			Reverser theReverser = new Reverser(input);
			output = theReverser.doRev(); // use it
			System.out.println("Reversed String: " + output);
		}

	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	// --------------------------------------------------------------
}

class Reverser {
	private String input; // input string
	private String output; // output string

	// --------------------------------------------------------------
	public Reverser(String in) // constructor
	{
		input = in;
	}

	// --------------------------------------------------------------
	public String doRev() // reverse the string
	{
		int stackSize = input.length(); // get max stack size
		StackY theStack = new StackY(stackSize); // make stack
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j); // get a char from input
			theStack.push(ch); // push it
		}
		output = " ";
		while (!theStack.isEmpty()) {
			char ch = theStack.pop(); // pop a char,
			output = output + ch; // append to output
		}
		return output;
	} // end doRev()
}

class StackY {
	private int maxSize;
	private char[] stackArray;
	private int top;

	// --------------------------------------------------------------
	public StackY(int max) // constructor
	{
		maxSize = max;
		stackArray = new char[maxSize];
		top = -1;
	}

	// --------------------------------------------------------------
	public void push(char j) // put item on top of stack
	{
		stackArray[++top] = j;
	}

	// --------------------------------------------------------------
	public char pop() // take item from top of stack
	{
		return stackArray[top--];
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

}