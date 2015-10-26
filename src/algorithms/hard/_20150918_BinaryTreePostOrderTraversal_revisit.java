package algorithms.hard;

/* Very excited, get this program accepted on Leetcode the first time I submitted, I did this all
 * by myself, after doing inorderTraversal and preorderTraversal, then this one is really trivial. */


/* Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively? */
import java.util.*;

import TreeUtils.TreeNode;
public class _20150918_BinaryTreePostOrderTraversal_revisit {
	static ArrayList<Integer> res = new ArrayList();
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
        	return res;
        }
        else{
        	postorderTraversal(root.left);
        	postorderTraversal(root.right);
        	res.add(root.val);
        }
		return res;
    }
public static void main(String args[]){
	TreeNode root = new TreeNode(1);
			root.left = null;
			root.right = new TreeNode(2);
			root.right.right = null;
			root.right.left = new TreeNode(3);

		//	TreeNode root = new TreeNode(1);
		//	root.right = null;
		//	root.left = new TreeNode(2);

//		TreeNode root = new TreeNode(2);
//		root.right = null;
//		root.left = new TreeNode(3);
//		root.left.left = null;
//		root.left.right = new TreeNode(1);
		
//		TreeNode root = new TreeNode(1);
//		root.left = null;
//		root.right = new TreeNode(2);

		System.out.println(postorderTraversal(root));
		System.out.println("Program finished.");
}
}
