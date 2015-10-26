/**
 * 
 */
package algorithms.easy;

import TreeUtils.TreeNode;

/* Maximum Depth of Binary Tree 
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the 
longest path from the root node down to the farthest leaf node. */

/* I implemented this code with the help of George Gu, but anyway, I'm still very excited when
 * the code runs. */

public class _20150918_MaximumDepthOfBinaryTree_revisit {
	public static int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		else {
			return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
		}
	}
	public static void main(String... args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		
		System.out.println("The max depth of this tree is " + maxDepth(root));
	}
}
