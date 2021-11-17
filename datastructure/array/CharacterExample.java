package array;

public class CharacterExample {

	public static void main(String[] args) {
		char[] ca = new char[26];
		char ch1='\u0000';
		ca['a'-'a']++;
		System.out.println(ca[0]);
		System.out.println(ca[1]++);
		System.out.println(ch1);
		/*for (char c : s.toCharArray())
			ca[c - 'a']++;
		String keyStr = String.valueOf(ca);*/

	}

}
