package linkedList;

public class RemoveDuplicatesII {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	// O(n) time, O(1) space
	static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy; // last node known to be kept
		ListNode curr = head;

		while (curr != null) {
			if (curr.next != null && curr.val == curr.next.val) {
				int dupVal = curr.val;
				// Skip every node with this value
				while (curr != null && curr.val == dupVal) {
					curr = curr.next;
				}
				prev.next = curr;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}

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
		System.out.println(toText(deleteDuplicates(build(1, 2, 3, 3, 4, 4, 5)))); // [1,2,5]
		System.out.println(toText(deleteDuplicates(build(1, 1, 1, 2, 3)))); // [2,3]
		System.out.println(toText(deleteDuplicates(build(1, 1)))); // []
		System.out.println(toText(deleteDuplicates(build(1, 2, 3)))); // [1,2,3]
	}
}
