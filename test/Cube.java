package com.test;

public class Cube {
	
	
	public static void main(String[] args) {
		System.out.println(rowSumOddNumbers(3));
	}
	private int value;

	/**
	 * @return
	 */
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public static int rowSumOddNumbers(int n) {
		 int sum=0;
		   
	        for(int i=0;i<n;i++){
	        	 sum=sum + (n*n+1-n) + 2*i;
	        }
	        return sum;
	    }
	
}


