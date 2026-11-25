package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {

	public static Node inverTree(Node root) {
		if (root == null)
			return null;

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			Node temp = node.left;
			node.left = node.right;
			node.right = temp;

			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return root;
	}

	public static Node invertTreeUsingRecursion(Node root) {
		if (root == null)
			return null;
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTreeUsingRecursion(root.left);
		invertTreeUsingRecursion(root.right);
		return root;
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
		int[] values = { 4, 2, 7, 1, 3, 6, 9 };

		for (int v : values) {
			root = insertValueInTree(root, v); // or insertBST(root, v)
		}

		InvertBinaryTree solution = new InvertBinaryTree();
		Node inverted = solution.inverTree(root);
		System.out.println(toList(inverted)); // [4, 7, 2, 9, 6, 3, 1]
	}

}
