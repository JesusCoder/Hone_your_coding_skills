package algorithms.medium;

/** Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL */
import java.util.*;

import TreeUtils.TreeLinkNode;

public class _20150916_PopulatingNextRightPointersInEachNode_revisit {
	/**
	 * I implemented this program all by myself, inspired by the a previous
	 * program algorithm method, but anyway I did this one by myself and made it
	 * accepted on Leetcode the very first time I submitted, very excited!
	 */
	public static void connect(TreeLinkNode root) {
		if (root != null) {
			Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
			root.next = null;
			q.add(root);
			int newcnt = 0, oldcnt = 1;

			while (!q.isEmpty()) {
				oldcnt = newcnt;
				newcnt = 0;
				if (root.left != null) {
					/**
					 * since this is a perfect binary tree, so if there's one
					 * node on each level then, this level must of full of
					 * nodes, so we don't need to check its right node
					 */
					for (int i = 0; i < oldcnt - 1; i++) {
						q.add(root.left);
						q.add(root.right);
						root.left.next = root.right;
						root.right.next = q.peek().left;
						newcnt += 2;
						root = q.poll();
					}
					q.add(root.left);
					q.add(root.right);
					root.left.next = root.right;
					root.right.next = null;
					/**
					 * only this line is different, so we'll have to do it
					 * outside of the for loop
					 */
					newcnt += 2;
					if (oldcnt == 0) {
						q.remove();
					}
					root = q.poll();
				} else
					break;
			}
		}
	}

	public static void main(String args[]) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		root.left.left.left = new TreeLinkNode(8);
		root.left.left.right = new TreeLinkNode(9);
		root.left.right.left = new TreeLinkNode(10);
		root.left.right.right = new TreeLinkNode(11);
		root.right.left.left = new TreeLinkNode(12);
		root.right.left.right = new TreeLinkNode(13);
		root.right.right.left = new TreeLinkNode(14);
		root.right.right.right = new TreeLinkNode(15);
		connect(root);
		System.out.println("Program finished.");
	}
}
