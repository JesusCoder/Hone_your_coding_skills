package algorithms.medium;

import TreeUtils.ListNode;

/**
 * Leetcode problem: You are given two linked lists representing two
 * non-negative numbers. The digits are stored in reverse order and each of
 * their nodes contain a single digit. Add the two numbers and return it as a
 * linked list. Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * I didn't figure this out by myself, although my very original code passed
 * 1548 test cases out of 1555, I simply fell into a deadlock of my code, once I
 * fixed this bug, that test case didn't pass again. So I simply copied code
 * from online which was very concise!!! From
 * here:http://gongxuns.blogspot.com/2012/12/leetcodeadd-two-numbers.html Good
 * explanations are here:http://www.programcreek.com/2012/12/add-two-numbers/
 */

public class _20150916_AddTwoNumbers_revisit {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode res = new ListNode(0);
		ListNode cur1 = l1, cur2 = l2, head = res;
		while (cur1 != null || cur2 != null) {
			if (cur1 != null) {
				carry += cur1.val;
				cur1 = cur1.next;
			}
			if (cur2 != null) {
				carry += cur2.val;
				cur2 = cur2.next;
			}
			head.next = new ListNode(carry % 10);
			head = head.next;
			carry = carry / 10;
		}
		if (carry == 1) {
			head.next = new ListNode(1);
		}
		return res.next;
	}

	public static void printList(ListNode head) {
		System.out.println("--------------------------------------------");
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		ListNode list1 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		list1.next = node1;
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		
		ListNode temp1 = list1;
		printList(temp1);
		printList(temp1);
		
		printList(addTwoNumbers(list1, list1));
		System.out.println("Program ended.");
	}

}
