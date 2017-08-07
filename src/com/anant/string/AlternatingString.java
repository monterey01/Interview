package com.anant.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Solution for https://www.hackerrank.com/challenges/alternating-characters
public class AlternatingString {

    	public static int numOfDel(String a){
        char[] c=a.toCharArray();
        int numOfDel=0;
        for (int i=0;i<c.length;i++){
            int nextIndex=i+1;
            
            if(nextIndex<c.length){
                if (c[i]==(c[i+1])){
                    numOfDel++;
                }
            }
            
        }
        return numOfDel;
    }
    
    
public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numOfStrings=sc.nextInt();
        List<String> strings=new LinkedList<String> ();
        for (int i=0;i<=numOfStrings-1;i++){
        	strings.add(i, sc.next());
        	
        }
        
        for(String s:strings){
        	 System.out.println(numOfDel(s));
        	
        }
        
       
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
