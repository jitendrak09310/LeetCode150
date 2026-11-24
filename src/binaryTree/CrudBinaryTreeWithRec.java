package binaryTree;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		this.key = item;
		left = right = null;
	}

}

public class CrudBinaryTreeWithRec {
	Node root;

	public CrudBinaryTreeWithRec() {
		root = null;
	}

	public void insert(int key) {
		root = insertRec(root, key);
	}

	private Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}

		return root;
	}

	public void inOrder() {
		inOrderRec(root);
	}

	private void inOrderRec(Node root) {
		if (root != null) {
			inOrderRec(root.left);
			System.out.println(root.key + " ");
			inOrderRec(root.right);
		}
	}

	private boolean search(int key) {
		return searchRec(root, key);
	}

	private boolean searchRec(Node root, int key) {
		if (root == null) {
			return false;
		}
		if (root.key == key) {
			return true;
		}
		if (key < root.key) {
			return searchRec(root.left, key);
		} else {
			return searchRec(root.right, key);
		}
	}

	public int findMin() {
		return findMinRec(root);
	}

	private int findMinRec(Node root) {
		if (root == null) {
			throw new IllegalStateException("Tree is empty");
		}
		if (root.left == null) {
			return root.key;
		}
		return findMinRec(root.left);
	}

	public int findMax() {
		return findMaxRec(root);
	}

	private int findMaxRec(Node root) {
		if (root == null) {
			throw new IllegalStateException("Tree is empty");
		}
		if (root.right == null) {
			return root.key;
		}
		return findMaxRec(root.right);
	}

	public static void main(String[] args) {
		CrudBinaryTreeWithRec tree = new CrudBinaryTreeWithRec();

		// Insert some nodes
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// Print inorder traversal of the tree
		System.out.println("Inorder traversal:");
		tree.inOrder();
		// Output: 20 30 40 50 60 70 80

		// Search for a key
		int searchKey = 400;
		if (tree.search(searchKey))
			System.out.println("\nKey " + searchKey + " found in the tree.");
		else
			System.out.println("\nKey " + searchKey + " not found in the tree.");

		// Find minimum and maximum values
		System.out.println("Minimum value in the tree: " + tree.findMin());
		System.out.println("Maximum value in the tree: " + tree.findMax());
	}
}
