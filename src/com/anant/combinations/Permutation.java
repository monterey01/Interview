package com.anant.combinations;

import java.util.LinkedList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {

		System.out.println(getPermutationList("abcd".toCharArray(), null));

	}

	//abcd`
	public static List<String> getPermutationList(char c[], List<String> ls ) {
		
			
		if (ls == null)
			ls = new LinkedList<String>();

		if (c.length == 2) {
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
			/**if(startChar!='\0'){
				sb1.append(startChar);
				sb2.append(startChar);
				
			}**/
			sb1.append(c[0]);
			sb1.append(c[1]);
			sb2.append(c[1]);
			sb2.append(c[0]);

			ls.add(sb1.toString());
			ls.add(sb2.toString());
		} else {
			for (int i = 0; i < c.length; i++) {
				char tmpc[] = new char[c.length - 1];
			
				
				boolean isSameCharacterChecked = false;
				for (int j = 0,k=0; j < c.length - 1; j++,k++) {
					if (!isSameCharacterChecked && i == j) {
						isSameCharacterChecked = true;
						j--;
					} else {
						tmpc[j] = c[k];
					}

				}
				List<String >ls1 = getPermutationList(tmpc, null);

				for (int k = 0; k < ls1.size(); k++) {
					String s = ls1.get(k);
					StringBuilder sb1 = new StringBuilder();
					sb1.append(s.toCharArray());
					sb1.insert(0, c[i]); 
					ls1.set(k, sb1.toString());
				}
				
				ls.addAll(ls1);

			}
		}

		return ls;
	}

}
