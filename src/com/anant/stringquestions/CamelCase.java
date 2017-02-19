package com.anant.stringquestions;

import java.util.Scanner;

//Solution for https://www.hackerrank.com/challenges/camelcase

public class CamelCase {
    
   public static int numOfWords(String camelCase) {
		char[] charArray = camelCase.toCharArray();
		int numOfWords = 0;

		if (charArray.length==0 ){
			numOfWords = 0;
		}
		else{
			if(Character.isLowerCase(charArray[0])) 
			numOfWords = 1;
		}

		for (int i = 0; i < charArray.length; i++) {
			if (Character.isUpperCase(charArray[i])) {
				numOfWords++;
			}

		}
		return numOfWords;
	}


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(numOfWords(s));
    }
}
