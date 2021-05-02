package test;

public class TestThread {

	
	public static void main(String[] args) {
		countRunnable cr=new countRunnable();
		Thread t1=new Thread(cr);
		Thread t2=new Thread(cr);
		t1.start();		
		t2.start();
	}

}

class countRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0;;i++){
			System.out.println(Thread.currentThread() + "-" + i);
		}
	}
	
}
