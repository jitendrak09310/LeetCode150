package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsSymmetric {

	public static boolean isSymmetric(Node root) {
		if (root == null)
			return true;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);

		while (!queue.isEmpty()) {
			Node a = queue.poll();// left
			Node b = queue.poll();// right

			if (a == null && b == null)
				continue;
			if (a == null || b == null || a.key != b.key)
				return false;

			queue.add(a.left);
            queue.add(b.right);
            queue.add(a.right);
            queue.add(b.left);
		}
		return true;
	}

	public static Node insertValueInTree(Node root, int val) {
		Node newNode = new Node(val);

		if (root == null)
			return newNode;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.left == null) {
				node.left = newNode;
				break;
			} else {
				queue.add(node.left);
			}

			if (node.right == null) {
				node.right = newNode;
				break;
			} else {
				queue.add(node.right);
			}
		}
		return root;
	}

	static List<Integer> toList(Node root) {
		List<Integer> result = new ArrayList();
		if (root == null) {
			return result;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node == null) {
				result.add(null);
				continue;
			}
			result.add(node.key);
			queue.add(node.left);
			queue.add(node.right);
		}

		while (!result.isEmpty() && result.get(result.size() - 1) == null) {
			result.remove(result.size() - 1);
		}
		return result;
	}

	public static void main(String[] args) {
		Node root = null;
//		int[] values = { 4, 2, 7, 1, 3, 6, 9 };
//		int[] values = { 1, 2, 2, 3, 3 };
		int[] values = { 1, 2, 2, 3, 4, 4, 3 };
		for (int v : values) {
			root = insertValueInTree(root, v); // or insertBST(root, v)
		}

		boolean symmetric = isSymmetric(root);
		System.out.println(symmetric); // [4, 7, 2, 9, 6, 3, 1]
	}

}
