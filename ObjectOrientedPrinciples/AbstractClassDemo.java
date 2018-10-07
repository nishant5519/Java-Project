package com.ObjectOrientedPrinciples;

public class AbstractClassDemo {

	public static void main(String[] args) {

	}

}

 abstract class Bank {

	public void deposit() {
		System.out.println("Deposit in Bank");
	}
	
	public void withDraw(){
		System.out.println("Wihdraw from Bank");
	}
	abstract int calInterest();
}