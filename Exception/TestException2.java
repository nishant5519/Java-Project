package Exception;

public class TestException2 {

	public static void defectedCode() {

		throw new Error();
	}

	public static void main(String args[]) {

		try {
			defectedCode();
			System.out.println("A");

		} catch (Exception e) { //Exception is unable to catch Error. Only Throwable could catch it. 

			System.out.println("B");

		} 
		catch(Throwable e){//this would work

	        System.out.println("B");

	    }
		finally {

			System.out.println("C");
		}
		System.out.print("D");
	}

}
