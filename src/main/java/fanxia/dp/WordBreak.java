package fanxia.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

/**
 * 
 * @author xiafan
 *
 */
public class WordBreak {
	boolean[] endMatch;

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s.length() == 0)
			return false;
		endMatch = new boolean[s.length() + 1];
		Arrays.fill(endMatch, true);
		int maxLen = 0;
		for (String word : wordDict) {
			maxLen = Math.max(maxLen, word.length());
		}
		return wordBreak_recur(s, wordDict, 0, maxLen);
	}

	/**
	 * empty word is not allowed in wordDict
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreakDP2(String s, Set<String> wordDict) {
		if (s.length() == 0)
			return false;

		int maxLen = 0;
		for (String word : wordDict) {
			maxLen = Math.max(maxLen, word.length());
		}

		boolean[] headMatch = new boolean[s.length() + 1];
		Arrays.fill(headMatch, false);
		headMatch[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			int j = Math.max(0, i - maxLen);
			for (; j < i; j++) {
				if (headMatch[j] && wordDict.contains(s.subSequence(j, i))) {
					headMatch[i] = true;
					break;
				}
			}
		}
		return headMatch[s.length()];
	}

	/**
	 * 使用数组记录计算结果的dp算法,如果字典很大的话，这个算法应该效果会好一点
	 * @param s
	 * @param wordDict
	 * @param start
	 * @param maxLen
	 * @return
	 */
	public boolean wordBreak_recur(String s, Set<String> wordDict, int start,
			int maxLen) {
		if (start == s.length())
			return true;

		for (int i = 1; i <= maxLen && i + start <= s.length(); i++) {
			String sub = s.substring(start, start + i);
			if (wordDict.contains(sub)) {
				if (endMatch[start + i]
						&& wordBreak_recur(s, wordDict, start + i, maxLen))
					return true;
				else
					endMatch[start + i] = false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		WordBreak word = new WordBreak();
		Set<String> set = new HashSet<String>();
		set.add("leet");
		set.add("code");
		Assert.assertEquals(true, word.wordBreak("leetcode", set));
		Assert.assertEquals(true, word.wordBreakDP2("leetcode", set));

		set = new HashSet<String>();
		set.add("leet");
		set.add("code");
		Assert.assertEquals(false, word.wordBreak("leet code", set));
		Assert.assertEquals(false, word.wordBreakDP2("leet code", set));

		set = new HashSet<String>();
		set.add("leet");
		set.add("lee");
		set.add("t");
		Assert.assertEquals(true, word.wordBreak("lee", set));
		Assert.assertEquals(true, word.wordBreakDP2("lee", set));

		set = new HashSet<String>();
		set.add("aaaa");
		set.add("aaa");
		Assert.assertEquals(true, word.wordBreak("aaaaaaa", set));
		Assert.assertEquals(true, word.wordBreakDP2("aaaaaaa", set));

		set = new HashSet<String>();
		set.addAll(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
				"aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));

		Assert.assertEquals(
				false,
				word.wordBreak(
						"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
						set));
		Assert.assertEquals(
				false,
				word.wordBreakDP2(
						"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
						set));
	}
}