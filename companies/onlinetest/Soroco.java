package com.companies.onlinetest;

import java.util.List;
import java.util.Stack;

public class Soroco {

	public static void main(String[] args) {
		String str = "abc";
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++)
			System.out.println((int) ch[i] - 97);

	}

	static int maximum_cookies(List<Integer> jars) {
		int include = jars.get(0);
		int exclude = 0;
		int excl_new;
		int i;

		for (i = 1; i < jars.size(); i++) {
			excl_new = (include > exclude) ? include : exclude;

			include = exclude + jars.get(i);
			exclude = excl_new;
		}

		return ((include > exclude) ? include : exclude);

	}

}
