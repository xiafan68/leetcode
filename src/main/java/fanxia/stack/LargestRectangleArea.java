package fanxia.stack;

import java.util.Stack;

import junit.framework.Assert;

/**
 * 问题的关键，只需要保留相邻递增高度的方形，这些方形之间的都在退栈的时候应该被计算掉
 * @author xiafan
 *
 */
public class LargestRectangleArea {
	public int largestRectangleArea(int[] height) {
		int max = 0;
		Stack<Integer> index = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			while (!index.isEmpty()) {
				if (index.isEmpty() || height[index.peek()] < height[i]) {
					break;
				}
				int cur = index.pop();
				int preTop = index.isEmpty() ? -1 : index.peek();
				max = Math.max(max, (i - 1 - preTop) * height[cur]);
			}
			index.push(i);
		}
		while (!index.empty()) {
			int cur = index.pop();
			int preTop = index.isEmpty() ? -1 : index.peek();
			max = Math.max(max, (height.length - 1 - preTop) * height[cur]);
		}
		return max;
	}

	public static void main(String[] args) {
		LargestRectangleArea sol = new LargestRectangleArea();
		Assert.assertEquals(10,
				sol.largestRectangleArea(new int[] { 1, 2, 3, 10 }));
		Assert.assertEquals(1, sol.largestRectangleArea(new int[] { 1 }));
		Assert.assertEquals(0, sol.largestRectangleArea(new int[] {}));

	}
}
