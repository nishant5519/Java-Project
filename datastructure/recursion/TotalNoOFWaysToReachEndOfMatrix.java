package recursion;

public class TotalNoOFWaysToReachEndOfMatrix {

	public static void main(String[] args) {
		System.out.println(numberOfPathsUsingRecursion(4, 4));
		System.out.println(numberOfPathsUsingDP(4, 4));
	}

	public static int numberOfPathsUsingRecursion(int m, int n) {

		if (m == 1 || n == 1)
			return 1;

		return numberOfPathsUsingRecursion(m - 1, n) + numberOfPathsUsingRecursion(m, n - 1);

	}
//Time complexity and space complexity of the  dynamic programming solution is O(mn)
	public static int numberOfPathsUsingDP(int m, int n) {
		int[][] dp = new int[m][n];
		
		for(int i=0;i<m;i++)
			dp[i][0]=1;
		
		for(int j=0;j<n;j++)
			dp[0][j]=1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}

}
