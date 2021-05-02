package concurrency;

public class LockImplementation {

	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException {
		while (isLocked)//if isLocked is true, then wait
			wait();
		isLocked = true;
	}

	public synchronized void unlock() {
		isLocked = false;
		notify();
	}

}
