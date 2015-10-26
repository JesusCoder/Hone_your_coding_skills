package algorithms.hard;

import TreeUtils.TreeNode;

/**This one is labeled as a hard problem, but I simply just copied one solution from discuss which has the most upvotes, it's indeed very elegant.
 * It's really worth of stepping thru it in debug mode.*/
public class _20150916_BinaryTreeMaximumPathSum {
	
	static int max = Integer.MIN_VALUE;
	
	public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
	
	
	private static int dfs(TreeNode root) {
		if(root == null) return 0;
		
		int left = Math.max(dfs(root.left), 0);
		int right = Math.max(dfs(root.right), 0);
		
		max = Math.max(max, root.val + left + right);
		
		return root.val + Math.max(left, right);
	}


	public static void main(String[] args) {

	}

}
