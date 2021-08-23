package main;

public class LinkedList {
	// Variables
	Node head;
	int count;

	// Constructors
	public LinkedList() {
		this.head = null;
		this.count = 0;
	}

	public LinkedList(Node head) {
		this.head = head;
		this.count = 1;
	}

	// Methods
	public void addNode(int data) {
		Node current = head;
		Node temp = new Node(data);

		if (current == null) {
			this.head = temp;
			count += 1;
			return;
		}

		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		count += 1;
	}

	public void removeNode() {
		Node current = head;

		if (current == null) {
			System.out.println("no Nodes to remove, empty Linked List");
			return;
		}

		else if (getCount() == 1) {
			System.out.println("only one Node in Linked List, deleting Node");
			this.head = null;
			count--;
			return;
		}

		while (current.getNext().getNext() != null) {
			current = current.getNext();
		}
		current.setNext(null);
		count--;
	}

	public int getCount() {
		return this.count;
	}

	public Boolean isEmpty() {
		return getCount() == 0;
	}

	public int get(int nodeNum) {
		if (nodeNum <= 0) {
			return -1;
		}
		Node current = head;
		for (int i = 1; i < nodeNum; i++) {
			current = current.getNext();
		}
		return current.getData();
	}
}