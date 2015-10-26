/**
 * 
 */
package algorithms.medium;

import java.util.ArrayList;
/** Leetcode: Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

/** I solved this problem all by myself! Hooray! Although it took me three hours.
 * I didn't give up and look for answers online, instead I kept thinking on my own,
 * was very despaired, but eventually made it accepted on Leetcode! */

public class _20150916_RemoveDuplicatesFromSortedArrayII_revisit {
	public static int removeDuplicates(int[] A) {
		int counter = 0;
		int len = A.length;
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return 1;
		}
		if (len == 2) {
			return 2;
		}

		ArrayList<Integer> a = new ArrayList();
		a.add(A[0]);
		a.add(A[1]);
		for (int i = 2; i < len; i++) {
			if (A[i] != A[i - 1]) {
				a.add(A[i]);
			} else if (A[i] != A[i - 2]) {
				a.add(A[i]);
			}
		}

		counter = a.size();
		for (int i = 0; i < counter; i++) {
			A[i] = a.get(i);
		}

		System.out.print(a);
		return counter;
	}

	public static void main(String args[]) {
		int[] A = new int[] { 1, 1, 1, 2 };
		removeDuplicates(A);
	}
}