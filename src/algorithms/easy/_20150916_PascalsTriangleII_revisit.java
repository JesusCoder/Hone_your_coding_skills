/**
 * 
 */
package algorithms.easy;

import java.util.ArrayList;

/*  Given rowIndex, generate the first rowIndex of Pascal's triangle.

For example, given rowIndex = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

 */

/* Nice, I quickly finished this problem based on my solution for PascalTriangle.java,
 * just modified a little bit. Great job! */

public class _20150916_PascalsTriangleII_revisit {
	public static// void
	ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		if (rowIndex == 0) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(1);
			outer.add(row);
			return outer.get(0);
		} else if (rowIndex == 1) {
			ArrayList<Integer> row1 = new ArrayList<Integer>();
			row1.add(1);
			outer.add(row1);
			ArrayList<Integer> row2 = new ArrayList<Integer>();
			row2.add(1);
			row2.add(1);
			outer.add(row2);
		} else {/* when rowIndex is greater than 1 */

			/*
			 * first initialize the first two rows, then start from the third
			 * row, use for loop to finish it
			 */

			ArrayList<Integer> row1 = new ArrayList<Integer>();
			row1.add(1);
			outer.add(row1);// outer[0]
			ArrayList<Integer> row2 = new ArrayList<Integer>();
			row2.add(1);
			row2.add(1);
			outer.add(row2);// outer[1]
			/* the above code block initializes the first two rows */

			for (int i = 2; i < rowIndex + 1; i++) {
				ArrayList<Integer> row = new ArrayList<Integer>();
				row.add(1);
				for (int j = 1; j < i; j++) {// there are N numbers on the Nth
												// row
					row.add(outer.get(i - 1).get(j)
							+ outer.get(i - 1).get(j - 1));
				}
				row.add(1);
				outer.add(row);// outer[i]
			}
		}
		return outer.get(rowIndex);
		// for(ArrayList i : outer){
		// System.out.println(i);
		// }
	}

	public static void main(String args[]) {
		System.out.print(getRow(6));
	}
}

