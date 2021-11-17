package recursion;

//Given two strings s1 and s2, return true if s2 contains the permutation of s1.In other words, one of s1's permutations is the substring of s2.
public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "ab", s2 = "eidbaooo";
		System.out.println(checkInclusion_1(s1, s2));
		System.out.println(checkInclusion_2(s1, s2));
	}

	public static boolean checkInclusion_1(String s1, String s2) {

		if (s1.length() > s2.length())
			return false;

		int[] s1map = new int[26];
		int[] s2map = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			s1map[s1.charAt(i) - 'a']++;
			s2map[s2.charAt(i) - 'a']++;
		}

		for (int j = 0; j < s2.length() - s1.length(); j++) {
			if (matches(s1map, s2map))
				return true;
			s2map[s2.charAt(j + s1.length()) - 'a']++;
			s2map[s2.charAt(j) - 'a']--;
		}
		return matches(s1map, s2map);
	}

	public static boolean matches(int[] s1map, int[] s2map) {
		for (int i = 0; i < 26; i++) {
			if (s1map[i] != s2map[i])
				return false;
		}
		return true;
	}

	public static boolean checkInclusion_2(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int[] s1map = new int[26];
		int[] s2map = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			s1map[s1.charAt(i) - 'a']++;
			s2map[s2.charAt(i) - 'a']++;
		}
		int count = 0;
		for (int i = 0; i < 26; i++)
			if (s1map[i] == s2map[i])
				count++;
		for (int i = 0; i < s2.length() - s1.length(); i++) {
			int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
			if (count == 26)
				return true;
			s2map[r]++;
			if (s2map[r] == s1map[r])
				count++;
			else if (s2map[r] == s1map[r] + 1)
				count--;
			s2map[l]--;
			if (s2map[l] == s1map[l])
				count++;
			else if (s2map[l] == s1map[l] - 1)
				count--;
		}
		return count == 26;
	}

}
