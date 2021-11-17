package Collections;

import java.util.HashMap;
import java.util.Map;

public class CustomObjectHashMap {

	public static void main(String[] args) {
		Personality p1= new Personality("firstname1","lastname1");
		Personality p2= new Personality("firstname2","lastname2");
		
		Map<Personality,String> map = new HashMap<>();
		//collision
		map.put(p1,"First person object");
		map.put(p2,"Second person object");
		map.put(new Personality("firstname1","lastname1"), "overriding first object");
		System.out.println(map.size());
		
		System.out.println(map);
		
		for(Personality key : map.keySet()) {
			System.out.print("Key : " + key);
			System.out.println("Value : " + map.get(key));
			
		}
	}

}

class Personality{
	private String firstName;
	private String lastName;
	
	public Personality(String fn , String ln) {
		this.firstName = fn;
		this.lastName = ln;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//induce collision
	public int hashCode() {
		return 13;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}

