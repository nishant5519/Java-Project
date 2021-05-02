package numbertheory;

import java.util.Stack;

public class CountNaturalNumbersWhoseAllPermutationAreGreaterThanThatNumber {

	public static void main(String[] args) {
		
	}
	
	static int countNumber(int n)
	{
	    int countNum = 0;	 
	    for (int i = 1; i <= 9; i++)
	    {
	       Stack<Integer> s=new Stack<>();
	        if (i <= n)
	        {
	            s.push(i);
	            countNum++;
	        }
	 
	        while (!s.empty())
	        {
	            int topElement = s.peek();
	            s.pop();
	            for (int j = topElement%10; j <= 9; j++)
	            {
	                int x = topElement*10 + j;
	                if (x <= n)
	                {
	                    s.push(x);
	                    countNum++;
	                }
	            }
	        }
	    }
	 
	    return countNum;
	}


}
