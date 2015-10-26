package algorithms.medium;

/** What I originally thought was brute-force, use two for loops, but undoubtely, it exceeded time limit.
 * Then I copied the algorithm from online: using two pointers, one start from the beginning, the other
 * starts from the end, compare them, the smaller one moves forward, then calculate its area. */

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */

public class _20150916_ContainerWithMostWater_revisit {
	public static int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		int len = height.length;
		int i = 0, j = len - 1;
		while (i < j) {
			if (Math.min(height[i], height[j]) * (j - i) > max) {
				max = Math.min(height[i], height[j]) * (j - i);
			}
			if (height[i] <= height[j]) {// we need to find the shorter one,
											// then calculate its area
				i++;
			} else {
				j--;
			}
		}
		return max;
	}

	public static void main(String args[]) {
//		int[] h = new int[] { 4, 4, 2, 11, 0, 11, 5, 11, 13, 8 };
		 int [] h = new int[]{1, 1, 2, 3, 4, 0, 9, 2};
		System.out.println(maxArea(h));
		System.out.println("Program finished.");
	}
}
