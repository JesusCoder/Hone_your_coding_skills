package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

import TreeUtils.Notes;
import TreeUtils.TreeNode;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 * 1 / \ 2 3 \ 5 All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 */
public class _20150817_BinaryTreePaths {

	@Notes(needsReview = true, context = "My idea: simply do a DFS and store each path into this result list. Then I went online and found people did use dfs, but I forgot dfs again, so copied this dfs solution here.")
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> allPaths = new ArrayList<String>();

		if (root == null) {
			return allPaths;
		}
		dfs(root, new StringBuilder(), allPaths);

		return allPaths;
	}

	private static void dfs(TreeNode root, StringBuilder stringBuilder,
			List<String> allPaths) {
		if (root.left == null && root.right == null) {
			stringBuilder.append(root.val);
			allPaths.add(stringBuilder.toString());
			return;
		}

		stringBuilder.append(root.val);
		stringBuilder.append("->");

		if (root.left != null) {
			dfs(root.left, new StringBuilder(stringBuilder), allPaths);
		}

		if (root.right != null) {
			dfs(root.right, new StringBuilder(stringBuilder), allPaths);
		}
	}

	public static void main(String[] args) {

	}

}
