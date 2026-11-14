package linkedList;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	// Definition for a Node.
	static class Node {
		int val;
		Node next;
		Node random;

		Node(int val) {
			this.val = val;
		}
	}

	// HashMap solution: O(n) time, O(n) space
	static Node copyRandomList(Node head) {
		if (head == null)
			return null;

		Map<Node, Node> map = new HashMap<>();

		// Pass 1: create a copy of each node
		for (Node curr = head; curr != null; curr = curr.next) {
			map.put(curr, new Node(curr.val));
		}

		// Pass 2: wire up next and random on the copies
		for (Node curr = head; curr != null; curr = curr.next) {
			Node copy = map.get(curr);
			copy.next = map.get(curr.next); // null key -> null
			copy.random = map.get(curr.random); // null key -> null
		}

		return map.get(head);
	}

	// O(1) extra space solution (interweaving)
	static Node copyRandomListO1(Node head) {
		if (head == null)
			return null;

		// Step 1: A -> A' -> B -> B' -> ...
		for (Node curr = head; curr != null;) {
			Node copy = new Node(curr.val);
			copy.next = curr.next;
			curr.next = copy;
			curr = copy.next;
		}

		// Step 2: set random pointers on the copies
		for (Node curr = head; curr != null; curr = curr.next.next) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
		}

		// Step 3: separate the lists and restore the original
		Node newHead = head.next;
		for (Node curr = head; curr != null;) {
			Node copy = curr.next;
			curr.next = copy.next;
			copy.next = (copy.next != null) ? copy.next.next : null;
			curr = curr.next;
		}

		return newHead;
	}

	// ---------- Helpers for testing ----------

	// Build a list from [val, random_index] pairs (null = no random pointer)
	static Node build(Integer[][] data) {
		if (data.length == 0)
			return null;

		Node[] nodes = new Node[data.length];
		for (int i = 0; i < data.length; i++) {
			nodes[i] = new Node(data[i][0]);
		}
		for (int i = 0; i < data.length; i++) {
			if (i + 1 < data.length)
				nodes[i].next = nodes[i + 1];
			if (data[i][1] != null)
				nodes[i].random = nodes[data[i][1]];
		}
		return nodes[0];
	}

	// Print a list in the [[val, random_index], ...] format
	static String toText(Node head) {
		Map<Node, Integer> index = new IdentityHashMap<>();
		int i = 0;
		for (Node c = head; c != null; c = c.next)
			index.put(c, i++);

		StringBuilder sb = new StringBuilder("[");
		for (Node c = head; c != null; c = c.next) {
			sb.append("[").append(c.val).append(",").append(c.random == null ? "null" : index.get(c.random))
					.append("]");
			if (c.next != null)
				sb.append(",");
		}
		return sb.append("]").toString();
	}

	// True if no node in the copy is (or points to) a node of the original
	static boolean isDeepCopy(Node original, Node copy) {
		Map<Node, Boolean> originals = new IdentityHashMap<>();
		for (Node c = original; c != null; c = c.next)
			originals.put(c, true);

		for (Node c = copy; c != null; c = c.next) {
			if (originals.containsKey(c))
				return false;
			if (c.random != null && originals.containsKey(c.random))
				return false;
		}
		return true;
	}

	static void runTest(String name, Integer[][] data) {
		Node head = build(data);
		String before = toText(head);

		Node copy1 = copyRandomList(head);
		Node copy2 = copyRandomListO1(head);

		System.out.println(name);
		System.out.println("  Input         : " + before);
		System.out.println("  HashMap copy  : " + toText(copy1) + "  deep copy? " + isDeepCopy(head, copy1));
		System.out.println("  O(1) copy     : " + toText(copy2) + "  deep copy? " + isDeepCopy(head, copy2));
		System.out.println("  Original intact: " + before.equals(toText(head)));
		System.out.println();
	}

	public static void main(String[] args) {
		runTest("Example 1", new Integer[][] { { 7, null }, { 13, 0 }, { 11, 4 }, { 10, 2 }, { 1, 0 } });
		runTest("Example 2", new Integer[][] { { 1, 1 }, { 2, 1 } });
		runTest("Example 3", new Integer[][] { { 3, null }, { 3, 0 }, { 3, null } });
		runTest("Empty list", new Integer[][] {});
	}
}