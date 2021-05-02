package Collections;

import java.util.HashSet;
import java.util.Set;

public class ListWithCustomObject {

	public static void main(String[] args) {
	//	List<vehicle> list = new ArrayList<>();
		Set<vehicle> set = new HashSet<>();
		vehicle v1 = new vehicle("figo","petrol");
		vehicle v2 = new vehicle("figo","petrol");
		set.add(v1);
		set.add(v2);
		
		System.out.println(set);
		
	}

}

class vehicle{
	
	String name;
	String model;
	
	public vehicle(String name, String model) {
		this.name=name;
		this.model=model;
	}

	@Override
	public String toString() {
		return "vehicle [name=" + name + ", model=" + model + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		vehicle other = (vehicle) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
