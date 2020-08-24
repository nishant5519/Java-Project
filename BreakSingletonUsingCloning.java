package com.cloning;

import com.practice.SingletonClass;

public class BreakSingletonUsingCloning {

//	Overcome Cloning issue:- To overcome this issue, override clone() method and throw an exception from clone method that is CloneNotSupportedException. Now whenever user will try to create clone of singleton object, it will throw exception and hence our class remains singleton.
	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonClass instance1 = SingletonClass.getInstance();
		SingletonClass instance2 = (SingletonClass) instance1.clone();
	    System.out.println("instance1 hashCode: "
	                           + instance1.hashCode());
	    System.out.println("instance2 hashCode: "
	                           + instance2.hashCode()); 
	}

}
