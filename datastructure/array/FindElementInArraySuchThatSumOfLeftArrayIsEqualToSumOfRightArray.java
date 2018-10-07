package com.datastructure.array;

public class FindElementInArraySuchThatSumOfLeftArrayIsEqualToSumOfRightArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 6 };
		System.out.println(findElement(arr));

	}
	

	private static int findElement(int[] arr) {
		int size = arr.length;
		int right_sum = 0, left_sum = 0;
		for (int i = 1; i < size; i++) {
			right_sum = right_sum + arr[i];
		}

		for (int i = 0, j = 1; j < size; i++, j++) {
			right_sum = right_sum - arr[j];
			left_sum = left_sum + arr[i];
			if (right_sum == left_sum)
				return arr[j];

		}
		return -1;
	}

}
