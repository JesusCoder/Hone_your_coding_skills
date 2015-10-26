package algorithms.hard;
/**
 * 
 */


/**
 
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

 * @author jiahuan
 *
 */
public class _20150814_RegularExpressionMatching {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println("Program ended.");
	}
	
	public static boolean isMatch(String s, String p){
		if(p.isEmpty()){
			System.out.println("It comes into FIRST if statement and exits.");
			return s.isEmpty();
		}
		if(p.length() == 1 || p.charAt(1) != '*'){
			if(s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))){
				System.out.println("It comes into if statement of SECOND if/else block and exits.");
				return false;
			} else {
				System.out.println("It comes into ELSE branch of if/else block and exits.");
				return isMatch(s.substring(1), p.substring(1));
			}
		}
		//p.length() >= 2
		while(!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
			if(isMatch(s, p.substring(2))){
				return true;
			}
			s = s.substring(1);
		}
		return isMatch(s, p.substring(2));
	}
}
