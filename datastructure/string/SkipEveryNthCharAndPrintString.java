package string;

import java.util.ArrayList;
import java.util.List;

public class SkipEveryNthCharAndPrintString {

	public static void main(String[] args) {

		List<String> strings = new ArrayList<String>();
		strings.add("Hello, World!");
		strings.add("Welcome to CoderPad.");
		strings.add("This pad is running Java ");
		strings.add("abcdefghtyiadasdhsafhsnf,ndnalmd fsdfrwe");

		for (String string : strings) {
			System.out.println(string + ":" + skipEveryNthChar(string, 3));
		}

	}

	public static String skipEveryNthChar(String str, int n) {
		// skipEveryNthChar("abcdefghtyiadasdhsafhsnf,ndnalmd fsdfrwe", 5) ==>
		// "abdeg"

		if (str == null)
			return "";
		if (str.length() < n)
			return str;

		StringBuilder sb = new StringBuilder();
		String temp = null;
		for (int i = 0; i < str.length(); i = i + n) {

			if (i + n > str.length())
				temp = str.substring(i);
			else
				temp = str.substring(i, i + n - 1);

			sb.append(temp);
		}

		return sb.toString();

	}

}
