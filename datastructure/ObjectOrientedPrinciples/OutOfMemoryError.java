
package com.ObjectOrientedPrinciples;

public class OutOfMemoryError {

	public static void main(String[] args) {
		//1 Example
//		Integer[] array = new Integer[100000 * 100000];
		
		//2 Example
		Long maxMemory = Runtime.getRuntime().maxMemory();
		System.out.println(maxMemory);		
		int[] matrix = new int[(int) (maxMemory + 1)];
		
	
		
	}

}
