package algorithms.medium;

/* I simply copied this algorithm online, word by word, didn't code for quite a while, this is the
 * first program after the finals are over. */

/* Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path. Note: You can only 
 * move either down or right at any point in time. */

public class _20150916_MinimumPathSum_revisit {
	public static int minPathSum(int[][] grid) {
		int[][] sums = new int[grid.length][grid[0].length];
		sums[0][0] = grid[0][0];
		for (int i = 1; i < grid.length; i++) {
			sums[i][0] = grid[i][0] + sums[i - 1][0];
		}
		for (int j = 1; j < grid[0].length; j++) {
			sums[0][j] = grid[0][j] + sums[0][j - 1];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				sums[i][j] = Math.min(sums[i - 1][j], sums[i][j - 1]
						+ grid[i][j]);
			}
		}
		return sums[grid.length - 1][grid[0].length - 1];
	}

	public static void main(String args[]) {
		int[][] grid = { { 1, 2 }, { 1, 1 } };
		System.out.println(minPathSum(grid));
		System.out.println("Program finished.");
	}
}
