package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Practice {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Employee,String> tm=new TreeMap<Employee,String>();
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String a,b;
		 char[] arr=input.toCharArray();
		 for(int i=0 ; i < arr.length ; i++)
		 {
			a= Character.toString(arr[i]);
			b=a.toLowerCase();
		//	if(a.equals(b))
			//	arr[i]=a.toUpperCase()
		 }

		
	}

}

class Employee{
	
}
