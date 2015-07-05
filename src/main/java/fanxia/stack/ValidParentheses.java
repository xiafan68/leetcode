package fanxia.stack;

import java.util.Stack;

import junit.framework.Assert;

public class ValidParentheses {

	private boolean isPair(char a, char b) {
		if (a == '(' && b == ')')
			return true;
		else if (a == '[' && b == ']')
			return true;
		else if (a == '{' && b == '}')
			return true;
		return false;
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(s.charAt(i));
			} else if (isPair(stack.peek(), s.charAt(i))) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses sol = new ValidParentheses();
		Assert.assertEquals(true, sol.isValid(""));
		Assert.assertEquals(false, sol.isValid("["));
		Assert.assertEquals(false, sol.isValid("("));
		Assert.assertEquals(false, sol.isValid("{"));
		Assert.assertEquals(false, sol.isValid("[["));
		Assert.assertEquals(false, sol.isValid("[[[[]"));
		Assert.assertEquals(false, sol.isValid("[(])"));
		Assert.assertEquals(true, sol.isValid("[]()"));
	}
}
