package fanxia.stack;

import java.util.Stack;

class MyQueue {
	private Stack<Integer> addStack = new Stack<Integer>();
	private Stack<Integer> popStack = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		addStack.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		transfer();
		if (!popStack.isEmpty())
			popStack.pop();
	}

	private void transfer() {
		if (popStack.isEmpty()) {
			while (!addStack.isEmpty()) {
				popStack.push(addStack.pop());
			}
		}
	}

	// Get the front element.
	public int peek() {
		transfer();
		return popStack.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return popStack.isEmpty() && addStack.isEmpty();
	}
}