package com.anant.linkedlist;

public class QueueLinkedList<V> {

	private class StackNode<V> {
		V data;
		StackNode<V> next;
	}

	private StackNode<V> head;
	private StackNode<V> tail;

	public V dequeue() {
		if (head == null) {
			return null;

		} else {
			V element = head.data;
			

			if (head == tail)
				tail = tail.next;
			head = head.next;

			return element;

		}

	}

	public void enqueue(V element) {
		if (head == null) {
			head = new StackNode<V>();
			head.data = element;
			tail = head;

		} else {
			StackNode<V> temp = new StackNode<V>();
			temp.data = element;
			tail.next = temp;
			tail = tail.next;

		}

	}

	public static void main(String args[]) {
		QueueLinkedList<Integer> q = new QueueLinkedList<Integer>();
		q.enqueue(1);
		System.out.println(q.dequeue());
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
