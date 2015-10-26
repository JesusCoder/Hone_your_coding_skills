package algorithms.medium;

import TreeUtils.TreeNode;
/**Just a copy here, details see _20151016_BinarySearchTreeValidity in Exodus package.*/
public class _20151016_ValidateBST {

	private boolean isValid(TreeNode root){
		return dfs(root, null, null);
	}

	/**This is the solution I used from leetcode.*/
	private boolean dfs(TreeNode root, Integer min, Integer max) {
		printRoot(root);
		printMin(min);
		printMax(max);
		System.out.println();
		if (root == null) {
			return true;
		} else if ((min != null && root.val <= min)
				|| (max != null && root.val >= max)) {
			return false;
		} else {
			return dfs(root.left, min, root.val)
					&& dfs(root.right, root.val, max);
		}
	}

	private void printMin(Integer min) {
		if(null != min){
			System.out.println("min is " + min);
		} else {
			System.out.println("min is null!");
		}
	}
	
	private void printMax(Integer max) {
		if(null != max){
			System.out.println("max is " + max);
		} else {
			System.out.println("max is null!");
		}
	}

	private void printRoot(TreeNode root) {
		if(null != root){
			System.out.println("root is " + root.val);
		} else {
			System.out.println("root is null!");
		}
	}
	
	public static void main(String[] args) {

	}

}
