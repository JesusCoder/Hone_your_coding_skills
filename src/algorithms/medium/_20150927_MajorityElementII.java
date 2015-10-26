package algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**I got this one accepted on the first time I submitted! And I wrote this program all by myself! Without any help from online.
 * Although its runtime is only better than 1.59% of all java submissions.
 * Apparently there's something that can be improved here.*/

public class _20150927_MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
		Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(counterMap.containsKey(nums[i])){
				counterMap.put(nums[i], counterMap.get(nums[i])+1);
			} else {
				counterMap.put(nums[i], 1);
			}
		}
		int size = nums.length;
		List<Integer> result = new ArrayList<Integer>();
		for(Integer i : counterMap.keySet()){
			if(counterMap.get(i) > size/3){
				result.add(i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 2, 2, 2, 2, 3, 3, 3, 3};
		_20150927_MajorityElementII test = new _20150927_MajorityElementII();
		System.out.print(test.majorityElement(nums));
	}

}
