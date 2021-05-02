package array;

import java.util.HashMap;
import java.util.Map;

public class CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK {

	public static void main(String[] args) {
		int[] input = { 92, 75, 65, 48, 45, 35, 10, 10 };
		System.out.println(checkAllPairs(input, 10));
	}

	private static boolean checkAllPairs(int[] arr, int k) {

		if (!(arr.length % 2 == 0))
			return false;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int remainder = arr[i] % k;
			if (!map.containsKey(remainder))
				map.put(remainder, 0);
			map.put(remainder, map.get(remainder) + 1);
		}

		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i] % k;

			if (temp == 0 && map.get(temp) % 2 == 1)
				return false;
			if (temp != 0 && map.get(temp) != map.get(k - temp))
				return false;

		}

		return true;
	}
}
