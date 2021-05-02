package array;

/*You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in list. One of the integers is missing in the list. Write an 
 * efficient code to find the missing integer.
 */
public class FindMissingNumber {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 5, 4, 6, 8, 9 };
		int missednumber = findmissingnumber(a);
		System.out.println("Missing number is: " + missednumber);
		System.out.println("Second way to find missing number : "
				+ getMissingNo(a));

	}

	// METHOD 1(Use sum formula):Time Complexity: O(n)
	static int findmissingnumber(int[] a) {
		int arraysum = 0;
		int n = a.length;
		int sum = (n + 1) * (n + 2) / 2;
		for (int i = 0; i < n; i++)
			arraysum = arraysum + a[i];

		return (sum - arraysum);
	}

	/*
	 * METHOD 2(Use XOR) Time Complexity: O(n)
	 * 
	 * 1) XOR all the array elements, let the result of XOR be X1. 2) XOR all
	 * numbers from 1 to n, let XOR be X2. 3) XOR of X1 and X2 gives the missing
	 * number.
	 */ 
	static int getMissingNo(int arr[]) {
		int n = arr.length;
		int i;
		int X1 = arr[0];
		int X2 = 1;

		/*
		 * For XOR of all the elements in array
		 */
		for (i = 1; i < n; i++)
			X1 = X1 ^ arr[i];

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (i = 2; i <= n + 1; i++)
			X2 = X2 ^ i;

		return (X1 ^ X2);
	}
}
