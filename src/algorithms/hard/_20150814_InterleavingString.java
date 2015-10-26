package algorithms.hard;

/**
 * Used answer from online, didn't fully understand it, need to come back and
 * study it.
 */

public class _20150814_InterleavingString {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		// String s3 = "aadbbbacccdef";
		char[] s1c = s1.toCharArray();
		char[] s2c = s2.toCharArray();
		char[] s3c = s3.toCharArray();
		System.out.println(recursive(s1c, s2c, s3c, 0, 0, 0) + "\nThe end.");

		System.out.println(dp(s1, s2, s3) + "\nThe end.");

	}

	private static boolean recursive(char s1[], char s2[], char s3[], int p1,
			int p2, int p3) {
		boolean result = false;
		if (p1 == s1.length && p2 == s2.length && p3 == s3.length)
			return true;
		// if any 2 are full but the other is not, can't match.
		if ((p1 == s1.length && p2 == s2.length || p3 == s3.length))
			return false;

		return p3 < s3.length && p1 < s1.length && s3[p3] == s1[p1]
				&& recursive(s1, s2, s3, p1 + 1, p2, p3 + 1) || p3 < s3.length
				&& p2 < s2.length && s3[p3] == s2[p2]
				&& recursive(s1, s2, s3, p1, p2 + 1, p3 + 1);
	}

	private static boolean dp(String s1, String s2, String s3) {
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
					System.out.print("ok[" + i + "][" + j + "][" + k + "]: "
							+ ok[i][j][k] + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}

		return ok[ss1.length][ss2.length][ss3.length];
	}
}
