package com.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemoExample {
	public static void main(String[] args) {
		CyclicBarrier cb=new CyclicBarrier(3);
		new DemoThread(cb,"A");
		new DemoThread(cb,"B");
		new DemoThread(cb,"C");
		int i=5;
		System.out.println("Value of returned number: " +counter(i));
		String s="AB- Auto";  
		   System.out.println(s.substring(6));//Tendulkar  
		   System.out.println(s.substring(0,2));//Sachin  
		
		

	}
	
	static int counter(int a){
		for(int i=0;i<a;)
			return 1;
		return 5;
		
	}

}

class DemoThread implements Runnable{
	CyclicBarrier cbar;
	String n;
	public DemoThread(CyclicBarrier cb,String name){
		this.cbar=cb;
		this.n=name;
		new Thread(this).start();
	}
	@Override
	public void run() {
		try {
			cbar.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Work implements Runnable {
	public void run() {
		System.out.println("Running inside run method");

	}
}

