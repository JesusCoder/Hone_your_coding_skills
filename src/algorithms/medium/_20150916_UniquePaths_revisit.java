package algorithms.medium;

/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there? */

/* This is the same problem as we did in Cracking robot moving. 
 * 
 * The algorithm is, as long as the robot goes to the left-most or the bottom lines, then there's only one
 * path to the finish point. */

/* Hooray, I implemented this code all by myself! Wonderful!
 * You must use an array to record this, otherwise it will absolutely exceed the time limit!
 * In this way, it's much more efficient! */

public class _20150916_UniquePaths_revisit {
	public static int uniquePaths(int m, int n) {
		int [][] path = new int[m+1][n+1];
		System.out.println("m = " + m + "\tn = " + n);
		if(m == 1 || n == 1){
			return path[m][n] = 1;
		}
		else{
			for(int p = 1; p <= m; p++){
				for(int q = 1; q <= n; q++){
					if(p == 1 || q == 1){
						path[p][q] = 1;
					}
				}
			}
			int i = 2, j = 2;
			for(; i <= m; i++){
				j = 1;
				for(; j <= n; j++){
					path[i][j] = path[i-1][j] + path[i][j-1];
					System.out.println("path[" + i + "][" + j + "] = " + path[i][j] + " = " + path[i-1][j] + " + " + path[i][j-1] );
				}
			}
			return path[i-1][j-1];
		}		
	}
	public static void main(String args[]){
		System.out.println(uniquePaths(2, 2));
	}
}
