package recursion;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=VaGBRiSdtFI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=33
public class GetMazePathWithJumps {
	public static void main(String[] args) {
		int sourceRow = 1;
		int sourceCol = 1;
		int destRow = 3;
		int destCol = 3;
		List<String> results = findAllPaths(sourceRow, sourceCol, destRow, destCol);
		System.out.println("Total paths : " +  results.size());

		System.out.println(results);
		System.out.println("Print all paths :");
		printAllPaths(sourceRow, sourceCol, destRow, destCol, "");
	}

	private static List<String> findAllPaths(int srow, int scol, int drow, int dcol) {

		if (srow == drow && scol == dcol) {
			ArrayList<String> bcase = new ArrayList<String>();
			bcase.add(""); // IMPORTANT
			return bcase;
		}

		List<String> paths = new ArrayList<String>();

		// horizontal paths
		for (int ms = 1; ms <= dcol - scol; ms++) {
			List<String> hpaths = findAllPaths(srow, scol + ms, drow, dcol);
			for (String path : hpaths) {
				paths.add("h" + ms + path);
			}
		}

		// diagonal paths
		for (int ms = 1; ms <= drow - srow && ms <= dcol - scol; ms++) {
			List<String> dpaths = findAllPaths(srow + ms, scol + ms, drow, dcol);
			for (String path : dpaths) {
				paths.add("d" + ms + path);
			}
		}

		// vertical paths
		for (int ms = 1; ms <= drow - srow; ms++) {
			List<String> vpaths = findAllPaths(srow + ms, scol, drow, dcol);
			for (String path : vpaths) {
				paths.add("v" + ms + path);
			}
		}

		return paths;
	}

	private static void printAllPaths(int srow, int scol, int drow, int dcol, String path) {

		if (srow == drow && scol == dcol) {
			System.out.print(path + ",");
		}

		// horizontal paths
		for (int ms = 1; ms <= dcol - scol; ms++) {
			printAllPaths(srow, scol + ms, drow, dcol, "h" + ms + path);
		}

		// diagonal paths
		for (int ms = 1; ms <= drow - srow && ms <= dcol - scol; ms++) {
			printAllPaths(srow + ms, scol + ms, drow, dcol, "d" + ms + path);
		}

		// vertical paths
		for (int ms = 1; ms <= drow - srow; ms++) {
			printAllPaths(srow + ms, scol, drow, dcol, "v" + ms + path);
		}

	}

}
