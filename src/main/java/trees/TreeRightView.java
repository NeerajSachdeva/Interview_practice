package trees;

import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(N)
//Space Complexity: O(H)       (H -> Height of the Tree)
public class TreeRightView {

    static List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    static void rightView(Node curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }

        if (currDepth == result.size()) {
            result.add(curr.data);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    public static void main(String args[]) {

        //        1
        //    2       3
        // 4    5   6    7
        //     8       9   10

        //OUTPUT: [1, 3, 7, 10]

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

        System.out.println("Right Side View : " + rightSideView(root));

    }
}

