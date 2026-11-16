package linkedList;

public class RotateLinkedList {

	static class ListNode {

		int val;
		ListNode next;

		ListNode() {

		}

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

		// Create linked list: 1 -> 2 -> 3 -> 4 -> 5
		ListNode head = createList(1, 2, 3, 4, 5);

		int k = 2;

		System.out.println("Original List:");
		printList(head);

		// Rotate the linked list
		ListNode result = rotateRight(head, k);

		System.out.println("After Rotation:");
		printList(result);
	}

	// Helper method to create linked list
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

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}

		int length = 1;
		ListNode tail = head;

		while (tail.next != null) {
			tail = tail.next;
			length++;
		}

		k = k % length;
		if (k == 0) {
			return head;
		}

		tail.next = head;

		int stepsToNewTail = length - k;

		ListNode newTail = head;

		for (int i = 1; i < stepsToNewTail; i++) {
			newTail = newTail.next;
		}

		ListNode newHead = newTail.next;

		newTail.next = null;

		return newHead;
	}
}
