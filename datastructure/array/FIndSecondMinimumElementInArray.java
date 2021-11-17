package array;

public class FIndSecondMinimumElementInArray {

	public static void main(String[] args) {
		int[] arr = { 10, 7, 6, 4, 5 };
		// int[] arr = {};
		System.out.println(findElement(arr));
		System.out.println(findElement1(arr));

	}

	public static int findElement(int[] arr) {

		if (arr.length < 2)
			return 0;

		int smallest = Integer.MAX_VALUE;
		int secondSmallest = smallest;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < smallest) {
				secondSmallest = smallest;
				smallest = arr[i];
			}
			if (arr[i] < secondSmallest && arr[i] != smallest)
				secondSmallest = arr[i];
		}

		return secondSmallest;
	}
	
	public static int findElement1(int[] arr) {

		if (arr.length < 2)
			return 0;

		int largest = Integer.MIN_VALUE;
		int secondLargest = largest;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			}
			if (arr[i] > secondLargest && arr[i] != largest)
				secondLargest = arr[i];
		}

		return secondLargest;
	}

}
