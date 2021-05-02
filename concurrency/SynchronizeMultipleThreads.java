package concurrency;

public class SynchronizeMultipleThreads {

	public static void main(String[] args) {
		ResourceLock lock = new ResourceLock();

		ThreadA1 a = new ThreadA1(lock);
		ThreadB2 b = new ThreadB2(lock);
		ThreadC3 c = new ThreadC3(lock);

		a.start();
		b.start();
		c.start();

	}

}

class ThreadA1 extends Thread {

	ResourceLock lock;

	ThreadA1(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {

				for (int i = 0; i < 100; i++) {

					while (lock.flag != 1) {
						lock.wait();
					}

					System.out.print("A ");
					Thread.sleep(1000);
					lock.flag = 2;
					lock.notifyAll();
				}

			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}

	}

}

class ThreadB2 extends Thread {

	ResourceLock lock;

	ThreadB2(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {

				for (int i = 0; i < 100; i++) {

					while (lock.flag != 2) {
						lock.wait();
					}

					System.out.print("B ");
					Thread.sleep(1000);
					lock.flag = 3;
					lock.notifyAll();
				}

			}
		} catch (Exception e) {
			System.out.println("Exception 2 :" + e.getMessage());
		}

	}
}

class ThreadC3 extends Thread {

	ResourceLock lock;

	ThreadC3(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {

				for (int i = 0; i < 100; i++) {

					while (lock.flag != 3) {
						lock.wait();
					}

					System.out.print("C ");
					Thread.sleep(1000);
					lock.flag = 1;
					lock.notifyAll();
				}

			}
		} catch (Exception e) {
			System.out.println("Exception 3 :" + e.getMessage());
		}

	}
}

class ResourceLock {
	public volatile int flag = 1;
}