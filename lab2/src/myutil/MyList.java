package myutil;

public class MyList<L> {

	private Node<L> first;
	private Node<L> last;
	private int size = 0;

	public void add(L i) {

		if (size == 0) {
			first = new Node<L>(i, null); // first = new Node(i, null);
			last = first;
		} else {
			last.setNext(new Node<L>(i, null));
			last = last.getNext();
		}
		++size;
	}

	public L getElementAt(int i) throws wrongAmountException {

		if (first == null || size < i) {
			throw new wrongAmountException();
		}

		Node<L> temp;
		temp = first;

		for (int j = 0; j < i; ++j) {
			temp = temp.getNext();
		}
		return temp.getData();
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
