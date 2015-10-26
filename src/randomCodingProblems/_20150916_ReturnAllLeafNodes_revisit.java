package randomCodingProblems;

/* Xi Huang's interview question from Dow Jones:
 * return all leaf nodes of a binary tree. */

/* Although I've implemented this program all by myself and it realized what I wanted it to, 
 * I failed to ask that 
 * 1. if this is a binary tree or a general tree, in fact, it's a general tree;
 * 2. I should declare res static outside of the function, this way, its encapsulation isn't ideal,
 * 	  I should write another function to pass this "res" into findLeaf(). */
/* No wonder that I failed to get Amazon's interview while everyone else gets it, I do need more practice
 * and training, a very frustrating day! Feb.7.2014. */
import java.util.*;

import TreeUtils.TreeNode;
public class _20150916_ReturnAllLeafNodes_revisit {
	static ArrayList<Integer> res = new ArrayList<Integer>();
	public static ArrayList<Integer> findLeaf(TreeNode root){
		if(root == null){
			return res;
		}
		if(root.left == null && root.right == null){
			res.add(root.val);
		}
		if(root.left != null){
			findLeaf(root.left);
		}
		if(root.right != null){
			findLeaf(root.right);
		}
		return res;
	}
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(6);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(3);
		root.right.right.left = new TreeNode(4);
		
		//	TreeNode root = new TreeNode(1);
		//	root.right = null;
		//	root.left = new TreeNode(2);

//					TreeNode root = new TreeNode(2);
//					root.right = null;
//					root.left = new TreeNode(3);
//					root.left.left = new TreeNode(4);
//					root.left.right = new TreeNode(1);

		//			TreeNode root = new TreeNode(1);
		//			root.left = null;
		//			root.right = new TreeNode(2);

		System.out.println(findLeaf(root));
		System.out.println("Program finished.");
	}
}
