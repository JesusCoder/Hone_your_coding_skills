package algorithms.medium;

import java.util.Stack;

import TreeUtils.TreeNode;

/**
 * I had no idea how to do this at all. So simply copied this very simple and
 * elegant solution from discuss, it's using a stack and only pushing the left
 * child into the stack, I need to spend time into understanding this.
 */
public class _20150915_BinarySearchTreeIterator {

	private Stack<TreeNode> stack = null;

	public _20150915_BinarySearchTreeIterator(TreeNode root) {
		stack = new Stack<>();

		TreeNode curr = root;
		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if (hasNext()) {
			int ret = stack.peek().val;
			TreeNode curr = stack.pop();
			if (curr.right != null) {
				curr = curr.right;

				while (curr != null) {
					stack.push(curr);
					curr = curr.left;
				}
			}
			return ret;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
