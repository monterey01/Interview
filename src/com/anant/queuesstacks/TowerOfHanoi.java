package com.anant.queuesstacks;

import java.util.Stack;

public class TowerOfHanoi {

	public static void solve(int n, Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> destination) {
		System.out.println(n);
		
		if (n == 1) {
			destination.push(source.pop());
		} else {
			solve(n - 1, source, destination, auxiliary);
			destination.push(source.pop());
			solve(n - 1, auxiliary, source, destination);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> source = new Stack<Integer>();
		Stack<Integer> auxiliary = new Stack<Integer>();
		Stack<Integer> destination = new Stack<Integer>();
		source.push(3);
		source.push(2);
		source.push(1);

		solve(source.size(), source, auxiliary, destination);
		System.out.println(destination);

	}
}