package com.datastructure.array;

public class PrintMatrixSpirally {

	public static void main(String[] args) throws InterruptedException {
		int arr[][] = { { 1, 2, 3, 11 }, { 4, 5, 6, 12 }, { 7, 8, 9, 13 } };
		printSpirally(arr);
	}

	static void printSpirally(int arr[][]) throws InterruptedException {
		// there must be comma between two elements.
		// after printing all elements, print a newline char as well.
		int endRow = arr.length;
		int endCol = arr[0].length;
		int startRow = 0;
		int startCol = 0;

		while (startRow < endRow && startCol < endCol) {
			for (int i = startCol; i < endCol; i++)
				System.out.print(arr[startRow][i] + " ,");
			startRow++;

			for (int j = startRow; j < endRow; j++)
				System.out.print(arr[j][endCol - 1] + " ,");
			endCol--;

			if (startRow < endRow) {
				for (int i = endCol - 1; i >= startCol; i--)
					System.out.print(arr[endRow - 1][i] + " ,");
				endRow--;
			}
			if (startCol < endCol) {
				for (int i = endRow - 1; i >= startRow; i--)
					System.out.print(arr[i][startCol] + " ,");
				startCol++;
			}
		}

	}

}