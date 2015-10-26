/**
 * 
 */
package algorithms.easy;

/* Leetcode:
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.*/

/* This is a problem that I solved before, but in order to cater to Leetcode submission
 * requirements, it works perfectly fine, but this one is not efficient enough, 
 * rejected on Leetcode because exceeded time limit, so I wrote Palindrome2.java */

public class _20150916_ValidPalindrome_revisit {

	public static boolean isPalindrome_exceededTimeLimit(String s) {
		String newStr = "";
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')
					|| (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
					|| (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')) {
				if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
					newStr = newStr + Character.toLowerCase(s.charAt(i));
				} else {
					newStr = newStr + s.charAt(i);
				}

			}

		}
		len = newStr.length();
		System.out.print(newStr);
		System.out.println();
		if (len == 0)
			return false;
		else if (len == 1)
			return true;
		else /* indicates all other situations: length is odd and minimum is 3 */{
			for (int i = 0; i < len / 2; i++) {
				if (newStr.charAt(i) != newStr.charAt(len - i - 1)) {
					return false;
				} else
					return true;
			}
		}
		/*
		 * Actually, no matter it's odd or even, there's no difference in
		 * dealingwith them.
		 */
		return false;
	}

	/**
	 * The above algorithm was not accepted due to time limiti exceeded, but in
	 * order to cater to Leetcode submission requirements, but this one is not
	 * efficient enough, rejected on Leetcode because exceeded time limit, so I
	 * wrote the following method
	 */

	/*
	 * I coded this out out alone again! And finally it passed the time
	 * constraint on Leetcode and got accepted! I was to the brink of
	 * desperation a couple times but eventually made it there!
	 * 
	 * It took me quite a while to organize this logic straight after
	 * frustrating debugging line by line.
	 */

	public static boolean isPalindrome(String s) {
		int len = s.length();
		char tempi, tempj;
		int i = 0, j = len - 1;
		if (len == 0 || len == 1)
			return true;
		else /*
			 * indicates all other situations: length is even, odd and minimum
			 * is 3
			 */{
			while (i < j) {
				if (s.charAt(i) != s.charAt(j)) {
					if (Character.isLetterOrDigit(s.charAt(i))) {
						if (Character.isLetterOrDigit(s.charAt(j))) {
							if (s.charAt(i) != s.charAt(j)) {
								if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
									tempi = Character.toLowerCase(s.charAt(i));
									if (tempi != s.charAt(j)) {
										tempj = Character.toLowerCase(s
												.charAt(j));
										if (tempi != tempj) {
											return false;
										}
									} else {
										i++;
										j--;
									}
								} else if (s.charAt(i) == Character
										.toLowerCase(s.charAt(j))) {
									i++;
									j--;
								} else
									return false;
							}
						} else
							j--;
					} else
						i++;
				} else {
					i++;
					j--;
				}

			}
		}
		/*
		 * Actually, no matter it's odd or even, there's no difference in
		 * dealingwith them.
		 */
		return true;
	}

	public static void main(String args[]) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
}