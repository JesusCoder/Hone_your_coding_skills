/**
 * 
 */
package algorithms.easy;

import TreeUtils.ListNode;

public class _20150916_ReverseLinkedList_revisit {
    /**
 * Used the solution from discuss: For linkedlist questions, keep in mind to use
 * a preHead node, this often simplifies questions!
 */
    public static ListNode reverseList_201505Version (ListNode head) {
        ListNode preHead = new ListNode(-1);
		preHead.next = head;
		/* This following while loop is the key part! Must fully understand it! */
		while (head != null && head.next != null) {
			ListNode next = head.next.next;
			head.next.next = preHead.next;
			preHead.next = head.next;
			head.next = next;
		}
		return preHead.next;
    }
    
    public static void main(String args[]){
		ListNode head = ListNode.createSinglyLinkedList();

		ListNode temp = reverseList(head);
		
		while(temp != null){
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		
		System.out.println("Program finished.");
	}

	public static ListNode reverseList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode reHead = reverseList(head.next);
		head.next.next = head;// this line of code always assigns the current node which "head" points to, to the last place
		head.next = null;// after assigning it into the last place, assign null to its next pointer to prevent circles from happening

		/* print out each step for testing */
//		ListNode temp = reHead;
//		while(temp != null){
//			System.out.print(temp.val + "->");
//			temp = temp.next;
//		}
//		System.out.println();

		return reHead;//this reHead is always the head of the new linkedlist
	}
}

