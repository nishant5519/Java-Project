package Collections;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExampleTest {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		Map<BrandingAttribute,Integer> map = new HashMap<>();
		BrandingAttribute ba1 = new BrandingAttribute("bw_communicator_android_link", "https://apps.sipadvantage.com/receptionist/");
		BrandingAttribute ba2 = new BrandingAttribute("bw_communicator_android_link", "https://apps.sipadvantage.com/receptionist/new");
		
		map.put(ba1, 1);
		map.put(ba2, 1);
		System.out.println(map);
		long endTime = System.nanoTime();
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
