package com.anant.queuesstacks;

import java.util.HashMap;
import java.util.Map;

public

class LRUCache {

	public static void main(String args[]) {
		LRUCache cache = new LRUCache(1);
		// ["LRUCache","put","get","put","get","get"]
		// [[1],[2,1],[2],[3,2],[2],[3]]

		cache.put(2, 1);
		System.out.println("Get value: " + cache.get(2));
		cache.put(3, 2);
		System.out.println("Get value: " + cache.get(2));
		System.out.println("Get value: " + cache.get(3));
	}

	static class Node {
		Node previous;
		Node next;
		int key;
		int value;
	}

	static Map<Integer, Node> mp = null;
	static Node head = null;
	static Node tail = null;
	static int capacity = 0;

	public LRUCache(int capacity) {
		System.out.println("capacity:" + capacity);
		if (head != null)
			System.out.println("hello1");
		mp = new HashMap<Integer, Node>();
		this.capacity = capacity;

	}

	public static int get(int key) {

		Node n = mp.get(key);
		if (n == null)
			return -1;

		int value = n.value;

		removeNode(key);
		addHeadNode(key, value);

		return value;

	}

	public static void put(int key, int value) {
		System.out.println("key: " + key + " value:" + value);

		if (mp.containsKey(key)) {
			removeNode(key);
		}

		if (mp.size() == capacity) {
			if (tail != null && mp.containsKey(tail.key)) {
				System.out.println("removing from cache");
				removeNode(tail.key);
			}

		}

		addHeadNode(key, value);

		if (tail != null) {
			System.out.println("tail:" + tail.value);
		}

	}

	public static void addHeadNode(int key, int value) {
		Node n = new Node();
		n.key = key;
		n.value = value;

		if (head != null) {
			n.next = head;
			head.previous = n;
			head = n;
		}

		if (head == null) {
			head = n;

		}

		if (tail == null) {
			tail = n;
		}

		mp.put(key, n);
	}

	public static void removeNode(int key) {
		Node n = mp.get(key);

		if (head == n) {
			head = head.next;
		}

		if (tail == n) {
			tail = tail.previous;
		}

		if (n.previous != null && n.next != null) {
			n.previous.next = n.next;

		}

		n = null;
		mp.remove(key);

	}

}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
