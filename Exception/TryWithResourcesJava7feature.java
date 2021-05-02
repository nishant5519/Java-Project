package Exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Important Points:

Java provides a feature to make the code more robust and to cut down the lines of code. This feature is known as Automatic Resource Management(ARM) using
 try-with-resources from Java 7 onwards. The try-with-resources statement is a try statement that declares one or more resources.
This statement ensures that each resource is closed at the end of the statement which eases working with external resources that need to be disposed or closed in case of 
errors or successful completion of a code block.

What is a resource?
A resource is an object that must be closed after the program is finished using it. Any object that implements java.lang.AutoCloseable, which includes all objects which 
implement java.io.Closeable, can be used as a resource.

In try-with-resources method there is no use of finally block. the file resource is opened in try block inside small brackets. Only the objects of those classes can be 
opened within the block which implements AutoCloseable interface and those object should also be local. The resource will be closed automatically regardless of whether 
try statement completes normally or abruptly.

finally blocks were used to cleanup the resources before Java 7.
After java 7, resource cleanup is done automatically.
ARM is done when you initialize resource in try-with-resources block because of the interface AutoCloseable. Its close method is invoked by JVM as soon as try block 
finishes.
Calling close() method might lead to unexpected results.
Resource that we use in try-with-resource must be subtypes of AutoCloseable to avoid compile time error.
The resources which are used in multiple resource ARM must be closed in reverse order as given in above example
*/
public class TryWithResourcesJava7feature {

	public static void main(String[] args) {
		BufferedReader br = null;
		String str = " ";
		System.out.println("Enter the file path");
		br = new BufferedReader(new InputStreamReader(System.in));

		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * try { String s; br = new BufferedReader(new FileReader(str));
		 * 
		 * while ((s = br.readLine()) != null) { System.out.println(s); } }
		 * catch (IOException e) { e.printStackTrace(); }
		 * 
		 * finally { try { if (br != null) br.close(); } catch (IOException ex)
		 * { ex.printStackTrace(); } }
		 */
		
		
		// try with Resource
		// note the syntax difference
		try (BufferedReader b = new BufferedReader(new FileReader(str))) {
			String s;
			while ((s = b.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Another Example======================================================Another Example");
		
		//note the order of opening the resources
        try(Demo d = new Demo(); Demo1 d1 = new Demo1()) 
        {
            int x = 10/0;
            d.show();
            d1.show1();
        }
        catch(ArithmeticException e)
        {
            System.out.println(e);
        }
	}

}

// custom resource 1
class Demo implements AutoCloseable {
	void show() {
		System.out.println("inside show");
	}

	public void close() {
		System.out.println("close from demo");
	}
}

// custom resource 2
class Demo1 implements AutoCloseable {
	void show1() {
		System.out.println("inside show1");
	}

	public void close() {
		System.out.println("close from demo1");
	}
}