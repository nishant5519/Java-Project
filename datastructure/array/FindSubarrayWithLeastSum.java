package array;

public class FindSubarrayWithLeastSum {

	public static void main(String[] args) {
		int[] arr = { 3, 7, 90, 20, 10, 50, 40 };
		int B = 3;
		System.out.println(solve(arr, B));
	}

	private static int solve(int[] A, int B) {

		int sum = 0;
		int leastAvg = Integer.MAX_VALUE;
		int startIdx = 0;
		for (int i = 0; i < B; i++) {
			sum = sum + A[i];
		}

		// System.out.println("Sum : " + sum);

		leastAvg = sum;

		for (int i = 1; i <= A.length - B; i++) {
			int endIndex = i+B-1;
			sum = sum - A[i] + A[endIndex];

			if (leastAvg > sum) {
				leastAvg = sum;
				startIdx = i;
			}
		}

		return startIdx;

	}

}
