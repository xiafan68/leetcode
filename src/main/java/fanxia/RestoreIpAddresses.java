package fanxia;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	List<String> ret;

	public List<String> restoreIpAddresses(String s) {
		ret = new ArrayList<String>();
		traverse(new ArrayList<Integer>(), s.toCharArray(), 0);
		return ret;
	}

	public void traverse(List<Integer> ip, char[] data, int cur) {
		if (ip.size() == 3 && cur < data.length && cur + 3 >= data.length) {
			if (data[cur] == '0' && data.length - cur > 1)
				return;
			String last = new String(data, cur, data.length - cur);
			int lastMask = Integer.parseInt(last);
			if (lastMask > 255)
				return;
			StringBuffer buf = new StringBuffer();
			for (Integer mask : ip) {
				buf.append(mask);
				buf.append(".");
			}
			buf.append(last);
			ret.add(buf.toString());
		} else if (ip.size() < 3) {
			int mask = 0;
			int idx = cur;
			for (int i = 0; i < 3 && idx < data.length; i++) {
				if (i != 0 && data[cur] == '0')
					break;
				mask = mask * 10 + (data[idx] - '0');
				if (mask > 255)
					break;
				ip.add(mask);
				traverse(ip, data, ++idx);
				ip.remove(ip.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		RestoreIpAddresses sol = new RestoreIpAddresses();
		System.out.println(sol.restoreIpAddresses("25525511135"));
		System.out.println(sol.restoreIpAddresses("1000"));
		System.out.println(sol.restoreIpAddresses("1111"));
		System.out.println(sol.restoreIpAddresses("100"));
		System.out.println(sol.restoreIpAddresses("010010"));
	}
}
