package algorithms.easy;

import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 */

/** 1st practice: 8/16/2015 */

public class _20150814_ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("cat", "tac"));
	}

	public static boolean isAnagram(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		Arrays.sort(sArray);
		Arrays.sort(tArray);

		System.out.println("sArray is: " + String.valueOf(sArray));
		System.out.println("tArray is: " + String.valueOf(tArray));

		return String.valueOf(sArray).equals(String.valueOf(tArray));
	}
}
