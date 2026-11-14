package linkedList;

public class ReverseLinkedListII {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	// O(n) time, O(1) space
	static ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || left == right)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// prev stops just before the left-th node
		ListNode prev = dummy;
		for (int i = 1; i < left; i++) {
			prev = prev.next;
		}

		// Move the node after curr to the front of the sublist, right-left times
		ListNode curr = prev.next;
		for (int i = 0; i < right - left; i++) {
			ListNode next = curr.next;
			curr.next = next.next;
			next.next = prev.next;
			prev.next = next;
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
		System.out.println(toText(reverseBetween(build(1, 2, 3, 4, 5), 2, 4))); // [1,4,3,2,5]
		System.out.println(toText(reverseBetween(build(5), 1, 1))); // [5]
		System.out.println(toText(reverseBetween(build(1, 2, 3), 1, 3))); // [3,2,1]
		System.out.println(toText(reverseBetween(build(3, 5), 1, 2))); // [5,3]
	}
}
