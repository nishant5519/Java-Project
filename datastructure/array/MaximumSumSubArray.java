package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySumforList(Arrays.asList(-1, 3, 4, -2, 5, -7)));
	}

	// Time Complexity: O(n) Kadane algorithm
	static int maxSubArraySum(int a[]) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, consecutiveSum = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			// max sum at index i maxSum[i]=max(arr[i],maxSum[i]+arr[i])
			consecutiveSum = consecutiveSum + a[i];
			if (max_so_far < consecutiveSum) {
				max_so_far = consecutiveSum;
				start = s;
				end = i;
			}
			if (consecutiveSum < 0) {
				consecutiveSum = 0;
				s = i + 1;
			}
		}
		System.out.println("Start index: " + start + ", " + "End Index: " + end);
		return max_so_far;
	}

	static int maxSubArraySumforList(List<Integer> a) {
		int size = a.size();
		int max_so_far = Integer.MIN_VALUE, consecutiveSum = 0;
		int start = 0;
		int end = 0;
		int index = 0;

		for (int i = 0; i < size; i++) {
			consecutiveSum = consecutiveSum + a.get(i);
			if (max_so_far < consecutiveSum) {
				max_so_far = consecutiveSum;
				start = index;
				end = i;
				
			}
			if (consecutiveSum < 0) {
				consecutiveSum = 0;
				index = i + 1; 
			}
		}
		return max_so_far;
	}

	static int minMovesToEvenFollowedByOdd(List<Integer> a) {
		int moves = 0;
		int totalLength = a.size();
		for (int i = 0; i < totalLength / 2; i++) {
			if (a.get(i) % 2 != 0) {
				for (int j = totalLength / 2; j < totalLength; j++) {
					if (a.get(j) % 2 == 0) {
						int temp = a.get(i);

						a.add(a.get(j));
						a.add(temp);
						moves++;
						break;
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
		return moves;
	}

	static String compareStrings(String firstString, String secondString, String thirdString) {
		List<String> str = new ArrayList<>();
		str.add(firstString);
		str.add(secondString);
		str.add(thirdString);

		str.sort((String s1, String s2) -> s1.compareTo(s2));
		return str.get(0) + str.get(1) + str.get(2);

	}
}
