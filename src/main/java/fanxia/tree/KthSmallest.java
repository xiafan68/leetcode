package fanxia.tree;

import java.util.Stack;

import junit.framework.Assert;

public class KthSmallest {
	int counter = 0;
	int k;

	public int kthSmallest(TreeNode root, int k) {
		counter = 0;
		this.k = k;
		return kthSmallestIntern(root);
	}

	// https://leetcode.com/discuss/47138/my-10-lines-java-solution-using-stack
	public int kthSmallest2(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0) {
				return root.val;
			}
			root = root.right;
		}
	}

	private int kthSmallestIntern(TreeNode cur) {
		int ret = 0;
		if (cur.left != null) {
			ret = kthSmallestIntern(cur.left);
		}
		if (counter == k) {
			return ret;
		} else if (++counter == k) {
			return cur.val;
		} else if (cur.right != null) {
			ret = kthSmallestIntern(cur.right);
		}
		return ret;
	}

	public static void main(String[] args) {
		KthSmallest k = new KthSmallest();
		TreeNode root = new TreeNode(5);
		Assert.assertEquals(5, k.kthSmallest(root, 1));
		root.left = new TreeNode(1);
		root.right = new TreeNode(7);
		TreeNode right = root.right;
		right.left = new TreeNode(6);
		right.right = new TreeNode(8);

		Assert.assertEquals(1, k.kthSmallest(root, 1));
		Assert.assertEquals(5, k.kthSmallest(root, 2));
		Assert.assertEquals(6, k.kthSmallest(root, 3));
	}
}
