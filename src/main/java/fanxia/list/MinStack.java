package fanxia.list;

import java.util.Stack;

class MinStack {
	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		if (minStack.isEmpty()) {
			minStack.push(x);
		} else {
			minStack.push(Math.min(minStack.peek(), x));
		}
		data.push(x);
	}

	public void pop() {
		data.pop();
		minStack.pop();
	}

	public int top() {
		return data.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
