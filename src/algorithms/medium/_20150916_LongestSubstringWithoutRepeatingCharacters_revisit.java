package algorithms.medium;

import java.util.Hashtable;

/* Leetcode: 
 * Given a string, find the length of the longest substring 
 * without repeating characters. For example, the longest 
 * substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", 
 * with the length of 1.*/

/**
 * My algorithm: Traverse the whole string from the beginning, put the char that
 * has been checked into a hashmap, if this is a new char (we haven't met
 * before), we'll put it into the hashmap, and increment the length by one, if
 * it's not new, we'll put this element into a new hashmap value, assign the
 * length to len variable, start a new counter and continue this process until
 * we hit the end of the string.
 */

/*
 * Cool, I spent exactly two hours and figured this problem out! Implemented the
 * following code and made it run!
 * 
 * There were a couple very frustrating moments when I truly wanted to give up!
 * But I hung in here and persevered till the end!
 */

public class _20150916_LongestSubstringWithoutRepeatingCharacters_revisit {
	public static int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		} else {
			Hashtable<Integer, String> charht = new Hashtable();
			/*
			 * the Integer (keys) in the Hashtable will be index of its
			 * corresponding substring (values)
			 */

			char[] charArray = s.toCharArray();
			int index = 0;
			charht.put(0, Character.toString(s.charAt(0)));/*
															 * Initialization of
															 * this Hashtable
															 * set index 0 as
															 * its first key,
															 * and also put the
															 * first char into
															 * the value
															 * position.
															 */
			String temp = Character.toString(s.charAt(0));
			/*
			 * Perfect! I don't need to worry about what would happen this temp
			 * is initialized to the first char of this input string, when it
			 * meets this char a second time when traversing this string, it
			 * will be the correct value by then! Cool!
			 */
			for (int i = 1; i < charArray.length; i++) {
				if (!charht.get(index).contains(
						Character.toString(charArray[i])))
				/*
				 * Here is a point that can be optimized: Instead of using the
				 * contains() method of the String class I could define the
				 * value type as ArrayList, so that I can take advantage of the
				 * Hashtable constant access time!
				 */
				{
					temp = temp + charArray[i];
					charht.put(index, temp);
					// System.out.println("if temp" + i + ": " + temp);
				} else {

					/*
					 * Before putting chars into a new hash value position, we
					 * need to find the position of the element that is
					 * duplicate with the current char then move all the chars
					 * after this duplicate char in the previous hash value into
					 * next one and then do the "else" statement
					 * 
					 * This is a very important step which I neglected when
					 * initally I designed my algorithm, it was very painful
					 * when I found this bug, very despaired! But I didn't truly
					 * give up, stayed calm, and figured the logic out and
					 * implemented them into code!
					 * 
					 * Jesus, I love this feeling! It's so awesome!
					 * 
					 * CS is all about logic! You have to figure out the logic
					 * step by step, cannot fail to consider any situation if
					 * you want to make your program be bug-free and robust!
					 */

					String temp1 = "";
					for (int j = 0; j < charht.get(index).length(); j++) {
						if (charArray[i] == charht.get(index).charAt(j))
						/*
						 * Find the position of the char that is duplicate with
						 * the previous hash value
						 */
						{
							for (int k = j + 1; k < charht.get(index).length(); k++) {
								temp1 = temp1 + charht.get(index).charAt(k);
							}
							/*
							 * Copy all the chars after this duplicate one into
							 * the new hash value, then start the "else"
							 * statement.
							 */
						}
					}

					temp = temp1;
					index++;
					temp = temp + charArray[i];
					charht.put(index, temp);
					// System.out.println("else temp" + i + ": " + temp);

				}
			}
			int longest = charht.get(0).length();
			int key = 0;
			/*
			 * This key refers to the key that hashes to the value which has the
			 * longest non-repeating substring
			 */
			for (int i = 1; i <= index; i++) {
				if (charht.get(i).length() > longest) {
					longest = charht.get(i).length();
					key = i;
				}
			}
			return longest;
		}
		// System.out.println("The longest substring that" +
		// " doesn't contain any repeating character" +
		// " is \"" + charht.get(key) + "\" that has a length of " +
		// longest + ".");
		// System.out.println("The values (non-repeating substrings) in the Hashtable are "
		// + charht.values() + ".");
		//
	}

	public static void main(String args[]) {
		String s = "";
		System.out.println(lengthOfLongestSubstring(s));

	}
}
