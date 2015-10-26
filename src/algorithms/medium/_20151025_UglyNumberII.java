package algorithms.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class _20151025_UglyNumberII {
	/**This is the closest I could get, but Leetcode showed me time limit exceeded.*/
	public int nthUglyNumber(int n) {
		int counter = 0, i = 0;
		for(; counter < n; i++){
			if(isUglyNumber(i)){
				counter++;
			}
		}
		return i-1; 
	}
	
	private boolean isUglyNumber(int i) {
		if(i <= 0) return false;
		if(i == 1) return true;
		if(i%2 == 0) return isUglyNumber(i/2);
		if(i%3 == 0) return isUglyNumber(i/3);
		if(i%5 == 0) return isUglyNumber(i/5);
		return false;
	}
	
	/**Instead, I copied this solution from discuss:*/
	public int nthUglyNumberII(int n){
		if(n == 1) return 1;
		Queue<Long> q = new PriorityQueue<Long>();
		q.add(1l);
		for(long i = 1; i<n; i++){
			long tmp = q.poll();
			while(!q.isEmpty() && q.peek() == tmp) tmp = q.poll();
			
			q.add(tmp*2);
			q.add(tmp*3);
			q.add(tmp*5);
		}
		return q.poll().intValue();
	}

	public static void main(String...strings){
		_20151025_UglyNumberII test = new _20151025_UglyNumberII();
		System.out.println(test.nthUglyNumber(10) + "\nEnds.");
	}
}
