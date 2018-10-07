package com.datastructure.array;

public class LargestSubarrayWithEqualNumberof0sand1s {
	public static void main(String[] args) {
		int arr[] = { 0, 0, 1, 1, 0 };
		findIndex(arr);
	}

	static void findIndex(int[] arr) {
		int oneCount = 0;
		int zeroCount = 0;
		int frontindex = 0, rearindex = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				zeroCount++;
			else
				oneCount++;
		}
		while (frontindex < rearindex) {
			if (zeroCount > oneCount) {
				if (arr[frontindex] == 0) {
					frontindex++;
					zeroCount--;
				}
				if (arr[rearindex] == 0) {
					rearindex--;
					zeroCount--;
				}

			} else {
				if (arr[frontindex] == 1) {
					frontindex++;
					oneCount--;
				}
				if (arr[rearindex] == 1) {
					rearindex--;
					oneCount--;
				}
			}
			if (oneCount == zeroCount) {
				System.out.println("LowerIndex: " + frontindex + ", "
						+ "UpperIndex: " + rearindex);
				break;
			}

		}

	}

}
