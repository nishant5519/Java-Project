package array;

public class FindTwoElementsSuchThatTheirSumIsClosestToZero {

	public static void main(String[] args) {
		int[] arr = { 15, 5, -20, 30, -45 };
		findElementMethod2(arr);
	}

	// Time complexity: O(n^2)
	static void findElementMethod1(int[] array) {
		int min = 99999999;// or use array[0]+array[1];
		int elmnt1 = 0, elmnt2 = 0;
		int sum = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				sum = Math.abs(array[i] + array[j]);
				if (min > sum) {
					min = sum;
					elmnt1 = i;
					elmnt2 = j;
				}
			}
		}

		System.out.println(min);
		System.out.println("Two elements are: " + array[elmnt1] + ";" + array[elmnt2]);
	}

	//Time Complexity: complexity to sort + complexity of finding the optimum pair = O(nlogn) + O(n) = O(nlogn)
	static void findElementMethod2(int[] array) {
		int min = 99999999;

		int left = 0, right = array.length - 1;
		int elmnt1 = left, elmnt2 = right;
		int sum = 0;
		
		/* Sort the elements */
		sort(array, left, right); //O(nlogn)  quicksort

		while (left < right) {
			sum = array[left] + array[right];

			if (Math.abs(sum) < Math.abs(min)) {
				min = sum;
				elmnt1 = left;
				elmnt2 = right;
			}
			if (sum < 0)
				left++;
			else
				right--;
		}

		System.out.println(min);
		System.out.println("Two elements are: " + array[elmnt1] + ";" + array[elmnt2]);
	}
	 static int partition(int arr[], int low, int high)
	{
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
 
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}
