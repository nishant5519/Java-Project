package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CountDigits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] count = new int[10];
		for (int i = 0; i < line.length(); i++) {
			 int c=Integer.parseInt(String.valueOf(line.charAt(i)));
			count[c]++;

		}
		for(int i = 0; i < 10; i++){
			System.out.println(i + " " +  count[i]);
		}
		 Scanner s = new Scanner(System.in);
	        int N = s.nextInt();
	        long[] arr=new long[N];
	        for(int i=0;i<N;i++){
	        arr[i]=s.nextInt();
	        if(arr[i]%2 == 0)
	        System.out.println("YES");
	        else
	        System.out.println("NO");
	        }
	}

}
