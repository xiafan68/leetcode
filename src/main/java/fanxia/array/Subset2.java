package fanxia.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*排序，然后枚举所有长度的子集
 * @author xiafan
 *
 */
public class Subset2 {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ret.add(new ArrayList<Integer>());
		enumerate(ret, num, 0);
		return ret;
	}

	private void enumerate(List<List<Integer>> ret, int[] num, int curIdx) {
		List<Integer> last = ret.get(ret.size() - 1);
		boolean start = true;
		int pre = 0;
		for (int i = curIdx; i < num.length; i++) {
			if (start || pre != num[i]) {
				start = false;
				List<Integer> newSet = new ArrayList<Integer>(last);
				newSet.add(num[i]);
				ret.add(newSet);
				enumerate(ret, num, i + 1);
				pre = num[i];
			}
		}
	}

	public static void main(String[] args) {
		Subset2 test = new Subset2();
		System.out.println(test.subsetsWithDup(new int[] { 1, 2, 2 }));
		System.out.println(test.subsetsWithDup(new int[] { 1, 2, 2, 3 }));
		System.out.println(test.subsetsWithDup(new int[] { 1 }));
		System.out.println(test.subsetsWithDup(new int[] {}));
	}
}
