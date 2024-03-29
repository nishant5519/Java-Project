package ObjectOrientedPrinciples;


//A Java program to demonstrate that both super class
//and subclass constructors refer to same object

//super class
class Fruit
{
 public Fruit()
 {
     System.out.println("Super class constructor");
     System.out.println("Super class object hashcode :" +
                        this.hashCode());
     System.out.println(this.getClass().getName());
 }
}

//sub class
class Apple extends Fruit
{
 public Apple()
 {
	 
     System.out.println("Subclass constructor invoked");
     System.out.println("Sub class object hashcode :" +
                        this.hashCode());
     System.out.println(this.hashCode() + "   " +
                        super.hashCode());

     System.out.println(this.getClass().getName() + "  " +
                        super.getClass().getName());
 }
}

//driver class
public class TestInterface
{
 public static void main(String[] args)
 {
     Apple myApple = new Apple();
     A a = new B();
     a.fun();  // prints A.fun()
 }
}

//file name: Main.java
class A {
static void fun() {
   System.out.println("A.fun()");
}
}

class B extends A { 
static void fun() {   
   System.out.println("B.fun()");
}
}