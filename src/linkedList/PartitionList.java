package linkedList;

import linkedList.PartitionList.ListNode;

public class PartitionList {
	public static class ListNode {
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

	public static void main(String[] args) {
		ListNode head = createList(1, 4, 3, 2, 5, 2);

		int k = 3;

		System.out.println("Original List:");
		printList(head);

		// Partition the linked list
		ListNode result = Partition(head, k);

		System.out.println("After Partition:");
		printList(result);
	}

	public static ListNode createList(int... values) {

		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		for (int value : values) {
			current.next = new ListNode(value);
			current = current.next;
		}

		return dummy.next;
	}

	public static void printList(ListNode head) {

		ListNode current = head;

		while (current != null) {
			System.out.print(current.val);

			if (current.next != null) {
				System.out.print(" -> ");
			}

			current = current.next;
		}

		System.out.println(" -> null");
	}

	public static ListNode Partition(ListNode head, int x) {

		ListNode small = new ListNode(0);
		ListNode large = new ListNode(0);

		ListNode smallHead = small;
		ListNode largeHead = large;

		while (head != null) {
			if (head.val < x) {
				small.next = head;
				small = small.next;
			} else {
				large.next = head;
				large = large.next;
			}
			head = head.next;
		}

		large.next = null;
		small.next = largeHead.next;
		return smallHead.next;
	}
}
