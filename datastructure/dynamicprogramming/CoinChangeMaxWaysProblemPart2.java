package dynamicprogramming;

public class CoinChangeMaxWaysProblemPart2 {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		System.out.println(countWays(arr, m, 4));
	}

	// Returns the count of ways we can
	// sum S[0...m-1] coins to get sum n
	static int count(int S[], int m, int n) {
		// If n is 0 then there is 1 solution
		// (do not include any coin)
		if (n == 0)
			return 1;

		// If n is less than 0 then no
		// solution exists
		if (n < 0)
			return 0;

		// If there are no coins and n
		// is greater than 0, then no
		// solution exist
		if (m <= 0 && n >= 1)
			return 0;

		// count is sum of solutions (i)
		// including S[m-1] (ii) excluding S[m-1]
		return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
	}
	
	//DP way. Time Complexity: O(mn)
	static long countWays(int coins[], int n, int sum) 
    { 
		// table[i] will be storing the number of solutions for 
	    // value i. We need n+1 rows as the table is constructed 
	    // in bottom up manner using the base case (n = 0) 
	    int table[]=new int[sum+1]; 
	  
	    // Base case (If given value is 0) 
	    table[0] = 1; 
	  
	    // Pick all coins one by one and update the table[] values 
	    // after the index greater than or equal to the value of the 
	    // picked coin 
	    for(int i=0; i<n; i++) 
	        for(int j=coins[i]; j<=sum; j++) 
	            table[j] += table[j-coins[i]]; 
	  
	    return table[sum]; 
    } 
	
		//n =  number of coins
		static long countWaysGfG(int coins[], int n, int sum) 
	    { 
			
			int[][] dp = new int[sum+1][n+1];
			
			for(int i = 0; i <= n ; i++)
				dp[0][i] = 1;
			
			for(int j = 1; j <= sum ; j++)
				dp[j][0] = 0;
			
			for(int i = 1 ; i <= sum ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					dp[i][j] = dp[i][j-1]; //exclude
					if(i >= coins[j-1]) {
						dp[i][j] = dp[i][j] + dp[i-coins[j-1]][j]; //include
					}
					
				}
			}
			return dp[sum][n];
	    } 
}