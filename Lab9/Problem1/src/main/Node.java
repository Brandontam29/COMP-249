package main;

public class Node {
	// Variables
	int data;
	Node next;

	// Constructors
	public Node(int data) {
		this.data = data;
		next = null;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	// Getters and Setters
	public int getData() {
		return this.data;
	}

	public void setValue(int data) {
		this.data = data;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
