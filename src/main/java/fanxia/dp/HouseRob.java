package fanxia.dp;

import junit.framework.Assert;

public class HouseRob {
	/**
	 * fn = max(f(n-1) + d[n], f(n-2) + max(d[n-1], d[n]))
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		int[] score = new int[] { 0, 0 };
		boolean[] choosen = new boolean[] { false, false };
		for (int i = 0; i < nums.length; i++) {
			if (score[0] + nums[i] > score[1]) {
				score[0] += nums[i];
				choosen[0] = true;
				swap(score, choosen);
			} else {
				score[0] = score[1];
				choosen[0] = choosen[1];
				choosen[1] = true;
			}

		}

		return score[1];
	}

	private void swap(int[] score, boolean[] choosen) {
		int tmp = score[0];
		score[0] = score[1];
		score[1] = tmp;

		boolean tmpC = choosen[0];
		choosen[0] = choosen[1];
		choosen[1] = tmpC;
	}

	public static void main(String[] args) {
		HouseRob rob = new HouseRob();
		Assert.assertEquals(1, rob.rob(new int[] { 1 }));
		Assert.assertEquals(10, rob.rob(new int[] { 1, 10 }));
		Assert.assertEquals(10, rob.rob(new int[] { 10, 1 }));
		Assert.assertEquals(20, rob.rob(new int[] { 10, 1, 10 }));
		Assert.assertEquals(30, rob.rob(new int[] { 10, 1, 10, 20 }));
	}
}