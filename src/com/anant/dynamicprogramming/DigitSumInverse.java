package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

abstract class DigitSumInverse {

	// Solution to
	// https://codefights.com/tournaments/od2Ak2LGvpg7dw6Aj/D/solutions/ARa39z9MpE8veoh66
	static int counter = 0;

	public static void main(String args[]) {

		// System.out.println(digitSumInverse(5, 1));

		//System.out.println(digitSumInverse(27, 800));
		System.out.println(digitSumInverse(27, 800,new HashMap<Memo, Integer>()) );

		System.out.println(counter);

	}

	static class Memo {

		int sum;
		int numberLength;

		public Memo(int sum, int numberLength) {
			this.sum = sum;
			this.numberLength = numberLength;

		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + numberLength;
			result = prime * result + sum;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Memo other = (Memo) obj;
			if (numberLength != other.numberLength)
				return false;
			if (sum != other.sum)
				return false;
			return true;
		}

	}

	public static int digitSumInverse(int sum, int numberLength) {
		int result=0;
		if (sum == 0 && numberLength == 0) {
			
			return 1;
		}
		if (numberLength == 0) {
		
			return 0;
		}
		
		for(int i=9;i>-1;--i) {
			if(sum-i>=0) {
		
				result+=digitSumInverse(sum-i,numberLength-1);
			}
		}
		
		return result;
		
	}
	
	public static int digitSumInverse(int sum, int numberLength, Map<Memo, Integer> memoziation) {

		if (sum == 0 && numberLength == 0) {
		
			return 1;
		}
		if (numberLength == 0) {
		
			return 0;
		}

		if (memoziation.containsKey(new Memo(sum, numberLength))) {

			return memoziation.get(new Memo(sum, numberLength));

		}

		int result = 0;
		int end=sum>9?9:sum;
		for (int k = 0; k <= end; k++) {
			++counter;
			if (sum - k >= 0) {
				result += digitSumInverse(sum - k, numberLength - 1, memoziation);

			}
		}

		memoziation.put(new Memo(sum, numberLength), result);

		return result;

	}

}

/*
 * 10^2 =100 5 14 23 32 41 50
 **/