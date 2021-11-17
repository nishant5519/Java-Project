package recursion;

public class FindLastOcccurenceUsingRecursion {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 3, 4, 9, 5, 6 };
		System.out.println(findIndex(arr, 0, 1));
	}

	static int findIndex(int[] arr, int index, int data) {

		if (index == arr.length)
			return -1;

		int result = findIndex(arr, index + 1, data);

		if (result == -1 && arr[index] == data)
			return index;
		else if (result == -1 && arr[index] != data) {
			return -1;
		}
		return result;
	}

}
