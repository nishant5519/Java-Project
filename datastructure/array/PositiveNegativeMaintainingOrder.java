package com.datastructure.array;

public class PositiveNegativeMaintainingOrder {
//Time complexity of above solution is O(n*n) and auxiliary space is O(1)
	public static void main(String[] args) {
		int[] arr = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
		int l = arr.length;
		int temp = 0;
		for (int i = 0; i < l; i++) {
			if (arr[i] > 0) {
				temp = arr[i];
				int j = i;
				while (j-1 >= 0 && arr[j - 1] < 0) {
					arr[j] = arr[j - 1];
					j--;
				}
				arr[j] = temp;
			}
		}
		for (int i = 0; i < l; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
		
	}

}
