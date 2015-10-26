/**
 * 
 */
package algorithms.easy;

/** From Leetcode:
 * Given a roman numeral, convert it to an integer.

   Input is guaranteed to be within the range from 1 to 3999.
   
   Pretty easy and straightforward, I did it all by myself, easy to write, but took me 1 hour to debug
   and finally make it robust. */

public class _20150916_RomanToInteger_revisit {

	public static int romanToInt(String s) {
		System.out.println(s.length());
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			System.out.print(c);
		}
		System.out.println();
		int[] res = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (charArray[i] == 'M') {
				res[i] = 1000;
				System.out.println("res[" + i + "] = " + res[i]);
			} else if (charArray[i] == 'D') {
				res[i] = 500;
				System.out.println("res[" + i + "] = " + res[i]);
			} else if (charArray[i] == 'C') {
				if (i != s.length() - 1) {
					if (charArray[i + 1] == 'D') {
						res[i] = 0;
						res[i + 1] = 400;
						System.out.println("res[" + i + "+1] = " + res[i + 1]);
						i++;
					} else if (charArray[i + 1] == 'M') {
						res[i] = 0;
						res[i + 1] = 900;
						System.out.println("res[" + i + "+1] = " + res[i + 1]);
						i++;
					} else
						res[i] = 100;
				} else if (i == s.length() - 1) {
					res[i] = 100;
					System.out.println("res[" + i + "] = " + res[i]);
				}

			} else if (charArray[i] == 'L') {
				res[i] = 50;
				System.out.println("res[" + i + "] = " + res[i]);
			} else if (charArray[i] == 'X') {
				if (i != s.length() - 1) {
					if (charArray[i + 1] == 'L') {
						res[i] = 0;
						res[i + 1] = 40;
						System.out.println("res[" + i + "+1] = " + res[i + 1]);
						i++;
					} else if (charArray[i + 1] == 'C') {
						res[i] = 0;
						res[i + 1] = 90;
						System.out.println("res[" + i + "+1] = " + res[i + 1]);
						i++;
					} else {
						res[i] = 10;
						System.out.println("res[" + i + "] = " + res[i]);
					}
				}

				else if (i == s.length() - 1) {
					res[i] = 10;
					System.out.println("res[" + i + "] = " + res[i]);
				}

			} else if (charArray[i] == 'V') {
				res[i] = 5;
				System.out.println("res[" + i + "] = " + res[i]);
			} else if (charArray[i] == 'I') {

				if (i != (s.length() - 1)) {
					if (charArray[i + 1] == 'V') {
						res[i] = 0;
						res[i + 1] = 4;
						System.out.println("res[" + i + "+1] = " + res[i + 1]);
						i++;
					} else if (charArray[i + 1] == 'X') {
						res[i] = 0;
						res[i + 1] = 9;
						System.out.println("res[" + i + "+1] = " + res[i + 1]);
						i++;
					} else {
						res[i] = 1;
						System.out.println("res[" + i + "] = " + res[i]);
					}
				} else if (i == (s.length() - 1)) {
					res[i] = 1;
					System.out.println("res[" + i + "] = " + res[i]);
				}
			}
		}

		int result = 0;
		;
		for (int j = 0; j < res.length; j++) {
			System.out.println(res[j]);
			result = result + res[j];
		}

		return result;
	}

	public static void main(String args[]) {
		System.out.println("The final result is " + romanToInt("MMVIII") + ".");
	}
}

