package fanxia;

public class SheetColumnNumber {
	/**
	 * 保证s不是空字符串
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {
		int len = s.length() - 1;
		int ret = s.charAt(len) - 'A' + 1;
		int base = 26;
		for (int i = len - 1; i >= 0; i--) {
			ret += (s.charAt(i) - 'A' + 1) * base;
			base *= 26;
		}
		return ret;
	}

	public String convertToTitle(int n) {
		StringBuffer ret = new StringBuffer();
		while (n > 0) {
			int ord = n % 26 != 0 ? n % 26 : 26;
			ret.append((char) ('A' + ord - 1));
			n = (n - ord) / 26;
		}
		return ret.reverse().toString();
	}

	public static void main(String[] args) {
		SheetColumnNumber test = new SheetColumnNumber();
		System.out.println(test.titleToNumber("A"));
		System.out.println(test.titleToNumber("AA"));
		System.out.println(test.titleToNumber("AZ"));
		System.out.println(test.titleToNumber("BB"));

		System.out.println(test.convertToTitle(1));
		System.out.println(test.convertToTitle(2));
		System.out.println(test.convertToTitle(26));
		System.out.println(test.convertToTitle(27));
		System.out.println(test.convertToTitle(28));
		System.out.println(test.convertToTitle(1 + 2 * 26));
		System.out.println(test.convertToTitle(1 + 2 * 26 + 26 * 26));
	}
}
