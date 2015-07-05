package fanxia.tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		postorderTraversal(root, ret);
		return ret;
	}

	void postorderTraversal(TreeNode root, List<Integer> ret) {
		if (root == null)
			return;
		
		if (root.left != null) {
			postorderTraversal(root.left, ret);
		}

		if (root.right != null) {
			postorderTraversal(root.right, ret);
		}
		ret.add(root.val);
	}
}