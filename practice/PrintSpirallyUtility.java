package practice;

public class PrintSpirallyUtility {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printSpirally(arr);
   String a="abc";
   char b='A';
   char c='B';
   System.out.println(a);
   System.out.println(b+c);
	}

	private static void printSpirally(int[][] arr) {
		int endRow = arr.length;
		int endCol = arr[0].length;
		int startRow = 0;
		int startCol = 0;

		while (startRow < endRow && startCol < endCol) {
			for (int i = startCol; i < endCol; i++)
				System.out.print(arr[startRow][i] + ",");
			startRow++;

			for (int j = startRow; j < endRow; j++)
				System.out.print(arr[j][endCol - 1] + ",");
			endCol--;

			if (startRow < endRow) {
				for (int i = endCol - 1; i >= startCol; i--)
					System.out.print(arr[endRow-1][i] + ",");
				endRow--;
			}
			if (startCol < endCol) {
				for (int i = endRow - 1; i >= startRow; i--)
					System.out.print(arr[i][startCol] + ",");
				startCol++;
			}

		}

	}

}
