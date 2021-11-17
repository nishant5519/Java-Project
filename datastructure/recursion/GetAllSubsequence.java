package recursion;

import java.util.ArrayList;

/*
 * A subsequence of a string is a new string that is formed from the original string by deleting 
 * some (can be none) of the characters without disturbing the relative positions of the 
 * remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class GetAllSubsequence {

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> result = getss(str);
		System.out.println(result);
		printss("abc","");
	}
	
	//Here we are storing all subsequence in a list and then returning. But for larger values of string
	//storing of all subsequence can eat upto 32 gb memory.
	private static ArrayList<String> getss(String str){
		
		if(str.length() == 0)
		{
			ArrayList<String> bc = new ArrayList<>();
			bc.add("");
			return bc;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rres = getss(ros);
		
		ArrayList<String> subsequences = new ArrayList<>();
		for(String pos : rres) {
			subsequences.add("" + pos);
			subsequences.add(ch + pos);
		}
		return subsequences;
		
	}
	
	//To avoid memory issue , just print all subsequence
	//https://www.youtube.com/watch?v=Ke8TPhHdHMw&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=34
	//max stack occupied = n+1 level where n is no. of char in ques string
	private static void printss(String ques,String ans) {

		if (ques.length() == 0) {
			System.out.print(ans + ",");
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		printss(ros , ans + ""); //first char not taken
		printss(ros , ans + ch); //first char taken

		

	}

}
