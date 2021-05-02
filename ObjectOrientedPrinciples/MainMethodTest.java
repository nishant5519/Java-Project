package ObjectOrientedPrinciples;

public class MainMethodTest {
	public static void main(String[] args) {
		System.out.println("I am going to invoke main method");
		int randomNum = (int) (Math.random() * 10);

		if (randomNum >= 8)
			System.exit(0);

		main(new String[] { "a", "b", "c" });
	}

}
