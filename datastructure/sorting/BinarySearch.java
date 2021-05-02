package sorting;

import java.util.Scanner;

//Should be sorted,Divide and conquer approach,time complexity O(logn)
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		// System.out.println(searchBinary(arr, num));
		System.out.println(searchBinaryRecursive(arr, num, 0, arr.length - 1));
		scan.close();
	}

	static int searchBinary(int[] arr, int num) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
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
		if (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == num)
				return mid;
			if (arr[mid] > num) {
				end = mid - 1;
				return searchBinaryRecursive(arr, num, start, end);
			}

			else {
				start = mid + 1;
				return searchBinaryRecursive(arr, num, start, end);
			}
		}
		return -1;
	}

}
