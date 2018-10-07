package com.practice;

import java.util.Scanner;



class HelloWorldResource {

}
public class MyTest {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("$ ");
			}
			System.out.println();
		}

		Scanner scanner = new Scanner(System.in);
		String myString = scanner.next();
		int myInt = scanner.nextInt();
		scanner.close();
		char arr[] = { 'G', 'L', 'G', 'L'};
		int ar[] = {2, 3, 5, 4, 5, 3, 4,3};
		int[][] names = { {3, 4}, {7, 5}, {9, 8}, };
		int key=4;

		System.out.println("myString is: " + myString);
		System.out.println("myInt is: " + myInt);
		// System.out.println("Divisble by four or not :" +
		// isPowerOfFour(myInt));
		System.out.println(0 / 10);
		System.out.println(1 % 4);
		System.out.println("rows: " + names.length);
		System.out.println("cols: " + names[0].length);
		int rows = names.length;
		  int cols = names[0].length;
		  for(int i=0;i< rows;i++){
		   for(int j=0;j< cols;j++){
		    		if(key==names[i][j]) 
		              System.out.println(i + " , " + j);
		     	
		   }
		    
		  } 
		          System.out.println("-1");
		int res = ar[0];
	     for (int i=1; i < ar.length; i++)
	        res = res ^ ar[i];
	     
	     System.out.println("non repeated number: " + res);
		
		char c;
		for (int i = 0; i < (arr.length-1); i++) {
			for (int k = 0; k < (arr.length-1); k++) {
				if (arr[k] == 'G' && arr[k + 1] == 'L') {
					c = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = c;
				}
			}          
		}
  
    System.out.print(arr);

		/*int n = arr.length;
		char temp;
		for (int i = 0; i < n-1; i++) {
			for (int k = 0; k < n-1; k++) {
				if (arr[k] == 'G' && arr[k + 1] == 'L') {
					temp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = temp;
				}
			}
		}
		System.out.print(arr);*/

		/*int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < (arr.length - 1); i++) {
			if (arr[i] < arr[i + 1]) {
				temp1 = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp1;
			}

		}
		System.out.print(arr[arr.length - 1]);
		for (int i = 0; i < (arr.length - 1); i++) {
			if (arr[i] > arr[i + 1]) {
				temp2 = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp2;
			}

		}
		System.out.print(" " + arr[arr.length - 1]);*/
	}

	static boolean isPowerOfFour(int n) {
		boolean b = false;

		if (n % 4 == 0) {
			while (!(n == 1) && !(n == 0))
				n = n / 4;
			if (n == 1)
				b = true;
		}

		return b;
	}

}
