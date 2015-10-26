package algorithms.medium;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 */
public class _20151020_MaximumProductSubarray {
	/**This is the closest I could get, but failed at 104/184 test cases, b/c I didn't consider
	 * enough edge cases.*/
	public int maxProduct_failedVersion(int[] nums) {
		int currentMax = nums[0], max = nums[0];
		for(int i = 1; i < nums.length; i++){
			currentMax = Math.max(nums[i], currentMax*nums[i]);
			max = Math.max(currentMax, max);
		}
		return max;
	}
	
	/**The following accepted algorithm I copied from discuss.
	 * This is a very clever algorithm, it uses temp, pos and neg to
	 * keep temp values to take care of those "double-negative becomes positive" cases.*/
	public int maxProduct_acceptedVersion(int[] nums) {
        int pos = nums[0], neg = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = pos;
            pos = Math.max(nums[i], nums[i]*((nums[i]>=0)?pos:neg));
            neg = Math.min(nums[i], nums[i]*((nums[i]>=0)?neg:temp));
            max = Math.max(max,pos);
        }
        return max;
    }
	
	public static void main(String... args){
		_20151020_MaximumProductSubarray test = new _20151020_MaximumProductSubarray();
//		int[] nums = new int[]{0, 2};
		int[] nums = new int[]{-2, 3, -4};
		System.out.println(test.maxProduct_acceptedVersion(nums));
//		System.out.println(test.maxProduct_failedVersion(nums));
	}
}
