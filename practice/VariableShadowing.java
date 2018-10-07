package com.practice;

/*Shadowing refers to the practice in Java programming of using two variables with the same name 
within scopes that overlap. When you do that, the variable with the higher-level scope is hidden because 
the variable with lower-level scope overrides it. The higher-level variable is then “shadowed.” */
public class VariableShadowing {
	static int x;

	public static void main(String[] args) {
		x = 5;
		System.out.println("x = " + x);
		int x;
		x = 10;//here local variable shadows Class variable
		System.out.println("x = " + x);
		System.out.println("VariableShadowing.x = " + VariableShadowing.x);
	}

}
