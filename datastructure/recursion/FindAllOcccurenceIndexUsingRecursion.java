package recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAllOcccurenceIndexUsingRecursion {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 3, 4, 9, 5, 6, 2, 8 };
		List<Integer> indexes = new ArrayList<>();
		findIndexes(arr, 0, 2, indexes);
		System.out.println(indexes);

		int[] result = findIndexes(arr, 0, 2, 0);
		for (int i : result)
			System.out.print(i + " ");
	}

	static void findIndexes(int[] arr, int index, int data, List<Integer> indexes) {

		if (index == arr.length)
			return;

		findIndexes(arr, index + 1, data, indexes);

		if (arr[index] == data) {
			indexes.add(index);
		}

	}

	static int[] findIndexes(int[] arr, int index, int data, int fsf) {

		if (index == arr.length)
			return new int[fsf];

		if (arr[index] == data) {
			int[] temp1 = findIndexes(arr, index + 1, data, fsf + 1);
			temp1[fsf] = index;
			return temp1;
		} else {
			int[] temp2 = findIndexes(arr, index + 1, data, fsf);
			return temp2;
		}

	}

}
