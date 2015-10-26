package algorithms.easy;

/**I used the solution from discuss:
 https://leetcode.com/discuss/30967/o-1-space-java-solution
 didn't fully understand it, need to study further.*/

import java.util.Arrays;

public class _20150814_RotateArray {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// int[] array = new int[] { 1, 2 };
		rotate(array, 1);
		System.out.println("The end.");
	}

	public static void rotate(int[] nums, int k) {
		System.out.println(Arrays.toString(nums));
		int start = 0 - k;
		for (; start < 0;) {
			System.out.println("start is: " + start);
			start = start + nums.length;
			System.out.println("start is: " + start + " after addition.");
		}
		if (start == 0)
			return;

		start = nums.length - start;
		System.out.println("start is: " + start + " after subtracting start");

		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, start - 1);
		reverse(nums, start, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int t = nums[start];
			nums[start] = nums[end];
			nums[end] = t;
			start++;
			end--;
		}
	}

	/*
	 * This following algorithm seems to be working as well, I also copied from
	 * discuss, but it just cannot be accepted on OJ.
	 */
	public static void rotate2(int[] nums, int k) {
		System.out.println(Arrays.toString(nums));
		k = k % nums.length;
		int[] res = new int[nums.length]; // target
		int offset = nums.length - k;
		for (int i = 0; i < nums.length; i++) {
			res[i] = nums[(i + offset) % nums.length];
		}
		nums = res;
		System.out.println(Arrays.toString(nums));
	}
}
