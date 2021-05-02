package array;

public class FindLargestSubarrayWithAlternateNegativePositiveNum {

	public static void main(String[] args) {
	//	int[] arr = { 1, -2, 6, 7, -3, 8, -9, -4 };
		int[] arr = { -1, -2, -6, -7, 3, -8, -9, 4 };
		System.out.println(findLargestLength(arr));
	}

	private static int findLargestLength(int[] num) {

		int len = 0;
		int startIndex = 0;
		int nextIndex = 1;
		boolean isPositive = num[0] > 0 ? true : false;

		while (nextIndex < num.length) {

			if (isPositive && num[nextIndex] < 0) {
				isPositive = false;
				nextIndex++;

			}

			else if (!isPositive && num[nextIndex] > 0) {
				isPositive = true;
				nextIndex++;
			}

			else if (num[nextIndex] * num[nextIndex - 1] > 0){
				isPositive = num[nextIndex] > 0 ? true : false;
				startIndex = nextIndex ;
				nextIndex++;
			}

			if (len < (nextIndex - startIndex))
				len = (nextIndex - startIndex);

		}

		return len;
	}

}
