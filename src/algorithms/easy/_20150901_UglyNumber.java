package algorithms.easy;

import TreeUtils.CommonUtils;

/**
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another
 * prime factor 7.
 * 
 * Note that 1 is typically treated as an ugly number.
 */
public class _20150901_UglyNumber {

	/**
	 * I thought about it and then copied this algorithm online.
	 * Unexpectedly, this one didn't get accepted due to time limit exceeded.*/
//	public boolean isUgly(int num) {
//		if(num < 0) { 
//			return false;
//		} else if (num == 1) {
//			return true;
//		} 
//		while (num % 2 == 0) {
//			CommonUtils.println("now the num is: " + num);
//			num /= 2;
//		}
//		while (num % 3 == 0) {
//			CommonUtils.println("now the num is: " + num);
//			num /= 3;
//		}
//		while (num % 5 == 0) {
//			CommonUtils.println("now the num is: " + num);
//			num /= 5;
//		}
//		return num == 1;
//	}
	
	public boolean isUgly(int num){
		if(num <= 0) return false;
		if(num == 1) return true;
		if(num % 2 == 0) {
			CommonUtils.println("now the num is: " + num);
			return isUgly(num/2);
		}
		if(num % 3 == 0) { 
			CommonUtils.println("now the num is: " + num);
			return isUgly(num/3);
		}
		if(num % 5 == 0) { 
			CommonUtils.println("now the num is: " + num);
			return isUgly(num/5);
		}
		return false;
	}
	
	public static void main(String... args){
		_20150901_UglyNumber test = new _20150901_UglyNumber();
		System.out.println(test.isUgly(35));
	}
}
