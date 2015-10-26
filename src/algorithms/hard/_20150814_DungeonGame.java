package algorithms.hard;

/**
 * @author SteveSun
 * Used the answer from online, need to digest further.
 */
public class _20150814_DungeonGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
		System.out.println(calculateMinimumHP(dungeon)+ "\nThe end!");

	}
	/**This is a question to find the minimum cost to go from top-left
	 * to bottom-right.
	 * Didn't think it thru, used a solution from discuss.*/
	public static int calculateMinimumHP(int[][] dungeon) {
		int w = dungeon[0].length;
		int [] dp = new int[w+1];
		//first we initialize this array with max values in java possible
		for(int x = 0; x < dp.length; x++){
			if(x != w-1){
				dp[x] = Integer.MAX_VALUE;
			}
		}
		
		//then we calculate the min health points from 
		for(int y = dungeon.length-1; y >= 0; y--){
			for(int x = w-1; x >= 0; x--){
				dp[x] = Math.max(0, Math.min(dp[x+1], dp[x]) - dungeon[y][x]);
				System.out.print("dp[" + x + "]:" + dp[x] + "    ");
			}
			System.out.println();
		}
		return dp[0] + 1;
	}
}
