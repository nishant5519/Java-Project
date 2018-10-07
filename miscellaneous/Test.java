package com.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int input=Integer.parseInt(s);
	//	printNumbers(input);
		char c='1';
		int i=(int)c;
		System.out.println(i);
	//	add(2,5);  ambiguous
	}

	static void printreverseNumber(int n) {
		if (n > 0) {
			System.out.print(n);
			System.out.print(" ");
			printreverseNumber(n - 1);
		}
	}

	static void printNumbers(int n) {
		if (n > 0) {
			printNumbers(n - 1);
			System.out.print(n);
			System.out.print(" ");
		}
	}
	
	static int add(int i,long l){
		return (int)l+i;
	}
	
	static int add(long l,int i){
		return (int)l+i;
	}
}
