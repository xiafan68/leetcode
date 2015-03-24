package fanxia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class LargestNumber {

	public String largestNumber(int[] num) {
		ArrayList<String> list = new ArrayList<String>();
		for (int cur : num) {
			list.add(Integer.toString(cur));
		}
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				int ret = 0;
				int len = Math.min(o1.length(), o2.length());
				int i = 0;
				while (i < len) {
					ret = Character.compare(o1.charAt(i), o2.charAt(i));
					if (ret != 0)
						break;
					i++;
				}
				if (ret != 0)
					return 0 - ret;
				else {
					return 0 - (o1 + o2).compareTo(o2 + o1);
				}
			}
		});

		StringBuffer ret = new StringBuffer();
		boolean zeroStart = true;
		Iterator<String> iter = list.iterator();
		String cur = "";
		while (iter.hasNext()) {
			cur = iter.next();
			if (zeroStart && cur.startsWith("0")) {
				if (!iter.hasNext()) {
					ret.append(cur);
				}
			} else {
				zeroStart = false;
				ret.append(cur);
			}
		}

		return ret.toString();
	}

	public static void main(String[] args) {
		LargestNumber num = new LargestNumber();
		System.out.println(num.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(num.largestNumber(new int[] { 121, 12 }));
		System.out.println(num.largestNumber(new int[] { 1213, 12 }));
		System.out.println(num.largestNumber(new int[] { 0, 0 }));
		System.out.println(num.largestNumber(new int[] { 1, 0, 0 }));
	}

}
