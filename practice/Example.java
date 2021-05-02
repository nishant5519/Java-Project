package practice;

import java.util.regex.Pattern;

public class Example {
	public static void main(String[] args) {
		System.out.println(Pattern.matches("[amn]", "abcd"));
		System.out.println(Pattern.matches("[amn]", "a"));
		System.out.println(Pattern.matches("[amn]", "ammm"));
		String text= " �Copied �from� Word� " ;
		System.out.println(text);
		String text1=text.replaceAll("[\\u2018\\u2019]", "'")		
        .replaceAll("[\\u201C\\u201D]", "\"");
		System.out.println(text1);
	}

}
