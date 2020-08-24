package com.datastructure.sorting;

/*Although the worst case time complexity of QuickSort is O(n2) 
 * which is more than many other sorting algorithms like Merge Sort and Heap Sort, QuickSort is 
 * faster in practice, because its inner loop can be efficiently implemented on most architectures, and in most 
 * real-world data. QuickSort can be implemented in different ways by changing the choice of pivot, so that the worst 
 * case rarely occurs for a given type of data. However, merge sort is generally considered better when data is huge 
 * and stored in external storage.
 */
public class QuickSort {

	public static void main(String[] args) {
		//int arr[] = { 10, 7, 8, 9, 1, 5 };
		//int arr[] = {  14, 5, 1, 2, 15, 6, 16, 4, 9, 8, 7 };
		int arr[] = {  10, 16, 8, 12, 15, 6, 3, 9, 5};
		int n = arr.length;

		QuickSort ob = new QuickSort();
		ob.sort(arr, 0, n - 1);

		System.out.println("sorted array");
		printArray(arr);

	}

	void sort(int arr[], int low, int high) {
		if (low < high) {
			
			// pi is partitioning index, arr[pi] is now at right place
			 //int pi = partitionWhenRightElementIsPivot(arr, low, high); 
			
			 int pi = partitionWhenLeftElementIsPivot(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	//basically to find sorted index of pivot
	int partitionWhenLeftElementIsPivot(int arr[], int low, int high) {

		int left, right, pivot_element = arr[low];
		left = low;
		right = high;

		while (left < right) {
			while (arr[left] <= pivot_element && left < high)
				left++; //if element less than pivot move ahead
			while (arr[right] > pivot_element && right >= left)
				right--; //if element greater than pivot move ahead
			if (left < right)
				swap(arr, left, right);

		}

		arr[low] = arr[right];
		arr[right] = pivot_element;

		return right;
	}

	private void swap(int[] a, int left, int rigth) {
		int temp = 0;
		temp = a[left];
		a[left] = a[rigth];
		a[rigth] = temp;
	}

	int partitionWhenRightElementIsPivot(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
