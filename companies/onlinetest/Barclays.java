package companies.onlinetest;

import java.util.TreeSet;

public class Barclays implements Runnable {
	Integer id = 1;

	public static void main(String[] args) {
		/*int j = 2, y = 3, z = 10;
		for (; j < 6; j++) {
			y = (++y + z++);
			System.out.println(y + z);
		}

		new Thread(new Barclays()).start();
		new Thread(new Barclays()).start();
		new Thread(new Barclays()).start();*/

		System.out.println("=======================");
		int a = 5;
		int b = 10;
		first: {
			second: {
				if (a == b >> 1)
					break first;
			}
			System.out.println("Value of a:" +a);
		}
		System.out.println("Value of b:" + b);
		
		System.out.println("=======================");
		
		TreeSet t =new TreeSet();
		
	t.add(new StringBuffer("H"));
	t.add(new StringBuffer("A"));
	t.add(new StringBuffer("C"));
	t.add(new StringBuffer("K"));
	System.out.println(t);
	}

	@Override
	public void run() {
		press(id);
	}

	synchronized void press(Integer id) {
		System.out.println(id.intValue());
		System.out.println((++id).intValue());
	}

}
