package algorithms.medium;

/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" */

import java.util.*;
public class _20150916_GenerateParenthesis_revisit {
	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res= new ArrayList<String>();
		if(n == 0){
			return res;
		}
		String s = "(";
		rec(n, 1, 0, s, res);
		return res;
	}
	public static void rec(int n, int left, int right, String s, ArrayList<String> res){
		if(left < right){
			return;
		}
		if(left == n && n == right){
			res.add(s);
			return;
		}
		if(left == n){// "(" is full already, you can only populate in ")"
			rec(n, left, right + 1, s + ")", res);
			return;
		}
		
		rec(n, left + 1, right, s + "(", res);
		rec(n, left, right + 1, s + ")", res);
	}
	public static void main(String args[]){
		System.out.println(generateParenthesis(3));
	}
}
