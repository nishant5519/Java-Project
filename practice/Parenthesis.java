package com.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Parenthesis {
	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		String[] strarray;
		removeInvalidParenthesis(expression);
	}

	
	static void removeInvalidParenthesis(String str) {
		if (str.length() == 0)
			return;

		Set<String> visit = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		Stack<String> stk=new Stack<String>();
		String temp;
		boolean level = false;

		q.add(str);
		visit.add(str);
		while (!q.isEmpty()) {
			str = q.peek();
			q.remove();
			if (isValidString(str)) {
				stk.add(str);
				level = true;
			}
			if (level)
				continue;
			for (int i = 0; i < str.length(); i++) {
				if (!isParenthesis(str.charAt(i)))
					continue;

			
				temp = str.substring(0, i) + str.substring(i + 1);
				if (!visit.contains(temp)) {
					q.add(temp);
					visit.add(temp);
				}
			}
		}
		
		while(!stk.isEmpty())
			System.out.println(stk.pop());
	}
	static boolean isParenthesis(char c) {
		return ((c == '(') || (c == ')'));
	}


	static boolean isValidString(String str) {
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				cnt++;
			else if (str.charAt(i) == ')')
				cnt--;
			if (cnt < 0)
				return false;
		}
		return (cnt == 0);
	}

}