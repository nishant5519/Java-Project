package recursion;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=hMJAlbJIS7E&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=29
//Jump of 1,2 and3 only allowed
public class GetStairPaths {

	public static void main(String[] args) {
		int stairs = 4;
		System.out.println(getStairsPath(stairs));
		
		printStairsPath(stairs, "");

	}

	static ArrayList<String> getStairsPath(int n) {

		if (n == 0) {
			ArrayList<String> bcase = new ArrayList<String>();
			bcase.add("");
			return bcase;

		}
		if (n < 0) {
			ArrayList<String> bcase = new ArrayList<String>();
			return bcase;

		}

		// this can be done in for loop as well
		ArrayList<String> p1 = getStairsPath(n - 1);
		ArrayList<String> p2 = getStairsPath(n - 2);
		ArrayList<String> p3 = getStairsPath(n - 3);

		ArrayList<String> paths = new ArrayList<>();

		for (String path : p1) {
			paths.add(1 + path);
		}
		for (String path : p2) {
			paths.add(2 + path);
		}
		for (String path : p3) {
			paths.add(3 + path);
		}

		return paths;
	}

	static void printStairsPath(int n, String path) {

		if (n == 0) {
			System.out.print(path +",");
			return;
		}
		if (n < 0) {
			return;
		}

		// this can be done in for loop as well
		printStairsPath(n - 1, path + "1");
		printStairsPath(n - 2, path + "2");
		printStairsPath(n - 3, path + "3");

	}

}
