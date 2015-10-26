/**
 * 
 */
package algorithms.easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/** The count-and-say sequence is the sequence of integers beginning as follows:

 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string. */

/** Very excited! I made it accepted on Leetcode at the very first time, although it took
 * me five hours to debug in Eclipse, but I came up with the algorithm, implemented it and single-step
 * debugging it, eventually it got accepted. Very excited! */

/** This is my first time to use Queue, this is actually an interface in Java, it must use a class
 * in order to instantiate an object that implements the Queue interface, in this case, I chose
 * LinkedList this class to implement Queue. */

/** My algorithm: use two LinkedLists (two queues) with FIFO property, one called workingQ, is used
 * to indicate the current string that we're working on, the other one called storeQ, is used to
 * store the next element that get generated based on the current string. */

public class _20150916_CountAndSay_revisit {
	public static String countAndSay(int n) {
		String res = "";
		if (n == 0) {
			return res;
		} else if (n == 1) {
			return "1";
		}

		Queue<String> workingQ = new LinkedList<String>();
		workingQ.add("1");// this is the initial condition to start with

		Queue<String> storeQ = new LinkedList<String>();

		int counter = 1;// this is a counter to indicate if we've reached the
						// given "n"
		while (counter < n) {
			/*
			 * exchange the workingQ with storeQ before they begin a new trip in
			 * this while loop, because by the end of this while loop, all
			 * elements in the workingQ will be .poll() out and the workingQ
			 * will be empty, so we exchange them here while keeping what their
			 * names mean accord to what they actually do.
			 */
			if (workingQ.size() < storeQ.size()) {
				Queue<String> tempQ = new LinkedList<String>();
				tempQ = workingQ;
				workingQ = storeQ;
				storeQ = tempQ;
			}
			System.out.println("workingQ.size() = " + workingQ.size()
					+ "\tstoreQ.size() = " + storeQ.size());
			int count = 0;// this counter is used to traverse all the characters
							// of the current string
			int tempSize = workingQ.size();
			/*
			 * you must use this tempSize variable to store workingQ.size(),
			 * because by the end of the while loop, the workingQ will be empty,
			 * thus the value of workingQ.size() will be changed, this way, you
			 * can keep the actual value of workingQ.size().
			 */
			while (count < tempSize) {
				int subCounter = 1;// this counter is used to indicate the # of
									// each element when reading
				String val = workingQ.poll();
				/*
				 * poll means to get the value of the next element and get rid
				 * of it in the queue
				 */
				System.out.println("val = " + val + "\tworkingQ.peek() = "
						+ workingQ.peek());
				if (val == null) {
					break;
				}
				if (val.equals(workingQ.peek())) {
					while (val.equals(workingQ.peek())) {
						workingQ.remove();// queue has FIFO property, so it
											// removes the head element
						subCounter++;
						count++;
					}
					storeQ.add(Integer.toString(subCounter));
					storeQ.add(val);
					System.out.println("subCounter = " + subCounter
							+ "\tval = " + val + "\tcount = " + count);
				} else {
					storeQ.add(Integer.toString(subCounter));
					storeQ.add(val);
					count++;
					System.out.println("subCounter = " + subCounter
							+ "\tval = " + val + "\tcount = " + count);
				}
			}
			counter++;
			System.out.println("counter = " + counter);
		}
		Iterator iter = storeQ.iterator();
		while (iter.hasNext()) {
			res += storeQ.poll();
		}
		return res;
	}

	public static void main(String args[]) {
		System.out.println(countAndSay(7));
		System.out.print("Program ended.");
	}
}
