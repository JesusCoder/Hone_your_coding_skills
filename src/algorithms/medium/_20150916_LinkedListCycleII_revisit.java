package algorithms.medium;

import TreeUtils.ListNode;

/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space? */

/* The algorithm was thought by Chris, Siyuan and others, I simply implemented it:
 * 
 * Set two pointers, fast and slow, fast runs twice as fast as slow,
 * if the two pointers never meet, then there's no cycle here, return null;
 * if the two pointers meet, then set the fast pointer back to head,
 * then start the two pointers again with equal speed, when the two pointers
 * meet again, that's the place where the cycle starts.
 * 
 * It looks very abstract to understand, but when you draw a picure, it becomes very easy
 * to comprehend. */

public class _20150916_LinkedListCycleII_revisit{
	public static ListNode detectCycle(ListNode head) {
		ListNode slow, fast;
		slow = head;
		fast = head;
		if(head == null){
			return null;
		}
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
		}
		if(fast == null || fast.next == null){
			System.out.println("null");
			return null;
		}
		else{
			fast = head;
			if(slow == head){
				System.out.println(head.val);
				return head;
			}
			while(fast != slow){
				fast = fast.next.next;
				slow = slow.next;
			}
			System.out.println(fast.next.val);
			return fast.next;	
		}
	}
	public static void main(String args[]){
// test case I:
		//		ListNode head = new ListNode(1);
		//		head.next = head;

		//test case II:
//		ListNode head = new ListNode(3);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(0);
//		head.next.next.next = new ListNode(-4);
//		head.next.next.next.next = head.next;
		
		//test case III:
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = head;
	
		//test case IV:
//		ListNode head = new ListNode(1);
//		head.next = head;
		
		//test case V:
		ListNode head = new ListNode(-1);
		head.next = new ListNode(-7);
		head.next.next = new ListNode(7);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = new ListNode(19);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(-9);
		head.next.next.next.next.next.next.next = new ListNode(-5);
		head.next.next.next.next.next.next.next.next = new ListNode(-2);
		head.next.next.next.next.next.next.next.next.next = new ListNode(-5);
		head.next.next.next.next.next.next.next.next.next.next = head.next.next.next.next.next.next;
		detectCycle(head);
	}
}
