package algorithms.medium;

/* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). */

/* A dp problem, I completely copied from online. */


import java.util.*;
public class _20150916_Triangle_revisit {
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int rowLen = triangle.size();
		System.out.println("rowLen = triangle.size() = " + rowLen);
		//dp array, used to store the most optimal solution of each row
		int[][] sum = new int[rowLen][rowLen];
		
		//now let's deal with the last row of the triangle
		ArrayList<Integer> last = triangle.get(triangle.size()-1);
		for(int i = 0; i < last.size(); i++){
			sum[rowLen-1][i] = last.get(i);
		}
		
		//bottom-up dp, from the last second row up to the first row
		for(int i = rowLen-2; i >= 0; i--){
			ArrayList<Integer> row = triangle.get(i);
			for(int j = 0; j <= i; j++){
				sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + row.get(j);
				/* this line actually calculates the minimum sum of each spot, formed by the spot
				 * itself, one of the two spots only one level below itself and whichever is smaller,
				 * and then store this sum into its spot, i.e. sum[i][j]. 
				 * As a result, in the end, the array sum[i][j] stores all the minimum path for its
				 * own spot. Thus, after the two for loops, we return sum[o][0]. */
			}
		}
		
		return sum[0][0];
	}
	public static void main(String args[]){
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(2);
		triangle.add(row1);
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(3);
		row2.add(4);
		triangle.add(row2);
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		row3.add(6);
		row3.add(5);
		row3.add(8);
		triangle.add(row3);
		ArrayList<Integer> row4 = new ArrayList<Integer>();
		row4.add(4);
		row4.add(1);
		row4.add(8);
		row4.add(3);
		triangle.add(row4);
		System.out.println(minimumTotal(triangle));
		System.out.println("Program finished.");
	}
}
