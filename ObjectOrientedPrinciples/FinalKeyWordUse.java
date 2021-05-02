package ObjectOrientedPrinciples;

import java.util.LinkedList;
import java.util.List;

public class FinalKeyWordUse {

	public static void main(String[] args) {
		AirCondition ac = new AirCondition();
		ac.cool();
	//	ac.temp=15; Not allowed
		ac.list.add("Copper Coil");
		System.out.println(ac.list);
		
		
		AirCondition inverterac=new InverterAC();
		inverterac.list.add("Inverter tech");
		System.out.println(inverterac.list);
		inverterac.cool();

	}

}

final class Coolers {
	int fan = 4;

	void cool() {
		System.out.println("My job is to cool");
	}
}

class AirCondition {
	final int temp = 25;
	final List<String> list = new LinkedList<String>();

	void cool() {
		list.add("Condensor");
		list.add("Compressor");
		System.out.println("Does cooling without water");
	}
}

class InverterAC extends AirCondition {
	void inverterCooling() {
		System.out.println("Cools and cosume less power");
	}

	void cool() {
		System.out.println("Inverter cooling");
	}
}