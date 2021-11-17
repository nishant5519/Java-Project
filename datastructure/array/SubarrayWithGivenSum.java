package array;

/*
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.
 * */
public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		int[] array = { 15, 2, 5, 6, 9 };
		int target = 7;
		int result[] = solve(array, target);
		for(int val : result) {
			System.out.print(val + " ");
		}
	}

	public static int[] solve(int[] A, int B) {
		int sum = 0;
		int left = 0;
		int i = 0;
		for (i = 0; i < A.length; i++) {

			sum = sum + A[i];

			while (sum > B) {
				sum = sum - A[left];
				left++;
			}

			if (sum == B) {
				break;
			}
		}
		if (sum < B)
			return new int[] { -1 };
		int size = i - left + 1;
		int[] result = new int[size];
		for (int j = 0; j < size; j++) {
			result[j] = A[left];
			left++;

		}
		return result;
	}

}
