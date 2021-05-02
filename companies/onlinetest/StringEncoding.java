package companies.onlinetest;

import java.util.Scanner;

public class StringEncoding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      System.out.print("Enter string: ");
	      String str = sc.nextLine();
	      System.out.println("Input: " + str);
	 
	      String collapsed = "";
	      System.out.println(collapsed.length());
	 
	      char ch=0;
	      int count=1;
	      for (int x = 0; x < str.length(); x++) { 
	         if (ch == str.charAt(x)){
	            count = count + 1;
	         } else {	           
	            if(count != 1){
	               collapsed = collapsed + count;
	            }
	            collapsed = collapsed + ch;
	            ch = str.charAt(x);
	            count = 1;
	         }
	      }
	     
	      if(count != 0 && !str.equals("")){
	         collapsed = collapsed + count;
	      }
	      collapsed = collapsed + ch;
	      System.out.println("Compressed: " + collapsed); 

	}
    /*
     * Complete the closingBracePosition function below.
     */
    static int closingBracePosition(String inputSentence, int openingBraceNum) {
        char[] input=inputSentence.toCharArray();
        int count=1;
         for(int i=0;i<input.length;i++){
            if(input[i]=='(' || input[i]=='{' || input[i]=='['){
                count++;
            }
            else if(input[i]==')' || input[i]=='}' || input[i]==']'){
                count--;
            }
         }
            if(count!=1)
                return -1;
        int openBracePos=0;  
        for(int i=0;i<input.length;i++){
            if((input[i]=='(' || input[i]=='{' || input[i]=='[') && openingBraceNum!=0){
                openingBraceNum--; 
                openBracePos=i;
            }         
         }
        int closingBraceNum=openBracePos;
        int counter=1;
        while(counter>0 && closingBraceNum < input.length-1){
            char c=input[++closingBraceNum];
            if(c=='(' || c=='{' || c=='['){
                counter++;
            }
            else if(c==')' || c=='}' || c==']'){
                counter--;
            }
        }
        
        return closingBraceNum+1;
    }



}
