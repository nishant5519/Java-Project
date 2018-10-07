package com.datastructure.sorting;

public class SelectionSort {

	/*
	 * Time Complexity: O(n2) as there are two nested loops.
	 * Auxiliary Space: O(1) The good thing about selection sort is it never
	 * makes more than O(n) swaps and can be useful when memory write is a
	 * costly operation.
	 */

	public static void main(String[] args) {
		int maxSize = 100; // array size
		ArraySel arr; // reference to array
		arr = new ArraySel(maxSize); // create the array
		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		arr.display(); // display items
		arr.selectionSort(); // selection-sort them
		arr.display(); // display them again
	}

}

class ArraySel {
	private long[] a; // ref to array a
	private int nElems; // number of data items

	// --------------------------------------------------------------

	public ArraySel(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++)
			// for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println(" ");
	}

	// --------------------------------------------------------------
	public void selectionSort() {
		int out, in, min;
		for (out = 0; out < nElems - 1; out++) // outer loop
		{
			min = out; // minimum
			for (in = out + 1; in < nElems; in++)
				// inner loop
				if (a[min] > a[in]) // if min greater,
					min = in; // we have a new min
			System.out.println(a[min]);
			swap(out, min); // swap them
		} // end for(out)
	} // end selectionSort()
		// --------------------------------------------------------------

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
		display();
	}
	// --------------------------------------------------------------
}