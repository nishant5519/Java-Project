package dynamicprogramming;

import java.util.Arrays;

public class CoinChangeProblemMinCoinsReqdPart1 {
	public static void main(String[] args) {

		int n = 18;
		int a[] = { 1, 7, 5 };

		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		int ans = minCoins(n, a, dp);
		System.out.println(ans);

		for (int x : dp) {
			System.out.print(x + " ");
		}
		System.out.println("");
		System.out.println(minCoinsChange(a,18));
	}

	//DP approach
	static int minCoins(int n, int a[], int dp[]) {

		if (n == 0)
			return 0;

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (n - a[i] >= 0) {
				int subAns = 0;
				if (dp[n - a[i]] != -1) {
					subAns = dp[n - a[i]];
				} else {
					subAns = minCoins(n - a[i], a, dp);
				}
				if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
					ans = subAns + 1;
				}
			}
		}
		return dp[n] = ans;
	}

	//DP approach .worst case time complexity O(coins.length X amount) =O(mn)
	static int minCoinsChange(int coins[], int amount) {

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount);
		dp[0] = 0;

		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j <= amount; j++) {

				if (coins[i] <= j)
					dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
			}
		}
		
		for (int x : dp) {
			System.out.print(x + " ");
		}
		System.out.println("");
		return dp[amount] > amount ? -1 : dp[amount];
	}
}