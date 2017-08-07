package com.anant.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/home/a/./x/../b//c/"));


	}

	static String simplifyPath(String path) {
		Deque<String> aq = new ArrayDeque<String>();
		String[] s = path.split("/");

		for (String tmp : s) {

			switch (tmp) {

			case "":
				continue;
			case ".":
				continue;
			case "..":
				if (aq.size() > 0)
					aq.removeLast();
				;
				continue;
			default:
				aq.add(tmp);

			}

		}
		
		StringBuilder sb=new StringBuilder();
		
		while(aq.size()>0){
			sb.append("/");
			sb.append(aq.remove());
			
		}

		if (sb.length()==0) return "/";
		return sb.toString();
	}

}
