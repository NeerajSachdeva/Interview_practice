package trees;

import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(N)
//Space Complexity: O(H)       (H -> Height of the Tree)
public class TreeLeftView {

    static List<Integer> lightSideView(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        leftView(root, result, 0);
        return result;
    }

    static void leftView(Node curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.data);
        }

        leftView(curr.left, result, currDepth + 1);
        leftView(curr.right, result, currDepth + 1);
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

        System.out.println("Left View of Tree is : " + lightSideView(root));

    }
}

