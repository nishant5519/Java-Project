package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import practice.SingletonClass;

//Overcome serialization issue:- To overcome this issue, we have to implement method readResolve() method.
public class BreakSingletonUsingSerialization {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		SingletonClass instance1 = SingletonClass.getInstance();
		SingletonClass instance2 = null;
		ObjectOutput out;
		out = new ObjectOutputStream(new FileOutputStream("file.text"));
		out.writeObject(instance1);
		out.close();
		// deserialize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
		instance2 = (SingletonClass) in.readObject();
		in.close();
		System.out.println("instanceOne hashCode="+instance1.hashCode());
        System.out.println("instanceTwo hashCode="+instance2.hashCode());
	}

}
