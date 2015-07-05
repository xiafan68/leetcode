package fanxia.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

/**
 * 
 * @author xiafan
 *
 */
public class WordBreak2 {
	/**
	 * empty word is not allowed in wordDict
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> ret = new ArrayList<String>();
		if (s.length() == 0)
			return ret;

		int maxLen = 0;
		for (String word : wordDict) {
			maxLen = Math.max(maxLen, word.length());
		}

		boolean[] headMatch = new boolean[s.length() + 1];
		Arrays.fill(headMatch, false);
		headMatch[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			int jStart = Math.max(0, i - maxLen);
			for (int j = jStart; j < i; j++) {
				if (headMatch[j] && wordDict.contains(s.subSequence(j, i))) {
					headMatch[i] = true;
				}
			}
		}
		if (headMatch[s.length()]) {
			dfs(s, wordDict, s.length(), "", ret);
		}
		return ret;
	}

	private void dfs(String s, Set<String> wordDict, int end, String suffix,
			List<String> ret) {
		if (end == 0) {
			ret.add(suffix.substring(0, suffix.length() - 1));
			return;
		}
		for (String word : wordDict) {
			int start = end - word.length();
			if (start >= 0 && s.substring(start, end).equals(word)) {
				dfs(s, wordDict, start, word + " " + suffix, ret);
			}
		}
	}

	public static void main(String[] args) {
		WordBreak2 word = new WordBreak2();
		Set<String> set = new HashSet<String>();
		set.add("leet");
		set.add("code");
		Assert.assertEquals(Arrays.asList("leet code"),
				word.wordBreak("leetcode", set));

		set = new HashSet<String>();
		set.add("leet");
		set.add("code");
		Assert.assertEquals(Arrays.asList(), word.wordBreak("leet code", set));

		set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		// Assert.assertEquals(Arrays.asList("cats and dog", "cat sand dog"),
		// word.wordBreak("catsanddog", set));

		set = new HashSet<String>();
		set.addAll(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
				"aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
		System.out
				.println(word
						.wordBreak(
								"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
								set));
	}
}