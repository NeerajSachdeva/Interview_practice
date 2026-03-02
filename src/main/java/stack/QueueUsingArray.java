package stack;

class Queue1 {

    private int arr[];
    private int start, end, currSize;

    public Queue1() {
        this(16);
    }

    public Queue1(int maxSize) {
        arr = new int[maxSize];
        start = -1;
        end = -1;
        currSize = 0;
    }
    public void put(int newElement) {
        if (currSize == arr.length) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }
        if (end == -1) {
            start = 0;
            end = 0;
        } else
            end = (end + 1) % arr.length;

        arr[end] = newElement;
        System.out.println("The element pushed is " + newElement);
        currSize++;
    }
    public int take() {
        if (start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int popped = arr[start];
        if (currSize == 1) {
            start = -1;
            end = -1;
        } else
            start = (start + 1) % arr.length;
        currSize--;
        return popped;
    }
    
    public int top() {
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }
    public int size() {
        return currSize;
    }

}

public class QueueUsingArray {
    public static void main(String args[]) {
        Queue1 q = new Queue1(6);
        q.put(4);
        q.put(14);
        q.put(24);
        q.put(34);
        q.put(35);
        q.put(36);
//        q.push(37);

        System.out.println("The peek of the queue before deleting any element " + q.top());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.take());
        System.out.println("The peek of the queue after deleting an element " + q.top());
        System.out.println("The size of the queue after deleting an element " + q.size());
        System.out.println("The first element to be deleted " + q.take());
        System.out.println("The first element to be deleted " + q.take());
        System.out.println("The first element to be deleted " + q.take());
        System.out.println("The first element to be deleted " + q.take());
        System.out.println("The first element to be deleted " + q.take());
        q.put(37);
        System.out.println("The first element to be deleted " + q.take());
        q.put(38);
        System.out.println("The first element to be deleted " + q.take());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.take());
    }
}
