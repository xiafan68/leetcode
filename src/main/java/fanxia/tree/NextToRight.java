package fanxia.tree;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;

/**
 * 把所有节点的next指针都指向右邻居
 * @author xiafan
 *          1 -> null
 *      2   ->   3 -> null
 *    1 -> 2 -> 3 -> 4 -> null
 */
public class NextToRight {
	public void connect(TreeLinkedNode root) {
		traverse(root, null);
		while (root != null) {
			TreeLinkedNode tmp = root.next;
			root.next = null;
			root = tmp;
		}
	}

	private void traverse(TreeLinkedNode cur, TreeLinkedNode left) {
		if (cur == null)
			return;
		cur.next = cur.right;
		if (cur.left != null) {
			if (left != null)
				traverse(cur.left, left.next);
			else
				traverse(cur.left, null);
		}

		if (cur.right != null) {
			traverse(cur.right, cur.left);
		}
		if (left != null)
			left.next = cur;
	}

	public static void main(String[] args) {
		TreeLinkedNode cur = new TreeLinkedNode(0);
		buildTree(cur, 1, 1, 4);
		NextToRight sol = new NextToRight();
		sol.connect(cur);
		printTree(cur);
	}

	private static void printTree(TreeLinkedNode cur) {
		Queue<TreeLinkedNode> queue = new LinkedList<TreeLinkedNode>();
		queue.add(cur);
		while (!queue.isEmpty()) {
			Queue<TreeLinkedNode> tmp = new LinkedList<TreeLinkedNode>();
			while (!queue.isEmpty()) {
				TreeLinkedNode node = queue.poll();
				System.out.print(node.val + " -> ");
				if (!queue.isEmpty())
					Assert.assertEquals(node.next, queue.peek());
				if (node.left != null) {
					tmp.add(node.left);
					tmp.add(node.right);
				}
			}
			System.out.println("null");
			queue = tmp;
		}
	}

	private static void buildTree(TreeLinkedNode cur, int val, int level,
			int max) {
		if (level < max) {
			cur.left = new TreeLinkedNode(val++);
			buildTree(cur.left, val, level + 1, max);
			cur.right = new TreeLinkedNode(val++);
			buildTree(cur.right, val, level + 1, max);
		}
	}
}
