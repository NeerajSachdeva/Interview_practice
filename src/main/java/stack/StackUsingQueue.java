package stack;

import java.util.LinkedList;
import java.util.Queue;

//(remove here)start	4 3 2 end (add here)
//        add 1
//        4 3 2 1
//        3 2 1 4
//        2 1 4 3
//        1 4 2 3

//Stack is like desi nalka
//to implement stack.stack using queue, socho jab bi new element aad ho to pehle se pade jitne bi ho unhe 1 1 karke nikal ke wapas peeche se baari baari add karte jaana hai

class stack {
    Queue< Integer > q = new LinkedList< >();
    void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }
    int pop() {
        return q.remove();
    }
    int top() {
        return q.peek();
    }
    int size() {
        return q.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("stack.stack{");
        sb.append("q=").append(q);
        sb.append('}');
        return sb.toString();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        stack s = new stack();
        s.push(3);
        System.out.println("S: " + s);
        s.push(2);
        System.out.println("S: " + s);
        s.push(4);
        System.out.println("S: " + s);
        s.push(1);
        System.out.println("S: " + s);
//        System.out.println("Top of the stack.stack: " + s.top());
        System.out.println("Size of the stack.stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
//        System.out.println("Top of the stack.stack after removing element: " + s.top());
//        System.out.println("Size of the stack.stack after removing element: " + s.size());
    }
}
