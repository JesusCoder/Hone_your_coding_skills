package algorithms.easy;

import TreeUtils.ListNode;

/**
 * Used the solution from discuss: For linkedlist questions, keep in mind to use
 * a preHead node, this often simplifies questions!
 */
public class _20150814_ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode.printList(head);

		System.out.println("\nAfter reversing:");
		ListNode.printList(reverseList(head));

		System.out.println("\nThe end.");
	}

	public static ListNode reverseList(ListNode head) {
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		int counter = 0;
		/* This following while loop is the key part! Must fully understand it! */
		while (head != null && head.next != null) {
			ListNode next = head.next.next;
			System.out.println("counter: " + counter + " next.val = " + next.val);
			head.next.next = preHead.next;
//			System.out.println("counter: " + counter + " head.next.next.val = " + head.next.next.val);
			preHead.next = head.next;
//			System.out.println("counter: " + counter + " preHead.next.val = " + preHead.next.val);
			head.next = next;
//			System.out.println("counter: " + counter + " head.next.val = " + head.next.val);
			counter++;
		}
		return preHead.next;
	}
}
