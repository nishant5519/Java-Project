package com.datastructure.array;

public class MaxSumOfLengthsOfNonOverlappingSubarraysWithKAsTheMaxElement {
	static int count = 0;

	public static void main(String[] args) {
		int arr[] = { 2, 1, 4, 9, 2, 3, 8, 3, 4 ,1};
		int size = arr.length;

		int k = 4;
		int ans = calculateMaxSumLength(arr, size, k);
		System.out.println("Max Length :: " + ans);
	}

	public static int calculateMaxSumLength(int[] arr, int size, int k) {
		int cnt = 0, Max = 0, i, total = 0;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] <= k) {
				++cnt;
				Max = Max < arr[i] ? arr[i] : Max;
			} else {
				if (Max == k)
					total = total + cnt;
				Max = 0;
				cnt = 0;

			}

		}
		if (Max == k)
			total = total + cnt;
		return total;

	}

	

}
