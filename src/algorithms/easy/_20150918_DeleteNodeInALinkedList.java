package algorithms.easy;

import TreeUtils.ListNode;

public class _20150918_DeleteNodeInALinkedList {
	/**
	 * Although this is labeled as an EASY problem, I didn't come up with my own
	 * solution, simply copied it from online. After setting a breakpoint and
	 * step thru it, I understand it, it's a pretty clever and smart design to
	 * use recursion to achieve the purpose of this problem.
	 */
	public void deleteNode(ListNode node) {
		if(node.next == null){
			return;
		}
		node.val = node.next.val;
		if(node.next.next == null){
			node.next = null;
			return;
		}
		deleteNode(node.next);
		return;
	}
	
	public static void main(String[] args) {
		_20150918_DeleteNodeInALinkedList test = new _20150918_DeleteNodeInALinkedList();
		ListNode head = ListNode.createSinglyLinkedList();
		ListNode.printList(head);
		
		ListNode delete = head.next.next.next.next;
		
		test.deleteNode(delete);
		
		System.out.println();
		
		ListNode.printList(head);
	}

}
