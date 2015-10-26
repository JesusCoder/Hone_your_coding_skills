package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * 345: 3+4+5 = 12: 1 + 2 =3 9876: 9 + 8 + 7 + 6 = 30: 3 + 0 = 3
 */
public class _20150816_AddDigits {

	/**
	 * I rocked! I solved this problem all by myself! Made it accepted at first
	 * submission! Praise the Lord! Although this is an easy question!
	 */
	public static void main(String[] args) {
		System.out.println(addDigits(38));
	}

	public static int addDigits(int num) {

		int placeholder = num;
		int temp;
		do {
			temp = 0;
			char[] numDigits = String.valueOf(placeholder).toCharArray();

			List<Integer> intArray = new ArrayList<Integer>();
			for (int i = 0; i < numDigits.length; i++) {
				System.out
						.println("Character.getNumericValue(numDigits[i]) is: "
								+ Character.getNumericValue(numDigits[i]));
				intArray.add(Character.getNumericValue(numDigits[i]));
			}

			for (int a : intArray) {
				temp += a;
			}
			System.out.println("temp is: " + temp);
			placeholder = temp;
		} while (temp >= 10);
		return temp;
	}
}
