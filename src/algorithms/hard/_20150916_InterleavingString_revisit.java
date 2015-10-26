package algorithms.hard;
/** Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. */

/** Internet said this is a dp problem, I didn't code it out. */

public class _20150916_InterleavingString_revisit {
	public static boolean isInterleave(String s1, String s2, String s3) {

		char ss1[] = s1.toCharArray();
		char ss2[] = s2.toCharArray();
		char ss3[] = s3.toCharArray();

		boolean ok[][][] = new boolean[ss1.length + 1][ss2.length + 1][ss3.length + 1];

		for (int i = 0; i <= ss1.length; i++)
			for (int j = 0; j <= ss2.length; j++)
				ok[i][j][0] = false;

		for (int i = 0; i <= ss3.length; i++) {
			ok[0][0][i] = false;
		}

		ok[0][0][0] = true;

		/*
		 * This triple for loop is the key of this dp solution, need to further
		 * understand it.
		 */
		for (int k = 1; k <= ss3.length; k++) {
			for (int i = 0; i <= ss1.length; i++) {
				for (int j = 0; j <= ss2.length; j++) {
					ok[i][j][k] = (i > 0 && ss3[k - 1] == ss1[i - 1])
							&& ok[i - 1][j][k - 1]
							|| (j > 0 && ss3[k - 1] == ss2[j - 1])
							&& ok[i][j - 1][k - 1];
				}
			}
		}

		return ok[ss1.length][ss2.length][ss3.length];
	}

	public static void main(String args[]) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		// String s3 = "aadbbbaccc";
		System.out.println(isInterleave(s1, s2, s3));
		System.out.println("Program finished.");
	}
}
