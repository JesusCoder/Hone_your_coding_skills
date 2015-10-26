package algorithms.medium;

/** All by myself, took 45 mins to get it accepted. 
 * I basically used the algorithm from subsets.java, and cheated a little bit in the end:
 * I simply put the result into a HashSet to filter all the duplicates, then put the non-duplicate into
 * result and return.*/

/** Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. */

import java.util.*;
public class _20150916_SubsetsII_revisit {
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if(len == 0){
			return res;
		}
		else if(len == 1){
			ArrayList<Integer> newSubsets1 = new ArrayList<Integer>();
			newSubsets1.add(num[0]);
			ArrayList<Integer> newSubsets2 = new ArrayList<Integer>();
			res.add(newSubsets1);
			res.add(newSubsets2);
			return res;
		}
		else if(len == 2){
			Arrays.sort(num);
			if(num[0] != num[1]){
				ArrayList<Integer> newSubsets2 = new ArrayList<Integer>();
				newSubsets2.add(num[0]);
				res.add(newSubsets2);
			}
			
			ArrayList<Integer> newSubsets1 = new ArrayList<Integer>();
			res.add(newSubsets1);//empty set
			ArrayList<Integer> newSubsets3 = new ArrayList<Integer>();
			newSubsets3.add(num[1]);
			res.add(newSubsets3);
			ArrayList<Integer> newSubsets4 = new ArrayList<Integer>();
			newSubsets4.add(num[0]);
			newSubsets4.add(num[1]);
			res.add(newSubsets4);
			return res;
		}
		else {
			Arrays.sort(num);
			ArrayList<Integer> newSubsets1 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets2 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets3 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets4 = new ArrayList<Integer>();
			
			res.add(newSubsets1);//empty set
			
			newSubsets2.add(num[0]);
			res.add(newSubsets2);
			
			newSubsets3.add(num[1]);
			res.add(newSubsets3);
			
			newSubsets4.add(num[0]);
			newSubsets4.add(num[1]);
			res.add(newSubsets4);
			
			for(int i = 2; i < len; i++){
				ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
				for(int j = 0; j < res.size(); j++){
					ArrayList<Integer> newSubsets = new ArrayList<Integer>(res.get(j));
					newSubsets.add(num[i]);
					moreSubsets.add(newSubsets);					
				}
				res.addAll(moreSubsets);
			}
		
			Set<ArrayList<Integer>> set = new HashSet();
			for(int i = 0; i < res.size(); i++){
				set.add(res.get(i));
			}
			res.clear();
			Iterator it = set.iterator();
			while(it.hasNext()){
				res.add((ArrayList<Integer>) it.next());
			}	
		}
		return res;
	}
	public static void main(String args[]){
		int [] S = new int[]{1, 2, 2};
		System.out.println(subsetsWithDup(S));
		System.out.println("Program finished.");
	}
}
