/**
 * 
 */
package algorithms.easy;

import java.util.Stack;
/* Leetcode: Given a string containing just the characters 
 * '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not. */

/* The whole idea here is to use stack! 
 * I implemented it all by myself! Hooray! */

public class _20150916_ValidParenthesis_revisit {
	public static boolean isValid(String s) {
		char [] a = s.toCharArray();
		int len = a.length;
		Stack<Character> stack = new Stack();
		for(int i = 0; i < len; i++){
			if(a[i] == '(' || a[i] == '[' || a[i] == '{'){
				stack.push(a[i]);
			}
			else{
				if(stack.isEmpty()) 
					return false;
				else if(a[i] == ')' && stack.pop() != '(')
					return false;
				else if (a[i] == ']' && stack.pop() != '[')
					return false;
				else if (a[i] == '}' && stack.pop() != '{')
					return false;
			}
		}
		if(!stack.isEmpty())
			return false;
		else
			return true;
	}
	public static void main(String args[]){
		String s = "[";
		System.out.println(isValid(s));
	}
}