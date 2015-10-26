package algorithms.medium;

/** Leetcode: 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

/** Cool, it's awesome! I made it this one all by myself! I went thru all the frustrating and
 * desperating debugging process again, didn't ask any one for help!
 * I was even hesitating if my algorithm is correct or not! But I persisted and won!
 * 
 * Thank you God! 
 * */

public class _20150916_SpiralMatrixII_revisit {

	public static int[][] generateMatrix(int num){
		int temp = num;
		int fourEdges[][] = new int[num][num];
		int  value = 1;
		int i = 0, j = 0;
		if(num%2 == 0)//when num is even
		{
			while(i < num/2 && j < num/2 && temp >= 0)
			{
				//System.out.println(num/2 + " " + temp);
				
				/* Assign the top row */
				while(j < temp)
				{
					fourEdges[i][j] = value;
					//System.out.println(i + "," + j + ":" + fourEdges[i][j]);
					j++;
					value++;

				}
				
				/* Assign the right column */
				while(i < temp - 1){
					i++;
					fourEdges[i][j - 1] = value;
					//System.out.println(i + "," + (j-1) + ":" + fourEdges[i][j-1]);
					value++;
				}
				j = j - 2;
				
				/* Assign the bottom row */
				while(j >= num - temp){
					fourEdges[i][j] = value;
					//System.out.println(i + "," + j + ":" + fourEdges[i][j]);
					j--;
					value++;
				}
				i--;
				j++;
				
				/* Assign the left column */
				while(i > num - temp){
					fourEdges[i][j] = value;
					//System.out.println(i + "," + j + ":" + fourEdges[i][j]);
					i--;
					value++;
				}
				//}
				i++;
				j++;
				temp--;
				//System.out.print("i: " + i + " j: " + j + " value: " + value + "\n");
			}	

		}
		else//when num is odd
		{
			while(i < num/2 && j < num/2 && temp >= 0)
			{
				//System.out.println(num/2 + " " + temp);
				
				/* Assign the top row */
				while(j < temp)
				{
					fourEdges[i][j] = value;
					//System.out.println(i + "," + j + ":" + fourEdges[i][j]);
					j++;
					value++;

				}
				
				/* Assign the right column */
				while(i < temp - 1){
					i++;
					fourEdges[i][j - 1] = value;
					//System.out.println(i + "," + (j-1) + ":" + fourEdges[i][j-1]);
					value++;
				}
				j = j - 2;
				//System.out.println();
				
				/* Assign the bottom row */
				while(j >= num - temp){
					fourEdges[i][j] = value;
					//System.out.println(i + "," + j + ":" + fourEdges[i][j]);
					j--;
					value++;
				}
				i--;
				j++;
				
				/* Assign the left column */
				while(i > num - temp){
					fourEdges[i][j] = value;
					//System.out.println(i + "," + j + ":" + fourEdges[i][j]);
					i--;
					value++;
				}
				//}
				i++;
				j++;
				temp--;
				//System.out.print("i: " + i + " j: " + j + " value: " + value + "\n");
			}	
			fourEdges[num/2][num/2] = num*num;
		}

		for(int m = 0; m < num; m++){
			for(int n = 0; n < num; n++){
				System.out.print(fourEdges[m][n] + "\t");
				if((n+1) % num == 0)
					System.out.println();
			}
		}
		return fourEdges;
	}

	public static void main(String args[]){
		generateMatrix(10);
		//	System.out.print(generateMatrix(5));
	}
}
