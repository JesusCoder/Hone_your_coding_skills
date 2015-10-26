package algorithms.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples: 
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false. 
 * pattern = "aaaa", str = "dog cat cat dog" should return false. 
 * pattern = "abba", str = "dog dog dog dog" should return false. 

 * Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a
 * single space.
 */
public class _20151018_WordPattern {
	/**Cool! I came up the algorithm all by myself and debugged it and made it accepted online all myself! Cool! Praise the Lord!*/
	public boolean wordPattern(String pattern, String str) {
		String[] stringList = new String[1000];//Integer.MAX_VALUE doesn't work on my Mac, so give it 1000 as a random big number for now
		stringList = str.split(" ");
		printList(stringList);
		
		char[] patternList = new char[1000];
		patternList = pattern.toCharArray();
		printChar(patternList);
		
		Map<Character, String> map = new HashMap<Character, String>();
		for(int i = 0, j =0; j < stringList.length && i < patternList.length; i++, j++){
			if(!map.containsKey(patternList[i]) && !map.containsValue(stringList[j])){
				map.put(patternList[i], stringList[j]);
			} 
		}
		printMap(map);
		
		if(stringList.length != patternList.length){
			return false;
		}
		
		for(int i = 0, j =0; j < stringList.length && i < patternList.length; i++, j++){
			if(map.containsKey(patternList[i])){
				if(!map.get(patternList[i]).equals(stringList[j])){
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	private void printMap(Map<Character, String> map) {
		System.out.print("The map is:");
		for(Entry entry : map.entrySet()){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

	private void printChar(char[] patternList) {
		for(char c : patternList){
			System.out.print(c + "\n");
		}
	}

	private void printList(String[] list) {
		for(String str : list){
			System.out.print(str + "\n");
		}
	}
	
	public static void main(String... args){
		_20151018_WordPattern test = new _20151018_WordPattern();
//		String str = "cat cat cat cat";
//		String pattern = "abba";
		String str = "cat cat cat cat";
		String pattern = "aaa";
		System.out.println(test.wordPattern(pattern, str));
	}
}
