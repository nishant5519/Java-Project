package Generics;

class Foo<X> {
	Foo(X x) {
	}

	Foo<X> get(X x) {
		return this;
	}
}

public class Test {
	void test() {
		Foo<?> f1 = new Foo(1).get(""); // ok - can pass String where Object is
										// expected
//		Foo<?> f2 = new Foo<>(1).get(""); // fail - cannot pass String where
											// Integer is expected
	}
}