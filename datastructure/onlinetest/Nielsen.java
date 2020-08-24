package com.onlinetest;

import java.util.Arrays;
/*
Programming challenge description:
The example sequence 011212201220200112 ... is constructed as follows:
1. The first element in the sequence is 0.
2. For each iteration, repeat the following action: take a copy of the entire current sequence, replace 0 with 1, 1 with 2, and 2 with 0, and place it at the end of the current sequence. E.g.
0 -> 01 -> 0112 -> 01121220 -> ...
Create an algorithm which determines what number is at the Nth position in the sequence (using 0-based indexing).
Input:
Your program should read lines from standard input. Each line contains an integer N such that 0 <= N <= 3000000000.
Output:
Print out the number which is at the Nth position in the sequence.
Test 1
Test Input
Download Test 1 Input
5
Expected Output
Download Test 1 Input
2
Test 2
Test Input
Download Test 2 Input
25684
Expected Output
Download Test 2 Input
0
*/

public class Nielsen {

	public static void main(String[] args) {
		String[] str= new String[5];
		str[0]="4";
		str[1]="2";
		str[2]="8";
		str[3]="1";
		str[4]="2";
		Arrays.sort(str);
		System.out.println(str[4]);
		mergeArrays("5,7,2,4;8,1");
	}

	private static void mergeArrays(String str) {
		String s1 = str.replace(';', ',');

		String[] strArr = s1.split(",");
		
		// Current indexes from left and right
		int l = 0, r = strArr.length - 1;

		// Count of odd numbers
		int k = 0;

		while (l < r) {
			while (Integer.parseInt(strArr[l]) % 2 != 0) {
				l++;
				k++;
			}

			while (Integer.parseInt(strArr[r]) % 2 == 0 && l < r)
				r--;

			if (l < r) {
				String temp = strArr[l];
				strArr[l] = strArr[r];
				strArr[r] = temp;
			}

		}
		
		System.out.println(k);
		for(int i=0;i<strArr.length;i++)
			System.out.print(strArr[i] + " ");
		
	}
}