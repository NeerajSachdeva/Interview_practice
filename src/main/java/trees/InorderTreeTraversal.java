package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//LEFT-ROOT-RIGHT

//Time Complexity: O(N)
//Space Complexity: O(H)       (H -> Height of the Tree)
public class InorderTreeTraversal {

    //Approach1
    static ArrayList<Integer> inOrderTraversalRecusion(Node curr) {
        if (curr == null) {
            return null;
        }
        ArrayList<Integer> postOrder = new ArrayList<>();
        inOrderTraversal(curr,postOrder);
        return postOrder;
    }

    private static void inOrderTraversal(Node curr, List<Integer> result) {
        if (curr == null)
            return;
        inOrderTraversal(curr.left,result);
        result.add(curr.data);
        inOrderTraversal(curr.right,result);
    }


    //Approach2
    static ArrayList<Integer> inOrderTraversal(Node curr) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        while (true) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                if (s.isEmpty()) break;
                curr = s.peek();
                inOrder.add(s.pop().data);
                curr = curr.right;
            }
        }
        return inOrder;
    }

    public static void main(String args[]) {

        //        1
        //    2       3
        // 4    5   6    7
        //     8       9   10

        //OUTPUT: 4 2 8 5 1 6 3 9 7 10

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        System.out.println("The inOrder Traversal is : " + inOrderTraversal(root));

        System.out.println("The inOrder Traversal using recursion is : " + inOrderTraversalRecusion(root));
//
//        Stack s = new Stack();
//
//        long a = 4587779242    % 7237710;
//        System.out.println( +"");
    }
}
