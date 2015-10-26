package algorithms.medium;

import TreeUtils.ListNode;

/* I implemented this program all by myself, step by step debugging, avoiding cycles in the end,
 * then it got accepted on Leetcode the very first time I submitted it! So excited it about it,
 * now the time is 3:32 am on 2/9/2014, very excited! */

/* Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. 
You may not modify the values in the list, only nodes itself can be changed. */

public class _20150916_SwapNodeInPairs_revisit {
	public static ListNode swapPairs(ListNode head) {
		if(head == null){
			return head;
		}
		/* set four pointers */
		ListNode one, two, three, four, temp;

		temp = head;
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println();

		/* if there's only one node: */
		if(head.next == null){
			return head;
		}

		/* if there are only two nodes */
		else if(head.next != null && head.next.next == null){
			one = head;
			two = one.next;
			two.next = one;
			one.next = null;
			temp = two;
			while(temp != null){
				System.out.print(temp.val);
				temp = temp.next;
			}
			System.out.println();
			return two;
		}
		
		/* if there are only three nodes */
		else if(head.next != null && head.next.next != null && head.next.next.next == null){
			one = head;
			two = head.next;
			three = two.next;

			/* now swap one and two */
			two.next = one;
			one.next = three;
			temp = two;
			while(temp != null){
				System.out.print(temp.val);
				temp = temp.next;
			}
			System.out.println();
			return two;
		}
		
		else{/* there are more than three nodes */
			two = head;// I set the first one two, instead of one
			three = head.next;
			four = head.next.next;

			/* exchange two and three here */
			three.next = two;
			two.next = four;

			head = three;
			/* now "three" is the new head, assign it to head, so that in the end, we can directly
		return "head", also in the following code, we can use the variable "mid" as randomly as we want. */

			/* place the four pointers into the proper positions to get ready to start a new swap */
			one = head.next;
			two = one.next;
			three = two.next;
			four = three.next;

			/* now start the loop */
			while(one != null){
				/* swap the two nodes "two" and "three" */
				three.next = two;
				one.next = three;
				two.next = four;

				/* now place the four pointers into the right positions and start a new round of swap */
				one = two;
				/* if there there're at least THREE nodes behind */
				if(one.next != null && one.next.next != null && one.next.next.next != null){
					two = one.next;
					three = two.next;
					four = three.next;
				}
				/* if there are only TWO nodes behind */
				else if(one.next != null && one.next.next != null && one.next.next.next == null){
					two = one.next;
					three = two.next;

					three.next = two;
					one.next = three;
					two.next = null;
					break;
				}
				/* if there's only ONE or NO node behind */
				else if((one.next == null) || (one.next != null && one.next.next == null)){
					break;
				}
			}
			temp = head;
			while(temp != null){
				System.out.print(temp.val);
				temp = temp.next;
			}
			System.out.println();
		}
		return head;
	}
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		System.out.println("Program started.");
		swapPairs(head);
		System.out.println("Program finished.");
	}
}
