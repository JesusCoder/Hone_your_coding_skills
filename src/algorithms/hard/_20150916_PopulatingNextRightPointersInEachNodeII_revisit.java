package algorithms.hard;

/* Praise the Lord, I finally implemented this program and made it accepted on LeetCode, 
 * all by myself, including coming up with this
 * algorithm, it's completely original from myself! Very excited! I even dreamed about it last night!
 * Thank Jesus! I love this torturing feeling and process! 
 * 
 * 1:20 pm 2/15/2014*/


/* I got stuck in the test case 38/61, because I don't know somehow Eclipse skips all the breakpoints
 * and I don't know how to set it back, very frustrating! I'll go back and fix the bug and hopefully it will
 * be good soon. 
 * 
 * 2:15 am 2/15/2014*/

/* Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL */


import java.util.LinkedList;
import java.util.Queue;

import TreeUtils.TreeLinkNode;

public class _20150916_PopulatingNextRightPointersInEachNodeII_revisit {
	public static void connect(TreeLinkNode root) {
		if (root != null) {
			Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
			root.next = null;
			q.add(root);
			int newcnt = 0, oldcnt = 1;

			TreeLinkNode danglingNode = new TreeLinkNode(Integer.MAX_VALUE);

			while (!q.isEmpty() || root.left != null || root.right != null) {
				oldcnt = newcnt;
				newcnt = 0;

				for (int i = 0; i < oldcnt && root != null; i++) {
					/*
					 * since this is not a perfect binary tree, we'll need to
					 * check both left and right nodes to see if they exist or
					 * not
					 */
					if (root.left != null) {
						if ((i != 0) && (danglingNode.val != Integer.MAX_VALUE)) {
							danglingNode.next = root.left;
						}
						q.add(root.left);
						newcnt++;
						if (root.right != null) {
							q.add(root.right);
							newcnt++;
							root.left.next = root.right;
							danglingNode = root.right;
						} else {
							danglingNode = root.left;
						}
					} else {
						if (root.right != null) {
							newcnt++;
							q.add(root.right);
							if ((i != 0)
									&& (danglingNode.val != Integer.MAX_VALUE)) {
								danglingNode.next = root.right;
								danglingNode = root.right;
							} else {
								danglingNode = root.right;
							}
						}
					}
					if (danglingNode.next == null) {
						danglingNode.next = null;
					}
					root = q.poll();
				}
				danglingNode = new TreeLinkNode(Integer.MAX_VALUE);
				if (root == null) {
					break;
				}

				/*
				 * the following code fragment is to deal with root only, all
				 * other nodes won't execute it
				 */
				if (oldcnt == 0) {
					if (root.left != null) {
						q.add(root.left);
						newcnt++;
						if (root.right != null) {
							q.add(root.right);
							newcnt++;
							root.left.next = root.right;
							root.right.next = null;
						} else {
							root.left.next = null;
						}
					} else {
						if (root.right != null) {
							q.add(root.right);
							root.right.next = null;
							newcnt++;
						}
					}
					root.next = null;
					q.remove();
					root = q.poll();
					if (root == null) {
						break;
					}
				}
			}
		}
	}

	public static void main(String args[]) {
		// test case 1:
		// TreeLinkNode root = new TreeLinkNode(1);
		// root.left = new TreeLinkNode(2);
		// root.right = new TreeLinkNode(3);
		// root.left.left = new TreeLinkNode(4);
		// root.left.right = new TreeLinkNode(5);
		// // root.right.left = new TreeLinkNode(6);
		// root.right.right = new TreeLinkNode(7);
		// // root.left.left.left = new TreeLinkNode(8);
		// // root.left.left.right = new TreeLinkNode(9);
		// // root.left.right.left = new TreeLinkNode(10);
		// // root.left.right.right = new TreeLinkNode(11);
		// // root.right.left.left = new TreeLinkNode(12);
		// // root.right.left.right = new TreeLinkNode(13);
		// // root.right.right.left = new TreeLinkNode(14);
		// // root.right.right.right = new TreeLinkNode(15);

		// test case 2:
		// TreeLinkNode root = new TreeLinkNode(0);
		// root.left = new TreeLinkNode(2);
		// root.right = new TreeLinkNode(4);
		// root.left.left = new TreeLinkNode(1);
		// root.right.left = new TreeLinkNode(3);
		// root.right.right = new TreeLinkNode(-1);

		// //test case 3:
		// TreeLinkNode root = new TreeLinkNode(0);
		// root.left = new TreeLinkNode(2);
		// root.right = new TreeLinkNode(4);
		// root.left.left = new TreeLinkNode(1);
		// root.right.left = new TreeLinkNode(3);
		// root.right.right = new TreeLinkNode(-1);
		// root.left.left.left = new TreeLinkNode(5);
		// root.left.left.right = new TreeLinkNode(1);
		// root.right.left.right = new TreeLinkNode(6);
		// root.right.right.right = new TreeLinkNode(8);

		// test case 4:
		// TreeLinkNode root = new TreeLinkNode(7);
		// root.left = new TreeLinkNode(-10);
		// root.right = new TreeLinkNode(2);
		// root.left.left = new TreeLinkNode(-4);
		// root.left.right = new TreeLinkNode(3);
		// root.left.right.right = new TreeLinkNode(-1);
		// root.right.left = new TreeLinkNode(-8);
		// root.right.left.left = new TreeLinkNode(11);

		// //test case 5:
		// TreeLinkNode root = new TreeLinkNode(4);
		// root.left = new TreeLinkNode(-4);
		// root.right = new TreeLinkNode(8);
		// root.left.left = new TreeLinkNode(1);
		// root.left.left.left = new TreeLinkNode(-4);
		// root.left.left.right = new TreeLinkNode(-9);
		// root.left.left.right.left = new TreeLinkNode(8);
		// root.left.left.right.right = new TreeLinkNode(-9);
		// root.left.left.right.left.left = new TreeLinkNode(7);
		// root.left.left.right.left.right = new TreeLinkNode(-9);
		// root.left.left.right.right.left = new TreeLinkNode(-6);
		// root.left.left.right.right.right = new TreeLinkNode(6);
		// root.left.left.right.right.right.left = new TreeLinkNode(-7);
		// root.left.left.right.right.right.left.right = new TreeLinkNode(-1);

		// test case 6:
		// TreeLinkNode root = new TreeLinkNode(0);

		// test case 6:
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		connect(root);
		System.out.println("Program finished.");
	}
}

