package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {
	
	static int counter=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(numDecodings("291"));
		System.out.println(numImp("291", 0));
		System.out.println(counter);
	}

	public static int numDecodings(String decodedMessage) {
		return numDecodings(decodedMessage, 0, new HashMap<Integer, Integer>());
	}

	public static int numDecodings(String decodedMessage, int position, Map<Integer, Integer> memo) {
		if (decodedMessage == null ||(decodedMessage!=null && decodedMessage.equals("")))
			return 0;

		int result = 0;

		if (position == decodedMessage.length()) {
			return 1;
		}

		if (memo.get(position) != null) {
			
			return memo.get(position);
		}
		
		++counter;

		if (position + 1 <= decodedMessage.length()) {
			Integer oneCharacter = Integer.parseInt(decodedMessage.substring(position, position + 1));

			if (oneCharacter >= 1 && oneCharacter <= 26)
				result += numDecodings(decodedMessage, position + 1, memo);
		}

		if (position + 2 <= decodedMessage.length()) {
			Integer twoCharacter = Integer.parseInt(decodedMessage.substring(position, position + 2));

			if (twoCharacter >= 10 && twoCharacter <= 26)
				result += numDecodings(decodedMessage, position + 2, memo);

		}

		memo.put(position, result);
		return result;

	}

	private static int numImp(String s, int pos) {
		if (pos == s.length())
			return 1;
		int sum = 0;
		int one = Integer.parseInt(s.substring(pos, pos + 1));
		int two = (pos + 1 < s.length()) ? Integer.parseInt(s.substring(pos, pos + 2)) : -1;

		if (one == 0)
			sum = 0;
		else if (two == 10)
			sum = numImp(s, pos + 2);
		else if (two > 10 && two <= 26)
			sum = numImp(s, pos + 1) + numImp(s, pos + 2);
		else
			sum = numImp(s, pos + 1);

		return sum;
	}

}
