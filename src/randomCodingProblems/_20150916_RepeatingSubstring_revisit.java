package randomCodingProblems;

/* This is a real telephone interview question of Amazon that Mian got asked on Jan.28.2014,
 * I'm glad that I solved it, very excited! */

/* Write a function to find if a given string repeats itelf where the repeat pattern length is more than 1 -

aaabbbaaabbbaaabbb => Yes, aaabbb
abababababab => Yes, ab
aaaaaaaaa => No
abcdbcde => No

Analyze the time complexity.
 */
public class _20150916_RepeatingSubstring_revisit {
	public static boolean repeat(String s){
		int len = s.length();
		if(len < 4){
			return false;
		}
		else{
			int start = 2;//b/c a repeating string has at least two chars
			int end = len - 2;
			while(!s.substring(0, start).equals(s.substring(end, len)) && start <= end){
				start++;
				end--;
			}
			//now we need to judge why it exits the while loop
			/* mainly to find one of the two reasons:
			 * first: is it because the two same substrings are found?
			 * second: is it because start equals end? */
			if(start == end){
				if(s.substring(0, start).equals(s.substring(end, len))){
					return true;
				}
				else
					return false;
			}
			else{
				/* here it means the two same substrings are found at both ends,
				 * then we first check if the remaining substring in the middle
				 * is a multiple of the length of the repeating substring, if so,
				 * then we go ahead and check it, if not, return false immediately. */
				int lenOfRepeatingSubstr = s.substring(0, start).length();
				System.out.println("lenOfRepeatingSubstr = " + lenOfRepeatingSubstr + "\tstart = " + start + "\tend = " + end);
				if((end - start) % lenOfRepeatingSubstr != 0){
					System.out.println("end = " + end + "\tstart = " + start);
					return false;
				}
				else{
					String repeatingStr = s.substring(0, start);
					/* before going into normal checking, we need to consider the case
					 * when all chars are identical in this repeating substring, i.e.
					 * a string like "aaaaa" */
					char [] a = repeatingStr.toCharArray();
					char firstChar = a[0];
					int i;
					for(i = 1; i < lenOfRepeatingSubstr; i++){
						if(a[i] != firstChar){
							break;
						}
					}
					if(i == lenOfRepeatingSubstr)//this means the above for loop is finished
					{
						return false;
					}

					
					/* After excluding the "aaaaaaa" case,
					 * now we check the middle part of the string from the index "start"
					 * to the index "end" using substring method in the string API. */
					int startOfMidSubstring = start;//start index of the substring

					System.out.println("startOfMidSubstring = " + startOfMidSubstring + "\trepeatingStr = " + repeatingStr);
					while(startOfMidSubstring < end){
						System.out.println("s.substring(startOfMidSubstring, lenOfRepeatingSubstr) = " + s.substring(startOfMidSubstring, startOfMidSubstring + lenOfRepeatingSubstr));
						if(s.substring(startOfMidSubstring, startOfMidSubstring + lenOfRepeatingSubstr).equals(repeatingStr)){
							startOfMidSubstring += lenOfRepeatingSubstr;
							System.out.println("startOfMidSubstring" + startOfMidSubstring);
						}
						else{
							return false;
						}
					}
					return true;
				}
			}
		}

	}
	public static void main(String args[]){

		//		String s = "abcdabcdabcd";
		//		System.out.println(s.substring(s.length()-4, s.length()));
		//		System.out.println(s.substring(0, 4));

		//String s = "abababababab";
		//		String s = "aaabbbaaabbbaaabbb";
		//String s = "aaaaaaaa";
		//String s = "abcdbcde";

		//String s = "aabaaaba"; 
		//	String s = "abcdefabcabcdefabc";
		//String s = "aabaaabaaaba";
		String s = "ababababcdababab";
		System.out.println(s.length());
		System.out.println(repeat(s));
	}
}
