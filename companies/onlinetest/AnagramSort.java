package companies.onlinetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramSort implements Comparator<String> {
	public String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	@Override
	// compares its two argument strings for order
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] ca = new char[26];
			for (char c : s.toCharArray())
				ca[c - 'a']++;
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<>());
			map.get(keyStr).add(s);
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String[] strArray = { "abcd", "abc", "abce", "acd", "abdc" };

		// String[] strArray = {"abcd","acdb"};
		Arrays.sort(strArray, new AnagramSort());

		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}

		System.out.println(groupAnagrams(strArray));
	}
}