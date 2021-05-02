package companies.onlinetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ZeMoSo {

	public static void main(String[] args) {
		// System.out.println(solution("0 - 22 1985--324"));
		int[] ab = { 7,5,2,7,2,7,4,7 };
		solution(ab);
	}

	static public String solution(String S) {
		List<Character> list = new ArrayList<Character>();

		if (S.length() == 2) {
			return S;
		}
		char[] ch = S.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (!(ch[i] == '-' || ch[i] == ' '))
				list.add(ch[i]);
		}
		int counter = 0;
		String str = new String();
		for (int j = 0; j < list.size(); j++) {
			str = str.concat(list.get(j).toString());
			counter++;
			if (counter == 3 && j != list.size() - 1) {
				str = str.concat("-");
				counter = 0;
			}
		}
		char[] strArr = str.toCharArray();
		if (str.charAt(str.length() - 1) == (char) ' ' + '-') {
			str = str.replace(strArr[strArr.length - 1], strArr[strArr.length - 2]);
			str = str.replace(strArr[strArr.length - 2], '-');
		}

		return str;
	}

	static public void solution(int[] A) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			list.add(A[i]);
		}
		Set<Integer> set = new LinkedHashSet<Integer>(list);
		int[] B = new int[set.size()];
		Iterator<Integer> itr = set.iterator();
		int j = 0;
		while (itr.hasNext()) {
			B[j] = itr.next();
			j++;
		}
		System.out.println(shortestVacation(A, A.length, B, B.length));

	}

	static int shortestVacation(int A[], int n, int B[], int m) {
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {

			for (int j = i; j < n; j++) {

				int k, index = 0;
				for (k = i; k <= j; k++) {
					if (A[k] == B[index])
						index++;
					if (index == m)
						break;
				}

				if (index == m && result > k - i + 1)
					result = (k == n) ? k - i : k - i + 1;
			}
		}

		return result-1;
	}
	
	 public static void multiply(LinkedList<Integer> operand1, LinkedList<Integer> operand2) {
	        // Edge case yields no change
	        if (operand1 == null || operand2 == null) {
	            return ;
	        }
	        String num1="";
	         while(!operand1.isEmpty())
	        	 num1=num1.concat(operand1.poll().toString());
	         String num2="";
	         while(!operand2.isEmpty())
	        	 num2=num2.concat(operand2.poll().toString());
	         int number1=Integer.valueOf(num1);
	         int number2=Integer.valueOf(num2);
	         System.out.println(number1*number2);
	       	    }
}
