package com.companies.onlinetest;

import java.util.ArrayList;
import java.util.Collections;

public class Microsoft {

	public static void main(String[] args) {
		ArrayList<String> listOfString = new ArrayList<String>();
		listOfString.add("B");
		listOfString.add("P");
		listOfString.add("U");
		listOfString.add("A");
		Collections.sort(listOfString);
		System.out.println(listOfString);
		ArrayList<Integer> listOfInteger = new ArrayList<Integer>();
		listOfInteger.add(56);
		listOfInteger.add(51);
		listOfInteger.add(45);
		listOfInteger.add(100);
		Collections.sort(listOfInteger);
		System.out.println(listOfInteger);

		int j = 2, y = 3, z = 10;
		for (; j < 6; j++) {
			y = (++y + z++);
			System.out.println(y + z);
		}
	}

}
