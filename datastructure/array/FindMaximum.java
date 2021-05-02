package array;

/*Time Complexity: O(n) 
Auxiliary Space: O(n)  */
class FindMaximum {
	int max(int x, int y) {
		return x > y ? x : y;
	}

	int min(int x, int y) {
		return x < y ? x : y;
	}

	int maxIndexDiff(int arr[], int n) {
		int maxDiff;
		int i, j;

		int RMax[] = new int[n];
		int LMin[] = new int[n];
//{ 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
//LMin[i] holds the smallest element on left side of arr[i] including arr[i]
		LMin[0] = arr[0];
		System.out.print(LMin[0] + " ");
		for (i = 1; i < n; ++i) {
			LMin[i] = min(arr[i], LMin[i - 1]);
			System.out.print(LMin[i] + " ");
		}

		System.out.println("===========");
		//RMax[j] holds the greatest element on right side of arr[j] including arr[j]
		RMax[n - 1] = arr[n - 1];
		System.out.print(RMax[n-1] + " ");
		for (j = n - 2; j >= 0; --j) {
			RMax[j] = max(arr[j], RMax[j + 1]);
			System.out.print(RMax[j] + " ");
		}
		System.out.println();
		System.out.println("===========");
		/*
		 * Traverse both arrays from left to right to find optimum j - i This process is
		 * similar to merge() of MergeSort
		 */
		i = 0;
		j = 0;
		maxDiff = -1;
		while (j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return maxDiff;
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		FindMaximum max = new FindMaximum();
		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		int n = arr.length;
		int maxDiff = max.maxIndexDiff(arr, n);
		System.out.println(maxDiff);
	}
}
