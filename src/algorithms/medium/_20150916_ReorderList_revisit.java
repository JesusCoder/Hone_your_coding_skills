package algorithms.medium;

import TreeUtils.CommonUtils;
import TreeUtils.ListNode;

/**Leetcode problem:
 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.*/

/**
 * Copied answer online here:
 * http://blog.csdn.net/whuwangyi/article/details/14146461
 */

public class _20150916_ReorderList_revisit {
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		/* first we use two pointers to separate this list into two parts */
		ListNode slowNode = head, fastNode = head;
		while (fastNode.next != null) {
			fastNode = fastNode.next;
			if (fastNode.next != null) {
				fastNode = fastNode.next;
			} else {
				break;
			}
			slowNode = slowNode.next;
		}
		// two sublist heads
		ListNode head1 = head, head2 = slowNode.next;
		// detach the two sublists;
		slowNode.next = null;

		// reverse the second sublist
		ListNode cur = head2, post = cur.next;
		cur.next = null;
		while (post != null) {
			ListNode temp = post.next;
			post.next = cur;
			cur = post;
			post = temp;
		}
		head2 = cur;// the new head of the reversed sublist

		// merge the two sublists as required
		ListNode p = head1, q = head2;
		while (q != null) {
			ListNode temp1 = p.next;
			ListNode temp2 = q.next;
			p.next = q;
			q.next = temp1;
			p = temp1;
			q = temp2;
		}
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(0);
		ListNode node1 = new ListNode(1);
		head.next = node1;
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		ListNode node6 = new ListNode(6);
		node5.next = node6;
		
		ListNode temp = head;
		CommonUtils.printList(temp);
		
		reorderList(head);
		CommonUtils.printList(head);
		
		System.out.print("\nProgram ended.");
	}
}
