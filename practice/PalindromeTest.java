package practice;

public class PalindromeTest {	
	public static void main(String[] args) {
		String s="dad";
		System.out.println(isPalindrome(s));
	}

	
	public static boolean isPalindrome(String str) {
		  int strLength = str.length();
		  for (int i = 0; i < (strLength/2); ++i) {
		     if (str.charAt(i) != str.charAt(strLength - i - 1)) {
		         return false;
		     }
		  }

		  return true;
		}
}
