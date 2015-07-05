package fanxia.tree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
	/**
	 * root为空的情况
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root != null)
			dfs(root, ret, 0);
		return ret;
	}

	private void dfs(TreeNode root, List<Integer> ret, int level) {
		if (level >= ret.size()) {
			ret.add(root.val);
		} else {
			ret.set(level, root.val);
		}
		if (root.left != null) {
			dfs(root.left, ret, level + 1);
		}
		if (root.right != null) {
			dfs(root.right, ret, level + 1);
		}
	}

	/**
	 *    1            <---
	/   \
	2     3         <---
	\     \
	5     4       <---
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		RightSideView view = new RightSideView();
		System.out.println(view.rightSideView(root));
	}
}