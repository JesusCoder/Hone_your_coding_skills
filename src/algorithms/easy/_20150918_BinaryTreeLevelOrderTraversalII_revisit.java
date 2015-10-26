/**
 * 
 */
package algorithms.easy;

/* I successfully implemented this program by myself, following the idea from binaryTreeLevelOrderTraversal
 * , just in the end, I reversed the result, then it got accepted. */

/* Given a binary tree, return the bottom-up level order 
 * traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
] */
import java.util.*;

import TreeUtils.TreeNode;
public class _20150918_BinaryTreeLevelOrderTraversalII_revisit {
	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		if(root == null){
			return res;
		}
		ArrayList<Integer> level = new ArrayList();
		level.add(root.val);
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		res.add(level);
		int newcnt = 1, oldcnt = 1;
		while(!q.isEmpty()){
			level = new ArrayList();
			oldcnt = newcnt;
			newcnt = 0;
			for(int i = 0; i < oldcnt; i++){
				if(q.peek().left != null){
					newcnt++;
					q.add(q.peek().left);
					level.add(q.peek().left.val);
				}
				if(q.peek().right != null){
					newcnt++;
					q.add(q.peek().right);
					level.add(q.peek().right.val);
				}
				q.remove();
			}
			if(level.size() != 0){
				res.add(level);
			}
		}
		ArrayList<ArrayList<Integer>> finalres = new ArrayList();
		for(int j = res.size()-1; j >= 0; j--){
			ArrayList<Integer> temp = new ArrayList();
			temp = res.get(j);
			finalres.add(temp);
		}
		return finalres;
	}
	public static void main(String args[]){
		System.out.println("Program started.");
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.left.left.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		root.right.right.right.left = new TreeNode(10);
		root.right.right.right.left.right = new TreeNode(11);
		root.right.right.right.left.left = new TreeNode(12);
		
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
		
		System.out.println(levelOrderBottom(root));
		System.out.println("Program finished.");
	}
}



