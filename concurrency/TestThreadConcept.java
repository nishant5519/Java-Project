package concurrency;

public class TestThreadConcept {

	public static void main(String[] args) throws InterruptedException {
		synchronized (args) {
			System.out.println("Inside Syn block");
			args.wait();
		}
		System.out.println("Main method completes");

	}

}
