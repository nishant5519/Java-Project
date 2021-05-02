package immutability;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		ImmutableExample immutableExample=new ImmutableExample(10,"A",new Date(10));
		System.out.println(immutableExample);
		tryModification(immutableExample.getImmutableField1(), immutableExample.getImmutableField2(), immutableExample.getMutableField());
		System.out.println(immutableExample);
		
	}
	

	@SuppressWarnings("deprecation")
	private static void tryModification(Integer immutableField1, String immutableField2, Date mutableField) {
		immutableField1 = 10000;
		immutableField2 = "test changed";
		mutableField.setDate(20);

}
}

class ImmutableExample{
	private final Integer immutableField1;
	private final String immutableField2;
	private final Date mutableField;
	public ImmutableExample(Integer immutableField1, String immutableField2, Date mutableField) {
		this.immutableField1 = immutableField1;
		this.immutableField2 = immutableField2;
		this.mutableField = mutableField;
	}
	
	
	@Override
	public String toString() {
		return "ImmutableExample [immutableField1=" + immutableField1 + ", immutableField2=" + immutableField2
				+ ", mutableField=" + mutableField + "]";
	}


	public Integer getImmutableField1() {
		return immutableField1;
	}


	public String getImmutableField2() {
		return immutableField2;
	}


	public Date getMutableField() {
		return mutableField;
	}

	
}
