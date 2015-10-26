package algorithms.medium;

/** Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. */


/** My idea:
 * In order to meet the O(log n) requirment, we must use binary search. 
 * Then I implemented it as follows, after trial and error, it got accepted on Leetcode. 
 * I did this all by myself, step by step debugging, hooray! */

public class _20150916_SearchForARange_revisit {
	public static int[] searchRange(int[] A, int target) {
		int range[] = new int[] { -1, -1 };
		int len = A.length;
		if (len == 0 || target > A[len - 1] || target < A[0])
			return range;
		if (len == 1) {
			if (A[0] == target) {
				range[0] = 0;
				range[1] = 0;
				return range;
			} else {
				return range;
			}
		} else {
			int start = 0, end = len - 1, mid = len / 2;// these are three
														// indexes to indicate
														// three points in the
														// array
			while (start <= end) {
				if (A[mid] < target) {
					start = mid + 1;
					mid = (start + end) / 2;
				} else if (A[mid] > target) {
					end = mid - 1;
					mid = (start + end) / 2;
				} else if (A[mid] == target) {
					range[0] = mid;
					range[1] = mid;
					for (int i = mid + 1; i <= end; i++) {
						if (A[i] == target) {
							range[1] = i;
						}
					}
					for (int i = mid - 1; i >= start; i--) {
						if (A[i] == target) {
							range[0] = i;
						}
					}
					System.out.println(range[0] + " " + range[1]);
					break;// set this break statement, this is extremely
							// important, otherwise infinite loop
				}
			}
		}
		return range;
	}

	public static void main(String args[]) {
		int[] a = new int[] { 1, 3 };
		searchRange(a, 1);
	}
}
