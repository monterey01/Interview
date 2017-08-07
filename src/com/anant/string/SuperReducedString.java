package com.anant.string;

import java.util.Scanner;
import java.util.Stack;

//Solution for https://www.hackerrank.com/challenges/reduced-string
public class SuperReducedString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(removeAdjDupCharacter(scan.next()));
        
    }



   private static String removeAdjDupCharacter(String s){
        StringBuilder sb=new StringBuilder();
        char c[]=s.toCharArray();
   
       String result;
       Stack<Character> st=new Stack<Character>();
    

      if(c.length==1){
         return s;
      }
   
       for (int i=0;i<c.length;i++){
          
          if((i+1<c.length) && (c[i]==c[i+1])){
              ++i;
          }
          else if((sb.length() >0)&&(c[i]==sb.charAt(sb.length() -1)) ){
              sb.deleteCharAt(sb.length()-1);
          }
          else{
              sb.append(c[i]);
          }
        
      }
     
      
       result=sb.toString();

       if (result.equals("")){
           return "Empty String";
       }
       else{
           return result;
       }
    
       
  }
 
   
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
}