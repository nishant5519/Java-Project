package com.Exception;

import java.util.ArrayList;
import java.util.List;

public class LoopAndException {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
	

		for (String str : list) {
			try {
				System.out.println(str);
				throw new Exception("Exception for string " + str);
			} catch (Exception ex) {
				System.out.println("Caught exception");
			}
		}
	}

}
