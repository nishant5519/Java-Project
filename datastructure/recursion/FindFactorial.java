package recursion;

public class FindFactorial {
	public static void main(String[] args) {
		System.out.println(factorial(2));

	}

	private static int factorial(int i) {
		if (i == 1)
			return 1;
		int j = i * factorial(i - 1);
		return j;
	}

}
