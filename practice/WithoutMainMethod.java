package practice;

public class WithoutMainMethod {
	 static int a;
     static {
             System.out.println("Static block1"); 
             a = 10;
     }
     static {
            System.out.println("Static block2"); 
            a = 20;
     } 
     public static void main(String[] args){
              System.out.println("Value of a is "+a) ;
              display(null);
     }
     
     public static void display(String s){
    	 System.out.println("Print messsage" + s);
     }
}
