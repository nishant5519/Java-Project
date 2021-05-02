package companies.onlinetest;

import java.util.Scanner;

public class Solution_1 {
	private static final int SIZE = 6;
	private static final int OFFSET = 2;
	private static int matrix[][] = new int[SIZE][SIZE];
	private static int maxHourglass = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
		
		scan.close();
		for(int i = 0; i < SIZE-OFFSET; i++){
			for(int j = 0; j < SIZE-OFFSET; j++)
			maxHourGlassCalc(i,j);
		}
		System.out.println(maxHourglass);
	}

	private static void maxHourGlassCalc(int i, int j) {
		int tmpSum=0;
		for(int k=j;k<=j+OFFSET;k++){
			tmpSum=tmpSum+matrix[i][k]+matrix[i+OFFSET][k];
		}
		tmpSum=tmpSum+matrix[i+1][j+1];
		if(maxHourglass < tmpSum)
			maxHourglass=tmpSum;
	}

}
