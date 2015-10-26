package algorithms.hard;

import java.util.ArrayList;

/** I copied the solution from online to this Leetcode problem. Clearly remember that I could not figure this one out after cracking my head on it for quite a while.*/

public class _20150916_TextJustification_revisit {
	public static ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		if (words == null || words.length == 0)
			return result;
		int count = 0;
		int last = 0;
		for (int i = 0; i < words.length; i++) {
			if (count + words[i].length() + (i - last) > L) {
				int spaceNum = 0;
				int extraNum = 0;
				if (i - last - 1 > 0) {
					spaceNum = (L - count) / (i - last - 1);
					extraNum = (L - count) % (i - last - 1);
				}
				StringBuilder sb = new StringBuilder();
				for (int j = last; j < i; j++) {
					sb.append(words[j]);
					if (j < i - 1) {
						for (int k = 0; k < spaceNum; k++) {
							sb.append(" ");
						}
						if (extraNum > 0) {
							sb.append(" ");
						}
						extraNum--;
					}
				}
				for (int j = sb.length(); j < L; j++) {
					sb.append(" ");
				}
				result.add(sb.toString());
				count = 0;
				last = i;
			}
			count += words[i].length();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = last; i < words.length; i++) {
			sb.append(words[i]);
			if (sb.length() < L) {
				sb.append(" ");
			}
		}
		for (int i = sb.length(); i < L; i++) {
			sb.append(" ");
		}
		result.add(sb.toString());
		return result;
	}

	public static void main(String args[]) {
		String[] words = new String[] { "This", "is", "an", "example", "of",
				"text", "justification." };
		System.out.print(fullJustify(words, 16) + "\nProgram ended.");
	}
}
