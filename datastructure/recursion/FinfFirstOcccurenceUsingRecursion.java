package recursion;

public class FinfFirstOcccurenceUsingRecursion {

	public static void main(String[] args) {
		int[] arr = {1 , 1 , 2 , 3 ,4 ,5 ,8};
		System.out.println(findIndex1(arr,0,1));
		System.out.println(findIndex2(arr,0,1));
	}

	// Worst because we are going at end of array unnecessarily.This approach more suitable to find last index
	static int findIndex1(int[] arr, int index, int data) {

		if (index == arr.length)
			return -1;

		int result = findIndex1(arr, index + 1, data);

		if (arr[index] == data)
			return index;
		else
			return result;

	}

	// Better than first approach. 
	static int findIndex2(int[] arr, int index, int data) {
		if (index == arr.length)
			return -1;

		if (arr[index] == data)
			return index;
		else {
			int result = findIndex1(arr, index + 1, data);
			return result;
		}

	}

}
