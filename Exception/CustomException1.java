package Exception;

public class CustomException1 {

	public static void main(String[] args) {
		int a=5;
		int b=2;
		double p=7;
		try{
			int c=a/b;
			System.out.println(p/0);
			throw new MyException("Result cannot be float");
		}
		catch(MyException e){
			System.out.println("Inside catch block " + e);
			//e.printStackTrace();
		}
	}

}

class MyException extends Exception {

	public MyException() {
		super();
	}

	MyException(String str) {
		super(str);
	}
}
