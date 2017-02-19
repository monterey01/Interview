package com.anant.bstquestions;

import java.util.PriorityQueue;
import java.util.Queue;

//Based on https://www.youtube.com/watch?v=ZM-sV9zQPEs&index=1&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
public class Traversal {

	static class Level implements Comparable<Level>{
		
		private Node n;
		private int i;
		private int io;
		
		
		public int getIo() {
			return io;
		}
		public void setIo(int io) {
			this.io = io;
		}
		public Node getN() {
			return n;
		}
		public void setN(Node n) {
			this.n = n;
		}
		public int getLevel() {
			return i;
		}
		public void setLevel(int i) {
			this.i = i;
		}
		@Override
		public String toString() {
			return "Level [n=" + n.toString() + ", i=" + i + "]";
		}
		
		@Override
		public int compareTo(Level o) {
			if (o!=null & n!=null){
				if(o.getLevel()==i){
					return io-o.getIo();
					
				}
				if(i<o.getLevel()){
					return -1;
				}
				else{
					return 1;
				}
				
				
			}
			
			return 0;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n, n1, n2, n3, n4, n5, n6, n7, n8;
		
		

		n = new Node();
		n1 = new Node();
		n2 = new Node();
		n3 = new Node();
		n4 = new Node();
		n5 = new Node();
		n6 = new Node();
		n7 = new Node();
		n8 = new Node();


		n.setData(10);

		// Left First
		n1.setData(15);
		n.setLeft(n1);

		n2.setData(3);
		n1.setLeft(n2);

		n3.setData(6);
		n1.setRight(n3);

		n4.setData(5);
		n2.setLeft(n4);

		n5.setData(30);
		n.setRight(n5);

		n6.setData(2);
		n5.setRight(n6);

		n7.setData(9);
		n6.setLeft(n7);

		n8.setData(8);
		n6.setRight(n8);

		System.out.println(" ");
		printPreOrder(n);

		System.out.println(" ");
		printInOrder(n);
		
		System.out.println(" ");
		printPostOrder(n);
		
		System.out.println(" ");
		Queue<Level> q=depthFirstTraversal(n,null,0,0);
		
	
	
		int index=0;
		while(q.size()>0){
			Level l=q.poll();
			if(l.getLevel()==index){
				System.out.print( l.getN().getData() + " " );
			}
			else{
				index=l.getLevel();
				System.out.println("");
				System.out.print(l.getN().getData() + " ");
			}
			
		}
	    
	}
	
	

	public static void printPreOrder(Node n) {

		if (n != null) {
			System.out.print(n.getData() + " ");
			printPreOrder(n.getLeft());
			printPreOrder(n.getRight());
		}

	}

	public static void printInOrder(Node n) {

		if (n != null) {
			printInOrder(n.getLeft());
			System.out.print(n.getData() + " ");
			printInOrder(n.getRight());
		}

	}
	
	public static void printPostOrder(Node n) {

		if (n != null) {
			printPostOrder(n.getLeft());
			printPostOrder(n.getRight());
			System.out.print(n.getData() + " ");
		
		}

	}
	
	public static Queue<Level> depthFirstTraversal(Node n,Queue<Level> q,int level,int counter) {
		
		if(q==null)q=new PriorityQueue<Level>();
	
		if (n != null) {
			Level l=new Level();
			l.setLevel(level);
			l.setN(n);
			l.setIo(counter);
			q.add(l);
			
			
			depthFirstTraversal(n.getLeft(),q,level+1,++counter);
			depthFirstTraversal(n.getRight(),q,level+1,++counter);
		}
		
		return q;

	}

}
