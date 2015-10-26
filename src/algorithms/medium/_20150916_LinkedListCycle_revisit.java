package algorithms.medium;

import TreeUtils.ListNode;

/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? */
public class _20150916_LinkedListCycle_revisit {
	public static boolean hasCycle(ListNode head) {
		ListNode slow, fast;
		slow = head;
		fast = head;
		if(head == null){
			return true;
		}
		while(fast != null && fast.next != null){
			/* Here the terminating conditions must be this way, because it always the fast
			 * pointer runs to the end first if there's no cycle. */
			
			fast = fast.next.next;
			slow = slow.next;
			/* We need to let the two pointers run first, and then we can test if
			 * the two pointers are equal are not, instead of the other way around. */
			
			if(fast == slow){
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		head.next = head;
		/* in this way, the test case is:
		 * there's only one node: head;
		 * but it has a cycle: it connects to itself.
		 * 
		 * If we don't have the statement:
		 * head.next = head;
		 * Then this test case is that it has no cycle! 
		 * 
		 * These are two completely different test cases. */
		System.out.println(hasCycle(head));
	}
}

