package com.anant.queuesstacks;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long s= System.currentTimeMillis();
	   System.out.println(decodeString("1[1[1[1[1[1[1[1[1[1[aaaaaaaaaaa]]]]]]]]]]"));
	   long j=System.currentTimeMillis();
		System.out.println(j-s);

	}

	// Put all the
	// expand the children
	//
	// 2[b3[a]]

	public static String decodeString(String s) {

		char[] ca = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		if (s == null || (s != null && s.length() == 0))
			return s;

		for (int i = 0; i < ca.length; i++) {
			if (i + 1 < ca.length && Character.isDigit(ca[i])) {
				StringBuilder result = new StringBuilder();

				i = processBracket(ca, i, result);
				sb.append(result);
			} else {
				sb.append(ca[i]);
			}

		}
		return sb.toString();

	}

	public static int processBracket(char[] ca, int index, StringBuilder sb) {



		int q = 0;
		StringBuilder qs = new StringBuilder();
		;
		for (int k = index; k < ca.length; k++) {
			if (ca[k] == '[') {
				index = k + 1;
				break;
			} else {
				qs.append(ca[k]);
			}
		}

		q = Integer.valueOf(qs.toString());



		if (sb == null)
			sb = new StringBuilder();
		int result = 0;

		StringBuilder tmp = new StringBuilder();

		for (int i = index; i < ca.length; i++) {
			if (i + 1 < ca.length && Character.isDigit(ca[i])) {
				StringBuilder tmp1 = new StringBuilder();
				i = processBracket(ca, i, tmp1);
				tmp.append(tmp1);
			} else if (ca[i] == ']') {
				result = i;
				break;
			} else {
				tmp.append(ca[i]);
			}
		}

		for (int j = 0; j < q; j++) {
			sb.append(tmp);
		}



		return result;

	}

}
