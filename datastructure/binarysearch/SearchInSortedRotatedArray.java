package binarysearch;

public class SearchInSortedRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 1 };
		int target = 1;
		System.out.println(search(arr, target));
	}

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (high >= low) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target)
				return mid;

			else if (nums[low] <= nums[mid]) {
				if (target >= nums[low] && target < nums[mid])
					high = mid - 1;
				else
					low = mid + 1;
			} else {
				if (target > nums[mid] && target <= nums[high])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}

		return -1;
	}

}
