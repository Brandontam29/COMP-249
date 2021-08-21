package main;

public class Node {
		// Variables
		int generic;
		Node next;

		// Constructors
		public Node(int data) {
			this.generic = data;
			next = null;
		}

		public Node(int data, Node next) {
			this.generic = data;
			this.next = next;
		}

		// Getters and Setters
		public int getData() {
			return this.generic;
		}

		public void setValue(int data) {
			this.generic = data;
		}

		public Node getNext() {
			return this.next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

}
