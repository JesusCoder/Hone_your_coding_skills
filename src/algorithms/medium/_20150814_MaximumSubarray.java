package algorithms.medium;

/**I used the solution from discuss:
https://leetcode.com/discuss/26995/a-simple-cpp-solution
Very straightforward to understand, cool! Praise the Lord!*/

public class _20150814_MaximumSubarray {

	public static void main(String[] args) {
		int [] nums = {(-2), 1, (-3), 4, (-1), 2, 1, (-5), 4};
		System.out.println(maxSubArray(nums) + "\nThe end.");
	}

	public static int maxSubArray(int[] nums) {
		int maxSum = nums[0], currentSum = nums[0];
		for(int i = 1; i < nums.length; i++){
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSum = Math.max(currentSum, maxSum);
		}
		return maxSum;
	}
}
