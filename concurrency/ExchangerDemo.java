package com.concurrency;

import java.util.concurrent.Exchanger;

/*It creates two threads. One thread
creates an empty buffer that will receive the data put into it by the second thread. Thus,
the first thread exchanges an empty thread for a full one.*/

public class ExchangerDemo {
	public static void main(String[] args) {
		Exchanger<String> exgr = new Exchanger<String>();
		new UseString(exgr);//same exchanger object should be used.
		new MakeString(exgr); 
	}

}

// A Thread that constructs a string.The MakeString class fills a string with data
class MakeString implements Runnable {
	Exchanger<String> ex;
	String str;

	MakeString(Exchanger<String> c) {
		ex = c;
		str = new String();
		new Thread(this).start();
	}

	public void run() {
		char ch = 'A';
		for (int i = 0; i < 3; i++) {
			// Fill Buffer
			for (int j = 0; j < 5; j++)
				str += ch++;
			System.out.println("Produced : "+ str);
			try {
				// Exchange a full buffer for an empty one.
				str = ex.exchange(str);
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}

// A Thread that uses a string.
class UseString implements Runnable {
	Exchanger<String> ex;
	String str;

	UseString(Exchanger<String> c) {
		ex = c;
		new Thread(this).start();
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				// Exchange an empty buffer for a full one.
				str = ex.exchange(new String());
				System.out.println("Got: " + str);
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}