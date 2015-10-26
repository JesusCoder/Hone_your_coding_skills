/**
 * 
 */
package algorithms.medium;

import TreeUtils.ListNode;

/* Given a sorted linked list, 
 * delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. */

public class _20150918_RemoveDuplicatesFromSortedListII_revisit {
	/* In the next method, I tried to code this out all by myself, but still,
	 * I failed, so I got this program from converting a C++ program online. */
	public static ListNode deleteDuplicates_WithOnlineHelp(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}

		/* We construct a node called myHead, set it in front of the very first node, because even
		 * the first node is possible to be a duplicate and therefore needs to be deleted. */
		ListNode myHead = new ListNode(Integer.MIN_VALUE);
		myHead.next = head;
		/* Then we set two pointers, pre and now to traverse this linked list. */
		ListNode pre = myHead, now = head;
		while(now != null && now.next != null){
			if(now.val == now.next.val){
				while(now.next != null && now.val == now.next.val){
					now = now.next;
				}
				pre.next = now.next;
				now = now.next;
			}
			else{
				pre = now;
				now = now.next;
			}
		}

		/* The following statement is very important, it gets rid of the initial value we put
		 * in the myHead.val. */
		head = myHead.next;

		System.out.print("\nThe final linked list is: ");
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		return head;
	}
	
	
	/* This program is all from myself, but I didn't make it accepted on Leetcode, there're always cases
	 * that cannot pass. So I used one algorithm from online in the next program called 
	 * "removeDuplicatesFromSortedListIIWithOnlineHelp". */
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode cur = head, nxt = cur.next, myHead = head, pre = head;
		if(nxt.next == null){
			if(cur.val == nxt.val){
				return null;
			}
			else{
				return head;
			}
		}

		/* Let's first locate myHead! */
		if(cur.val != nxt.val){
			myHead = cur;
			cur = nxt;
			nxt = nxt.next;
		}
		else{
			while(nxt != null && nxt.next != null){
				if(cur.val == nxt.val){
					cur.next = nxt.next;
					nxt = nxt.next;
				}
				else{
					myHead = nxt;
					pre = myHead;
					cur = nxt.next;
					nxt = cur.next;
					break;
				}
			}
			if(nxt == null){
				ListNode temp = pre;
				while(temp != null){
					System.out.print(temp.val);
					temp = temp.next;
				}
				return pre;
			}
			if(nxt.next == null){
				if(cur.val != nxt.val){
					System.out.println(nxt.val);
					return nxt;
				}
				else{
					System.out.println("null");
					return null;
				}
			}
		}
		ListNode temp = myHead;
		System.out.print("After locating the head, the linked list is: ");
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
		}


		while(nxt != null){
			if(cur.val == nxt.val){
				nxt = nxt.next;
				cur.next = nxt;
			}
			else{
				cur = nxt;
				nxt = nxt.next;
				//pre.next = cur;
			}
		}
		if(cur.val == pre.next.val){
			pre.next = null;
		}
		else{
			cur = null;
		}
		System.out.print("\nThe final linked list is: ");
		temp = myHead;
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
		}

		return myHead;
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(1);

		ListNode node1 = new ListNode(2);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		ListNode node3 = new ListNode(3);
		node2.next = node3;

		ListNode node4 = new ListNode(3);
		node3.next = node4;

		ListNode node5 = new ListNode(3);
		node4.next = node5;

		ListNode node6 = new ListNode(3);
		node5.next = node6;

		ListNode node7 = new ListNode(4);
		node6.next = node7;

		ListNode node8 = new ListNode(5);
		node7.next = node8;

		ListNode node9 = new ListNode(5);
		node8.next = node9;

		ListNode node10 = new ListNode(6);
		node9.next = node10;

		ListNode temp = head;
		System.out.print("The input linked list is: ");
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println();
		deleteDuplicates_WithOnlineHelp(head);
		System.out.println("\nProgram finished");
	}
}
