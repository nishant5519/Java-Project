package companies.onlinetest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreyOrange {

	public static void main(String[] args) {
		List<Integer> avg = new ArrayList<>();
		avg.add(0);
		avg.add(1);
		avg.add(0);
		avg.add(1);
		int minMoves = 0;
		for (int i = 0; i < avg.size() - 1; i++) {
			for (int j = 0; j < avg.size() -1; j++) {
			if (avg.get(j) == 0 && avg.get(j + 1) == 1) {
				Collections.swap(avg, j, j+1);
				minMoves++;
			}
			}
		}
		System.out.println(minMoves);
		Math.abs(3-2);

	}

}
