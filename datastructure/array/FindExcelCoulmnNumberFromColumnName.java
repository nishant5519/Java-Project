package array;

public class FindExcelCoulmnNumberFromColumnName {

	public static void main(String[] args) {
		String column="ABC";
		int result = 0;
        for (int i = 0; i < column.length(); i++) {
            result *= 26;
            result += column.charAt(i) - 'A' + 1;
        }
        System.out.println(result);
	}

}
