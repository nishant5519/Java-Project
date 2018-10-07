package com.datastructure.recursion;

public class PrintNto1 {

	public static void main(String[] args) {
		int n = 10;
		print(n);

	}

	static void print(int N) {
		if (N <= 0)
			return;
		System.out.println(N);
		print(N - 1);
	}
}
