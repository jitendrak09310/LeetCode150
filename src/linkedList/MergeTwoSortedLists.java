package linkedList;

import java.util.*;

import linkedList.MergeTwoSortedLists.ListNode;

public class MergeTwoSortedLists {
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

	static String toString(ListNode head) {
		List<Integer> out = new ArrayList<>();
		while (head != null) {
			out.add(head.val);
			head = head.next;
		}
		return out.toString();
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode();
		ListNode curr = dummy;

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				curr.next = list1;
				list1 = list1.next;
			} else {
				curr.next = list2;
				list2 = list2.next;
			}
			curr = curr.next;
		}

		curr.next = (list1 != null) ? list1 : list2;
		return dummy.next;
	}

	public static void main(String[] args) {
//		/ Expected [1, 1, 2, 3, 4, 4]
		System.out.println(toString(mergeTwoLists(build(new int[] { 1, 2, 4 }), build(new int[] { 1, 3, 4 }))));

		// Expected []
		System.out.println(toString(mergeTwoLists(build(new int[] {}), build(new int[] {}))));

		// Expected [0]
		System.out.println(toString(mergeTwoLists(build(new int[] {}), build(new int[] { 0 }))));

	}

}
