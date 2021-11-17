package array;

/*
 * Source and destination has to be included. Only one spot can be left in between destinations to form 
 * max cash .
 */
public class FindMaxCost {

	public static void main(String[] args) {
		int arr[] = {10 , -5 , -10 , -20 , 20 };
	}
	
	void findMaxCash(int[] arr) {
		int maxCash = arr[0];
		boolean isTaken = true;
		for(int i = 1 ; i< arr.length-1 ; i++) {
			if(arr[i] + maxCash > arr[i] && ) {
				maxCash = maxCash + arr[i];
				isTaken = true;
			}
			
		}
		
		
		
	}

}
