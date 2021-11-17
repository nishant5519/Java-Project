package recursion;

import java.util.ArrayList;

public class GetMazeAllPath {

	public static void main(String[] args) {

		int sourceRow = 1;
		int sourceCol = 1;
		int destRow = 2;
		int destCol = 2;

		System.out.println(findAllPath(sourceRow, sourceCol, destRow, destCol));
		printMazeAllPath(1,1,"" ,3,3);
	}

	public static ArrayList<String> findAllPath(int srow, int scol, int drow, int dcol) {

		if (srow == drow && scol == dcol) {
			ArrayList<String> bcase = new ArrayList<String>();
			bcase.add(""); //IMPORTANT
			return bcase;
		}

		ArrayList<String> hpaths = new ArrayList<String>();
		ArrayList<String> vpaths = new ArrayList<String>();
		ArrayList<String> paths = new ArrayList<String>();

		if (scol < dcol)
			hpaths = findAllPath(srow, scol + 1, drow, dcol); // get all horizontal paths
		if (srow < drow)
			vpaths = findAllPath(srow + 1, scol, drow, dcol); // get all vertical paths

		for (String hpath : hpaths)
			paths.add("h" + hpath);

		for (String vpath : vpaths)
			paths.add("v" + vpath);
		
		return paths;

	}
	
	public static void printMazeAllPath(int srow, int scol, String path, int drow , int dcol) {

		if (srow == drow && scol == dcol) {
			System.out.print(path + ",");
		}

		if(scol < dcol)
			printMazeAllPath(srow, scol + 1, "h" + path , drow ,dcol); // get all horizontal paths
		if (srow < drow)
			printMazeAllPath(srow + 1, scol, "v" + path , drow ,dcol); // get all vertical paths

		/*
		 * OR
		 * 
		 if(srow > drow || scol > dcol)
		 	return;
		 	
		 if (srow == drow && scol == dcol) {
			System.out.print(path + ",");
		}

		if(scol < dcol)
			printMazeAllPath(srow, scol + 1, "h" + path , drow ,dcol); // get all horizontal paths
		if (srow < drow)
			printMazeAllPath(srow + 1, scol, "v" + path , drow ,dcol); // get all vertical paths

		 */
	}

}
