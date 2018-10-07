package com.datastructure.array;
//does not find starting and end index.
public class ContiguousSum {

	public static void main(String[] args) {
		int arr[] = { -1, 2, 3, 6 };
		int max = arr[0];
		int sum = 0;
		int i;
		for (i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum <= max) {
				if (sum < 0)
					sum = 0;
			} else {
				max = sum;
			}
		}
		//System.out.println("Start index :" + start + "," + "End Index :" + end);
		System.out.println("Largest Sum Contiguous Subarray : " + max);
	}

}
