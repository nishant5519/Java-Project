package com.ObjectOrientedPrinciples;

public class OverloadingExamples {

	public static void main(String[] args) {
		OverloadedMethods obj = new OverloadedMethods();
		obj.add(1, 2);
		int result = obj.add(1, 2, 3);
		System.out.println(result);
		///////////////
		obj.test1(null);
		////////////
		// obj.test2(null); AMBIGUOUS
		///////////
		obj.test3(null); // C2
		////////////
		// obj.test4(null, null); AMBIGUOUS
		///////////////////
//		obj.test5(null);    AMBIGUOUS
		////////////
//		obj.test6(null);   AMBIGUOUS
		//////////////////
		obj.test7(1);    //Because Widening wins over Boxing.
		obj.test8('a');
		obj.test9('x'); //Methods with varargs (...) have the lowest priority.Priority goes as Widening --> Boxing --> Var args.
        obj.test9(97);
	}

}

class OverloadedMethods {
	public void add(int num1, int num2) {
		System.out.println(num1 + num2);
	}

	public int add(int num1, int num2, int num3) {
		int result = num1 + num2 + num3;
		return result;
	}

	///////////////
	public void test1(String str) {
		System.out.println("String");
	}

	public void test1(Object obj) {
		System.out.println("Object");
	}

	//////////////
	public void test2(String str) {
		System.out.println("String");
	}

	public void test2(StringBuffer obj) {
		System.out.println("Object");
	}

	//////////////
	public void test3(B2 obj) {
		System.out.println("B2");
	}

	public void test3(C2 obj) {
		System.out.println("C2");
	}

	//////////////
	public void test4(String obj1, Object obj2) {
		System.out.println("B");
	}

	public void test4(Object obj1, String obj2) {
		System.out.println("C");
	}

	//////////////
	public void test5(int[] intArr) {
		System.out.println("int array");
	}

	public void test5(char[] charArr) {
		System.out.println("char array");
	}

	//////////////
	public void test6(Object obj) {
        System.out.println("Object");
    }
    public void test6(char[] obj) {
        System.out.println("Char");
    } 
    public void test6(Integer obj) {
        System.out.println("Int");
    } 
	//////////////
    public void test7(long lng) {
        System.out.println("Long");
    }
      
    public void test7(Integer integer) {
        System.out.println("Integer");
    }
      
	//////////////
    public void test8(char obj) {
        System.out.println("Char");
    }
    public void test8(int obj) {
        System.out.println("Int");
    } 
	//////////////
    public void test9(int i) {
        System.out.println("Int");
    }
    public void test9(char... c) {
        System.out.println("Char varargs");
    } 
    //////////////This is not overloading but duplicate methods
    /*public boolean test10(int i) {
        return true;
    }
    public int test10(int i) {
        return 1;
    } */
}

class A2 {
}

class B2 extends A2 {
}

class C2 extends B2 {
}
