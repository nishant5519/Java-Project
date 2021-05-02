package string;

public class FindAllSubstringOfString {

	public static void main(String[] args) {
		String input = "abcaba";
		String temp = null;
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				 temp=input.substring(i, j);
				 System.out.println(temp);
				/*if (temp.charAt(0) == temp.charAt(temp.length()-1) && temp.length() > 1)
					System.out.println("Substring: " + input.substring(i, j));*/
			}
		}

	}

}
