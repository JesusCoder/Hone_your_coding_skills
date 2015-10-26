package algorithms.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Copied from discuss, very smart and easy.
 */
public class _20150919_ImplementStackUsingQueues {
	private Queue<Integer> queue;
	
	public _20150919_ImplementStackUsingQueues(){
		this.queue = new ArrayDeque<Integer>(); 
	}
	
	// Push element x onto stack.
    public void push(int x) {
		/**
		 * Copied from discuss! We use a tempQueue here to push the int x to the
		 * first of this queue, then get all the elements out from the original
		 * queue into this tempQueue, then assign this tempQueue to the original
		 * queue. Good design!
		 */
        Queue<Integer> tempQueue = new ArrayDeque<>();
        tempQueue.add(x);
        int len = queue.size();
        for(int i = 0; i < len; i++){
        	tempQueue.add(queue.element());
        	queue.poll();
        }
        queue = tempQueue;
    }

	// Removes the element on top of the stack.
    public void pop() {
    	queue.remove();
    }

    // Get the top element.
    public int top() {
    	return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	return queue == null ? true : queue.isEmpty();
    }

    public static void main(String... args){
    	_20150919_ImplementStackUsingQueues test = new _20150919_ImplementStackUsingQueues();
		Queue<Integer> testQ = new ArrayDeque<>();
		testQ.add(0);
		testQ.add(1);
		testQ.add(2);
		testQ.add(3);
		testQ.add(4);
		testQ.add(5);
		test.queue = testQ;
		test.push(12);
    	System.out.println();
	}
}
