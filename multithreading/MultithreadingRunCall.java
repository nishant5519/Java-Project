package multithreading;

public class MultithreadingRunCall {
	private static MultithreadingRunCall synchronizationExample = null;

	public static void main(String[] args) {

		Thread t = new Thread(() -> System.out.println("Run method executed by " + Thread.currentThread().getName()));
		t.start();//t.run() will also execute the run method but not in separate thread but in main thread
		hello();
	}

	private static void hello() {
		synchronized (synchronizationExample) {
			System.out.println("Inside synchronized block");
		}

	}
}