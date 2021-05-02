package cloning;

public class DeepCloningTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		TestClonable t1 = new TestClonable();
	       t1.a = 10;
	       t1.b = 20;
	       t1.c.x = 30;
	       t1.c.y = 40;
	 
	       TestClonable t2 = (TestClonable)t1.clone();
	       t2.a = 100;
	 
	       // Change in primitive type of t2 will not
	       // be reflected in t1 field
	       t2.c.x = 300;
	 
	       // Change in object type field of t2 will not
	       // be reflected in t1(deep copy)
	       System.out.println(t1.a + " " + t1.b + " " +
	                          t1.c.x + " " + t1.c.y);
	       System.out.println(t2.a + " " + t2.b + " " +
	                          t2.c.x + " " + t2.c.y);}
}

//An object reference of this class is
//contained by Test2
class Test
{
 int x, y;
}


//Contains a reference of Test and implements
//clone with deep copy.
class TestClonable implements Cloneable
{
 int a, b;

 Test c = new Test();

 public Object clone() throws
             CloneNotSupportedException
 {
     // Assign the shallow copy to new reference variable t
     TestClonable t = (TestClonable)super.clone();

     t.c = new Test();

     // Create a new object for the field c
     // and assign it to shallow copy obtained,
     // to make it a deep copy
     return t;
 }
}
