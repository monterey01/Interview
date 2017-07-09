package com.anant.dynamicprogramming;

public class FibonacciSeries {

	static int[] loookup;
	static int fib(int n) {
		if (n == 1)
			return 0;
		else if (n == 2)
			return 1;
		else if(loookup[n]!=0){
			return loookup[n];
		}
		else
			loookup[n]= (fib(n - 1) + fib(n - 2));
			return loookup[n];
		
	}

	public static void main(String args[]) {
		int n = 5000;
		loookup=new int[n+1];
		System.out.println(fib(n));
	}
}
// 0,1,1,2,3