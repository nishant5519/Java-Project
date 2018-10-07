package com.datastructure.array;

/* IMPORTANT: Multiple classes and nested static classes are supported */
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
        */
        
        //Scanner
        Scanner s = new Scanner(System.in);
        int count=0;
        int boysCount = s.nextInt();
        int[] boysSkill=new int[boysCount];

        for (int i = 0; i < boysCount; i++) {
            boysSkill[i]=s.nextInt();
        }
        int girlsCount = s.nextInt();
        int[] girlsSkill=new int[girlsCount];

        for (int i = 0; i < girlsCount; i++) {
             girlsSkill[i]=s.nextInt();
        }
        
        for(int i=0;i < boysCount;i++){
            for(int j=0;j < girlsCount;j++){
                if(girlsSkill[j]-boysSkill[i]==1 || girlsSkill[j]-boysSkill[i]==-1 || girlsSkill[j]-boysSkill[i]==0)
                count++;
            }
        }
        System.out.println(count);
        
    }
}
