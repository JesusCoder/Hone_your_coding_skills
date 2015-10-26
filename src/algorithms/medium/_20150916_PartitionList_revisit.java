package algorithms.medium;

import TreeUtils.ListNode;

/* Finally I made this program accepted all by myself! Very encouraging! I didn't go online and look for
 * answers but all finished it by myself, single step by step debugging, after 8 hours for it! */

/* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. */

public class _20150916_PartitionList_revisit {
	public static ListNode partition(ListNode head, int x) {
		if(head == null){
			return head;
		}
		else{
			ListNode keeper, detector, detPre, keepNxt, myHead;/* initialize two pointers, "keeper" is used to
			indicate where the next node that is smaller than x should be appended while
			detector moves in the forefront to detect whether each node is smaller than x */
			detector = head;
			keeper = head;
			detPre = head;
			keepNxt = head;
			myHead = new ListNode(Integer.MAX_VALUE);
			myHead.next = head;

			if(head.val >= x){
				keeper = myHead;

				/* we use two while loops:
				 * first one to locate where the initial position of keeper should be;
				 * second one to start traversing the whole linkedlist */
				while(detector != null){
					/* first while loop*/
					if(detector.val < x){
						detPre.next = detector.next;
						keeper = detector;
						keeper.next = head;
						keepNxt = keeper.next;
						myHead = keeper;
						detector = detPre.next;
						break;
					}
					else{
						if(detector.next != null){
							detPre = detector;
							detector = detector.next;
						}
						else{
							break;
						}
					}
				}

				while(detector != null){
					/* second while loop */
					if(detector.val >= x){
						if(detector.next != null){
							detPre = detector;
							detector = detector.next;
						}
						else{
							if(Integer.MAX_VALUE == myHead.val){
								myHead = myHead.next;
							}
							else
							break;
						}
					}
					else{
						if(detector.next != null){
							detPre.next = detector.next;
							keeper.next = detector;
							keeper.next.next = keepNxt;
							detector = detPre.next;

							/* then I'll have to update the keeper pointer and keepNxt pointer*/
							keeper = keeper.next;
							keepNxt = keeper.next;
						}
						else{
							keeper.next = detector;
							keeper.next.next = keepNxt;
							detPre.next = null;
							break;
						}
					}
					System.out.println("\nIn second while loop: keeper.val = " + keeper.val + "\tkeepNxt.val = " + keepNxt.val + "\tdetector.val = " + detector.val
							+ "\tdetPre.val = " + detPre.val);
				}
				System.out.println();
				ListNode temp = myHead;
				while(temp != null){
					System.out.print(temp.val);
					temp = temp.next;
				}
				return myHead;
			}
			else{/* when the very first node is greater or equal than x */

				/* we use two while loops:
				 * first one to locate where the initial position of keeper should be;
				 * second one to start traversing the whole linkedlist */
				while(detector != null ){
					/* first while loop*/
					if(detector.val >= x){
						break;
					}
					else{
						keeper = detector;
						detector = detector.next;
					}
				}
				if(detector != null){
					detPre = keeper;
					keepNxt = keeper.next;
					while(detector != null){
						/* second while loop */
						if(detector.val >= x){
							if(detector.next != null){
								detPre = detector;
								detector = detector.next;
							}
							else{
								break;
							}
						}
						else{
							if(detector.next != null){
								detPre.next = detector.next;
								keeper.next = detector;
								keeper.next.next = keepNxt;
								detector = detPre.next;

								/* then I'll have to update the keeper pointer and keepNxt pointer*/
								keeper = keeper.next;
								keepNxt = keeper.next;
							}
							else{
								keeper.next = detector;
								keeper.next.next = keepNxt;
								detPre.next = null;
								break;
							}
						}
						System.out.println("\nIn second while loop: keeper.val = " + keeper.val + "\tkeepNxt.val = " + keepNxt.val + "\tdetector.val = " + detector.val
								+ "\tdetPre.val = " + detPre.val);
						ListNode temp = head;
						while(temp != null){
							System.out.print(temp.val);
							temp = temp.next;
						}
					}
					System.out.println();
					ListNode temp = head;
					while(temp != null){
						System.out.print(temp.val);
						temp = temp.next;
					}
					return head;
				}
				else if(detector == null){
					System.out.println("\nIn second while loop: keeper.val = " + keeper.val + "\tkeepNxt.val = " + keepNxt.val + "\tdetPre.val = " + detPre.val);
					ListNode temp = head;
					while(temp != null){
						System.out.print(temp.val);
						temp = temp.next;
					}
					return head;
				}
			}			
			ListNode temp = head;
			while(temp != null){
				System.out.print(temp.val);
				temp = temp.next;
			}
			return head;
		}
	}
	public static void main(String args[]){
		//		ListNode head = new ListNode(1);
		//		head.next = new ListNode(4);
		//		head.next.next = new ListNode(3);
		//		head.next.next.next = new ListNode(2);
		//		head.next.next.next.next = new ListNode(5);
		//		head.next.next.next.next.next = new ListNode(2);

				ListNode head = new ListNode(1);
				head.next = new ListNode(4);
				head.next.next = new ListNode(3);
				head.next.next.next = new ListNode(2);
				head.next.next.next.next = new ListNode(5);
				head.next.next.next.next.next = new ListNode(2);
				head.next.next.next.next.next.next = new ListNode(1);
				head.next.next.next.next.next.next.next = new ListNode(2);

		//				ListNode head = new ListNode(3);
		//				head.next = new ListNode(1);
		//				head.next.next = new ListNode(2);

//				ListNode head = new ListNode(1);
//				head.next = new ListNode(1);
		
//				ListNode head = new ListNode(1);
//				head.next = new ListNode(3);
//				head.next.next = new ListNode(2);

//		ListNode head = new ListNode(1);

//		ListNode head = new ListNode(2);
//		head.next = new ListNode(1);
		
//		ListNode head = new ListNode(2);
	//	head.next = new ListNode(1);
		//head.next.next = new ListNode(3);
		
//		ListNode head = new ListNode(3);
//		head.next = new ListNode(4);
//		head.next.next = new ListNode(0);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(2);
//		head.next.next.next.next.next = new ListNode(1);
//		head.next.next.next.next.next.next = new ListNode(2);
//		head.next.next.next.next.next.next.next = new ListNode(3);
//		head.next.next.next.next.next.next.next.next = new ListNode(4);
		
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println();
		partition(head, 2);
		System.out.println("\nProgram finished.");
	}
}
