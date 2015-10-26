/**
 * 
 */
package algorithms.easy;

import TreeUtils.CommonUtils;

public class _20150916_PlusOne_revisit {
	public static int[] plusOne(int[] digits) {
		int len = digits.length;
		// ArrayList<Integer> temp = new ArrayList();
		int[] res = new int[len];
		int[] res1 = new int[len + 1];
		if (len == 0) {
			return res;
		} else if (len == 1) {
			if (digits[0] == 9) {
				res1[0] = 1;
				res1[1] = 0;
				// for(int i = 0; i < len; i++){
				// System.out.print(res1[i] + " ");
				// }
				return res1;
			} else {
				res[0] = digits[0] + 1;
				// here remove res[1], I must implement this here!
				// for(int i = 0; i < len; i++){
				// System.out.print(res[i] + " ");
				// }
				return res;
			}
		} else {
			int carry = 1;
			for (int i = len - 1; i >= 0; i--) {
				if (digits[i] == 9 && carry == 1) {
					res[i] = 0;
					carry = 1;
				} else {
					if (carry == 1) {
						res[i] = digits[i] + 1;
						carry = 0;
					} else {
						res[i] = digits[i];
						carry = 0;
					}
				}
			}
			if (carry == 1) {
				res1[0] = 1;
				for (int i = 0; i < len; i++) {
					res1[i + 1] = res[i];
				}
				return res1;
			} else {
				// for(int i = 1; i < len+1; i++){
				// res[i-1] = res[i];
				// }
			}
			// for(int i = 0; i < len; i++){
			// System.out.print(res[i] + " ");
			// }
			return res;
		}
	}

	public static void main(String args[]) {
		int[] a = new int[] { 0 };
		plusOne(a);
		CommonUtils.print("Program ended.");
	}
}

