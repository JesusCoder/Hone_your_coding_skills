/**
 * 
 */
package algorithms.easy;

/** Given a sorted array, remove the duplicates 
 * in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].*/


/** I solved this problem all by myself! Hooray! This is so encouraging! Although I got some hint
 * from one of the previous problems. */

/** One thing to note here is that the array is SORTED! Don't ignore this given condition.
 * My algorithm, traverse this array, for each element, compare it with its previous
 * one, if they're equal, then do nothing, if not, assign it into the new array. */

public class _20150916_RemoveDuplicatesFromSortedArray_revisit {
	public static int removeDuplicates(int[] A) {
		int len = A.length;
		if (len == 0)
			return 0;
		else {
			int num = 1;
			A[num - 1] = A[0];
			for (int i = 1; i < len; i++) {
				if (A[i] != A[i - 1]) {
					A[num++] = A[i];
				}
			}
			// for(int i = 0; i < num; i++){
			// System.out.print(A[i] + " ");
			// }
			return num;
		}
	}

	public static void main(String args[]) {
		int[] a = new int[] { 1, 2, 2, 3, 3, 3, 4 };
		System.out.println(removeDuplicates(a));
	}
}


