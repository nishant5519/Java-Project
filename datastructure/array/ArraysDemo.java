package array;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] arr1={1,2,3,4,5};
		printArray(arr1);
		
		int[] arr2=new int[5];
		arr2[0]=10;
		arr2[1]=11;
		arr2[2]=12;
		arr2[3]=13;
		arr2[4]=14;
		printArray(arr2);
		
		int[] arr3=Arrays.copyOf(arr1, 10);
		printArray(arr3);
		

	}
	
	private static void printArray(int[] a){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

}
