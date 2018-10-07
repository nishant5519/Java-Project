package com.datastructure.array;

public class Segregate0sAnd1sInAnArray {
	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 0, 1, 1, 1, 0};
	//	segregate1(arr);
		segregate2(arr);
		print(arr);
	}

		//Time Complexity: O(n)
	static void segregate2(int[] arr) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			while (arr[left] == 0 && left < right)
				left++;

			while (arr[right] == 1 && left < right)
				right--;

			if (left < right) {
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
	}

	//Time Complexity : O(n)
	static void segregate1(int[] arr) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				count++;
		}
		for (int i = 0; i < count; i++) {
			arr[i] = 0;
		}
		for (int i = count; i < n; i++) {
			arr[i] = 1;
		}
	}

	static void print(int arr[]) {
		System.out.print("Array after segregation is ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
