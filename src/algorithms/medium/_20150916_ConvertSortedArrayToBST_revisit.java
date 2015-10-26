package algorithms.medium;

import java.util.ArrayList;

import TreeUtils.CommonUtils;
import TreeUtils.ListNode;
import TreeUtils.TreeNode;

/** I knew this is a recursive problem and I was half way there, but I just didn't think it out all by myself
 * and I didn't think of writing a help function either, so I basically copied the algorithm from online and
 * made it accepted on Leetcode. */

/**
 * Keep this lesson in mind: the usual and very handy way to deal with the
 * situation when each time you want to call a function and it returns a new
 * result, at the same time, you want to modify the new result when you call
 * this function again, the best way is to create a help function which takes
 * this constantly changing result as a parameter!!! Make it a parameter of the
 * help function, this is the most handy way to implement this function!!! Cool!
 * This is especially useful when dealing with recursive functions!
 */

public class _20150916_ConvertSortedArrayToBST_revisit {
	public static TreeNode sortedArrayToBST(int[] num) {
		return rec(num, 0, num.length - 1);
	}

	public static TreeNode rec(int[] num, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = rec(num, low, mid - 1);
		root.right = rec(num, mid + 1, high);
		return root;
	}

	public static void inOrder(TreeNode root, ArrayList<Integer> res) {
		if (root == null) {
			return;
		}
		inOrder(root.left, res);
		res.add(root.val);
		inOrder(root.right, res);
	}

	public static void main(String args[]) {
		int[] num = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = sortedArrayToBST(num);
		ArrayList<Integer> res = new ArrayList<Integer>();
		inOrder(root, res);
		System.out.println(res);
		System.out.println("Finished.");
	}
}
