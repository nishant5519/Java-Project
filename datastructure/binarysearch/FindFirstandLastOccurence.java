package binarysearch;

class FindFirstandLastOccurence {

	public static void main(String[] args) {
		int arr[] = { 5, 10, 10, 15, 30, 40, 50 };

		int x = 50;

		System.out.println(searchRange(arr, x));

	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		int left = search(nums, nums.length, target, 1);
		int right = search(nums, nums.length, target, -1);
		result[0] = left;
		result[1] = right;
		System.out.println(result[0]);
		System.out.println(result[1]);
		return result;
	}

	private static int search(int[] arr, int n, int x, int toggle) {

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
				if (toggle == 1)
					high = mid - 1;
				else
					low = mid + 1;
			}

		}

		return index;

	}
}