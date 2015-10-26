package algorithms.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Didn't even bother to think this time, just used the solution from discuss:
 * https://leetcode.com/discuss/21020/hashmap-java-ac-code but it seems
 * straightforward to understand and fits my conceptual model.
 */

public class _20150814_PermutationsII {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 1, 2 };
		printListOfList(permuteUnique(num));
		System.out.println("The end");
	}

	public static List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		if (num.length == 0)
			return permutations;
		HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if (occurrences.containsKey(num[i])) {
				occurrences.put(num[i], occurrences.get(num[i]) + 1);
			} else {
				occurrences.put(num[i], 1);
			}
		}
		List<Integer> curList = new ArrayList<Integer>();
		helper(occurrences, permutations, curList);
		return permutations;
	}

	/* This RECURSIVE helper function is the key to this algorithm. */
	private static void helper(HashMap<Integer, Integer> occurrences,
			List<List<Integer>> permutations, List<Integer> curList) {
		if (occurrences.isEmpty()) {
			permutations.add(curList);
			return;
		}
		for (int key : occurrences.keySet()) {
			List<Integer> newList = new ArrayList<Integer>(curList);
			HashMap<Integer, Integer> newOccurrences = new HashMap<Integer, Integer>(
					occurrences);
			newList.add(key);
			newOccurrences.put(key, newOccurrences.get(key) - 1);
			if (newOccurrences.get(key) == 0) {
				newOccurrences.remove(key);
			}
			helper(newOccurrences, permutations, newList);
		}
	}

	private static void printListOfList(List<List<Integer>> permuteUnique) {
		for (List<Integer> list : permuteUnique) {
			for (int i : list) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
