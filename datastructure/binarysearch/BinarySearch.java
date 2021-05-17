package binarysearch;

import java.util.Scanner;

//Should be sorted,time complexity O(logn)
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println(searchBinary(arr, num));
		// System.out.println(searchBinaryRecursive(arr, num, 0, arr.length -
		// 1));
		scan.close();
	}

	static int searchBinary(int[] arr, int num) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (num == arr[mid])
				return mid;
			if (num > arr[mid])
				start = mid + 1;
			else
				end = mid - 1;

		}

		return -1;
	}

	static int searchBinaryRecursive(int[] arr, int num, int start, int end) {

		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		if (arr[mid] == num)
			return mid;
		if (arr[mid] > num)
			return searchBinaryRecursive(arr, num, start, mid - 1);
		else
			return searchBinaryRecursive(arr, num, mid + 1, end);
	}

	public static int findFirstOccurrence(int[] a, int start, int end, int key) {

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (a[mid] >= key) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return (a[start] == key) ? start : -1;
	}
}
