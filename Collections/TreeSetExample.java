package com.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// Creating a TreeSet without supplying any Comparator
		TreeSet<Integer> intset = new TreeSet<Integer>();
		// Adding elements to TreeSet
		// set.add(null); null not allowed in TreeSet
		intset.add(11);
		intset.add(41);
		intset.add(7);
		intset.add(69);
		intset.add(18);
		intset.add(38);
		System.out.println(intset); // Output : [7, 11, 18, 23, 38, 41, 69]

		TreeSet<String> stringSet = new TreeSet<String>();
		stringSet.add("Z");
		stringSet.add("C");
		stringSet.add("Q");
		stringSet.add("A");
		System.out.println(stringSet);
		
		System.out.println("=================");
		System.out.println("Removing duplicates from array");
		String[] strArr = {"one","two","three","four","four","five"};
	    List<String> tmpList = Arrays.asList(strArr);
	    TreeSet<String> unique = new TreeSet<String>(tmpList);
	    System.out.println(unique);
		
	    System.out.println("=================");
		System.out.println(" create a TreeSet with a List");
		List<String> li = new ArrayList<String>();
        li.add("one");
        li.add("two");
        li.add("three");
        li.add("four");
        System.out.println("List: "+li);
        TreeSet<String> myset = new TreeSet<String>(li);
        System.out.println("Set: "+myset);
	   

	    System.out.println("=================");
		System.out.println("For custom objects using Comparable");
		Set<BookAuthorSet> set = new TreeSet<BookAuthorSet>();
		// Creating Books
		BookAuthorSet b1 = new BookAuthorSet(121, "Let us C", "Yashwant Kanetkar",
				"BPB", 8);
		BookAuthorSet b2 = new BookAuthorSet(233, "Operating System", "Galvin",
				"Wiley", 6);
		BookAuthorSet b3 = new BookAuthorSet(101, "Data Communications & Networking",
				"Forouzan", "Mc Graw Hill", 4);
		set.add(b1);
		set.add(b2);
		set.add(b3);
		for (BookAuthorSet b : set)
			System.out.println(b.id + " " + b.name + " " + b.author + " "
					+ b.publisher + " " + b.quantity);
		
		
		System.out.println("=================");
		System.out.println("For objects using Comparator");
		TreeSet<String> ts = new TreeSet<String>(new MyComp());
	    ts.add("RED");
	    ts.add("ORANGE");
	    ts.add("BLUE");
	    ts.add("GREEN");
	    System.out.println(ts);
	    
	    
	    System.out.println("=================");
		System.out.println("For custom objects using Comparator"); 
	    
	    //By using name comparator (String comparison)
        TreeSet<Empl> nameComp = new TreeSet<Empl>(new MyNameComp());
        nameComp.add(new Empl("Ram",3000));
        nameComp.add(new Empl("John",6000));
        nameComp.add(new Empl("Crish",2000));
        nameComp.add(new Empl("Tom",2400));
        for(Empl e:nameComp){
            System.out.println(e);
        }
        System.out.println("===========================");
        //By using salary comparator (int comparison)
        TreeSet<Empl> salComp = new TreeSet<Empl>(new MySalaryComp());
        salComp.add(new Empl("Ram",3000));
        salComp.add(new Empl("John",6000));
        salComp.add(new Empl("Crish",2000));
        salComp.add(new Empl("Tom",2400));
        //Adding duplicate
        salComp.add(new Empl("John",2400));
        for(Empl e:salComp){
            System.out.println(e);
        }
        
        System.out.println("===========================");
        
        Set treeset=new TreeSet();
        treeset.add(1);
        treeset.add(7);
        treeset.add("abc");//Gives exception ClassCastException at runtime
        System.out.println("Output of non-generic treeset is: " + treeset);
        

	}
}

class BookAuthorSet implements Comparable<BookAuthorSet> {
	int id;
	String name, author, publisher;
	int quantity;

	public BookAuthorSet(int id, String name, String author, String publisher,
			int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	@Override
	public int compareTo(BookAuthorSet b) {
		if (id > b.id) {
			return 1;
		} else if (id < b.id) {
			return -1;
		} else {
			return 0;
		}
	}

}

class MyComp implements Comparator<String>{
	 
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
     
} 


class MyNameComp implements Comparator<Empl>{
	 
    @Override
    public int compare(Empl e1, Empl e2) {
        return e1.getName().compareTo(e2.getName());
    }
}   
 
class MySalaryComp implements Comparator<Empl>{
 
    @Override
    public int compare(Empl e1, Empl e2) {
    	if(e1.getSalary()==e2.getSalary())
    		return 0;
        if(e1.getSalary() > e2.getSalary()){
            return 1;
        } else {
            return -1;
        }
    }
}
 
class Empl{
     
    private String name;
    private int salary;
     
    public Empl(String n, int s){
        this.name = n;
        this.salary = s;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String toString(){
        return "Name: "+this.name+"-- Salary: "+this.salary;
    }
}
