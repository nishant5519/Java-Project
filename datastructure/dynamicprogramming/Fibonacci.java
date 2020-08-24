package com.datastructure.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	final Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	final int MAX = 100;
	final int NIL = -1;
	int lookup[] = new int[MAX];

	/*
	 * function for nth Fibonacci number Time Complexity: O(n) Extra Space: O(n)
	 * f0=0,f1=1...
	 */
	int DPfib1(int n) {
		if (n <= 1)
			lookup[n] = n;
		if (lookup[n] != -1)
			return lookup[n];
		lookup[n] = DPfib1(n - 1) + DPfib1(n - 2);
		return lookup[n];
	}

	void _initialize() {
		for (int i = 0; i < MAX; i++)
			lookup[i] = NIL;
	}

	//f1=1,f2=1..
	int DPfib2(int n) {
		if (n <= 2)
			lookup[n] = 1;
		if (lookup[n] != 0)
			return lookup[n];
		lookup[n] = DPfib2(n - 1) + DPfib2(n - 2);
		return lookup[n];
	}

	// Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential,O(2^n)
	// Extra Space: O(n) if we consider the function call stack size, otherwise
	// O(1).
	int recursiveFib(int n) {
		if (n <= 1)
			return n;
		return recursiveFib(n - 1) + recursiveFib(n - 2);
	}
	
	
	private int fib(int N) {
	    if (cache.containsKey(N)) {
	      return cache.get(N);
	    }
	    int result;
	    if (N < 2) {
	      result = N;
	    } else {
	      result = fib(N-1) + fib(N-2);
	    }
	    // keep the result in cache.
	    cache.put(N, result);
	    return result;
	  }
	public static void main(String[] args) {
		
		Fibonacci f = new Fibonacci();
		int n = 3;
		f._initialize();
		System.out.println("Fibonacci number using DP is: " + f.DPfib1(n));
		System.out.println("Fibonacci number using recursion is: " + f.recursiveFib(n));
	}

}