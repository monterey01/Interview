package com.anant.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

//Solution for https://www.hackerrank.com/challenges/reverse-a-linked-list
public class ReverseLinkedList {

	public static void main(String Args[]) {

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();

		n1.data = 1;
		n2.data = 3;
		n3.data = 5;
		n4.data = 6;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println( reverse(n1));

	}

	public static Node reverse(Node h) {
		  if(h==null||h.next==null) return h;
          Node next=h.next;
          h.next=null;
    
          while(next != null);
          {
      
         
            
         }
    
      
      return h;
	}

	class Solution {
		public List<String> findItinerary(String[][] tickets) {
			Map<String, Queue<String>> targets = new HashMap<String, Queue<String>>();

			for (String[] ticket : tickets) {
				targets.putIfAbsent(ticket[0], new PriorityQueue<>());
				targets.get(ticket[0]).add(ticket[1]);
			}

			List<String> route = new LinkedList<String>();
			Stack<String> stack = new Stack<>();
			stack.push("JFK");
			while (!stack.empty()) {
				while (targets.containsKey(stack.peek()) && targets.get(stack.peek()).size() > 0) {
					stack.push(targets.get(stack.peek()).poll());
				}
				route.add(0, stack.pop());

			}
			return route;

		}
	}
}
