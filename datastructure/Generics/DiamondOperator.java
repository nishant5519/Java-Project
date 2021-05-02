package Generics;

public class DiamondOperator<T> {
	 public DiamondOperator(T t) { }
	   public T get() { return null; }

	   public static int f(String s) { return 1; }
	   public static int f(Object o) { return 2; }

	public static void main(String[] args) {
		System.out.println(f(new DiamondOperator<>("").get()));
	      System.out.println(f(new DiamondOperator("").get()));
	}

}


