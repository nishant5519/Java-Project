package com.practice;
/*package com.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BookMyShow {
	public static void main(String[] args) {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
        int n;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String[] s1=br.readLine().split(" ");
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(s1[i]);
        Arrays.sort(a);
        int m=Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            String[] s2=br.readLine().split(" ");
            int[] a2=new int[s2.length];
            for(int k=0;k<s2.length;k++)
            {
                a2[k]=Integer.parseInt(s2[k]);
            }
            Arrays.sort(a2);
            int k=0;
            if(a.length<=a2.length)
            {
            for(k=0;k<n;k++)
            {
                if(a[k]!=a2[k])
                    break;
            }
            }
            if(k==n)
                cnt++;
        }
        System.out.println(cnt);
	}

}
*/