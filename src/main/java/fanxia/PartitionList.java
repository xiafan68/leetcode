package fanxia;

import junit.framework.Assert;
import fanxia.list.ListNode;

public class PartitionList {

	/**
	 * 题目的意思是所有小于x的元素都放在所有不大于x的元素的前面，并没有要求所有大于x的都放在x的后面
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode ret = new ListNode(Integer.MIN_VALUE);
		ListNode front = ret;// always insert behind
		front.next = head;

		ListNode pre = front;
		ListNode cur = front.next;
		while (cur != null) {
			if (cur.val < x) {
				pre.next = cur.next;// list remove
				cur.next = front.next; // list insert
				front.next = cur;
				front = front.next;
				if (pre.next == front) {
					pre = front;
				}
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return ret.next;
	}

	public static void main(String[] args) {
		ListNode l1 = ListNode.create(new int[] { 1, 1 });
		PartitionList sol = new PartitionList();
		Assert.assertEquals(ListNode.create(new int[] { 1, 1 }),
				sol.partition(l1, 1));

		l1 = ListNode.create(new int[] { 1 });
		Assert.assertEquals(ListNode.create(new int[] { 1 }),
				sol.partition(l1, 2));

		l1 = ListNode.create(new int[] { 1, 1 });
		Assert.assertEquals(ListNode.create(new int[] { 1, 1 }),
				sol.partition(l1, 2));

		l1 = ListNode.create(new int[] { 4, 1, 45 });
		Assert.assertEquals(ListNode.create(new int[] { 4, 1, 45 }),
				sol.partition(l1, 1));

		l1 = ListNode.create(new int[] { 1, 45 });
		Assert.assertEquals(ListNode.create(new int[] { 1, 45 }),
				sol.partition(l1, 1));

		l1 = ListNode.create(new int[] { 1 });
		Assert.assertEquals(ListNode.create(new int[] { 1 }),
				sol.partition(l1, 1));

		l1 = ListNode.create(new int[] {});
		Assert.assertEquals(ListNode.create(new int[] {}), sol.partition(l1, 1));

		l1 = ListNode.create(new int[] { 9, 8, 5, 5, 5, 4, 3, 4 });
		Assert.assertEquals(
				ListNode.create(new int[] { 4, 3, 4, 9, 8, 5, 5, 5 }),
				sol.partition(l1, 5));
		// System.out.println(sol.partition(l1, 5));

	}
}
