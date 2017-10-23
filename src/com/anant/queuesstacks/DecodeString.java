package com.anant.queuesstacks;

public class DecodeString {

	//Solution to https://codefights.com/interview-practice/task/dYCH8sdnxGf5aGkez
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long s= System.currentTimeMillis();
	   System.out.println(decodeString("a5[b2[c]]"));
	   long j=System.currentTimeMillis();
		System.out.println(j-s);

	}

	// Put all the
	// expand the children
	//
	// 2[b3[a]]
	
	
	public static String decodeString2(String input){
	      StringBuilder sb=new StringBuilder(input);
	      
	      for(int i=0;i<sb.length();i++){
	          if(Character.isDigit(sb.charAt(i))){
	              processBrackets(sb,i);
	            
	          }
	      }
	    
	      return sb.toString();
	  }
	  
	  
	  public static void processBrackets(StringBuilder input,int startIndex){
	        int bracketStartPosition=0;
	        int bracketEndPosition=0;
	        StringBuilder repeatSize=new StringBuilder();
	        boolean isFirstStartBracket=false;
	        
	        for(int i=startIndex;i<input.length();i++){
	            char c=input.charAt(i);  
	          
	            //Find number of times to repeat string
	            if(Character.isDigit(c)){
	               if(!isFirstStartBracket)repeatSize.append(c);
	              //There is a sub string here
	               if(isFirstStartBracket)processBrackets(input,i);
	            }
	            else if(c=='['){
	                  bracketStartPosition=i;
	                  isFirstStartBracket=true;
	            }
	            else if(c==']'){
	              bracketEndPosition=i;
	              break;
	            }      
	        }
	    
	        String repeat=input.substring(bracketStartPosition+1,bracketEndPosition);
	        int repeatNumber=Integer.valueOf(repeatSize.toString());
	        StringBuilder result=repeatString(repeat,repeatNumber);
	        input.replace(startIndex,bracketEndPosition+1,result.toString());
	    
	  }
	  
	  
	  public static StringBuilder repeatString(String input,int repeatNumber){
	        StringBuilder sb=new StringBuilder();
	        
	        for(int i=1; i<=repeatNumber;i++){
	              sb.append(input);
	        }
	    
	    return sb;
	    
	  }

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
