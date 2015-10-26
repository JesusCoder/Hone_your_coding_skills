package algorithms.hard;


/* Leetcode:
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * */

/* A very awesome problem, it helps me deepen my understanding of for loop.
 * Don't underestimate for loop, when you use && to combine multiple conditions there,
 * it's use to confuse yourself how for loop really executes.
 * 
 * when the second condition doesn't meet, it will jump out the for loop and never come back!
 * 
 * that's the key of a for loop, DO NOT forget that! */

/* Algorithm: Siyuan Song's idea:
 * From (y1-y2)/(x1-x2) = (y2-y3)/(x2-x3) we can get (y1-y2)*(x2-x3) = (x1-x2)*(y2-y3)
 * we MUST use the latter one to implement this algorithm, this way, we don't need to worry about
 * all the following issue:
 * when the slope doesn't exist, when the slope is infinite, the division in Java neglects fractional part,
 * all these problems! 
 * */

public class _20150916_MaxPointsOnALine_revisit {
	public static int maxPoints(Point[] points) {
		int max = 0;
		if (points.length == 0) {
			max = 0;
		} else if (points.length == 1) {
			max = 1;
		} else if (points.length == 2) {
			max = 2;
		} else if (points.length == 3) {
			max = 2;
			if ((points[0].x - points[1].x) * (points[1].y - points[2].y) == (points[0].y - points[1].y)
					* (points[1].x - points[2].x)) {
				max++;
			}
		} else {
			int maxPoints[][] = new int[points.length][points.length];
			for (int i = 0; i < points.length; i++) {
				for (int j = 0; j < points.length && j != i; j++) {
					maxPoints[i][j] = 2;
					// System.out.print(maxPoints[i][j] + " ");
				}
			}

			for (int i = 0; i < points.length; i++) {
				for (int j = 0; (j < points.length) && (j != i); j++) {
					if (((points[i].x == points[j].x) && (points[i].y == points[j].y))) {
						for (int k = 0; (k < points.length); k++) {
							if ((k != i) && (k != j)) {
								if (((points[k].x == points[i].x) && (points[k].y == points[i].y))) {
									maxPoints[i][j]++;
								}
							}
						}
					} else
						for (int k = 0; (k < points.length); k++)
						/*
						 * Here, I must put the judgment (k!=i) && (k!=j) in the
						 * if statement instead of in the for, otherwise, when k
						 * equals i or j, it will stop traversing the rest of
						 * the points that k represents!
						 * 
						 * This is the key to solving this problem and Siyuan
						 * Song helped me spot this error!
						 * 
						 * It took me an hour and couldn't find any clue!
						 */
						{
							if ((k != i) && (k != j)) {
								if (((points[k].x == points[i].x) && (points[k].y == points[i].y))) {
									maxPoints[i][j]++;
								} else if (((points[k].x == points[j].x) && (points[k].y == points[j].y))) {
									maxPoints[i][j]++;
								} else if ((points[i].x - points[j].x)
										* (points[k].y - points[j].y) == (points[i].y - points[j].y)
										* (points[k].x - points[j].x)) {
									maxPoints[i][j]++;

								}
							}
						}
				}
			}
			for (int m = 0; m < points.length; m++) {
				for (int n = 0; n < points.length; n++) {
					if (maxPoints[m][n] > max)
						// System.out.print("maxPoints[" + m + "][" + n +"]:" +
						// maxPoints[m][n] + "\t");
						max = maxPoints[m][n];
				}
			}
		}
		return max;
	}

	public static void main(String args[]) {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(2, 2);
		Point p4 = new Point(2, 2);
		Point p5 = new Point(3, 3);
		Point p6 = new Point(0, 0);
		Point p7 = new Point(0, 0);
		Point p8 = new Point(0, 4);
		Point[] points = new Point[] { p1, p2, p3, p4, p5, p6, p7, p8 };
		System.out.println(maxPoints(points));
	}

}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
