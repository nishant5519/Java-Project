package array;

public class PrintMatrixSpirally {

	public static void main(String[] args) throws InterruptedException {
		int arr[][] = { { 1, 2, 3, 11 }, { 4, 5, 6, 12 }, { 7, 8, 9, 13 } };
		printSpirally(arr);
	}

	static void printSpirally(int arr[][]) throws InterruptedException {
		// there must be comma between two elements.
		// after printing all elements, print a newline char as well.
		int top = 0;
		int bottom = arr.length; //row
		
		int left = 0;
		int right = arr[0].length; //col
		
		

		while (top < bottom && left < right) {
			for (int i = left; i < right; i++)
				System.out.print(arr[top][i] + " ,");
			top++;

			for (int j = top; j < bottom; j++)
				System.out.print(arr[j][right - 1] + " ,");
			right--;

			if (top < bottom) {
				for (int i = right - 1; i >= left; i--)
					System.out.print(arr[bottom - 1][i] + " ,");
				bottom--;
			}
			if (left < right) {
				for (int i = bottom - 1; i >= top; i--)
					System.out.print(arr[i][left] + " ,");
				left++;
			}
		}

	}

}