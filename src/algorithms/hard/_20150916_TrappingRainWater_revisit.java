package algorithms.hard;

import java.util.Stack;

/* I copied this algorithm from online, didn't figrue this out at all. */

/* Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. 
Thanks Marcos for contributing this image! */

public class _20150916_TrappingRainWater_revisit {
	public static int trap(int[] A) {
		int len = A.length;
		if(len == 0){
			return 0;
		}
		int res = 0;
		
		//first use DP to calculate out left and right arrays
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		
		left[0] = A[0];
		for(int i = 1; i < A.length; i++){
			left[i] = Math.max(left[i-1], A[i]);
		}
		
		right[A.length-1] = A[A.length-1];
		for(int i = A.length-2; i >= 0; i--){
			right[i] = Math.max(right[i+1], A[i]);
		}
		
		for(int i = 1; i < A.length-1; i++){
			res += Math.min(left[i], right[i]) - A[i];
		}
		return res;
	}
	public static void main(String args[]){
		int [] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(a));
		System.out.println("Program finished.");
	}
}
