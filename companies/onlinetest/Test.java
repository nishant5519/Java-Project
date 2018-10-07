package com.companies.onlinetest;

import java.util.HashMap;

public class Test {
	static String value = "testify";
	static int value1 = 25;
	static {
		value1 = 50;
		System.out.println(value);
		System.out.println(value1);
	}

	public static void main(String[] args) {
		System.out.println("Hello");
		
		System.out.println("Available Processor::" + Runtime.getRuntime().availableProcessors());
		HashMap<String, String> hm;
		double d = 10.0 / -0;

		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		System.out.println(1.0 / 0.0);

		if (d == Double.POSITIVE_INFINITY)
			System.out.println("posi");
		else
			System.out.println("negi");
	}

}
