package com.concurrency.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureTest {

	public static void main(String[] args) {
		CompletableFuture<String> completableFuture = calculateAsync();

		try {
			String result = completableFuture.get();
			System.out.println(result);
			System.out.println(Thread.currentThread().getName());
			System.out.println("------------------------------------");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private static CompletableFuture<String> calculateAsync() {
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
		List<String> list = new ArrayList<>();
		list.add("AB");
		list.add("KK");
		list.add("CC");
		Executors.newCachedThreadPool().submit(() -> {
			try {
				Thread.sleep(20);
				String joinStr = String.join(",", list);
				System.out.println(Thread.currentThread().getName());
				completableFuture.complete(joinStr);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return null;
		});
		return completableFuture;
		
	}

}
