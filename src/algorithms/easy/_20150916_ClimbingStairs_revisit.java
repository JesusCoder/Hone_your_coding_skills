/**
 * 
 */
package algorithms.easy;

/**
 * I implemented this code (similar to the one that I did before on Cracking),
 * but it exceeded time limit on Leetcode when n is a little bit large, say 44.
 * 
 * I'll have to redo it, using REAL dynamic programming method. (This one is
 * actually recursive.)
 */
public class _20150916_ClimbingStairs_revisit {
	public static int climbStairs(int n) {
		int ways = 0;
		if (n <= 0)
			ways = 0;
		else if (n == 1)
			ways = 1;
		else if (n == 2)
			ways = 2;
		else if (n == 3)
			ways = 3;
		else
			ways = climbStairs(n - 1) + climbStairs(n - 2);

		return ways;
	}

	public static void main(String... args) {
		System.out.println(climbStairs(15));
		System.out.print("Program ended.");
	}
}
