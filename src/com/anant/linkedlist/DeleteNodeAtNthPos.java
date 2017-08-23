package com.anant.linkedlist;

public class DeleteNodeAtNthPos {

	// Solution for
	// https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
	public static Node Delete(Node head, int position) {

		Node prv = null;
		Node cur = null;

		if (head == null)
			return head;

		// 1,2,3
		for (int i = 0; i <= position; i++) {

			if (i == 0 && i == position) {
				if (head.next == null) {
					head = null;
				} else {
					head = head.next;
				}

			} else {

				if (cur == null) {
					cur = head;
				} else {
					prv =cur;
					cur=cur.next;
					
					if(i==position){
						if(cur.next==null){
							prv.next=null;
						}
						else{
							 prv.next=cur.next;
						}
					}
				}

			}
		}

		return head;
	}
}