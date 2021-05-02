package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		
		boolean a=Pattern.matches("geeksforge*ks", "geeksforgeeks");
		System.out.println(a);
		
		//second way to match pattern
		Pattern p=Pattern.compile("geeksforge*ks");
		Matcher m1=p.matcher("geeksforgeeks");
		boolean b=m1.matches();
		System.out.println(b);		
		System.out.println(Pattern.matches("g*geeks*", "gegeeks"));
		Pattern pattern = Pattern.compile("geeks");// Create a pattern to be searched
		Matcher m2 = pattern.matcher("geeksforgeeks.org");// Search above pattern in "geeksforgeeks.org"
		// Print starting and ending indexes of the pattern in text
		while (m2.find())
			System.out.println("Pattern found from " + m2.start() + " to "
					+ (m2.end()-1));
		
		
		Pattern p1=Pattern.compile("ge*",Pattern.CASE_INSENSITIVE);
		Matcher m3=p1.matcher("GeeksforGeeks.org");
		while(m3.find()){
			 System.out.println("Pattern found from " + m3.start() +
                     " to " + (m3.end()-1));
		}
		
		
		String text = "geeks1for2geeks3";
		 
        // Specifies the string pattern which is to be searched
        String delimiter =  "\\d";
        Pattern p2 = Pattern.compile(delimiter,
                                        Pattern.CASE_INSENSITIVE);
 
        // Used to perform case insensitive search of the string
        String[] result = p2.split(text);
 
 
        for (String temp: result)
            System.out.println(temp);
		
        String sentence="My name is nishant";
        System.out.println("Number of words inside sentence is: " + sentence.split(" ").length);
	}

}
