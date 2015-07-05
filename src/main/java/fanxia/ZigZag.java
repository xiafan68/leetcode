package fanxia;

import junit.framework.Assert;

public class ZigZag {
	/**
	 * 通过总结zigzag规律的方式直接组装，不是很直观
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convert(String s, int nRows) {
		if (nRows == 1)
			return s;
		StringBuffer buf = new StringBuffer();
		int base = 2 * nRows - 2;
		for (int i = 0; i < nRows && i < s.length(); i++) {
			int j = 0;
			int ord = base * j - i;
			while (ord < s.length()) {
				if (ord >= 0)
					buf.append(s.charAt(ord));
				if (i != 0 && i != nRows - 1) {
					if (ord + 2 * i < s.length())
						buf.append(s.charAt(ord + 2 * i));
				}
				j++;
				ord = base * j - i;
			}
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		ZigZag sol = new ZigZag();
		Assert.assertEquals("PAYPALISHIRING",
				sol.convert("PAYPALISHIRING", 100));
		Assert.assertEquals("PAYPALISHIRING",
				sol.convert("PAYPALISHIRING", "PAYPALISHIRING".length()));
		Assert.assertEquals("PAHNAPLSIIGYIR", sol.convert("PAYPALISHIRING", 3));
		Assert.assertEquals("PYAIHRNAPLSIIG", sol.convert("PAYPALISHIRING", 2));
		Assert.assertEquals("PAYPALISHIRING", sol.convert("PAYPALISHIRING", 1));
	}
}
