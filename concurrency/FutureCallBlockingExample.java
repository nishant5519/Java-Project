package com.concurrency.completionservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallBlockingExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MultiplyingTask multiplyingTask1= new MultiplyingTask("Task 1",10,20,8000l);
		MultiplyingTask multiplyingTask2= new MultiplyingTask("Task 2",30,40,4000l);
		MultiplyingTask multiplyingTask3= new MultiplyingTask("Task 3",40,50,3000l);
		MultiplyingTask multiplyingTask4= new MultiplyingTask("Task 4",50,60,1000l);
		
		ExecutorService executors=Executors.newFixedThreadPool(4);
		
		List<Future<Integer>> listOfFuture=new ArrayList<Future<Integer>>();
		listOfFuture.add(executors.submit(multiplyingTask1)); //calls call() of Callable Interface
		listOfFuture.add(executors.submit(multiplyingTask2));
		listOfFuture.add(executors.submit(multiplyingTask3));
		listOfFuture.add(executors.submit(multiplyingTask4));
		
		for (Future<Integer> future : listOfFuture) {
			Integer i=future.get();
			System.out.println("Result: " +i);
		}
		executors.shutdown();
	}

}
