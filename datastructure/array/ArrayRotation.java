package com.datastructure.array;

import java.util.Iterator;

//Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
public class ArrayRotation {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5};
		int d=4;
		leftRotate(arr, d);
		//rightRotate(arr, d);
		//leftRotateUsingReversalAlgo(arr,d);
		printArray(arr);
	}
		//Time Complexity: O(n)
	  static void leftRotateUsingReversalAlgo(int[] arr, int d) {
		  int n=arr.length;
		  
		  reverseArray(arr,0,d-1);
		  reverseArray(arr,d,n-1);
		  reverseArray(arr,0,n-1); //To shift the bits right, move this line at first
		  
		  
	}
	  
	  static void reverseArray(int[] a,int start,int end){
		  
		  while(start < end){
			  int temp=a[start];
			  a[start]=a[end];
			  a[end]=temp;
			  start++;
			  end--;
		  }
		  
	  }

	static void rightRotate(int[] arr, int d) {

			int temp;
			int j;
			for (int i = 0; i < d; i++) {
				temp = arr[arr.length-1];
				for (j = (arr.length-2); j >= 0; j--) {
					arr[j+1] = arr[j];
				}
				arr[0] = temp;
			}
		
		 
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+ " ");
	}

	// Time complexity: O(n*d)
	// Auxiliary Space: O(1)
	static void leftRotate(int[] arr, int d) {
		int temp;
		int j;
		for (int i = 0; i < d; i++) {
			temp = arr[0];
			for (j = 0; j < (arr.length - 1); j++) {
				arr[j] = arr[j + 1];
			}
			arr[j] = temp;
		}
	}

}
