package com.datastructure.array;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}
	//Time Complexity: O(n)
	static int maxSubArraySum(int a[]) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, consecutiveSum = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			//max sum at index i maxSum[i]=max(arr[i],maxSum[i]+arr[i])
			consecutiveSum = consecutiveSum + a[i]; 
			if (max_so_far < consecutiveSum) {
				max_so_far = consecutiveSum;
				start = s;
				end = i;
			}
			if (consecutiveSum < 0) {
				consecutiveSum = 0;
				s = i + 1;
			}
		}
		System.out
				.println("Start index: " + start + ", " + "End Index: " + end);
		return max_so_far;
	}
}
