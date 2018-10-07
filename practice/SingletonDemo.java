package com.practice;

public class SingletonDemo {
	static SingletonClass obj1 = null;
	static SingletonClass obj2 = null;

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				obj1 = SingletonClass.getInstance();
			}

		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj2 = SingletonClass.getInstance();
			}

		});

		t1.start();		
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println(obj1.equals(obj2));

	}

}
