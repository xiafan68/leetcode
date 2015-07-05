package fanxia;

import fanxia.list.ListNode;

public class AddTwoIntegers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ret = l1;
		ListNode cur = l1, pre = null;
		int carry = 0;
		int val1 = 0;
		int val2 = 0;
		while (!(carry == 0 && l1 == null && l2 == null)) {
			if (l1 != null)
				val1 = l1.val;
			if (l2 != null)
				val2 = l2.val;

			if (cur == null && l2 != null) {
				cur = l2;
				if (pre != null) {
					pre.next = cur;
				} else {
					ret = cur;
				}
			}
			if (cur != null)
				cur.val = val1 + val2 + carry;
			else {
				cur = new ListNode(carry);
				pre.next = cur;
				break;
			}
			carry = 0;
			if (cur.val >= 10) {
				cur.val -= 10;
				carry = 1;
			}

			val1 = 0;
			val2 = 0;

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null)
				l2 = l2.next;
			pre = cur;
			cur = cur.next;
		}

		return ret;
	}

	public static void main(String[] args) {
		test(new int[] { 9 }, new int[] { 1, 9 });
		test(new int[] { 1, 9, 1, 1, 1 }, new int[] { 1, 9, 1, 9 });
		test(new int[] {}, new int[] { 1, 9, 1, 9 });
		test(new int[] { 1, 9, 1, 9 }, new int[] {});
		test(new int[] { 1, 9, 1, 9 }, new int[] { 1, 9, });
		test(new int[] { 5 }, new int[] { 5 });
	}

	private static void test(int[] vals1, int[] vals2) {
		ListNode l1 = ListNode.create(vals1);
		ListNode l2 = ListNode.create(vals2);

		AddTwoIntegers sol = new AddTwoIntegers();
		ListNode ret = sol.addTwoNumbers(l1, l2);
		System.out.println(ret.toString());
	}
}
