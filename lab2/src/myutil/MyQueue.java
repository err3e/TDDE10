package myutil;

public class MyQueue<Q> {

	private Node<Q> first;
	private Node<Q> last;
	private int size = 0;

	public MyQueue() {
	}

	public void enqueue(Q i) {

		if (size == 0) {
			first = new Node<Q>(i, null);
			last = first;
		} else {
			last.setNext(new Node<Q>(i, null));
			last = last.getNext();
			System.out.println();
		}
		++size;
	}

	public Q dequeue() throws wrongAmountException {

		if (first == null) {
			throw new wrongAmountException();
		}

		// kommer inte ens hit..

		Q returnData = first.getData();
		first = first.getNext();
		size--;
		return returnData;
	}

	public boolean isEmpty() {

		if (first == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return size;
	}
}
