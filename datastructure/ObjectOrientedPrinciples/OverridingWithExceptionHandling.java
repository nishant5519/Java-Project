package com.ObjectOrientedPrinciples;

import java.io.FileNotFoundException;

public class OverridingWithExceptionHandling {

	public static void main(String[] args) {

	}

}

class ParentSuper {
	//
	void m1() throws Exception,NullPointerException{
		System.out.println("From parent m1()");
	}

	void m2() {
		System.out.println("From parent  m2()");
	}
	
	void m3() throws FileNotFoundException{
		System.out.println("From parent  m2()");
	}
}

class ChildSuper extends ParentSuper {
	@Override
	// no issue while throwing unchecked exception regardless of Overridden method declares which exception
	void m1() throws RuntimeException {
		System.out.println("From child m1()");
	}

	
	// compile-time error issue while throwing checked exception
/*	void m2() throws Exception {
		System.out.println("From child m2");
	}*/
	
	// compile-time error issue while throwing checked exception which is broader than the parent method
	/*void m3() throws Exception{
		System.out.println("From parent  m2()");
	}*/

}