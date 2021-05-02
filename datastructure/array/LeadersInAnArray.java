package array;

public class LeadersInAnArray {

	/**
	 * An element is leader if it is greater than all the elements to its right
	 * side. And the rightmost element is always a leader. For example in the
	 * array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2. Time Complexity:
	 * O(n)
	 */
	public static void main(String[] args) {
		int[] arr = { 16, 17, 4, 3, 5, 2 };
		int len = arr.length;
		printLeaders(arr, len);

	}

	static void printLeaders(int[] arr, int len) {
		int max = arr[len - 1];
		System.out.print(max + " ");
		for (int i = len - 1; i > 0; i--) {
			if (max < arr[i]) {
				max = arr[i];
				System.out.print(arr[i] + " ");
			}
		}
	}

}
