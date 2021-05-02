package practice;

public class Average {
	public static void main(String[] args) {
		double num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int a[] = { 1, 2, 3, 4, 5 };
		int d[] = a;
		int sum = 0;
		double result;
		result = 0;
		for (int j = 0; j < 10; ++j)
			result = result + num[j];
		System.out.println(result / 10);
		for (int i = 0; i < 3; ++i)
			sum = sum + (a[i] * d[i + 1]) + (a[i + 1] * d[i]);
		System.out.println(sum);
	}

}
