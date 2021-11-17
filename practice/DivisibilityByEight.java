package practice;

public class DivisibilityByEight {

	public static void main(String[] args) {
		// System.out.println(1000%8);
		System.out.println(solve("16"));
	}

	public static int solve(String A) {
		int length = A.length();
		int sum = 0;
		int temp = 1;
		for (int i = 0; i < 3; i++) {
			if (i < A.length()) {
				sum = sum + Character.getNumericValue(A.charAt(length - 1 - i)) * temp;
				temp = temp * 10;
			}

		}
		return sum % 8 == 0 ? 1 : 0;
	}

	public int[] solve(int[] A) {
		int xorOf2Ele = 0;

		for (int a : A) {
			xorOf2Ele = xorOf2Ele ^ a;
		}

		int mask = xorOf2Ele & -xorOf2Ele; // right most set bit
		int num1 = 0;
		int num2 = 0;

		for (int i : A) {
			if ((mask&i)==0) {
				num1 = num1 ^ i;
			} else {
				num2 = num2 ^ i;
			}
		}

		int[] result = new int[2];
		result[0] = num1;
		result[1] = num2;

		return result;
	}

}
