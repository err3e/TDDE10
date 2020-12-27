package myutil;

public class Test {

	// Node

	public static void nodeTest() {

		Node<String> node1 = new Node<String>("ett", null);
		Node<String> node2 = new Node<String>("två", node1);
		Node<String> node3 = new Node<String>("tre", node2);
		Node<String> node4 = new Node<String>("fyra", node3);

		System.out.println(node1.getData());
		System.out.println(node2.getData());

		Node<String> nodeLoop = new Node<String>("fem", node4);

		System.out.println(node3.getData());
		System.out.println("Loopen: ");

		while (true) {
			System.out.println(nodeLoop.getData());
			if (nodeLoop.getNext() == null) {
				break;
			}
			nodeLoop = nodeLoop.getNext();
		}
	}

	// MyStack

	public static void stackTest() {

		MyStack<String> stack = new MyStack<String>();

		stack.push("ett");
		stack.push("hej");
		stack.push("tre");
		stack.push("fyra");

		System.out.println("Stackens storlek: " + stack.size());
		System.out.println("Stackens element: ");

		while (!stack.isEmpty()) {
			try {
				System.out.println(stack.pop());
			} catch (wrongAmountException e) {
				System.out.println("Nu blev de fel du.");
			}
		}
		
		try {
			System.out.println(stack.pop());
		} catch (wrongAmountException e) {
			System.out.println("Nu blev de fel du.");
		}

		stack.push("hej");
		
		System.out.println("Stackens storlek: " + stack.size());

		// Test med int.

		Integer a = new Integer(453);
		MyStack<Integer> intStack = new MyStack<Integer>();

		intStack.push(a);
		intStack.push(a);
		intStack.push(a);
		intStack.push(a);

		System.out.println("Stackens storlek: " + intStack.size());
		System.out.println("Stackens element: ");
		while (!intStack.isEmpty()) {
			try {
				intStack.pop().printYourSelf();
			} catch (wrongAmountException e) {
				System.out.println("Nu blev de fel du.");
			}
		}
		System.out.println("Stackens storlek: " + intStack.size());
	}

	// MyQueue

	public static void queueTest() {

		MyQueue<String> queue = new MyQueue<String>();
		System.out.println("Queue: ");
		queue.enqueue("ett");
		queue.enqueue("två");
		queue.enqueue("tre");
		queue.enqueue("fyra");
		System.out.println("Storleken Ãr: " + queue.size());

		while (!queue.isEmpty()) {

			try {
				System.out.println(queue.dequeue());
			} catch (wrongAmountException e) {
				System.out.println("Nu blev de fel du.");
			}
		}
		
		try {
			System.out.println(queue.dequeue());
		} catch (wrongAmountException e) {
			System.out.println("Nu blev de fel du.");
		}
		
		queue.enqueue("ett");
		queue.enqueue("två");
		queue.enqueue("tre");
		queue.enqueue("fyra");
		System.out.println("Storleken Ãr: " + queue.size());

		try {
			System.out.println(queue.dequeue());
		} catch (wrongAmountException e) {
			System.out.println("Nu blev de fel du.");
		}
		System.out.println("Storleken Ãr: " + queue.size());
	
	
	Integer b = new Integer(352);
	MyQueue<Integer> intQueue = new MyQueue<Integer>();
	System.out.println("Queue: ");
	intQueue.enqueue(b);
	intQueue.enqueue(b);
	intQueue.enqueue(b);
	intQueue.enqueue(b);
	System.out.println("Storleken Ãr: " + intQueue.size());
	
	while (!intQueue.isEmpty()) {

		try {
			intQueue.dequeue().printYourSelf();
		} catch (wrongAmountException e) {
			System.out.println("Nu blev de fel du.");
		}
	}
	System.out.println("Storleken Ãr: " + intQueue.size());
	}

	// MyList

	public static void listTest() {

		MyList<String> mylist = new MyList<String>();

		mylist.add("noll");
		mylist.add("ett");
		mylist.add("två");
		mylist.add("tre");
		mylist.add("fyra");

		// Indexerat från 0.

		System.out.println("Värdet i listan på valt index: ");
		try {
			System.out.println(mylist.getElementAt(3));
		} catch (wrongAmountException e) {
			System.out.println("Nu blev de fel du.");
		}
		
		try {
			System.out.println(mylist.getElementAt(10));
		} catch (wrongAmountException e) {
			System.out.println("Nu blev de fel du.");
		}
		
		
		MyList<Integer> myIntList = new MyList<Integer>();
		Integer c = new Integer(1337);
		Integer d = new Integer(85769);
		
		myIntList.add(c);
		myIntList.add(d);
		myIntList.add(c);
		myIntList.add(d);
		
		System.out.println("Värdet i listan på valt index: ");
		try {
			myIntList.getElementAt(3).printYourSelf();
		} catch (wrongAmountException e) {
			System.out.println("Nu blev de fel du.");
		}
		
		System.out.println("Värdet i listan på valt index: ");
		try {
			myIntList.getElementAt(2).printYourSelf();
		} catch (wrongAmountException e) {
			System.out.println("Nu blev de fel du.");
		}
	}

	public static void main(String[] args) throws wrongAmountException {

		//nodeTest();
		//stackTest();
		//queueTest();
		listTest();

	}

}