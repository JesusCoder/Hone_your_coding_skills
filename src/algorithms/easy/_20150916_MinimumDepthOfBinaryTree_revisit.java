/**
 * 
 */
package algorithms.easy;

import TreeUtils.TreeNode;

/* Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node. */

/* I implemented this code with the hint from George Gu, anyway, I made it, every excited! */

/* The trick here (also where it differs from max depth of a binary tree problem) is that
 * you'll have to consider when half of the tree is empty, in those situations you must
 * traverse the other half of the binary tree and find its min depth and directly return! */
public class _20150916_MinimumDepthOfBinaryTree_revisit {
	public static int minDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		else{
			if(root.left == null && root.right != null){
				return minDepth(root.right) + 1;
			}
			else if(root.right == null && root.left != null){
				return minDepth(root.left) + 1;
			}
			else
				return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}
	}
	public static void main(String args[]){
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.left.left.left.left = new TreeNode(6);
		System.out.println(minDepth(root));
	}
}

