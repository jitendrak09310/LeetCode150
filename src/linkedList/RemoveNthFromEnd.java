package linkedList;

public class RemoveNthFromEnd {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	// One pass, O(n) time, O(1) space
	static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode fast = dummy;
		ListNode slow = dummy;

		// Gap of n between the two pointers
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		// When fast reaches the last node, slow is just before the target
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return dummy.next;
	}

	static ListNode build(int... values) {
		ListNode dummy = new ListNode(0), tail = dummy;
		for (int v : values) {
			tail.next = new ListNode(v);
			tail = tail.next;
		}
		return dummy.next;
	}

	static String toText(ListNode head) {
		StringBuilder sb = new StringBuilder("[");
		for (ListNode c = head; c != null; c = c.next) {
			sb.append(c.val);
			if (c.next != null)
				sb.append(",");
		}
		return sb.append("]").toString();
	}

	public static void main(String[] args) {
		System.out.println(toText(removeNthFromEnd(build(1, 2, 3, 4, 5), 2))); // [1,2,3,5]
		System.out.println(toText(removeNthFromEnd(build(1), 1))); // []
		System.out.println(toText(removeNthFromEnd(build(1, 2), 1))); // [1]
		System.out.println(toText(removeNthFromEnd(build(1, 2), 2))); // [2]
	}
}
