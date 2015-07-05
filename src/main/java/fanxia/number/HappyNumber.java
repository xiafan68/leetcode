package fanxia.number;

import java.util.Arrays;

/**
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * @author xiafan
 *	
 *重点是解决endless loop的问题，所以分析最大的可能值是多少
*
 */
public class HappyNumber {

	public boolean isHappy(int n) {
		boolean[] computed = new boolean[1000];
		Arrays.fill(computed, false);
		while (true) {
			n = next(n);
			if (n == 1) {
				return true;
			} else if (computed[n]) {
				return false;
			}
			computed[n] = true;
		}
	}

	private int next(int n) {
		int ret = 0;
		while (n > 0) {
			ret += Math.pow(n % 10, 2);
			n /= 10;
		}
		return ret;
	}

	public static void main(String[] args) {
		HappyNumber num = new HappyNumber();
		System.out.println(num.isHappy(19));
	}
}