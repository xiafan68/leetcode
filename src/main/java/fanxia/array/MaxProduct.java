package fanxia.array;

public class MaxProduct {
	/**
	 * 找出连续子数组的最大乘积
	 * 
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		int max = 1;
		int min = 1;
		int ret = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int preMax = max;
			max = Math.max(max * nums[i], min * nums[i]);
			max = Math.max(max, nums[i]);
			ret = Math.max(ret, max);
			min = Math.min(preMax * nums[i], min * nums[i]);
			min = Math.min(min, nums[i]);
		}
		return ret;
	}
}
