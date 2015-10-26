package algorithms.medium;

/* I got the major idea from Internet and then implemented and debugged this 
 * program by myself. 
 * 
 * Algorithm: use two pointers, actually three pointers:
 * first, set one pointer at the beginning to traverse the whole array,
 * second, set two poiners, one called start, the other called end,
 * for each number num[i], we traverse the whole rest of the array by moving the
 * start and end pointers, to find all the possible triplets. */


/* Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2) */

import java.util.*;

public class _20150916_3Sum_revisit {
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		Arrays.sort(num);
		int len = num.length;
		if(len == 0){
			return res;
		}
		for(int i = 0; i < len; i++){
			System.out.print(num[i] + " ");
		}
		for(int i = 0; num[i] <= 0 && i < len - 2; i++){
			//remove duplicates
			if(i > 0 && num[i] == num[i-1]){
				continue;
			}
			int start = i + 1;
			int end = len - 1;
			for(; start < len -1 && end > start;){
					//remove duplicates
					if(end < len - 1 && num[end] == num[end+1]){
						end--;/*It's also very tricky here, NEVER forget to update the end pointer,
						otherwise it might be indefinite loop.*/
						continue;
					}
					int sum = num[i] + num[start] + num[end];
					if(sum > 0){
						end--;
					}
					else if(sum < 0){
						start++;
					}
					else{// here sum == 0
						ArrayList<Integer> a = new ArrayList();
						a.add(num[i]);
						a.add(num[start]);
						a.add(num[end]);
						res.add(a);
						start++;
						end--;
						/* it's very tricky here, NEVER forget to update start and end here, otherwise
						 * it's infinite loop. */
					}
				}
			}
		return res;
	}

	public static void main(String args[]){
		//int [] num = new int[]{-1, 0, 1, 2, -1, -4};
		//int [] num = new int[]{0, 0, 0, 0, 0};
		//int [] num = new int[] {1,-1,-1,0};
		//int [] num = new int[]{-2, 0, 0, 2, 2};
		int [] num = new int[]{1, 1, -1, -1, 0, 1, 1};
		System.out.println(threeSum(num));
	}
}
