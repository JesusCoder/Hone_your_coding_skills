package backlog;

public class TreeNodeClass {
	int val;
	public TreeNodeClass left;
	public TreeNodeClass right;

	public TreeNodeClass(int x) {
		val = x;
	}

	public static TreeNodeClass initARandomBinaryTree() {
		TreeNodeClass root = new TreeNodeClass(0);
		root.left = new TreeNodeClass(1);
		root.right = new TreeNodeClass(2);
		root.left.left = new TreeNodeClass(3);
		root.left.right = new TreeNodeClass(4);
		root.left.left.left = null;
		root.left.left.right = null;
		root.left.right.left = null;
		root.left.right.right = null;
		root.right.left = new TreeNodeClass(5);
		root.right.right = new TreeNodeClass(6);
		root.right.right.left = null;
		root.right.right.right = null;
		root.right.left.right = null;
		root.right.left.left = null;
		return root;
	}

	public static void printTree(TreeNodeClass root) {
		// TODO: figure out an elegant way to print out the tree in a more
		// visualized manner
	}

}