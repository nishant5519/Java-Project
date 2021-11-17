package Collections;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HashMapExampleTest {

	public static void main(String[] args) {
		System.out.println("Execution time in milliseconds : " +
                (1301) / 1000000);
		
		System.out.println(getHost("https://testbrandedspint.com"));
		
		
		Scanner input = new Scanner(System.in);
        String name;
        System.out.println("Enter your full name: ");
        name = input.nextLine();
        String[] parts = name.split(" ");
        System.out.println(java.util.Arrays.toString(parts));
        input.close();
	}
	
	public static String getHost(String origin) {
		String host = null;
		try {
			URL url = new URL(origin);
			host = url.getHost();
		} catch (MalformedURLException e) {
		}
		return host;
	}

}
