package com.datastructure.array;

import java.util.Arrays;

//First sort the input array, then swap all adjacent elements.
public class SortArrayInWaveForm {

	public static void main(String[] args) {
		int arr[] = { 10, 90, 49, 2, 1, 5, 23 };
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
			i++;
		}

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "   ");
	}

}
