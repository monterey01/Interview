package com.anant.string;

import java.util.HashMap;
import java.util.Map;

//Solution to leetcode.com/problems/decode-string/description/
public class DecodeString {
	public String decodeString(String s) {
		char[] ca = s.toCharArray();
		Map<Integer, StringBuilder> mp = new HashMap<Integer, StringBuilder>();
		Map<Integer, Integer> mp1 = new HashMap<Integer, Integer>();
		int curlevel = -1;
		StringBuilder r = new StringBuilder();

		for (int i = 0; i < ca.length; i++) {
			if (Character.isDigit(ca[i])) {
				StringBuilder sb = new StringBuilder();
				sb.append(ca[i]);
				++curlevel;
				while (Character.isDigit(ca[i + 1])) {
					++i;
					sb.append(ca[i]);
				}
				mp1.put(curlevel, Integer.parseInt(sb.toString()));
			}
			if (ca[i] == '[') {
				mp.put(curlevel, new StringBuilder());
				continue;
			}

			if (ca[i] == ']') {

				StringBuilder sb = new StringBuilder();
				int j = mp1.get(curlevel);
				while (j > 0) {
					sb.append(mp.get(curlevel));
					--j;
				}
				mp.remove(curlevel);
				mp1.remove(curlevel);
				if (curlevel - 1 == -1) {
					r.append(sb);
				}

				if (curlevel - 1 > -1) {
					mp.get(curlevel - 1).append(sb);
				}
				--curlevel;
				continue;
			}
			if (ca[i] >= 'a' && ca[i] <= 'z') {
				System.out.println(curlevel + "->" + ca[i]);
				if (curlevel > -1)
					mp.get(curlevel).append(ca[i]);
				if (curlevel == -1) {
					System.out.println(r);
					r.append(ca[i]);
				}
			}

		}
		return r.toString();
	}

}