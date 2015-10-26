package algorithms.medium;

/** Leetcode: Implement pow(x, n).
 * 
 * I wrote mine at first, but it didn't work out, because I failed to take into account of
 * the situation when n is negative. But when I tried to consider this scenario, I didn't come
 * up with a possible solution. 
 * 
 * So I got the following algorithm online. 
 * 
 * Recursion is more efficient than iteration, also it uses loop unrolling by a factor of two,
 * this also significantly increases the efficiency. */

public class _20150916_ImplementPow_revisit {
	public static double pow(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		double temp = pow(x, Math.abs(n / 2));
		if (n > 0) {
			if (n % 2 != 0)/*
							 * if n is odd, we need to multiply x one more time
							 * b/c the division in Java truncates the remainder.
							 */{
				// System.out.println(temp);
				return temp * temp * x;
			} else
				return temp * temp;
		} else {

			if (n % 2 != 0) {
				// System.out.println(temp);
				return 1.0 / (temp * temp * x);
			} else
				return 1 / (temp * temp);
		}
	}

	public static void main(String args[]) {
		double x = 2.0;
		int n = -5;
		System.out.println(pow(x, n));
	}
}

