package com.datastructure.recursion;

public class ReverseStringUsingRecursion {

	public static void main(String[] args) {
		System.out.println(reverse("abcdef"));
		char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f' };
		reverse(ch);
	}

	private static String reverse(String str) {
		if (str.isEmpty())
			return str;
		return reverse(str.substring(1)) + str.charAt(0);
	}

	private static void reverse(char[] ch) {

		helper(0, ch);
	}

	private static void helper(int i, char[] ch) {

		if (i == ch.length || ch == null)
			return;
		helper(i + 1, ch);
		System.out.println(ch[i]);

	}
	
	public static String reverseWithoutRecursion(String input){
	    char[] in = input.toCharArray();
	    int begin=0;
	    int end=in.length-1;
	    char temp;
	    while(end>begin){
	        temp = in[begin];
	        in[begin]=in[end];
	        in[end] = temp;
	        end--;
	        begin++;
	    }
	    return new String(in);
	}

}
