package concurrency;

public class PrintNaturalNumbersUsingTwoThread {

	public static void main(String[] args) {
		final NaturalCount naturalcount = new NaturalCount();
		Thread tA = new Thread(new Runnable() {

			@Override
			public void run() {
				naturalcount.counterA();
			}

		});
		Thread tB = new Thread(new Runnable() {

			@Override
			public void run() {
				naturalcount.counterB();
			}

		});
		tA.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tB.start();

	}

}

class NaturalCount {

	void counterA() {
		synchronized (this) {
			for (int i = 1;; i++) {
				System.out.println(Thread.currentThread() + "A " + "-" + i);
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	void counterB() {
		synchronized (this) {
			for (int i = 1;; i++) {
				System.out.println(Thread.currentThread() + "-" + i);
				this.notify();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}