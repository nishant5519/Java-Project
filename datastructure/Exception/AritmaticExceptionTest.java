package com.Exception;

public class AritmaticExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i, sum;
		sum = 10;
		try {			
			for (i = -1; i < 3; ++i)
				sum = (sum / i);
		} catch (ArithmeticException e) {
			System.out.print("0");
		}
		System.out.print(sum);
	}

}
