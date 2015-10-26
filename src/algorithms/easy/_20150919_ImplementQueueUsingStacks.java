package algorithms.easy;

import java.util.Stack;

/**
 * This is also an easy one, but I got it accepted with some hint from discuss.
 * Esp. the part that it gives this class a private field of type Stack, then
 * pass it into this class constructor. Pretty nice design. I really need to keep
 * it in mind.
 */
public class _20150919_ImplementQueueUsingStacks {
	
	private Stack<Integer> stack;
	
	public _20150919_ImplementQueueUsingStacks() {
		this.stack = new Stack<>();
	}
	
	 // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	Stack<Integer> tempStack = new Stack<>();
    	moveStack(stack, tempStack);
    	tempStack.pop();
    	moveStack(tempStack, stack);
    }

    // Get the front element.
    public int peek() {
    	Stack<Integer> tempStack = new Stack<>();
    	moveStack(stack, tempStack);
    	int result = tempStack.peek();
    	moveStack(tempStack, stack);
    	return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	return stack.isEmpty();
    }
	
	private void moveStack(Stack<Integer> fromStack, Stack<Integer> toStack) {
		int size = fromStack.size();
		for(int i = 0; i < size; i++){
			int value = fromStack.pop();
			toStack.push(value);
		}
	}

	public static void main(String... args){
		_20150919_ImplementQueueUsingStacks test = new _20150919_ImplementQueueUsingStacks();
		System.out.println();
	}
}
