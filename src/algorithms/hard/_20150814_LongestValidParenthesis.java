package algorithms.hard;

import java.util.Stack;

/**
 * Used the answer from discuss, what this following line of code does is: After
 * pop(), the stack can be empty, which means that s.substring(0,i+1) is valid
 * so we need i-(-1); if not empty, s.substring(st.peek(),i+1) will be valid.
 * max = Math.max(max, i - ((stack.isEmpty())? - 1:stack.peek())); This one uses
 * “stack” approach, the other alternative is to use DP, but I din’t dive deeper
 * into that one.
 */

public class _20150814_LongestValidParenthesis {

	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(longestValidParentheses(s) + "\nThe end.");
	}

	public static int longestValidParentheses(String s) {
		int len = s.length(), max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
				stack.pop();
				// System.out.println("max is: " + max +
				// "\n((stack.isEmpty()) is:" + stack.isEmpty() +
				// "\n((stack.isEmpty())? - 1:stack.peek()) is: "
				// + ((stack.isEmpty()) ? -1 : stack.peek()));
				max = Math.max(max, i - ((stack.isEmpty()) ? -1 : stack.peek()));
				System.out.println("max is: " + max);
			} else {
				stack.push(i);
			}
		}
		return max;
	}
}
