package recursion;

public class FindWordInMatrix {
	public static void main(String[] args) {
		char[][] arr = { { 'A', 'B', 'C', 'D', 'E' },
				{ 'J', 'K', 'S', 'T', 'F' }, { 'M', 'I', 'T', 'P', 'G' },
				{ 'O', 'S', 'S', 'Q', 'H' }, { 'T', 'O', 'P', 'D', 'I' } };

		char[] word = { 'A', 'J', 'K', 'I','T','S'};

		System.out.println("Is KISS word present in Matrix: "
				+ hasWord1(arr, word));
		hasWord(arr, 5, 5, word);

	}

	static boolean hasWord1(char grid[][], char word[]) { // Your Code Here

		int w = word.length;

		boolean result = hasWordHelper1(grid, word, 0, 0, 0);

		return result;

	}

	static boolean hasWordHelper1(char grid[][], char[] word, int x, int y,
			int k) {
		int rows = grid.length;
		int cols = grid[0].length;
		boolean result = false;

		if (grid[x][y] == word[k] && k == word.length - 1)
			return true;

		if (grid[x][y] != word[k] && k > 0)
			return false;

		for (int i = x; i < rows - 1; i++) {
			for (int j = y; j < cols - 1; j++) {
				if (grid[i][j] == word[k]) {
					/*result = hasWordHelper1(grid, word, i + 1, j, k + 1);
					if (!result)
						result = hasWordHelper1(grid, word, i, j + 1, k + 1);
					return result;*/
					return hasWordHelper1(grid, word, i + 1, j, k + 1)||hasWordHelper1(grid, word, i, j + 1, k + 1);
				}
				if (result)
					return true;

			}

		}

		return result;

	}

	static boolean hasWord(char arr[][], int r, int c, char word[]) {
		int len = word.length;
		boolean bfound = findword(arr, r, c, word, 0, 0, len, 1);
		if (bfound)
			return true;
		else
			return false;
	}

	static boolean findword(char arr[][], int row, int col, char[] word, int i,
			int j, int len, int pos) {
		if (j >= col)
			return false;

		if (i >= row)
			return false;

		// return false;
		boolean bret = false;
		if ((pos == len) && (word[pos - 1] == arr[i][j]))
			return true;
		if ((pos > 1) && (word[pos - 1] != arr[i][j]))
			return false;
		for (int m = i; m < col; m++) {
			for (int n = j; n < row; n++) {
				if (word[pos - 1] == arr[m][n]) {
					pos = pos + 1;

					bret = findword(arr, row, col, word, m, n + 1, len, pos);
					if (!bret) {
						bret = findword(arr, row, col, word, m + 1, n, len, pos);
					}
					return bret;
				} else if (pos > 1)
					return false;
				if (bret)
					return bret;
			}
		}
		return bret;
	}

}
