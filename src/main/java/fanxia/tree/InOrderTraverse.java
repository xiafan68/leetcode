package fanxia.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
		Stack<TreeNode> trStack = new Stack<TreeNode>();
		trStack.push(root);
		TreeNode cur = null;
		while (!trStack.isEmpty()) {
			cur = trStack.peek();
			if (cur.left != null) {
				trStack.push(cur.left);
				cur.left = null;
			} else {
				trStack.pop();
				ret.add(cur.val);
				if (cur.right != null) {
					trStack.push(cur.right);
				}
			}

		}
		return ret;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		InOrderTraverse in = new InOrderTraverse();
		System.out.println(in.inorderTraversal(root));

		root = new TreeNode(1);
		root.right = new TreeNode(2);
		System.out.println(in.inorderTraversal(root));

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(in.inorderTraversal(root));
	}
}
