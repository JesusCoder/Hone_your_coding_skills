package algorithms.medium;

/* Xi Huang said, this is definitely a DFS problem, so I'll use DFS to resolve this problem, combing with
 * a HashSet inside the DFS to get rid of the duplicates. */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class _20150916_PermutationsII_revisit {

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

	public static void main(String args[]) {
		int[] num = new int[] { 3, 3, 0, 0, 2, 3, 2 };
		System.out.println(permuteUnique(num));
		System.out.println("Program finished.");
	}
}

