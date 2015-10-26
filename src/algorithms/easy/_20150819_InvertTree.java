package algorithms.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import TreeUtils.CommonUtils;
import TreeUtils.TreeNode;
import TreeUtils.TreeUtils;

public class _20150819_InvertTree {

	/**Copied solution online: https://leetcode.com/discuss/51933/clean-code-in-java-using-stack-not-recursive*/
	public static TreeNode invertTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null){
			return null;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = (TreeNode) stack.pop();
			if(node.left == null && node.right == null){
				continue;
			}
			TreeNode temp = node.right;
			node.right = node.left;
			node.left = temp;
			if(node.left != null){
				stack.push(node.left);
			}
			if(node.right != null){
				stack.push(node.right);
			}
		}
		return root;
	}
	
	//copied solution: https://leetcode.com/discuss/45751/0ms-simple-recursive-solution-with-explaination
	public static TreeNode invertTreeSimpleRecursion(TreeNode root) {
		if(root == null){
			return null;
		}
		TreeNode tmp = invertTreeSimpleRecursion(root.left);
		root.left = invertTreeSimpleRecursion(root.right);
		root.right = tmp;
		return root;
	}
	
	public static void main(String[] args) {
		List<Integer> treeValues = new ArrayList<Integer>();

		treeValues = CommonUtils.randomIntArrayGenerator(21, 21);

		TreeNode root2 = TreeUtils.constructBinaryTree(treeValues);
		TreeUtils.printBinaryTree(root2);
		
//		invertTree(root2);
		invertTreeSimpleRecursion(root2);
		
		CommonUtils.println("After inverting the tree:");
		TreeUtils.printBinaryTree(root2);
	}

}
