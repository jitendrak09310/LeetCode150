package linkedList;

import java.util.*;

import linkedList.LinkedListCycle.ListNode;

public class LinkedListCycle {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	static ListNode buildList(int[] values, int pos) {
		if (values.length == 0) {
			return null;
		}
		ListNode head = new ListNode(values[0]);
		ListNode current = head;
		ListNode cycleNode = (pos == 0) ? head : null;

		for (int i = 1; i < values.length; i++) {

			current.next = new ListNode(values[i]);
			current = current.next;
			if (i == pos) {
				cycleNode = current;
			}
		}

		current.next = cycleNode;
		return head;
	}

	public static boolean hasCycle(ListNode head) {
		Set<ListNode> seen = new HashSet<>();

		while (head != null) {
			if (!seen.add(head)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	public static void main(String[] args) {
		// Example 1: [3,2,0,-4], pos = 1 -> true
		ListNode head1 = buildList(new int[] { 3, 2, 0, -4 }, 1);
		System.out.println("Example 1: " + hasCycle(head1));

		// Example 2: [1,2], pos = 0 -> true
		ListNode head2 = buildList(new int[] { 1, 2 }, 0);
		System.out.println("Example 2: " + hasCycle(head2));

		// Example 3: [1], pos = -1 -> false
		ListNode head3 = buildList(new int[] { 1 }, -1);
		System.out.println("Example 3: " + hasCycle(head3));

		// Extra: empty list -> false
		ListNode head4 = buildList(new int[] {}, -1);
		System.out.println("Empty list: " + hasCycle(head4));
	}

}
