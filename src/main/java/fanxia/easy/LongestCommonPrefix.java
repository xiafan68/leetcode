package fanxia.easy;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		StringBuffer buf = new StringBuffer();
		int i = 0;
		boolean noeq = false;
		while (!noeq) {
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || i >= strs[j - 1].length()
						|| strs[j].charAt(i) != strs[j - 1].charAt(i)) {
					noeq = true;
					break;
				}
			}
			if (!noeq && i < strs[0].length()) {
				buf.append(strs[0].charAt(i));
			} else
				noeq = true;
			i++;
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		LongestCommonPrefix sol = new LongestCommonPrefix();
		System.out.println(sol.longestCommonPrefix(new String[] { "" }));
		System.out.println(sol.longestCommonPrefix(new String[] { "", "a" }));
		System.out.println(sol.longestCommonPrefix(new String[] { "a", "" }));
		System.out
				.println(sol.longestCommonPrefix(new String[] { "sdf", "s" }));
	}
}
