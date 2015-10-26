/**
 * 
 */
package algorithms.easy;

import TreeUtils.TreeNode;

/*  Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3 */

/* I didn't solve this problem all by myself, got hints from online. */

/* I cannot initialize the tree, it always executes the statement after if(root == null) which
 * means my tree was not initialized as supposed to. Can someone help me please? */
public class _20150916_SymmetricTree_revisit {
	public static boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		else{
			return isSymmetricX(root.left, root.right);
		}
	}
	/* Because it's head to write recursive code to judge if a tree is symmetric or not,
	 * so we separate one tree into two subtrees and see if the two subtrees are symmetric
	 * to each other. */
	
	public static boolean isSymmetricX(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null){
			return true;
		}
		else if(t1 != null && t2 == null || t1 == null && t2 != null){
			return false;
		}
		else if(t1.val != t2.val){
			return false;
		}
		else{
			return isSymmetricX(t1.left, t2.right) && isSymmetricX(t1.right, t2.left);
		}
	}
	
	public static void main(String args[]){

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root));
	}
}

