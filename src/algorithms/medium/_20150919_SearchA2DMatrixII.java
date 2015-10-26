package algorithms.medium;

/**Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.*/

public class _20150919_SearchA2DMatrixII {
//give up my own solution, cannot think it thru
	//	public static boolean searchMatrix(int[][] matrix, int target) {
//		int i = 0, j = 0;
//		for(; i < matrix.length; i++){
//			for(; j < matrix[0].length; j++){
//				if(target < matrix[i][matrix[0].length-1] && target > matrix[i][0]){
//					//search in this row
//				} else {
//					//check this j column's range then
//					break;
//				}
//			}
//			if(target < matrix[i][j] && target > matrix[i][j]){
//				
//			}
//		}
//	}

	/**
	 * copied this solution from discuss, looks very elegant and concise. This
	 * turns out to be a very smart algorithm, it fully utilizes the sorted
	 * properties of this matrix after I stepping thru it. it uses x and y as
	 * coordinates, always check the right-most column first, then decide its
	 * next step. Cool!
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0;
		int y = n - 1;
		while (x < m && y >= 0) {
			if (target == matrix[x][y]) {
				return true;
			} else if (target > matrix[x][y]) {
				x++;
			} else {
				y--;
			}
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
		/**
		 * 1 , 3 , 5 , 7
		 * 10, 11, 16, 20
		 * 23, 30, 34, 50
		 * */
		// System.out.println(matrix.length);
		// System.out.println(matrix[0].length);
		_20150919_SearchA2DMatrixII test = new _20150919_SearchA2DMatrixII();
		System.out.println(test.searchMatrix(matrix, 24));
	}
}
