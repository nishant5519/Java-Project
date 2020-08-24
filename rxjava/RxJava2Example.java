package com.rxjava;

import java.util.Observable;
import java.util.function.Consumer;

public class RxJava2Example {

	public static void main(String[] args) {
		//producer
  //      Observable<String> observable = Observable.just("how", "to", "do", "in", "java");

        //consumer
        Consumer<? super String> consumer = System.out::println;

        //Attaching producer to consumer
 //       observable.subscribe(consumer);
	}

}
