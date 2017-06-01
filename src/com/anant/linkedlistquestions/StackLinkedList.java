package com.anant.linkedlistquestions;

public class StackLinkedList<E> {

	private class StackNode<E> {
		E data;
		StackNode<E> next;
	}

	StackNode<E> head;

	public Object pop() {
		if (head == null) {
			return null;
		} else {
			StackNode<E> tmp = head.next;
			Object result;
			result = head.data;

			if (tmp == null) {
				head = null;
			} else {
				head = tmp;
			}

			return result;
		}
	}

	public Object peek() {
		if (head == null) {
			return null;
		} else {
			return head.data;
		}

	}

	public void push(E element) {
		if (head == null) {
			head = new StackNode<E>();
			head.data = element;
		} else {
			StackNode<E> tmp = new StackNode<E>();
			tmp.data = element;
			tmp.next = head;
			head = tmp;
		}
	}

	public static void main(String args[]) {
		StackLinkedList<Integer> s = new StackLinkedList<Integer>();
		s.push(1);

		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
