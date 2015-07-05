package fanxia.number;

import org.junit.Assert;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		return singleNumber1(nums);
	}

	/**
	 * 这个方法太巧妙了，基本没想到
	 * @param nums
	 * @return
	 */
	public int singleNumber1(int[] nums) {
		int ret = 0;
		for (int i = 0; i < nums.length; i++) {
			ret ^= nums[i];
		}
		return ret;
	}

	public int singleNumber2(int[] nums) {
		int[] counts = new int[32];
		for (int i = 0; i < nums.length; i++) {
			int mask = 1;
			for (int j = 0; j < 32; j++) {
				if ((nums[i] & mask) != 0) {
					counts[j]++;
				}
				mask = mask << 1;
			}
		}

		int ret = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if (counts[i] % 2 != 0) {
				ret = ret | mask;
			}
			mask = mask << 1;
		}
		return ret;
	}

	/**
	 * 出了一个数，其它数都出现三次
	 * @param nums
	 * @return
	 */
	public int singleNumber3(int[] nums) {
		int[] counts = new int[32];
		for (int i = 0; i < nums.length; i++) {
			int mask = 1;
			for (int j = 0; j < 32; j++) {
				if ((nums[i] & mask) != 0) {
					counts[j]++;
				}
				mask = mask << 1;
			}
		}

		int ret = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if (counts[i] % 3 != 0) {
				ret = ret | mask;
			}
			mask = mask << 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		SingleNumber num = new SingleNumber();
		Assert.assertEquals(1,
				num.singleNumber1(new int[] { 2, 3, 4, 4, 2, 3, 1 }));
		Assert.assertEquals(1,
				num.singleNumber2(new int[] { 2, 3, 4, 4, 2, 3, 1 }));
		Assert.assertEquals(1, num.singleNumber1(new int[] { 1 }));
		Assert.assertEquals(1, num.singleNumber2(new int[] { 1 }));
		Assert.assertEquals(-1, num.singleNumber2(new int[] { -1 }));

		// 3 times
		Assert.assertEquals(1, num.singleNumber3(new int[] { 1 }));
		Assert.assertEquals(-1, num.singleNumber3(new int[] { -1 }));
		Assert.assertEquals(1, num.singleNumber3(new int[] { 2, 2, 1, 2 }));
		Assert.assertEquals(-1, num.singleNumber3(new int[] { -1, 2, 2, 2 }));
	}
}