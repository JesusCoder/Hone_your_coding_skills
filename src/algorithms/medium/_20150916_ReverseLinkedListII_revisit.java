/**
 * 
 */
package algorithms.medium;

import TreeUtils.ListNode;

/** I ran out of patience for this problem, so I simply copied this algrithm from online word by word without
 * changing a single letter, I'll have to come back and revisit and truly understand this problem! */
public class _20150916_ReverseLinkedListII_revisit {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode preBegin = dummy;
		int cnt = 1;
		while (preBegin != null && cnt < m) {
			preBegin = preBegin.next;
			cnt++;
		}

		ListNode reverseEnd = preBegin.next;
		ListNode reHead = null;
		ListNode cur = preBegin.next;
		cnt = 1;
		ListNode postEnd = null;
		while (cur != null && cnt <= n - m + 1) {
			ListNode preCur = cur;
			cur = cur.next;
			if (cnt == n - m + 1) {
				postEnd = preCur.next;
			}
			preCur.next = reHead;
			reHead = preCur;
			cnt++;
		}
		preBegin.next = reHead;
		if (reverseEnd != null) {
			reverseEnd.next = postEnd;
		}
		return dummy.next;
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(1);

		ListNode node1 = new ListNode(2);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		ListNode node3 = new ListNode(4);
		node2.next = node3;

		ListNode node4 = new ListNode(5);
		node3.next = node4;

		ListNode node5 = new ListNode(6);
		node4.next = node5;

		ListNode node6 = new ListNode(7);
		node5.next = node6;

		ListNode node7 = new ListNode(8);
		node6.next = node7;

		ListNode node8 = new ListNode(9);
		node7.next = node8;

		ListNode node9 = new ListNode(10);
		node8.next = node9;

		/* print out to verify */
		ListNode temp = reverseBetween(head, 3, 8);
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("Program finished.");
	}
	
	/** I recalled the recursive algorithm for a previous program and was trying to solve this problem.
	 * But it didn't work out, it can run for most general cases, but it always fails the extreme cases, such
	 * as 1->NULL, or 1->2->NULL. */
	public static ListNode reverseBetween_myOwnTrial(ListNode head, int m, int n) {
		ListNode mpointer = head, mpointerPre = head, npointer = head, cursor = head;
		int mcounter = 1, ncounter = 1;
		if (m == n) {
			return head;
		}
		while (cursor != null) {
			if (m == mcounter + 1) {
				mpointerPre = cursor;
				mpointer = cursor.next;
				System.out.println("mpointerPre.val = " + mpointerPre.val);
				System.out.println("mpointer.val = " + mpointer.val);
			}
			if (n == ncounter) {
				npointer = cursor;
				System.out.println("npointer.val = " + npointer.val);
				break;
			}
			mcounter++;
			ncounter++;
			cursor = cursor.next;
		}

		mpointerPre.next = null;/* cut the head part off from the rest of it */
		ListNode tempHead = head;/* then assign this cut-off head to tempHead */

		System.out.println("\nBegin:");
		ListNode temp3 = tempHead;
		while (temp3 != null) {
			System.out.print(temp3.val + "->");
			temp3 = temp3.next;
		}
		System.out.println("\nEnd.");

		ListNode temp1 = mpointer;/*
								 * now mpointer is the head, and we assign it to
								 * a temp
								 */

		ListNode tempTail = npointer.next;// store the tail part temporarily
		npointer.next = null;/*
							 * now we temporarily assign null to the next
							 * pointer of npointer, after reversing the required
							 * part, we attach the tail part to the reversed
							 * list
							 */

		ListNode newHead = rec(temp1);

		/* after reversing from mpointer to npointer, do the following */
		ListNode temp4 = tempHead;/* find the last node of tempHead */
		while (temp4.next != null) {
			temp4 = temp4.next;
		}
		temp4.next = newHead;/*
							 * this "newHead" is the head of the reversed list,
							 * so we attach it to the end of tempHead
							 */

		ListNode temp2 = newHead;/* find the last node of the reversed list */
		while (temp2.next != null) {
			temp2 = temp2.next;
		}
		temp2.next = tempTail;/* then attach the tail part to the last node */

		return head;
	}
	public static ListNode rec(ListNode start){
		if(start == null || start.next == null){
			return start;
		}
		ListNode newHead = rec(start.next);
		start.next.next = start;
		start.next = null;
		return newHead;
		
	}
}


