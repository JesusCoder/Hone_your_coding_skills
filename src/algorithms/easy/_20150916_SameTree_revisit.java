/**
 * 
 */
package algorithms.easy;

import TreeUtils.TreeNode;

/* Given two binary trees, write a function to check if 
 * they are equal or not. Two binary trees are considered 
 * equal if they are structurally identical and the nodes 
 * have the same value. */

/* This is a super easy question, but I didn't solve it by myself, simply because 
 * I'm not familiar with recursive at all! I need more and more practice for recursive! */

public class _20150916_SameTree_revisit {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if((p == null && q != null) || (p != null && q == null)){
			return false;
		}
		else if(p == null && q == null){
			return true;
		}
		else if(p.val != q.val){
			return false;
		}
		else{
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
	public static void main(String args[]){
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		System.out.println(isSameTree(root1, root2));
	}
}
