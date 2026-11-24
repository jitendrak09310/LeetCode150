package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

	private static boolean isSameTreeIterative(Node p, Node q) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(p);
		queue.add(q);

		while (!queue.isEmpty()) {
			Node a = queue.poll();
			Node b = queue.poll();
			if (a == null && b == null)
				continue;

			if (a == null || b == null || a.key != b.key)
				return false;
			queue.add(a.left);
			queue.add(b.left);
			queue.add(a.right);
			queue.add(a.right);
		}

		return true;
	}

	private static boolean isSameTreeRecursive(Node p, Node q) {
		if (p == null && q == null)
			return true;

		if (p == null || q == null)
			return false;

		if (p.key != q.key)
			return false;

		return isSameTreeIterative(p.left, q.left) && isSameTreeIterative(p.right, q.right);
	}

	public static void main(String[] args) {

		// Example 1: p = [1,2,3], q = [1,2,3]
		Node p1 = new Node(1);
		p1.left = new Node(2);
		p1.right = new Node(3);
		Node q1 = new Node(1);
		q1.left = new Node(2);
		q1.right = new Node(3);
		System.out.println("Example 1: " + isSameTreeRecursive(p1, q1) + " / " + isSameTreeIterative(p1, q1)); // true /
																												// true

		// Example 2: p = [1,2], q = [1,null,2]
		Node p2 = new Node(1);
		p2.left = new Node(2);
		Node q2 = new Node(1);
		q2.right = new Node(2);
		System.out.println("Example 2: " + isSameTreeRecursive(p2, q2) + " / " + isSameTreeIterative(p2, q2)); // false
																												// /
																												// false

		// Example 3: p = [1,2,1], q = [1,1,2]
		Node p3 = new Node(1);
		p3.left = new Node(2);
		p3.right = new Node(1);
		Node q3 = new Node(1);
		q3.left = new Node(1);
		q3.right = new Node(2);
		System.out.println("Example 3: " + isSameTreeRecursive(p3, q3) + " / " + isSameTreeIterative(p3, q3)); // false
																												// /
																												// false

		// Edge case: both empty
		System.out.println("Both empty: " + isSameTreeRecursive(null, null)); // true
	}

}
