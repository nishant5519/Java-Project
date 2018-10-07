package com.companies.onlinetest;

import java.util.ArrayList;
import java.util.Collections;

public class StringEncodingMyAttempt {
	public static void main(String[] args) {
		String str = "GrT";
		System.out.println(encodeString(str));
		
		ArrayList list=new ArrayList();
		list.add(new AX("test"));
		list.add(1 , new AX("sfsdf"));
		Collections.sort(list);
		System.out.println(list);
	}

	public static String encodeString(String str) {
		char[] input = str.toCharArray();
		char c = input[0];
		String collapsed = "";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {

			if (c == input[i]) {
				count = count + 1;
			}

			else {

				collapsed = collapsed + c + count;// move this code above line
													// to
													// change the sequence
				count = 1;

			}

			c = input[i];

		}
		if (count != 0)

			collapsed = collapsed + c + count;

		return collapsed;
	}

}

class AX  implements Comparable<AX>{
	public String name;
	
	public AX(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name;
	}

	@Override
	public int compareTo(AX o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
