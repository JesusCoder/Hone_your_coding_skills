/**
 * 
 */
package algorithms.easy;

import java.util.ArrayList;

/*  Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */

/* I finished this problem all by myself, pretty soon. Nice done! */

public class _20150916_PascalsTriangle_revisit {
	public static// void
	ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0) {
			return outer;
		} else if (numRows == 1) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(1);
			outer.add(row);
		} else if (numRows == 2) {
			ArrayList<Integer> row1 = new ArrayList<Integer>();
			row1.add(1);
			outer.add(row1);
			ArrayList<Integer> row2 = new ArrayList<Integer>();
			row2.add(1);
			row2.add(1);
			outer.add(row2);
		}

		else {/* when numRows is greater than 2 */

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

			for (int i = 2; i < numRows; i++) {
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
		return outer;
		// for(ArrayList i : outer){
		// System.out.println(i);
		// }
	}

	public static void main(String args[]) {
		System.out.print(generate(6));
	}
}

