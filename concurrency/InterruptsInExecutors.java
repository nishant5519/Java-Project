package concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InterruptsInExecutors {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		Future<?> future = es.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Random ran = new Random();

				for (int i = 0; i < 1E8; i++) {

					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted!");
						break;
					}
					Math.sin(ran.nextDouble());

				}
				return null;
			}
		});
		es.shutdown();
	//	future.cancel(true); or es.shutdownNow()  same result
		es.shutdownNow();
		System.out.println("Finished..");
	}

}
