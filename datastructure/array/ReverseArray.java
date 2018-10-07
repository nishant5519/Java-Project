package com.datastructure.array;

public class ReverseArray {
	/* Function to reverse arr[] from start to end Iterative way Time Complexity: O(n)*/
	static void reverseArray(int arr[], int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	/* Function to reverse arr[] from start to end recursively Time Complexity: O(n)*/
    static void reveresArrayRecursive(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reveresArrayRecursive(arr, start+1, end-1);
    }

	/* Utility that prints out an array on a line */
	static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7};
		int size = arr.length;
		printArray(arr, size);
		reverseArray(arr, 0, size - 1);
		System.out.println("Reversed array is ");
		printArray(arr, size);
	}

}
