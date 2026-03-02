package stack;

import java.util.Stack;

class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {}

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!input.empty()) {
            output.push(input.pop());
        }
        // Insert the desired element in the stack.stack input
        System.out.println("Pushed: " + x);
        input.push(x);
        // Pop out elements from the stack.stack output and push them into the stack.stack input
        while (!output.empty()) {
            input.push(output.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // shift input to output
        if (input.empty()) {
            System.out.println("Stack is empty");

        }
//        int val = input.peek();
       return  input.pop();
//        return val;

    }

    /**
     * Get the front element.
     */
    public int peek() {
        // shift input to output
        if (input.empty()) {
            System.out.println("Stack is empty");

        }
        return input.peek();
    }


    int size() {
        return input.size();
    }
}

public class QueueUsingStack {
    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("Popped: " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());

    }
}
