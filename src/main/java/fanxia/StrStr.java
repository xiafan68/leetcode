package fanxia;

import junit.framework.Assert;

import org.junit.Test;

public class StrStr {
	/**
	 * return the first occurence of needle in haystack or -1
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		// 忘掉了needle是空的情况
		if (needle.length() > haystack.length()) {
			return -1;
		}
		int[] table = buildJumpTable(needle);

		int i = 0;
		int nIdx = 0;

		while (i < haystack.length() && nIdx < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(nIdx)) {
				i++;
				nIdx++;
			} else if (nIdx == 0) {
				i++;
			} else {
				nIdx = table[nIdx - 1] + 1;
			}
		}
		if (nIdx == needle.length()) {
			return i - needle.length();
		} else {
			return -1;
		}
	}

	/**
	 * 如果needle本身没有很多重复的pattern的话，这个方法和brute force没有什么区别
	 * @param needle
	 * @return
	 */
	private int[] buildJumpTable(String needle) {
		int[] table = new int[needle.length()];
		if (needle.isEmpty())
			return table;
		table[0] = -1;
		for (int i = 1; i < needle.length(); i++) {
			int dupIdx = table[i - 1] + 1;
			if (needle.charAt(i) == needle.charAt(dupIdx)) {
				table[i] = dupIdx;
			} else {
				table[i] = -1;
			}
		}
		return table;
	}

	@Test
	public void strStrTest() {
		StrStr test = new StrStr();
		Assert.assertEquals(4, test.strStr("mississippi", "issip"));
		Assert.assertEquals(0, test.strStr("", ""));
		Assert.assertEquals(0, test.strStr("sdf", ""));

		Assert.assertEquals(0, test.strStr("sadfsdf", "sa"));
		Assert.assertEquals(1, test.strStr("sasadfsdf", "asa"));
		Assert.assertEquals(0, test.strStr("asdfbsdasdfb", "asdfb"));
		Assert.assertEquals(6, test.strStr("sdfbsdasdfbsdf", "asdfb"));
	}
}
