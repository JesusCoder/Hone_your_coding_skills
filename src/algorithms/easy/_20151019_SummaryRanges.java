package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class _20151019_SummaryRanges {
	
	/**Nice! I made it accepted on by myself, from thinking of the algorithm, to code it up, and debug it, without looking for any sort of help!
	 * Nice! Praise the Lord!*/
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if(nums.length == 0){
			return result;
		}
		int beginning = nums[0], end = nums[0], i = 0;
		for(; i < nums.length; i++){
			beginning = nums[i];
			end = nums[i];
			while(i+1 < nums.length && nums[i+1] - nums[i] == 1){
				i++;
			}
			end = nums[i];
			String oneSummary = createOneSummary(beginning, end);
			result.add(oneSummary);
		}
		return result;
	}

	private String createOneSummary(int beginning, int end) {
		String summary = null;
		if(beginning != end){
			summary = beginning + "->" + end;
		} else {
			summary = String.valueOf(beginning);
		}
		return summary;
	}
	
	public static void main(String... args){
		System.out.println("test started!");
		_20151019_SummaryRanges test = new _20151019_SummaryRanges();
//		int[] nums = new int[]{0,1,2,4,5,7};
		int[] nums = new int[]{0,1};
		System.out.println(test.summaryRanges(nums));
		System.out.println("test ended!");
	}
}
