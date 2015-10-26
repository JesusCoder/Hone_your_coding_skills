/**
 * 
 */
package algorithms.easy;

/** Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321*/

/* done by myself, cool! */

public class _20150916_ReverseInteger_revisit {
	public static int reverse(int x) {
		String X = Integer.toString(x);
		if (x < 0) {
			X = X.substring(1);// get rid of the negative sign if it has one
			char[] A = X.toCharArray();
			int len = X.length();
			if (len == 2) {
				char temp = A[0];
				A[0] = A[1];
				A[1] = temp;

				String resStr = "";
				for (char i : A) {
					resStr = resStr + i;
				}
				int res = Integer.parseInt(resStr);
				res = -res;
				return res;
			} else {
				for (int i = 0, j = len - 1; i < len / 2 && j >= len / 2; i++, j--) {
					char temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
				String resStr = "";
				for (char i : A) {
					resStr = resStr + i;
				}
				int res = Integer.parseInt(resStr);
				res = -res;
				return res;
			}
		} else {
			char[] A = X.toCharArray();
			int len = X.length();
			if (len == 2) {
				char temp = A[0];
				A[0] = A[1];
				A[1] = temp;

				String resStr = "";
				for (char i : A) {
					resStr = resStr + i;
				}
				int res = Integer.parseInt(resStr);
				return res;
			} else {
				for (int i = 0, j = len - 1; i < len / 2 && j >= len / 2; i++, j--) {
					char temp = A[i];
					// System.out.println(temp);
					A[i] = A[j];
					// System.out.println(A[i]);
					A[j] = temp;
					// System.out.println(A[j]);
					// System.out.println(i + " " + j);
				}
				String resStr = "";
				for (char i : A) {
					resStr = resStr + i;
				}
				int res = Integer.parseInt(resStr);
				return res;
			}
		}
	}

	public static void main(String args[]) {
		System.out.println(reverse(901000));
	}
}


