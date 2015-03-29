package fanxia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * 找出所有长度为10的重复dna字串。这里其实就是从头扫描，记录之前出现过的所有的dna字串，
 * 只是为了避免子串的比较，这里为每个子串生成了一个一一对应的hash值
 * @author xiafan
 *
 */
public class RepeatedDNASequence {
	private static int[] charMaps = new int[26];
	static { // A, C, G, and T,
		charMaps['A' - 'A'] = 1;
		charMaps['C' - 'A'] = 2;
		charMaps['G' - 'A'] = 3;
		charMaps['T' - 'A'] = 4;
	}
	private static char[] intMap = new char[] { 'A', 'C', 'G', 'T' };

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> ret = new ArrayList<String>();
		if (s.length() < 10)
			return ret;

		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		int base = 4 << 16;
		int cur = 0;
		for (int i = 0; i < 10; i++) {
			cur += base * charMaps[s.charAt(i) - 'A'];
			base >>= 2;
		}
		update(countMap, cur);

		base = 4 << 16;
		for (int i = 1; i <= s.length() - 10; i++) {
			cur -= base * charMaps[s.charAt(i - 1) - 'A'];
			cur = cur << 2;
			cur += charMaps[s.charAt(i + 9) - 'A'];
			update(countMap, cur);
		}

		for (Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > 1) {
				ret.add(decode(entry.getKey()));
			}
		}
		return ret;
	}

	private String decode(int num) {
		StringBuffer buf = new StringBuffer();
		while (num > 0) {
			int ord = num % 4 == 0 ? 4 : num % 4;
			buf.append(intMap[ord - 1]);
			num -= ord;
			num >>= 2;
		}
		return buf.reverse().toString();
	}

	private void update(HashMap<Integer, Integer> map, int num) {
		if (map.containsKey(num)) {
			map.put(num, map.get(num) + 1);
		} else {
			map.put(num, 1);
		}
	}

	public static void main(String[] args) {
		RepeatedDNASequence test = new RepeatedDNASequence();
		System.out.println(test
				.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(test.findRepeatedDnaSequences("AAAAAAAAAAAA"));
		System.out.println(test.findRepeatedDnaSequences("AGAGAGAGAGAGAGAAAA"));
	}
}
