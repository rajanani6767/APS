import java.util.Stack;

class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // Push element x to the back of queue
    public void push(int x) {
        stackIn.push(x);
    }

    // Removes the element from the front of queue and returns it
    public int pop() {
        shiftStacks();
        return stackOut.pop();
    }

    // Get the front element
    public int peek() {
        shiftStacks();
        return stackOut.peek();
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // Helper method to move elements from stackIn to stackOut if needed
    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}