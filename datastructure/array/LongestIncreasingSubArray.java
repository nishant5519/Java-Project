package array;

public class LongestIncreasingSubArray {
	//LongestIncreasingSubsequence is diff problem

	public static void main(String[] args) {
		int[] arr = { 5, 6, 3, 5, 7, 1, 2, 3 }; // {3, 5, 7, 8, 9}
		int startIndex = 0, maxLen = 1, subArrayMaxlen = 1;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] > arr[i])
				maxLen++;
			else {
				if (subArrayMaxlen < maxLen) {
					subArrayMaxlen = maxLen;
					startIndex = i + 1 - subArrayMaxlen;
				}
				maxLen = 1;

			}
		}
		if (subArrayMaxlen < maxLen) {
			subArrayMaxlen = maxLen;
			startIndex = arr.length - subArrayMaxlen;
		}
		for (int j = startIndex; j < subArrayMaxlen + startIndex; j++) {
			System.out.println(arr[j] + " ");
		}

	}
}
