package algorithms.medium;

import TreeUtils.ListNode;
import TreeUtils.TreeNode;

/**
 * I copied the code from online.
 * 
 * The major idea is similar to "Convert sorted array into BST", the only
 * difference is that this is a sorted linked list. I thought of using fast and
 * slow pointers, but just cannot figure out the implementation details.
 */

/**This is a very good and classic recursive solution, I need to spend time and really fully understand why it's written this way!*/

public class _20150916_ConvertSortedListToBST_revisit {
	public static TreeNode sortedListToBST(ListNode head) {
		TreeNode res = rec(head, null);
		return res;
	}

	public static TreeNode rec(ListNode start, ListNode end) {
		if (start == end) {
			return null;
		} else {
			ListNode mid = start;
			ListNode probe = start;
			while (probe != end && probe.next != end) {
				mid = mid.next;
				probe = probe.next.next;
			}

			TreeNode root = new TreeNode(mid.val);
			root.left = rec(start, mid);
			root.right = rec(mid.next, end);
			return root;
		}
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		sortedListToBST(head);
		System.out.println("ended.");
	}
}
