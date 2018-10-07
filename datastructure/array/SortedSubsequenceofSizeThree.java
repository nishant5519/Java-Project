package com.datastructure.array;

public class SortedSubsequenceofSizeThree {

	public static void main(String[] args) {
		int[] arr = {12, 11, 10, 5, 6, 2, 30};
		int[] pos=new int[3];
		findSubsequence(arr,pos);
	}

	static void findSubsequence(int[] a,int[] index){
		int first=0,second=0,third=0;
		 while(true){
			 if(a[first]<a[second])
				 if(a[second]<a[third]){
					 index[0]=first;
					 index[1]=second;
					 index[2]=third;
				 }
			 	
		 }
		
	}
	
}
