package algorithms.medium;

/* Luckily, after trial and error, I finished this program all by myself! Very excited! Had a better understanding
 * of recursion! */

/* Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ. */

import java.util.*;

import TreeUtils.TreeNode;
public class _20150917_BinaryTreeInorderTraversal_revisit {
	static ArrayList<Integer> res = new ArrayList();
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
		
		if(root == null){
			return res;
		}
		else{
			inorderTraversal(root.left);
			res.add(root.val);
			System.out.println(res);
			inorderTraversal(root.right);	
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

		System.out.println(inorderTraversal(root));
		System.out.println("Program finished.");
	}
}

