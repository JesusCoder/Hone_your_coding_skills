package algorithms.hard;

/* I used this algorithm online, it's very hard, Xi Huang said he couldn't think it out without
 * referring to solution either. It's particularly hard due to its constraint that constant space and
 * O(n) time. */

/* Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space. */

public class _20150916_FirstMissingPositive_revisit {
	public static int firstMissingPositive(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] > 0 && A[i] != i + 1 && A[i] - 1 < A.length
					&& A[i] != A[A[i] - 1]) {
				swap(A, i, A[i] - 1);
			} else {
				i++;
			}
		}
		for (int j = 0; j < A.length; j++) {
			if (A[j] != j + 1) {
				return j + 1;
			}
		}
		return A.length + 1;// if all values are in the correct position, then
							// we return the last one + 1
	}

	/*
	 * writing this swap() function also takes some wisdom, I'm glad that I
	 * wrote this out exactly the same as online.
	 */
	public static void swap(int[] A, int i, int j) {// i and j are indices in
													// array A
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String args[]) {
		// int [] a = new int[]{3,4,-1,1};
		// int [] a = new int[]{1, 2, 0};
		// int [] a = new int[]{2};
		// int [] a = new int[]{};
		// int [] a = new int[]{1, 0};
		// int [] a = new int[]{2, 1};
		// int [] a = new int[]{-5, 1000};
		int[] a = new int[] { -1, 4, 2, 1, 9, 10 };
		System.out.println(firstMissingPositive(a));
		System.out.println("Program finished.");
	}
}
