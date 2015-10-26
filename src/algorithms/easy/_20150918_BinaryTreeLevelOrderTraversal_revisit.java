/**
 * 
 */
package algorithms.easy;

/* Very excited, although I peeked a little bit from 大神's blog to get a little inspiration
 * on how to implement "for all nodes in n's adjacent" this function, I implemented then everything
 * all by myself and get it accepted on Leetcode! Hooray! */

/* Given a binary tree, return the level 
 * order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
] */

import java.util.*;

import TreeUtils.TreeNode;
public class _20150918_BinaryTreeLevelOrderTraversal_revisit {
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList();	
		if(root == null){
			return res;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		ArrayList<Integer> a = new ArrayList();
		a.add(root.val);
		res.add(a);
		ArrayList<Integer> level = new ArrayList();
		
		int oldcnt = 1, newcnt = 1;
/* The trick here is to use the two counter variables to keep records of all the nodes at
 * the same level! This is very tricky but also very elegant! */
		
		while(!q.isEmpty()){
			oldcnt = newcnt;
			newcnt = 0;
			System.out.println("oldcnt = " + oldcnt + "\tq.peek().val = " + q.peek().val);

			for(int n = 0; n < oldcnt; n++){
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
			System.out.println(level);
			if(level.size() != 0){
			res.add(level);		
			}
			level = new ArrayList();
			
		}

		return res;
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
		
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
		System.out.println(levelOrder(root));
		System.out.println("Program finished.");
	}
}


