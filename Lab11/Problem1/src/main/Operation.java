package main;

public class Operation {
	// Variables
	Node head;
	int count;

	// Constructors
	public Operation() {
		this.head = null;
		this.count = 0;
	}

	public Operation(Node head) {
		this.head = head;
		this.count = 1;
	}

	// Methods
	public void addNode(int generic) {
		Node current = head;
		Node temp = new Node(generic);

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

		else if (this.count == 1) {
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
}
