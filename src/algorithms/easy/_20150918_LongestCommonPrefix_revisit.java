/**
 * 
 */
package algorithms.easy;

/* To judge whether two strings are equal or not, you MUST not use "=="!
 * You must use String.equals(anotherString)!!! */

/* Eventually, I made this code accepted on Leetcode, I implemented all by myself!
 * 
 * What this problem really means is that it wants me to find a COMMON prefix that
 * is shared by every single string in the array, if there's no such prefix, then you
 * must return an empty string "" !
 * 
 * Then the algorithm flows naturally:
 * first, find the string with the shortest length in this array;
 * second, traverse this array, compare this shortest string with all strings in this array,
 * if any one of the strings don't contain this prefix, then cut the prefix's last char off,
 * then start the new traverse again, until the prefix is cut into an empty string, this means
 * there're no such common prefix that is shared by EVERY string in this array! */

public class _20150918_LongestCommonPrefix_revisit {
	public static String longestCommonPrefix(String[] strs) {
		int len = strs.length;
		if(len == 0){
			return "";
		}
		int minStrLen = strs[0].length();
		int minStrIndex = 0;
		for(int i = 1; i < len; i++){
			if(strs[i].length() < minStrLen){
				minStrLen = strs[i].length();
				minStrIndex = i;
			}
		}
		int endIndex = minStrLen;
		int i = 0;
		System.out.println("place 1");
		for(; endIndex >= 0 && i < len;){
			for(; i < len; i++){
				System.out.println(endIndex + "\t" + strs[i].substring(0, endIndex) + "\t" + strs[minStrIndex].substring(0, endIndex));
				if(!strs[i].substring(0, endIndex).equals(strs[minStrIndex].substring(0, endIndex))){
					endIndex--;
					System.out.println("place 2");
					break;
				}
			}
		}
		if(endIndex == -1){
			return "";
		}
		else
			return strs[minStrIndex].substring(0, endIndex);
	}
	public static void main(String args[]){

		//test case 2:
		//		String [] s = new String[]{"a"};

		//		test case 3:
		//		String [] s = new String[]{"aa", "aa"};

		//		test case 4:
		String [] s = new String[]{"flower", "floweig", "flowet", "flowegh", "flow", "flow1", "flow&"};

		System.out.println(longestCommonPrefix(s));
	}
}
