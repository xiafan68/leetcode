package fanxia.list;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public static ListNode create(int[] vals) {
		ListNode header = null;
		ListNode cur = null;
		for (int i = 0; i < vals.length; i++) {
			if (header == null) {
				header = new ListNode(vals[i]);
				cur = header;
			} else {
				cur.next = new ListNode(vals[i]);
				cur = cur.next;
			}
		}
		return header;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		ListNode cur = this;
		while (cur != null) {
			buf.append(cur.val);
			buf.append(",");
			cur = cur.next;
		}
		return buf.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		ListNode o = (ListNode) other;
		boolean ret = true;

		ListNode aCur = this;
		ListNode oCur = o;
		while (aCur != null && oCur != null) {
			if (aCur.val != oCur.val) {
				ret = false;
				break;
			}
			aCur = aCur.next;
			oCur = oCur.next;
		}

		if (aCur != null || oCur != null) {
			ret = false;
		}
		return ret;
	}
}
