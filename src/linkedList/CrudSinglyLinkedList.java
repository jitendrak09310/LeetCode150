package linkedList;

public class CrudSinglyLinkedList {

	public static void main(String[] args) {
		CrudSinglyLinkedList list = new CrudSinglyLinkedList();
		list.addLast(10);
		list.addLast(30);
		list.insertAfter(10, 20); // 10 -> 20 -> 30 -> null
		list.print();
		list.update(20, 25); // 10 -> 25 -> 30 -> null
		System.out.println();
		list.print();
		list.delete(25); // 10 -> 30 -> null
		System.out.println();
		list.print();
	}

	Node head;

	void addFirst(int value) {
//		head --> value
		Node n = new Node(value);
		n.next = head;
		head = n;
	}

	void addLast(int value) {
		Node n = new Node(value);
		if (head == null) {
			head = n;
			return;
		}
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = n;
	}

	void insertAfter(int target, int value) {
		Node cur = head;
		while (cur != null && cur.data != target) {
			cur = cur.next;
		}
		if (cur == null) {
			return;
		}
		Node n = new Node(value);
		n.next = cur.next;
		cur.next = n;

	}

	boolean contains(int value) {
		for (Node cur = head; cur != null; cur = cur.next) {
			if (cur.data == value) {
				return true;
			}
		}
		return false;
	}

	void print() {
		for (Node cur = head; cur != null; cur = cur.next) {
			System.out.print(cur.data + " - > ");
		}
		System.out.print("null");
	}

	boolean update(int oldValue, int newValue) {

		for (Node cur = head; cur != null; cur = cur.next) {
			if (cur.data == oldValue) {
				cur.data = newValue;
				return true;
			}
		}
		return false;
	}

	boolean delete(int value) {
		if (head == null) {
			return false;
		}
		if (head.data == value) {
			head = head.next;
			return true;
		}

		Node prev = head;

		while (prev.next != null && prev.next.data != value) {
			prev = prev.next;
		}
		if (prev.next == null) {
			return false;
		}
		prev.next = prev.next.next;

		return true;
	}

}
