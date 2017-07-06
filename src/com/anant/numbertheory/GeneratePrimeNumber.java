package com.anant.numbertheory;

public class GeneratePrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPrime(4);
		
		

	}
	
	static private void printPrime( int n){
	
		for(int i=2;i<n;n++){
			
			int number=(int)Math.sqrt(i);
			
			if(number%2==0)System.out.println(number);
			
		}
		
	}

}
