package linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);

		lru.put(1, 10);
		lru.put(2, 20);

		System.out.println(lru.get(1)); // 10

		lru.put(3, 30); // Removes key 2

		System.out.println(lru.get(2)); // -1
		System.out.println(lru.get(3)); // 30

		lru.put(4, 40); // Removes key 1

		System.out.println(lru.get(1)); // -1
		System.out.println(lru.get(3)); // 30
		System.out.println(lru.get(4)); // 40
	}

	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	private Map<Integer, Node> map;
	private Node head;
	private Node tail;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();

		head = new Node(0, 0);
		tail = new Node(0, 0);

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node node = map.get(key);
		remove(node);
		addToFront(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			addToFront(node);
		} else {
			if (map.size() == capacity) {
				Node lru = tail.prev;
				remove(lru);
				map.remove(lru.key);
			}

			Node newNode = new Node(key, value);

			map.put(key, newNode);
			addToFront(newNode);
		}
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;  
	}

	private void addToFront(Node node) {
		node.next = head.next;
		node.prev = head;

		head.next.prev = node;
		head.next = node;
	}

}
