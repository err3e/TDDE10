package myutil;

public class Node<D> { // public class Node<D, N>

	private D data;

	private Node<D> next; // private N next;

	public Node(D data, Node<D> next) { // D data, N next
		this.data = data;
		this.next = next;
	}

	// getters and setters

	public Node<D> getNext() {
		return next;
	}

	public D getData() {
		return data;
	}

	public void setNext(Node<D> next) {
		this.next = next;
	}
}