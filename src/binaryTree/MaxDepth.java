package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

	public static int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int depth = 0;
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node node = queue.poll();
				if (node.left != null)
					queue.add(node.left);

				if (node.right != null)
					queue.add(node.right);
			}
			depth++;

		}

		return depth;
	}

	public static void main(String[] args) {
		Node root1 = new Node(3);
		root1.left = new Node(9);
		root1.right = new Node(20);
		root1.right.left = new Node(15);
		root1.right.right = new Node(7);

		System.out.println("Example 1 (iterative): " + maxDepth(root1)); // 3

		// Example 2: [1,null,2]
		// 1
		// \
		// 2
		Node root2 = new Node(1);
		root2.right = new Node(2);

		System.out.println("Example 2 (iterative): " + maxDepth(root2)); // 2

		// Edge case: empty tree
		System.out.println("Empty tree: " + maxDepth(null)); // 0
	}

}
