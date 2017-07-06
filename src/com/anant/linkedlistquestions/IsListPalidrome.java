package com.anant.linkedlistquestions;

public class IsListPalidrome {

	public static void main(String[] args) {
		// 1, 1000000000, -1000000000, -1000000000, 1000000000, 1]
		ListNode<Integer> n = new ListNode<Integer>(1);
		ListNode<Integer> n1 = new ListNode<Integer>(1000000000);
		ListNode<Integer> n2 = new ListNode<Integer>(-1000000000);
		ListNode<Integer> n3 = new ListNode<Integer>(-1000000000);
		ListNode<Integer> n4 = new ListNode<Integer>(1000000000);
		ListNode<Integer> n5 = new ListNode<Integer>(1);

		n.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		System.out.println(isListPalindrome(n));

		// TODO Auto-generated method stub

	}

	static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

	// find middle element
	// reverse middle element to end
	// have a pointer to header
	// have a pointer to middle
	static boolean isListPalindrome(ListNode<Integer> l) {
		if (l == null)
			return true;
		if (l.next == null)
			return true;

		ListNode<Integer> h = l;
		ListNode<Integer> m = l;
		ListNode<Integer> ptr2 = l.next;

		// 1,2
		// 1,2,3
		// 1,2,3,4

		int i = 0;
		while (ptr2 != null) {
			++i;
			m = m.next;

			ptr2 = ptr2.next != null ? ptr2.next.next : null;
		}

		if (i > 1 && i % 2 == 0) {
			m = m.next;
		}

		m = reverse(m);

		ListNode<Integer> tmp = h;
		while (m != null) {
			if (!m.value.equals(tmp.value)) {
				return false;
			}
			m = m.next;
			tmp = tmp.next;

		}

		return true;

	}

	public static ListNode reverse(ListNode head) {
		// 2,3,4

		if (head != null && head.next != null) {

			// 2
			ListNode tmp1 = head;
			ListNode tmp2 = null;

			// 3
			head = tmp1.next;
			tmp1.next = null;

			tmp2 = head.next;

			head.next = tmp1;

			while (tmp2 != null) {

				tmp1 = head;
				head = tmp2;
				tmp2 = head.next;
				head.next = tmp1;

			}

		}

		return head;
	}

}
