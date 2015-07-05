package fanxia.sort;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import fanxia.list.ListNode;

/**
 * 这里同时实现了merge sort和quick sort。结果quick sort没有通过测试，原因是quick sort在面临输入中存在
 * 很多相同元素的时候，它可能无法每次都将链表均分成两部分，导致其实效率可能变成n^2。
 * @author xiafan
 *
 */
public class SortList {
	/**
	 * sort the list in O(nlog(n)) time and constant space
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;

		// ListNode ret = new ListNode(0);
		// ret.next = head;
		// quickSort(ret, null);
		int len = len(head);

		return mergeSort(head, len);
	}

	/**
	 * sort the items between start and end(both exclusive)
	 * 但是在面临很多相同元素的时候，这个算法速度太慢。。。
	 * @param start
	 * @param end
	 */
	private ListNode mergeSort(ListNode start, int len) {
		if (len < 2)
			return start;

		int mid = len / 2;
		ListNode cur = start;
		for (int i = 0; i < mid - 1; i++) {
			cur = cur.next;
		}
		ListNode tailHead = cur.next;
		cur.next = null;

		start = mergeSort(start, mid);
		tailHead = mergeSort(tailHead, len - mid);
		ListNode ret = new ListNode(0);
		cur = ret;
		while (start != null && tailHead != null) {
			if (start.val <= tailHead.val) {
				cur.next = start;
				start = start.next;
			} else {
				cur.next = tailHead;
				tailHead = tailHead.next;
			}
			cur = cur.next;
		}
		if (start == null) {
			cur.next = tailHead;
		} else {
			cur.next = start;
		}
		return ret.next;
	}

	private int len(ListNode start) {
		int ret = 0;
		while (start != null) {
			ret++;
			start = start.next;
		}
		return ret;
	}

	/**
	 * sort the items between start and end(both inclusive)
	 * 但是在面临很多相同元素的时候，这个算法速度太慢。。。
	 * @param start
	 * @param end
	 */
	private void quickSort(ListNode start, ListNode end) {
		ListNode front = start.next;
		if (front == null || front == end)
			return;

		ListNode preFront = start;
		ListNode pre = front;
		ListNode cur = front.next;

		while (cur != null && cur != end) {
			if (cur.val < front.val) {
				pre.next = cur.next;
				cur.next = preFront.next;
				preFront.next = cur;
				preFront = preFront.next;
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		quickSort(start, front);
		quickSort(front, end);
	}

	@Test
	public void sortTest() throws IOException {
		SortList sol = new SortList();
		Assert.assertEquals(ListNode.create(new int[] { 1, 2, 3, 4 }),
				sol.sortList(ListNode.create(new int[] { 1, 2, 3, 4 })));

		Assert.assertEquals(ListNode.create(new int[] { 1 }),
				sol.sortList(ListNode.create(new int[] { 1 })));

		Assert.assertEquals(ListNode.create(new int[] { 1, 1, 2 }),
				sol.sortList(ListNode.create(new int[] { 2, 1, 1 })));

		Assert.assertEquals(ListNode.create(new int[] {}),
				sol.sortList(ListNode.create(new int[] {})));

		Assert.assertEquals(
				ListNode.create(new int[] { 2, 2, 3, 4, 56, 345, 345, 567 }),
				sol.sortList(ListNode.create(new int[] { 2, 345, 2, 3, 345, 4,
						56, 567 })));
		List<Integer> data = new ArrayList<Integer>();
		DataInputStream dis = new DataInputStream(new FileInputStream(
				"data/listsort.txt"));
		String line = null;
		while ((line = dis.readLine()) != null) {
			line = line.trim();
			String[] ints = line.split(",");
			for (String curStr : ints) {
				data.add(Integer.parseInt(curStr.trim()));
			}
		}
		dis.close();
		int[] intData = new int[data.size()];
		for (int i = 0; i < data.size(); i++)
			intData[i] = data.get(i);
		System.out.println(sol.sortList(ListNode.create(intData)));
	}
}
