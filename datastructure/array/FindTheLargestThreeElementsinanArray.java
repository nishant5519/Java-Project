package com.datastructure.array;

class FindTheLargestThreeElementsinanArray {
//	Time complexity is O(n) and extra space is O(1).
	static void print2largest(int arr[], int arr_size) {
		int i, first, second, third;

		/* There should be atleast two elements */
		if (arr_size < 3) {
			System.out.print(" Invalid Input ");
			return;
		}

		third = first = second = Integer.MIN_VALUE;
		for (i = 0; i < arr_size; i++) {			
			if (arr[i] > first) {
				third = second;
				second = first;
				first = arr[i];
			}

			else if (arr[i] > second) {
				third = second;
				second = arr[i];
			}

			else if (arr[i] > third)
				third = arr[i];
		}

		System.out.println("Three largest elements are " + first + " " + second + " " + third);
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = { 12, 13, 1, 10, 34, 1 };
		int n = arr.length;
		print2largest(arr, n);
	}
}