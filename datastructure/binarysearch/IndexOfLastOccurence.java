package binarysearch;

public class IndexOfLastOccurence {

	public static void main(String[] args) {
		int arr[] = { 5, 10, 10, 15, 20, 20, 20 }, n = 7;

		int x = 20;

		System.out.println(lastOcc(arr, 0, n - 1, x));
		System.out.println(lastOcc(arr, n, x));
		System.out.println(lastOcc2(arr, n, x));

	}

	// recursive sol
	static int lastOcc(int arr[], int low, int high, int x) {

		if (low > high)
			return -1;

		int mid = low + (high - low) / 2;

		if (x > arr[mid])
			return lastOcc(arr, mid + 1, high, x);

		else if (x < arr[mid])
			return lastOcc(arr, low, mid - 1, x);

		// in case of equal , two subcases
		else {
			if (mid == arr.length - 1 || arr[mid + 1] != arr[mid])
				return mid;

			else
				return lastOcc(arr, mid + 1, high, x);
		}
	}

	// iterative sol-1
	static int lastOcc(int arr[], int n, int x) {
		int low = 0, high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (x > arr[mid])
				low = mid + 1;

			else if (x < arr[mid])
				high = mid - 1;

			else {
				if (mid == n - 1 || arr[mid + 1] != arr[mid])
					return mid;

				else
					low = mid + 1;
			}

		}

		return -1;
	}

	// iterative sol-2
	static int lastOcc2(int arr[], int n, int x) {
		int low = 0, high = n - 1;
		int index = -1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (x > arr[mid])
				low = mid + 1;
			else if (x < arr[mid])
				high = mid - 1;

			else {
				index = mid;
				low = mid + 1;
			}

		}

		return index;
	}

}
