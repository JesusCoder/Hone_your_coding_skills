package algorithms.hard;

public class _20150814_DistinctSubsequences {

	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(numDistinct1(s, t) + "\nThe end.");
		System.out.println(numDistinct2(s, t) + "\nThe end.");
	}

	/**
	 * Didn't even bother to understand the question completely, used the
	 * solution from discuss
	 * https://leetcode.com/discuss/29151/ac-java-solution-
	 * with-o-t-space-and-o-ts-time: Author's comments: I think there is no need
	 * to maintain a matrix TxS; instead, I used a list of counters to track the
	 * number of prefix of T. This should improve in memory usage. For example,
	 * given T="ABC", count[0] = count of "A", count[1] = count of "AB",
	 * count[2] = count of "ABC".
	 */

	public static int numDistinct1(String s, String t) {
		if (t.length() == 0)
			return 0;

		int[] counts = new int[t.length()];
		for (int indexS = 0; indexS < s.length(); indexS++) {
			char charS = s.charAt(indexS);
			for (int indexT = t.length() - 1; indexT >= 0; indexT--) {
				if (t.charAt(indexT) == charS) {
					if (indexT == 0)
						counts[0]++;
					else
						counts[indexT] += counts[indexT - 1];
				}
			}
		}

		return counts[counts.length - 1];
	}

	/**
	 * Another algorithm is as follows, it maintains a matrix, from discuss:
	 * https://leetcode.com/discuss/26680/easy-to-understand-dp-in-java
	 * explanation can be found in that link, very detailed explanation.
	 */
	public static int numDistinct2(String S, String T) {
		// array creation
		int[][] mem = new int[T.length() + 1][S.length() + 1];

		// filling the first row: with 1s
		for (int j = 0; j <= S.length(); j++) {
			mem[0][j] = 1;
		}

		// the first column is 0 by default in every other rows but the first,
		// which we need.

		for (int i = 0; i < T.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				if (T.charAt(i) == S.charAt(j)) {
					mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
				} else {
					mem[i + 1][j + 1] = mem[i + 1][j];
				}
			}
		}

		return mem[T.length()][S.length()];
	}
}
