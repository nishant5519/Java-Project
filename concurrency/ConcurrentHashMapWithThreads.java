package com.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapWithThreads {

	public static void main(String[] args) {
//		Map<String, Integer> hashMap = new HashMap<>();
//		Map<String, Integer> map = Collections.synchronizedMap(hashMap);
		String[] table=new String[16];
		Map<String, Integer> map = new ConcurrentHashMap<>();
		
		MapHelper1 mapHelper1 = new MapHelper1(map);
		MapHelper2 mapHelper2 = new MapHelper2(map);
		MapHelper3 mapHelper3 = new MapHelper3(map);

		for (Map.Entry<String, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}
		System.out.println(map);
		
	}

}

class MapHelper1 implements Runnable {
	Map<String, Integer> map;

	public MapHelper1(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "MapHelper1").start();
	}

	public void run() {
		map.put("One", 1);
		try {
			System.out.println("MapHelper1 sleeping");
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

class MapHelper2 implements Runnable {
	Map<String, Integer> map;

	public MapHelper2(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "MapHelper2").start();
	}

	public void run() {
		map.put("Two", 2);
		try {
			System.out.println("MapHelper2 sleeping");
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

class MapHelper3 implements Runnable {
	Map<String, Integer> map;

	public MapHelper3(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "MapHelper3").start();
	}

	public void run() {
		map.put("Three", 3);
		try {
			System.out.println("MapHelper3 sleeping");
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}