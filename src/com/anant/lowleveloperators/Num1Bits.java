package com.anant.lowleveloperators;

//Solution to https://codelab.interviewbit.com/problems/num1bits/

public class Num1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSetBits(11));

	}

	
	public static int numSetBits(long a) {
	    int result=0;
	    for(int i=0; i<=31;i++){
	        long tmp=a>>i & 1;
            result+=(int)tmp;
	        
	   
	    }
	   return result; 
	}
}
