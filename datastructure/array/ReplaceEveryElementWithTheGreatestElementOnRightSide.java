package array;

public class ReplaceEveryElementWithTheGreatestElementOnRightSide {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 7, 1, 2, 3 };
		nextMax(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	// Time Complexity: O(n*n)
	static void replace(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int max = -1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > max)
					max = arr[j];
			}
			arr[i] = max;
		}
	}

	// Time Complexity: O(n)
	static void nextMax(int arr[]) {
		int i, max, temp;
		max = arr[arr.length - 1];
		arr[arr.length - 1] = -1;
		temp = max;
		for (i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > max)
				temp = arr[i];
			arr[i] = max;
			max = temp;
		}
	}

}
