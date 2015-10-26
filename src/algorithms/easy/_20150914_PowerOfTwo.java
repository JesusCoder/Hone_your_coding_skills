/**
 * 
 */
package algorithms.easy;


/**
 * @author jiahuan
 *
 */
public class _20150914_PowerOfTwo {

	/**
	 Problem: Given an integer, write a function to determine if it is a power of two. 
	 */
	
	/**
	 * Cool! I made it all the way thru all by myself! I debugged one step after
	 * another, submitted five times, hung in there and fixed the logic bug in
	 * my code in the first failed four submissions! Cool! Praise the Lord!
	 */
	public static boolean isPowerOfTwo(int n) {
		if (n < 1)
			return false;
		if (n <= 2)
			return true;
		if(n % 2 != 0)
			return false;
		int remainder = 0;
		do {
			remainder = n % 2;
			n = n / 2;
			if(n % 2 != 0) {
				return false;
			}
		} while (n != 0 && n > 2);
		if (n == 0 || (n == 2 && remainder == 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println((isPowerOfTwo(18)));
	}

}
