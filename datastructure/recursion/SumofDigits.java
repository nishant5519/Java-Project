package recursion;

public class SumofDigits {

	public static void main(String[] args) {
		System.out.println(getSumOfDigits(0));
		/* N%10==right most digit
		 * 
		 * N/10== Rest of left digits
		 * */
	}

	static int getSumOfDigits(int N) {
		if (N < 10)
			return N;

		return (N % 10) + getSumOfDigits(N / 10);
	}

}
