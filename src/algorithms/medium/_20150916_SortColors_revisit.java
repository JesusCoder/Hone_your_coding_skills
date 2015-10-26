package algorithms.medium;

/** Leetcode:
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same 
 * color are adjacent, with the colors in the order red, white and blue. 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue 
 * respectively. 
 * Note: You are not supposed to use the library's sort function for this problem. */


/** Suppose this problem doesn't require to sort them in a stable way, if it requires, I'll have to set
 * the values of the HashMap to be an ArrayList. 
 * Hooray, it accepts! No need to sort them in a stable way! And even no need to use HashMap! */

/** But DO keep in mind that I shouldn't use print statements, otherwise OJ will always report internal
 * errors! */

/** I finished this job all by myself, pretty soon, hooray! */

public class _20150916_SortColors_revisit {
	public static void sortColors(int[] A) {
		int len = A.length;
		if (len == 1) {
			System.out.println(A[0]);
		} else {
			int counter0 = 0;
			int counter1 = 0;
			int counter2 = 0;
			for (int i : A) {
				if (i == 0) {
					counter0++;
				} else if (i == 1) {
					counter1++;
				} else {
					counter2++;
				}
			}
			// System.out.println("counter0, counter1 and counter2 are " +
			// counter0 + " " + counter1 + " " + counter2);
			for (int i = 0; i < counter0; i++) {
				A[i] = 0;
			}
			int startOf2 = counter1 + counter0;
			for (int j = counter0; j < startOf2; j++) {
				A[j] = 1;
			}
			for (int k = startOf2; k < len; k++) {
				A[k] = 2;
			}
			for (int i : A) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String args[]) {
		int a[] = new int[] { 0 };
		sortColors(a);
	}
}
