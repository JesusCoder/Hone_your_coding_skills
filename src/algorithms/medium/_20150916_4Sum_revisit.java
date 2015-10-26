package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Very excited, I implemented this program all by myself and get it accepted on Leetcode, 
 * inspired by the previous problem: 3sum;
 * used two pointers to traverse thru the whole array twice. */

/* Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2) */

public class _20150916_4Sum_revisit {
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		int i = 0;
		int j = 1;
		int p = j + 1;
		int k = num.length - 1;
		for (i = 0; i <= num.length - 4; i++) {
			for (j = i + 1; j <= num.length - 3; j++) {
				p = j + 1;
				k = num.length - 1;
				int sum = num[i] + num[j] + num[p] + num[k];
				while (p < k) {
					if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[p]);
						temp.add(num[k]);
						res.add(temp);
						p++;
						while (p < num.length - 2 && num[p - 1] == num[p]) {
							p++;
						}
						k--;
						while (k > p && num[k + 1] == num[k]) {
							k--;
						}
						sum = num[i] + num[j] + num[p] + num[k];
					} else if (sum > target && p < k) {
						k--;
						while (num[k] == num[k + 1] && k > p) {
							k--;
						}
						sum = num[i] + num[j] + num[p] + num[k];
					} else if (sum < target && p < k) {
						p++;
						while (num[p] == num[p - 1] && k > p) {
							p++;
						}
						sum = num[i] + num[j] + num[p] + num[k];
					}
				}
			}
		}
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		for (int q = 0; q < res.size(); q++) {
			set.add(res.get(q));
		}
		res.clear();
		for (Iterator<ArrayList<Integer>> it = set.iterator(); it.hasNext();) {
			res.add(it.next());
		}
		return res;
	}

	public static void main(String args[]) {
		 int [] num = new int[]{1, 0, -1, 0, -2, 2};
//		int[] num = new int[] { 0, 0, 0, 0 };
		// int [] num = new int[]{-3, -1, 0, 2, 4, 5};
		// int [] num = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
		// int [] num = new int[]{-1, 0, 1, 2, -1, -4};
		System.out.println(fourSum(num, 1));
		System.out.println("Program finished.");
	}
}
