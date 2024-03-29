package binarysearch;

public class SearchAnElementInASortedAndRotatedArray {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = arr.length;
		int key = 6;
		int i = search(arr, 0, n - 1, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
		
		int array[] = {3,1};
		int target = 1;
		System.out.println(search(array,target));
	}

	static int search(int arr[], int l, int h, int key) {
		if (l > h)
			return -1;

		int mid = (l + h) / 2;
		if (arr[mid] == key)
			return mid;

		/* If arr[l...mid] is sorted */
		if (arr[l] <= arr[mid]) {
			/*
			 * As this subarray is sorted, we can quickly check if key lies in half or other
			 * half
			 */
			if (key >= arr[l] && key <= arr[mid])
				return search(arr, l, mid - 1, key);

			return search(arr, mid + 1, h, key);
		}

		/*
		 * If arr[l..mid] is not sorted, then arr[mid... r] must be sorted
		 */
		if (key >= arr[mid] && key <= arr[h])
			return search(arr, mid + 1, h, key);

		return search(arr, l, mid - 1, key);
	}

	public static int search(int[] arr, int target) {

		if (arr.length == 0 || arr == null)
			return -1;

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (end + start) / 2;
			if (target == arr[mid])
				return mid;

			// left array is sorted
			if (arr[start] <= arr[mid]) {
				if (target < arr[mid] && target >= arr[start])
					end = mid - 1;
				else
					start = mid + 1;
			}

			// right array is sorted
			else {
				if (target > arr[mid] && target <= arr[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;

	}
}
