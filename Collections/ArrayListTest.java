package Collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		/*
		 * list.add(2); list.add(10); list.add(11); list.add(12); list.add(3,4);
		 */
		list.remove(5);
		list.remove(new Integer(5));

		/*
		 * for(Integer num:list){ list.add(10); //throws
		 * java.util.ConcurrentModificationException because for each uses iterator
		 * internally. }
		 * 
		 * for(int i=0;i<5;i++) list.add(11);//does not throw exception.
		 * 
		 * 
		 * Iterator<Integer> itr=list.iterator(); while(itr.hasNext()){
		 * System.out.println(itr.next()); list.add(12); }
		 */

		System.out.println(list);

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(5);
		list1.add(6);
		list1.add(7);
		list1.add(8);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(5);
		list2.add(6);
		list2.add(7);
		list2.add(9);
		
		System.out.println(list1.equals(list2));

	/*	for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).equals(list2.get(i)));
			if (!list1.get(i).equals(list2.get(i)))
				System.out.println("False");
		}
		System.out.println("True");*/
	}

}
