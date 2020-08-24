package com.datastructure.string;

public class SwapString {

	public static void main(String[] args) {
		String str1 = "String1";
		String str2 = "String2";
		swap(str1, str2);
		System.out.println("str1:" + str1);
		System.out.println("str2:" + str2);

		StringBuffer strbuf1 = new StringBuffer("Str1");
		StringBuffer strbuf2 = new StringBuffer("Str2");
		swapBuffer(strbuf1, strbuf2);
		System.out.println(strbuf1);
		System.out.println(strbuf2);

		int int1 = 1;
		int int2 = 2;
		swapintegers(int1, int2);
		System.out.println(int1);
		System.out.println(int2);

	}

	public static void swap(String string1, String string2) {
		String temp = string1;
		string1 = string2;
		string2 = temp;
		string1.concat("_appended");
		string2.concat("_appended");
	}

	public static void swapBuffer(StringBuffer x, StringBuffer y) {
		StringBuffer temp=x;
		x=y;
		y=temp;
		x.append("_appendX");
		y.append("_appendY");
		x.append(y);
		y = x;
	}

	//Here new variables i1 and i2 are created apart from int1 and int2
	public static void swapintegers(int i1, int i2) {
		int temp = i1;
		i1 = i2;
		i2 = temp;
		
	}

}
