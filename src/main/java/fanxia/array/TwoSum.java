package fanxia.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
	private class Pair {
		public int value;
		public int idx;

		public Pair(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}
	}

	private class PairComp implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			int ret = Integer.compare(a.value, b.value);
			if (ret == 0) {
				ret = Integer.compare(a.idx, b.idx);
			}
			return ret;
		}
	}

	private class PairCompByValue implements Comparator<Pair> {

		public int compare(Pair a, Pair b) {
			int ret = Integer.compare(a.value, b.value);
			return ret;
		}
	}

	public int[] twoSum1(int[] numbers, int target) {
		int[] ret = new int[2];
		Pair[] pairs = new Pair[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			pairs[i] = new Pair(numbers[i], i + 1);
		}
		PairComp comp = new PairComp();
		Arrays.sort(pairs, comp);

		Pair temp = new Pair(0, 0);
		PairCompByValue vCmp = new PairCompByValue();
		for (int i = 0; i < numbers.length; i++) {
			int remain = target - pairs[i].value;
			temp.value = remain;
			int idx = Arrays.binarySearch(pairs, temp, vCmp);
			if (idx > 0) {
				if (pairs[idx].idx > pairs[i].idx) {
					ret[0] = pairs[i].idx;
					ret[1] = pairs[idx].idx;
				} else {
					ret[0] = pairs[idx].idx;
					ret[1] = pairs[i].idx;
				}
				break;
			}
		}
		return ret;
	}

	public int[] twoSum(int[] numbers, int target) {
		int[] ret = new int[2];
		HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int cur = numbers[i];
			int remain = target - cur;
			if (visited.containsKey(remain)) {
				ret[0] = visited.get(remain) + 1;
				ret[1] = i + 1;
				break;
			} else {
				visited.put(cur, i);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		TwoSum sol = new TwoSum();
		System.out
				.println(Arrays.toString(sol.twoSum(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(sol.twoSum(new int[] { 1, 5, 2, 10,
				9 }, 3)));
		System.out.println(Arrays.toString(sol.twoSum(new int[] { 1, 5, 2, 10,
				9 }, 15)));
		System.out.println(Arrays.toString(sol.twoSum(new int[] { 1, 5 }, 6)));

	}

}
