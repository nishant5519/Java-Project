package recursion;

public class DisplayAllArrayElementUsingRecursion {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		display(arr,0);
		
	}
	
	public static void display(int[] arr, int index) {

		if (index > arr.length - 1)
			return;
		System.out.println(arr[index]);
		display(arr, index + 1);
	}

	public static void displayInReverse(int[] arr, int index) {

		if (index > arr.length - 1)
			return;
		display(arr, index + 1);
		System.out.println(arr[index]);
		
	}

}
