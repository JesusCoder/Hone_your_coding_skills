/**
 * 
 */
package algorithms.easy;

/* Leetcode: 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example, 
 Given s = "Hello World",
 return 5.*/

/* Algorithm: start from the end of the string, begin counting when it meets the first
 * alphabet, when it meets the first non-alphabet stuff, it exits and return the counter. 
 * 
 * Here, the tricky part is how to jump out of the loop when it has started counting and
 * encountered the first non-alphabet stuff, I Googled it and found people use 
 * two while loops
 * , this is a very handy algorithm! 
 * 
 * Also, you need to pay attention to the array boundary problem, it took me quite a while
 * to make it accepted on Leetcode. */

public class _20150916_LengthOfLastWord_revisit {
	public static int lengthOfLastWord(String s) {
		char[] a = s.toCharArray();
		int len = a.length;
		int counter = 0;
		int i = len - 1;
		if (len == 0)
			return 0;
		else {
			while (i >= 0 && a[i] == ' ') {
				i--;
			}
			while (i >= 0
					&& ((a[i] >= 'A' && a[i] <= 'Z') || (a[i] >= 'a' && a[i] <= 'z'))) {
				counter++;
				i--;
			}
			return counter;
		}
	}

	public static void main(String args[]) {
		String s = " Sophie is lovelyyyyyyyyyy";
		System.out.println(lengthOfLastWord(s));
	}
}
