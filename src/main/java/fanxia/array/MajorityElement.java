package fanxia.array;

import org.junit.Assert;

/**
 * majority元素必须是超过Math.ceil(n/2)才行
 * @author xiafan
 *
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		int ret = 0;
		int count = 0;
		boolean first = false;
		for (int num : nums) {
			if (first) {
				ret = num;
				count = 1;
			} else if (ret != num) {
				if (count == 0) {
					ret = num;
					count = 1;
				} else
					count--;
			} else {
				count++;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		MajorityElement major = new MajorityElement();
		Assert.assertEquals(3,
				major.majorityElement(new int[] { 1, 1, 1, 1, 2, 2, 2, 3, 3 }));
	}
}