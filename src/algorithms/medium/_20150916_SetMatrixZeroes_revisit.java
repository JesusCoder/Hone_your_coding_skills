package algorithms.medium;

/** Leetcode: Given a m x n matrix, if an 
 * element is 0, set its entire row and column to 0. Do it in place. */

/** Not a new problem, solved the same one before, implemented all by myself again!
 * Very fast to have done it! */

public class _20150916_SetMatrixZeroes_revisit {
	public static void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] zero = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					zero[i][j] = true;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (zero[i][j] == true) {
					for (int m = 0; m < row; m++) {
						matrix[m][j] = 0;
					}
					for (int n = 0; n < col; n++) {
						matrix[i][n] = 0;
					}
				}
			}
		}

		for (int i = 0; i < row; i++) {
			System.out.println();
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j]);
			}
		}

	}

	public static void main(String args[]) {
		int[][] mat = new int[][] { 
				{ 1, 2, 3, 0, 4, 5, },
				{ 1, 2, 4, 9, 8, 0, }, 
				{ 3, 4, 1, 9, 8, 3, },
				{ 9, 8, 0, 1, 2, 3, }, 
				};
		setZeroes(mat);
	}
}
