package ObjectOrientedPrinciples;

import java.util.HashSet;
import java.util.TreeSet;

class Example1 {
	public static void main(String[] args) {
		AppleFruit apple = new AppleFruit();
		int pieces = apple.peel();
		HashSet set = new HashSet();
		set.add("hungary");
		TreeSet abc = new TreeSet();
		abc.add("tree");
	}

}

class Fruits {
	// Return int number of pieces of peel that
	// resulted from the peeling activity.
	public Peel peel() {
		System.out.println("Peeling is appealing.");
		return new Peel(1);
	}
}

/*
 * class AppleFruit extends Fruits { }
 */

class AppleFruit {
	private Fruits fruit = new Fruits();

	public int peel() {
		Peel peel = fruit.peel();
		return peel.getPeelCount();
	}
}

class Peel {
	private int peelCount;

	public Peel(int peelCount) {
		this.peelCount = peelCount;
	}

	public int getPeelCount() {
		return peelCount;
	}
	// ...
}