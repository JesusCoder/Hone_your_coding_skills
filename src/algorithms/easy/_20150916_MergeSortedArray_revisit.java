/**
 * 
 */
package algorithms.easy;

/* I implemented this program based on methods from online and it got accepted on Leetcode. */

/* Given two sorted integer arrays A and B, 
 * merge B into A as one sorted array.
Note:
You may assume that A has enough space to hold 
additional elements from B. The number of elements 
initialized in A and B are m and n respectively. */

public class _20150916_MergeSortedArray_revisit {
	public static void merge(int A[], int m, int B[], int n) {
		int i = m-1, j = n-1, k = m+n-1;
		while(k >= 0){
			if(i == -1){
				A[k--] = B[j--];
				continue;
			}
			if(j == -1){
				A[k--] = A[i--];
				continue;
			}
			if(A[i] >= B[j]){
				A[k--] = A[i--];
			}
			else{
				A[k--] = B[j--];
			}
		}
		for(int p = 0; p < m + n; p++){
			System.out.print(A[p]);
		}
	}
	public static void main(String args[]){
		/* test case 1: */
//		int [] A = new int[7];
//		A[0] = 1;
//		A[1] = 2;
//		A[2] = 3;
//		int [] B = new int[]{4, 5, 6};
		
		
		/* test case 2: */
//		int [] A = new int[7];
//		A[0] = 7;
//		A[1] = 8;
//		A[2] = 9;
//		int [] B = new int[]{1, 2, 3};
		
		
		/* test case 3: */
//		int [] A = new int[7];
//		A[0] = 1;
//		A[1] = 2;
//		A[2] = 6;
//		A[3] = 7;
//		int [] B = new int[]{3, 4, 5};
		
		
		//test case 4:
//		int [] A = new int[7];
//		A[0] = 6;
//		A[1] = 7;
//		A[2] = 8;
//		A[3] = 9;
//		int [] B = new int[]{3, 4, 5};
		
		//test case 5:
		int [] A = new int[7];
		int [] B = new int[]{1};
		
		for(int i = 0; i < A.length; i++){
			System.out.print(A[i]);
		}
		System.out.println();
		for(int i = 0; i < B.length; i++){
			System.out.print(B[i]);
		}
		System.out.println();
		merge(A, 0, B, 1);
		System.out.print("\nProgram finished.");
	}
}

