package algorithms.hard;

/* Given an unsorted array of integers, find 
 * the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity. */

/* Initially, I came up with an algorithm using HashMap<Integer, HashSet<Integer>>,
 * I was trying to construct the longest consecutive sequence for each element in the
 * array using this nested HashMap, but it proved out to be wrong and its time complexity is n^2.
 * 
 * So I went for help online and found this awesome algorithm!*/

import java.util.*;

public class _20150916_LongestConsecutiiveSequence_revisit {
	public static int longestConsecutive(int[] num) {
		int len = num.length;
		int res = 0; // used to store the return result

		/*
		 * 遇到不能排序又要复杂度O(n)有序的问题，只能增加空间复杂度 用空间换时间，用hashset或者hashtable
		 */

		Set<Integer> set = new HashSet<Integer>();
		for (int i : num) {
			set.add(i);
		}
		/* first put all of the elements into this HashSet. */

		for (int i = 0; i < len; i++) {
			if (set.contains(num[i])) {
				set.remove(num[i]);
				int count = 1;
				int next = num[i] - 1;
				// first let's check all the possible elements that are smaller
				// than num[i] in the array
				while (set.contains(next)) {
					set.remove(next);
					next--;
					count++;
				}

				next = num[i] + 1;
				// then let's check all the possible elements that are larger
				// than num[i] in the array
				while (set.contains(next)) {
					set.remove(next);
					count++;
					next++;
				}
				res = Math.max(res, count);
			}
		}
		return res;
	}

	public static void main(String args[]) {
		int[] num = new int[] { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(num));
	}
}
