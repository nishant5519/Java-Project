package array;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindCountOfOccurenceOfStringinAnArray {

	public static void main(String[] args) {
		String s1 = "t";
		String[] s2 = { "abcdetest", "tetstest", "ddsfkbfktest", "dadtestsfsdf", "testabc", "stes", "ab", "t", "s",
				"st", "q", " " };
		int count = 0;
		String str = null;
		for (String string : s2) {
			if (string.length() >= s1.length()) {
				str = string.substring(string.length() - s1.length(), string.length());
				System.out.println(str);
				if (str.equals(s1))
					count++;

			}

		}

		System.out.println(count);

		Stream<String> stream = Arrays.stream(s2);
		long occurences = stream.filter(s -> s.endsWith(s1)).count();
		System.out.println(occurences);
	}

}
