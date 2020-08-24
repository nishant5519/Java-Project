package com.datastructure.design;

import java.util.HashMap;
import java.util.Map;

/*A Least Recently Used (LRU) Cache organizes items in order of use, allowing you to quickly identify which item
hasn't been used for the longest amount of time.Under the hood, an LRU cache is often implemented by pairing a 
doubly linked list with a hash map.We'll set up our linked list with the most-recently used item at the head of 
the list and the least-recently used item at the tail: https://www.interviewcake.com/concept/java/lru-cache 
https://www.java-success.com/implement-an-in-memory-cache-in-java/ */
public class LRUCache {
	
	Node head, tail;
	final Map<Integer, Node> node_map;

	int cache_capacity; // Here i am setting 4 to test the LRU cache
						// implementation, it can make be dynamic

	public LRUCache(int capacity) {
		node_map = new HashMap<Integer, Node>();
		this.cache_capacity = capacity;
	}

	public int get(int key) {
		if (node_map.containsKey(key)) {
			Node node = node_map.get(key);
			removeNode(node);
			addAtTop(node);
			return node.value;
		}
		return -1;

	}

	public void put(int key, int value) {
		if (node_map.containsKey(key)) {
			Node node = node_map.get(key);
			node.value = value;
			removeNode(node);
			addAtTop(node);
		} else {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;
			newNode.next = null;
			newNode.prev = null;
			
			if (node_map.size() >= cache_capacity) {
				node_map.remove(tail.key);
				removeNode(tail);
			}
			node_map.put(key, newNode);
			addAtTop(newNode);

		}

	}

	public void addAtTop(Node node) {
		node.next = head;
		node.prev = null;

		if (head != null)
			head.prev = node;
		head = node;
		if (tail == null)
			tail = head;
	}

	public void removeNode(Node node) {
		
		if(node.prev !=null)
			node.prev.next = node.next;
		else
			head = node.next;
		if(node.next!=null)
			node.next.prev = node.prev;
		else
			tail = node.prev;

	}

	public static void main(String[] args) throws java.lang.Exception {
		LRUCache lrucache = new LRUCache(5);
		lrucache.put(1, 1);
		lrucache.put(10, 15);
		lrucache.put(15, 10);
		lrucache.put(10, 16); 
		lrucache.put(12, 15);
		lrucache.put(18, 10); //Key 1 will be evicted
		lrucache.put(13, 16); //key 10 will be evicted 

		System.out.println(lrucache.get(1));
		System.out.println(lrucache.get(10));
		System.out.println(lrucache.get(15));

	}
}

class Node {
	int value;
	int key;
	Node prev;
	Node next;
}
