package dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

	//Using Recursion
	public int lcs(char str1[], char str2[], int len1, int len2) {

		if (len1 == str1.length || len2 == str2.length) {
			return 0;
		}
		if (str1[len1] == str2[len2]) {
			return 1 + lcs(str1, str2, len1 + 1, len2 + 1);
		} else {
			return Math.max(lcs(str1, str2, len1 + 1, len2),
					lcs(str1, str2, len1, len2 + 1));
		}
	}

	private static int findSequenceUsingTabulation(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();

		int dp[][]=new int[l1+1][l2+1];

		for (int i=0;i<=l1;i++)
			dp[i][0] = 0;

		for (int i=0;i<=l2;i++)
			dp[0][i] = 0;

		for(int i=1;i<=l1;i++){
			for(int j=1;j<=l2;j++){
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
			}

		}

		return dp[l1][l2];
	}


	//Adding Memoization. Time complexity O(mn) Space Complexity O(mn)
	private static int findSequenceUsingMemoization(String s1, String s2, int l1, int l2, int[][] dp) {

		if (dp[l1][l2] != -1)
			return dp[l1][l2];
		if (l1 == 0 || l2 == 0)
			dp[l1][l2] = 0;

		else if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
			dp[l1][l2] = 1 + findSequenceUsingMemoization(s1, s2, l1 - 1, l2 - 1, dp);
		else
			dp[l1][l2] = Math.max(findSequenceUsingMemoization(s1, s2, l1, l2 - 1, dp), findSequenceUsingMemoization(s1, s2, l1 - 1, l2, dp));

		return dp[l1][l2];
	}

	public static void main(String args[]) {
		String s1 = "abcde";
		String s2 = "be";
		int l1 = s1.length();
		int l2 = s2.length();

		int[][] arr = new int[l1 + 1][l2 + 1];

		// assign -1 to all positions
		for (int[] row : arr) {
			Arrays.fill(row, -1);
		}

		// System.out.print(findSequenceUsingMemoization(s1, s2, l1, l2, arr));
		//   System.out.print(findSequence(s1,s2,l1,l2));
		System.out.print(findSequenceUsingTabulation(s1, s2));

	}

}