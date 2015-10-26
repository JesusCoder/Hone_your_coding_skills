/**
 * 
 */
package algorithms.medium;

/**
 * @author jiahuan
 *
 */
public class _20150913_PerfectSquares {

	/** recursive solution. copied from discuss board:
	 I found it very hard to follow this algorithm since I didn't think about
	 it, I used debug mode to step thru it, find it hard to come up with an
	 algorithm like this
	 */
//	public static int numSquares(int n) {
//		int result = n, num = 2;
//		while (num * num <= n) {
//			int temp1 = n / (num * num), temp2 = n % (num * num);
//			result = Math.min(result, temp1 + numSquares(temp2));
//			num++;
//		}
//		return result;
//	}
	
	/**iterative solution, also copied from discuss board:
	 The key for understanding this algorithm is this inner for loop: 
	 for (int j = 1; j <= i / 2; j++) {
					result[i] = Math.min(result[i], result[j] + result[i - j]);
				}
	which I ran out of patience to fully understand it. Need to come back and re-visit.
	 */
	public static int numSquares(int n) {
		int count = 1;
		int[] result = new int[n + 1];
		if (n <= 0) {
			return 0;
		}

		for (int i = 1; i <= n; i++) {
			if (count * count == i) {
				result[i] = 1;
				count += 1;
			} else {
				result[i] = n;
				for (int j = 1; j <= i / 2; j++) {
					result[i] = Math.min(result[i], result[j] + result[i - j]);
				}
			}
		}
		return result[n];
	}
	
	public static void main(String[] args) {
		System.out.println(numSquares(24));
	}

}
