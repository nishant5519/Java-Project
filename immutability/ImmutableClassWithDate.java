package immutability;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//for primitives and immutable object , no extra care is reqd
//for mutable objects , you need deep cloning. Always return new object in getters of mutable object. DON'T return same reference
public class ImmutableClassWithDate {
	
	public static void main(String[] args) {
		List<String> skills = new ArrayList<>();
		skills.add("Core Java");
		skills.add("String");
		skills.add("Hibernate");
		ImmutableClass im = ImmutableClass.createNewInstance(100, "test", new Date(),skills);
		System.out.println(im);
		tryModification(im.getImmutableField1(), im.getImmutableField2(), im.getMutableField() , im.getSkills());
		System.out.println(im);
	}

	private static void tryModification(Integer immutableField1, String immutableField2, Date mutableField , List<String> skills) {
		immutableField1 = 10000;
		immutableField2 = "test changed";
		mutableField.setDate(10);
		skills.add("Spring");
	}

}

final class ImmutableClass {

	private final Integer immutableField1;
	private final String immutableField2;
	private final Date mutableField;
	private final List<String> skills;

	private ImmutableClass(Integer fld1, String fld2, Date date,List<String> skl) {
		this.immutableField1 = fld1;
		this.immutableField2 = fld2;
	//	this.mutableField = new Date(date.getTime()); //this is not mandatory.Below line also works for Immutability
		this.mutableField=date;
		this.skills=skl;
	}

	public static ImmutableClass createNewInstance(Integer fld1, String fld2, Date date,List<String> skl) {
		return new ImmutableClass(fld1, fld2, date,skl);
	}

	// Provide no setter methods

	public Integer getImmutableField1() {
		return immutableField1;
	}

	public String getImmutableField2() {
		return immutableField2;
	}
	
	public List<String> getSkills() {
		return skills;
		//return new ArrayList<>(skills);
	}

	/**
	 * Date class is mutable so we need a little care here. We should not return
	 * the reference of original instance variable. Instead a new Date object,
	 * with content copied to it, should be returned.
	 */
	public Date getMutableField() {
	//	return mutableField; 					//This is always WRONG. Do not do this
		return new Date(mutableField.getTime()); //This is correct.Always return new Instance in getters of Mutable field with content of original object copied inside it.
	}

	@Override
	public String toString() {
		return "ImmutableClass [immutableField1=" + immutableField1 + ", immutableField2=" + immutableField2
				+ ", mutableField=" + mutableField + ", skills=" + skills + "]";
	}

	
}

