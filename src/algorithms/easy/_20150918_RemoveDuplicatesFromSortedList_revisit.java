/**
 * 
 */
package algorithms.easy;

import TreeUtils.ListNode;

/* Given a sorted linked list, delete all duplicates 
 * such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. */

/* My code didn't work out, although 50% of them is correct, then I copied Chris Huang's
 * code, and it got accepted!
 * 
 * Now I have a better understanding of LinkedList node:
 * I originally wrote
 * ListNode cur = new ListNode(head.val);
 * but this is wrong, this means I created a new node of type ListNode called cur,
 * and its val, (only its val) is equal to head.val, but cur and head are two different things,
 * however, Chris wrote like this:
 * ListNode cur;
 * cur = head;
 * this is totally different from mine, in his first statement, he simply declares a variable called
 * cur of type ListNode, and in his second statement, he assigns the entire head to cur, he's using
 * the original ListNode (and the original whole linkedlist), but my code was not. 
 * 
 * Keep this lesson in mind! */

public class _20150918_RemoveDuplicatesFromSortedList_revisit {
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null){
			return head;
		}
		/* set two pointers to implement this function */
		ListNode cur = head, nxt = cur.next;
		while(nxt != null){
			if(cur.val == nxt.val){
				cur.next = nxt.next;
				nxt = nxt.next;
			}
			else{
				cur = nxt;
				nxt = nxt.next;
			}
		}
		
		ListNode temp1 = head;
		System.out.println();
		while(temp1 != null){
			System.out.print(temp1.val);
			temp1 = temp1.next;
		}
		return head;
	}
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		
		ListNode node1 = new ListNode(1);
		head.next = node1;
		
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		
		ListNode node4 = new ListNode(3);
		node3.next = node4;
		
		ListNode node5 = new ListNode(4);
		node4.next = node5;
		
		ListNode node6 = new ListNode(5);
		node5.next = node6;
		
		ListNode node7 = new ListNode(5);
		node6.next = node7;
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
		}
		deleteDuplicates(head);
		System.out.println("\nFinished program.");
	}
}
