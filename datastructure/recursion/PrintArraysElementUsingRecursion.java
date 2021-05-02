package recursion;

public class PrintArraysElementUsingRecursion {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		print(arr, 8);
	}

	private static void print(int[] arr, int len) {

		if (len == 0)
			return;

		System.out.println(arr[arr.length - len]);
		print(arr, len - 1);
	}

}
