package fanxia.sort;

import java.util.Stack;

import fanxia.list.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 *reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *You must do this in-place without altering the nodes' values.
 *For example,
 *Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * @author xiafan
 *
 */
public class ReorderList {
	/**
	 * 当前的实现其实是冒泡排序
	 * @param head
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode cur = head.next;
		if (cur.next == null)
			return;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}

		ListNode pre = head;
		cur = head.next;
		do {
			ListNode top = stack.pop();
			if (top == cur) {
				cur.next = null;
				break;
			}

			pre.next = top;
			top.next = cur;
			pre = cur;
			cur = cur.next;
			if (cur == top) {
				pre.next = null;
				break;
			}
		} while (!stack.isEmpty());
	}

	/**
	 * 当前的实现其实是冒泡排序
	 * @param head
	 */
	public void reorderList1(ListNode head) {
		if (head.next == null)
			return;
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode next = null;
		boolean noSwap = false;
		while (!noSwap) {
			pre = head;
			cur = head.next;
			next = cur.next;
			noSwap = true;

			while ((next = cur.next) != null) {
				if (cur.val > next.val) {
					noSwap = false;
					pre.next = next;
					cur.next = next.next;
					next.next = cur;
					pre = next;
				} else {
					pre = cur;
					cur = next;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] vals = new int[] { 1, 2, 3, 4 };
		test(vals);
		vals = new int[] { 1, 2, 3, 4, 5 };
		test(vals);
	}

	private static void test(int[] vals) {
		ListNode header = new ListNode(0);
		ListNode cur = header;
		for (int i = 0; i < vals.length; i++) {
			cur.next = new ListNode(vals[i]);
			cur = cur.next;
		}

		header = header.next;

		ReorderList sol = new ReorderList();
		sol.reorderList(header);
		while (header != null) {
			System.out.print(header.val + ",");
			header = header.next;
		}
		System.out.println();
	}
}
