/**
 * 
 */
package algorithms.easy;

/** Leetcode: Given an array and a value, remove all instances 
 * of that value in place and return the new length. 
 * The order of elements can be changed. 
 * It doesn't matter what you leave beyond the new length.*/


public class _20150916_RemoveElement_revisit {

	public static void main(String args){
		int [] a = new int[]{1, 2, 3, 4, 1, 4, 5, 1, 5, 5, 6, 7};
		System.out.println(removeElement(a, 1));
	}
	
	/** My own original algorithm didn't work out, so I used the algorithm online:
	 * traverse the original array, copy each element that is different from "elem". */
	public static int removeElement(int[] A, int elem) {
		int len = A.length;
		int counter = 0;
		for(int i = 0; i < len; i++){
			if(A[i] != elem){
				A[counter] = A[i];
				counter++;
			}
		}
		return counter;
	}
}


