/**
 * 
 */
package algorithms.easy;

import TreeUtils.TreeNode;

/** Given a binary tree and a sum, determine if the tree 
 * has a root-to-leaf path such that adding up all the values 
 * along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. */

/** I copied this code from Chris Huang. This is a very smart algorithm.
 * 
 * Keep in mind that for RECURSIVE functions, it always pushes the most recent function
 * into stack, and then execute the next one, when reaching the base condition, it will finish
 * the current function and begin executing all the previously pushed-into-the-stack functions
 * one after another until the stack is empty!
 * 
 * This is the core essence of all RECURSIVE functions! Keep it in mind.
 * 
 * Then no wonder why when it reaches hasPathSum(null, -5), it executes return false;
 * and after this, it didn't quit the function and end in there, instead, it keeps executing all the
 * previously executed functions until it meets the condition or traversed the whole tree. */


public class _20150916_PathSum_revisit {
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null && root.val == sum)
			return true;
		else
			return (hasPathSum(root.left, sum - root.val) ||
			/**
			 * attention:here we must put root.left prior to root.right in order
			 * to keep the right order
			 */
			(hasPathSum(root.right, sum - root.val)));
		/**
		 * it will execute the first part of this statement first until it
		 * becomes false, and then it starts to check the second part of this
		 * statement, if the first part becomes true, then the second part won't
		 * be executed at all.
		 */
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		System.out.println(hasPathSum(root, 22));
	}
}

