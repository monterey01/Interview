package com.anant.numbertheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	static class LargestNumberComparator implements Comparator<StringBuffer> {

		@Override
		public int compare(StringBuffer sb1, StringBuffer sb2) {
			// TODO Auto-generated method stub

			if (sb1.length() == 1 && sb2.length() == 1) {
				return (Integer.valueOf(sb1.toString()).compareTo(Integer.valueOf(sb2.toString())));

			}

			if (sb1.length() > 1 && sb2.length() > 1 || sb1.length() == 1 && sb2.length() > 1
					|| sb1.length() > 1 && sb2.length() == 1) {

				if (sb1.length() == 1 && sb2.length() > 1 && sb1.charAt(0) == sb2.charAt(0)) {
					return -1;
				}
				if (sb1.length() > 1 && sb2.length() == 1 && sb1.charAt(0) == sb2.charAt(0)) {
					return 1;
				}
				if (sb1.length() > 1 && sb2.length() > 1 && sb1.charAt(0) == sb2.charAt(0)) {
					int comparator = 0;

					for (int i = 1, j = 1; i < sb1.length() && j < sb2.length(); i++, j++) {
						comparator = Integer.valueOf(sb1.charAt(i)).compareTo(Integer.valueOf(sb2.charAt(j)));
						if (comparator == 1)
							return -1;
						if (comparator == -1)
							return 1;
					}
					return comparator;
				}

			}

			int comparator = Integer.valueOf(sb1.toString()).compareTo(Integer.valueOf(sb2.toString()));
			if (comparator == 1)
				return -1;
			if (comparator == -1)
				return 1;
			return comparator;
		}

	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();

		sb1.append(32);
		sb.append(3);

		List<StringBuffer> collection = new ArrayList<StringBuffer>();
		collection.add(sb);
		collection.add(sb1);

		Collections.sort(collection, new LargestNumberComparator());

		StringBuilder result = new StringBuilder();

		for (StringBuffer sbTemp : collection) {
			result.append(sbTemp);
		}

		System.out.println(result);
		;
	}

}
