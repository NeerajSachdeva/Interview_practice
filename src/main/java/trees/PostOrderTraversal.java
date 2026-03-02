package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//LEFT-RIGHT-ROOT

//Time Complexity: O(N)
//Space Complexity: O(H)       (H -> Height of the Tree)
public class PostOrderTraversal {
    static ArrayList<Integer> postTraversal(Node curr) {
        if (curr == null) {
            return null;
        }
        ArrayList<Integer> postOrder = new ArrayList<>();
        postTraversal(curr,postOrder);
        return postOrder;
    }

    private static void postTraversal(Node curr, List<Integer> result) {
        if (curr == null)
            return;
        postTraversal(curr.left,result);
        postTraversal(curr.right,result);
        result.add(curr.data);
    }

    public static void main(String args[]) {

        //        1
        //    2       3
        // 4    5   6    7
        //     8       9   10

        //OUTPUT: 4 8 5 2 6 9 10 7 3 1

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

        ArrayList<Integer> inOrder = postTraversal(root);

        System.out.println("The inOrder Traversal is : ");
        for (int i = 0; i < inOrder.size(); i++) {
            System.out.print(inOrder.get(i) + " ");
        }


        System.out.println("\n\nThe inOrder Traversal is : " + postTraversal(null));
    }
}
