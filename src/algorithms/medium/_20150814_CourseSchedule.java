package algorithms.medium;

import java.util.HashSet;

/**
 * Used the solution from discuss:
 * https://leetcode.com/discuss/34694/my-java-dfs-solution Didn't fully
 * understand it.
 * 
 * It involves topological sort.
 */
public class _20150814_CourseSchedule {

	public static void main(String[] args) {
		// int numCourses = 2;
		// int[][] prerequisites = new int[][] { { 1, 0 } };
		// int numCourses = 2;
		// int[][] prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
		int numCourses = 3;
		int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 0 }, { 1, 2 } };
		System.out.println(canFinish(numCourses, prerequisites) + "\nThe end.");
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0)
			return true;
		int n = numCourses;
		HashSet<Integer>[] graph = new HashSet[n];
		for (int i = 0; i < n; i++)
			graph[i] = new HashSet<>();
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}
		boolean[] visited = new boolean[n];
		boolean[] visiting = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (!dfs(i, visited, visiting, graph))
					return false;
			}
		}
		return true;
	}

	private static boolean dfs(int i, boolean[] visited, boolean[] visiting,
			HashSet<Integer>[] graph) {
		if (visiting[i])
			return false;
		visiting[i] = true;
		for (Integer j : graph[i]) {
			if (!visited[j]) {
				if (!dfs(j, visited, visiting, graph))
					return false;
			}
		}
		visiting[i] = false;
		visited[i] = true;
		return true;
	}
}
