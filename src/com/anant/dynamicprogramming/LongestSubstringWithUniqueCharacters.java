package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestSubstringWithUniqueCharacters {

	static int counter = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(getLongestSubStringWithUniqueChars("XAXAAACCIIBB".toCharArray(),
		// 2));
		 System.out.println(lengthOfLongestSubstring("arwvivbgvtybtnudd"));
		//System.out.println(lengthOfLongestSubstring("abcda"));
		System.out.println(counter);
		System.out.println(reverseWords("a"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int result = longestSubstring(s.toCharArray(), new HashMap<Character, Integer>());

		return result;
	}
	
	 public static String reverseWords(String s) {
	      Stack<String> resultStack=new Stack<String>();
	       char[] ca=s.toCharArray();
	        
	      StringBuilder sb=null;
	    
	        for(int i=0;i<ca.length;i++){
	          if(ca[i]==' ' && sb!=null){
	                resultStack.push(sb.toString());
	                sb=null;
	          }
	          else if(ca[i]!=' ' ){
	              if(sb==null)sb=new StringBuilder();
	               sb.append(ca[i]);
	          }
	      }  
	        
	      if(sb!=null) resultStack.push(sb.toString());;
	      sb=null;
	        
	     StringBuilder result=new StringBuilder();
	        
	      while(!resultStack.isEmpty()){
	          result.append(resultStack.pop());
	          if(!resultStack.isEmpty())result.append(" ");
	      }  
	    
	        return result.toString();
	    }

	public static int longestSubstring(char[] ca, Map<Character, Integer> memoziation) {


		int result = 0;
		int currentResult = 0;

		for (int i = 0; i < ca.length; i++) {
			
			++counter;

			if (!memoziation.containsKey(ca[i])) {
				++currentResult;
				memoziation.put(ca[i], i);

			}

			else {
				result = Math.max(result, currentResult);
				i = memoziation.get(ca[i])+1;

				memoziation = new HashMap<Character, Integer>();
				memoziation.put(ca[i], i);
				currentResult = 1;
			}

		}
		result = Math.max(result, currentResult);

		return result;
	}

}
