package recursion;

public class FindPathSum {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int pathsum = 25;
		boolean result = hasSumPath(arr, pathsum);
		System.out.println(result);
	}

	static boolean hasSumPath(int array[][], int sum) {

		return hasSumPathHelper(array, sum, 0, 0);
	}

	static boolean hasSumPathHelper(int a[][], int interimsum, int i, int j) {
		// Your Code Here
		int cols = a[0].length;
		int rows = a.length;
		if (i >= rows || j >= cols)
			return false;
		if (i == (rows - 1) && j == (cols - 1))
			return (interimsum == a[i][j]);
		boolean down = hasSumPathHelper(a, interimsum - a[i][j], i + 1, j);
		if (down)
			return true;
		return hasSumPathHelper(a, interimsum - a[i][j], i, j + 1);

	}

}
