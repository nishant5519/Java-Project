package array;

import java.util.List;

public class ConsecutivePresence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int maxStreak(int m , List<String> data) {
		
		String str = "";
		for(int i = 0 ; i < m ; i++) {
			str = str + "Y";
		}
		
		int count  = 0 ;
		int max = 0;
		for(int i = 0 ; i < data.size() ; i++) {
			
			if(data.get(i).equals(str)) {
				count++;
			if(count > max)
				max = count;
			}
			else 
				count = 0;
			
			
		}
		
		return max;
	}
	
	
}
