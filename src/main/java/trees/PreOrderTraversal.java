package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//ROOT-LEFT-RIGHT

//Time Complexity: O(N)
//Space Complexity: O(H)       (H -> Height of the Tree)
public class PreOrderTraversal {

    static ArrayList<Integer> preTraversalRecursion(Node curr) {
        if (curr == null) {
            return null;
        }
        ArrayList<Integer> preOrder = new ArrayList<>();
        preTraversal(curr,preOrder);
        return preOrder;
    }

    private static void preTraversal(Node curr, List<Integer> result) {
        if (curr == null)
            return;
        result.add(curr.data);
        preTraversal(curr.left,result);
        preTraversal(curr.right,result);
    }


    //Approach2
    static ArrayList<Integer> preTraversal(Node curr) {
        if (curr == null) {
            return null;
        }
        ArrayList<Integer> preOrder = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(curr);
        while (!s.isEmpty()) {
            Node root = s.peek();
            preOrder.add(s.pop().data);

            if(root.right!=null){
                s.push(root.right);
            }

            if(root.left!=null){
                s.push(root.left);
            }
        }
        return preOrder;
    }

    public static void main(String args[]) {

        //        1
        //    2       3
        // 4    5   6    7
        //     8       9   10

        //OUTPUT: 1 2 4 5 8 3 6 7 9 10

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

        System.out.println("Approach1 inOrder Traversal is : "+ preTraversalRecursion(root));

        System.out.println("Approach2 The inOrder Traversal is : " + preTraversal(root));

    }
}
