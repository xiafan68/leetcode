package fanxia.list;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 通过新增一个额外的节点，往往能够使程序的逻辑简单很多
 * @author xiafan
 *
 */
public class SingleLinkedList {
	/**
	 * Given a sorted linked list, delete all duplicates such that
	 *  each element appear only once.
	* For example,
	* Given 1->1->2, return 1->2.
	* Given 1->1->2->3->3, return 1->2->3
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;

		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode cur = head;
		ListNode pre = ret;
		while (cur != null) {
			if (cur.next != null && cur.next.val == cur.val) {
				int val = cur.val;
				pre = cur;
				cur = cur.next;
				while (cur != null && cur.val == val) {
					pre.next = cur.next;
					cur = cur.next;
				}
			} else if (cur.next != null) {
				pre = cur;
				cur = cur.next;
			} else {
				break;
			}
		}
		return ret.next;
	}

	@Test
	public void deleteDuplicatesTest() {
		SingleLinkedList sol = new SingleLinkedList();
		ListNode ret = sol.deleteDuplicates(ListNode
				.create(new int[] { 1, 1, 2 }));
		System.out.println(ret);
		ret = sol
				.deleteDuplicates(ListNode.create(new int[] { 1, 1, 2, 3, 3 }));
		Assert.assertEquals(ListNode.create(new int[] { 1, 2, 3 }), ret);
		ret = sol.deleteDuplicates(ListNode.create(new int[] { 1, 1 }));
		Assert.assertEquals(ListNode.create(new int[] { 1 }), ret);

		ret = sol.deleteDuplicates(ListNode.create(new int[] { 1, 1, 3 }));
		Assert.assertEquals(ListNode.create(new int[] { 1, 3 }), ret);
		ret = sol.deleteDuplicates(ListNode.create(new int[] { 1, 1, 3, 4 }));
		Assert.assertEquals(ListNode.create(new int[] { 1, 3, 4 }), ret);

		ret = sol
				.deleteDuplicates(ListNode.create(new int[] { 1, 1, 3, 3, 4 }));
		Assert.assertEquals(ListNode.create(new int[] { 1, 3, 4 }), ret);

		ret = sol.deleteDuplicates(ListNode.create(new int[] { 1, 3, 3 }));
		Assert.assertEquals(ListNode.create(new int[] { 1, 3 }), ret);
	}

	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null)
			return null;

		ListNode ret = new ListNode(0);
		ret.next = head;
		ListNode cur = head;
		ListNode pre = ret;
		while (cur != null) {
			if (cur.next != null && cur.next.val == cur.val) {
				int val = cur.val;
				while (cur != null && cur.val == val) {
					pre.next = cur.next;
					cur = cur.next;
				}
			} else if (cur.next != null) {
				pre = cur;
				cur = cur.next;
			} else {
				break;
			}
		}
		return ret.next;
	}

	@Test
	public void deleteDuplicates2Test() {
		SingleLinkedList sol = new SingleLinkedList();
		ListNode ret = sol.deleteDuplicates2(ListNode.create(new int[] { 1, 1,
				2 }));
		System.out.println(ret);
		ret = sol.deleteDuplicates2(ListNode
				.create(new int[] { 1, 1, 2, 3, 3 }));
		System.out.println(ret);
		ret = sol.deleteDuplicates2(ListNode.create(new int[] { 1, 1 }));
		System.out.println(ret);
		ret = sol.deleteDuplicates2(ListNode.create(new int[] { 1, 1, 3 }));
		System.out.println(ret);
		ret = sol.deleteDuplicates2(ListNode.create(new int[] { 1, 1, 3, 4 }));
		System.out.println(ret);
		ret = sol.deleteDuplicates2(ListNode
				.create(new int[] { 1, 1, 3, 3, 4 }));
		System.out.println(ret);
		ret = sol.deleteDuplicates2(ListNode.create(new int[] { 1, 3, 3 }));
		System.out.println(ret);
	}
}
