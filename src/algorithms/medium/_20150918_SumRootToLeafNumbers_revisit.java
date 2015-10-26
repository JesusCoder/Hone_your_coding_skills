/**
 * 
 */
package algorithms.medium;

import TreeUtils.TreeNode;

/* Given a binary tree containing digits from 0-9 only, 
* each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

1
/ \
2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25. */

public class _20150918_SumRootToLeafNumbers_revisit {
public static int sumNumbers(TreeNode root) {
	 int res = 0;
	return res = recurs(root, 0);
}
public static int recurs(TreeNode root, int n){
	if(root == null){
		return 0;
	}
	n = n*10 + root.val;
	System.out.println("n = " + n);
	if(root.left == null && root.right == null){
		return n;
	}
	return recurs(root.left, n) + recurs(root.right, n);
}
public static void main(String args[]){
//	TreeNode root = new TreeNode(1);
//	root.left = null;
//	root.right = new TreeNode(2);
//	root.right.right = null;
//	root.right.left = new TreeNode(3);

	//	TreeNode root = new TreeNode(1);
	//	root.right = null;
	//	root.left = new TreeNode(2);

				TreeNode root = new TreeNode(2);
				root.right = null;
				root.left = new TreeNode(3);
				root.left.left = new TreeNode(4);
				root.left.right = new TreeNode(1);

	//			TreeNode root = new TreeNode(1);
	//			root.left = null;
	//			root.right = new TreeNode(2);

	System.out.println(sumNumbers(root));
	System.out.println("Program finished.");
}
}
