/**
 * 
 */
package algorithms.medium;

import TreeUtils.ListNode;

/* I came up with this wonderful algorithm to traverse only once all by myself, and it got accepted at the
 * very first time that I submitted it, very excited! 
 * 
 * My idea: use two pointers, "fast" to reach the end, "slow" to indicate the node that
 * is N nodes behind "fast", when "fast" reaches the end, then "slow" means the one that should
 * be removed. */

/* Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass. */
public class _20150918_RemoveNthNodeFromEndOfList_revisit {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null){
			return head;
		}
		ListNode slow, fast, slowPre, slowNxt;
		fast = head;
		slow = head;
		int counter = 1;
		while(counter <= n && fast.next != null){
			fast = fast.next;
			counter++;
		}
		if(fast.next == null){
			if(counter < n){
				return head;
			}
			else if(counter == n){// this means the Nth node from end is the VERY first node in this LinkedList.
				head = head.next;
				ListNode temp = head;
				while(temp != null){
					System.out.print("temp.val = " + temp.val + "\n");
					temp = temp.next;
				}
				return head;
			}
		}
		if(counter == n){
			slow = head;
		}
		slowPre = slow;
		slow = slow.next;
		slowNxt = slow.next;
		
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
			slowPre = slowPre.next;
			slowNxt = slowNxt.next;
		}
		
		slowPre.next = slowNxt;
		
		ListNode temp = head;
		while(temp != null){
			System.out.print("temp.val = " + temp.val + "\n");
			temp = temp.next;
		}
		return head;
	}
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		removeNthFromEnd(head,5);
		System.out.println("\nProgram finished.");
	}
}
