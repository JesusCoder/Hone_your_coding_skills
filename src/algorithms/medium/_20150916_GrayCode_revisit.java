package algorithms.medium;

import java.util.ArrayList;

/* Leetcode: 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 00 - 0
 01 - 1
 11 - 3
 10 - 2

 */

/* I finished this problem based on some hint from the Internet, but I implemented all by myself!
 * Hooray! */

public class _20150916_GrayCode_revisit {
	public static int pow(int n, int power) {
		int res = n;
		if (power == 0) {
			return 1;
		} else if (power == 1) {
			return n;
		} else {
			for (int i = power; i > 1; i--) {
				res = res * n;
			}
		}
		return res;
	}

	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n == 0) {
			res.add(0);
		} else if (n == 1) {
			res.add(0);
			res.add(1);
		} else if (n == 2) {
			res.add(0);
			res.add(1);
			res.add(3);
			res.add(2);
		} else/*
			 * for n is greater than 2: for example when n equals 3, we got 8
			 * numbers, they're [0,1,3,2,6,7,5,4], we can see that the last four
			 * numbers are the first four numbers plus 4 in reverse order, i.e.
			 * 6 = 2+4; 7 = 3+4; 5 = 1+4; 4 = 0+4; and 4 is just value that the
			 * bit that gets added when we increase from a two-bit number to a
			 * three-bit number. So is when n becomes 4, 5, 6, etc. Then that
			 * forms the algorithm.
			 */
		{
			res.add(0);
			res.add(1);
			res.add(3);
			res.add(2);

			for (int i = 3; i <= n; i++) {
				for (int j = res.size() - 1; j >= 0; j--) {
					res.add(res.get(j) + pow(2, i - 1));
				}

			}

		}

		return res;
	}

	public static void main(String args[]) {
		// System.out.println(pow(2, 7));
		System.out.print(grayCode(4));

	}
}
