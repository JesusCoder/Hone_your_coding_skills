package algorithms.medium;

/* Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100. */

/* Very excited! I implemented this code completely by myself! And I made it accepted on Leetcode!
 * Now the time is 1:52 am of Jan.28.2014, I'm still in the Biomedical library, this is the vintage moment!
 * I love programming! */

public class _20150916_UniquePathsII_revisit {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int height = obstacleGrid.length;
		int width = obstacleGrid[0].length;
		int paths = 0;
		System.out.println("width = " + width + "\theight = " + height);
		if(height == 0 || width == 0){
			paths = 0;
		}
		else if(height == 1 && width == 1){
			if(obstacleGrid[0][0] == 1){
			paths = 0;
			}
			else{
				paths = 1;
			}
		}
		else{
			int[][] path = new int[height][width];
			/* this 2-d array is used to indicate the number of unique paths possible from
			 * start to reach this point */
		
			for(int i = 0; i < width; i++){
				if(obstacleGrid[0][i] == 0){
					path[0][i] = 1;
				}
				else{
					for(; i < width; i++){
						System.out.println(i);
						path[0][i] = 0;
					}
				}
			}
			for(int i = 0; i < height; i++){
				if(obstacleGrid[i][0] == 0){
					path[i][0] = 1;
				}
				else{
					for(;i < height; i++){
						path[i][0] = 0;	
					}
				}
			}
			/*print this path out just for testing*/
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j++){
					System.out.print(path[i][j] 
							//+ "\ti = " + i + "\tj = " + j + "\n"
							);
				}
				System.out.println();
			}
			System.out.println();
			/************************************/
		
			
			
			/* after setting the leftmost column and the topmost row, let's start to tackle the core
			 * part of this grid. */
			
			/* It's possible that when there's ONLY one column or one row,
			 * it won't execute the double for loops, so I'll have to assign the last element of
			 * path[][] to the final result. */
			paths = path[height-1][width-1];
			
			
			/* When both the height or the width are higher than 1, the following code will
			 * be executed. */
			for(int i = 1; i < height; i++){		
				for(int j = 1; j < width; j++){
					if(obstacleGrid[i][j] == 0){
						path[i][j] = path[i-1][j] + path[i][j-1];
					}
					else{
						/* do nothing here, you MUST NOT break;
						 * here, because this goes row-wise, I put break;
						 * statement here, then test case 7 won't pass, because
						 * path[1][2] will never be 1 which it should be! */
					}
				}
			}
			paths = path[height-1][width-1];

			/*print this path out just for testing*/
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j++){
					System.out.print(path[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			/************************************/
		}


		return paths;
	}
	public static void main(String args[]){
		//test case 1:
//				int[][] obstacleGrid = new int[][]{
//					{0, 0, 1, 0},
//					{0, 1, 0, 0},
//					{0, 0, 0, 0},
//					{0, 0, 0, 0}
//				};

		//test case 2:
//				int[][] obstacleGrid = new int[][]{
//						{0, 0},
//					};

		//test case 3:
//				int[][] obstacleGrid = new int[][]{
//						{0, 0, 1, 0, 1},
//						{0, 1, 0, 0, 0},
//						{0, 0, 0, 0, 0},
//					};

		//test case 4:
//				int[][] obstacleGrid = new int[][]{
//				{0, 0, 0, 0, 0, 0}
//				};

		//test case 5:
//		int[][] obstacleGrid = new int[][]{
//				{0},
//				{0},
//				{0},
//				{0},
//		};
		
		//test case 6:
//		int[][] obstacleGrid = new int[][]{
//				{0},
//			};
		
		//test case 7:
		int[][] obstacleGrid = new int[][]{
			{0, 0, 0},
			{0, 1, 0},
			{0, 0, 0}
		};

		
System.out.println(uniquePathsWithObstacles(obstacleGrid));
}
}
