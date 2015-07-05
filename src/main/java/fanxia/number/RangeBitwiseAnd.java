package fanxia.number;

/**
 * 如果直接循环的从m做到n的话，代价会是o(n)的，显然不行。这个问题的重点是一个int只有32位，只要能够确定每个
 * bit的值就ok了。
 * @author xiafan
 *
 */
public class RangeBitwiseAnd {
	public int rangeBitwiseAnd(int m, int n) {
		return (m != n) ? (rangeBitwiseAnd(m >> 1, n >> 1) << 1) : m;
	}

	public static void main(String[] args) {
		RangeBitwiseAnd and = new RangeBitwiseAnd();
		System.out.println(and.rangeBitwiseAnd(5, 7));
		System.out.println(and.rangeBitwiseAnd(0, 7));
		System.out.println(and.rangeBitwiseAnd(0, 0));
		System.out.println(and.rangeBitwiseAnd(7, 7));
		System.out.println((1 << 31) + " " + Integer.MAX_VALUE);
		//System.out.println(and.rangeBitwiseAnd(1 << 31, Integer.MAX_VALUE));
	}
}