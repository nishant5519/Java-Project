package binarysearch;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(2147483647));
	}

	public static int sqrt(int A) {

		int low = 1;
		int high = A;
		int ans = 0;

		while (high >= low) {

			int mid = low + (high - low) / 2;
			int midSqr = mid * mid;

			if (midSqr == A)
				return mid;
			else if (midSqr > A)
				high = mid - 1;
			else {
				ans = low;
				low = mid + 1;
			}

		}
		return ans;
	}
}
