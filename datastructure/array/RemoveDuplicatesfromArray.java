package com.datastructure.array;

public class RemoveDuplicatesfromArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };

		 naiveMethodForDuplicateRemovalFromAnyArray(array);
		int n = removeDuplicatesFromSortedArrayOnlyUsingConstantSpace(array,
				array.length);
		for (int i = 0; i < n; i++)
			System.out.print(array[i] + " ");
	}

	private static void naiveMethodForDuplicateRemovalFromAnyArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					for (int p = j; p < array.length - 1; p++) {
						array[p] = array[p + 1];

					}
				}

			}
		}
	}
	
	//Time Complexity : O(n) 	Auxiliary Space : O(1)

	static int removeDuplicatesFromSortedArrayOnlyUsingConstantSpace(int arr[],
			int n) {
		if (n == 0 || n == 1)
			return n;

		int j = 0;

		for (int i = 0; i < n - 1; i++)
			if (arr[i] != arr[i + 1])
				arr[j++] = arr[i];

		arr[j++] = arr[n - 1];

		return j;
	}

	//Time Complexity : O(n) 	Auxiliary Space : O(n)
	static int removeDuplicatesFromSortedArrayOnlyUsingExtraSpace(int arr[],
			int n) {
		if (n == 0 || n == 1)
			return n;

		int j = 0;
		int[] temp = new int[n];

		for (int i = 0; i < n - 1; i++)
			if (arr[i] != arr[i + 1])
				temp[j++] = arr[i];

		temp[j++] = arr[n - 1];

		return j;
	}

}
