package array;

import java.util.HashSet;

public class CheckForPairInArrayWithSumAsX {

	/*
	 * Some notes about the solution :The best way would be to insert every
	 * element into a hash table (without sorting). This takes O(n) as constant
	 * time insertion. Then for every x, we can just look up its complement,
	 * T-x, which is O(1). Overall the run time of this approach is O(n).
	 * 
	 * We iterate only once through the array --> O(n) time Insertion and lookup
	 * time in Hash is O(1). Overall time is O(n), although it uses extra space
	 * in terms of hash.
	 */
	public static void printSumPairs(int[] input, int k) {
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < input.length; ++i) {
			int temp = k - input[i];
			if (temp >= 0 && s.contains(temp)) {
				System.out.println("Pair with given sum " + k + " is (" + input[i] + ", " + temp + ")");
			}
			s.add(input[i]);
		}
	}

	public static void main(String[] args) {
		int A[] = { 8, 10, 2, 4, 12 };
		int n = 16;
		// printpairs(A, n);
		printSumPairs(A, n);
		// printSumPairsIterativly(A,n);

	}

	private static void printSumPairsIterativly(int[] a, int n) {

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == n)
					System.out.println("Pairs is :" + "(" + a[i] + "," + a[j] + ")");
			}
		}

	}

}
