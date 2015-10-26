package algorithms.easy;

public class _20151022_Atoi {
	/**I used the answer from discuss. But understood it very easily.
	 * Still it's very worth to manually re-type every single line myself
	 * to have deepened my understanding of how this algorithm really works.*/
	public int myAtoi(String str){
		int p = 0, result = 0;
		while(p < str.length() && Character.isWhitespace(str.charAt(p))) p++;
		if(p == str.length()) return 0;
		boolean negativeFlag = (str.charAt(p) == '-');
		if(str.charAt(p) == '+' || str.charAt(p) == '-') p++;
		for(; p<str.length(); p++){
			if(str.charAt(p) > '9' || str.charAt(p) < '0'){
				break;
			} else {
				int digit = str.charAt(p) - '0';
				if(!negativeFlag && result > (Integer.MAX_VALUE - digit)/10) return Integer.MAX_VALUE;
				else if (negativeFlag && result < (Integer.MIN_VALUE + digit)/10) return Integer.MIN_VALUE;
				result = result*10 + (negativeFlag? -digit:digit);
			}
		}
		return result;
	}
	
	public static void main(String... args) {

	}
}
