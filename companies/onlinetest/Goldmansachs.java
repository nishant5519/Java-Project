package companies.onlinetest;

public class Goldmansachs {

	public static void main(String[] args) {
		int n = nonRepeatingDigitProductCount(1, 0, 99);
		System.out.println(n);
	}

	static int nonRepeatingDigitProductCount(int x, int y, int z) {
		int range = z - y;
		int count = 0;

		for (int i = 0; i <= range; i++) {
			int product = x * y;
			if (!checkProductContainsNumber(product, y))
				count = count + 1;
			y = y + 1;
		}

		return count;

	}
	// check the answer for x =1 and range from 0 to 99 -->
	static boolean checkProductContainsNumber(int product, int y) {
		while (y >= 0) {
			int lastdigit = y % 10;
			String strY = String.valueOf(lastdigit);
			String strProduct = String.valueOf(product);
			boolean temp = strProduct.contains(strY);
			if (temp)
				return true;
			y /= 10;
		}
		return false;

	}

	static int[] findTruckCargo(int maxCargoWeight, int[][] cargoList) {
		int rows = cargoList.length;
		int cols = cargoList[0].length;
		int listOfWeight[] = new int[rows];
		for (int i = 0; i < rows; i++)
			listOfWeight[i] = cargoList[i][1];
		return null;
	}

	// Returns true if there is a subset of set[] with sum equal to given sum
	static boolean isSubsetSum(int set[], int n, int sum) {
		// The value of subset[i][j] will be true if there
		// is a subset of set[0..j-1] with sum equal to i
		boolean subset[][] = new boolean[sum + 1][n + 1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		// If sum is not 0 and set is empty, then answer is false
		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		// Fill the subset table in botton up manner
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j]
							|| subset[i - set[j - 1]][j - 1];
			}
		}

		/*
		 * // uncomment this code to print table for (int i = 0; i <= sum; i++)
		 * { for (int j = 0; j <= n; j++) System.out.println (subset[i][j]); }
		 */

		return subset[sum][n];

	}

}
