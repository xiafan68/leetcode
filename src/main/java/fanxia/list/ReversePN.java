package fanxia.list;

import java.util.Stack;

public class ReversePN {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		int right = 0, left = 0;
		for (int i = 0; i < tokens.length; i++) {
			switch (tokens[i]) {
			case "+":
				right = stack.pop();
				left = stack.pop();
				stack.push(left + right);
				break;
			case "-":
				right = stack.pop();
				left = stack.pop();
				stack.push(left - right);
				break;
			case "/":
				right = stack.pop();
				left = stack.pop();
				stack.push(left / right);
				break;
			case "*":
				right = stack.pop();
				left = stack.pop();
				stack.push(left * right);
				break;
			default:
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}
}