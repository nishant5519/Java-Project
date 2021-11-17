package recursion;

public class TargetSumSubset {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int targetSum = 70;
		targetSum(arr, 0, "", 0, targetSum);
	}

	static void targetSum(int[] arr, int idx, String set, int sos, int tar) {

		if (idx == arr.length) {
			if (sos == tar)
				System.out.println(set);
			return;
		}

		targetSum(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
		targetSum(arr, idx + 1, set, sos, tar);

	}

}
