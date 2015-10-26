package algorithms.medium;

public class _20150814_DivideTwoIntegers {

	public static void main(String[] args) {
		int dividend = 12;
		int divisor = 12;
		System.out.println(divide(dividend, divisor) + "\nThe end.");
	}

	public static int divide(int dividend, int divisor) {
		// 特殊情况
		if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
			return Integer.MAX_VALUE;// 溢出
		if (dividend != Integer.MIN_VALUE
				&& Math.abs(dividend) < Math.abs(divisor))
			return 0;
		if (divisor == Integer.MIN_VALUE)
			return (dividend == Integer.MIN_VALUE) ? 1 : 0;
		//
		boolean flag = (dividend < 0) ^ (divisor < 0);// 被除数与除数是否异号
		dividend = -Math.abs(dividend);
		divisor = -Math.abs(divisor);
		int[] num = new int[40];
		int[] multiple = new int[40];
		num[1] = divisor;
		multiple[1] = 1;
		for (int i = 2; i < 32 && num[i - 1] < 0; ++i) {
			num[i] = num[i - 1] << 1;
			System.out.print("num[" + i + "]:" + num[i]);
			multiple[i] = multiple[i - 1] << 1;
			System.out.println("\tmultiple[" + i + "]" + multiple[i]);
		}
		int result = 0;
		int index = 1;
		while (num[index] < 0)
			++index;
		index -= 1;
		while (dividend <= divisor) {
			while (dividend <= num[index]) {
				result += multiple[index];
				dividend -= num[index];
			}
			--index;
		}
		return !flag ? result : -result;
	}
}
