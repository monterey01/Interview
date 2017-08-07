package com.anant.numbertheory;

import java.util.HashMap;
import java.util.Map;

public class DecimalToHexaDecimal {

	static Map<Integer, Character> decimalToHexaDecimalMap = new HashMap<Integer, Character>();

	public static void main(String[] args) {

		System.out.println(decToHex(2000));
	}

	public static String decToHex(int num) {
		// Digits in hexadecimal number system
	     char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	 
	  // For storing remainder
	     int rem;
	        
	     // For storing result
	     String str2=""; 
	 
	     while(num>0)
	     {
	       rem=num%16; 
	       str2=hex[rem]+str2; 
	       num=num/16;
	     }
	     return str2;

	}

}
