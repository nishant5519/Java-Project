package com.Exception;

public class TestReturnStatementInException {

	public static void main(String[] args) {
		System.out.println(getValue());
		System.out.println(getVal());
	}

	static int getValue() {
		try {
			return 1;
		} catch (Exception e) {
			System.out.println("Inside catch");
		} finally {
			System.out.println("Finally executed");
		}
		return 0;
	}

	static int getVal() {
		try {
			int a = 1, c, b = 0;
			c = a / b;
			return 1;
		} catch (Exception e) {
			System.out.println("Inside catch");
			return 2;
		} finally {
			return 3;
		}
	}

}
