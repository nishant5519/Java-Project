package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SuperClassSerializableButSubclassShudNot {

	public static void main(String[] args) {
		D b1 = new D(10, 20);
        
        System.out.println("i = " + b1.i);
        System.out.println("j = " + b1.j);
         
        // Serializing D's(subclass) object 
         try{
        //Saving of object in a file
        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
             
        // Method for serialization of D's class object
        oos.writeObject(b1);
             
        // closing streams
        oos.close();
         }
         catch (FileNotFoundException e) {
 			// TODO SuperClassAuto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO SuperClassAuto-generated catch block
 			e.printStackTrace();
 		}
             
        System.out.println("Object has been serialized");
         D d2=null;
        // De-Serializing D's(subclass) object 
         try{
        // Reading the object from a file
        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
             
        // Method for de-serialization of D's class object
         d2 = (D)ois.readObject();
             
        // closing streams
        ois.close();
        fis.close();
             
         }
         catch (FileNotFoundException e) {
 			// TODO SuperClassAuto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO SuperClassAuto-generated catch block
 			e.printStackTrace();
 		} catch (ClassNotFoundException e) {
 			// TODO SuperClassAuto-generated catch block
 			e.printStackTrace();
 		}
        System.out.println("Object has been deserialized");
         
        System.out.println("i = " + d2.i);
        System.out.println("j = " + d2.j);
	}

}

//superclass C 
//implementing Serializable interface
class C implements Serializable
{
 int i;
  
 // parameterized constructor
 public C(int i) 
 {
     this.i = i;
 }
  
}

//subclass D 
//D class doesn't implement Serializable
//interface.
class D extends C
{
 int j;
  
 // parameterized constructor
 public D(int i,int j) 
 {
     super(i);
     this.j = j;
 }
  
 // by implementing writeObject method, 
 // we can prevent
 // subclass from serialization
 private void writeObject(ObjectOutputStream out) throws IOException
 {
     throw new NotSerializableException();
 }
  
 // by implementing readObject method, 
 // we can prevent
 // subclass from de-serialization
 private void readObject(ObjectInputStream in) throws IOException
 {
     throw new NotSerializableException();
 }
  
}