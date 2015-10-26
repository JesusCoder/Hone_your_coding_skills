package algorithms.medium;

/* With Xi Huang's algorithm, I finally implemented this program by myself, also
 * I learned how to check the contents of each variable using Eclipse features instead of
 * laboriously writing print functions frequently when testing. */

/* Now I have a better understanding of recursion, you can always try to write a separate function
 * which takes in MULTIPLE parameters, some of them should be timely updated, also one of the parameters
 * should just be the final return result, in this way, we can just declare this function type VOID, then
 * just return the result, I think this is the KEY to implement DFS and recursive functions.*/
import java.util.ArrayList;

import TreeUtils.TreeNode;

/* Given a binary tree and a sum, 
 * find all root-to-leaf paths where each path's sum equals the given sum.

For example:

Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
] 
 */

public class _20150916_PathSumII_revisit {
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		int sum0 = 0;
		dfs(root, sum, sum0, path, res);
		return res;
	}

	public static void
	dfs(TreeNode root, int sum, int sum0, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
		path.add(root.val);
		sum0 += root.val;
		if(root.left == null && root.right == null){
			if(sum0 == sum){
				res.add(new ArrayList<Integer>(path));
				/* the above line of code needs special attention, I must NEW an ArrayList
				 * for path, and must put parenthesis to surround "path", otherwise,
				 * I just add a pointer called "path" into res, and any functions applying
				 * to path, will directly influence the elements in res!!!
				 * This is very KEY! */
				path.remove(path.size()-1);
			}
			else{
				path.remove(path.size()-1);
				sum0 = sum0 - root.val;
			}
		}
		else{
			if(root.left != null){
				dfs(root.left, sum, sum0, path, res);
			}
			if(root.right != null){
				dfs(root.right, sum, sum0, path, res);
			}
			path.remove(path.size()-1);
		}	
	}
	
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		System.out.println(pathSum(root, 22));
		System.out.println("Program finished.");
	}
	
	/** This is a failed program, I implemented it from scratch, but it falls into indefinite loop,
	 * this is my attempts to try to master DFS. */
	public static ArrayList<ArrayList<Integer>> pathSum_myOwnTrial(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		ArrayList<Integer> a = new ArrayList<Integer>();
		return res = recurs(root, 0, a, sum);
	}
	
	static ArrayList<ArrayList<Integer>> res = new ArrayList();
	public static ArrayList<ArrayList<Integer>> recurs(TreeNode root, int n, ArrayList<Integer> a, int sum){

		a.add(root.val);
		System.out.println("a:" + a);
		n += root.val;
		System.out.println("n = " + n);
		if(root.left != null){
			recurs(root.left, n, a, sum);
		}
		if(root.right != null){
			recurs(root.right, n, a, sum);
		}
		if(root.left == null && root.right == null){
			if(n == sum){
				res.add(a);
			}
			a.remove(a.size()-1);
			n -= root.val;
			recurs(root, n, a, sum);
		}
		return res;
	}
}
