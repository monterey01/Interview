package com.anant.queuesstacks;

import java.util.LinkedList;

//Solution to https://codefights.com/interview-practice/task/MdHZFgZFERPPagfdD
import java.util.Queue;
import java.util.Stack;

public class NextLarger {

	public static void main(String[] args) {

		System.out.println();
		int number[] = nextLarger(new int[] { 300, 100, 100, 100, 1, 5, 1, 200, 900 });

		for (int n : number) {
			System.out.print(n + " ");
		}
	}

	static int[] nextLarger(int[] a) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (i + 1 < a.length && a[i + 1] > a[i]) {
				q.add(i + 1);
			}
		}
		Stack<Integer> q1 = new Stack<Integer>();

		for (int j = 0; j < a.length; j++) {

			if (q1.size() > 0 && q.size() > 0 && q1.peek() < q.peek() && a[q1.peek()] < a[q.peek()]) {
				while (q1.size() > 0 && a[q1.peek()] < a[q.peek()]) {
					a[q1.peek()] = a[q.peek()];
					q1.pop();
				}
			}

			if (q.size() > 0 && j == q.peek())
				q.poll();

			if (q.size() > 0 && j < q.peek() && a[j] < a[q.peek()]) {
				a[j] = a[q.peek()];
			}

			else if (q.size() > 0 && j < q.peek() && a[j] > a[q.peek()]) {
				q1.add(j);

			}

			if (q.size() == 0) {
				a[j] = -1;
			}
		}

		while (q1.size() > 0) {
			a[q1.peek()] = -1;
			q1.pop();
		}

		return a;
	}

	
	
	//5,2

	
}
