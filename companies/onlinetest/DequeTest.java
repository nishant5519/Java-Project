package com.companies.onlinetest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DequeTest {

	public static void main(String[] args) {
		Deque<Integer> dq = new LinkedList<>();
		Scanner scan = new Scanner(System.in);
		int arrSize = scan.nextInt();
		int index = 0;
		int k = scan.nextInt();
		int[] arr = new int[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = scan.nextInt();
			if (arr[i] == k)
				index = i;
		}

		for (int j = 0; j < arrSize; j++) {
			 if (j >= index)
				dq.addFirst(arr[j]);
			else {
				dq.addLast(arr[j]);
			}
		}

		for (int p = 0; p < arrSize; p++) {
			if (p > index)
				arr[p] = dq.removeFirst();
			else
				arr[p] = dq.removeLast();
		}
		for (int p = 0; p < arrSize; p++) {
			System.out.print(arr[p] + " ");
		}
		scan.close();
	}

}
