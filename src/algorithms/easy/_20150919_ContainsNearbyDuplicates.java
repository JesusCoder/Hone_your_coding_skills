package algorithms.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _20150919_ContainsNearbyDuplicates {
	/**
	 * Cool! I figured this out all by myself! Failed at first submission, and
	 * then I quickly figured out the reason, then added one line, re-submitted,
	 * then it got accepted! Cool! Praise the Lord! Though this is labeled as an
	 * EASY problem. Cheers.
	 */
	public boolean containsDuplicate(int[] nums, int k) {
		
		if(nums.length <= 1){
			return false;
		}
		
		//use the number as key and the index as value
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int i = 0, j = 0;
		for(int m = 0; m < nums.length; m++){
			if(!map.containsKey(nums[m])){
			map.put(nums[m], m);
			} else {
				i = m;
				j = map.get(nums[m]);
				map.put(nums[m], m);
			}
		}
		if(i == j){
			return false;
		} else if(Math.abs(i-j) <= k){
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String... args){
//		int[] nums = new int[]{0};
//		int[] nums = new int[]{0, 1, 2, 3, 4, 5};
		int[] nums = new int[]{1, 0, 1, 1};
		_20150919_ContainsNearbyDuplicates test = new _20150919_ContainsNearbyDuplicates();
		System.out.println(test.containsDuplicate(nums, 1));
	}
}
