package array;

//https://www.geeksforgeeks.org/find-excel-column-name-given-number/ 
public class FindExcelColumnNameFromAGivenColumnNumber {

	public static void main(String[] args) {
		int i = 'a';
		char c = 'a';
		char add=1 + 'a';
		System.out.println(i);
		System.out.println(c);
		System.out.println(add);
		int number = 28;
		final StringBuilder sb = new StringBuilder();

		int num = number - 1;
		//complexity: O(logn)
		while (num >= 0) {
			int numChar = (num % 26) + 65;
			sb.append((char) numChar);
			num = (num / 26) - 1;
		}
		System.out.println(sb.reverse().toString());
	}

}
