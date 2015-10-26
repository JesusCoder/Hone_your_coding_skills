package algorithms.hard;

/* Leetcode: 
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */

public class _20150916_RegularExpressionMatching_revisit {

	/**
	 * no idea. Used the answer from discuss. Used a recursive approach. Very
	 * smart way of designing this algorithm. This answer basically considers
	 * ways of how to handle all possible cases.
	 */
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.isEmpty()
					|| (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}
		// p.length() >= 2
		while (!s.isEmpty()
				&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			s = s.substring(1);
		}
		return isMatch(s, p.substring(2));
	}

	public static void main(String args[]) {
		_20150916_RegularExpressionMatching_revisit test = new _20150916_RegularExpressionMatching_revisit();
		System.out.println(test.isMatch("aa", "a*"));
	}
}
