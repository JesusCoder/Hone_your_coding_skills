/**
 * 
 */
package algorithms.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Used solution from online, need to digest this further. First off, I needed
 * to understand the problem in the first place, I don't think I know what it's
 * asking for.
 * 
 * @author SteveSun
 */
public class _20150814_NumberOfIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[][] grid1 = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		char[][] grid2 = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		System.out.println(numIslandsAlgorithm1(grid2) + "\nThe end!");
		// System.out.println(numIslandsAlgorithm2(grid2) +
		// "\nUsing calling algorithm 2, the end!");
	}

	private static int m;
	private static int n;

	public static int numIslandsAlgorithm1(char[][] grid) {
		m = grid.length;
		if (m == 0) {
			return 0;
		}
		/**
		 * This is a smart way to check edge case, also a very typical way to
		 * check on a 2-d array: check row first, if it's zero, we don't need to
		 * check column at all, this way, it also avoid null pointer exception.
		 */
		n = grid[0].length;
		if (n == 0) {
			return 0;
		}

		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != '1') {
					continue;
				}
				System.out.println("grid[" + i + "][" + j + "]: " + grid[i][j] + " is one island!");
				result++;
				dfs(grid, i, j);
			}
		}
		return result;
	}

	private static void dfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= m || j < 0 || j >= n) {
			return;
		}
		if (grid[i][j] == '1') {

			grid[i][j] = '2';
			printGrid(grid);

			dfs(grid, i - 1, j);
			printGrid(grid);

			dfs(grid, i + 1, j);
			printGrid(grid);

			dfs(grid, i, j - 1);
			printGrid(grid);

			dfs(grid, i, j + 1);
			printGrid(grid);
		}
	}

	private static void printGrid(char[][] grid) {
		System.out.println("\nThe grid now is as follows:");
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int numIslandsAlgorithm2(char[][] grid) {
		HashMap<Integer, HashSet<Integer>> allones = new HashMap<Integer, HashSet<Integer>>();
		int row = grid.length;
		if (row == 0) {
			return 0;
		}
		int col = grid[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					if (allones.containsKey(i)) {
						allones.get(i).add(j);
					} else {
						HashSet<Integer> values = new HashSet<Integer>();
						values.add(j);
						allones.put(i, values);
					}
				}
			}
		}
		int islandCnt = 0;
		while (allones.keySet().size() > 0) {
			int rid = allones.keySet().iterator().next();
			int cid = allones.get(rid).iterator().next();
			islandCnt++;
			removeOneisland(rid, cid, allones);

		}
		return islandCnt;
	}

	private static void removeOneisland(int rid, int cid, HashMap<Integer, HashSet<Integer>> allones) {
		if (allones.containsKey(rid)) {
			if (allones.get(rid).contains(cid)) {
				allones.get(rid).remove(cid);
				if (allones.get(rid).size() == 0) {
					allones.remove(rid);
				}
				removeOneisland(rid - 1, cid, allones);
				removeOneisland(rid + 1, cid, allones);
				removeOneisland(rid, cid - 1, allones);
				removeOneisland(rid, cid + 1, allones);
			}
		}
	}
}
