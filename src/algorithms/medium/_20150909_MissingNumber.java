/**
 * 
 */
package algorithms.medium;

import java.util.Arrays;

import TreeUtils.CommonUtils;

/**
 * @author jiahuan
 * problem here: https://leetcode.com/problems/missing-number/
 */
public class _20150909_MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] nums = new int[]{0, 1, 3};
		CommonUtils.print(missingNumber(nums));
	}
	
	/**
	 * Cool! I made it! I coded out this problem all by myself! Debugged it and
	 * sumitted four times! And then it got accepted and my runtime even beats
	 * 95.18% of total java submission! Praise the Lord!
	 */
	public static int missingNumber(int[] nums) {
		if(nums.length == 1 && nums[0] == 0){
			return 1;
		} else if(nums.length == 1){
			return 0;
		}
		int result = 0;
		Arrays.sort(nums);
		if(nums[0] == 1){
			return 0;
		}
		int i = 0;
		for(; i < nums.length-1; i++){
			if(nums[i+1] - nums[i] == 2){
				result = nums[i]+1;
				break;
			}
		}
		if(i == nums.length-1){
			result = nums[nums.length-1]+1;
		}
		return result;
	}

}
