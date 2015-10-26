package algorithms.medium;

/**
 Directly used the solution from discuss board, didn't dive deep into the details:
 https://leetcode.com/discuss/28293/229-ms-java-with-sorting-and-comparator:
 It turned out that the Comparator that I learned toward the end of the HeadFirstJava
 book is a very oftenly used and helpful class!
 "I first analyzed to cases where each num precedes other, and implemented a comparator based on every special case. Used Arrays.sort to sort every num (as a string) then merged them alltogether.

 The idea is getting the largest digit first, if there is a tie (multiple numbers with the same first digit), then it gets tricky; you check both numbers until you see a mismatch, and declare the number with the larger digit as the winner. As it happens that one of the strings is finished while looking for tie break, there are 3 other cases: (1) if next digit in the longer number is greater than the very first digit, then it is the winner. (2) if next digit is smaller, then the other number is the winner. (3)if next digit is same as the first, you chop the longer string, and recursively call it on the remaining digits."*/
import java.util.Arrays;
import java.util.Comparator;

public class _20150814_LargestNumber {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 30, 34, 5, 9 };
		System.out.println(largestNumber(nums) + "\nThe end.");
	}

	public static String largestNumber(int[] num) {
		if (num.length == 0)
			return "";
		if (num.length == 1)
			return Integer.toString(num[0]);
		String[] str = new String[num.length];
		for (int i = 0; i < num.length; i++)
			str[i] = Integer.toString(num[i]);
		Arrays.sort(str, new StringComparator());
		StringBuilder sb = new StringBuilder("");
		for (int i = num.length - 1; i >= 0; i--)
			sb.append(str[i]);
		if (sb.charAt(0) == '0')
			return "0";
		return sb.toString();
	}
}

class StringComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() == 0 && s2.length() == 0)
			return 0;
		if (s2.length() == 0)
			return 1;
		if (s1.length() == 0)
			return -1;
		for (int i = 0; i < s1.length() && i < s2.length(); i++) {
			if (s1.charAt(i) > s2.charAt(i)) {
				return 1;
			} else if (s1.charAt(i) < s2.charAt(i)) {
				return -1;
			}
		}
		if (s1.length() == s2.length())
			return 0;
		if (s1.length() > s2.length()) {
			if (s1.charAt(0) < s1.charAt(s2.length()))
				return 1;
			else if (s1.charAt(0) > s1.charAt(s2.length()))
				return -1;
			else
				return compare(s1.substring(s2.length()), s2);
		} else {
			if (s2.charAt(0) < s2.charAt(s1.length()))
				return -1;
			else if (s2.charAt(0) > s2.charAt(s1.length()))
				return 1;
			else
				return compare(s1, s2.substring(s1.length()));
		}
	}
}
