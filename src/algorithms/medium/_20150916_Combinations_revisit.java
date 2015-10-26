package algorithms.medium;

import java.util.ArrayList;

import TreeUtils.CommonUtils;
import TreeUtils.ListNode;

/** I copied this algorithm online. I thought the way to solve it, but got stuck, since
 * I didn't consider to use RECURSION!*/

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n. For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */

public class _20150916_Combinations_revisit {
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		rec(res, list, 1, n, k);
		return res;
	}

	public static void rec(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, int start, int n, int k) {
		/* base case, when k equals zero, put it into final result */
		if (k == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i <= n - k + 1; i++) {
			list.add(i);
			rec(res, list, i + 1, n, k - 1);
			list.remove(list.size() - 1);/*
										 * remove the last element to restore to
										 * its previous condition
										 */
		}
	}

	public static void main(String args[]) {
		System.out.println(combine(4, 2));
		System.out.println("Program finished.");
	}
}
