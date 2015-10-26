package algorithms.medium;

/** I implemented this by myself, but used the algorithm from Cracking. */

/** Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
] */
import java.util.*;
public class _20150916_Subsets_revisit {
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		if(S.length == 0){
			return allSubsets;
		}
		else if(S.length == 1){
			ArrayList<Integer> newSubsets1 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets2 = new ArrayList<Integer>();
			newSubsets1.add(S[0]);
			allSubsets.add(newSubsets1);
			allSubsets.add(newSubsets2);
		}
		else if(S.length == 2){
			Arrays.sort(S);
			ArrayList<Integer> newSubsets1 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets2 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets3 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets4 = new ArrayList<Integer>();
			newSubsets1.add(S[0]);
			newSubsets2.add(S[1]);
			newSubsets3.add(S[0]);
			newSubsets3.add(S[1]);
			allSubsets.add(newSubsets1);
			allSubsets.add(newSubsets2);
			allSubsets.add(newSubsets3);
			allSubsets.add(newSubsets4);
		}
		else{
			Arrays.sort(S);
			ArrayList<Integer> newSubsets1 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets2 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets3 = new ArrayList<Integer>();
			ArrayList<Integer> newSubsets4 = new ArrayList<Integer>();
			newSubsets1.add(S[0]);
			newSubsets2.add(S[1]);
			newSubsets3.add(S[0]);
			newSubsets3.add(S[1]);
			allSubsets.add(newSubsets4);//add empty set into the first position
			allSubsets.add(newSubsets1);
			allSubsets.add(newSubsets2);
			allSubsets.add(newSubsets3);


			for(int i = 2; i < S.length; i++){
				ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
				for(int j = 0; j < allSubsets.size(); j++){
					ArrayList<Integer> newSubsets = new ArrayList<Integer>();
					newSubsets = new ArrayList<Integer>(allSubsets.get(j));/* MUST put allSubsets.get(j)
					into the parenthesis, otherwise it won't work!!!! This is the pitfall that took me an hour to debug
					but Yue Gu helped me find it! The function takes parameters that are put in the parenthesis! */
					newSubsets.add(S[i]);
					moreSubsets.add(newSubsets);
				}
				allSubsets.addAll(moreSubsets);
			}
		}
		return allSubsets;
	}
	
	public static void main(String args[]){
		int [] S = new int[]{4, 1, 0};
		System.out.println(subsets(S));
		System.out.println("Now calling dfs version:");
		System.out.println(subsets_dfs_version(S));
		System.out.println("Program finished.");
	}
	
	public static ArrayList<ArrayList<Integer>> subsets_dfs_version(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(S);
		res.add(temp);
		dfs(res, temp, S, 0);
		return res;
	}
	public static void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int [] S, int pos){
		for(int i = pos; i <= S.length-1; i++){
			temp.add(S[i]);
			res.add(new ArrayList<Integer>(temp));
			System.out.println("Place 1");
			dfs(res, temp, S, i+1);
			temp.remove(temp.size()-1);
			System.out.println("Place 2");
		}
	}
}
