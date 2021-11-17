package recursion;

public class FindMaxElementInArrayUsingRecursion {

	public static void main(String[] args) {
		int[] arr = {12,30 , 56, 34 , 45 ,1};
		System.out.println(findMax(arr , 0));
	}
	
	
	 static int findMax(int[] arr , int index){
		
		 if(index == arr.length)
			 return 0;
		 
		 /*
		  * OR (return last element itself if reaches at end of the array)
		  * if(index == arr.length-1)
			 return arr[index];
		  */
		 
		 int temp = findMax(arr , index+1);
		 if(arr[index] > temp)
			 return arr[index];
		 else
			 return temp;
	}

}
