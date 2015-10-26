package algorithms.hard;

/*Leetcode: Given a 2D binary matrix filled 
 *with 0's and 1's, find the largest rectangle 
 *containing all ones and return its area.*/

/* I'm half way there for this problem, but cannot get the correct area.
 * I used the algorithm from GeeksforGeeks, but it actually turned out to be
 * a buggy algorithm! Bummer!
 * I can locate the point where it is the rightmost and bottom-most point, but cannot
 * based on this information, return the biggest sub-matrix. */

public class _20150916_MaximalRectangle_revisit {
	public static int maximalRectangle(char[][] matrix) {
		int height = matrix.length;
		if (height == 0)
			return 0;
		else {
			int width = matrix[0].length;
			// System.out.println(width + " " + height);

			if (height == 1 && width == 1) {
				if (matrix[0][0] == '1')
					return 1;
				else
					return 0;
			} else {

				/* convert this char matrix into int matrix */
				int[][] mat = new int[height][width];
				for (int i = 0; i < height; i++)
					for (int j = 0; j < width; j++) {
						mat[i][j] = Character.getNumericValue(matrix[i][j]);
						System.out.print(mat[i][j] + " ");
						if (j + 1 == width)
							System.out.println();
					}

				int[][] temp = new int[height][width];
				/* assign the first row into temp */
				for (int i = 0; i < width; i++) {
					temp[0][i] = mat[0][i];
					// System.out.print(temp[0][i] + " ");
				}
				// System.out.println();

				/* assign the first column into temp */
				for (int i = 1; i < height; i++) {
					// System.out.print(matrix[i][0] + " ");
					temp[i][0] = mat[i][0];
					// System.out.print(temp[i][0] + " ");
				}

				/*
				 * here's the juicy part of this algorithm: if mat[i][j] is 0,
				 * then assign 0 into temp[i][j] if mat[i][j] is 1, then assign
				 * min(mat[i-1][j], mat[i][j-1], mat[i-1][j-1]) into temp[i][j]
				 */
				for (int i = 1; i < height; i++)
					for (int j = 1; j < width; j++) {
						if (mat[i][j] == 0) {
							temp[i][j] = 0;
						} else {
							int c = min(temp[i - 1][j], temp[i][j - 1],
									temp[i - 1][j - 1]);
							// int d = Character.getNumericValue(c);
							// d = d + 1;
							// c = (char) d;
							temp[i][j] = c + 1;
						}
					}

				/* print out this temp matrix for testing */
				for (int i = 0; i < height; i++)
					for (int j = 0; j < width; j++) {
						System.out.print(temp[i][j] + "\t");
						if (j + 1 == width)
							System.out.println();
					}

				int row = 0, col = 0;/*
									 * use these two variables to mark the row
									 * and column of the max point
									 */
				int max = temp[0][0];
				for (int i = 0; i < height; i++)
					for (int j = 0; j < width; j++) {
						// System.out.println(max);
						if (max <= temp[i][j]) {
							row = i;
							col = j;
							max = temp[i][j];
							// System.out.println(row + " " + col + " " + max);
						}
					}
				System.out.println("row: " + row);
				System.out.println("col: " + col);
				System.out.println("max: " + max);
				int area = (row - max) * (col - max);
				return area;
			}
		}
	}

	public static int min(int c1, int c2, int c3) {
		int res = c1;
		if (c2 < res)
			res = c2;
		if (c3 < res)
			res = c3;
		return res;
	}

	public static void main(String args[]) {
		char[][] matrix = new char[][] {
				// {'0', '0'},
				{ '0', '1', '1', '0', '1' }, { '1', '1', '0', '1', '0' },
				{ '0', '1', '1', '1', '0' }, { '1', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '0' }, { '0', '0', '0', '0', '0' }, };
		// System.out.println(matrix[0][0]);
		System.out.println(maximalRectangle(matrix));
		// System.out.println(min('g', 'f', 'z'));
	}
}
