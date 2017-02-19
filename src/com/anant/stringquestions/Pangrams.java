package com.anant.stringquestions;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//Solution for https://www.hackerrank.com/challenges/pangrams
public class Pangrams {

    public static void main(String[] args) {
       		Scanner in = new Scanner(System.in);
		StringBuilder sentence = new StringBuilder();

		while (in.hasNextLine()) {
			sentence.append(in.next());
		}

		System.out.println(isPangram(sentence.toString()));
        
    
    }
    
	public static String isPangram(String sentence) {
		char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		HashMap characterCountMap = new HashMap();

		// put all the characters in hashmap and initialize count to 0
		for (Character alphabetChar : alphabetArray) {
			long count = 0;
			characterCountMap.put(alphabetChar, count);
		}

		char[] sentenceCharArray = sentence.toCharArray();
		for (Character char1 : sentenceCharArray) {

			char lowerCase = Character.toLowerCase(char1);

			if (characterCountMap.containsKey(lowerCase)) {
				long count = (Long) characterCountMap.get(lowerCase) + 1;
				characterCountMap.put(lowerCase, count);
			}
		}

		Iterator itr = characterCountMap.keySet().iterator();

		while (itr.hasNext() == true) {
			long count = (Long) characterCountMap.get(itr.next());
			if (count == 0)
				return "not pangram" ;
		}

		return "pangram ";
    }
	}