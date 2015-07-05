package fanxia.stack;

import java.util.Stack;

import junit.framework.Assert;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * @author xiafan
 *
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int longest = 0;
		int curLen = 0;
		Stack<Character> paren = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				if (paren.isEmpty() || paren.peek() == ')') {
					longest = Math.max(longest, curLen);
					curLen = 0;
				}
				paren.add('(');
			} else {
				if (!paren.isEmpty() && paren.peek() == '(') {
					curLen += 2;
					paren.pop();
				} else {
					longest = Math.max(longest, curLen);
					curLen = 0;
				}
			}
		}
		longest = Math.max(longest, curLen);
		return longest;
	}

	public static void main(String[] args) {
		LongestValidParentheses sol = new LongestValidParentheses();
		Assert.assertEquals(2, sol.longestValidParentheses("()"));
		Assert.assertEquals(4, sol.longestValidParentheses("()()"));
		Assert.assertEquals(2, sol.longestValidParentheses(")()"));
		Assert.assertEquals(4, sol.longestValidParentheses(")()()(()()"));
		Assert.assertEquals(6, sol.longestValidParentheses("(()())"));
		Assert.assertEquals(0, sol.longestValidParentheses("(("));
		Assert.assertEquals(0, sol.longestValidParentheses("("));
		Assert.assertEquals(2, sol.longestValidParentheses("()(()"));

	}
}
