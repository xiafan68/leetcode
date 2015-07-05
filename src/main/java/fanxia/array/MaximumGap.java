package fanxia.array;

import java.util.Arrays;

import junit.framework.Assert;

/**
 * the upper bound for bucket len is (max - min) / (nums.length - 1). With smaller length, 
 * there will be more buckets, and thus there exists empty buckets, which determines the maximum gap
 * @author xiafan
 *
 */
public class MaximumGap {
	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int cur : nums) {
			min = Math.min(min, cur);
			max = Math.max(max, cur);
		}

		int len = (max - min) / (nums.length - 1);
		len = (len == 0) ? 1 : len;
		int size = (max - min) / len + 1;
		int[] minBuck = new int[size];
		Arrays.fill(minBuck, Integer.MAX_VALUE);
		int[] maxBuck = new int[size];
		Arrays.fill(maxBuck, Integer.MIN_VALUE);

		for (int i = 0; i < nums.length; i++) {
			int idx = (nums[i] - min) / len;
			minBuck[idx] = Math.min(minBuck[idx], nums[i]);
			maxBuck[idx] = Math.max(maxBuck[idx], nums[i]);
		}

		int ret = 0;
		int preMax = maxBuck[0];
		for (int i = 1; i < size; i++) {
			if (minBuck[i] != Integer.MAX_VALUE) {
				ret = Math.max(ret, minBuck[i] - preMax);
				preMax = maxBuck[i];
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		MaximumGap gap = new MaximumGap();
		Assert.assertEquals(1, gap.maximumGap(new int[] { 1, 2 }));
		Assert.assertEquals(6, gap.maximumGap(new int[] { 1, 2, 10, 4 }));
		Assert.assertEquals(10, gap.maximumGap(new int[] { 1, 2, 10, 4, 20 }));
	}
}