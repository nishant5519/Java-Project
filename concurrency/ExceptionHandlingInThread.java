package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExceptionHandlingInThread {
//This is not possible in Runnable task as Runnable does not throws any exception.
	public static void main(String[] args) {
		MyTask task = new MyTask(2, 0);
		ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
		Future<Integer> future=threadExecutor.submit(task);
		threadExecutor.shutdown();//Shutdown after submitting the task

		try {
			int result = future.get();
			System.out.println("The result is " + result);
		} catch (ExecutionException e) {
			if (e.getMessage().contains("cannot divide by zero"))
				System.out.println("Error in child thread caused by zero division");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class MyTask implements Callable<Integer> {

	private int numerator;
	private int denominator;

	public MyTask(int n, int d) {
		this.numerator = n;
		this.denominator = d;
	}

	// The call method may throw an exception
	public Integer call() throws Exception {
		if (denominator == 0)
			throw new Exception("cannot divide by zero");
		else
			return numerator / denominator;
	}
}