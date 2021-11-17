package recursion;

public class FindAllPemutationsOfString {

	//No of permutations for length n string is n!
	public static void main(String[] args) {
		String s = "abc";
		findAllPermuatations(s, "");
		System.out.println();
		permute(s, 0, s.length() - 1);
	}

	private static void findAllPermuatations(String str, String ans) {
		// If string is empty
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding the ith character
			String ros = str.substring(0, i) + str.substring(i + 1);

			// Recurvise call
			findAllPermuatations(ros, ans + ch);
		}
	}

	//Time complexity O(n*n!) where n is length of the string
	private static void permute(String str, int l, int r) {
		if (l == r) {
			System.out.print(str + " ");
			return;
		}

		for (int i = l; i <= r; i++) {
			str = swap(str, l, i);
			permute(str, l + 1, r);
			str = swap(str, l, i);
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	private static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
