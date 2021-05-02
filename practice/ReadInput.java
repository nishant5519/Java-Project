package practice;

import java.io.File;
import java.util.Scanner;

public class ReadInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int myInt = scanner.nextInt();	
		String myString = scanner.next();
		System.out.println("myString is: " + myString);
		System.out.println("myInt is: " + myInt);
		int[] input=new int[myInt];
		for(int i=0;i<myInt;i++){
			input[i]=scanner.nextInt();
		}
		for(int i=0;i<myInt;i++){
			System.out.println(input[i]);
		}
	}

}
