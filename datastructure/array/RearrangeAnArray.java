package array;

public class RearrangeAnArray {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 0, 2 };
		rearrangeNaive(arr);
		rearrangeTricky(arr);
		printArray(arr,arr.length);
	}

	 static void rearrangeTricky(int[] arr) {
		 int i=0,temp=0;
		 
		 while(true){
			 temp=arr[i];
			 int temp1=arr[temp];
		 }
	}

	static void printArray(int arr[], int n) {
		int i;
		for (i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
	}

	static void rearrangeNaive(int arr[]) {
		int len = arr.length;
		int[] temp = new int[len];
		for (int i = 0; i < len; i++)
			temp[arr[i]] = i;
		for (int i = 0; i < len; i++)
            arr[i] = temp[i];
	}
}
