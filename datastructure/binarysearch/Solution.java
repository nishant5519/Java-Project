package binarysearch;

import java.util.ArrayList;

public class Solution {
	public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {

		int rowNum = -1;
		int colNum = A.get(0).size();

		for (int i = 0; i < A.size(); i++) {

			if (A.get(i).get(0) == B)
				rowNum = i;

			else if (A.get(i).get(0) > B && A.get(i).get(colNum - 1) <= B)
				rowNum = i;

		}

		// System.out.println("rownm " + rowNum);
		if (rowNum == -1)
			return 0;
		else
			return searchInsert(A.get(rowNum), B);

	}

	private int searchInsert(ArrayList<Integer> a, int b) {
		// System.out.println("List " + a);
		int low = 0;
		int high = a.size() - 1;

		while (low <= high) {

			int mid = low + (high - low) / 2;

			if (a.get(mid) == b) {
				return 1;
			} else if (a.get(mid) > b) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return 0;
	}
}
