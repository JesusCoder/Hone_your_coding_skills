package algorithms.medium;

/** Made this problem accepted with Xi Huang's help, a very simple problem, but when I used my own algorithm
 * it always exceeded time limit. 
 * 
 * Then I adopted Xi Huang's method, split it, and then use StringBuilder to connect them, since
 * String is immutable, each time when I add string to itself, the time cost is very huge, while
 * StringBuilder is very time-saving. 
 * 
 * split() method splits a string into an array of strings, pay special attention to that
 * if the first character of the string is empty, it might put an empty string into the splitted result,
 * we'll need to get rid of that. */

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 */

public class _20150916_ReverseWordsInAString_revisit {
	public static String reverseWords(String s) {
		char[] c = s.toCharArray();
		String res = "";
		int len = s.length();
		if (len == 0) {
			return res;
		}
		if (s.matches(" *")) {
			return res;
		}
		if (!s.contains(" ")) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		String[] str = s.split(" *");
		for (int j = str.length - 1; j >= 0; j--) {
			if (!str[j].equals(" ") && !str[j].equals("")) {
				sb.append(str[j]);
				sb.append(" ");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static void main(String args[]) {
		 String s = "the sky is blue";
		// String s = " ";
		// String s = "a";
		// String s = "1 ";
		// String s = "   a   ";
//		String s = " 1";
		System.out.println(reverseWords(s));

		System.out.println("Program finished.");
	}
}

