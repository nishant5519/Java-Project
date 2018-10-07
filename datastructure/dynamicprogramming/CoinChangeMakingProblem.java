package com.datastructure.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeMakingProblem {

	static int minCoins(int[] coins, int n, int V) {
		// table to store minimum numnbers of coins required to change value i
		int[] lookup = new int[V + 1];
		int[] res = new int[V + 1];

		lookup[0] = 0;
		res[0] = -1;

		for (int i = 1; i <= V; i++) {
			lookup[i] = Integer.MAX_VALUE - 1;
			res[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= V; j++) {
				if (j >= coins[i]) {
					if (lookup[j] > 1 + lookup[j - coins[i]]) {
						lookup[j] = 1 + lookup[j - coins[i]];
						res[j] = i;
					}
				}
			}
		}

		System.out.println("lookup: " + Arrays.toString(lookup));
		System.out.println("res: " + Arrays.toString(res));

		printCoins(res, coins);

		return lookup[V];
	}

	static void printCoins(int[] res, int[] coins) {
		if (res[res.length - 1] == -1) {
			System.out.println("No change is possible");
			return;
		}

		int start = res.length - 1;

		System.out.println("The changes are: ");
		while (start > 0) {
			System.out.print(coins[res[start]] + " ");
			start -= coins[res[start]];
		}

		System.out.println("");
	}

	public static void main(String[] args) {
		int coins[] = { 1, 3, 4, 10, 20, 30, 40, 50, 100 };

		int value = 77;
		// int value = 1;
		int ans = minCoins(coins, coins.length, value);
		if (ans != Integer.MAX_VALUE - 1)
			System.out.println("The numbe of coins required to change " + value
					+ " is: " + ans);
	}
}