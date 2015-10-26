package algorithms.easy;

import TreeUtils.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).”
 */
public class _20150816_LowestCommonAncestor {

	/**
	 * Basically you go from top level to bottom, then left to right within the
	 * level
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		TreeNode largerNode = (p.val > q.val) ? p : q;
		TreeNode smallerNode = (p.val < q.val) ? p : q;

		if (root.val <= largerNode.val && root.val >= smallerNode.val) {
			return root;
		} else if (root.val > largerNode.val) {
			root = root.left;
		} else {
			root = root.right;
		}
		return lowestCommonAncestor(root, p, q);
	}

	public static void main(String[] args) {

	}

}
