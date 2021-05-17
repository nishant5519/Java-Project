package binarysearch;

public class FindAPairExistsWithGivenSumInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 12, 30 };
		int x = 17;
		System.out.println(solution1(arr, x));
	}

	public static boolean solution1(int[] arr, int target) {

		int left = 0;
		int right = arr.length - 1;

		while (right > left) {

			if (arr[left] + arr[right] > target)
				right--;
			else if (arr[left] + arr[right] < target)
				left++;
			else
				return true;
		}

		return false;
	}

}
