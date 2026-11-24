package binaryTree;

import java.util.Stack;

public class CrudBinaryTreeIterative {
	Node root;

	public CrudBinaryTreeIterative() {
		root = null;
	}

	public void insert(int key) {

		Node newNode = new Node(key);

		if (root == null) {
			root = newNode;
			return;
		}

		Node cur = root;
		Node parent = null;

		while (cur != null) {
			parent = cur;
			if (key < cur.key) {
				cur = cur.left;
			} else if (key > cur.key) {
				cur = cur.right;
			} else {
				return;
			}
		}

		if (key < parent.key) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
	}

	public void inOrder() {
		Stack<Node> stack = new Stack<>();

		Node cur = root;

		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			System.out.println(cur.key + " ");
			cur = cur.right;
		}
		System.out.println();

	}

	public boolean search(int key) {
		Node cur = root;
		while (cur != null) {
			if (key == cur.key) {
				return true;
			}
			cur = (key < cur.key) ? cur.left : cur.right;
		}

		return false;
	}

	public int findMin() {
		if (root == null) {
			throw new IllegalStateException("Tree is Empty");
		}
		Node cur = root;
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur.key;
	}

	public int findMax() {
		if (root == null) {
			throw new IllegalStateException("Tree is Empty");
		}
		Node cur = root;
		while (cur.right != null) {
			cur = cur.right;
		}
		return cur.key;
	}

	public static void main(String[] args) {
		CrudBinaryTreeIterative tree = new CrudBinaryTreeIterative();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Inorder traversal:");
		tree.inOrder(); // 20 30 40 50 60 70 80

		int searchKey = 400;
		if (tree.search(searchKey))
			System.out.println("Key " + searchKey + " found in the tree.");
		else
			System.out.println("Key " + searchKey + " not found in the tree.");

		System.out.println("Minimum value in the tree: " + tree.findMin());
		System.out.println("Maximum value in the tree: " + tree.findMax());
	}
}
