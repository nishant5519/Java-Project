package array;

public class MaximumSumSubarrayInCircularArray {

	//Time Complexity: O(n) Auxiliary Space: O(1)
	public static void main(String[] args) {
		int a[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
		System.out.println("Maximum circular sum is " + maxCircularSum(a));

	}

	private static int maxCircularSum(int[] arr) {

		int max_sum1 = kadane(arr);
		int sum_array = 0;
		for (int i = 0; i < arr.length; i++) {
			sum_array = sum_array + arr[i];
			arr[i] = -arr[i];
		}

		sum_array = sum_array - (- kadane(arr)) ;

		return max_sum1 > sum_array ? max_sum1 : sum_array;

	}

	private static int kadane(int[] arr) {

		int consecutive_sum = 0;
		int max_sum_so_far = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			consecutive_sum = consecutive_sum + arr[i];
			if (max_sum_so_far < consecutive_sum)
				max_sum_so_far = consecutive_sum;

			if (consecutive_sum < 0)
				consecutive_sum = 0;
		}

		return max_sum_so_far;
	}

}
