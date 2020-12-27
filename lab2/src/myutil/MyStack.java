package myutil;

public class MyStack<T> {

	private Node<T> top;
	private int size = 0;

	public MyStack() {

	}

	public void push(T i) {

		Node<T> node = new Node<T>(i, top); // Node node = new Node(i, top);
		top = node;
		++size;
	}

	public T pop() throws wrongAmountException {

		if (top == null) {
			throw new wrongAmountException();
		}

		T returnData = top.getData();
		top = top.getNext();
		size--;
		return returnData;
	}

	public boolean isEmpty() {

		if (top == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return size;
	}
}