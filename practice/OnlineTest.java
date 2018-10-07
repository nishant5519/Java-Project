package com.practice;

public class OnlineTest {

	
	public static void main(String[] args) {
		boolean b1=true;
		boolean b2=false;
		boolean b3=true;
		if(b1&b2 | b2&b3 | b2)
			System.out.println("ok");
		if(b1&b2 | b2&b3 | b2 | b1)
			System.out.println("dokey");
		int[] arr={1,2,3,4,5};
	
		call_array(arr[0], arr);
		System.out.println(arr[0] + "," +arr[1]);
			String s1="abc";
			String s2="def";
			String s3=s1.concat(s2.toUpperCase());
			System.out.println(s1+s2+s3);
			int i=010;
			int j=07;
			
			System.out.println(i);
			System.out.println(j);
			s1.toCharArray();
			int t[][]=new int[s1.length()][];
			char[] s;
			System.out.println(-1);
			int count=0;
			 if(arr[j]%arr[i]==0){
                 System.out.println(arr[i]);
                 count++;
             }
	}
	
	static void call_array(int i,int arr[]){
		arr[i]=6;
		i=5;
	}

}
