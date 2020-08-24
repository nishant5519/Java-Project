package com.datastructure.array;

import java.util.Arrays;

public class PrintMatrixFromCenterClockwise {

	public static void main(String[] args) {
		print2D(formMatrix(3));
	}

	static int[][] formMatrix(int num) {
		int[][] matrix = new int[num][num];

		int bottom = matrix.length;
		int right = matrix[0].length;
		int top = 0;
		int left = 0;
		int counter = num * num;

		while (top < bottom && left < right) {
			for (int i = left; i < right; i++) {
				matrix[top][i] = counter;
				counter--;
			}
			top++;

			for (int j = top; j < bottom; j++) {
				matrix[j][right - 1] = counter;
				counter--;
			}
			right--;

			if (top < bottom) {
				for (int i = right - 1; i >= left; i--) {
					matrix[bottom - 1][i] = counter;
					counter--;
				}
				bottom--;
			}
			if (left < right) {
				for (int i = bottom - 1; i >= top; i--) {
					matrix[i][left] = counter;
					counter--;
				}
				left++;
			}
		}
		return matrix;

	}

	public static void print2D(int mat[][]) {
		for (int[] row : mat)
			System.out.println(Arrays.toString(row));
	}

}
