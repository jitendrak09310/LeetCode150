package linkedList;

public class ReverseNodesInKGroup {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	// O(n) time, O(1) space
	static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode groupPrev = dummy;

		while (true) {
			ListNode kth = getKth(groupPrev, k);
			if (kth == null)
				break; // fewer than k nodes left

			ListNode groupNext = kth.next;

			// Reverse the group; its first node ends up pointing at groupNext
			ListNode prev = groupNext;
			ListNode curr = groupPrev.next;
			while (curr != groupNext) {
				ListNode tmp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = tmp;
			}

			// Reconnect: old first node of the group is now its tail
			ListNode oldFirst = groupPrev.next;
			groupPrev.next = kth;
			groupPrev = oldFirst;
		}

		return dummy.next;
	}

	// Returns the k-th node after start, or null if there are fewer than k nodes
	static ListNode getKth(ListNode start, int k) {
		ListNode curr = start;
		while (curr != null && k > 0) {
			curr = curr.next;
			k--;
		}
		return curr;
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
		System.out.println(toText(reverseKGroup(build(1, 2, 3, 4, 5), 2))); // [2,1,4,3,5]
		System.out.println(toText(reverseKGroup(build(1, 2, 3, 4, 5), 3))); // [3,2,1,4,5]
		System.out.println(toText(reverseKGroup(build(1, 2, 3, 4, 5, 6), 3))); // [3,2,1,6,5,4]
		System.out.println(toText(reverseKGroup(build(1, 2, 3), 1))); // [1,2,3]
	}
}
