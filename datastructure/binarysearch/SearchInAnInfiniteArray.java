package binarysearch;

public class SearchInAnInfiniteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {};
		int target = 9;
		System.out.println(search(arr , 9));
	}

	private static int search(int[] arr, int target) {

		if (arr[0] == target)
			return 0;
		int index = 1;
		while (arr[index] < target) 
			index = 2 * index;
		
		if(arr[index] == target)
			return index;
		
		return binarySearch(arr, target, index / 2 + 1, index-1);
	}

	private static int binarySearch(int[] arr, int target, int low, int high) {
		int start = low;
		int end = high;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (target == arr[mid])
				return mid;
			if (target > arr[mid])
				start = mid + 1;
			else
				end = mid - 1;

		}

		return -1;
	}

}
