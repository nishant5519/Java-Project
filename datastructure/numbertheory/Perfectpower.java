package com.datastructure.numbertheory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Perfectpower {
	// A perfect power is a number that can be expressed as power of another
	// positive integer.
	// Given a number n, find count of numbers from 1 to n that are of type xy
	// where x >= 1 and y > 1

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println(powerNumbers(num));
	}

	private static int findCount(int num) {
		int count = 0;
		for (int j = 2; j <= num; j++) {
			for (int i = 2; i <= num; i++) {
				int temp = j;
				while (temp % i == 0) {
					temp = temp / i;
					if (temp == 1) {
						count++;
						i = num + 1;
					}
				}
			}
		}
		return count;
	}

	static int powerNumbers(int n) {
		// v is going to store all unique
		// power numbers
		Map<Integer, Integer> v = new HashMap<Integer, Integer>();
		v.put(1, 1);

		// Traverse through all base numbers
		// and compute all their powers
		// smaller than or equal to n.
		for (int i = 2; i * i <= n; i++) {
			int j = i * i;
			v.put(j, 2);
			int count = 3;
			while (j * i <= n) {
				v.put(j * i, count);
				count++;
				j = j * i;
			}
		}
		System.out.println(v);
		return v.size();
	}

}
