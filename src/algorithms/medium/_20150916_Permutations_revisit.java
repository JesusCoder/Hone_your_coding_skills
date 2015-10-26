package algorithms.medium;

/**
 * Given a collection of numbers, return all possible permutations. 
 * I imitated the algorithm from Cracking 9.5 to implement this and get it accepted on Leetcode. */

import java.util.*;

public class _20150916_Permutations_revisit {
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		if (num == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			res.add(a);
			return res;
		}

		int first = num[0];
		int[] remainder = Arrays.copyOfRange(num, 1, num.length);
		ArrayList<ArrayList<Integer>> numbers = permute(remainder);
		for (ArrayList<Integer> number : numbers) {
			for (int j = 0; j <= number.size(); j++) {
				ArrayList<Integer> newPerm = insertNumAt(number, first, j);
				res.add(newPerm);
			}
		}
		return res;
	}

	public static ArrayList<Integer> insertNumAt(ArrayList<Integer> a,
			int number, int index) {
		ArrayList<Integer> start = new ArrayList<Integer>();
		for (int i = 0; i < index; i++) {
			start.add(a.get(i));
		}
		start.add(number);
		for (int i = index; i < a.size(); i++) {
			start.add(a.get(i));
		}
		return start;
	}

	public static void main(String args[]) {
		int[] num = new int[] { 1, 2, 3 };
		System.out.println(permute(num));
		System.out.println("Program finished.");
	}
}
