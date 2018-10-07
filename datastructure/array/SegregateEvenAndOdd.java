package com.datastructure.array;

public class SegregateEvenAndOdd {

	public static void main(String[] args) {
		int[] arr = { 12, 34, 45, 9, 8, 90, 3 };
		segregatefunction(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}
//Time Complexity: O(n); Same cab be used to segregate 0s and 1s
	static void segregatefunction(int[] a) {
		int front = 0;
		int rear = a.length - 1;
		while (front < rear) {
			while (a[front] % 2 == 0 && front < rear)
				front++;
			while (a[rear] % 2 == 1 && front < rear)
				rear--;
			if (front < rear) {
				int temp = a[front];
				a[front] = a[rear];
				a[rear] = temp;
				front++;
				rear--;
			}

		}
	}

	/*static void swap(int[] array, int front, int rear) {
		int temp = array[front];
		array[front] = array[rear];
		array[rear] = temp;

	}
*/
}
