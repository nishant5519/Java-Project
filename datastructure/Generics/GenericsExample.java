package Generics;

public class GenericsExample {

	public static void main(String[] args) {
		// instance of Integer type
		TestGenericsExample<Integer> iObj = new TestGenericsExample<Integer>(15);
		System.out.println(iObj.getObject());

		// instance of String type
		TestGenericsExample<String> sObj = new TestGenericsExample<String>("GeeksForGeeks");
		System.out.println(sObj.getObject());
		
		System.out.println("=============================");
		
		TestMultipleType <String, Integer> obj = 
	            new TestMultipleType<String, Integer>("GfG", 15); 
	  
	        obj.print();
	        
	    System.out.println("=============================");
	    
	    // Calling generic method with Integer argument 
        genericDisplay(11); 
   
        // Calling generic method with String argument 
        genericDisplay("GeeksForGeeks"); 
   
        // Calling generic method with double argument 
        genericDisplay(1.0); 
			    
	}
	
	 // A Generic method example 
    static  <T> void genericDisplay (T element) 
    { 
        System.out.println(element.getClass().getName() + 
                           " = " + element); 
    } 

}

class TestGenericsExample<T> {
	T obj;

	TestGenericsExample(T obj) {
		this.obj = obj;
	} 

	public T getObject() {
		return this.obj;
	}
}

class TestMultipleType<T, U> 
{ 
    T obj1;  // An object of type T 
    U obj2;  // An object of type U 
  
    TestMultipleType(T obj1, U obj2) 
    { 
        this.obj1 = obj1; 
        this.obj2 = obj2; 
    } 
  
    // To print objects of T and U 
    public void print() 
    { 
        System.out.println(obj1); 
        System.out.println(obj2); 
    } 
} 