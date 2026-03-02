package stack;

class Stack1 {

    int[] arr =new int[3];
    int top=-1;

    void push(int obj) {
        if(top==arr.length-1){
            System.out.println("Stack full");
            return;
        }
        arr[++top]=obj;
        System.out.println("Pushed: " + obj);
    }
    int pop() {
        if(top==-1){
            System.out.println("Stack Empty");
            return 0;
        }
        int obj = arr[top--];
        System.out.println("Popped: " + obj);
        return obj;
    }

    int top(){
        return arr[top];
    }

    int size() {
        return top+1;
    }
}

public class StackUsingArray {


    public static void main(String[] args) {

        Stack1 s = new Stack1();
        s.push(6);
        s.push(3);
        s.push(7);
        s.pop();
        System.out.println("Size of the stack.stack after deleting an element " + s.size());
        System.out.println("Top of the stack.stack after deleting an element " + s.top());
        s.pop();s.pop();
        System.out.println("Size of the stack.stack after deleting an element " + s.size());

    }
}

