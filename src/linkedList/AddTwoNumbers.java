package linkedList;

import java.util.*;

import linkedList.AddTwoNumbers.ListNode;

public class AddTwoNumbers {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	static ListNode build(int[] arr) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		for (int x : arr) {
			curr.next = new ListNode(x);
			curr = curr.next;
		}
		return dummy.next;
	}

	// Helper: convert a linked list to a printable string
	static String toString(ListNode head) {
		List<Integer> out = new ArrayList();
		while (head != null) {
			out.add(head.val);
			head = head.next;
		}
		return out.toString();
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);

		ListNode curr = dummy;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {

		// Example 1: expected [7, 0, 8]
		System.out.println(toString(addTwoNumbers(build(new int[] { 2, 4, 3 }), build(new int[] { 5, 6, 4 }))));

		// Example 2: expected [0]
		System.out.println(toString(addTwoNumbers(build(new int[] { 0 }), build(new int[] { 0 }))));

		// Example 3: expected [8, 9, 9, 9, 0, 0, 0, 1]
		System.out.println(
				toString(addTwoNumbers(build(new int[] { 9, 9, 9, 9, 9, 9, 9 }), build(new int[] { 9, 9, 9, 9 }))));
	}
}
