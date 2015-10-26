package algorithms.medium;

/* Implement next permutation, 
 * which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order 
(ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. 
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1 

 */

/* Chris Huang thought the algorithm, I implemented it all by myself, after step by step debugging. */

public class _20150916_NextPermutation_revisit {
	public static void nextPermutation(int[] num) {
		int len = num.length;
		for(int key : num){
			System.out.print(key + " ");
		}
		System.out.println();
		int i;
		for( i = len - 1; i >= 1; i--){
			if(num[i] <= num[i-1]){
				//do nothing
			}
			else{
				/* when we meet the element that is smaller than its previous one, then we jump out of the loop */
				break;
			}
		}
		/* Now we sort the sub-array starting from index i */
		int tempi = i;
		System.out.println("tempi = " + tempi);
		for(i = i + 1; i < len; i++){
			for(int j = i; j > tempi; j--){
				if(num[j] < num[j-1]){
					int temp = num[j];
					num[j] = num[j-1];
					num[j-1] = temp;
				}
				for(int k = 0; k < len; k++){
					System.out.print(num[k] + " ");
				}
				System.out.println();
			}
		}
		/* Now we need to find the first element that is greater than num[tempi - 1]
		 * and then exchange them */
		if(tempi == 0 && num[0] == num[len-1]){
			/* when tempi equals zero and all the elements are equal, we execute the following code */
			for(int j = tempi; j < len; j++){
				if(num[j] > num[tempi]){
					int temp = num[j];
					num[j] = num[tempi];
					num[tempi] = temp;
					break;
				}
			}
		}
		else if(tempi == 0){
			/* when tempi equals zero, but the elements are not equal, this means that all the
			 * elements are in non-increasing order, after the above code, it's already sorted in
			 * non-decreasing order, so we don't need to do anything here. */

			//do nothing

		}
		else {
			for(int j = tempi; j < len; j++){
				if(num[j] > num[tempi-1]){
					int temp = num[j];
					num[j] = num[tempi-1];
					num[tempi-1] = temp;
					break;
				}
			}
		}

		System.out.println("\nThe final num[] is ");
		for(int j = 0; j < len; j++){
			System.out.print(num[j] + " ");
		}
	}

	public static void main(String[] args){
		int [] num = new int[]{3, 2, 1, 1, 1, 1};
		nextPermutation(num);
	}
}