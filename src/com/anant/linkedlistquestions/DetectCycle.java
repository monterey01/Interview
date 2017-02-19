package com.anant.linkedlistquestions;

import com.anant.linkedlistquestions.Node;

public class DetectCycle {

	// Solution for
	// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle

	boolean hasCycle(Node head) {
		Node tmp = head;
		Node tmp1 = null;

		if (tmp == null)
			return false;

		if (tmp.next == null) {
			return false;
		}

		else {
			tmp1 = tmp.next;
		}

		while (tmp != null && tmp1 != null) {

			if (tmp.next != null) {
				tmp = tmp.next;
			} else {
				return false;
			}

			if (tmp1.next != null && tmp1.next.next != null) {
				tmp1 = tmp1.next.next;
			} else {
				return false;
			}

			if (tmp == tmp1)
				return true;

		}

		return false;

	}

}
