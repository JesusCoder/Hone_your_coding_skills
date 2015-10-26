package algorithms.easy;

import java.util.HashSet;
import java.util.Set;

public class _20150919_ContainsDuplicates {
	/**Really super easy question, I got it accepted all by myself in less than 5 mins.*/
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> uniqueSet = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(!uniqueSet.add(nums[i])){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String... args){
		int[] nums = new int[]{0};
//		int[] nums = new int[]{0, 1, 2, 3, 4, 5};
		_20150919_ContainsDuplicates test = new _20150919_ContainsDuplicates();
		System.out.println(test.containsDuplicate(nums));
	}
}
