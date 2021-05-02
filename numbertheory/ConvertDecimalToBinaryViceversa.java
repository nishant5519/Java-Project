package numbertheory;

public class ConvertDecimalToBinaryViceversa {

	public static void main(String[] args) {
		convertDeciToBin(3);
		convertBinToDeci(1001);
	}

	static void convertDeciToBin(int input) {
		StringBuilder sb = new StringBuilder();
		while (input > 0) {
			sb = sb.append(String.valueOf(input % 2));
			input = input / 2;
		}
		System.out.println(sb.reverse());
	}

	static void convertBinToDeci(int input) {
		int last = 0, base = 1;
		int decimal = 0;
		while (input > 0) {
			last = input % 10;
			input = input / 10;
			decimal = decimal + last * base;
			base = base * 2;
		}
		
		System.out.println(decimal);
	}
}
