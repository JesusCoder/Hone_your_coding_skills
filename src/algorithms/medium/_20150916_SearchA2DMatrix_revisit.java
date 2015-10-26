package algorithms.medium;

/** Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.*/

public class _20150916_SearchA2DMatrix_revisit {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int N = matrix.length;// # of rows in this matrix
		int M = matrix[0].length;// # of elements in each row
		if (N == 0)
			return false;
		else if (N == 1) {
			if (matrix[0][0] == target)
				return true;
			else if (matrix[0][0] > target)/*
											 * the smallest number in this
											 * matrix is greater than target
											 */
				return false;
			else if (target > matrix[0][M - 1])/*
												 * the largest number in this
												 * matrix is smaller than target
												 */
				return false;
			else
				for (int j = 0; j < M; j++) {
					if (matrix[0][j] == target)
						return true;
					else if (j == M - 1)
						return false;
				}
		} else// N is greater than 1, i.e. there're at least two rows in this
				// matrix

		{/* first check the first row */
			if (matrix[0][0] > target)/*
									 * the smallest number in this matrix is
									 * greater than target
									 */
				return false;
			else {/*
				 * if the target is found in the first row, then return true
				 * directly, otherwise continue
				 */
				for (int j = 0; j < M; j++) {
					if (matrix[0][j] == target)
						return true;
				}/*
				 * if target is not found in the fist row, the following code
				 * will be executed
				 */
				for (int i = 1; i < N;) {
					if (target == matrix[i][0])// check the first element of row
												// i
						return true;
					else if (target == matrix[i][M - 1])// check the last
														// element of row i
						return true;
					else if (target < matrix[i][M - 1]) {// if target is less
															// than the largest
															// in row i
						for (int j = 0; j < M; j++) {// then we traverse row i
							if (matrix[i][j] == target)
								return true;
							else if (j == M - 1)
								return false;
						}
					} else if (target > matrix[i][M - 1]) {// if target is
															// greater than the
															// largest of row i
						i++;
					}
				}
			}
			return false;
		}
		return false;
	}

	public static void main(String args[]) {
		int[][] matrix = new int[3][4];
		matrix[0][0] = 1;
		matrix[0][1] = 3;
		matrix[0][2] = 5;
		matrix[0][3] = 7;
		matrix[1][0] = 10;
		matrix[1][1] = 11;
		matrix[1][2] = 16;
		matrix[1][3] = 20;
		matrix[2][0] = 23;
		matrix[2][1] = 30;
		matrix[2][2] = 34;
		matrix[2][3] = 50;
		// System.out.println(matrix.length);
		// System.out.println(matrix[0].length);
		System.out.println(searchMatrix(matrix, 23));
	}
}
