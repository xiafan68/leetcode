package fanxia;

public class ReverseBits {
	// you need treat n as an unsigned value
	/**
	 * 这个算法犯了一个错误，那就是如果n是负数，那么最高位是不能通过除法算出来的
	 * @param n
	 * @return
	 */
	public static int reverseBits(int n) {
		int ret = 0;
		for (int i = 0; i < 31; i++) {
			int bit = n % 2;
			n = n >> 1;
			ret = ret | (bit << (31 - i));
		}
		if (n < 0)
			ret = ret | 1;
		return ret;
	}

	public static int reverseBits1(int n) {
		// INT_SIZE=32 in general
		int INT_SIZE = Integer.SIZE;

		for (int i = 0; i < INT_SIZE / 2; i++) {
			int j = INT_SIZE - 1 - i;

			int lowBit = (n >> i) & 1;
			int highBit = (n >> j) & 1;

			int lowMask = 1 << i;
			int highMask = 1 << j;
			// 通过异或操作实现swap
			if ((highBit ^ lowBit) == 1) {
				n = n ^ (lowMask | highMask);
			}
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
		System.out.println(reverseBits(-1));
		System.out.println(reverseBits1(0x80000000));
		System.out.println(reverseBits(0x80000000));
	}
}
