package com.anant.arrayquestions;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstNonRepeatingCharacter {

	// Solution to https://codefights.com/interview-practice/task/uX5iLwhc6L5ckSyNC

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bccccccccccccccyb";
		System.out.println(firstNotRepeatingCharacter(s));

	}

	static char firstNotRepeatingCharacter(String s1) {

	    
	    int[] ascii=new int[256];
	    char[] c1=s1.toCharArray();
	    Set<Character> s=new LinkedHashSet<Character>();
	    
	    for(char c:c1){
	        
	        s.add(c);
	        ascii[(int)c]=++ascii[(int)c];
	        if (ascii[(int)c]>1){
	            s.remove(c);
	        }
	    }
	    
	    if(s.size()==0) return '_';
	    
	    Iterator<Character> itr=s.iterator();
	    
	    return itr.next();
	    
	    
	}

}
