package recursion;/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class FindPowerUsingRecursion {
	public static void main (String[] args) {
		//code
		Scanner scan=new Scanner(System.in);
		
		int T = scan.nextInt();
		
		while(T-->0){
		    int num = scan.nextInt();
		    int revNum = reverse(num);

		    System.out.println(power(num,revNum));
		}


	}
	
	static int findPow(int num , int rev) {
	    System.out.println(rev);
	    if(rev == 0){
	       return 1; 
	    }
	    
	    if(rev%2 == 0)
	       return findPow(num*num , rev/2);

		return num * findPow(num , rev -1);
	}

	static int power(int x, int y)
	{
		if (y == 0)
			return 1;
		else if (y % 2 == 0)
			return power(x, y / 2) * power(x, y / 2);
		else
			return x * power(x, y / 2) * power(x, y / 2);
	}

	static int reverse(int num) {
		int rev = 0;

		while (num != 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;

		}

		return rev;
	}

}