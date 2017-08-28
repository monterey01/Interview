package com.anant.numbertheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorInterface {

	static class IncreasingIntegerComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer obj, Integer obj1) {
		

			if (obj.equals(obj1))
				return 0;
			if (obj.intValue() > obj1.intValue()) {
				return 1;
			} else {
				return -1;
			}

		}
	}

	public static void main(String args[]) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(10);
		numbers.add(5);

		Collections.sort(numbers, new IncreasingIntegerComparator());

		for (Integer number : numbers) {
			System.out.println(number);
		}

	}
	
	
	

}
