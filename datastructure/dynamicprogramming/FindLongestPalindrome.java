package dynamicprogramming;

//Longest Palindrome Substring
//Time complexity: O ( n^2 ) where n is the length of input string.
//Auxiliary Space: O ( 1 )
public class FindLongestPalindrome {

	public static void main(String[] args) {
		String str = "abaforgeeksskeegfor";
		System.out.println("Length is: " + findLPSWithoutDP(str));

	}

	static int findLPSWithoutDP(String str) {
		int maxlength = 1;// assumed initial length of LPS
		int start = 0, low = 0, high = 0;
		for (int i = 1; i < str.length(); i++) {
			low = i - 1;
			high = i;
			while (isValidPalindrome(str, low, high)) {
				if (high - low + 1 > maxlength) {
					start = low;
					maxlength = high - low + 1;
				}
				--low;
				high++;
			}
			low = i - 1;
			high = i + 1;
			while (isValidPalindrome(str, low, high)) {
				if (high - low + 1 > maxlength) {
					start = low;
					maxlength = high - low + 1;
				}
				--low;
				high++;
			}
		}
		System.out.print("Longest palindrome substring is: ");
		System.out.println(str.substring(start, start + maxlength));

		return maxlength;
	}

	public static boolean isValidPalindrome(String str, int low, int high) {
		return low >= 0 && high < str.length()
				&& str.charAt(low) == str.charAt(high);
	}

}
