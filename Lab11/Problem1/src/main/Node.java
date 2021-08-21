package main;

public class Node<T> {
	// Variables
	T generic;
	Node<T> next;

	// Constructors
	public Node(T data) {
		this.generic = data;
		next = null;
	}

	public Node(T data, Node<T> next) {
		this.generic = data;
		this.next = next;
	}

	// Getters and Setters
	public T getData() {
		return this.generic;
	}

	public void setValue(T data) {
		this.generic = data;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}
