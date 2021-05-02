package companies.onlinetest;

import java.util.Scanner;

public class FindPrimeNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int b = scan.nextInt();
		String primeNumbers = "";
		int a = 2;
		for (int i = a; i <= b; i++) {
			int counter = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0)
					counter = counter + 1;
			}
			if (counter == 2)
				primeNumbers = primeNumbers + i + " ";

		}
		System.out.println(primeNumbers);
		char x='a';
		System.out.println((int)x);
		scan.close();
		
	}

}
