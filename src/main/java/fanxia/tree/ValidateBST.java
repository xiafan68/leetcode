package fanxia.tree;

public class ValidateBST {

	public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}

	// https://leetcode.com/discuss/42687/another-passed-java-solution
	// 自顶向下的思想，巧妙
	private boolean isValid(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;
		if ((min != null && root.val < min) || (max != null && root.val > max)) {
			return false;
		}

		return isValid(root.left, min, root.val - 1) && isValid(root, root.val + 1, max);
	}
}
