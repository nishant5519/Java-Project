package com.Exception;

class TestException {
	public static void main(String args[]) {
		try {
			
				System.out.println(divide(4,0));
				System.out.println("going to divide");
				int b = 39 / 0;
			

		
				int a[] = new int[5];
				a[5] = 4;
			
			try {
				if(true)
					throw new ArithmeticException("not valid");  
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}

			System.out.println("other statement");
		} catch (Exception e) {
			System.out.println("handled in exception block: " + e.getMessage());
		}

		System.out.println("normal flow..");
	}



public static int divide(int a,int b){
	int c=-1;
	try{
		c=a/b;
	}
	catch(Exception e){
		System.err.print("Exception");
	}
	finally{
		System.err.print("Finally");
	}
	return c;
}
}

