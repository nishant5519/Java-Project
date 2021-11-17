package dynamicprogramming;

public class CountStairPathUsingDP {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(countPath(n, new int[n + 1]));
	}

	public static int countPath(int n, int[] qb) {

		if (n == 0)
			return 1;

		if (n < 0)
			return 0;

		if (qb[n] > 0)
			return qb[n];

		int nm1 = countPath(n - 1, qb);
		int nm2 = countPath(n - 2, qb);
		int nm3 = countPath(n - 3, qb);

		int count = nm1 + nm2 + nm3;
		qb[n] = count;
		return qb[n];

	}

}
