package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class UnionAndIntersectionOfTwoUnsortedArrays {

	public static void main(String[] args) {
		int arr1[] = { 7, 10};
		int arr2[] = { 3, 8, 6, 20, 7 };

		print(arr1, arr2);

	}

	static void print(int[] arr1, int[] arr2) {
		TreeSet<Integer> hsUnion = new TreeSet<Integer>();
		TreeSet<Integer> hsIntersection = new TreeSet<Integer>();
		for (int i = 0; i < arr1.length; i++)
			hsUnion.add(arr1[i]);
		for (int i = 0; i < arr2.length; i++) {
			if (hsUnion.contains(arr2[i]))
				hsIntersection.add(arr2[i]);
			else
				hsUnion.add(arr2[i]);

		}
		System.out.println("Union of two arrays is : " + hsUnion);
		System.out.println("Intersection of two arrays is : " + hsIntersection);
	}

}
