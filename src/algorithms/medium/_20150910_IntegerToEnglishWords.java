/**
 * 
 */
package algorithms.medium;

import java.util.HashMap;
import java.util.Map;

import TreeUtils.CommonUtils;

/**
 * @author jiahuan
 * problem: {@link https://leetcode.com/problems/integer-to-english-words/ }
 */
public class _20150910_IntegerToEnglishWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		_20150910_IntegerToEnglishWords test = new _20150910_IntegerToEnglishWords();
		CommonUtils.print(test.numberToWords(1234545));
	}
	
	//the biggest number is: 2,147,483,647 per the problem description.
	//I didn't figure out my own algorithm, met difficulties and gave up and went online for solutions.
//	public static String numberToWords(int num) {
//		String result = "";
//		String numStr = Integer.toString(num);
//		switch(String.valueOf(num).length()){
//		case 10 : 
//			result = speakOutOneDigitWords(numStr.substring(0, 1)) + " Billion " + speakOutThreeDigitWords(numStr.substring(2, 4)) + " Million " + speakOutThreeDigitWords() + " Thousand " +speakOutThreeDigitWords();
//			break; 
//		case 9 : ;
//			break;
//		case 8 : ;
//			break;
//		case 7 : ;
//			break;
//		case 6 : ;
//			break;
//		case 5 : ;
//			break;
//		case 4 : ;
//			break;
//		case 3 : ;
//			break;
//		case 2 : ;
//			break;
//		case 1 : ;
//			break;
//		}
//		return result;
//
//	}
//
//	private static String speakOutThreeDigitWords() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private static String speakOutThreeDigitWords(String digits) {
//		return digitMap.get(digits.substring(0, 1)) + " Hundred " + digitMap.get(digits.substring(0, 1)) + "  " +digitMap.get(digits.substring(0, 1)) + " ";
//	}
//
//	private static String speakOutOneDigitWords(String digit) {
//		return digitMap.get(digit);
//	}
//	
//	private static final Map<String, String> digitMap = new HashMap<String, String>() {
//		{
//			put("0", "Zero");
//			put("1", "One");
//			put("2", "Two");
//			put("3", "Three");
//			put("4", "Four");
//			put("5", "Five");
//			put("6", "Six");
//			put("7", "Seven");
//			put("8", "Eight");
//			put("9", "Nine");
//		};
//	};
//	
//	private static final Map<String, String> tenthMap = new HashMap<String, String>() {
//		{
//			put("0", "");
//			//TODO: deal with the 1 case, like ten, eleven, twelve, thirteen fourteen up to nineteen
//			put("2", "Twenty");
//			put("3", "Thirty");
//			put("4", "Fourty");
//			put("5", "Fifty");
//			put("6", "Sixty");
//			put("7", "Seventy");
//			put("8", "Eighty");
//			put("9", "Ninety");
//		};
//	};
	
	
	//I copied the following algorithm from discuss.
	private String[] digit = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private String[] teen = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private String[] ten = new String[] {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private String[] thousand = new String[] {"Thousand", "Million", "Billion"};

	public String numberToWords(int num) {
	    String ans;
	    if (num == 0)
	        return digit[num];

	    ans = hundredHelper(num%1000);
	    num = num/1000;
	    int i = 0;
	    while (i < 3 && num > 0) {
	        if (num % 1000 > 0)
	            ans = hundredHelper(num%1000) + thousand[i] + " " + ans;
	        num = num/1000;
	        i++;
	    }

	    return ans.trim();
	}

	public String hundredHelper(int num) {
	    String nstr = "";
	    if (num >= 100) {
	        nstr = digit[num/100] + " Hundred ";
	    }
	    num = num%100;
	    if (num >= 20) {
	        if (num % 10 != 0)
	            nstr = nstr + ten[num/10 - 2] + " " +  digit[num%10] + " ";
	        else
	            nstr = nstr + ten[num/10 - 2] + " ";
	    } else if (num >= 10) {
	        nstr = nstr + teen[num%10] + " ";
	    } else if (num > 0){
	        nstr = nstr + digit[num] + " ";
	    }
	    return nstr;
	}
}
