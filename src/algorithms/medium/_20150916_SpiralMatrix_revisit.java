package algorithms.medium;

import java.util.*;
/** Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5]. */

/** Hooray! I solved this problem all by myself! After debugging step by step, hooray! 
 * Without any help from others or online. 
 * 
 * In retrospect, this one turns out to be the first one of my Amazon internship interview question! Praise the Lord!
 * Thus, all in all, must really sit down and think thru each algorithm problem, only in this way, I could crack the coding interview!*/

public class _20150916_SpiralMatrix_revisit {
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList();
		int row = matrix.length;

		if(row == 0){
			return res;
		}
		int col = matrix[0].length;
		int len = row*col;
		System.out.println("row = " + row + "\tcol = " + col + "\tlen = " + len);

		int i = 0, j = 0, rowStart = 1, colStart = 0;
		while(res.size() <= len){
			for(; j < col; j++){
				res.add(matrix[i][j]);				
			}
			if(res.size() == len)
				break;
			col--;
			j--;
			i++;
			System.out.println("i = " + i + "\tj = " + j + "\tcol = " + col + "\trow = " + row + "\trowStart = " + rowStart + "\tcolStart = " + colStart);
			System.out.println(res);
			for(; i < row; i++){
				res.add(matrix[i][j]);
			}
			if(res.size() == len)
				break;
			row--;
			i--;
			j--;
			System.out.println("i = " + i + "\tj = " + j + "\tcol = " + col + "\trow = " + row + "\trowStart = " + rowStart + "\tcolStart = " + colStart);
			System.out.println(res);
			for(; j >= colStart; j--){
				res.add(matrix[i][j]);
			}
			if(res.size() == len)
				break;
			colStart++;
			j++;
			i--;
			System.out.println("i = " + i + "\tj = " + j + "\tcol = " + col + "\trow = " + row + "\trowStart = " + rowStart + "\tcolStart = " + colStart);
			System.out.println(res);
			for(; i >= rowStart; i--){
				res.add(matrix[i][j]);
			}
			if(res.size() == len)
				break;
			rowStart++;
			i ++;
			j++;
			System.out.println("i = " + i + "\tj = " + j + "\tcol = " + col + "\trow = " + row + "\trowStart = " + rowStart + "\tcolStart = " + colStart);
			System.out.println(res);
		}
		System.out.print(res);
		return res;
	}
	public static void main(String args[]){
		int [][] mat = new int[][]{
				{ 1,	2,	3,	4,	5,	6 },
				{ 7,	8,	9,	10,	11,	12},
				{ 13,	14,	15,	16,	17,	18},
				{ 19,	20,	21,	22,	23,	24}
	};
		int [][] mat2 = new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int [][] mat3 = new int[][]{
		};
		System.out.print(spiralOrder(mat));
	}
}
