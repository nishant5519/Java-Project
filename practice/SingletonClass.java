package com.practice;

import java.io.Serializable;

import com.cloning.SuperClass;

public class SingletonClass extends SuperClass implements Serializable {
	/**
	 * http://thecodersbreakfast.net/index.php?post/2011/05/12/Serialization-and-magic-methods
	 */
	private static final long serialVersionUID = 1L;
	
	private static volatile SingletonClass singletonObj = null;//cannot make it final because then this will behave as constant

	private SingletonClass() {
		/*
		 * if(singletonObj!=null)//changes to avoid creation of object using reflection
		 * throw new RuntimeException("Create Object using getInstance() method only");
		 */
	}

	public static SingletonClass getInstance() {
		if (singletonObj == null)
			synchronized (SingletonClass.class) {
				if (singletonObj == null) {
					singletonObj = new SingletonClass();
				}
			}

		return singletonObj;
	}

	// implement readResolve method.Called while Deserialization
	protected Object readResolve() {
		return singletonObj;
	}
	private Object writeReplace(){
		System.out.println("writeReplace");
        return this;		
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		//Now we have stopped user to create clone of singleton class. If you don't want to throw 
		//exception you can also return the same instance from clone method.
	//	throw new CloneNotSupportedException();
		return singletonObj;
	}
}
