package com.anant.string;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Solution for https://www.hackerrank.com/challenges/sherlock-and-anagrams

public class SherlockAndAnagrams {

	static int i;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        sc.nextInt();
	
		while (sc.hasNext()) {
			System.out.println(noOfAnagrams(sc.next()));
		}

		sc=null;
	
	}

	public static int noOfAnagrams(String s) {


		int noa = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		char c[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]);
			addTo(map, sb.toString());
			
			{
        		for (int j = i + 1; j < c.length; j++) {
					sb.append(c[j]);
					char tmpc[] = sb.toString().toCharArray();
					Arrays.sort(tmpc);
					addTo(map, new String(tmpc));
		}
				sb.setLength(0);
			}

		}
        
        //Get the combinations for each string in map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				int r = 0;
				int n = entry.getValue() *(entry.getValue()-1) ;
		      	r = n / (2);
				noa = noa + r;
			}

		}

		return noa;
	}



	/**
	 * Add string occurrences to map
	 * @param map
	 * @param s
	 */
	private static void addTo(HashMap<String, Integer> map, String s) {

		if (map.get(s) == null) {
			map.put(s, 1);
		} else {
			i++;
			map.put(s, map.get(s) + 1);
		}
	}

}