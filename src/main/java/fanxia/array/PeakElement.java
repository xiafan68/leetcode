package fanxia.array;

import junit.framework.Assert;

public class PeakElement {

	public int findPeakElement(int[] nums) {
		return findPeakElement1(nums);
	}

	/**
	 * o(n) algorithm
	 * @param nums
	 * @return
	 */
	public int findPeakElement1(int[] nums) {
		int idx = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				idx = i;
				max = nums[i];
			}
		}
		return idx;
	}

	/**
	 * binary search, o(log(n)) algorithm
	 * @param nums
	 * @return
	 */
	public int findPeakElement2(int[] nums) {
		int l = 0;
		int u = nums.length - 1;
		int mid = 0;
		while (l < u) {
			mid = (l + u) / 2;
			if (nums[mid] < nums[mid + 1]) {
				l = mid + 1;
			} else {
				u = mid;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		PeakElement peak = new PeakElement();
		Assert.assertEquals(3,
				peak.findPeakElement(new int[] { 1, 2, 3, 4, 3 }));
		Assert.assertEquals(3,
				peak.findPeakElement2(new int[] { 1, 2, 3, 4, 3 }));
		Assert.assertEquals(1, peak.findPeakElement2(new int[] { 1, 2, 1 }));
	}
}