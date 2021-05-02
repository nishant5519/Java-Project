package companies.onlinetest;
import java.io.*;
import java.util.*;

public class Solution2 {
	static int minReservationTables(int[][] reservationStartEndTimes) {
          // YOUR CODE HERE
		
		int arr1[] =  new int[reservationStartEndTimes.length];
		int arr2[] =  new int[reservationStartEndTimes.length];
		
		for(int i = 0; i < reservationStartEndTimes.length ; i++) {
			arr1[i] = reservationStartEndTimes[i][0];
			arr2[i] = reservationStartEndTimes[i][1];
		}
		
		int n = arr1.length;
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		  int table_reqd  = 1, result = 1; 
        int i = 1, j = 0; 
  
        
        while (i < n && j < n) { 
            if (arr1[i] <= arr2[j]) { 
            	table_reqd++; 
                i++; 
            } 
  
            else if (arr1[i] > arr2[j]) { 
            	table_reqd--; 
                j++; 
            } 
  
            if (table_reqd > result) 
                result = table_reqd; 
        } 
  
        return result; 


	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] reservationStartEndTimeList = new int[n][2];
		String[] reservationStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] reservationStartEndTime = reservationStartEndTimes[i].split(",");
			for (int j = 0; j < reservationStartEndTime.length; j++) {
				reservationStartEndTimeList[i][j] = Integer.parseInt(reservationStartEndTime[j]);
			}
		}

		int out = minReservationTables(reservationStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}