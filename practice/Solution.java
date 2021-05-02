package practice;

import java.util.Scanner;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
          Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[] testCase = new int[M];
        int[] depTestCase=new int[2*N];
        for(int i = 0; i < M; i++){
            testCase[i] = in.nextInt();
        }
        
        String s=Integer.toString(M);
        s.toCharArray();
        for(int i = 0; i < 2*N; ){
        	   int a = in.nextInt();
               int b = in.nextInt();
            depTestCase[i] = a;
            depTestCase[i+1] = b;
            i++;
            i=2*i;
            
        }
        checkDependency(testCase,depTestCase);
    }
    static void checkDependency(int[] testCases,int[] depTestCases){
        for(int i=0;i< testCases.length;i++){
            if(testCases[i]==0)
                System.out.println("NO");
             else if(i+1==depTestCases[(i+1)%2])  {
                 if(testCases[depTestCases[((i+1)%2)+1]]==1)
                      System.out.println("YES");
                 else
                     System.out.println("NO");
             } 
        }
    }
}