package algorithms.medium;

/** Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
*/

/** Initially I thought of using HashMap to implement, as some people tried over the Internet, but it didn't
* work out, or at least I didn't make it run, then I googled it and found this incredibly concise and simple
* algorithm, just use exclusive OR to traverse this array! */

/** The reason we can do this is that, a number XOR with itself will end up in zero,
* so as long as the number appears twice, it will set the result to zero;
* and also any number XOR with zero will return itself, so, we can get this unique number by
* directly returning the result of XOR. */

public class _20150916_SingleNumber_revisit {

	public static int singleNumber(int[] A) {
		int len = A.length;
		int xor = 0;
		for (int i = 0; i < len; i++) {
			xor = xor ^ A[i];
		}
		return xor;
	}

	public static void main(String args[]) {
		int a[] = new int[] { 1, 1, 2, 2, 3, 0, 3, 0, 19, 4, 4, 5, 19, 5, 7, 7,
				9, 10, 9, 10, 15 };
		System.out.println(singleNumber(a));
	}
}
