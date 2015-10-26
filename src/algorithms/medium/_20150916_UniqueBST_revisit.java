package algorithms.medium;

/* Problem on Leetcode:
 * I completely copied the code from online but understood it with Rajat's help. Cool! */

public class _20150916_UniqueBST_revisit {
	public static int numTrees(int n) {
		return numTreesRec(1, n);
	}
	public static int numTreesRec(int begin, int end){
		if(begin >= end){
			return 1;
		}
		int cnt = 0;
		for(int i = begin; i <= end; i++){
			int leftNum = numTreesRec(begin, i-1);
			int rightNum = numTreesRec(i+1, end);
			cnt += leftNum*rightNum;
			/* the number of left unique BST multiplies the number of right unique BST, that is
			 * the number of total unique BST for the root of i, then we add them all up, that is
			 * cnt, thus, we return cnt. */
		}
		return cnt;
	}
	public static void main(String args[]){
		System.out.println(numTrees(7));
		System.out.println("Program finished.");
	}
}
