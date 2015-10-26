package algorithms.hard;

public class _20150814_MaximalRectangle {

	public static void main(String[] args) {
		char[][] matrix = { { '1', '1', '1' }, { '1', '0', '1' },
				{ '0', '1', '1' } };
		System.out.println(maximalRectangle(matrix) + "\nThe end.");
	}

	/**
	 * didn't even think again, used the solution from discuss:
	 * https://leetcode.com/discuss/23448/sharing-my-296ms-java-solution The
	 * author says this:
	 * 
	 * The idea is, to form a matrix x where each element indicates the next
	 * index of horizontal '1' before '0' or end (getX()), and another matrix y
	 * where each element indicates the index of next vertical '1' before '0' or
	 * end (getY()). E.g. 1 1 1 0 0 1 1 becomes 2 2 2 -1 -1 6 6.
	 * 
	 * Then, for each element [i][j], only [i+1][j+1], [i+2][j+2]... needs to be
	 * checked. The area can be easily computed by the indexes on x and y.
	 */

	public static int maximalRectangle(char[][] matrix) {
		int h = matrix.length;
		if (h == 0) {
			return 0;
		}
		int w = matrix[0].length;
		if (w == 0) {
			return 0;
		}

		int[][] x = getX(matrix, h, w);
		int[][] y = getY(matrix, h, w);

		int maxArea = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {

				int xIdx = x[i][j];
				int yIdx = y[i][j];

				int k = 0;
				while (k <= Math.min((xIdx - j), (yIdx - i))
						&& matrix[i + k][j + k] == '1') {

					xIdx = Math.min(xIdx, x[i + k][j + k]);
					yIdx = Math.min(yIdx, y[i + k][j + k]);

					if ((xIdx - j + 1) * (yIdx - i + 1) <= maxArea) {
						break;
					}

					int wArea = (k + 1) * (xIdx - j + 1);
					int hArea = (k + 1) * (yIdx - i + 1);
					if (wArea > maxArea) {
						maxArea = wArea;
					}
					if (hArea > maxArea) {
						maxArea = hArea;
					}

					k++;
				}

			}
		}

		return maxArea;
	}

	private static int[][] getX(char[][] matrix, int h, int w) {

		int[][] res = new int[h][w];

		for (int i = h - 1; i >= 0; i--) {
			int curr = -1;
			for (int j = w - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					if (curr == -1) {
						curr = j;
					}

				} else {
					curr = -1;
				}
				res[i][j] = curr;
			}
		}
		return res;
	}

	private static int[][] getY(char[][] matrix, int h, int w) {

		int[][] res = new int[h][w];

		for (int j = w - 1; j >= 0; j--) {
			int curr = -1;
			for (int i = h - 1; i >= 0; i--) {
				if (matrix[i][j] == '1') {
					if (curr == -1) {
						curr = i;
					}

				} else {
					curr = -1;
				}
				res[i][j] = curr;
			}
		}
		return res;
	}

}
