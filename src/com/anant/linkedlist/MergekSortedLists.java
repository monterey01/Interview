package com.anant.linkedlist;

public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static class Result {
		ListNode head;
		ListNode tail;

	}

	// Base Case if list is 1 kick out
	// Merge Algorithm for 2 list list nodes
	// Have result= merge algorithm
	// Merge next with list

	class Solution {

		public ListNode mergeKLists(ListNode[] lists) {
			if (lists.length == 0)
				return null;
			if (lists.length == 1)
				return lists[0];
			ListNode result = null;
			ListNode tail = null;

			Result tmpResult = mergeListNode(lists[0], lists[1]);
			if (tmpResult != null) {
				result = tmpResult.head;
				tail = tmpResult.tail;
			}

			for (int i = 2; i < lists.length; i++) {
				if (result != null) {
					Result tmpResult1 = mergeListNode(result, lists[i]);
					if (lists[i] == null)
						continue;

					if (tmpResult1 != null) {
						result = tmpResult1.head;
						tail = tmpResult1.tail;
					}

				}

			}

			return result;
		}

		public Result mergeListNode(ListNode l1, ListNode l2) {
			Result result = null;
			ListNode l3head = null;
			ListNode l3tail = null;

			while (l1 != null || l2 != null) {
				int val = 0;
				if (l1 != null && l2 != null) {
					if (l1.val < l2.val) {
						val = l1.val;
						l1 = l1.next;
					} else {
						val = l2.val;
						l2 = l2.next;
					}

				} else if (l1 == null && l2 != null) {
					val = l2.val;
					l2 = l2.next;
				} else if (l1 != null && l2 == null) {
					val = l1.val;
					l1 = l1.next;
				}

				if (result == null) {
					result = new Result();
					l3head = new ListNode(val);
					System.out.println(val);
					l3tail = l3head;
					result.head = l3head;
					result.tail = l3tail;
				} else {
					l3tail.next = new ListNode(val);
					l3tail = l3tail.next;
					result.tail = l3tail;
				}

			}

			return result;

		}

	}

}
