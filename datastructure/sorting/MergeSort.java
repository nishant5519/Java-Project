package sorting;

/* Java program for Merge Sort */
class MergeSort {
	// Merges two subarrays of arr[]. | First subarray is arr[l..m] | Second
	// subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r) {
		int[] temp = new int[r - l + 1];
		int i = l;
		int j = m + 1;
		int k = 0;
		while (i <= m && j <= r) {
			if (arr[i] < arr[j])
				temp[k++] = arr[i++]; // same as b[k]=a[i]; k++; i++;
			else
				temp[k++] = arr[j++];
		}

		while (j <= r) {
			temp[k++] = arr[j++];
		}
		while (i <= m) {
			temp[k++] = arr[i++];
		}

		for (i = r; i >= l; i--) {
			arr[i] = temp[--k];
		}
	}

	void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method
	public static void main(String args[]) {
		//int arr[] = { 12, 11, 13, 5, 6, 7 };
		int arr[] = {45};
		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}
