package fanxia.tree;

import java.util.ArrayList;

/**
 * 判断一颗二叉树是否是对称的
 * @author xiafan
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return recursiveSym(root.left, root.right);
	}

	private boolean recursiveSym(TreeNode left, TreeNode right) {
		if ((left == null && right != null) || (left != null && right == null))
			return false;
		else if (left == null && right == null) {
			return true;
		} else {
			boolean ret = recursiveSym(left.left, right.right);
			if (ret) {
				ret = recursiveSym(left.right, right.left);
			}
			return ret;
		}
	}

	static class Pair {
		public TreeNode node;
		public boolean left;
	}

	private boolean iterSym(TreeNode root) {
		ArrayList<TreeNode> state = new ArrayList<TreeNode>();
		ArrayList<Short> direct = new ArrayList<Short>();
		state.add(root.left);
		state.add(root.right);
		direct.add((short) -1);
		while (!state.isEmpty()) {
			int size = state.size();
			int dirIdx = size << 1 - 1;
			TreeNode left = state.get(size - 2);
			TreeNode right = state.get(size - 1);
			if ((left == null && right != null)
					|| (left != null && right == null))
				return false;
			else if (left == null && right == null) {
				state.remove(size - 1);
				state.remove(size - 2);
				direct.remove(dirIdx);
			} else {
				if (left.val != right.val)
					return false;

				if (direct.get(dirIdx) == -1) {
					direct.set(dirIdx, (short) 0);
					state.add(left.left);
					state.add(right.right);
					direct.add((short) -1);
				} else if (direct.get(dirIdx) == 0) {
					direct.set(dirIdx, (short) 1);
					state.add(left.left);
					state.add(right.right);
					direct.add((short) -1);
				} else {
					state.remove(size - 1);
					state.remove(size - 2);
					direct.remove(dirIdx);
				}
			}
		}
		return true;
	}
}
