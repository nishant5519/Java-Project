package com.Exception;

public class CustomException {

	public static void main(String[] args) {
		try {
			System.out.println("Starting of try block");
			// I'm throwing the custom exception using throw
			throw new MyExceptions("This is My error Message");
		} catch (MyExceptions exp) {
			System.out.println("Catch Block");
			System.out.println(exp);
		}
	}

}

class MyExceptions extends Exception {
	String str1;

	/*
	 * Constructor of custom exception class here I am copying the message that
	 * we are passing while throwing the exception to a string and then
	 * displaying that string along with the message.
	 */
	MyExceptions(String str2) {
		str1 = str2;
	}

	public String toString() {
		return ("MyExceptions Occurred: " + str1);
	}
}
