package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Test_code {
	public static void main(String[] args) {
		/*People emp1 = new People(23);
		People emp2 = new People(23);
		System.out.println("emp1.equals(emp2)--->>>"+emp1.equals(emp2));
		System.out.println("emp1" + emp1);
		System.out.println("emp2" + emp2);*/
		Integer i1=1000;
		Integer i2=1000;
		Integer i3=10;
		Integer i4=10;
		System.out.println(i1!=i2); //True
		System.out.println(i1==i2); //False
		System.out.println(i1.equals(i2)); //True
		System.out.println(i3!=i4); //False
		System.out.println(i3==i4); //True
		System.out.println(i3.equals(i4)); //True
		
		People emp1 = new People(23);
		People emp2 = new People(23);
		People emp3 = new People(25);
		People emp4 = new People(26);
		People emp5 = new People(27);
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
		System.out.println(emp4);
		System.out.println(emp5);
		HashSet<People> hs = new HashSet<People>();
		hs.add(emp1);
		hs.add(emp2);
		hs.add(emp3);
		hs.add(emp4);
		hs.add(emp5);
		
		System.out.println("HashSet Size--->>>"+hs.size());
		System.out.println("hs.contains( new Emp(25))--->>>"+hs.contains(emp3));
		System.out.println("hs.remove( new Emp(24)--->>>"+hs.remove(emp2));
		System.out.println("Now HashSet Size--->>>"+hs.size());
		
		
		List<Integer> L = new LinkedList<Integer>();
	    L.add(0);
	    L.add(1);
	    L.add(2);
	    for (ListIterator<Integer> i = L.listIterator(); i.hasNext(); ) {
	      int x = i.next();
	      i.add(10);
	    }
	    System.out.println(L);
	  
	
	List<Integer> intlist=new ArrayList<Integer>();
	intlist.add(1);
	intlist.add(2);
	intlist.add(3);
	intlist.add(4);
	intlist.add(5);
	intlist.add(6);
	
	Iterator<Integer> itr=intlist.iterator();
	//ListIterator listitr=intlist.listIterator();
	for(Integer i: intlist){
		System.out.println("Print list using Iterator : "+ i);
	}
	

	ListIterator<Integer> listitr=intlist.listIterator();
	//ListIterator listitr=intlist.listIterator();
//	System.out.println(listitr.next());
	//System.out.println(listitr.previous());
	//listitr.add(7);

 /*for(Integer i:intlist){	 
	 listitr.next();
		listitr.add(8);
 }*/
	while(listitr.hasNext()){	
		listitr.next();
		listitr.add(7);
	
	}
	System.out.println("Print list using ListIterator : "+ intlist);
	
	}

}

class People {
	int age;

	People(int a) {
		this.age = a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;		
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (age != other.age)
			return false;
		return true;
	}

		
	/*public int hashCode() {
		return age;
	}

	public boolean equals(Object obj) {
		boolean flag = false;
		People p1 = (People) obj;
		if (p1.age == age)
			flag = true;
		return flag;
	}*/
}