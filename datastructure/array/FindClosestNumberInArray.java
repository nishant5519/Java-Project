package com.datastructure.array;

public class FindClosestNumberInArray {

	public static void main(String[] args) {
		int arr[] = {2, 5, 6, 7, 8, 8, 9};
		int targetNumber = 4;
		int index=0;
		int minDiff=Integer.MAX_VALUE;
		
		for(int i=0; i < arr.length; i++){
			if(Math.abs(targetNumber-arr[i]) < minDiff){
				minDiff=Math.abs(targetNumber-arr[i]);
				index=i;
			}
			
		}
		System.out.println(arr[index]);
	}

}
