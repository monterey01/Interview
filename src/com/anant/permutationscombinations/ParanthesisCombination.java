package com.anant.permutationscombinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParanthesisCombination {
	// ((()))
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="\t\ta";
		
		System.out.println(s.lastIndexOf('\t'));
		longestPalindrome("babad");
	}
	
	 public static String longestPalindrome(String s) {
		 
		 
	      String r="";   
	        //abba
	      char[] ca=s.toCharArray();
	      
	        for(int i=0;i<ca.length;i++){
	            for(int j=ca.length-1;j>-1;j--){
	                if(isPalindrome(ca,i,j)){
	                		String tmp=s.substring(i,j+1);
	                    if(r.length()<tmp.length()){
	                        r=tmp;
	                    }
	                    break;
	                }
	            }
	        }
	        
	        return r;
	    }
	    
	    public static boolean isPalindrome(char[] ca, int s, int e){
	        
	        for(int i=s,j=e;i<(s+e+1)/2;i++,j--){
	                if(ca[i]!=ca[j]) return false;
	        }
	        return true;
	    }

	static class TemperatureStat {
		double totalTemp;
		int numberOfHits;
		double lastAverage;
	}



	static double totalTemp = 0;
	static double totalCount = 0;
	static double lastAverage = Double.MAX_VALUE;

	static Map<Integer, TemperatureStat> sensorAverageMap = new ConcurrentHashMap<Integer, TemperatureStat>();

	public static void sendTemperature(int sensorNumber, double temp) {

		int[] a= {1,2,4,5};
		List<Integer> l=new LinkedList<Integer>();
		for(Integer v:a) {
			l.add(v);
		}
		Collections.sort(l,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
		
		if (sensorAverageMap.containsKey(sensorNumber)) {
			TemperatureStat tempStat = sensorAverageMap.get(sensorNumber);
			++tempStat.numberOfHits;
			tempStat.totalTemp += temp;

			if (temp - tempStat.lastAverage >= (double) 5)
				System.out.println("Average exceeded for sensor number->" + sensorNumber);
			tempStat.lastAverage = (tempStat.totalTemp / tempStat.numberOfHits);
			sensorAverageMap.put(sensorNumber, tempStat);
		} else {
			TemperatureStat tempStat = new TemperatureStat();
			tempStat.lastAverage = temp;
			++tempStat.numberOfHits;
			tempStat.totalTemp = temp;
			sensorAverageMap.put(sensorNumber, tempStat);
		}

	}

	public static List<String> pc(char[] ca, int n) {
		List<String> ls = new ArrayList<String>();

		print(ca, ls);
		for (int i = 1; i < n; i++) {
			for (int j = n; j < n * 2 - 1; j++) {
				swap(ca, i, j);
				print(ca, ls);
				swap(ca, i, j);
			}

		}

		return ls;
	}

	public static void print(char[] ca, List<String> ls) {
		StringBuilder sb = new StringBuilder();
		for (char c : ca) {
			sb.append(c);
		}
		ls.add(sb.toString());
	}

	public static void swap(char[] ca, int a, int b) {
		char tmp = ca[a];
		ca[a] = ca[b];
		ca[b] = tmp;
	}

}
/**
 * ((())) ()()() (())() (()()) ()(())
 */

/*
 * 
 * 
 * (()) (()) ()()
 */
