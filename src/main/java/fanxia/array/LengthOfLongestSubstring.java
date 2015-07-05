package fanxia.array;

import java.util.HashMap;

import junit.framework.Assert;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int ret = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char curChar = s.charAt(i);
			if (map.containsKey(curChar)) {
				ret = Math.max(ret, map.size());
				for (int j = map.get(curChar) - 1; j >= 0; j--) {
					if (map.containsKey(s.charAt(j))
							&& map.get(s.charAt(j)) == j) {
						map.remove(s.charAt(j));
					} else {
						break;
					}
				}
			}
			map.put(curChar, i);
		}
		// 如果字符串最长字串出现在末尾，可能就会忘掉统计
		ret = Math.max(ret, map.size());

		return ret;
	}

	public static void main(String[] args) {
		LengthOfLongestSubstring sol = new LengthOfLongestSubstring();

		Assert.assertEquals(sol.lengthOfLongestSubstring("bpfbhmipx"), 7);
		Assert.assertEquals(sol.lengthOfLongestSubstring("pkwkww"), 3);
		Assert.assertEquals(sol.lengthOfLongestSubstring("pwwkew"), 3);
		Assert.assertEquals(sol.lengthOfLongestSubstring("abba"), 2);
		Assert.assertEquals(sol.lengthOfLongestSubstring("ssa"), 2);
		Assert.assertEquals(sol.lengthOfLongestSubstring("ssas"), 2);
		Assert.assertEquals(sol.lengthOfLongestSubstring("s"), 1);
		Assert.assertEquals(sol.lengthOfLongestSubstring("ss"), 1);
		Assert.assertEquals(sol.lengthOfLongestSubstring("sass"), 2);
		Assert.assertEquals(sol.lengthOfLongestSubstring("sassab"), 3);
	}
}
