package companies.onlinetest;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*2
aabcd
3(k=three)--output -1
aabcd
2(k=two) --output b

Find the kth largest freq element in given string*/
public class WhatPix2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for (int i = 0; i < testcase; i++) {
			String str = scan.next();
			int freq = scan.nextInt();
			System.out.println(findFrequency(str, freq));
		}
		scan.close();
	}

	static String findFrequency(String str, int freq) {
		Map<Character, Integer> map = new TreeMap<>();
		char[] ch = str.toCharArray();
		for (char c : ch) {
			if (!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);
		}
		int counter=1;
		int temp=0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()){
			if (counter == freq)
				return entry.getKey().toString();
			 if(temp!=entry.getValue()){
				counter++;
				temp=entry.getValue();
			 }
		}
		return "-1";
	}

}
