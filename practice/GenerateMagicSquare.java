package com.practice;

import java.util.Scanner;

public class GenerateMagicSquare {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
	//	printMagicSq1(n);
		printMagicSq2(n);
	}

	private static void printMagicSq1(int n) {
		int magicsqr[][] = new int[n][n];

		int j = n / 2;
		int i = 0;
		for (int num = 1; num <= n * n; num++) {
			if (i == -1 && j == n) {
				i = 0;
				j = n - 2;
			} else if (i == -1)
				i = n - 1;
			else if (j == n)
				j = 0;

			if (magicsqr[i][j] != 0) {
				i = i + 1;
				j = j - 2;
			}

			if ((i >= 0 && i < n) || (j >= 0 && j < n))
				magicsqr[i][j] = num;

			i--;
			j++;
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				System.out.print(magicsqr[row][col]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}

	private static void printMagicSq2(int n) {
		int magicsqr[][] = new int[n][n];
		int i = 0;
		int j = n / 2;
		int newI, newJ;
		int num = 1;
		magicsqr[i][j] = num++;
		while (num <= n * n) {
			newI = (i - 1 + n) % n;
			newJ = (j + 1) % n;
			if (magicsqr[newI][newJ] != 0) {
				newI = (i + 1) % n;
				newJ = j;
			}
			magicsqr[newI][newJ] = num++;
			i = newI;
			j = newJ;

		}
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				System.out.print(magicsqr[row][col]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}