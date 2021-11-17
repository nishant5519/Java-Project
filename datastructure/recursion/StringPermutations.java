package recursion;

class StringPermutations {
	public static void main(String[] args) {
		String str = "abc";
		//numOfPermutations(str, 0, str.length() - 1);
		System.out.println("Print all String permuatations : ");
		printAllPermutation(str, "");


	}

	static void numOfPermutations(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				numOfPermutations(str, l + 1, r);
				str = swap(str, l, i);
			}
		}

	}

	static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	// https://www.youtube.com/watch?v=sPAT_DbvDj0&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=43
	static void printAllPermutation(String ques, String ans) {
		
		if(ques.length() == 0) {
			System.out.print(ans + ",");
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char tempAns = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);
			printAllPermutation(ros, tempAns + ans);

		}

	}
}