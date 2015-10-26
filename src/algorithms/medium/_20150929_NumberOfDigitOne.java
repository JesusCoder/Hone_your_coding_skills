package algorithms.medium;

/**
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative integers less than or equal to n.
 * 
 * For example: Given n = 13, Return 6, because digit 1 occurred in the
 * following numbers: 1, 10, 11, 12, 13.
 */
public class _20150929_NumberOfDigitOne {

	/**
	 * Used solution from discuss:
	 * 
	 * The basic idea is to find the relationship between the increse of number
	 * of digit 1 and each digit. For example, let (edcba) be a number, I want
	 * to find a relationship that represents how number of digit 1 incresed
	 * with the current digit, like f(e) =
	 * countDigitOne(edcba)-countDigitOne(dcba). Once such function is
	 * identified, the total number of digit 1 can be iteratively calculated.
	 * 
	 * The following is the process to identify the relationship(function f()):
	 * The function (f(e)) is defined as the number of digit 1 increased because
	 * of digit e. (i.e. compared to there was no digit e, just (dcba), for
	 * example).
	 * 
	 * We take (edcba) as a number like 12345 (e =1, d=2,c=3,b=4 and a =5) here.
	 * 
	 * Start from f(a), it's obvious that if a=0, f(a) = 0, if a >0, f(a)=1.
	 * 
	 * Then f(b). If b =1,since countDigitOne(11) = 4 while countDigitOne(01) =1
	 * ,and countDigitOne(19) = 12 while countDigitOne(09) = 1, it shows that
	 * f(b) = 1 + a +1.
	 * 
	 * If b>1, since countDigitOne(21) = 13 while countDigitOne(01) = 1 and
	 * countDigitOne(99) = 20 while countDigitOne(09) = 1, f(b) = b + 10;
	 * 
	 * Similarly,
	 * 
	 * if c=1, f(c) = 20 + 10b+a+1; if c>1, f(c) = 20c+100;
	 * 
	 * if d = 1, f(d) = 300+100c+10b+a+1; if d>1, f(d) = 300d+1000;
	 * 
	 * The relationships between the parameters are easy to find out. Take f(d)
	 * as an example, 300 = f(a)+f(b)+f(c) when (a = b = c = 9 ), that is
	 * 1+19+280 = 300, which essentialy is the countDigitOne(999). 1000 =
	 * 101010, and 100c+10b+a is the value of number (cba).
	 * 
	 * With these relationships, a scan and accumulate from lowest digit can
	 * lead to the answer.
	 */
	public int countDigitOne(int n) {
		int remain;
		int accumulate = 0;
		int numIndex = 0;
		int factor = 1;
		int count = 0;
		while(n > 0){
			remain = n % 10;
			n /= 10;
			if(remain == 1){
				count += numIndex + accumulate + 1;
			} else if (remain > 1){
				count += remain * numIndex + factor;
			}
			accumulate += remain*factor;
			numIndex += 9 * numIndex + factor;
			factor *= 10;
		}
		return count;
	}
	
	public static void main(String[] args) {
		_20150929_NumberOfDigitOne test = new _20150929_NumberOfDigitOne();
		System.out.println(test.countDigitOne(14));
	}

}
