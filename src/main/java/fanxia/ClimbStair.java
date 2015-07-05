package fanxia;

import junit.framework.Assert;

import org.junit.Test;

public class ClimbStair {
	/**
	 * 居然是用斐波那契公式计算的
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		int a = 0;
		int ret = 1;
		for (int i = 1; i <= n; i++) {
			int tmp = ret + a;
			a = ret;
			ret = tmp;
		}
		return ret;
	}

	public int climbStairs1(int n) {
		if (n == 0)
			return 0;
		int ret = 0;
		for (int i = 0; i * 2 <= n; i++) {
			int totalSteps = n - i;
			ret += combine(totalSteps, i);
		}
		return ret;
	}

	public int combine(int total, int n) {
		int denom = 1;
		for (int i = n + 1; i <= total; i++) {
			denom *= i;
		}
		int nom = 1;
		for (int i = 1; i <= total - n; i++)
			nom *= i;
		return denom / nom;
	}

	@Test
	public void climbStairsTest() {
		ClimbStair sol = new ClimbStair();
		Assert.assertEquals(3, sol.climbStairs(3));
		//Assert.assertEquals(0, sol.climbStairs(0));
		Assert.assertEquals(1, sol.climbStairs(1));
		Assert.assertEquals(2, sol.climbStairs(2));
		Assert.assertEquals(5, sol.climbStairs(4));
		//Assert.assertEquals(5, sol.climbStairs(35));
	}
}
