package stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
 */
public class SortStackUsingTempStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("input:" + stack);
        Stack<Integer> result = sortStack(stack);
        System.out.println("output:" + result);
    }

    private static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> result = new Stack<>();

        while (!input.isEmpty()) {
            Integer topElement = input.pop();

            while (!result.isEmpty() && result.peek()>topElement) {
                    input.push(result.pop());
            }
            result.push(topElement);
        }
        return result;
    }
}
