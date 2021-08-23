package main;

public class Main {

	public static void main(String[] args) {
		Node nodeFive = new Node(5);
		LinkedList linkedList = new LinkedList(nodeFive);
		linkedList.addNode(6);
		System.out.println(nodeFive.getNext().getData());
		System.out.println(linkedList.getCount());
		linkedList.removeNode();
		System.out.println(linkedList.getCount());
		System.out.println(nodeFive.getNext());
		linkedList.addNode(7);
		linkedList.addNode(9);
		System.out.println(linkedList.get(3));
	}

}