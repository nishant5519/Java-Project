package com.companies.onlinetest;

public class IHSMarkitThread {

	public static void main(String[] args) throws InterruptedException {
		ThreadTest test=new ThreadTest();
		Thread t=new Thread(test);
		String x="ab";
		synchronized (x) {
			t.start();
			Thread.sleep(2000);
			System.out.println("Inside main");
		}
	}

}

class ThreadTest implements Runnable{
	String s="abc";
	@Override
	public void run() {
		synchronized (s) {
			System.out.println("Inside ThreadTest class");
		}
	}
	
}
