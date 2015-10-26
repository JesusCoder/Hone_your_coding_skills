package algorithms.medium;

/* Leetcode:
 * Given an integer, convert it to a roman numeral.
 Input is guaranteed to be within the range from 1 to 3999.

 Pretty easy question, quickly get it done.
 */

public class _20150916_IntegerToRoman_revisit {

	public static String intToRoman(int num) {
		int thousandth = num / 1000;
		int hundredth = (num - thousandth * 1000) / 100;
		int tenth = (num - thousandth * 1000 - hundredth * 100) / 10;
		int ones = num - thousandth * 1000 - hundredth * 100 - tenth * 10;
		// System.out.print(thousandth + " \t" + hundredth + " \t" + tenth +
		// " \t" + ones);
		String res = "";

		/* First, let's deal with thousandth. */
		for (int i = 0; i < thousandth; i++) {
			res = res + "M";
		}

		/* Now let's deal with hundredth. */
		switch (hundredth) {
		case 1:
			res = res + "C";
			break;
		case 2:
			res = res + "CC";
			break;
		case 3:
			res = res + "CCC";
			break;
		case 4:
			res = res + "CD";
			break;
		case 5:
			res = res + "D";
			break;
		case 6:
			res = res + "DC";
			break;
		case 7:
			res = res + "DCC";
			break;
		case 8:
			res = res + "DCCC";
			break;
		case 9:
			res = res + "CM";
			break;
		}

		/* Now let's deal with hundredth. */
		switch (tenth) {
		case 1:
			res = res + "X";
			break;
		case 2:
			res = res + "XX";
			break;
		case 3:
			res = res + "XXX";
			break;
		case 4:
			res = res + "XL";
			break;
		case 5:
			res = res + "L";
			break;
		case 6:
			res = res + "LX";
			break;
		case 7:
			res = res + "LXX";
			break;
		case 8:
			res = res + "LXXX";
			break;
		case 9:
			res = res + "XC";
			break;
		}

		/* Now let's deal with hundredth. */
		switch (ones) {
		case 1:
			res = res + "I";
			break;
		case 2:
			res = res + "II";
			break;
		case 3:
			res = res + "III";
			break;
		case 4:
			res = res + "IV";
			break;
		case 5:
			res = res + "V";
			break;
		case 6:
			res = res + "VI";
			break;
		case 7:
			res = res + "VII";
			break;
		case 8:
			res = res + "VIII";
			break;
		case 9:
			res = res + "IX";
			break;
		}

		/*
		 * Following is another way to implement this, but not efficient as the
		 * first one.
		 */

		// /* Now let's deal with tenth. */
		// if(tenth == 4){
		// res = res + "XL";
		// }
		// else if(tenth >= 5 && tenth < 9){
		// res = res + "L";
		// for(int i = 0; i < tenth - 5; i++){
		// res = res + "X";
		// }
		// }
		// else if(tenth == 9){
		// res = res + "XC";
		// }
		// else if(tenth < 4){
		// for(int i = 0; i < tenth; i++){
		// res = res + "X";
		// }
		// }
		//
		// /* Now we'll deal with the ones. */
		// if(ones == 4){
		// res = res + "IV";
		// }
		// else if(ones >= 5 && ones < 9){
		// res = res + "V";
		// for(int i = 0; i < ones - 5; i++){
		// res = res + "I";
		// }
		// }
		// else if(ones == 9){
		// res = res + "IX";
		// }
		// else if(ones < 4){
		// for(int i = 0; i < ones; i++){
		// res = res + "I";
		// }
		// }

		return res;
	}

	public static void main(String args[]) {
		System.out.println("\n" + intToRoman(3));
	}
}
