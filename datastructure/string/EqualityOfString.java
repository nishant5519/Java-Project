package string;

public class EqualityOfString {

	public static void main(String[] args) {
		String s1 = "Test";
		String s2 = "Test";
		String s3 = new String("Test");
		final String s4 = s3.intern();
		System.out.println(s1 == s2); // true
		System.out.println(s2 == s3); // false
		System.out.println(s3 == s4); // false
		System.out.println(s1 == s3); // false
		System.out.println(s1 == s4); // true
		System.out.println(s2 == s4); // true
		System.out.println(s1.equals(s2)); // true
		System.out.println(s2.equals(s3)); // true
		System.out.println(s3.equals(s4)); // true
		System.out.println(s1.equals(s4)); // true
		System.out.println(s1.equals(s3)); // true

		int i, j = 1;

		i = j > 2 ? 2 : 1;
		switch (i) {
		case 0:
			System.out.println(0);
			break;
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		}
	}

}
